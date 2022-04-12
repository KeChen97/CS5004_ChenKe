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

// Commentary for possible future improvements
// 1. if we use Enum type to present the direction of up down left right, instead of int 1 2 3 4  can be more clear.
// 2. we can add more features like : a. the game will over if the snake eats (touches) its body
//                                    b. the game will over if the snake touches the edge of the panel
//
