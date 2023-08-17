class selecao{
	public static int [] array = {2,3,5,4,6,7,1,8}; 
	public static int cont = 0;
	public static void swap(int a, int b){
		int temp = array[b];
		cont++;
		array[b] = array[a];
		cont++;
		array[a] = temp;
		cont++;
	}
	public static void main(String args[]){
		int n = 6;
		for (int i = 0; i < n - 1; i++){
			int menor = i;
			for(int j = i + 1; j < n; j++){
				if(array[menor] > array[j]){
					menor = j;
				}
			}
			swap(menor, i);
		}
		System.out.println("teoria: "+(3*n - 3));
		System.out.println("pratica: "+cont);
	}
}
