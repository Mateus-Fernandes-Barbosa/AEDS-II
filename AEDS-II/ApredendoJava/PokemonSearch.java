class Pokemon{
    //Variáveis da Classe
    private String nome;
    private int quantidade;
    
    //Métodos sets
    public void SetQtd(int n){
        this.quantidade = n;
    }
    public void SetNome(String palavra){
        this.nome = palavra;
    }

    //Métodos gets
    public int GetQtd(){
        return this.quantidade;
    }
    public String GetNome(){
        return this.nome;
    }

    //Construtores
    Pokemon(String palavra){
        SetNome(palavra);
        SetQtd(1);
    }
    
    Pokemon(String palavra, int n){
        SetNome(palavra);
        SetQtd(n);
    }
}

public class PokemonSearch{

    public static int ConferePokemon(Pokemon [] lista, String nome, int qtdPokemonCapturado){
        int resp = -1;
        //MyIO.println("Maçã"); Teste de Funcionamento da Operação
        //MyIO.println("QtdPokemons: " + qtdPokemonCapturado); Teste de Funcionamento da Operação
        for(int i = 0; i < qtdPokemonCapturado; i++){
            //MyIO.println("i2: " + i); Teste de Funcionamento da Operação
            if(nome.equals(lista[i].GetNome())){
                resp = i;
                i = lista.length;
            }
        }
        return resp;
    } 

    public static int NumTotalPokemons = 151;
    public static void main(String [] args){
        int qtdPokemonCapturado, quantidadeTotal = 1;
        qtdPokemonCapturado = MyIO.readInt();
        Pokemon [] capturados = new Pokemon[qtdPokemonCapturado];
        capturados[0] = new Pokemon(MyIO.readLine());
        for(int i = 1; i < qtdPokemonCapturado; i++){
            String aux = MyIO.readLine();
            //MyIO.println("i: " + i); Teste de Funcionamento da Operação
            int auy = ConferePokemon(capturados, aux, quantidadeTotal);
            if(auy != -1){
                capturados[i] = new Pokemon(aux, (capturados[auy].GetQtd() + 1));
                capturados[auy].SetQtd(capturados[auy].GetQtd() + 1);
                //MyIO.println("Banana"); Teste de Funcionamento da Operação
            }
            else{
                quantidadeTotal++;
                //MyIO.println("QtdPokemons2: " + quantidadeTotal); Teste de Funcionamento da Operação
                capturados[i] = new Pokemon(aux);
                //MyIO.println("Limão"); Teste de Funcionamento da Operação
            }
            
        }
        quantidadeTotal = 151 - quantidadeTotal;
        MyIO.println(quantidadeTotal);
    }
}