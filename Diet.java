class Diet {
  int calories = 0;
  int vegs = 0;
  int fruits = 0;
  int grains = 0;
  int protein = 0;

  public void addFood(int cal, int veggies, int fruit, int grain, int proteins) {
    calories += cal;
    vegs += veggies;
    fruits += fruit;
    grains += grain;
    protein += proteins;
  }

  public int getCalories() {
    return calories;
  }

  public int getVegtables() {
    return vegs;
  }

  public int getFruits() {
    return fruits;
  }

  public int getGrains() {
    return grains;
  }

  public int getProtein() {
    return protein;
  }
}