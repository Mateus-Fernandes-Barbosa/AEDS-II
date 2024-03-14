class Is{
	public static boolean Vogal(String palavra){
		int n = palavra.length();
		boolean resp = true;
		for(int i = 0; i < n; i++){
			if(palavra.charAt(i) != 'A' 
			&& palavra.charAt(i) != 'E'
			&& palavra.charAt(i) != 'I'
			&& palavra.charAt(i) != 'O'
			&& palavra.charAt(i) != 'U'
                        && palavra.charAt(i) != 'a' 
                        && palavra.charAt(i) != 'e'
                        && palavra.charAt(i) != 'i'
                        && palavra.charAt(i) != 'o'
			&& palavra.charAt(i) != 'u'){
				resp = false;
			}

		}
		return resp;
	}
	public static boolean Real(String palavra){
		int n = palavra.length();
		boolean resp = true;
		for(int i = 0; i < n; i++){
			if(palavra.charAt(i) != '0'
                   		   && palavra.charAt(i) != '1'
                      	 	   && palavra.charAt(i) != '2'
	        	           && palavra.charAt(i) != '3'
        	        	   && palavra.charAt(i) != '4'
		                   && palavra.charAt(i) != '5'
                		   && palavra.charAt(i) != '6'
		                   && palavra.charAt(i) != '7'
                		   && palavra.charAt(i) != '8'
		                   && palavra.charAt(i) != '9' 
	        		   && palavra.charAt(i) != ','){
					resp = false;
				   }
		}
		return resp;
	}
	public static boolean Inteiro(String palavra){
		int n = palavra.length();
		boolean resp = true;
		for(int i = 0; i < n; i++){
                        if(palavra.charAt(i) != '0'
                        && palavra.charAt(i) != '1' 
                        && palavra.charAt(i) != '2'
                        && palavra.charAt(i) != '3'
                        && palavra.charAt(i) != '4'
                        && palavra.charAt(i) != '5'
                        && palavra.charAt(i) != '6'
                        && palavra.charAt(i) != '7'
                        && palavra.charAt(i) != '8'
                        && palavra.charAt(i) != '9'
			/*&& palavra.charAt(i) != '-'*/){
				resp = false;
			}
		}
		return resp;
	}
	public static boolean Consoante(String palavra, boolean X1, boolean X3, boolean X4){
		int n = palavra.length();
		boolean resp = true;
		for(int i = 0; i < n; i++){
			if((palavra.charAt(i) != '-'
                        && palavra.charAt(i) != '_'
                        && palavra.charAt(i) != '?'
                        && palavra.charAt(i) != '!'
                        && palavra.charAt(i) != '*'
                        && palavra.charAt(i) != '+'
                        && palavra.charAt(i) != '='
                        && palavra.charAt(i) != '('
                        && palavra.charAt(i) != ')'
                        && palavra.charAt(i) != '.'
			&& palavra.charAt(i) != ','
			&& palavra.charAt(i) != '/'
			&& (int) palavra.charAt(i) != -61 
			&& (int) palavra.charAt(i) != -17)
			&& 
			(X1 == true 
			|| X3 == true
			|| X4 == true)){
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
		String palavra;
		palavra = MyIO.readLine();
		boolean X1 = Vogal(palavra), X3 = Inteiro(palavra);
		boolean X4 = Real(palavra), X2 = Consoante(palavra,X1,X3,X4);
		while(!Strcmp(palavra)){
		if(X1 == true){
			MyIO.println("SIM\nNAO\nNAO\nNAO");
		}
		else if(X3 == true){
			MyIO.println("NAO\nNAO\nSIM\nSIM");
		}
		else if(X4 == true){
			MyIO.println("NAO\nNAO\nNAO\nSIM");
		}
		else if(X2 == true){
			MyIO.println("NAO\nSIM\nNAO\nNAO");
		}
		else{
			MyIO.println("NAO\nNAO\nNAO\nNAO");
		}
		palavra = MyIO.readLine();
		X1 = Vogal(palavra);
		X3 = Inteiro(palavra);
		X4 = Real(palavra);
		X2 = Consoante(palavra, X1, X2, X3);
	}
	}
}
