import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

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
	
	//funções gets e sets
	public void setId(int valor){
		this.id = valor;
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
}
