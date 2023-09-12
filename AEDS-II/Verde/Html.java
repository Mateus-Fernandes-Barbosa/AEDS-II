import java.io.*;
import java.net.*;
class Html{
	public static int a = 0, e = 0, i = 0, o = 0, u = 0, a1 = 0, e1 = 0, i1 = 0, o1 = 0, u1 = 0,a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0,a3 = 0, e3 = 0, i3 = 0, o3 = 0, u3 = 0,a4 = 0, e4 = 0, i4 = 0, o4 = 0, u4 = 0, table = 0, br = 0, consoante = 0; 
       //Tabela referência de variáveis:
       //Na ausência de números, indica-se o caracter padrão
       //(`) = 1
       //(´) = 2
       //(~) = 3
       //(^) = 4
        public static void Contador(String palavra){
		int n = palavra.length();
		//palavra = palavra.toLowerCase();
		for(int j = 0; j < n; j++){
			if((int) palavra.charAt(j) == 195){
				switch((int) palavra.charAt(j + 1)){
					case 160:
						a1++;
						break;
					case 168:
						e1++;
						break;
					case 172:
						i1++;
						break;
					case 178:
						o1++;
						break;
					case 185:
						u1++;
						break;
					case 161:
						a2++;
						break;
					case 169:
						e2++;
						break;
					case 173:
						i2++;
						break;
					case 179:
						o2++;
						break;
					case 186:
						u2++;
						break;
					case 163:
						a3++;
						break;
					case 181:
						o3++;
						break;
					case 162:
						a4++;
						break;
					case 170:
						e4++;
						break;
					case 174:
						i4++;
						break;
					case 180:
						o4++;
						break;
					case 187:
						u4++;
						break;
				}
			}
			else if((int) palavra.charAt(j) == 60){
				switch((int) palavra.charAt(j + 1)){
					case 116:
						table++;
						i += 6;
						break;
					case 98:
						br++;
						i+= 3;
						break;
				}
			}
			else{
				switch(palavra.charAt(j)){
					case 'a': 
						a++;
						break;
					case 'e':
						e++;
						break;
					case 'i':
						i++;
						break;
					case 'o':
						o++;
						break;
					case 'u':
						u++;
						break;
                                        case 'b':
                                                consoante++;
                                                break;
                                        case 'c':
                                                consoante++;
                                                break;
                                        case 'd':
                                                consoante++;
                                                break;
                                        case 'f':
                                                consoante++;
                                                break;
                                        case 'g':
                                                consoante++;
                                                break;
                                        case 'h':
                                                consoante++;
                                                break;
                                        case 'j':
                                                consoante++;
                                                break;
                                        case 'k':
                                                consoante++;
                                                break;
                                        case 'l':
                                                consoante++;
                                                break;
                                        case 'm':
                                                consoante++;
                                                break;
                                        case 'n':
                                                consoante++;
                                                break;
                                        case 'p':
                                                consoante++;
                                                break;
                                        case 'q':
                                                consoante++;
                                                break;
                                        case 'r':
                                                consoante++;
                                                break;
                                        case 's':
                                                consoante++;
                                                break;
                                        case 't':
                                                consoante++;
                                                break;
                                        case 'v':
                                                consoante++;
                                                break;
                                        case 'w':
                                                consoante++;
                                                break;
                                        case 'x':
                                                consoante++;
                                                break;
                                        case 'y':
                                                consoante++;
                                                break;
                                        case 'z':
                                                consoante++;
                                                break;

				}
			}
		}
	}
	public static boolean Strcmp(String palavra){//Função para comparar strings
		boolean resp = false;
		if(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
			resp = true;
		}
		return resp;
	}
public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
	public static void main(String [] args){
		String nome, endereco, html;
		nome = MyIO.readLine();
		while(!Strcmp(nome)){
			Contador(nome);
			endereco = MyIO.readLine();
			html = getHtml(endereco);
			Contador(html);
			MyIO.println("a(" + a + ") " + "e(" + e + ") " + "i(" + i + ") " + "o(" + o + ") " + "u(" + u + ") " + "á(" + a2 + ") " + "é(" + e2 + ") " + "í(" + i2 + ") " + "ó(" + o2 + ") " + "ú(" + u2 + ") " + "à(" + a1 + ") " + "è(" + e1 + ") " + "ì(" + i1 + ") " + "ò(" + o1 + ") " + "ù(" + u1 + ") " + "ã(" + a3 + ") " + "õ(" + o3 + ") " + "â(" + a4 + ") " + "ê(" + e4 + ") " + "î(" + i4 + ") " + "ô(" + o4 + ") " + "û(" + u4 + ") " + "consoante(" + consoante + ") " + "<br>(" + br + ") " + "<table>(" + table + ") " + nome);
			nome = MyIO.readLine();
			//int n = nome.length();
			/*for(int i = 0; i < n; i++){ //Verificador do valor ASCII de caractéres especiais
				MyIO.println(nome.charAt(i) + ":" + (int) nome.charAt(i));	
			}*/
		}
	}
}
