/**
 * @path TP02Q02 - Classe em C/Player.c
 * @description C file that implements the Player class.
 * @author Pedro Lopes - github.com/httpspedroh
 * @version 1.0
 * @update 2023-09-27
 */

// ---------------------------------------------------------------------------------------------------- //

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// ---------------------------------------------------------------------------------------------------- //

// Constants
#define MAX_PLAYERS 4000
#define FILE_PATH "/tmp/players.csv"

#define MAX_NAME_SIZE 40
#define MAX_COLLEGE_SIZE 60
#define MAX_BIRTH_CITY_SIZE 40
#define MAX_BIRTH_STATE_SIZE 40

#define MAX_LINE_SIZE 300
#define MAX_ATTRIBUTE_SIZE 100

// ---------------------------------------------------------------------------------------------------- //

// Structs
typedef struct Player {
    int id;
    char *name;
    int height;
    int weight;
    int birthYear;
    char *birthCity;
    char *birthState;
    char *college;
} Player;

// ---------------------------------------------------------------------------------------------------- //

// Global variables
Player players[MAX_PLAYERS];
int playersLength = 0;

// ---------------------------------------------------------------------------------------------------- //

// Functions 
bool isEnd(char* line) { return line[0] == 'F' && line[1] == 'I' && line[2] == 'M'; }

void substring(char *string, char *stringStart, int length) {

    strncpy(string, stringStart, length);
    string[length] = '\0';
}

void proccess_attribute(char *attribute, char **substringStart, char **substringEnd, bool isFirstAttribute) {

    // Skip first comma
    if(!isFirstAttribute) {
        
        if(*substringEnd != NULL) *substringStart = *substringEnd + 1;
        else *substringStart = *substringEnd;
    }

    // Get next comma
    *substringEnd = strchr(*substringStart, ',');
    
    // Get substring
    if(*substringEnd) substring(attribute, *substringStart, *substringEnd - *substringStart);
    else strcpy(attribute, *substringStart);

    // Set default value if attribute is empty
    if(strcmp(attribute, "") == 0 || attribute[0] == '\n' || attribute[0] == '\r' || attribute[0] == '\0') strcpy(attribute, "nao informado");
    
    // Clean \n from the end of the string
    if(attribute[strlen(attribute) - 1] == '\n') attribute[strlen(attribute) - 1] = '\0';
}

// ---------------------------------------------------------------------------------------------------- //

// Methods signatures

// Class
Player player_newBlank();
Player player_new(int id, char *name, int height, int weight, int birthYear, char *birthCity, char *birthState, char *college);
Player *player_clone(Player *player);
void player_print(Player player);
Player player_read(char *line);
Player player_searchById(int id);

// Gets
int player_getId(Player *player);
char *player_getName(Player player);
int player_getHeight(Player player);
int player_getWeight(Player player);
char *player_getCollege(Player player);
int player_getBirthYear(Player player);
char *player_getBirthCity(Player player);
char *player_getBirthState(Player player);

// Sets
void player_setId(Player *player, int id);
void player_setName(Player *player, char *name);
void player_setHeight(Player *player, int height);
void player_setWeight(Player *player, int weight);
void player_setCollege(Player *player, char *college);
void player_setBirthYear(Player *player, int birthYear);
void player_setBirthCity(Player *player, char *birthCity);
void player_setBirthState(Player *player, char *birthState);

// General
void startPlayers();

// ---------------------------------------------------------------------------------------------------- //

// Methods implementations

// Class
Player player_newBlank() {

    Player player;

    player.id = -1;
    player.height = -1;
    player.weight = -1;
    player.birthYear = -1;

    player.name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(player.name, "");

    player.birthCity = (char *) calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(player.birthCity, "");

    player.birthState = (char *) calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(player.birthState, "");

    player.college = (char *) calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(player.college, "");

    return player;
}

Player player_new(int id, char *name, int height, int weight, int birthYear, char *birthCity, char *birthState, char *college) {

    Player player;

    player.id = id;
    player.height = height;
    player.weight = weight;
    player.birthYear = birthYear;

    player.name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(player.name, name);

    player.birthCity = (char *) calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(player.birthCity, birthCity);

    player.birthState = (char *) calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(player.birthState, birthState);

    player.college = (char *) calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(player.college, college);

    return player;
}

