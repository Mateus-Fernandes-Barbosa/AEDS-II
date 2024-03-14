#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*This code has the purpose to combine two diferent strings in just one string, switching the letters one string by time
 * Exemple: Aba + Bab = ABbaab*/

const int MAXTAM = 50;

char* stringCombiner(char* string1, char* string2){
	int tam = strlen(string1) + strlen(string2); //used to create the final answer string;
	char* resp = (char*) malloc(tam * sizeof(char));
	for(int i = 0, j = 0, z = 0; i < tam; i++){
		if(i % 2 == 0 && j < strlen(string1)){
			if(string1[j] != '\0'){
				resp[i] = string1[j];
				j++;
				//printf("1\n");
			}
			else if(string2[z] != '\0'){
				resp[i] = string2[z];
				z++;
				//printf("3\n");
			}
		}
		else{
                        if(string2[z] != '\0'){
                                resp[i] = string2[z];
                                z++;
				//printf("4\n");
                        }
			else if(string1[j] != '\0'){
				resp[i] = string1[j];
				j++;
				//printf("6\n");
			}

		}
		//printf("i: %i -- j: %i %c -- z: %i %c\n", i, j, string1[j - 1], z, string2[z - 1]);
	}
	return resp;
}

int main (void){

	char* string1 = (char*) malloc(MAXTAM * sizeof(char)), *string2 = (char*) malloc(MAXTAM * sizeof(char));
        scanf("%s",string1);
        scanf("%s",string2);
	while(strcmp(string2, "FIM") != 0){
		char* resp = stringCombiner(string1, string2);
		printf("%s\n",resp);
                scanf("%s",string1);
                scanf("%s",string2);
	}
}
