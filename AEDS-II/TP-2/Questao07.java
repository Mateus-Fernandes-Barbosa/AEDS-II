import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

class Jogador{
	//valores privados
	private int id;
	private String nome;
	private int altura;
	private int peso;
	private String universidade;
	private int anoNascimento;
	private String cidadeNascimento;
	private String estadoNascimento;
	
	//Lista de Jogadores
	protected Jogador [] lista = new Jogador[3922];
	protected Jogador [] array;

	//Variáveis Acessórias
	public static int contador = 0;
	public static int numComp = 0;
	public static double inicio, fim;
	public static int tamArray;
	
	//Método Acessório
	private void AumentarTamArray(Jogador jogador){
    //MyIO.println("tamArray 2: "+tamArray);
		Jogador [] temp = new Jogador [tamArray];
		for(int i = 0; i < tamArray; i++){
      //MyIO.println("tamArray 3: "+tamArray);
			temp[i] = jogador.array[i];
		}
		jogador.array = new Jogador [tamArray + 1];
    //MyIO.println("tamArray 4: "+tamArray);
		for(int i = 0; i < tamArray; i++){
      //MyIO.println("tamArray 5: "+tamArray);
			jogador.array[i] = temp[i];
		}
    tamArray = jogador.array.length;
		temp = null;
	}

	//funções gets e sets
	public void setId(int valor){
		this.id = valor;
	}
	public void setPeso(int valor){
		this.peso = valor;
	}
	public void setNome(String palavra){
		this.nome = palavra;
	}
	public void setAltura(int valor){
		this.altura = valor;
	}
	public void setUniversidade(String palavra){
		this.universidade = palavra;
	}
	public void setBirth(int valor){
		this.anoNascimento = valor;
	}
	public void setCidade(String palavra){
		this.cidadeNascimento = palavra;
	}
	public void setEstado(String palavra){
		this.estadoNascimento = palavra;
	}
	public int getId(){
		return this.id;
	}
	public String getNome(){
		return this.nome;
	}
	public int getAltura(){
		return this.altura;
	}
	public int getPeso(){
		return this.peso;
	}
	public String getUniversidade(){
		return this.universidade;
	}
	public int getBirth(){
		return this.anoNascimento;
	}
	public String getCidade(){
		return this.cidadeNascimento;
	}
	public String getEstado(){
		return this.estadoNascimento;
	}

	//construtores
	Jogador(){
		setNome("Teste");
		setUniversidade("testando");
		setCidade("Testolandia");
		setEstado("Banana");
		setBirth(2077);
		setId(0);
		setAltura(0);
		setPeso(0);
	}
	Jogador(int id,int peso, int birth, int altura, String universidade, String cidade, String estado, String nome){
		setId(id);
		setBirth(birth);
		setAltura(altura);
		setUniversidade(universidade);
		setCidade(cidade);
		setEstado(estado);
		setNome(nome);
		setPeso(peso);

	}
	//Método Clone
	protected Jogador clone(){
		Jogador novo = new Jogador();
		novo.nome = this.nome;
		novo.id = this.id;
		novo.anoNascimento = this.anoNascimento;
		novo.cidadeNascimento = this.cidadeNascimento;
		novo.estadoNascimento = this.estadoNascimento;
		novo.altura = this.altura;
		return novo;
	}

