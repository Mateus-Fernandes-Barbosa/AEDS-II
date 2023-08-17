class repeticao{
	public static void main (String [] args){
		int i = 0, valor = 10;
		while(i < 3){
			valor--;
			i++;
			valor--;
		}
		System.out.println("\n"+valor+"\n");
		valor = 10;
		i = 0;
		do{
			valor--;
			i++;
			valor--;
		}while(i < 3);
                System.out.println("\n"+valor+"\n");
	}
}
