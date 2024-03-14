import java.util.Random;
class AlteracaoAleatoria{
	public static Random gerador = new Random(); 
	public static char Sorteador(){
		char c = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
		return c;
	}
	public static String Aleatorizador(String palavra, char letra1,char letra2){
		int n = palavra.length();
		String aleatorizada = "";
		for(int i = 0; i < n; i++){
			 char c = palavra.charAt(i);
			 if(c == letra1){
				 aleatorizada += letra2;
			 }
			 else{
				 aleatorizada += c;
			 }
		}
		return aleatorizada;
	}
	public static boolean Strcmp(String palavra){//Função para comparar strings
		boolean resp = false;
		if(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
			resp = true;
		}
		return resp;
	}
	public static void main(String [] args){
		gerador.setSeed(4);
		String palavra, aleatorizada;
		palavra = MyIO.readLine();
		while(!Strcmp(palavra)){
			char letra1 = Sorteador(), letra2 = Sorteador();
			aleatorizada = Aleatorizador(palavra, letra1, letra2);
			MyIO.println(aleatorizada);
			palavra = MyIO.readLine();

		}


	}
}
