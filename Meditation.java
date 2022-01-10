class Meditation {
  int count = 0;
    public void meditate(){
      count++;
    }
    public String getCounter() {
      String str = Integer.toString(count);
      return str;
  }
}
