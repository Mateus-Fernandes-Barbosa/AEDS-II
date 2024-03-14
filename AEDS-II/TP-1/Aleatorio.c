#include <stdio.h>
#include <stdlib.h>
#include <time.h>

char Sorteador() {
    char c = 'a' + (rand() % 26);
    return c;
}

char* Aleatorizador(char* palavra, char letra1, char letra2, int index) {
    if (palavra[index] == '\0') {
        return palavra;
    }

    if (palavra[index] == letra1) {
        palavra[index] = letra2;
    }

    return Aleatorizador(palavra, letra1, letra2, index + 1);
}

int Strcmp(char* palavra) {
    return (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M' && palavra[3] == '\0');
}

int main() {
    srand(time(NULL));
    char palavra[1000];

    scanf("%s", palavra);

    while (!Strcmp(palavra)) {
        char letra1 = Sorteador();
        char letra2 = Sorteador();
        char* aleatorizada = Aleatorizador(palavra, letra1, letra2, 0);
        printf("%s\n", aleatorizada);

        scanf("%s", palavra);
    }

    return 0;
}

