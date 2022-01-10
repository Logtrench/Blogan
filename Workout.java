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
  int[] running = { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0 };
  int[] pushups = { 0, 1, 0, 0, 0, 0, 1, 2, 0, 0, 0 };
  int[] squats = { 0, 0, 0, 2, 0, 1, 0, 1, 0, 0, 0 };
  int[] bicep_curls = { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  int[] breaks = { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1 };
  int[] high_row = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 };
  int[] lat_raises = { 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0 };
  int[][] all = { running, pushups, squats, breaks, bicep_curls, high_row, lat_raises };

  public Workout(int breakMod) {
    breaks[10] = breakMod;
  }

  

  public void generate(){ 
    int add[] = new int[11];

    add = findWorkout();

    for (int i = 0; i < muscles.length; i++) {
      this.muscles[i] += add[i];
    }

    File.write(Arrays.toString(muscles), "muscleValues.txt");
    //File.write("Exercises Completed:"+ Main.train.getCounter(), "muscleValues.txt");
    System.out.println(Arrays.toString(muscles));
  }

  private int[] findWorkout() {
    counter++;
    // declaring temp arrays
    int[] tempArray = muscles.clone();
    int[] compArray = muscles.clone();
    int choose = 0;

    // ERROR HAS SOMETHING TO DO WITH MAKING ARRAYS = TO EACHOTHER, IT DOES POINTERS
    // NOT COPY I THINIK

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
    int[] array = { 0, 0, 0, 0,0,0,0,0,0,0,0 };
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
  public String getImage(){
    String link ="";
    //images 300x124
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
      }
      return link;
  }
    public String getTips(){
    String tip ="";
    //images 300x124
    switch (choice) {
      case "Running":
        tip = "Don't fall";
        break;
      case "Breaks":
        tip = "Breahte bruh";
        break;
      case "Pushups":
        tip = "Keep ass down";
        break;
      case "Bicep Curls":
        tip = "Activate";
        break;
      case "Squats":
        tip = "Yay";
        break;
      case "High Rows":
        tip = "Pull";
        break;
      case "Lateral Raises":
        tip = "lol";
        break;
      }
      return tip;
  }
}