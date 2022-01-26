
//import all needed files.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
  // the parameters for meditation
  String startTime;
  String endTime;
  static String medit = "Play";
  public static String time = "";
  static boolean invalid = false;
  static String quote = "";

  // the parameters for diet
  public static int fats = 0;
  public static int carbs = 0;
  public static int protein = 0;

  // the submitting toggle variable and username testfield object
  public static boolean sub = false;
  public static JTextField num_fats = new JTextField(15);
  public static JTextField num_carbs = new JTextField(15);
  public static JTextField num_protein = new JTextField(15);

  // The frame to be used by ALL panels
  public static JFrame mainFrame = new JFrame();

  // All panels that need to be setVisible(false) by button actions.
  static JPanel ChoicePanel = new JPanel();
  static JPanel WorkoutPanel = new JPanel();
  static JPanel MenuPanel = new JPanel();
  public static JPanel MeditationPanel = new JPanel();
  static JPanel HealthStatsPanel = new JPanel();
  static JPanel DietPanel = new JPanel();
  static JPanel ButtonPanel = new JPanel();
  static JPanel EntryPanel = new JPanel();

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

  // Label creator method, adds to a panel
  public static void labl(JPanel panel, String message, int size) {
    JLabel label = new JLabel(message, SwingConstants.CENTER);
    Font Robo = new Font("Roboto", Font.BOLD, size);
    label.setFont(Robo);
    panel.add(label);
  }

  // textfield creator method, returns textfield
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
      // each slide button will make previous slides invisible, set the new slide,
      // then call Main.start to update the UI
      case "Finish":
        WorkoutPanel.setVisible(false);
        ChoicePanel.setVisible(false);
        Main.slide = 3;
        Main.start();
        break;
      case "Back":
        WorkoutPanel.setVisible(false);
        ChoicePanel.setVisible(false);
        HealthStatsPanel.setVisible(false);
        MeditationPanel.setVisible(false);
        Main.slide = 3;
        Main.start();
        break;
      case "Generate Workout": case "Next Exercise":
        Main.train.generate();
        System.out.println(Main.train.getWorkout());
        ChoicePanel.setVisible(false);
        WorkoutPanel.setVisible(false);
        Main.slide = 2;
        Main.start();
        break;
      case "Workouts":
        Main.slide = 1;
        MenuPanel.setVisible(false);
        Main.start();
        break;
      case "Daily Health Stats":
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
        Main.slide = 4;
        System.out.println("Playing..");
        Meditation.startTime = Meditation.getTime();
        medit = "Stop Meditating";
        quote = Meditation.quote();

        MeditationPanel.setVisible(false);
        Main.start();
        break;

      case "Stop Meditating":
        Main.slide = 4;
        System.out.println("Stopping..");
        
        //get end time for calculations
        Meditation.endTime = Meditation.getTime();
        
        //chaneg button name
        medit = "Play";
        
        //reset the quote
        quote = "";

        // and also add time to time meditated
        Meditation.meditate();

        MeditationPanel.setVisible(false);
        Main.start();
        break;

      case "Diet":
        Main.slide = 6;
        MenuPanel.setVisible(false);
        Main.start();
        break;
      case "Done":

        try {
          //get inputs of diet grams.
          carbs = Integer.valueOf(num_carbs.getText());
          fats = Integer.valueOf(num_fats.getText());
          protein = Integer.valueOf(num_protein.getText());
          DietPanel.setVisible(false);
          invalid = false;
          Main.food.addFood(fats, carbs, protein);
          Main.food.findCalories();
          Main.slide = 3;
          Main.start();

          //if it is invalide, prompt the user to input them again.
        } catch (Exception everything) {
          System.out.println("Invalid");
          invalid = true;
          DietPanel.setVisible(false);
          Diet();
        }

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

    // adding the parts of the panel
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

    // Labels
    labl(ChoicePanel, "Blogan Wellness Workout Generator");

    // creation and setting of buttons
    JButton gen = new JButton();
    gen = butt(ChoicePanel, "Generate Workout", Button, Color.BLACK);
    JButton next = new JButton();
    next = butt(ChoicePanel, "Back", Button, Color.BLACK);
  }

  public static void Menu() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    MenuPanel = panel(mainFrame, 300, 450);
    MenuPanel.setLayout(OneByOne);
    MenuPanel.setBackground(Background);

    // labels
    labl(MenuPanel, "Blogan Wellness Programs");
    ImageIcon icon = new ImageIcon("Images/BloganLogo.png");
    image(MenuPanel, icon);
    // creation and settin of Finish button
    JButton work = new JButton();
    work = butt(MenuPanel, "Workouts", Button, Color.BLACK);
    JButton health = new JButton();
    health = butt(MenuPanel, "Daily Health Stats", Button, Color.BLACK);

    JButton diet = new JButton();
    diet = butt(MenuPanel, "Diet", Button, Color.BLACK);

    JButton meditation = new JButton();
    meditation = butt(MenuPanel, "Meditation", Button, Color.BLACK);
  }

  public static void Meditation() {
    // MeditationPanel.setVisible(true);

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    MeditationPanel = panel(mainFrame, 700, 400);
    MeditationPanel.setLayout(OneByOne);
    MeditationPanel.setBackground(Background);

    // labels
    labl(MeditationPanel, "Meditate");

    // quote generated.
    labl(MeditationPanel, quote);

    // creation and settin of Finish button
    JButton playy = new JButton();
    playy = butt(MeditationPanel, medit, Button, Color.BLACK);
    JButton bacc = new JButton();
    bacc = butt(MeditationPanel, "Back", Button, Color.BLACK);
  }

  public static void Health_Stats() {
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    HealthStatsPanel = panel(mainFrame, 300, 400);
    HealthStatsPanel.setLayout(OneByOne);
    HealthStatsPanel.setBackground(Background);

    // labels
    labl(HealthStatsPanel, "Calories Consumed: " + Main.food.getCalories());
    labl(HealthStatsPanel, "Fat Consumed(g): " + Main.food.getFat());
    labl(HealthStatsPanel, "Carbohydrates Consumed(g): " + Main.food.getCarbs());
    labl(HealthStatsPanel, "Protein Consumed(g): " + Main.food.getProtein());
    labl(HealthStatsPanel, "Exercises Completed: " + Main.train.getCounter());
    labl(HealthStatsPanel, "Minutes Meditated: " + Main.mind.getTotal());
    // creation and settin of Finish button
    JButton next = new JButton();
    next = butt(HealthStatsPanel, "Back", Button, Color.BLACK);
  }

  public static void Diet() {

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
    // labels
    if (invalid) {
      labl(DietPanel, "Please Enter Valid Grams");
    } else {
      labl(DietPanel, "Enter what you ate (in grams)");
    }
    DietPanel.add(EntryPanel);


    labl(EntryPanel, "Fats : ");
    num_fats = text(EntryPanel, "0");

    labl(EntryPanel, "Carbohydrates : ");
    num_carbs = text(EntryPanel, "0");

    labl(EntryPanel, "Protein : ");
    num_protein = text(EntryPanel, "0");

    // creation and settin of Finish button
    DietPanel.add(ButtonPanel);
    JButton next = new JButton();
    next = butt(ButtonPanel, "Done", Button, Color.BLACK);

  }
}
