import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main function to run Snake Game
 */
public class SnakeGame {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JPanel panel = new MyPanel();
    panel.setPreferredSize(new Dimension(600, 600));
    frame.add(panel);
    frame.pack();
    // by default, everything is invisible. Make it visible
    frame.setVisible(true);
  }
}