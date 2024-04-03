
public class AlgebraBool {
  public static Boolean [] variaveis;
  public static int quantidadeDeOperacoes;
  
  public static int QualOIndexLetra(String entrada){ 
    int resp = 0;
    //MyIO.println("Entrada: " + entrada);
    //MyIO.println("Length: " + entrada.length());
    entrada = entrada.toUpperCase();
    for(int i = 0; i < entrada.length(); i++){
      //MyIO.println("i2: " + i);
      char c = entrada.charAt(i);
      //MyIO.println("C: " + c);
      if(c >= 'A' && c <= 'Z'){
        resp = i;
        //MyIO.println("Resp: " + resp);
	      i = entrada.length();
      }
      //MyIO.println("i: " + i);
    }
    return resp;
  }//Função utilizada para definir qual a posição da primeira letra da string e separar as instruções da criação das variáveis das instruções lógicas.

  public static void DefineVariaveis(String aux){ 
      int qtdVariaveis = (int) aux.charAt(0);
      variaveis = new Boolean[qtdVariaveis + 2];
      for(int i = 0, j = 2; i < aux.length(); i++){
        char c = aux.charAt(i);
        if(c == '1' || c == '0'){
          if(c == '1') variaveis[j] = true;
          else variaveis[j] = false;
          //MyIO.println("Teste1: " + variaveis[j] + "[" + j + "]");
          j++;
        }
      }
    variaveis[0] = false;
    variaveis[1] = true;
  }//Função utilizada para definir o valor booleano das variáveis a serem utilizadas nas operações booleanas.

  public static int DefinequantidadeDeOperacoes(String entrada){ 
    int resp = 0;
    for(int i = 0; i < entrada.length(); i++){
      char c = entrada.charAt(i);
      if(c == ')'){
        resp++;
      }
    }
    //MyIO.println("Qtd Operações: " + resp);
    return resp;
  } //Função utilizada para determinar a quantidade de operações a serem realizadas na algebra booleana em questão.

  public static String AlteraValores(String entrada){ 
    char [] aux = entrada.toCharArray();
    for(int i = entrada.indexOf('('); i < entrada.indexOf(')'); i++){
      //MyIO.println("I: " + i);
      if(aux[i] >= 'A' && aux[i] <= 'Z'){
        //MyIO.println("teste4: " + variaveis[aux[i] - 63]);
        //MyIO.println("AUX[i]: " + aux[i]);
        aux[i] = variaveis[aux[i] - 63] ? '1' : '0';
      }
    }
    entrada = new String(aux);
    return entrada;
  }//Função utilizada para substituir as variáveis por seus respectivos valores booleanos.

  public static String BuscaOperacao(String entrada){ 
    int aux = 0, auy = -1;
    entrada = entrada.toUpperCase();
    //MyIO.println("length2: " + entrada.length());
    for(int i = entrada.length() - 1; auy == -1 ; i--){
       char c = entrada.charAt(i);
      if(c == ')'){
        aux = i;
        //MyIO.println("AUX: " + aux);
      }
      if(c == '('){
        auy = i;
        //MyIO.println("AUY: " + auy);
        if(i - 2 >= 0 && entrada.charAt(i - 2) == 'O'){
          if(i - 3 >= 0 && entrada.charAt(i - 3) == 'N'){
            char resultado = EncontraVariaveis(entrada.substring(auy - 3, aux + 1), entrada);
            entrada = MontaResultado(entrada, resultado, auy - 3, aux);
          }
          else{
            //MyIO.println("LIMÃO");
            char resultado = EncontraVariaveis(entrada.substring(auy - 2, aux + 1), entrada);
            entrada = MontaResultado(entrada, resultado, auy - 2, aux);
          }
        }
        else if(i - 3 >= 0 && entrada.charAt(i - 3) == 'A'){
          if(i - 4 >= 0 && entrada.charAt(i - 4) == 'N'){
            char resultado = EncontraVariaveis(entrada.substring(auy - 4, aux + 1), entrada);
            entrada = MontaResultado(entrada, resultado, auy - 4, aux);
          }
          else{
            //MyIO.println("MAÇÃ");
            char resultado = EncontraVariaveis(entrada.substring(auy - 3, aux + 1), entrada);
            entrada = MontaResultado(entrada, resultado, auy - 3, aux);
          }
        }
      }
    }
      //MyIO.println("i: " + i);
      return entrada;
  }//Função utilizada par1a determinar onde a operação começa onde termina

