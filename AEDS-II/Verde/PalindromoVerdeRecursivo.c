#include <stdio.h>
#include <stdbool.h>
#include <string.h>

const int MAX = 400;

bool FraseEhPalindromoRecursivo(char palavra[], int inicio, int fim) {
    // Caso base: quando a string tem tamanho 0 ou 1, é um palíndromo.
    if (inicio >= fim) {
        return true;
    }

    // Verifica se os caracteres nas posições inicio e fim são iguais.
    if (palavra[inicio] == palavra[fim]) {
        // Chamada recursiva para verificar o restante da string.
        return FraseEhPalindromoRecursivo(palavra, inicio + 1, fim - 1);
    }

    return false;
}

bool FraseEhPalindromo(char palavra[]) {
    int tamanhoPalavra = strlen(palavra);
    return FraseEhPalindromoRecursivo(palavra, 0, tamanhoPalavra - 1);
}

char* LePalavra(char palavra[]) {
    fgets(palavra, MAX, stdin);
    palavra[strcspn(palavra, "\n")] = '\0';
    return palavra;
}

int main(void) {
    char palavra[MAX];

    LePalavra(palavra);

    while (strcmp(palavra, "FIM") != 0) {
        if (FraseEhPalindromo(palavra)) {
            puts("SIM");
        } else {
            puts("NAO");
        }

        LePalavra(palavra);
    }

    return 0;
}

