#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

//Class Jogador:

//Variáveis
typedef struct{
	int id;
	char* nome;
	int altura;
	int peso;
	char* universidade;
	int anoNascimento;
	char* cidadeNascimento;
	char* estadoNascimento;
} Jogador;

//Listas
Jogador lista[3922];
Jogador* array;

//Variáveis Acessórias
int contador = 0;
int numComp = 0;
int tamArray;

//Método Acessório
void AumentarTamArray(){
	Jogador temp[tamArray];
	for(int i = 0; i < tamArray; i++){
		temp[i] = array[i];
	}
	free(array);
	array = (Jogador*) malloc((tamArray + 1) * sizeof(Jogador));
	for(int i = 0; i < tamArray - 1; i++){
		array[i] = temp[i];
	}
	tamArray = sizeof(array)/sizeof(Jogador);
	printf("%i\n",tamArray);
	free(temp);
}

//Funções sets
void setId(Jogador* jogador, int valor){
	jogador.id = valor;
}

void setPeso(Jogador* jogador, int valor){
	jogador.peso = valor;
}

void setNome(Jogador* jogador, char* palavra){
	jogador.nome = palavra;
}

void setAltura(Jogador* jogador, int valor){
	jogador.altura = valor;
}

void setUniversidade(Jogador* jogador, char* palavra){
	jogador.universidade = palavra;
}

void setBirth(Jogador* jogador, int valor){
	jogador.anoNascimento = valor;
}

void setCidade(Jogador* jogador, char* palavra){
	jogador.cidadeNascimento = valor;
}

void setEstado(Jogador* jogador, char* palavra){
	jogador.estadoNascimento = palavra;
}

//Funções gets
int getId(Jogador* jogador){
	return jogador.id;
}

char* getNome(Jogador* jogador){
	return jogador.nome;
}

int getAltura(Jogador* jogador){
	return jogador.altura;
}

int getPeso(Jogador* jogador){
	return jogador.peso;
}

char* getUniversidade(Jogador* jogador){
	return jogador.universidade;
}

int getBirth(Jogador* jogador){
	return jogador.anoNascimento;
}

char* getCidade(Jogador* jogador){
	return jogador.cidadeNascimento;
}

char* getEstado(Jogador* jogador){
	return jogador.estadoNascimento;
}


int main (void){

	return 0;
}
