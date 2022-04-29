import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener, KeyListener {

  /**
   * Set up the panel, set the source of apple and snake images, and initialize the location of apple and snake
   */
  public MyPanel() {
    // make the panel focusable so that it can react to keyboard inputs
    this.setFocusable(true);

    // Load the image from the internet
    try {
      background = ImageIO.read(new File("/Users/chen/Downloads/backg5.png"));
      title =  ImageIO.read(new File("/Users/chen/Downloads/title.png"));
      apple_image = ImageIO.read(new File("/Users/chen/Downloads/heart.png"));
      snake_head_image = ImageIO.read(new File("/Users/chen/Downloads/snakehead.png"));
      snake_body_image = ImageIO.read(new File("/Users/chen/Downloads/snakebody.png"));
      snake2_head_image = ImageIO.read(new File("/Users/chen/Downloads/snakehead22.png"));
      snake2_body_image = ImageIO.read(new File("/Users/chen/Downloads/snakebody2.png"));
    } catch (Exception e) {
      System.out.println("url doesn't work");
    }

    // add the label of scores to this panel
    label_score1.setLocation(150,30);
    this.add(label_score1);
    this.add(label_score2);

    rnd = new Random();
    // Init the location of the apple
    apple_loc = new Coordinate(200, 200);
    // Init the location of the snake.
    // It starts with head only
    // The list head is the snake head.
    // Assume the radius of each dot is 25.

    //Initialize snake1
    snake_loc = new ArrayList<>();
    snake_loc.add(new Coordinate(400, 400));
    snake_loc.add(new Coordinate(400 + dot_size, 400));
    snake_loc.add(new Coordinate(400 + 2 * dot_size, 400));

    //Initialize snake2
    snake2_loc = new ArrayList<>();
    snake2_loc.add(new Coordinate(300, 300));
    snake2_loc.add(new Coordinate(300 + dot_size, 300));
    snake2_loc.add(new Coordinate(300 + 2 * dot_size, 300));

    // initialize direction: snake1 to right, snake2 to left
    direction1 = Direction.RIGHT;
    direction2 = Direction.LEFT;

    // set up the alarm, which fires periodically (16 ms == 60fps).
    // the time period depends on the difficulty level
    // Every time it fires, we update the snake's location and repaint it.
    if(difficulty == 1) {
      timer = new Timer(timerEasy, this);
    }
    else if(difficulty == 2) {
      timer = new Timer(timerHard, this);
    }
    else{
      throw new IllegalStateException("Please choose difficulty level");
    }
    timer.start();

    // register this panel as the keyboard event listener.
    this.addKeyListener(this);
  }

  /**
   * Paint components, apple and snakes in this function based on their real-time locations
   * @param g a Graphics object
   */
  @Override
  protected void paintComponent(Graphics g) {
   // System.out.println("repainting");
    super.paintComponent(g);

    g.drawImage(title,0,0,this);
    // paint the background
    int x = (this.getWidth() - background.getWidth(null)) / 2;
    int y = (this.getHeight() - background.getHeight(null)) /2;
    g.drawImage(background, 0, title.getHeight(null) , this);

    // paint the apple
    g.drawImage(apple_image, apple_loc.x, apple_loc.y, this);

    // paint snake1
    // paint the snake head
    g.drawImage(snake_head_image, snake_loc.get(0).x, snake_loc.get(0).y, this);
    // paint the snake body
    for (int i = 1; i < snake_loc.size(); i++) {
      g.drawImage(snake_body_image, snake_loc.get(i).x, snake_loc.get(i).y, this);
    }
    // paint snake2
    // paint the snake head
    //g.drawImage(snake2_head_image, (snake2_loc.get(0).x) < 0 ? (snake2_loc.get(0).x + 600) : (snake2_loc.get(0).x % 600),
    //    (snake2_loc.get(0).x) < 0 ? (snake2_loc.get(0).x + 600) : (snake2_loc.get(0).x % 600), this);
    g.drawImage(snake2_head_image, snake2_loc.get(0).x, snake2_loc.get(0).y, this);
    // paint the snake body
    for (int i = 1; i < snake2_loc.size(); i++) {
     // g.drawImage(snake2_body_image, (snake2_loc.get(i).x) < 0 ? (snake2_loc.get(i).x + 600) : (snake2_loc.get(i).x % 600),
       //   (snake2_loc.get(i).x) < 0 ? (snake2_loc.get(i).x + 600) : (snake2_loc.get(i).x % 600), this);
      g.drawImage(snake2_body_image, snake2_loc.get(i).x, snake2_loc.get(i).y, this);
    }
  }

  /**
   * This function decides how the snake move
   * @param snake_move A list of snake body dots location
   * @param player 1 represents player1, 2 represents player2
   */
  public void snakeMove(List<Coordinate> snake_move, int player){
    // We update the snake's location.
    // Make it look like the snake is moving forward
    // Trick: move the tail to become the new head,
    // and keep other nodes the same

    // 1. chop off the tail
    Coordinate old_tail;
    if(snake_move.size()==1) {
      old_tail = snake_move.get(0);
    }
    else {
      old_tail = snake_move.remove(snake_move.size() - 1);
    }
    // 2. get the loc of the old head
    int old_head_x = snake_move.get(0).x;
    int old_head_y = snake_move.get(0).y;
    // 3. add a new head. The loc of the new head
    // depends on the direction of movement
    int new_head_x = old_head_x;
    int new_head_y = old_head_y;

    // snake1 moves according to direction1, snake2 moves according to direction2
    Direction direction;
    if (player == 1) {
      direction = direction1;
    } else {
      direction = direction2;
    }

    if (direction == Direction.UP) {
      // up
      new_head_y -= dot_size;
      // if the snake touch the boundary, it will appear on the other side
      if(new_head_y < title.getHeight(null) + SnakeGame.panelFrame) {
        new_head_y = title.getHeight(null) + SnakeGame.panelHeight - SnakeGame.panelFrame - dot_size ;
      }
    } else if (direction == Direction.DOWN) {
      // down
      new_head_y += dot_size;
      // if the snake touch the boundary, it will appear on the other side
      if(new_head_y > title.getHeight(null) + SnakeGame.panelHeight - SnakeGame.panelFrame - dot_size) {
        new_head_y = title.getHeight(null) + SnakeGame.panelFrame;
      }
    } else if (direction == Direction.LEFT) {
      // left
      new_head_x -= dot_size;
      // if the snake touch the boundary, it will appear on the other side
      if(new_head_x < SnakeGame.panelFrame) {
        new_head_x = SnakeGame.panelWidth - SnakeGame.panelFrame - dot_size ;
      }
    } else if (direction == Direction.RIGHT) {
      // right
      new_head_x += dot_size;
      // if the snake touch the boundary, it will appear on the other side
      if(new_head_x >= SnakeGame.panelWidth - SnakeGame.panelFrame) {
        new_head_x = SnakeGame.panelFrame;
      }
    }

    snake_move.add(0, new Coordinate(new_head_x, new_head_y));
    System.out.println("Snake " + player + "Head Location: " + new_head_x + " " + new_head_y);

    // the aggressive snake will lose the game
//    for(int i = 1; i< snake_other.size(); i++){
//      if(snake_move.get(0).equals(snake_other.get(i))){
//        // TODO:
//        String gameover = "Game Over!\n";
//       if(player == 1) {
//         gameover = gameover + "Player 1 hits player 2. Player 1 loses!";
//       }
//       else{
//         gameover = gameover + "Player 2 hits player 1. Player 2 loses!";
//        }
//        JOptionPane.showMessageDialog(null,gameover);
//      }
//    }

    // check whether the head overlaps with the apple
    if (snake_move.get(0).equals(apple_loc)) {
      // eating the apple.
      // Increase size by 1.
      // Added the removed tail back.
      snake_move.add(old_tail);
      // increase score by 1
      if (player == 1) {
        score1++;
        label_score1.setText("Player1 Scores: " + score1);
      } else {
        score2++;
        label_score2.setText("Player2 Scores: " + score2);
      }
      // also need to regenerate the apple's location
      regenApple();
    }
  }

  /**
   * This function control the operation of snake and apple
   * @param e an ActionEvent object, processing individual mouse movements and mouse clicks
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //System.out.println("alarm fired");
    // We reach here every time the alarm fires.

    snakeMove(snake_loc, 1);
    snakeMove(snake2_loc, 2);

    // Call repaint, which further invokes `paintComponent`.
    repaint();
  }

  /**
   * This function regenerate a random location for the apple in panel range
   */
  private void regenApple() {
    // Random location within the panel.
    int new_x = rnd.nextInt(SnakeGame.panelFrame,SnakeGame.panelWidth - SnakeGame.panelFrame );
    int new_y = rnd.nextInt(SnakeGame.panelFrame + title.getHeight(null) , title.getHeight(null) + SnakeGame.panelHeight - SnakeGame.panelFrame);
    // Round the location to dot_size.
    apple_loc = new Coordinate((new_x / dot_size) * dot_size, (new_y / dot_size) * dot_size);
    System.out.println("Apple Location: " + (new_x / dot_size) * dot_size + " " + (new_y / dot_size) * dot_size);
  }

  /**
   * keyTyped is fired when a key is pressed that can be converted into a unicode character.
   * The basic idea is that keyTyped is used to find characters that are typed.
   * For this game, we don't need any keycode except up/down/left/right to control the snake, so that it will do nothing if receive keyTyped
   * @param e  a KeyEvent object
   */
  @Override
  public void keyTyped(KeyEvent e) {
    // do nothing
  }

  /**
   * This function read the keyboard action, it is used for obtain raw key presses.
   * For this game, the direction will change based on when which key (up/down/left/right) is received from the keyboard,
   * @param e a KeyEvent object
   */
  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP) {
      // up key is pressed
      direction1 = Direction.UP;
    } else if (keyCode == KeyEvent.VK_DOWN) {
      // down
      direction1 = Direction.DOWN;
    } else if (keyCode == KeyEvent.VK_LEFT) {
      // left
      direction1 = Direction.LEFT;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      // right
      direction1 = Direction.RIGHT;
    }

    if (keyCode == KeyEvent.VK_W) {
      // W key is pressed - UP
      direction2 = Direction.UP;
    } else if (keyCode == KeyEvent.VK_S) {
      // S - down
      direction2 = Direction.DOWN;
    } else if (keyCode == KeyEvent.VK_A) {
      // A - left
      direction2 = Direction.LEFT;
    } else if (keyCode == KeyEvent.VK_D) {
      // D - right
      direction2 = Direction.RIGHT;
    }
  }

  /**
   * This function released the keyboard
   * For this game, do nothing if keyboard is released.
   * @param e a KeyEvent object
   */
  @Override
  public void keyReleased(KeyEvent e) {
    // do nothing
  }

  private Coordinate apple_loc;
  private int dot_size = 25;
  private Image apple_image;
  private Image background;
  private Image title;
  private Image snake_head_image;
  private Image snake_body_image;
  private Image snake2_head_image;
  private Image snake2_body_image;
  private int score1 = 0;
  JLabel label_score1 = new JLabel("Player1 Scores: " + score1);
  private int score2 = 0;
  JLabel label_score2 = new JLabel("Player2 Scores: " + score2);
  private Direction direction1;
  private Direction direction2;
  private Random rnd;
  List<Coordinate> snake_loc;
  List<Coordinate> snake2_loc;
  private Timer timer;
  public static int difficulty;
  public static int playerNumber;
  public static int timerEasy = 400;   // if it's easy mode, timer is 300 ms
  public static int timerHard = 150;   // if it's hard mode, timer is 150 ms
}
