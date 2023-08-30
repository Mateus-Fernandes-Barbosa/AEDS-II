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
			temp[i] = (int) palavra.charAt(i) + 3;
		}
		palavra = "";
		for(int i = 0; i < n; i++){
			palavra += (char)temp[i];
		}
		return palavra;
	}
	public static void main (String[] args){
//		MyIO.setCharset("UTF-8");
		String palavra, encriptada;
		palavra = MyIO.readLine();
		while(!Strcmp(palavra)){
			encriptada = CriptografiaCesar(palavra);
			MyIO.println(encriptada);
			palavra = MyIO.readLine();
		}	

	}
}
