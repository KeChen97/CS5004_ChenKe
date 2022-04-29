import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * This class is for showing a "login window" for this snake game, user can choose different mode in
 * this window The mode user choose will decide how's this game look like: easy (slow) or hard
 * (fast), one player or two player
 */
public class OptionFrame extends JFrame {
  public static JComboBox playerBox;
  public JComboBox difficultyModeBox;
  private JButton start;
  private JButton reset;

  /**
   * The operations need to do for creating this option window
   */
  public OptionFrame() {
    super();
    final BorderLayout borderLayout = new BorderLayout();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(borderLayout);
    setTitle("Snake Game by kk");
    setSize(300, 170); //the size of this window
    setLocation(550, 350);

    final JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
    getContentPane().add(mainPanel); // add this main panel to window

    final JPanel centerPanel = new JPanel();
    final GridLayout gridLayout = new GridLayout(3, 2);
    centerPanel.setLayout(gridLayout);
    mainPanel.add(centerPanel); // add this center panel to main panel

    // two space holders
    JLabel emptyLabel1 = new JLabel();
    centerPanel.add(emptyLabel1);
    JLabel emptyLabel12 = new JLabel();
    centerPanel.add(emptyLabel12);

    // the difficulty mode option box
    final JLabel difficultyModelabel = new JLabel();
    difficultyModelabel.setHorizontalAlignment(SwingConstants.CENTER);
    difficultyModelabel.setPreferredSize(new Dimension(0, 0));
    difficultyModelabel.setMinimumSize(new Dimension(0, 0));
    centerPanel.add(difficultyModelabel);
    difficultyModelabel.setText("Difficulty Mode:");
    difficultyModeBox = new JComboBox();
    difficultyModeBox.addItem("--Options--");
    difficultyModeBox.addItem("Easy");
    difficultyModeBox.addItem("Hard");
    difficultyModeBox.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          System.out.println("Difficulty level is:" + difficultyModeBox.getSelectedItem());
          MyPanel.difficulty = difficultyModeBox.getSelectedIndex();
        }
      }
    });
    centerPanel.add(difficultyModeBox);

		// the number of player option box
    final JLabel playerLabel = new JLabel();
    playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    centerPanel.add(playerLabel);
    playerLabel.setText("Number of Player:");
    playerBox = new JComboBox();
    playerBox.addItem("--Options--");
    playerBox.addItem("One");
    playerBox.addItem("Two");
    playerBox.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          System.out.println("Number of player is:" + playerBox.getSelectedIndex());
          MyPanel.playerNumber = playerBox.getSelectedIndex();
        }
      }
    });
    centerPanel.add(playerBox);

		// add a new panel at the bottom for the two buttons
    final JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    start = new JButton();
		start.addActionListener(new StartAction());
		start.setText("Start");
    bottomPanel.add(start);
//    reset = new JButton();
//    reset.addActionListener(new ResetAction());
//    reset.setText("Reset");
//    bottomPanel.add(reset);

    setVisible(true);
    setResizable(false);
  }

  class ResetAction implements ActionListener {

    public void actionPerformed(final ActionEvent e) {
    }
  }

  class zcAction implements ActionListener {

    public void actionPerformed(final ActionEvent e) {
			/*ComZhuCeFrame aa=new ComZhuCeFrame();
						aa.setVisible(true);*/
      //	desktop.add(new ComZhuCeFrame(),BorderLayout.CENTER);
    }
  }


//  public static void main(String[] args) {
//    new OptionFrame();
//  }
}







