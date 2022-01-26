import java.lang.Math.*;
import java.util.*;

class Workout {
  // Attributes
  private int[] muscles = makeArray(File.read("muscleValues.txt"));
  String choice = "Click generate to generate a workout";
  String link = "";
  String tip = "";
  int counter = 0;
  // In order of: Biceps, Triceps, Shoulders, quads,
  // hamstrings,glutes,core,pecs,upperback,midback,breaks

  // Workout arrays
  int[] running = { 0, 0, 0, 2, 2, 2, 1, 0, 0, 1, 0 };
  int[] pushups = { 0, 1, 2, 0, 0, 0, 1, 2, 0, 1, 0 };
  int[] squats = { 0, 0, 0, 2, 0, 2, 1, 0, 0, 1, 0 };
  int[] bicep_curls = { 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
  int[] breaks = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
  int[] high_row = { 1, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0 };
  int[] lat_raises = { 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0 };
  int[] hammer_curls = { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
  int[] tricep_kickback = { 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
  int[] tricep_extension = { 0, 2, 0, 0, 0, 0, 1, 0, 0, 1, 0 };
  int[] db_deadlift = { 0, 0, 0, 2, 1, 2, 1, 0, 1, 1, 0 };
  int[] front_raises = { 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0 };
  int[] wall_sits = { 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0 };
  int[] forward_lunge = { 0, 0, 0, 2, 1, 2, 1, 0, 0, 0, 0 };
  int[] hamstring_curl = { 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0 };
  int[] Straight_leg_deadlift = { 0, 0, 0, 0, 2, 2, 1, 0, 1, 0, 0 };
  int[] glute_bridge = { 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0 };
  int[] plank = { 0, 1, 1, 1, 0, 0, 2, 1, 0, 1, 0 };
  int[] deadbug = { 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0 };
  int[] bird_dog = { 0, 0, 1, 0, 1, 1, 2, 0, 1, 1, 0 };
  int[] wide_pushups = { 0, 1, 2, 0, 0, 0, 1, 3, 0, 1, 0 };
  int[] arm_row = { 2, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0 };
  int[] chinups = { 2, 0, 1, 0, 0, 0, 1, 1, 1, 2, 0 };
  int[][] all = { running, pushups, squats, breaks, bicep_curls, high_row, lat_raises, hammer_curls, tricep_kickback,
      tricep_extension, front_raises, wall_sits, forward_lunge, hamstring_curl, Straight_leg_deadlift, glute_bridge,
      db_deadlift, plank, deadbug, bird_dog, wide_pushups, arm_row, chinups };

  public Workout(int breakMod) {
    breaks[10] = breakMod;
  }

  public void generate() {
    int add[] = new int[11];

    add = findWorkout();

    for (int i = 0; i < muscles.length; i++) {
      this.muscles[i] += add[i];
    }

    File.write(Arrays.toString(muscles), "muscleValues.txt");
    // File.write("Exercises Completed:"+ Main.train.getCounter(),
    // "muscleValues.txt");
    System.out.println(Arrays.toString(muscles));
  }

  private int[] findWorkout() {
    counter++;
    // declaring temp arrays
    int[] tempArray = muscles.clone();
    int[] compArray = muscles.clone();
    int choose = 0;

    // making tempArray default to adding the first workout
    for (int o = 0; o < all[0].length; o++) {
      tempArray[o] += all[0][o];
    }

    // TEMP ARRAY GETS MESSED UP IN FOR LOOP

    // finding the option with the lowest deviation
    // go through list of arrays (workouts)
    for (int j = 0; j < all.length; j++) {
      // resetting compArray
      compArray = muscles.clone();
      // go through weightings of muscles for each workout
      for (int i = 0; i < muscles.length; i++) {
        compArray[i] += all[j][i];
      }

      /*
       * if(dev of comp array better, then no change) elseif (dev of temp array
       * better, make comp array = to temparray)
       */

      if (dev(tempArray) > dev(compArray)) {
        tempArray = compArray.clone();

        choose = j;
      }
    }

    tempArray = all[choose].clone();

    // assigning the identity to the workout NEED TO ADD ALL TINGyS
    switch (choose) {
      case 0:
        choice = "Running";
        break;

      case 1:
        choice = "Pushups";
        break;

      case 2:
        choice = "Squats";
        break;

      case 3:
        choice = "Breaks";
        counter--;
        break;
      case 4:
        choice = "Bicep Curls";
        break;
      case 5:
        choice = "High Rows";
        break;
      case 6:
        choice = "Lateral Raises";
        break;
      case 7:
        choice = "Hammer Curls";
        break;
      case 8:
        choice = "Tricep Kickbacks";
        break;
      case 9:
        choice = "Tricep Extension";
        break;
      case 10:
        choice = "Front Raises";
        break;
      case 11:
        choice = "Wall Sits";
        break;
      case 12:
        choice = "Forward Lunge";
        break;
      case 13:
        choice = "Hamstring Curl";
        break;
      case 14:
        choice = "Straight Leg Deadlift";
        break;
      case 15:
        choice = "Glute Bridge";
        break;
      case 16:
        choice = "Dumbbell Deadlift";
        break;
      case 17:
        choice = "Plank";
        break;
      case 18:
        choice = "Deadbug";
        break;
      case 19:
        choice = "Bird Dog";
        break;
      case 20:
        choice = "Wide Pushups";
        break;
      case 21:
        choice = "Arm Row";
        break;
      case 22:
        choice = "Chinups";
        break;

      /*
       * running, pushups, squats, breaks, bicep_curls, high_row,
       * lat_raisesAAAA,hammer_curls,tricep_kickback, tricep_extension, front_raises,
       * wall_sits, forward_lunge, hamstring_curl, Straight_leg_deadlift,
       * glute_bridge, db_deadlift, plank, deadbug, bird_dog, wide_pushups,arm_row,
       * chinups };
       */
    }

    return tempArray;
  }

  private double dev(int[] array) {
    double mean = mean(array);
    double sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += (Math.abs(array[i] - mean));
    }
    double absDeviation = sum / array.length;
    // System.out.println("the mean is " + mean);
    return absDeviation;
  }

  private double mean(int[] array) {
    double mean = 0;
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    mean = (double) sum / (double) array.length;
    return mean;
  }

  private int[] makeArray(String s) {
    String t = "";
    int counter = 0;
    int[] array = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        t += ch;
      }
      if (ch == ',' || ch == ']') {
        array[counter] = Integer.valueOf(t);
        t = "";
        counter++;
      }
    }
    System.out.println(Arrays.toString(array));

    return array;
  }

