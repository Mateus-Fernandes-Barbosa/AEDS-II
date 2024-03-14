public class Is2{
	
	private static boolean IsVogal(String entrada){
		entrada = entrada.toLowerCase();
		//System.out.println("entrada1: " + entrada);
		boolean resp = true;
		for(int i = 0; i < entrada.length(); i++){
			char c = entrada.charAt(i);
			if(c != 'a' && c != 'e' && c != 'i' && c != 'o'&& c != 'u') {
				resp = false;
				i = entrada.length();
			}
		}
		return resp;
	}

	private static boolean IsConsoante(String entrada){
                entrada = entrada.toLowerCase();
		//System.out.println("entrada2: " + entrada);
                boolean resp = true;
                for(int i = 0; i < entrada.length(); i++){
                        char c = entrada.charAt(i);
                        if(c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u' || (c >= '0' && c <= '9') ) {
                                resp = false;
                                i = entrada.length();
                        }
                }
                return resp;
        }
	
	private static boolean HasLetter(String entrada){ /*Criei essa função para evitar caracteres especiais como ç, ã, â, á, à, etc...*/
		entrada = entrada.toLowerCase();
		boolean resp = false;
		for(int i = 0; i < entrada.length(); i++){
			char c = entrada.charAt(i);
			if(c >= 'a' && c <= 'z'){
				resp = true;
				i = entrada.length();
			}
		}
		return resp;
	}

	private static int QtdDots(String entrada){
		int cont = 0;
		for(int i = 0; i < entrada.length(); i++){
			if(entrada.charAt(i) == '.'){
				cont++;
			}
		}
		return cont;
	}
	
	private static boolean IsInt(String entrada){
		boolean resp = true;
		if(HasLetter(entrada)){
			resp = false;
		}
		else{
			if(QtdDots(entrada) > 0){
				resp = false;
			}
		}
		/*else{
			float f = Float.parseFloat(entrada);
			int i = (int) f;	
			if(f - i > 0){
				resp = false;
			}
		}*/
		return resp;
	}

	private static boolean IsFloat(String entrada){
                boolean resp = true;
                if(HasLetter(entrada)){
                        resp = false;
                }
		else{
			if(QtdDots(entrada) > 1 || QtdDots(entrada) < 1){
				resp = false;
			}
		}
                /*else{
                        float f = Float.parseFloat(entrada);
                        int i = (int) f;
                        if(f - i == 0){
                                resp = false;
                        }
                }*/
                return resp;
        }


	public static void main(String [] args){
		String entrada = MyIO.readLine();
		while(!entrada.equals("FIM")){
			if(IsVogal(entrada)){
				System.out.println("SIM NAO NAO NAO");			
			}
			else if(IsConsoante(entrada)){
				System.out.println("NAO SIM NAO NAO");
			}
			else if(IsInt(entrada)){
				System.out.println("NAO NAO SIM NAO");
			}
			else if(IsFloat(entrada)){
				System.out.println("NAO NAO NAO SIM");
			}
			else{
				System.out.println("NAO NAO NAO NAO");
			}
			entrada = MyIO.readLine();
		}
	}

}
