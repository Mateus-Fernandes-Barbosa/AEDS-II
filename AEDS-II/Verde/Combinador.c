/*Nome: Mateus Fernandes Barbosa
 *Matrícula: 810286
Data: 05/09/2023*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void combinador(char frase[], char combinado[]){
	int posicao = 0;
	for(int i = 0; i < 50; i++){
		if(frase[i] == ' '){
			posicao = i;
		}
	}
	char frase1[50], frase2[50];
	for(int i = 0; i < posicao; i++){
		frase1[i] = frase[i];
	}
	for(int i = posicao + 1, k = 0; i < strlen(frase) - 1; i++){
		frase2[k] = frase[i];
		k++;
	}
	int n = strlen(frase1) + strlen(frase2) + 1;
	printf("%i\n", n);
	for(int i = 0, j = 0, k = 0; i < n; i++){
		if(i % 2 == 0 && k < strlen(frase1)){
			combinado[i] = frase1[k];
			k++;
		}
		else{
			if(j < strlen(frase2)){
				combinado[i] = frase2[j];
				j++;
			}
		}
	}
}
int TAM(char frase1[], char frase2[]){
	int n = strlen(frase1) + strlen(frase2);
	return n;
}

int main(){
char frase1 [50], combinado[50];
int n;
for(int j = 0; j < 3; j++){
//recebendo a frase:
fgets(frase1,50,stdin);
combinador(frase1, combinado);
for(int i = 0; i < 50; i++){
	printf("%c",combinado[i]);
}
printf("\n");
}
return 0;
}
