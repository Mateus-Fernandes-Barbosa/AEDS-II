import java.util.Scanner;

public class Is {
    public static boolean Vogal(String palavra) {
        int n = palavra.length();
        for (int i = 0; i < n; i++) {
            char c = palavra.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                return false;
            }
        }
        return true;
    }

    public static boolean Consoante(String palavra) {
        int n = palavra.length();
        for (int i = 0; i < n; i++) {
            char c = palavra.charAt(i);
            if (!Character.isLetter(c) || "AEIOUaeiou".indexOf(c) != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean Inteiro(String palavra) {
        int n = palavra.length();
        for (int i = 0; i < n; i++) {
            char c = palavra.charAt(i);
            if (!Character.isDigit(c) && (i != 0 || c != '-')) {
                return false;
            }
        }
        return true;
    }

    public static boolean Real(String palavra) {
        int n = palavra.length();
        boolean pontoEncontrado = false;
        for (int i = 0; i < n; i++) {
            char c = palavra.charAt(i);
            if (!Character.isDigit(c)) {
                if (c == '.' && !pontoEncontrado) {
                    pontoEncontrado = true;
                } else {
                    return false;
                }
            }
        }
        return pontoEncontrado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palavra;

        while (true) {
            palavra = scanner.nextLine();
            if (palavra.equals("FIM")) {
                break;
            }

            boolean X1 = Vogal(palavra);
            boolean X2 = Consoante(palavra);
            boolean X3 = Inteiro(palavra);
            boolean X4 = Real(palavra);

            System.out.println((X1 ? "SIM" : "NAO") + " " + (X2 ? "SIM" : "NAO") + " " + (X3 ? "SIM" : "NAO") + " " + (X4 ? "SIM" : "NAO"));
        }
    }
}
