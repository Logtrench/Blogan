import java.lang.Math.*;
import java.util.*;

class Workout {
  // Attributes
  private int[] muscles = { 0, 0, 0, 0 };
  String choice = "Click generate to generate a workout";
  // In order of: Legs, Torso, Arms, breaks

  // break modifier defaulted to 1
  int breakModifier = 1;

  Workout(int breaks) {
    this.breakModifier = breaks;
  }

  // Workout arrays
  int[] running = { 1, 0, 0, 0 };
  int[] pushups = { 0, 2, 1, 0};
  int[] punching = { 0, 0, 2, 0 };
  int[] breaks = {0, 0, 0, breakModifier};
  int[][] all = { running, pushups, punching, breaks };

  public void generate() {
    int add[] = new int[4];

    add = findWorkout();
    
    for (int i = 0; i < muscles.length; i++) {
        this.muscles[i] += add[i];      
    }
    System.out.println(Arrays.toString(muscles));
  }

  private int[] findWorkout(){
    //declaring temp arrays
    int [] tempArray = muscles.clone();
    int [] compArray = muscles.clone();
    int choose = 0;
    
    //ERROR HAS SOMETHING TO DO WITH MAKING ARRAYS = TO EACHOTHER, IT DOES POINTERS NOT COPY I THINIK


    //making tempArray default to adding the first workout
    for(int o =0; o<all[0].length;o++)
    {
      tempArray[o]+=all[0][o];
    }

    //TEMP ARRAY GETS MESSED UP IN FOR LOOP

    //finding the option with the lowest deviation
    //go through list of arrays (workouts)
    for(int j = 0; j<all.length;j++){
      //resetting compArray
      compArray = muscles.clone();
      //go through weightings of muscles for each workout
      for(int i = 0; i<muscles.length;i++){
          compArray[i]+=all[j][i];
      }
      
      /*
      if(dev of comp array better, then no change)
      elseif (dev of temp array better, make comp array = to temparray)
      */
      
      if(dev(tempArray)>dev(compArray)){
        tempArray=compArray.clone();

        choose = j;
      } 
    }

    tempArray = all[choose].clone();
    
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
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    mean = (double)sum / (double)array.length;
    return mean;
  }

  /*private int[] copyArray(int[] art, int[] copy)
  {
    for(int i =0;i<art.length;i++)
    {
      copy[i] = art[i];
    }
  }*/

  public String getWorkout() {
    return choice;
  }
}