class Workout{
  //Attributes
  private int[] muscles = {0,0,0,0};
  String choice = "Click generate to generate a workout";
      //In order of: Legs, Torso, Arms, breaks
    
    //Workout arrays
    int[] running = {1,0,1,0};
    int[] pushups = {0,1,1,0};
    int[] punching = {0,0,1,0};
    int[] breaks = {0,0,0,1};

    //break modifier
    int breakModifier = 0;
     
     Workout(int breaks)
    {
      this.breakModifier = breaks;
    }

    public void generate()
    {
      for(int i = 0; i<muscles.length;i++)
      {
        System.out.println(muscles[i]);
      }

      int min = findMinimum(muscles);
      int max = findMaximum(muscles);
      System.out.println("the min is " + min);
      int add[] = new int[4];
      
      add = findWorkout(min,max);

      //HEY CHOOSE A WORKOUT CHOOSE PUNCHING PLEASE
      System.out.println("YOU DO " + choice);
      for(int i = 0; i<muscles.length;i++)
      {
        this.muscles[i] += add[i];
      }
    }

    private int findMinimum(int[] array)
    {
      int minNum = array[0];
      int index = 0;
      
      for(int i=0;i<array.length;i++){ 
        if(array[i] < minNum){ 
          minNum = array[i]; 
          index = i;
        } 
      }
    
      return index;
    }

    private int findMaximum(int[] array)
    {
      int maxNum = array[0];
      int index = 0;
      
      for(int i=0;i>array.length;i++){ 
        if(array[i] > maxNum){ 
          maxNum = array[i]; 
          index = i;
        } 
      }
    
      return index;
    }

    private int[] findWorkout(int min, int max)
    {
      int[] array = new int[muscles.length];

        if(running[min]>=pushups[min]&&running[min]>=punching[min]&&running[min]>=breaks[min])
        {
          array = running;
          choice = "running";
        } else if(pushups[min]>=punching[min]&&pushups[min]>=breaks[min])
        {
          array = pushups;
          choice = "pushups";
        } else if(punching[min]>=breaks[min])
        {
          array = punching;
          choice = "punching";
        } else
        {
          array = breaks;
          choice = "breaks";
        }
      
      return array;
    }
  
  public String getWorkout()
  {
    return choice;
  }
}