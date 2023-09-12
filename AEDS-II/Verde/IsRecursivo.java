import java.util.Scanner;

public class IsRecursivo{
    public static boolean Vogal(String palavra) {
        return VogalRecursivo(palavra, 0);
    }

    private static boolean VogalRecursivo(String palavra, int index) {
        if (index == palavra.length()) {
            return true;
        }

        char c = palavra.charAt(index);
        if ("AEIOUaeiou".indexOf(c) != -1) {
            return VogalRecursivo(palavra, index + 1);
        }

        return false;
    }

    public static boolean Consoante(String palavra) {
        return ConsoanteRecursivo(palavra, 0);
    }

    private static boolean ConsoanteRecursivo(String palavra, int index) {
        if (index == palavra.length()) {
            return true;
        }

        char c = palavra.charAt(index);
        if (Character.isLetter(c) && "AEIOUaeiou".indexOf(c) == -1) {
            return ConsoanteRecursivo(palavra, index + 1);
        }

        return false;
    }

    public static boolean Inteiro(String palavra) {
        return InteiroRecursivo(palavra, 0);
    }

    private static boolean InteiroRecursivo(String palavra, int index) {
        if (index == palavra.length()) {
            return true;
        }

        char c = palavra.charAt(index);
        if ((Character.isDigit(c) && index != 0) || (c == '-' && index == 0)) {
            return InteiroRecursivo(palavra, index + 1);
        }

        return false;
    }

    public static boolean Real(String palavra) {
        return RealRecursivo(palavra, 0, false);
    }

    private static boolean RealRecursivo(String palavra, int index, boolean pontoEncontrado) {
        if (index == palavra.length()) {
            return pontoEncontrado;
        }

        char c = palavra.charAt(index);
        if (Character.isDigit(c)) {
            return RealRecursivo(palavra, index + 1, pontoEncontrado);
        } else if (c == '.' && !pontoEncontrado) {
            return RealRecursivo(palavra, index + 1, true);
        }

        return false;
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

