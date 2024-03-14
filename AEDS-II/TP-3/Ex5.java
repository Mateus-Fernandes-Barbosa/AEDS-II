import java.util.Scanner;

class Celula {
   public int elemento;
   public Celula inf, sup, ant, prox;

   public Celula(){
      this(0);
   }

   public Celula(int elemento){
      this(elemento, null, null, null, null);
   }

   public Celula(int elemento, Celula inf, Celula sup, Celula ant, Celula prox){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.ant = ant;
      this.prox = prox;
   }
}

class Matriz {
   private Celula inicio;
   private int linha, coluna;

   public Matriz(){
      this(3, 3);
   }

   public Matriz(int linha, int coluna){
      this.linha = linha;
      this.coluna = coluna;
      this.inicio = new Celula();
      Celula temp = inicio;
      for(int i = 0; i < linha; i++){
	Celula aux = temp;
      	for(int j = 0; j < coluna; j++){
		aux.prox = new Celula();
		aux.prox.ant = aux;
		aux = aux.prox;
	}
		temp.inf = new Celula();
		temp = temp.inf;
      }
      temp = inicio;
      Celula temp2 = inicio.inf;
      for(int i = 1; i < linha; i++){
	Celula aux = temp;
	Celula auy = temp2;
      	for(int j = 0; j < coluna; j++){
		aux.inf = auy; 
		auy.sup = aux;
		aux = aux.prox;
		auy = auy.prox;
	}
	temp = temp.inf;
	temp2 = temp2.inf;
      }
   }

   public Matriz preencher(Matriz m){
	   Scanner leia = new Scanner(System.in);
	   Celula temp = m.inicio;
   	for(int i = 0; i < m.linha; i++){
		Celula aux = temp;
		for(int j = 0; j < m.coluna; j++){
			aux.elemento = leia.nextInt();
			MyIO.println("aux: " + aux.elemento);
			aux = aux.prox;
		}
		temp = temp.inf;
	}
	return m;
   }
	

   public Matriz soma (Matriz m) {
      Matriz resp = null;

      if(this.linha == m.linha && this.coluna == m.coluna){
         resp = new Matriz(this.linha, this.coluna);
      	 Celula temp = resp.inicio, temp2 = m.inicio, temp3 = this.inicio;
	 for(int i = 0; i < this.linha; i++){
		 Celula aux = temp, auy = temp2, auz = temp3;
	   for(int j = 0; j < this.coluna; j++){
	   	aux.elemento = auy.elemento + auz.elemento;
		aux = aux.prox; auy = auy.prox; auz = auz.prox;
	   }
	   temp = temp.inf; temp2 = temp2.inf; temp3 = temp3.inf;
	 }
      }

      return resp;
   }

   public Matriz multiplicacao (Matriz m) {
      Matriz resp = null;
      if(this.coluna == m.linha){
      	resp = new Matriz(this.linha, m.coluna);
	Celula temp = resp.inicio, temp2 = m.inicio, temp3 = this.inicio;
	for(int i = 0; i < this.linha; i++){
		Celula aux = temp, auy, auz;
		int elementoTemp = 0;
		for(int j = 0; j < m.coluna; j++){
			auy = temp2; auz = temp3;
			for(int x = 0; x < this.coluna; x++){
				elementoTemp += auz.elemento * auy.elemento;
				auz = auz.prox;
				auy = auy.inf;
			}
			aux.elemento = elementoTemp;
			aux = aux.prox;
			temp2 = temp2.prox;
			temp3 = temp3.prox;
	  	}
		temp = temp.inf;
	}
      }

      return resp;
   }

   public boolean isQuadrada(){
      boolean ehQuadrada = false;
      if(this.linha == this.coluna) ehQuadrada = true;
      return ehQuadrada;
  }

   public void mostrarDiagonalPrincipal(){
      if(isQuadrada() == true){
	      Celula temp = this.inicio, aux = temp;
	      for(int i = 0; i < this.linha; i++){
	      	for(int j = 0; j <= i; j++, aux = aux.prox);
		System.out.print(aux.elemento);
	      }
	      System.out.print("\n");
      }
   }

   public void mostrarDiagonalSecundaria(){
   	if(isQuadrada() == true){
              Celula temp = this.inicio;
        for(int i = this.linha; i > 0; i--){
		Celula aux = temp;
		for(int j = i - 1; j >= 0; j--) aux = aux.prox;
		System.out.print(aux.elemento + ' ');
                temp = temp.inf;
      }
    }
  }
  public void printMatriz(){
  	Celula temp = this.inicio;
	for(int i = 0; i < this.linha; i++){
		Celula aux = temp;
		for(int j = 0; j < this.coluna; j++){
			System.out.print(aux.elemento + ' ');
			aux = aux.prox;
		}
		System.out.println("\n");
		temp = temp.inf;
	}
  }	  
}



public class Ex5{
	public static void main(String [] args){
		Scanner leia = new Scanner(System.in);
		int qtdMatrizes = leia.nextInt();
		qtdMatrizes = qtdMatrizes * 2;
		Matriz [] matrizes = new Matriz[qtdMatrizes];
		MyIO.println(matrizes.length);
		for(int i = 0; i < qtdMatrizes; i++){
			Matriz temp = new Matriz();
			int aux = leia.nextInt();
			int auy = leia.nextInt();
			matrizes[i] = new Matriz(aux, auy);
			matrizes[i] = temp.preencher(matrizes[i]);
		}
		for(int i = 0; i < qtdMatrizes/2; i = + 2){
			Matriz mult, soma;
			matrizes[i].mostrarDiagonalPrincipal();
			MyIO.println("banana");
			System.out.print("\n");
			matrizes[i].mostrarDiagonalSecundaria();
			MyIO.println("Limao");
			System.out.print("\n");
			soma = matrizes[i].soma(matrizes[i + 1]);
			mult = matrizes[i].multiplicacao(matrizes[i + 1]);
			soma.printMatriz();
			mult.printMatriz();
		}
		
	}

}
