import java.util.Scanner;

public class Espelho{

	public static Scanner leia = new Scanner(System.in);

	public static void main(String [] args){
		int base, fim;
		base = leia.nextInt();
		fim = leia.nextInt();
		while(base >= 0 && fim > 0){
			int tam = (fim - base + 1) * 2;
			int [] vetor = new int[tam];
			for(int i = 0; i < tam/2; i++){
				vetor[i] = base;
				vetor[tam - i - 1] = base;
				base++;
			}
			for(int i = 0; i < tam; i++){
				System.out.print(vetor[i]);
			}
			System.out.print("\n");
			base = leia.nextInt();
			fim = leia.nextInt();
		}
	}
}
