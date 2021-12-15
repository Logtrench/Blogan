import java.lang.Math.*;
import java.util.*;

class Workout {
  // Attributes
  private int[] muscles = { 0, 0, 0, 0 };
  String choice = "Click generate to generate a workout";
  // In order of: Legs, Torso, Arms, breaks

  // Workout arrays
  int[] running = { 9, 0, 1, 0 };
  int[] pushups = { 0, 1, 1, 0 };
  int[] punching = { 0, 0, 1, 0 };
  int[] breaks = { 0, 0, 0, 1 };

  int[][] all = { running, pushups, punching, breaks };

  // break modifier
  int breakModifier = 0;

  Workout(int breaks) {
    this.breakModifier = breaks;
  }

  public void generate() {
    for (int i = 0; i < muscles.length; i++) {
      System.out.println(muscles[i]);
    }

    int min = findMinimum(muscles);
    int max = findMaximum(muscles);
    System.out.println("the min is " + min);
    int add[] = new int[4];

    add = findWorkout();

    // HEY CHOOSE A WORKOUT CHOOSE PUNCHING PLEASE
    System.out.println("YOU DO " + choice);
    for (int i = 0; i < muscles.length; i++) {
      this.muscles[i] += add[i];
    }
    System.out.println(Arrays.toString(muscles));
  }

  private int findMinimum(int[] array) {
    int minNum = array[0];
    int index = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] < minNum) {
        minNum = array[i];
        index = i;
      }
    }

    return index;
  }

  private int findMaximum(int[] array) {
    int maxNum = array[0];
    int index = 0;

    for (int i = 0; i > array.length; i++) {
      if (array[i] > maxNum) {
        maxNum = array[i];
        index = i;
      }
    }

    return index;
  }

  /*
   * private int[] findWorkout(int min, int max) { int[] array = new
   * int[muscles.length];
   * 
   * if (running[min] >= pushups[min] && running[min] >= punching[min] &&
   * running[min] >= breaks[min]) { array = running; choice = "running"; } else if
   * (pushups[min] >= punching[min] && pushups[min] >= breaks[min]) { array =
   * pushups; choice = "pushups"; } else if (punching[min] >= breaks[min]) { array
   * = punching; choice = "punching"; } else { array = breaks; choice = "breaks";
   * }
   * 
   * return array; }
   */

  private int[] findWorkout(){
    //declaring temp arrays
    int [] tempArray = muscles;
    int [] compArray = muscles;
    int choose = 0;
    
    //making tempArray default to adding the first workout
    for(int o =0; o<all[0].length;o++)
    {
      tempArray[o]+=all[0][o];
      System.out.println(all[0][o]);
    }
    System.out.println("this is temp" +Arrays.toString(tempArray));

    //TEMP ARRAY GETS MESSED UP IN FOR LOOP

    //finding the option with the lowest deviation
    //go through list of arrays (workouts)
    for(int j = 0; j<all.length;j++){
      //resetting compArray
      compArray = muscles;
      //go through weightings of muscles for each workout
      for(int i = 0; i<muscles.length;i++){
        compArray[i]+=all[j][i];
      }
      
      /*
      if(dev of comp array better, then no change)
      elseif (dev of temp array better, make comp array = to temparray)
      */
      if(dev(tempArray)>dev(compArray)){
        tempArray=compArray;

        choose = j;
      }
      System.out.println(dev(compArray));
      System.out.println("this mean is comparray:" +mean(compArray));
      System.out.println(dev(tempArray));
      System.out.println("this mean is temparray:" +mean(tempArray));
      System.out.println("this is the comparray:"+ Arrays.toString(compArray));
      
    }
    
    //assigning the identity to the workout
    switch(choose)
    {
      case 0:
      choice = "Running";
      break;
      
      case 1:
      choice = "Pushups AHAHAHAH";
      break;
      
      case 2:
      choice = "Punching";
      break;

      case 3:
      choice = "Breaks";
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
    System.out.println("this is the array:"+ Arrays.toString(array));
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    mean = (double)sum / (double)array.length;
    return mean;
  }

  public String getWorkout() {
    return choice;
  }
}