class teste{
	public static void main(String [] args){
		ListaSequencial lista = new ListaSequencial(6);
		lista.InserirInicio(1);
		lista.InserirInicio(2);
		lista.InserirFim(6);
		lista.InserirFim(5);
		lista.Inserir(3, 3);
		lista.Inserir(4, 4);
		lista.Inserir(9, 2);
		lista.Mostrar();
	}
}

