class HelloWorld{
  public static void main(String[] args){
    teste();
    Principal();
  }
  public static void teste(){
    for(int i = 0; i < 4; i++){
      System.out.println(i);
    }
  }
  public static void Principal(){
    mostrar(0);
  }
    public static void mostrar(int value){
    if(value < 4){
      System.out.println(value);
      mostrar(value + 1);
    }
  }
}

