class Main {
  public static int slide = 1;
  public static Workout train = new Workout();

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

    }
  }
}