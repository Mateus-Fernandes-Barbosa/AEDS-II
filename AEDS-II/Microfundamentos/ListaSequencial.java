//import java.util.Scanner;
class ListaSequencial{
//	public static Scanner leia = new Scanner(System.in);
//	Utilizar linha acima em caso de não ter a class MyIO;
	private int [] array;
	private int n;
	private int contadorInicio = 0, contadorFim = 0;
	public int TamArray(){
	       System.out.println("Determine o tamanho da lista: ");
	       int valor = MyIO.readInt();
	       return valor;
	}
	private void AumentaTamArray(){
		int [] temp = new int[n];
		for(int i = 0; i < n; i++){
			temp[i] = array[i];
		}
		array = new int [++n];
		for(int i = 0; i < n - 1; i++){
			array[i] = temp[i];
		}
		n = array.length;
	}
	private void AumentaTamArray(int posicao){
		int [] temp = new int [n];
		for(int i = posicao; i < n; i++){
			temp[i] = array[i];
		}
		array = new int [++n];
		for(int i = posicao; i < n - 1; i++){
			array[i] = temp[i];
		}
		n = array.length;
	}
	public void InserirInicio(int valor){
		if(contadorInicio + contadorFim >= n){
			AumentaTamArray();
		}
		if(array[0] != 0){ //verificando se já há algum valor na posição 0, em caso afirmativo, todos os valores contidos na lista são mandados uma posição para     frente
				int [] temp = new int [n];
			for(int i = 0; i < n; i++){
				temp[i] = array[i];
				//MyIO.println("temp: "+temp[i]); Comentário para verificar se o valor da variável temporária está seguindo o esperado
			}
			for(int i = 0; i < n - 1 - contadorFim; i++){
				array[i + 1] = temp[i];
			}
		}
		array[0] = valor;
		contadorInicio++;
	}
	public void InserirFim(int valor){//apenas acrescenta-se uma posição ao array e posiciona-se o valor desejado na última posição
		if(contadorInicio + contadorFim >= n){
			AumentaTamArray();
		}
		if(array[n - 1] != 0){
			int [] temp = new int [n];
			for(int i = 0; i < n; i++){
				temp[i] = array[i];
			}
			for(int i = n - 1; i > contadorInicio; i--){
				array[i - 1] = temp[i];
			}
		}
		array[n - 1] = valor;
		contadorFim++;
	}
	public void Inserir(int valor, int posicao){
		posicao = posicao - 1;
		boolean error = false;
		if(posicao >= n || posicao < 0){
			MyIO.println("Erro! Valor inválido!");
		}
		else if(contadorInicio + contadorFim >= n){
			MyIO.println("Erro! limite atingido com inserção, tente com outra operação");
			error = true;
		}
		else if(array[posicao] != 0){
			for(int i = contadorInicio + 1; i < ( n - contadorFim - 1); i++){
				array[i + 1] = array[i];
			}
		}
		if(!error){
			array[posicao] = valor;
			contadorInicio++;
		//	contadorFim++;
		}
	}
	public void Mostrar(){
		MyIO.println("Aqui está sua lista: ");
		for(int i = 0; i < n; i++){
			MyIO.println("Posicao["+(i + 1)+"]: "+array[i]);
		}
	}
	ListaSequencial(int valor){
		array = new int [valor];
		n = valor;
	}
	ListaSequencial(){
		array = new int [TamArray()];
		n = array.length;
	}

}