  public String getWorkout() {
    return choice;
  }

  public String getCounter() {
    String count = Integer.toString(counter);
    return count;
  }

  public String getImage() {
    String link = "";
    // images 300x124
    // choice = "Chinups";
    switch (choice) {
      case "Running":
        link = "Images/RunPic.jpg";
        break;
      case "Breaks":
        link = "Images/BreakPic.jpg";
        break;
      case "Pushups":
        link = "Images/PushupPic.jpg";
        break;
      case "Bicep Curls":
        link = "Images/BicepCurlsPic.jpg";
        break;
      case "Squats":
        link = "Images/SquatPic.jpg";
        break;
      case "High Rows":
        link = "Images/HighRowPic.jpg";
        break;
      case "Lateral Raises":
        link = "Images/LatRaisePic.jpg";
        break;
      case "Hammer Curls":
        link = "Images/HamCurlPic.jpg";
        break;
      case "Tricep Kickbacks":
        link = "Images/TriKickbackPic.jpg";
        break;
      case "Tricep Extension":
        link = "Images/TriExtensionPic.jpg";
        break;
      case "Front Raises":
        link = "Images/FrontRaisesPic.jpeg";
        break;
      case "Wall Sits":
        link = "Images/WallSitPic.jpg";
        break;
      case "Forward Lunge":
        link = "Images/FwdLungPic.jpg";
        break;
      case "Hamstring Curl":
        link = "Images/hamstring_curl.jpg";
        break;
      case "Straight Leg Deadlift":
        link = "Images/StrLegDeadliftPic.jpg";
        break;
      case "Glute Bridge":
        link = "Images/GluteBridgePic.jpg";
        break;
      case "Dumbbell Deadlift":
        link = "Images/DBDeadliftPic.jpg";
        break;
      case "Plank":
        link = "Images/PlankPic.jpg";
        break;
      case "Deadbug":
        link = "Images/DeadbugPic.jpg";
        break;
      case "Bird Dog":
        link = "Images/BirddogPic.jpg";
        break;
      case "Wide Pushups":
        link = "Images/WidePushupPic.jpg";
        break;
      case "Arm Row":
        link = "Images/ArmRowPic.jpg";
        break;
      case "Chinups":
        link = "Images/ChinupPic.jpeg";
        break;
    }
    return link;
  }

  public String getTips() {
    String tip = "";
    // images 300x124
    switch (choice) {
      case "Running":
        tip = "Don't run too fast";
        break;
      case "Breaks":
        tip = "Live your normal life!";
        break;
      case "Pushups":
        tip = "Make sure your body is straight";
        break;
      case "Bicep Curls":
        tip = "Take your time";
        break;
      case "Squats":
        tip = "Finish strong";
        break;
      case "High Rows":
        tip = "Try not to let your elbows straighten";
        break;
      case "Lateral Raises":
        tip = "Go down slower";
        break;
      case "Hammer Curls":
        tip = "Keep your posture as you lift";
        break;
      case "Tricep Kickbacks":
        tip = "Time it with your breathing";
        break;
      case "Tricep Extension":
        tip = "Keep your elbows close to your body";
        break;
      case "Front Raises":
        tip = "Lift the weight upward while inhaling";
        break;
      case "Wall Sits":
        tip = "Keep your knees above your ankles";
        break;
      case "Forward Lunge":
        tip = "Engage your core";
        break;
      case "Hamstring Curl":
        tip = "Lower your foot slowly";
        break;
      case "Straight Leg Deadlift":
        tip = "Bend at your hips";
        break;
      case "Glute Bridge":
        tip = "Keep your arms at your side";
        break;
      case "Dumbbell Deadlift":
        tip = "Keep your head in line with the rest of your body";
        break;
      case "Plank":
        tip = "Keep a neutral sine and neck";
        break;
      case "Deadbug":
        tip = "Exhale as you rise";
        break;
      case "Bird Dog":
        tip = "Keep your hip and shoulders parallel to the floor";
        break;
      case "Wide Pushups":
        tip = "Keep body in a straight line";
        break;
      case "Arm Row":
        tip = "Maintain a tight core";
        break;
      case "Chinups":
        tip = "Can be assisted with bands";
        break;
    }
    return tip;
  }
}