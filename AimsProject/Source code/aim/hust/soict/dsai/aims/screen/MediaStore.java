package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.exception.LimitExceededException;
public class MediaStore extends JPanel {

    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> {
            try {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(
                        null,
                        "Added to cart!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (LimitExceededException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Cart full",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
        container.add(btnAddToCart);


        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e ->
                openPlayScreen((Playable) media)
            );
            container.add(btnPlay);
        }

        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(Box.createVerticalGlue());
        add(container);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void openPlayScreen(Playable playable) {
        JFrame frame = new JFrame("Play Media");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(this);
        frame.add(new PlayPanel(media, playable));
        frame.setVisible(true);
    }

    public class PlayPanel extends JPanel {

        public PlayPanel(Media media, Playable playable) {
            setLayout(new BorderLayout());

            JLabel title = new JLabel("Playing: " + media.getTitle(), JLabel.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 20));

            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> {
                try {
                    playable.play();
                } catch (PlayerException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(
                            this,
                            ex.getMessage(),
                            "Play error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            add(title, BorderLayout.CENTER);
            add(btnPlay, BorderLayout.SOUTH);
        }
    }
}