Player *player_clone(Player *player) {

    Player *clone = (Player *) malloc(sizeof(Player));

    clone -> id = player -> id;
    clone -> height = player -> height;
    clone -> weight = player -> weight;

    clone -> name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(clone -> name, player -> name);

    clone -> birthCity = (char *) calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(clone -> birthCity, player -> birthCity);

    clone -> birthState = (char *) calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(clone -> birthState, player -> birthState);

    clone -> college = (char *) calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(clone -> college, player -> college);

    return clone;
}

void player_print(Player player) {

    printf(" ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n",
        player.name,
        player.height,
        player.weight,
        player.birthYear,
        player.college,
        player.birthCity,
        player.birthState
    );
}

Player player_read(char *line) {

    Player player = player_newBlank();

    char *substringStart = line;
    char *substringEnd = NULL;
    char attribute[MAX_ATTRIBUTE_SIZE];
   
    // Get id
    proccess_attribute(attribute, &substringStart, &substringEnd, true);
    player_setId(&player, atoi(attribute));
    
    // Get name
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setName(&player, attribute);

    // Get height
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setHeight(&player, atoi(attribute));

    // Get weight
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setWeight(&player, atoi(attribute));

    // Get college
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setCollege(&player, attribute);

    // Get birth year
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthYear(&player, atoi(attribute));

    // Get birth city
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthCity(&player, attribute);

    // Get birth state
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthState(&player, attribute);

    return player;
}

Player player_searchById(int id) {
    
    Player temp;

    for(int i = 0; i < playersLength; i++) {

        if(player_getId(&players[i]) == id) return players[i];
    }
    return temp;
}

// Gets
int player_getId(Player* player) { return player->id; }
char* player_getName(Player player) { return player.name; }
int player_getHeight(Player player) { return player.height; }
int player_getWeight(Player player) { return player.weight; }
char *player_getCollege(Player player) { return player.college; }
int player_getBirthYear(Player player) { return player.birthYear; }
char *player_getBirthCity(Player player) { return player.birthCity; }
char *player_getBirthState(Player player) { return player.birthState; }

// Sets
void player_setId(Player *player, int id) { player -> id = id; }
void player_setName(Player *player, char *name) { strcpy(player -> name, name); }
void player_setHeight(Player *player, int height) { player -> height = height; }
void player_setWeight(Player *player, int weight) { player -> weight = weight; }
void player_setBirthYear(Player *player, int birthYear) { player -> birthYear = birthYear; }
void player_setBirthCity(Player *player, char *birthCity) { strcpy(player -> birthCity, birthCity); }
void player_setBirthState(Player *player, char *birthState) { strcpy(player -> birthState, birthState); }
void player_setCollege(Player *player, char *college) { strcpy(player -> college, college); }

// General
void startPlayers() {

    // Open file
    FILE *fp;
    char *line = NULL;
    size_t len = 0;
    ssize_t read;

    fp = fopen(FILE_PATH, "r");

    if(fp == NULL) {

        perror("x Error opening file");
        exit(EXIT_FAILURE);
    }

    // Skip first line
    getline(&line, &len, fp);

    // Read all lines
    while((read = getline(&line, &len, fp)) != -1) {

        // Read player from line
        Player player = player_read(line);

        players[playersLength++] = player;

        if(playersLength >= MAX_PLAYERS) {

            perror("x Max players reached");
            exit(EXIT_FAILURE);
        }
    }

    // Close file and free memory
    fclose(fp);

    if(line) free(line);
}

// ---------------------------------------------------------------------------------------------------- //

//Variáveis Globais
int tamLJogadores = 0; // Tamanho da Lista de Jogadores
int tamLExcluidos = 0; // Tamanho da Lista de Excluidos
Player listaJogadores[4000];
Player listaExcluidos[4000];

//Métodos Acessórios

int indexOf(char c, char* frase){
  int i, resp = -1; 
  for(i = 0; i < strlen(frase); i++){
    if(frase[i] == c){
     resp = i;
     i = strlen(frase);
    }
  }

 return resp;
 
}

char* subString(char* palavra, int i, int j){
  char* resp = (char*) malloc((j - i) * sizeof(char));
  for(int x = i, z = 0; x < j; x++, z++){
    resp[z] = palavra[x];
  }
  return resp;
}

int contaChar(char c, char* frase){
  int resp = 0;
  printf("aqui está o c: [%c]\n",c);
  for(int i = 0; i < strlen(frase); i++){
    if(frase[i] == c){
      resp++;
    }
  }
}

void inserirExcluidos(int x) {

   Player temp = player_searchById(x);
   
   listaExcluidos[tamLExcluidos] = temp;
   
   tamLExcluidos++;
      
}

