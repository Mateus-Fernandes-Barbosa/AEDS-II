import java.io.IOException;
import java.io.RandomAccessFile;
class Arquivo{
	public static void LeitorDouble(RandomAccessFile arq, int qtdNumeros) throws IOException{
		for(int i = 0; i < qtdNumeros; i++){
			double n = MyIO.readDouble();
			arq.writeDouble(n);
		}
		arq.close();
	}
	public static void LendoInverso(RandomAccessFile arq, int qtdNumeros) throws IOException{
		for(int i = 0; i < qtdNumeros; i++){
			arq.seek((qtdNumeros - i - 1) * 8);
			double valor = arq.readDouble();
			int coersao = (int) valor;
			if(coersao == valor){
				MyIO.println(coersao);
			}
			else{
				MyIO.println(valor);
			}
		}
		arq.close();
	}
	public static void main(String [] args) throws IOException{
		int qtdNumeros = MyIO.readInt();
		RandomAccessFile arq = new RandomAccessFile("texto.txt", "rw");
		LeitorDouble(arq, qtdNumeros);
		arq = new RandomAccessFile("texto.txt","r");
		LendoInverso(arq, qtdNumeros);
	}
}
