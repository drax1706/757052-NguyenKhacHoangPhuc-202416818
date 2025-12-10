package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.ListChangeListener;
import java.util.function.Predicate;
import hust.soict.dsai.aims.exception.PlayerException;



public class CartScreenController {

    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    // >>> Label hiển thị tổng tiền
    @FXML
    private Label lbTotalCost;

    private FilteredList<Media> filteredMedia;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));

        ObservableList<Media> originalList = cart.getItemsOrdered();
        filteredMedia = new FilteredList<>(originalList, media -> true);
        tblMedia.setItems(filteredMedia);

        // >>> tổng tiền ban đầu + lắng nghe thay đổi
        updateTotalCostLabel();
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            updateTotalCostLabel();
        });

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } else {
                        btnPlay.setVisible(false);
                        btnRemove.setVisible(false);
                    }
                });

        tfFilter.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showFilteredMedia(newValue);
                });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
        }
    }

    private void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            filteredMedia.setPredicate(media -> true);
            return;
        }

        String lowerFilter = filterText.toLowerCase();

        Predicate<Media> predicate;
        if (radioBtnFilterId.isSelected()) {
            predicate = media -> {
                String idString = String.valueOf(media.getId()).toLowerCase();
                return idString.contains(lowerFilter);
            };
        } else {
            predicate = media -> {
                String title = media.getTitle();
                return title != null && title.toLowerCase().contains(lowerFilter);
            };
        }

        filteredMedia.setPredicate(predicate);
    }

    @FXML
    private void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media == null) {
            showAlert(AlertType.ERROR, "Error", "Please select a media to play.");
            return;
        }
        if (!(media instanceof Playable)) {
            showAlert(AlertType.ERROR, "Error", "This media is not playable.");
            return;
        }
        try {
            ((Playable) media).play();
        } catch (PlayerException e) {
            System.err.println(e.toString());
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Play error", e.getMessage());
        }
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            showAlert(AlertType.INFORMATION, "Information", "Your cart is empty!");
            return;
        }

        cart.getItemsOrdered().clear();
        updateTotalCostLabel();
        showAlert(AlertType.INFORMATION, "Success", "Order placed successfully!");
    }

    private void updateTotalCostLabel() {
        if (lbTotalCost != null) {
            lbTotalCost.setText(String.format("Total: %.2f $", cart.totalCost()));
        }
    }

    private void showAlert(AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