  public static char EncontraVariaveis(String entrada, String entradaCompleta){

    //MyIO.println("Substring2: " + entrada);
    entrada = AlteraValores(entrada);
    //MyIO.println("Substring3: " + entrada);
    String comando = new String(entrada.substring(0, entrada.indexOf('(')));
    //MyIO.println("Substring1: " + comando);
    int j = 0;
    for(int i = entrada.indexOf('('); i < entrada.indexOf(')'); i++){
      char c = entrada.charAt(i);
      if(c == '1' || c == '0') j++;
    }
    //MyIO.println("Quantidade de variáveis: " + j);
    char [] valores = new char[j];
    j = 0;
    for(int i = entrada.indexOf('('); i < entrada.indexOf(')'); i++){
      char c = entrada.charAt(i);
      if(c == '1' || c == '0'){
        valores[j] = c;
        j++;
      }
    }
    comando = comando.toLowerCase();
    char resultado = ExecutaComando(comando, valores);
    return resultado;
  }//Função utilizada para encontrar quais as variáveis presentes na substring, para poder realizar a operação.
    

  public static char ExecutaComando(String comando, char[] valores){ 
    Boolean resp = true;
    //MyIO.println("teste3: " + (valores[0] - '0'));
    if(valores.length > 1){
      for(int i = 0; i < valores.length - 1; i++){
       if(comando.equals("not")){
          resp = !variaveis[valores[i] - '0'];     
        } else if(comando.equals("and")){
          resp =  variaveis[valores[i] - '0'] && variaveis[valores[i + 1] - '0']; 
        } else if(comando.equals("or")){
          resp = variaveis[valores[i] - '0'] || variaveis[valores[i + 1] - '0']; 
        } else if(comando.equals("nand")){
          resp = variaveis[valores[i] - '0'] && variaveis[valores[i + 1] - '0'];
          resp = !resp;
        } else if(comando.equals("nor")){
          resp = variaveis[valores[i] - '0'] || variaveis[valores[i + 1] - '0']; 
          resp = !resp;
        }
      }
    }
    else{
          resp = !variaveis[valores[0] - '0'];
      }
      char c = resp ? '1' : '0';
      //MyIO.println("Resultado da operação em char: " + c);
      return c;
  }//Função utilizada para executar a função booleana propriamente dita, utilizando os valores das variáveis presentes na substring.
  
  public static String MontaResultado(String entrada, char resultado, int auy, int auz){
    char [] aux = entrada.toCharArray();
    aux[auy] = resultado;
    for(int i = auz; i > auy; i--){
      aux[i] = ' ';
    }
    for(int i = auz + 1, j = auy + 1; i < aux.length; i++){
      aux[j] = aux[i];
      //MyIO.println("AUX[j]: " + aux[j]);
      //MyIO.println("AUX[i]1: " + aux[i]);
      aux[i] = '\0';
      //MyIO.println("AUX[i]2: " + aux[i]);
      j++;
    }
    entrada = new String(aux);
    return entrada;
  }//Função que reconstroe a String de entrada substituindo as operações por seus respectivos resultados

  public static void main(String[] args) {
  
    String entrada = "";
    entrada = MyIO.readLine();
    //MyIO.println("Entrada: " + entrada);
    //MyIO.println("Length: " + entrada.length());
    while(!entrada.equals("0")){
      String aux = entrada.substring(0,QualOIndexLetra(entrada) - 1);
      DefineVariaveis(aux);
      entrada = new String(entrada.substring(QualOIndexLetra(entrada)));
      int n = DefinequantidadeDeOperacoes(entrada);
      for(int i = 0; i < n; i++){
       entrada = BuscaOperacao(entrada);
      }
      MyIO.println(/*"Resultado final da algebra: " +*/ entrada);
      entrada = MyIO.readLine();  
    }
  }
  
}