//Métodos da Lista
void inserirInicio(int x) {
   Player temp = player_searchById(x);
   int i;
   //levar elementos para o fim do array
   for(i = tamLJogadores; i > 0; i--){
      listaJogadores[i] = listaJogadores[i-1];
   }

   listaJogadores[0] = temp;
   tamLJogadores++;
}

void inserirFim(int x) {

   Player temp = player_searchById(x);
   
   listaJogadores[tamLJogadores] = temp;
   
   tamLJogadores++;
}

void inserir(int x, int pos) {
   int i;
   
   Player temp = player_searchById(x);
   
   //levar elementos para o fim do array
   for(i = tamLJogadores; i > pos; i--){
      listaJogadores[i] = listaJogadores[i-1];
   }

   listaJogadores[pos] = temp;
   tamLJogadores++;
   
}

Player removerInicio() {
   int i;
   Player resp;
   
   resp = listaJogadores[0];
    
   for(i = 0; i < tamLJogadores; i++){
      listaJogadores[i] = listaJogadores[i+1];
   }

   return resp;
}

Player removerFim() {

   //validar remocao
   if (tamLJogadores == 0) {
      printf("Erro ao remover!");
      exit(1);
   }
   
   
   
   return listaJogadores[tamLJogadores];
}

Player remover(int pos) {
   int i;
   Player resp;
   
   //validar remocao
   if (tamLJogadores == 0 || pos < 0 || pos >= tamLJogadores) {
      printf("Erro ao remover!");
      exit(1);
   }

   resp = listaJogadores[pos];
   for(i = pos; i < tamLJogadores; i++){
      listaJogadores[i] = listaJogadores[i+1];
   }
    
   return resp;
}

int verificaComando(char* str){
  int resp = -1;
  if(str[0] == 'I' && str[1] == 'I'){
    resp = 0;
  } else if(str[0] == 'I' && str[1] == 'F'){
    resp = 1;
  } else if(str[0] == 'I' && str[1] == '*'){
    resp = 2;
  } else if(str[0] == 'R' && str[1] == 'I'){
    resp = 3;
  } else if(str[0] == 'R' && str[1] == '*'){
    resp = 4;
  } else if(str[0] == 'R' && str[1] == 'F'){
    resp = 5;
  }
  return resp;
}

void executaComando(int cmd, int num, int pos){
  Player resp;
  bool removeu = false;
  switch(cmd){
    case 0:
      inserirInicio(num);
    break;
    case 1:
      inserirFim(num);
    break;
    case 2:
      inserir(pos, num);
    break;
    case 3:
      resp = removerInicio();
      removeu = true;
      tamLJogadores--;
    break;
    case 4:
      resp = remover(num);
      removeu = true;
      tamLJogadores--;
    break;
    case 5:
      resp = removerFim();
      removeu = true;
      tamLJogadores--;
    break;
  }
  
  if(removeu){
    inserirExcluidos(resp.id);
  }
}


// Main
int main() {

    // ----------------------------------------------------------------- //

    // #1 - Start - Read all players in CSV file
    startPlayers();


    // ----------------------------------------------------------------- //

    // #2 - Read input and print players from pub.in id entries
    char in[5];
    scanf(" %[^\n]s", in);
    for(int i = 0; !isEnd(in); i++){
      inserirFim(atoi(in));
      scanf(" %[^\n]s", in);
    }
    int qtdComandos, cmd, num = -1, num2 = -1;
    scanf("%i",&qtdComandos);
    char *in2 = (char*) malloc(20 * sizeof(char));
    char *comando = (char*) malloc(2 * sizeof(char));
    for(int i = 0; i < qtdComandos; i++){
      scanf(" %[^\n]s", in2);
      sscanf(in2, "%s %i %i", comando, &num, &num2);
      cmd = verificaComando(comando);
      executaComando(cmd, num, num2);
    }
    for(int i = 0; i < tamLExcluidos; i++){
      printf("(R) %s\n", player_getName(listaExcluidos[i]));
    }
    for(int j = 0; j < tamLJogadores; j++){
      printf("[%i]",j);
      player_print(listaJogadores[j]);
    }
    return 0;
}

/*int main(void){

char* palavra = "testando se funciona";
int i = indexOf(' ', palavra);
char* sub = subString(palavra, indexOf(' ', palavra), 20);
char* sub2 = subString(palavra, 1, 10);
printf("%s\n%i\n%s\n", palavra, i, sub2);
return 0;
}*/
