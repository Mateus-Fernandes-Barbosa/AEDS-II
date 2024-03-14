//import java.io.File;
import java.io.RandomAccessFile;

/*
 * Objetivo: Criar um algoritmo capaz de armazenar um número n de valores reais e um arquivo de texto.
 * Depois lê-los de trás para frente os imprimindo.
 */

public class Arquivo2{
	private static void LeArq(String arq, int qtdReais) throws Exception{
		RandomAccessFile file = new RandomAccessFile(arq, "r");
		for(int i = 0; i < qtdReais; i++){
			file.seek((qtdReais - i - 1) * 4);
			float f = file.readFloat();
			int j = (int) f;
			if(f - j > 0){				/*Nesse trecho, utilizo o int j para descobrir se o valor de f é redondo ou não, 
								  ou seja, contém valores decimais ou não*/
				System.out.println(f);
			}		
			else{
				System.out.println(j);
			}
		}
	}

	private static void EscreveArq(String arq, int qtdReais) throws Exception{
		RandomAccessFile file = new RandomAccessFile(arq, "rw");
		for(int i = 0; i < qtdReais; i++){
                        float f = MyIO.readFloat();
                        file.writeFloat(f);
                }
		file.close();
	}

	public static void main (String [] args)throws Exception{
		String file = "texto.txt";
		int qtdReais = MyIO.readInt();
		EscreveArq(file, qtdReais);
		LeArq(file, qtdReais);
	}

}
