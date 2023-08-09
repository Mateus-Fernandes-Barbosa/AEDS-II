class Teste02{
  public static void main(String [] args){
    int i = 10, b = 10;
    while(i > 0){
      b--;
      i = i >> 1;
      System.out.println("i: " + i + "b: " + b + "\n");
    }
    i = 0;
    while(i < 15){
      b--;
      i+=2;
    }
  }
}
