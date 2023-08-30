class Cesar{
	public static boolean Strcmp(String palavra){//Função para comparar strings
                boolean resp = false;
                if(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
			resp = true;
                }
		return resp;
        }
	public static String CriptografiaCesar(String palavra){
		int n = palavra.length();
		int [] temp = new int [n];
		for(int i = 0; i < n; i++){
			if(palavra.charAt(i) != ' '){	
				temp[i] = (int) palavra.charAt(i) + 9;
				if((int) palavra.charAt(i) + 9 > 117){
					temp[i] = (((int) palavra.charAt(i) + 9 + 137) - 255) + 33;
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
                for(int i = 0; i < n; i++){
			if(palavra.charAt(i) != ' '){
                        	temp[i] = (int) palavra.charAt(i) - key;
				if((int) palavra.charAt(i) - key < 33){
					temp[i] = (((int) palavra.charAt(i) - 33) + 255) - 137 - 9;
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
	public final static void clearConsole() //Método pego da internet
{
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {
        //  Handle any exceptions.
    }
}
	public static void main (String[] args){
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
					resultado = CriptografiaCesar(palavra);
					MyIO.println("Resultado: "+resultado);
					break;
				case 2:
					MyIO.println("Escreva a mensagem:");
					palavra = MyIO.readLine();
					MyIO.println("Escreva a chave:");
					key = MyIO.readInt();
					resultado = DescriptografiaCesar(palavra, key);
					MyIO.println("Resultado: "+resultado);
					break;
			}
		}while(opcao != 0);	
	}
}
