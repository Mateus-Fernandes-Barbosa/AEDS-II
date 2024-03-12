class Valor{
	int valor;

	public Valor(){
		this.valor = 10;
	}
}


public class Teste2{
	public static void mudaPos(Valor[] x){
		for(int i=0, j = 4; i<j; i++, j--){
			Valor tmp = x[i];
			x[i] = x[j];
			x[j] = tmp;
		}
	}

	public static void printValores(Valor[] x){
		for(int i=0; i<5; i++){
			MyIO.println(x[i].valor);
		}
	}
	public static void main(String [] args){
		Valor[] valores = new Valor[5];
		for(int i=0; i<5; i++){
			valores[i] = new Valor();
			valores[i].valor = i;
		}
		printValores(valores);
		mudaPos(valores);
		printValores(valores);


	}

}
