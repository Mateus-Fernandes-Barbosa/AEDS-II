class Ex15{
	public static void main(String [] args){
		int n = 512, cont = 0, a = 1;
		for(int i = n; i > 0; i /= 2){
			a *=2;
			cont++;
		}
		System.out.println("Qtd de multiplicações: "+cont);
	}
}
