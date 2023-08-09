import java.util.Scanner;

public class nivelamento {
	static Scanner read = new Scanner(System.in);

	static void slide02a () {
		int [] array = {1,2,3,4,5,6,7,8,9,10};
		int x = 3;
		int n = array.length;
		boolean contido = false;

		for (int i = 0; i < array.length; i++) {
			if (array [i] == x) {
				contido = true; 
				i = 10; 
			}
		}	
		System.out.println(contido);
	}
	
	static void slide02b () {
                int [] array = {1,2,3,4,5,6,7,8,9,10};
                int x = 3;
                boolean contido = false;
		int n = array.length;
		int meio = 0;
        	int superior = n - 1;
        	int inferior = 0;
		

	        while (inferior <= superior) {
             		meio = (superior + inferior) / 2;
            		if (x == array[meio]) {
                		contido = true;
                		inferior = n;
            		} else if (x > array[meio]) {
             		   	inferior = meio + 1;
            		}	
            		else {
                		superior = meio - 1;
            		}
        	}
                System.out.println(contido);
    	
    	}

	static void slide03a () {
		int [] array = {1,2,3,4,5,6,7,8,9,10};
		int menor = array [0];
		int maior = array [0];
		int n = array.length; 
		
		for(int i = 1; i < array.length; i++) { 
			if (menor > array [i]) {
			       menor = array [i];
			}
		}
		for (int i = 1; i<array.length; i++) {
			if (maior < array [i]) {
				maior = array [i];
			}
		}
		System.out.println ("Numero maior, " + maior + " , numero menor, " + menor);
	}

	static void slide03b () {
		int [] array = {1,2,3,4,5,6,7,8,9,10};
                int menor = array [0];
                int maior = array [0];
                int n = array.length;

                for(int i = 1; i < array.length; i++) {
                        if (menor < array [i]) {
                               menor = array [i];
                        }
                        else if(maior > array [i]) {
                                maior = array [i];
                        }
                }
                System.out.println ("Numero maior, " + maior + " , numero menor, " + menor);

	}
		

	/*
	 	Slide 4 :
		boolean doidao (char c){
			boolean resp= false;
			int v = (int) c;
			if (v == 65 || v == 69 || v == 73 || v == 79 || v == 85 || v == 97 || v == 101 || v ==105 ||
			v == 111 || v == 117){
				resp = true;
			}
			return resp;
		}
		Resposta: O codigo verifica se o caractere c se encontra entre um dos caracteres selecionados, por meio de uma comparação de inteiros entre o valor ASCII do caracter c e dos demais caracteres.

		Slide 7 :
		boolean isConsoante(String s, int n){
			boolean resp= true;
			if (n!=s.length()){
				if (s.charAt(n)<'0' || s.charAt(n)>'9'){
					if (isVogal(s.charAt(n)) == true){
						resp= false;
					} else{
						resp=isConsoante(s, n+1);
					}
				} else {
					resp=false;
				}
			}
			return resp;
		}
	*/
	static int menu () {
		int op = 0;
		
		do {
			System.out.print("\nEscolha uma opção que deseja ver : "+
					"\n\t [0] -- Parar"+
					"\n\t [1]" +
					"\n\t [2]" +
					"\n\t [3]" +
					"\n\t [4]" +
					"\n\t [5] Arquivos" +
					"\n\t [6] Tipo de Triângulo"+
					"\n\t [7] Maior e Menor"+
					"\n\t [8] Lista de If's e Else's"+
					"\n\t Opção : ");
			op = read.nextInt();
		}while (op < 0 );
		return op;
	}

		public static void main (String args []){
		int opc = 0;
			opc = menu();
			switch (opc){
				case 0:
					break;
				case 1:
					slide02a();
					break;
				case 2:
					slide02b();
					break;
				case 3: 
					slide03a();
					break;
				case 4: 
					slide03b();
					case 5:
					CopiaArquivos();
					break;
				case 6:
					TipoTriangulo();
					break;
				case 7:
					MaiorEMenor();
					break;
				case 8:
					ListaIfs();
					break;

			}
	}




