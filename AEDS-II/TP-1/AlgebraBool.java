
public class AlgebraBool {
  public static Boolean [] variaveis;
  public static int quantidadeDeOperacoes;
  
  public static int QualOIndexLetra(String entrada){
    int resp = 0;
    MyIO.println("Entrada: " + entrada);
    MyIO.println("Length: " + entrada.length());
    entrada = entrada.toUpperCase();
    for(int i = 0; i < entrada.length(); i++){
      char c = entrada.charAt(i);
      MyIO.println("C: " + c);
      if(c >= 'A' && c <= 'Z'){
        resp = i;
	      i = entrada.length();
      }
    }
    return resp;
  } //Função utilizada para definir qual a posição da primeira letra da string e separar as instruções da criação das variáveis das instruções lógicas.

  public static void DefineVariaveis(String aux){
      int qtdVariaveis = (int) aux.charAt(0);
      variaveis = new Boolean[qtdVariaveis + 2];
      for(int i = 0, j = 2; i < aux.length(); i++){
        char c = aux.charAt(i);
        if(c == '1' || c == '0'){
          if(c == '1') variaveis[j] = true;
          else variaveis[j] = false;
          MyIO.println("Teste1: " + variaveis[j] + "[" + j + "]");
          j++;
        }
      }
    variaveis[0] = false;
    variaveis[1] = true;
  } //Função utilizada para definir o valor booleano das variáveis a serem utilizadas nas operações booleanas.

  public static void DefinequantidadeDeOperacoes(String entrada){
    int resp = 0;
    for(int i = 0; i < entrada.length; i++){
      char c = entrada.charAt(i);
      if(c == ')'){
        resp++;
      }
    }
    quantidadeDeOperacoes = resp;
  }//Função utilizada para determinar a quantidade de operações a serem realizadas na algebra booleana em questão

  public static String AlteraValores(String entrada){
    char [] aux = entrada.toCharArray();
    for(int i = 0; i < entrada.length(); i++){
      if(aux[i] >= 'A' && aux[i] <= 'Z'){
        aux[i] = variaveis[aux[i] - 65] ? '1' : '0';
      }
    }
    entrada = new String(aux);
    return entrada;
  } //Função utilizada para substituir as variáveis por seus respectivos valores booleanos.

  public static String BuscaOperacao(String entrada){
    int aux = 0, auy = 0;
    for(int i = entrada.length() - 1; i >= 0 ; i++){
       char c = entrada.charAt(i);
      if(c == ')'){
        aux = i;
      }
      if(c == '('){
        auy = i;
        if(i - 4 >= 0 && entrada.charAt(i - 4) == 'N'){
          entrada = ExecutaOperacao(entrada.substring(auy - 4, aux), entrada);
        }
        if(i - 3 >= 0 && entrada.charAt(i - 3) >= 'A' && entrada.charAt(i - 3) <= 'Z'){
          entrada = ExecutaOperacao(entrada.substring(auy - 2, aux), entrada);
        }
        else{
          entrada = ExecutaOperacao(entrada.substring(auy - 2, aux), entrada);
        }
      }
    }
  }

  public static String ExecutaOperacao(String entrada, String entradaCompleta){
    char [] aux = entrada.toCharArray();
    String comando = new String(entrada.substring(0, entrada.indexOf('(')));
    int j = 0;
    for(int i = entrada.indexOf('('); i < entrada.indexOf(')'); i++){
      char c = entrada.charAt(i);
      if(c >= 'A' && c <=  'Z') j++;
    }
    char [] valores = new char[j];
    j = 0;
    for(int i = entrada.indexOf('('); i < entrada.indexOf(')'); i++){
      char c = entrada.charAt(i);
      if(c >= 'A' && c <=  'Z' || c == '1' || c == '0'){
        valores[j] = c;
        j++;
      }
    }
    char resultado = ExecutaComando(comando, valores);

  }

  public static char ExecutaComando(String comando, char[] valores){
    Boolean resp;
    if(valores.length > 1){
      for(int i = 0; i < valores.length - 1; i++){
        if(comando.equals("not") && valores[i] >= 'A' && valores[i] <= 'Z'){
          resp = !variaveis[valores[i] - 63];     
        } else if(comando.equals("and") ){
          resp =  variaveis[valores[i] - 63] && variaveis[valores[i + 1] - 63]; 
        } else if(comando.equals("or")){
          
        } else if(comando.equals("nand")){
          
        } else if(comando.equals("nor")){
          
        }
      }
    }
    else{
      if(comando.equals("not")){
          resp = !variaveis[valores[i] - 65];
        } else if(comando.equals("and")){
          
        } else if(comando.equals("or")){
          
        } else if(comando.equals("nand")){
          
        } else if(comando.equals("nor")){
          
        }
      }
    }
  }
  
  public static void main(String[] args) {
  
    String entrada = "";
    MyIO.readLine();
    MyIO.println("Entrada: " + entrada);
    MyIO.println("Length: " + entrada.length());
    while(!entrada.equals("0")){
      int teste = QualOIndexLetra(entrada);
      String aux = entrada.substring(0,teste - 1);
      DefineVariaveis(aux);
      entrada = new String(entrada.substring(QualOIndexLetra(entrada)));
      for(int i = 0; i < quantidadeDeOperacoes; i++){
        BuscaOperacao(entrada);
      }  
    }
  }
  
}
