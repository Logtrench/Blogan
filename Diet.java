class Diet {
  int calories = 0;
  int fat = 0;
  int protein = 0;
  int carbohydrates = 0;


  public void addFood( int fats, int carbs, int proteins) {
    fat += fats;
    carbohydrates += carbs;
    protein += proteins;
  }

  public void findCalories()
  {
    calories = fat*9+carbohydrates*4+protein*4;
  }

  public int getCalories() {
    return calories;
  }

  public int getFat() {
    return fat;
  }

  public int getCarbs() {
    return carbohydrates;
  }

  public int getProtein() {
    return protein;
  }
}