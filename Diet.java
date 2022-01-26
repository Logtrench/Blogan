class Diet {
  // Creating the Attributes for the Diet Class
  int calories = 0;
  int fat = 0;
  int protein = 0;
  int carbohydrates = 0;

  // This simply adds the amount of grams the user inputs into a value.
  public void addFood(int fats, int carbs, int proteins) {
    fat += fats;
    carbohydrates += carbs;
    protein += proteins;
  }

  // this calculates the number of calories based on the grams of fat, protein,
  // and carbs
  public void findCalories() {
    calories = fat * 9 + carbohydrates * 4 + protein * 4;
  }

  // get method for calories
  public int getCalories() {
    return calories;
  }

  // get method for fat
  public int getFat() {
    return fat;
  }

  // get method for carbs
  public int getCarbs() {
    return carbohydrates;
  }

  // get method for protein
  public int getProtein() {
    return protein;
  }
}