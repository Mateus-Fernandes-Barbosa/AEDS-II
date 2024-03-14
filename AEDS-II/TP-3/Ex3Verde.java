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
 * Celula (pilha, lista e fila dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Celula {
	public Jogador jogador; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.


	/**
	 * Construtor da classe.
	 */
	public Celula() throws Exception {
		this(0);
	}

	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public Celula(int elemento)throws Exception {
      	Jogador jogador = new Jogador();
      	jogador.ler("/tmp/players.csv");
      	this.jogador = jogador.criaArray(elemento);
      	this.prox = null;
	}
}

/**
 * Lista dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
	protected Celula primeiro;
	protected Celula ultimo;


	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() throws Exception {
		primeiro = new Celula();
		ultimo = primeiro;
	}

	/**
	 * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(int x) throws Exception {
		Celula tmp = new Celula(x);
      tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      tmp = null;
	}


	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirFim(int x) throws Exception{
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


	/**
	 * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Celula removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

      		Celula tmp = primeiro;
		primeiro = primeiro.prox;
		tmp.prox = null;
		return tmp;
	}


	/**
	 * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Celula removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima celula:
      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      Celula resp = ultimo; 
      ultimo = i; 
      i = ultimo.prox = null;
      
		return resp;
	}


	/**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
   public void inserir(int x, int pos) throws Exception {

      int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } else if (pos == 0){
         inserirInicio(x);
      } else if (pos == tamanho){
         inserirFim(x);
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = new Celula(x);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }


	/**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
	 * @param posicao Meio da remocao.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public Celula remover(int pos) throws Exception {
      Celula resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         resp = i.prox;
         i.prox = resp.prox;
         resp.prox = null;
         i = null;
      }

		return resp;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.jogador.toString(i.jogador.getId()) + " ");
		}
		System.out.println("] ");
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.jogador.getId() == x){
            resp = true;
            i = ultimo;
         }
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp int tamanho
	 */
   public int tamanho() {
      int tamanho = 0; 
      for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }
}

public class Ex3Verde{
	public static Lista listaJogadores;
	public static Lista listaExcluidos;
	public static int verificaComando(String str){
		int resp = -1;
		switch(str){
			case "II":
			resp = 0;
			//MyIO.println("resp: " + resp);
			break;
			
			case "I*":
			resp = 1;
			//MyIO.println("resp: " + resp);
			break;

			case "IF":
			resp = 2;
			//MyIO.println("resp: " + resp);
			break;

			case "RI":
			resp = 3;
			//MyIO.println("resp: " + resp);
			break;

			case "R*":
			resp = 4;
			//MyIO.println("resp: " + resp);
			break;

			case "RF":
			resp = 5;
			//MyIO.println("resp: " + resp);
			break;
		}
		return resp;
	}

	public static void executaComando(int cmd, String str1, String str2) throws Exception{
		Celula resp = null;
		Jogador temp = new Jogador();
		Scanner leia = new Scanner(System.in);
		temp.ler("/tmp/players.csv");
		String pos = str2, num = str1;
		//String string;
		switch(cmd){
			case 0:
				//num = leia.next();
				listaJogadores.inserirInicio(Integer.parseInt(num));
				break;
			case 1:
				//num = leia.next();
				//pos = leia.next();
				listaJogadores.inserir(Integer.parseInt(num), Integer.parseInt(pos));
				break;
			case 2:
				//num = leia.next();
				listaJogadores.inserirFim(Integer.parseInt(num));
				break;
			case 3:
				resp = listaJogadores.removerInicio();
				break;
			case 4:
				//pos = leia.next();
				resp = listaJogadores.remover(Integer.parseInt(pos));
				break;
			case 5:
				resp = listaJogadores.removerFim();
				break;
		}
		if(resp != null){
			listaExcluidos.inserirFim(resp.jogador.getId());
		}
	}
		
