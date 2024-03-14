#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* confirmaVencedor;

int ConfirmaVencedor(char** cartelas, char* numSorteador, int N, int K, int U){
	int teste = 1;
	printf("\n");
	for(int i = 0; i < N; i++){
		for(int j = 0; j < K; j++){
			for(int z = 0; z < U; z++){
				printf("%c", numSorteador[z]);
				if(cartelas[i][j] == numSorteador[z]){
					confirmaVencedor[i]++;	
				}
			}
		}
		if(confirmaVencedor[i] == K){
			i = N + 1;
			teste = 0;
		}
	}
	return teste;
}

int main(void){
	int N = 0, K = 0, U = 0;
	/* 
	 * N = qtd cartelas
	 * K = qtd de nº por cartela
	 * U = qtd de nº a serem sorteados
	 */

	char *numSorteados, **cartelas;
	int teste;

	scanf("%i %i %i",&N,&K,&U);
	printf("%i\n",U);

	confirmaVencedor = (int*) malloc(N * sizeof(int));

	cartelas = (char**) malloc(N * sizeof(char*));

	numSorteados = (char*) malloc(U * sizeof(char));

	for(int i = 0; i < N; i++){
		cartelas[i] = (char*) malloc((K) * sizeof(char));
		for(int j = 0; j < K; j++){
			scanf("%s",&cartelas[i][j]);
		}
		confirmaVencedor[i] = 0;
	}	

	for(int i = 0; i < U; i++){
		scanf("%s",&numSorteados[i]);
	}

	for(int j = 0; j < N; j++){
		teste = ConfirmaVencedor(cartelas, numSorteados, N, K, U);
		if(teste == 0){
			printf("%i",(j + 1));
			j = N + 1;
		}
		free(cartelas[j]);
	}
	free(cartelas);

	return 0;
}
