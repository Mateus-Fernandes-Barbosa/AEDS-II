/*Palindromo
 * Mateus Fernandes Barbosa
 * 22/08/2023
 */

class Palindromo{
	public static boolean EhPalindromo(String palavra){
		boolean resp = true;
		String metade1 = "", metade2 = "";
		int n = palavra.length();
		for(int i = 0; i < n/2; i++){ //Realizando a inversão da 2ª metade e a divisão de "palavra" em duas outras Strings
			metade1 += palavra.charAt(i);
			metade2 += palavra.charAt(n - i - 1);
		}
		for(int i = 0; i < n/2; i++){
			if(metade1.charAt(i) != metade2.charAt(i)){
				i = n/2;
				resp = false;
			}
		}
		return resp;
	}
	public static boolean Strcmp(String palavra){//Função para comparar strings
		boolean resp = false;
		if(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
			resp = true;
		}
		return resp;
	}	
	public static void main(String [] args){
		MyIO.setCharset("UTF-8");
		String palavra = MyIO.readLine();
		while(!Strcmp(palavra)){	
			if(!EhPalindromo(palavra)){
				MyIO.println("NAO");
			}
			else{
				MyIO.println("SIM");
			}
			palavra = MyIO.readLine();	
		}
	}
}

