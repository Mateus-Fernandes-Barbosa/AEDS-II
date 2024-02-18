#include <stdlib.h>
#include <stdio.h>
#include <string.h>

const int MAXTAM = 50;

int contadorMaiusculos(char* palavra){
	int contador = 0, n = strlen(palavra);
	for(int i = 0; i < n; i++){
		if((int) palavra[i] >= 65 && (int) palavra[i] <= 90){
			contador++;
		}
	}
	return contador;
}

int main(void){
	char* palavra = (char*) malloc(MAXTAM * sizeof(char));
	fgets(palavra,MAXTAM,stdin);
	palavra[strcspn(palavra,"\n")] = '\0';
	while(strcmp(palavra, "FIM") != 0){
	 int contador = contadorMaiusculos(palavra);
 	 printf("%i\n", contador);
	 fgets(palavra,MAXTAM,stdin);
	 palavra[strcspn(palavra, "\n")] = '\0';
	}

	return 0;
}
