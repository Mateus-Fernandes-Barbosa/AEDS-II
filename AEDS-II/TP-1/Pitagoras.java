import java.io.IOException;
class Pitagoras{
	private static char principal = (char) 53, publico = (char) 51, privado = (char) 52;
	public static boolean Strcmp(String palavra){//Função para comparar strings
                boolean resp = false;
                if(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
			resp = true;
                }
		return resp;
        }
	private static int ConfereChave(int key){
		if(((key * key) + ((privado - '0') * (privado - '0'))) == ((principal - '0') * (principal - '0'))){
			key = principal - '0';
		}
		else{
			MyIO.println("chave pública incorreta!");
		}
		return key;
	}
	private static int ConverteChave(int key){
		double resultado = Math.sqrt((key * key) + ((publico - '0') * (publico - '0')));
		key = (int) resultado;
		return key;
	}
	public static String CriptografiaCesar(String palavra, int valor){
		int n = palavra.length();
		int [] temp = new int [n];
		for(int i = 0; i < n; i++){
			if(palavra.charAt(i) != ' '
			   && palavra.charAt(i) != 'á'
                           && palavra.charAt(i) != 'ã'
                           && palavra.charAt(i) != 'Á'
                           && palavra.charAt(i) != 'é'
                           && palavra.charAt(i) != 'É'
                           && palavra.charAt(i) != 'ê'
                           && palavra.charAt(i) != 'Ê'
                           && palavra.charAt(i) != 'í'
                           && palavra.charAt(i) != 'Í'
                           && palavra.charAt(i) != 'ô'
                           && palavra.charAt(i) != 'Ô'
                           && palavra.charAt(i) != 'õ'
                           && palavra.charAt(i) != 'Õ'
                           && palavra.charAt(i) != '*'
			   && palavra.charAt(i) != 'ç'
			   && palavra.charAt(i) != 'Ç'
                           && palavra.charAt(i) != '-'
                           && palavra.charAt(i) != '.'
                           && palavra.charAt(i) != '+'
                           && palavra.charAt(i) != ','){	
				temp[i] = (int) palavra.charAt(i) + valor;
		//		MyIO.println("ASCCI Letra: "+temp[i]); Teste de conversão
				if((int) palavra.charAt(i) + valor > 121){
					temp[i] = ((((int) palavra.charAt(i) + valor) + 133) - 255) + 33;
		//			MyIO.println("ASCCI Letra: "+temp[i]); Teste de conversão

				}
			}
			else{
				temp[i] = palavra.charAt(i);
			}
		}
		palavra = "";
		for(int i = 0; i < n; i++){
			palavra += (char)temp[i];
		}
		return palavra;
	}
	public static String DescriptografiaCesar(String palavra, int key){
		int n = palavra.length();
                int [] temp = new int [n];
		//key = Math.sqrt((key * key) + ((publico - '0') * (publico - '0')));
                for(int i = 0; i < n; i++){
			if(palavra.charAt(i) != ' ' 
			   && palavra.charAt(i) != 'á'
			   && palavra.charAt(i) != 'ã'
			   && palavra.charAt(i) != 'Á'
			   && palavra.charAt(i) != 'é'
			   && palavra.charAt(i) != 'É'
			   && palavra.charAt(i) != 'ê'
			   && palavra.charAt(i) != 'Ê'
			   && palavra.charAt(i) != 'í'
			   && palavra.charAt(i) != 'Í'
			   && palavra.charAt(i) != 'ô'
			   && palavra.charAt(i) != 'Ô'
			   && palavra.charAt(i) != 'õ'
			   && palavra.charAt(i) != 'Õ'
			   && palavra.charAt(i) != '*'
			   && palavra.charAt(i) != '-'
			   && palavra.charAt(i) != '.'
			   && palavra.charAt(i) != '+'
			   && palavra.charAt(i) != ','
			   && palavra.charAt(i) != 'ç'
			   && palavra.charAt(i) != 'Ç'){
                        	temp[i] = (int) palavra.charAt(i) - key;
		//		MyIO.println("ASCCI Letra: "+temp[i]); Teste de conversão
				if((int) palavra.charAt(i) - key < 38){
					temp[i] = ((((int) palavra.charAt(i) - 33) + 255) - 133) - key;
		//			MyIO.println("ASCCI Letra: "+temp[i]);	Teste de conversão
				}
			}
			else{
				temp[i] = palavra.charAt(i);
			}
                }
                palavra = "";
                for(int i = 0; i < n; i++){
                        palavra += (char)temp[i];
                }
                return palavra;
	}
	public static int menu(){
		int opcao;
		MyIO.println("Escolha uma das opções abaixo:"+
			     "\n[0] Sair"+
			     "\n[1] Criptografar"+
			     "\n[2] Descriptografar");
		opcao = MyIO.readInt();
		return opcao;
	}
	public final static void clearConsole() throws IOException, InterruptedException {
        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else 	{
      		new ProcessBuilder("clear").inheritIO().start().waitFor();
        	}
    	}
	public static void main (String[] args) throws IOException,InterruptedException{
		MyIO.setCharset("UTF-8");
		String palavra, resultado;
		int opcao, key;
		do{
			clearConsole();
			opcao = menu();
			switch(opcao){
				case 0:
					MyIO.println("Flw!");
					break;
				case 1:
					MyIO.println("Escreva a mensagem:");
					palavra = MyIO.readLine();
					MyIO.println("Escreva a chave:");
					key = MyIO.readInt();
					key = ConfereChave(key);
					if(key == principal - '0'){
						resultado = CriptografiaCesar(palavra, key);
						MyIO.println("Resultado: "+resultado);
						MyIO.readChar("Press Enter to continue\n");
					}
					break;
				case 2:
					MyIO.println("Escreva a mensagem:");
					palavra = MyIO.readLine();
					MyIO.println("Escreva a chave:");
					key = MyIO.readInt();
					key = ConverteChave(key);
					resultado = DescriptografiaCesar(palavra, key);
					MyIO.println("Resultado: "+resultado);
					MyIO.readChar("Press Enter to continue\n");
					break;
			}
		}while(opcao != 0);	
	}
}
