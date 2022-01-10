class Main {
  //Should start on menu
  public static int slide = 3;
  public static Workout train = new Workout(2);
  public static Meditation mind = new Meditation();
  public static Diet food = new Diet();
  public static void main(String[] args) {
    start();
  }

  public static void start() {
    switch (slide) {
      case 1:
        GUI.ChooseWorkout();
        break;
      case 2:

        GUI.exercise();
        break;

      case 3:

        GUI.Menu();
        break;

      case 4:
        GUI.Meditation();
        break;
      case 5:
        GUI.Health_Stats();
        break;
      case 6:
        GUI.Diet();
        break;
        

    }
  }
}