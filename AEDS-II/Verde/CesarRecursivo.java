class CesarRecursivo{
	public static String Cesar(String palavra){
		int n = palavra.length(), i = 0;
		int [] temp = new int[n];
		Char2Int(palavra, n, i, temp);
		palavra = "";
	       	char [] aux = new char[n];
		Int2Char(aux, n, i, temp);
		for(i = 0; i < n; i++){
			palavra += aux[i];
		}
		return palavra;
	}
	public static void Char2Int(String palavra, int n, int i, int [] temp){
		if(i < n){
			temp[i] = (int) palavra.charAt(i) + 3;
			Char2Int(palavra, n, ++i, temp);
		}
	}
	public static void Int2Char(char [] aux, int n, int i, int [] temp){
	       if(i < n){
	       		aux[i] = (char) temp[i];
	 		Int2Char(aux, n, ++i, temp);
		}
	}
	public static boolean Strcmp(String palavra){//Função para comparar strings
		boolean resp = false;
		if(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
			resp = true;
		}
		return resp;
	}
	public static void main(String [] args){
		String palavra;
		palavra = MyIO.readLine();
		while(!Strcmp(palavra)){
			palavra = Cesar(palavra);
			MyIO.println(palavra);
			palavra = MyIO.readLine();
		}
	}
}

			 
