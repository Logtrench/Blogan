import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
  public static int calories = 0;
  public static int vegs = 0;
  public static int fruits = 0;
  public static int grains = 0;
  public static int protein = 0;
  // the submitting toggle variable and username testfield object
  public static boolean sub = false;
  public static JTextField num_calories = new JTextField(15);
  public static JTextField num_vegtables = new JTextField(15);
  public static JTextField num_fruits = new JTextField(15);
  public static JTextField num_protein = new JTextField(15);
  public static JTextField num_grain = new JTextField(15);
  // The frame to be used by ALL panels
  public static JFrame mainFrame = new JFrame();

  // All panels that need to be setVisible(false) by button actions.
  static JPanel ChoicePanel = new JPanel();
  static JPanel WorkoutPanel = new JPanel();
  static JPanel MenuPanel = new JPanel();
  static JPanel MeditationPanel = new JPanel();
  static JPanel HealthStatsPanel = new JPanel();
  static JPanel DietPanel = new JPanel();

  // this is the colour palet
  // colour names reflect purpose
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
        ChoicePanel.setVisible(false);
        System.out.println("Finshing da workout");
        Main.slide = 3;
        Main.start();
        break;
      case "Back":
        WorkoutPanel.setVisible(false);
        ChoicePanel.setVisible(false);
        HealthStatsPanel.setVisible(false);
        MeditationPanel.setVisible(false);
        System.out.println("Goin back to da men");
        Main.slide = 3;
        Main.start();
        break;
      case "Generate Workout":
        Main.train.generate();
        System.out.println(Main.train.getWorkout());
        ChoicePanel.setVisible(false);
        Main.slide = 2;
        Main.start();
        break;
      case "Next Exercise":
        Main.train.generate();
        System.out.println(Main.train.getWorkout());
        WorkoutPanel.setVisible(false);
        Main.slide = 2;
        Main.start();
        break;
      case "Workouts":
        Main.slide = 1;
        MenuPanel.setVisible(false);
        Main.start();
        break;
      case "Health Stats":
        Main.slide = 5;
        MenuPanel.setVisible(false);
        Main.start();
        break;
      case "Meditation":
        Main.slide = 4;
        System.out.println("fart");
        MenuPanel.setVisible(false);
        Main.start();
        break;
      case "Play":
        // Main.slide = 4;
        System.out.println("Playing..");

        // MenuPanel.setVisible(false);
        // Main.start();
        break;
      case "Diet":
        Main.slide = 6;
        MenuPanel.setVisible(false);
        Main.start();
        break;
      case "Done":
        DietPanel.setVisible(false);
        calories = Integer.valueOf(num_calories.getText());
        vegs = Integer.valueOf(num_vegtables.getText());
        fruits = Integer.valueOf(num_fruits.getText());
        grains = Integer.valueOf(num_grain.getText());
        protein = Integer.valueOf(num_protein.getText());
        Main.food.addFood(calories, vegs, fruits, grains, protein);
        Main.slide = 3;
        Main.start();

    }
  }

  public static void exercise() {
    JPanel ButtonPanel = new JPanel();
    JPanel HeaderPanel = new JPanel();
    // creation of grid layout

    GridLayout OneCol = new GridLayout(0, 1, 0, 0);
    GridLayout TwoCol = new GridLayout(0, 2, 0, 0);

    // setting of panel parameters
    HeaderPanel = panel(mainFrame, 300, 400);
    HeaderPanel.setLayout(OneCol);
    HeaderPanel.setBackground(Background);

    WorkoutPanel = panel(mainFrame, 300, 400);
    WorkoutPanel.setLayout(OneCol);
    WorkoutPanel.setBackground(Background);

    ButtonPanel = panel(mainFrame, 300, 400);
    ButtonPanel.setLayout(TwoCol);
    ButtonPanel.setBackground(Background);

    // story development!
    WorkoutPanel.add(HeaderPanel);
    labl(HeaderPanel, Main.train.getWorkout());
    labl(HeaderPanel, "Tips:");
    labl(HeaderPanel, Main.train.getTips());
    // Workout Image
    ImageIcon icon = new ImageIcon(Main.train.getImage());
    image(WorkoutPanel, icon);

    // creation and settin of Finish button
    WorkoutPanel.add(ButtonPanel);
    JButton fin = new JButton();
    fin = butt(ButtonPanel, "Finish", Button, Color.BLACK);
    JButton next = new JButton();
    next = butt(ButtonPanel, "Next Exercise", Button, Color.BLACK);

  }

  public static void ChooseWorkout() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    ChoicePanel = panel(mainFrame, 300, 400);
    ChoicePanel.setLayout(OneByOne);
    ChoicePanel.setBackground(Background);

    // story development!
    labl(ChoicePanel, "Blogan Wellness Workout Generator");

    // creation and settin of Finish button
    JButton gen = new JButton();
    gen = butt(ChoicePanel, "Generate Workout", Button, Color.BLACK);
    JButton next = new JButton();
    next = butt(ChoicePanel, "Back", Button, Color.BLACK);
  }

  public static void Menu() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    MenuPanel = panel(mainFrame, 300, 400);
    MenuPanel.setLayout(OneByOne);
    MenuPanel.setBackground(Background);

    // story development!
    labl(MenuPanel, "Blogan Wellness Programs");

    // creation and settin of Finish button
    JButton work = new JButton();
    work = butt(MenuPanel, "Workouts", Button, Color.BLACK);
    JButton health = new JButton();
    health = butt(MenuPanel, "Health Stats", Button, Color.BLACK);

    JButton diet = new JButton();
    diet = butt(MenuPanel, "Diet", Button, Color.BLACK);

    JButton meditation = new JButton();
    meditation = butt(MenuPanel, "Meditation", Button, Color.BLACK);
  }

  public static void Meditation() {
    Main.mind.meditate();
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    MeditationPanel = panel(mainFrame, 300, 400);
    MeditationPanel.setLayout(OneByOne);
    MeditationPanel.setBackground(Background);

    // story development!
    labl(MeditationPanel, "Meditate");
    // creation and settin of Finish button
    JButton playy = new JButton();
    playy = butt(MeditationPanel, "Play", Button, Color.BLACK);
    JButton bacc = new JButton();
    bacc = butt(MeditationPanel, "Back", Button, Color.BLACK);
  }

  public static void Health_Stats() {
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    HealthStatsPanel = panel(mainFrame, 300, 400);
    HealthStatsPanel.setLayout(OneByOne);
    HealthStatsPanel.setBackground(Background);

    // story development!
    labl(HealthStatsPanel, "Calories Consummed: " + Main.food.getCalories());
    labl(HealthStatsPanel, "Veggies Consummed: " + Main.food.getVegtables());
    labl(HealthStatsPanel, "Fruits Consummed: " + Main.food.getFruits());
    labl(HealthStatsPanel, "Grains Consummed: " + Main.food.getGrains());
    labl(HealthStatsPanel, "Protein Consummed: " + Main.food.getProtein());
    labl(HealthStatsPanel, "Exercises Completed: " + Main.train.getCounter());
    labl(HealthStatsPanel, "Minutes Meditated: " + Main.mind.getCounter());
    // creation and settin of Finish button
    JButton next = new JButton();
    next = butt(HealthStatsPanel, "Back", Button, Color.BLACK);
  }

  public static void Diet() {
    JPanel ButtonPanel = new JPanel();
    JPanel EntryPanel = new JPanel();
    GridLayout TwoCol = new GridLayout(0, 2, 3, 10);
    GridLayout OneCol = new GridLayout(0, 1, 3, 10);
    // setting of panel parameters

    DietPanel = panel(mainFrame, 300, 400);
    DietPanel.setLayout(OneCol);
    DietPanel.setBackground(Background);

    ButtonPanel = panel(mainFrame, 300, 400);
    ButtonPanel.setLayout(OneCol);
    ButtonPanel.setBackground(Background);

    EntryPanel = panel(mainFrame, 300, 400);
    EntryPanel.setLayout(TwoCol);
    EntryPanel.setBackground(Background);
    // story development!
    labl(DietPanel, "Enter what you ate");
    DietPanel.add(EntryPanel);

    labl(EntryPanel, "Calories : ");
    num_calories = text(EntryPanel, "0");

    labl(EntryPanel, "Veggies : ");
    num_vegtables = text(EntryPanel, "0");

    labl(EntryPanel, "Fruits : ");
    num_fruits = text(EntryPanel, "0");

    labl(EntryPanel, "Grain : ");
    num_grain = text(EntryPanel, "0");

    labl(EntryPanel, "Protein : ");
    num_protein = text(EntryPanel, "0");

    // creation and settin of Finish button
    DietPanel.add(ButtonPanel);
    JButton next = new JButton();
    next = butt(ButtonPanel, "Done", Button, Color.BLACK);

  }
}
