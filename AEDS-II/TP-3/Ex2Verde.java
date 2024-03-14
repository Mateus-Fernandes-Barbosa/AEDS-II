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
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */

class Pilha {
   private Jogador[] array;
   private int n;


   /**
    * Construtor da classe.
    */
   public Pilha () {
      this(1);
   }


   /**
    * Construtor da classe.
    * @param tamanho Tamanho da lista.
    */
   public Pilha (int tamanho){
      array = new Jogador[tamanho];
      n = 0;
   }

   /* 
    * Cria um array novo array com uma posição a mais
    * e move os demais elementos para frente
    */
   public void AumentarTamArray(){
//	   	MyIO.println("n: " + n);
                Jogador [] temp = new Jogador [n];
                for(int i = 0; i < n; i++){
                        temp[i] = array[i];
                }
//		MyIO.println("TAM array 2: "+ array.length);
                array = new Jogador [n + 1];
//		MyIO.println("TAM array 3: "+ array.length);
//		MyIO.println("n 2: " + n);
                for(int i = 0; i < array.length - 1; i++){
                        array[i] = temp[i];
                }
                n = array.length - 1;
                temp = null;
   }

   /**
    * Insere um elemento na primeira posicao da lista e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirInicio(Jogador x) throws Exception {

      //validar insercao
      if(n >= array.length){
         AumentarTamArray();
      } 

      //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         array[i] = array[i-1];
      }

      array[0] = x;
      n++;
   }


   /**
    * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirFim(Jogador x) throws Exception {

      //validar insercao
      if(n >= array.length){
      	AumentarTamArray();
      }

      array[n] = x;
      n++;
   }


   /**
    * Insere um elemento em uma posicao especifica e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @param pos Posicao de insercao.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
   public void inserir(Jogador x, int pos) throws Exception {

      //validar insercao
      if(n >= array.length || pos < 0 || pos > n){
         AumentarTamArray();
      }

      //levar elementos para o fim do array
      for(int i = n; i > pos; i--){
         array[i] = array[i-1];
      }

      array[pos] = x;
      n++;
   }


   /**
    * Remove um elemento da primeira posicao da lista e movimenta 
    * os demais elementos para o inicio da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Jogador removerInicio() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      Jogador resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }


   /**
    * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Jogador removerFim() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      return array[--n];
   }


   /**
    * Remove um elemento de uma posicao especifica da lista e 
    * movimenta os demais elementos para o inicio da mesma.
    * @param pos Posicao de remocao.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
   public Jogador remover(int pos) throws Exception {

      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }

      Jogador resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }


   /**
    * Mostra os elementos da lista separados por espacos.
    */
   public void mostrar (){
      System.out.print("[ ");
      for(int i = 0; i < n; i++){
         System.out.print(array[i] + " ");
      }
      System.out.println("]");
   }

   /*
    *Métodos Gets 
    */
	public Jogador[] getArray(){
		return this.array;
	}

	public int getN(){
		return this.n;
	}

	public Jogador getElemento(int posicao){
		return this.array[posicao];
	}

   /**
    * Procura um elemento e retorna se ele existe.
    * @param x int elemento a ser pesquisado.
    * @return <code>true</code> se o array existir,
    * <code>false</code> em caso contrario.
    */
   public boolean pesquisar(int x) {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
	      if(array[i].getId() == x){
	      	retorno = true;
	      }
      }
      return retorno;
   }
}

public class Ex2Verde{
	public static Pilha pilhaJogadores;
	public static Pilha pilhaExcluidos;
	public static int verificaComando(String str){
		int resp = -1;
		switch(str){
			case "II":
			resp = 5;
			//MyIO.println("resp: " + resp);
			break;
			
			case "I*":
			resp = 1;
			//MyIO.println("resp: " + resp);
			break;

			case "I":
			resp = 0;
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

			case "R":
			resp = 1;
			//MyIO.println("resp: " + resp);
			break;
		}
		return resp;
	}

	public static void executaComando(int cmd, String str1, String str2) throws Exception{
		Jogador temp = new Jogador(), resp = null;
		Scanner leia = new Scanner(System.in);
		temp.ler("/tmp/players.csv");
		String pos = str2, num = str1;
		//String string;
		switch(cmd){
			case 2:
				//num = leia.next();
				pilhaJogadores.inserirInicio(temp.criaArray(Integer.parseInt(num)));
				break;
			case 5:
				//num = leia.next();
				//pos = leia.next();
				pilhaJogadores.inserir(temp.criaArray(Integer.parseInt(num)), Integer.parseInt(pos));
				break;
			case 0:
				//num = leia.next();
				pilhaJogadores.inserirFim(temp.criaArray(Integer.parseInt(num)));
				break;
			case 3:
				resp = pilhaJogadores.removerInicio();
				break;
			case 4:
				//pos = leia.next();
				resp = pilhaJogadores.remover(Integer.parseInt(pos));
				break;
			case 1:
				resp = pilhaJogadores.removerFim();
				break;
		}
		if(resp != null){
			pilhaExcluidos.inserirFim(resp);
			pilhaExcluidos.AumentarTamArray();
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
                Jogador jogador = new Jogador();
                jogador.ler("/tmp/players.csv");
		pilhaJogadores = new Pilha();
		pilhaExcluidos = new Pilha();
                String entrada;
		entrada = leia.nextLine();
		for(int i = 0; !entrada.equals("FIM"); i++){
			pilhaJogadores.inserirFim(jogador.criaArray(Integer.parseInt(entrada)));
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
		for(int j = 0; j < pilhaExcluidos.getN(); j++){
			System.out.println("(R) " + pilhaExcluidos.getElemento(j).getNome());
		}
		for(int i = 0; i < pilhaJogadores.getN(); i++){
			System.out.println("[" + i + "]"
					+ jogador.toString(pilhaJogadores.getElemento(i).getId()));
		}
        }
}
