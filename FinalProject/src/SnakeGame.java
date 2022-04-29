import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main function to run Snake Game
 */
public class SnakeGame {
  public static boolean ifStart = false;
  public static JPanel panel;
  public static JFrame frame;
  public static JFrame optionFrame;
  public static final int frameWidth = 700;
  public static final int frameHeight = 800;
  public static final int panelWidth = 700;  // 600 + panelframe * 2
  public static final int panelHeight = 700; // 600 + panelframe * 2
  public static final int panelFrame = 50;

  public static void main(String[] args) {
    optionFrame = new OptionFrame();
  }
}

class StartAction implements ActionListener {

  public void actionPerformed(final ActionEvent e) {
    System.out.println("The game begins!");
    SnakeGame.frame = new JFrame();
    SnakeGame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SnakeGame.frame.setSize(SnakeGame.frameWidth,SnakeGame.frameHeight);
    SnakeGame.panel = new MyPanel();
    SnakeGame.panel.setPreferredSize(new Dimension(SnakeGame.panelWidth, SnakeGame.panelHeight));
    SnakeGame.frame.add(SnakeGame.panel);
    SnakeGame.frame.setTitle("Snake Game by kk");

    SnakeGame.frame.setVisible(true);
    SnakeGame.optionFrame.setVisible(false);
  }
}
