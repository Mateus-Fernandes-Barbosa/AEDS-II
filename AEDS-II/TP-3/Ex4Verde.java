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
/**
 * Pilha dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Pilha {
	public Celula topo;

	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = null;
	}

	/**
	 * Insere elemento na pilha (politica FILO).
	 * 
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) throws Exception{
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}

	/**
	 * Remove elemento da pilha (politica FILO).
	 * 
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
	public Celula remover() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}
		Celula tmp = topo;
		topo = topo.prox;
		tmp.prox = null;
		return tmp;
	}
  
  public int tamanho(){
    int i = 0;
    for(Celula j = this.topo; j != null; j = j.prox, i++);
    return i;
  }
}

public class Ex4Verde{
	public static Pilha pilhaJogadores;
	public static Pilha pilhaExcluidos;
	public static int verificaComando(String str){
		int resp = -1;
		switch(str){
			case "I":
			resp = 0;
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
		Celula resp = null;
		Jogador temp = new Jogador();
		Scanner leia = new Scanner(System.in);
		temp.ler("/tmp/players.csv");
		String pos = str2, num = str1;
		//String string;
		switch(cmd){
			case 0:
				//num = leia.next();
				pilhaJogadores.inserir(Integer.parseInt(num));
				break;
			case 1:
				//num = leia.next();
				//pos = leia.next();
				resp = pilhaJogadores.remover();
				break;
		}
		if(resp != null){
			pilhaExcluidos.inserir(resp.jogador.getId());
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

	public static Pilha OrganizaPilha(Pilha pilha) throws Exception{
		Pilha temp = new Pilha();
		for(Celula i = pilha.topo; i != null; i = i.prox){
			temp.inserir(i.jogador.getId());
		}
		return temp;
	}
		
	public static void main(String [] args) throws Exception{
                Scanner leia = new Scanner(System.in);
                Jogador temp = new Jogador();
                temp.ler("/tmp/players.csv");
		pilhaJogadores = new Pilha();
		pilhaExcluidos = new Pilha();
                String entrada;
		entrada = leia.nextLine();
		for(int i = 0; !entrada.equals("FIM"); i++){
			pilhaJogadores.inserir(Integer.parseInt(entrada));
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
		pilhaJogadores = OrganizaPilha(pilhaJogadores);
		pilhaExcluidos = OrganizaPilha(pilhaExcluidos);
		for(Celula j = pilhaExcluidos.topo; j != null; j = j.prox){
			System.out.println("(R) " + j.jogador.getNome());
		}
		Celula i = pilhaJogadores.topo;
		for(int j = 0; i != null; j++, i = i.prox){
			System.out.println("[" + j + "]"
					+ temp.toString(i.jogador.getId()));
		}
        }
}
