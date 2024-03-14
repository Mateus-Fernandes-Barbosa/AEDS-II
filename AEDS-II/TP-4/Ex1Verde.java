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
	protected Jogador [] array = new Jogador[49];

	//Variáveis Acessórias
	public static int contador = 0;
	public static int numComp = 0;
	public static double inicio, fim;
	public static int tamArray;
	
	//Método Acessório
	private void AumentarTamArray(){
		Jogador [] temp = new Jogador [tamArray];
		for(int i = 0; i < tamArray - 1; i++){
			temp[i] = array[i];
		}
		array = new Jogador [++tamArray];
		for(int i = 0; i < tamArray - 1; i++){
			array[i] = temp[i];
		}
		tamArray = array.length;
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
		String resp = "";
                /*if(id != -1){
			resp += id;
                }
                else{
                	resp += "nao informado";
                }*/
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
		resp += " ##";
		
		return resp;
	}

	public void OrdenacaoSelecao(String [] array){
		for(int j = 0; j < tamArray; j++){
			for(int i = j + 1; i < tamArray; i++){
				if(array[j].compareTo(array[i]) == 1){
					String temp = array[j];
					array[j] = array[i];
					array[i] = temp; 
				}
			}
		}
  }
}



/**
 * Arvore binaria de pesquisa
 * @autho
 * Max do Val Machado
 */
class ArvoreBinaria {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(Jogador x) {
		return pesquisar(x, raiz);
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(Jogador x, No i) {
      boolean resp;
      if (i == null) {
         resp = false;

      } else if (CompareTo(x.getNome(), i.elemento.getNome()) == 0) {
         resp = true;

      } else if (CompareTo(x.getNome(), i.elemento.getNome()) < 0) {
         resp = pesquisar(x, i.esq);

      } else {
         resp = pesquisar(x, i.dir);
      }
      return resp;
	}

	/**
         * Metodo publico iterativo para pesquisar elemento.
         * @param x Elemento que sera procurado.
         * @return <code>true</code> se o elemento existir,
         * <code>false</code> em caso contrario.
         */
        public boolean pesquisar(String x) {
                return pesquisar(x, raiz);
        }

        /**
         * Metodo privado recursivo para pesquisar elemento.
         * @param x Elemento que sera procurado.
         * @param i No em analise.
         * @return <code>true</code> se o elemento existir,
         * <code>false</code> em caso contrario.
         */
        private boolean pesquisar(String x, No i) {
      boolean resp;
      if (i == null) {
         resp = false;

      } else if (CompareTo(x, i.elemento.getNome()) == 0) {
         resp = true;

      } else if (CompareTo(x, i.elemento.getNome()) < 0) {
	 System.out.print(" esq");
         resp = pesquisar(x, i.esq);

      } else {
	 System.out.print(" dir");
         resp = pesquisar(x, i.dir);
      }
      return resp;
        }


	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento.getId() + " "); // Conteudo do no.
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPre() {
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPos() {
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento + " "); // Conteudo do no.
		}
	}

	private int CompareTo(String str1, String str2){
		int resp;
		//System.out.println(str1 + "-" + str2); --> Verificação de Atividade
		if(str1.charAt(0) != str2.charAt(0)){
			if(str1.charAt(0) > str2.charAt(0)){
				resp = 1;
			}
			else{
				resp = -1;
			}
		}
		else{
			resp = str1.compareTo(str2);
		}
		return resp;
	}	

	/**
	 * Metodo publico iterativo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(Jogador x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(Jogador x, No i) throws Exception {
	if (i == null) {
         i = new No(x);

      	 } else if (CompareTo(x.getNome(), i.elemento.getNome()) < 0) {
         i.esq = inserir(x, i.esq);

      	 } else if (CompareTo(x.getNome(), i.elemento.getNome()) > 0) {
         i.dir = inserir(x, i.dir);

      	 } else {
         throw new Exception("Erro ao inserir!");
      	 }

		return i;
	}

  public boolean verificarNome(int n) throws Exception{
        Jogador jogador = new Jogador(), temp;
	jogador.ler("/tmp/players.csv");
	temp = jogador.criaArray(n);
        boolean resp = pesquisar(temp);
        return resp;
    }


}

/**
 * No da arvore binaria
 * @author Max do Val Machado
 */

class No {
    public Jogador elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(Jogador elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(Jogador elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }

  }

public class Ex1Verde{

  public static void main (String [] args) throws Exception{
                Scanner leia = new Scanner(System.in);
                Jogador jogador = new Jogador(), temp;
                jogador.ler("/tmp/players.csv");
		ArvoreBinaria arvore = new ArvoreBinaria();
                String entrada;
                entrada = leia.nextLine();
                while(!entrada.equals("FIM")){
			if(!arvore.verificarNome(Integer.parseInt(entrada))){
	                  temp = jogador.criaArray(Integer.parseInt(entrada));
			  arvore.inserir(temp);
			}
			  entrada = leia.nextLine();
                	
		}
		entrada = leia.nextLine();
		while(!entrada.equals("FIM")){
			System.out.print(entrada + " raiz");
			if(arvore.pesquisar(entrada)){
				System.out.println(" SIM");
			}
			else{
				System.out.println(" NAO");
			}
			entrada = leia.nextLine();
		}

  }
  
}
