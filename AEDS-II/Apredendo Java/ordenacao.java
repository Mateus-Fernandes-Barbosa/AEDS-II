class ordenacao{
	public static int [] array = {1,6,7,5,3,4,2};
	public static int n = 7;
	public static void main(String [] args){
		int aux;
		for(int j = 0; j < n - 1; j++){
			for(int i = j + 1; i < n; i++){
				if(i < n){
					if(array[j] > array[i]){
						aux = array[i];
						array[i] = array[j];
						array[j] = aux;
					}
				}	
			}
		}
		for(int i = 0; i < n; i++){
			System.out.println(array[i]);
		}

	}
}
		

