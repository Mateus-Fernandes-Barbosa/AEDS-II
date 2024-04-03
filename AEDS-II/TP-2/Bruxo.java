class Date{
    //Atributos da Classe
     private int dia;
     private int mes;
     private int ano;
    //Fim atributos da classe

    //Métodos Set's
        public void setDia(int dia){
            this.dia = dia;
        }

        public void setMes(int mes){
            this.mes = mes; 
        }

        public void setAno(int ano){
            this.ano = ano;
        }
    //Fim métodos Set's

    //Métodos Get's
        public int getDia(){
            return this.dia;
        }
        public int getMes(){
            return this.mes;
        }
        public int getAno(){
            return this.ano;
        }
    //Fim métodos Get's

    //Métodos Construtores
        public Date(int dia, int mes, int ano){
            setDia(dia);
            setMes(mes);
            setAno(ano);
        }

        public Date(){
            this(0,0,0);
        }
    //Fim métodos construtores
}

public class Bruxo{
    //Atributos da Classe
        private String id;
        private String name;
        private String [] nicknames;
        private String house;
        private String genealogia;
        private String species;
        private String patronus;
        private Boolean staff;
        private Boolean studing;
        private String actorName;
        private Boolean alive;
        private String [] outrosAtores;
        private Date dataNasc;
        private String eyeColor;
        private String gender;
        private String hairColor;
        private Boolean wizard;
    //Fim atributos da classe

    //Métodos Set's
        public void setId(String entrada){
            this.id = entrada;
        }
        public void setName(String entrada){
            this.name = entrada;
        }
        public void setNicknames(String [] entrada){
            for(int i = 0; i < entrada.length; i++){
                this.nicknames[i] = entrada[i];
                aumentarTamArray(this.nicknames);
            }
        }
        public void setHouse(String entrada){
            this.house = entrada;
        }
        public void setGenealogia(String entrada){
            this.genealogia = entrada;
        }
        public void setSpecies(String entrada){
            this.species = entrada;
        }
        public void setPatronus(String entrada){
            this.patronus = entrada;
        }
        public void setStaff(Boolean staff){
            this.staff = staff;
        }
        public void setStuding(Boolean studing){
            this.studing = studing;
        }
        public void setActorName(String entrada){
            this.actorName = entrada;
        }
        public void setAlive(Boolean alive){
            this.alive = alive;
        }
        public void setOutrosAtores(String [] entrada){
            for(int i = 0; i < entrada.length; i++){
                this.outrosAtores[i] = entrada[i];
                aumentarTamArray(this.outrosAtores);
            }
        }
        public void setDataNasc(String entrada){
            int dia = Integer.parseInt(entrada.substring(0, entrada.indexOf('-')));
            entrada = entrada.substring(entrada.indexOf('-') + 1);
            int mes = Integer.parseInt(entrada.substring(0, entrada.indexOf('-')));
            entrada = entrada.substring(entrada.indexOf('-') + 1);
            int ano = Integer.parseInt(entrada.substring(0, entrada.indexOf('-')));
            this.dataNasc = new Date(dia,mes,ano);
        }
        public void setEyeColor(String entrada){
            this.eyeColor = entrada;
        }
        public void setGender(String entrada){
            this.gender = entrada;
        }
        public void setHairColor(String entrada){
            this.hairColor = entrada;
        }
        public void setWizard(Boolean wizard){
            this.wizard = wizard;
        }
    //Fim métodos set's
    public static void main(String [] args){
    }
}