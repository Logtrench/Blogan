import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {


  // the submitting toggle variable and username testfield object
  public static boolean sub = false;
  public static JTextField user = new JTextField(50);

  // The frame to be used by ALL panels
  public static JFrame mainFrame = new JFrame();

  // All panels that need to be setVisible(false) by button actions.
  static JPanel ChoicePanel = new JPanel();
  static JPanel WorkoutPanel = new JPanel();

  // this is the colour palet
  //colour names reflect purpose
  static Color Background = new Color(153, 221, 204);
  static Color Button = new Color(81, 92, 89);

  // Panel Creator method, returns the panel
  public static JPanel panel(JFrame frame, int x, int y) {
    JPanel panel = new JPanel();
    frame.setSize(x, y);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(panel);
    return panel;
  }

  // Label creator method, adds to a panel
  public static void labl(JPanel panel, String message) {
    JLabel label = new JLabel(message, SwingConstants.CENTER);
    panel.add(label);
  }

  public static void labl(JPanel panel, String message, int size) {
    JLabel label = new JLabel(message, SwingConstants.CENTER);
    Font Robo = new Font("Roboto", Font.BOLD, size);
    label.setFont(Robo);
    panel.add(label);
  }

  // Label creator method, adds to a panel
  public static JTextField text(JPanel panel, String message) {
    JTextField text = new JTextField(message, 12);
    panel.add(text);

    return text;
  }

  // Image creator method, adds to a panel
  public static void image(JPanel panel, ImageIcon icon) {
    JLabel label = new JLabel(icon);
    panel.add(label);
  }

  // Buton creator method , returns button
  public static JButton butt(JPanel panel, String message, Color back, Color fore) {
    JButton button = new JButton(message);
    panel.add(button);
    button.addActionListener(new GUI());
    button.setBackground(back);
    button.setForeground(fore);
    return button;
  }

  // how the program deals with inputs from buttons
  @Override
  public void actionPerformed(ActionEvent e) {

    // Takes button input and sets it to String
    // This will find the name of the button
    String buttonName = e.getActionCommand();

    // checking the button name and implementing actions
    // in switch case
    switch (e.getActionCommand()) {
      // exit button will simply exit system
      case "Finish":
        WorkoutPanel.setVisible(false);
        System.out.println("i want it that way");
        break;
      case "Generate Workout":
        Main.train.generate();
        System.out.println(Main.train.getWorkout());
        ChoicePanel.setVisible(false);
        //Main.slide = 2;
        Main.start();
        ChoicePanel.setVisible(true);
        break;
    }
  }
    public static void exercise(){
          // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    WorkoutPanel = panel(mainFrame, 300, 300);
    WorkoutPanel.setLayout(OneByOne);
    WorkoutPanel.setBackground(Background);

    // story development!
    labl(WorkoutPanel, Main.train.getWorkout());

    // creation and settin of Finish button
    JButton next = new JButton();
    next = butt(WorkoutPanel, "Finish", Button, Color.BLACK);
    }
    
    public static void ChooseWorkout() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    ChoicePanel = panel(mainFrame, 300, 300);
    ChoicePanel.setLayout(OneByOne);
    ChoicePanel.setBackground(Background);

    // story development!
    labl(ChoicePanel, "Blogan Wellness");

    // creation and settin of Finish button
    JButton next = new JButton();
    next = butt(ChoicePanel, "Finish", Button, Color.BLACK);
    JButton gen = new JButton();
    gen = butt(ChoicePanel, "Generate Workout", Button, Color.BLACK);
  }
}
