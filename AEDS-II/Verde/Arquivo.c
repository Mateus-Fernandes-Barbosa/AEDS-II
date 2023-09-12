#include <stdio.h>
#include <stdlib.h>

void LeitorDouble(FILE *arq, int qtdNumeros) {
    for (int i = 0; i < qtdNumeros; i++) {
        double n;
        scanf("%lf", &n);
        fwrite(&n, sizeof(double), 1, arq);
    }
    fclose(arq);
}

void LendoInverso(FILE *arq, int qtdNumeros) {
    for (int i = 0; i < qtdNumeros; i++) {
        fseek(arq, (qtdNumeros - i - 1) * sizeof(double), SEEK_SET);
        double valor;
        fread(&valor, sizeof(double), 1, arq);
        int coersao = (int) valor;
        if (coersao == valor) {
            printf("%d\n", coersao);
        } else if((valor * 1000 - (int) valor * 1000) == 0){
		printf("%.3f\n",valor);
	}
	else{
		printf("%g\n",valor);
	}
    }
    fclose(arq);
}

int main() {
    int qtdNumeros;
    scanf("%d", &qtdNumeros);
    FILE *arq = fopen("texto.txt", "wb");
    LeitorDouble(arq, qtdNumeros);
    arq = fopen("texto.txt", "rb");
    LendoInverso(arq, qtdNumeros);

    return 0;
}