	public static int contaEspacos(String str){
		int qtdEspacos = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' '){
				qtdEspacos++;
			}
		}
		return qtdEspacos;
	}
	public static void main(String [] args) throws Exception{
                Scanner leia = new Scanner(System.in);
                Jogador temp = new Jogador();
                temp.ler("/tmp/players.csv");
		listaJogadores = new Lista();
		listaExcluidos = new Lista();
                String entrada;
		entrada = leia.nextLine();
		for(int i = 0; !entrada.equals("FIM"); i++){
			listaJogadores.inserirFim(Integer.parseInt(entrada));
			entrada = leia.nextLine();
		}
		String segundaEntrada, pos = "", comando = "";
		int qtdComandos = leia.nextInt();
		segundaEntrada = leia.nextLine();
		int cmd;
		int qtdEspacos = contaEspacos(segundaEntrada);
			if(qtdEspacos == 1 && segundaEntrada.charAt(0) != 'R'){
				comando = segundaEntrada.substring(0, segundaEntrada.indexOf(' '));
				segundaEntrada = segundaEntrada.substring(segundaEntrada.indexOf(' ') + 1, segundaEntrada.length());
				pos = "banana";
			}
			else if(qtdEspacos == 1){
                                        comando = segundaEntrada.substring(0, segundaEntrada.indexOf(' '));
                                        pos = segundaEntrada.substring(segundaEntrada.indexOf(' ') + 1, segundaEntrada.length());
					segundaEntrada = "banana";
                        }
			else if(qtdEspacos == 2){
				comando = segundaEntrada.substring(0, segundaEntrada.indexOf(' '));
                        	segundaEntrada = segundaEntrada.substring(segundaEntrada.indexOf(' '), segundaEntrada.length());
				pos = segundaEntrada.substring(0, segundaEntrada.indexOf(' '));
        	                segundaEntrada = segundaEntrada.substring(segundaEntrada.indexOf(' ') + 1, segundaEntrada.length());
			}
			else{
        	                comando = segundaEntrada;
	                        pos = "banana";
				segundaEntrada = "limao";
                	}
		
			cmd = verificaComando(comando);
			executaComando(cmd, segundaEntrada, pos);
		for(int i = 0; i < qtdComandos ; i++){
			segundaEntrada = leia.nextLine();
				qtdEspacos = contaEspacos(segundaEntrada);
				if(qtdEspacos == 1 && segundaEntrada.charAt(0) != 'R'){
        	                	comando = segundaEntrada.substring(0, segundaEntrada.indexOf(' '));
                		        segundaEntrada = segundaEntrada.substring(segundaEntrada.indexOf(' ') + 1, segundaEntrada.length());
					pos = "banana";
	        	        }
				else if(qtdEspacos == 1){
					comando = segundaEntrada.substring(0, segundaEntrada.indexOf(' '));
                                        pos = segundaEntrada.substring(segundaEntrada.indexOf(' ') + 1, segundaEntrada.length());
                                        segundaEntrada = "banana";
				}
		                else if(qtdEspacos == 2){
                		        comando = segundaEntrada.substring(0, segundaEntrada.indexOf(' '));
        	        	        segundaEntrada = segundaEntrada.substring(segundaEntrada.indexOf(' ') + 1, segundaEntrada.length());
		                        pos = segundaEntrada.substring(0, segundaEntrada.indexOf(' '));
        	                	segundaEntrada = segundaEntrada.substring(segundaEntrada.indexOf(' ') + 1, segundaEntrada.length());
				}
				else{
					comando = segundaEntrada;
					pos = "banana";
					segundaEntrada = "limao";
				}
		              	cmd = verificaComando(comando);	
				executaComando(cmd, segundaEntrada, pos);
		}
		for(Celula j = listaExcluidos.primeiro.prox; j != null; j = j.prox){
			System.out.println("(R) " + j.jogador.getNome());
		}
		Celula i = listaJogadores.primeiro.prox;
		for(int j = 0; i != null; j++, i = i.prox){
			System.out.println("[" + j + "]"
					+ temp.toString(i.jogador.getId()));
		}
        }
}
