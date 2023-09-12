class PalindromoRecursivo {
    public static boolean EhPalindromo(String palavra) {
        return EhPalindromoRecursivo(palavra, 0, palavra.length() - 1);
    }

    private static boolean EhPalindromoRecursivo(String palavra, int inicio, int fim) {
        // Caso base: quando a string tem tamanho 0 ou 1, é um palíndromo.
        if (inicio >= fim) {
            return true;
        }

        // Verifica se os caracteres nas posições inicio e fim são iguais.
        if (palavra.charAt(inicio) == palavra.charAt(fim)) {
            // Chamada recursiva para verificar o restante da string.
            return EhPalindromoRecursivo(palavra, inicio + 1, fim - 1);
        }

        return false;
    }

    public static boolean Strcmp(String palavra) {
        return palavra.equals("FIM");
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        String palavra = MyIO.readLine();
        while (!Strcmp(palavra)) {
            if (!EhPalindromo(palavra)) {
                MyIO.println("NAO");
            } else {
                MyIO.println("SIM");
            }
            palavra = MyIO.readLine();
        }
    }
}