	public void ler(String nomeArquivo) throws Exception {
		FileReader arq = new FileReader(nomeArquivo);
		BufferedReader leia = new BufferedReader(arq);
		String temp = leia.readLine();
		String linhas = "";
		int cont = 0,id, birth, altura, peso;
		String nome, universidade, estado, cidade;
		String [] campos = new String[9];
		//Jogador [] lista = new Jogador[3920];
		linhas = leia.readLine();
		while(linhas != null){
			for(int i = 0; i < 8; i++){
				if(i < 7){
					campos[i] = linhas.substring(0, linhas.indexOf(","));
					linhas = linhas.substring(linhas.indexOf(",") + 1, linhas.length());
				}
				else{
					campos[i] = linhas.substring(0, linhas.length());
				}
			}
			if(campos[0] != null){
				id = Integer.parseInt(campos[0]);
			}
			else{
				id = -1;
			}
                        if(campos[1] != ""){
                                nome = campos[1];
                        }
                        else{
                                nome = "-1";
                        }
			if(campos[2] != null){
				altura = Integer.parseInt(campos[2]);
                        }
                        else{
                                altura = -1;
                        }
			if(campos[3] != null){
				peso = Integer.parseInt(campos[3]);
                        }
                        else{
                                peso = -1;
                        }
			if(campos[4] != ""){
				universidade = campos[4];
                        }
                        else{
                                universidade = "-1";
                        }
			if(campos[5] != null){
				birth = Integer.parseInt(campos[5]);
			                        }
                        else{
                                birth = -1;
                        }
			if(campos[6] != ""){
				cidade = campos[6];
                        }
                        else{
                                cidade = "-1";
                        }
			if(campos[7] != ""){
				estado = campos[7];
                        }
                        else{
                                estado = "-1";
                        }
			this.lista[cont] = new Jogador(id, peso, birth, altura, universidade, cidade, estado, nome);
			cont++;
			linhas = leia.readLine();
		}
		leia.close();
		arq.close();
	}
	public void imprimir(int valor){
		if(this.lista[valor].getId() != -1){
			System.out.println(toString(valor));
		}
	}
	public Jogador criaArray(int valor){
                int id = this.lista[valor].getId();
                String nome = this.lista[valor].getNome();
                int peso = this.lista[valor].getPeso();
                int altura = this.lista[valor].getAltura();
                String universidade = this.lista[valor].getUniversidade();
                int birth = this.lista[valor].getBirth();
                String cidade = this.lista[valor].getCidade();
                String estado = this.lista[valor].getEstado();
		Jogador temp = new Jogador(id, peso, birth, altura, universidade, cidade, estado, nome);
		return temp;
	}
	public boolean Selecao(String valor){
		boolean resp = false;
		int n = contador;
		//MyIO.println("N: "+ n);
		for(int i = 0; i < n; i++){
			String nome = this.array[i].getNome();
			//MyIO.println("Nome: "+nome);
			if(nome.equals(valor)){
				numComp++;
				resp = true;
				i = n;
			}
		}
		return resp;
	}
	public String toString(int valor){
		int id = this.lista[valor].getId();
                String nome = this.lista[valor].getNome();
                int peso = this.lista[valor].getPeso();
                int altura = this.lista[valor].getAltura();
                String universidade = this.lista[valor].getUniversidade();
                int birth = this.lista[valor].getBirth();
                String cidade = this.lista[valor].getCidade();
                String estado = this.lista[valor].getEstado();
		String resp = "[";
                if(id != -1){
			resp += id;
                }
                else{
                	resp += "nao informado";
                }
		resp += " ## ";
                if(nome != "-1"){
                        resp += nome;
                }
                else{
                        resp += "nao informado";
                }
                resp += " ## ";
                if(altura != -1){
                        resp += altura;
                }
                else{
                        resp += "nao informado";
                }
                resp += " ## ";
                if(peso != 1){
                        resp += peso;
                }
                else{
                        resp += "nao informado";
                }
                resp += " ## ";
                if(birth != -1){
                        resp += birth;
                }
                else{
                        resp += "nao informado";
                }
                resp += " ## ";
                if( universidade != "-1"){
                        resp += universidade;
                }
                else{
                        resp += "nao informado";
                }
                resp += " ## ";
                if( cidade != "-1"){
                        resp += cidade;
                }
                else{
                        resp += "nao informado";
                }
		resp += " ## ";
                if( estado != "-1"){
                        resp += estado;
                }
                else{
                        resp += "nao informado";
                }
		resp += "]";
		
		return resp;
	}

		public void OrdenacaoSelecao(){
		for(int j = 0; j < tamArray - 1; j++){
			for(int i = j + 1; i < tamArray; i++){
        if(array[j].getNome().charAt(0) > array[i].getNome().charAt(0)){
          Jogador temp = array[j];
					array[j] = array[i];
					array[i] = temp;
        }
				else if(array[j].getNome().compareTo(array[i].getNome()) > 0){
					Jogador temp = array[j];
					array[j] = array[i];
					array[i] = temp; 
          numComp++;
				}
        numComp++;
			}
		}
	}
  		public void OrdenacaoInsercao(){
      for(int i = 1; i < tamArray; i++){
        Jogador temp = array[i];
        int j = i - 1;
          while((j >= 0) && (array[j].getBirth() > temp.getBirth())){
            array[j + 1] = array[j];
            j--;
          }
          array[j + 1] = temp;
      }
      for(int i = 1; i < tamArray; i++){
        Jogador temp = array[i];
        int j = i - 1;
          while((j >= 0) && (array[j].getBirth() == temp.getBirth()) && array[j].getNome().compareTo(temp.getNome()) > 0){
            array[j + 1] = array[j];
            j--;
          }
          array[j + 1] = temp;
      }
	}

    public static void main(String[] args) throws Exception {
    Scanner leia = new Scanner(System.in);
    Jogador jogador = new Jogador();
    jogador.ler("/tmp/players.csv");
    String valor;
    valor = leia.nextLine();
    tamArray = 0;
    jogador.array = new Jogador[1];
    while (!valor.equals("FIM")) {
        if (tamArray < jogador.array.length) {
            jogador.array[tamArray] = jogador.criaArray(Integer.parseInt(valor));
            tamArray++;
        }
        else{
          jogador.AumentarTamArray(jogador);
          jogador.array[tamArray - 1] = jogador.criaArray(Integer.parseInt(valor));
        }
        valor = leia.nextLine();
    }
    long startTime = System.nanoTime();
    jogador.OrdenacaoInsercao();
    long endTime = System.nanoTime();
    double duration = (endTime - startTime) / 1e6; // Tempo de execução em milissegundos

    // Geração do registro de log
    File arq = new File("matricula_selecao.txt");
    FileWriter escreva = new FileWriter(arq);
    escreva.write("810286\t" + numComp + "\t" + tamArray + "\t" + duration);
    escreva.close();

    // Impressão dos jogadores ordenados
    for (int i = 0; i < tamArray; i++) {
        String resp = jogador.toString(jogador.array[i].getId());
        System.out.println(resp);
    }
}
}