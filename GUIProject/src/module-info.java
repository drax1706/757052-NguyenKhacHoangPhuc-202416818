module GUIProject {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    // Cho FXMLLoader truy cập vào controller
    opens hust.soict.dsai.javafx to javafx.fxml;

    // Cho module javafx.graphics tạo instance Painter
    exports hust.soict.dsai.javafx;
}