						/*Questões de Arquivos*/
					
	public static void CopiaArquivos(){
		Arq.openWrite("teste.txt");
		Arq.println("Banana\n"+"Maçã\n"+"Limão\n"+"Laranja\n");
		String lista = "";
		while(Arq.hasNext() == true){
			lista += Arq.readChar();
		}
		Arq.close();
		Arq.openWrite("copiateste.txt");
		Arq.println(lista);
		Arq.close();
	}	
						/*Questão qual o tipo de triângulo ? */
	public static void TipoTriangulo(){
		int ladoA, ladoB, ladoC;
		boolean error = false;
		do{	
			System.out.println("Digite o valor do ladoA: ");
			ladoA = read.nextInt();
			System.out.println("Digite o valor do ladoB: ");
			ladoB = read.nextInt();
			System.out.println("Digite o valor do ladoC: ");
			ladoC = read.nextInt();
			if(ladoA + ladoC < ladoB || ladoB + ladoC < ladoA || ladoA + ladoB < ladoC){
				error = true;
			}
			if(error == true){
				System.out.println("Valores inválidos, tente novamente!");
			}
		}while(error == true);
			if(ladoA == ladoC && ladoC == ladoB){
				System.out.println("O triângulo é esquilátero");
			}
			else if(ladoA == ladoC && ladoC != ladoB || ladoA == ladoB && ladoB != ladoC || ladoB == ladoC && ladoC != ladoA){
				System.out.println("O triângulo é isóceles");
			}
			else{
				System.out.println("O triângulo é escaleno");
			}
	}
				
							/*Questão qual o maior ? e o menor ?*/
	public static void MaiorEMenor(){
		int numeroA, numeroB, numeroC, maior, menor;
		System.out.println("Digite o valor do numeroA: ");
                numeroA = read.nextInt();
                System.out.println("Digite o valor do numeroB: ");
                numeroB = read.nextInt();
		System.out.println("Digite o valor do numeroC: ");
		numeroC = read.nextInt();
		
		if(numeroA > numeroB && numeroB > numeroC || numeroA > numeroC && numeroC > numeroB ){
			maior = numeroA;
		}
		else if(numeroB > numeroC && numeroC > numeroA || numeroB > numeroA && numeroA > numeroC){
			maior = numeroB;
		}
		else{
			maior = numeroC;
		}
		if(numeroA > numeroB && numeroB > numeroC || numeroB > numeroA && numeroA > numeroC){
			menor = numeroC;
		}
		else if(numeroB > numeroC || numeroC > numeroA){
			menor = numeroA;
		}
		else{
			menor = numeroB;
		}

		System.out.println("Maior: "+maior+"\nMenor: "+menor);
	}
	
							/*Exercício de comparação de números com um tanto de regra*/
	public  static void ListaIfs(){
		int numeroA, numeroB, resultado;
                System.out.println("\nDigite o valor do numeroA: ");
                numeroA = read.nextInt();
                System.out.println("\nDigite o valor do numeroB: ");
                numeroB = read.nextInt();
		if(numeroA > 45 || numeroB > 45){
			resultado = numeroA+numeroB;
			System.out.println("\nresultado da soma: " + resultado);
		}
		else if(numeroA > 20 && numeroB > 20){
			if(numeroA > numeroB){
				resultado = numeroA - numeroB;
				System.out.println("\nresultado da subtração: " + resultado);
			}
			else{
				resultado = numeroB - numeroA;
				System.out.println("\nresultado da subtração: " + resultado);
			}
		}
		else if(numeroA <  10 && numeroB > 0){
			resultado = numeroA/numeroB;
			System.out.println("\nresultado da divisão: " + resultado);
		}
		else if(numeroB < 10 && numeroA > 0){
			resultado = numeroA/numeroB;
			System.out.println("\nresultado da divisão: " + resultado);
		}
		else{
			System.out.println("\nMateus Fernandes Barbosa");
		}
	}

}
	
	
