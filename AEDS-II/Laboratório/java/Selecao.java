/**
 * Algoritmo de ordenacao por selecao
 * @author Max do Val Machado
 * @version 3 08/2020
 */

class Selecao extends Geracao {

   /**
    * Construtor.
    */
   public Selecao(){
      super();
   }
   /*
    * Contador de operações
    */
   public static int contador = 0;
   /**
    * Construtor.
    * @param int tamanho do array de numeros inteiros.
    */
   public Selecao(int tamanho){
      super(tamanho);
   }


   /**
    * Algoritmo de ordenacao por selecao.
    */
   @Override
   public void sort() {
      for (int i = 0; i < (n - 1); i++) {
         int menor = i;
         for (int j = (i + 1); j < n; j++){
            if (array[menor] > array[j]){
               menor = j;
	       //contador++;
            }
	    contador++;
         }
         swap(menor, i);
      }
      MyIO.println("Contador: "+contador);
   }
}
