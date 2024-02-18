import java.util.Scanner;
class lab1{
	public static Scanner leia = new Scanner(System.in);
	
	public static int contadorMaiusculas(String palavra){
		int contador = 0;
		for(int i = 0; i < palavra.length(); i++){
			char c = palavra.charAt(i);
			if(c <= 'Z' && c >= 'A'){
				contador++;
			}
		}
		return contador;
	}

	public static void main(String [] args){
		String palavra = leia.nextLine();
		while(!palavra.equals("FIM")){
			int contador = contadorMaiusculas(palavra);		
			System.out.println(contador);
			palavra = leia.nextLine();
		}	
	}
}
