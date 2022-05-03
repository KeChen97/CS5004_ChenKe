import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *  <Purpose of the file>
 * Author : KK 4/29/2022
 * Source code: Snake Game Starter https://northeastern.instructure.com/courses/103018/files/14752164?wrap=1
 * This is for demonstrating this snake game.
 *
 * The snake game rules:
 * 1. User can choose different difficulty mode : easy or hard.
 *    Snakes will move faster in hard mode.
 * 2. User can choose number of players : one or two.
 *    One player's goal is eating more apples (head touches apple) and get more scores. Two players need to compete for the apple.
 * 3. Game will be over if the snake's head touches its body.
 * 4. The snake will lose the game if it hits another snake.
 *
 */
public class SnakeGame {
  public static JPanel panel;
  public static JFrame frame;
  public static JFrame optionFrame;
  public static final int frameWidth = 700;  // width of the frame container
  public static final int frameHeight = 800; // height of the frame container
  public static final int panelWidth = 700;  // 600 + panelframe * 2
  public static final int panelHeight = 700; // 600 + panelframe * 2
  public static final int panelFrame = 50; // the dark pink frame of the panel view

  public static void main(String[] args) {
    optionFrame = new SnakeGameControllerWindow();
  }
}

