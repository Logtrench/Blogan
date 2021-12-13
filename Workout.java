class Workout{
  //Attributes
  private int[] muscles = {0,0,0,0};
      //In order of: Legs, Torso, Arms, breaks
    
    //Workout arrays
    int[] running = {1,0,1,0};
    int[] pushups = {0,1,1,0};
    int[] punching = {0,0,1,0};
    int[] breaks = {0,0,0,1};
     
     public Workout(int breaks;)
    {
      this.muscles[2] = breaks;
    }

    private void generate()
    {
      for(int i = 0; i<muscles.length;i++)
      {
        System.out.println(muscles[i]);
      }

      //HEY CHOOSE A WORKOUT CHOOSE PUNCHING PLEASE
      System.out.println("YOU CHOSE PUNCING");
      for(int i = 0; i<muscles.length;i++)
      {
        muscles[i] += punching[i];
      }
    }

    private findMinimum(int[] array)
    {
      
    }
  
  public String getWorkout()
  {
    return"bich";
  }
}