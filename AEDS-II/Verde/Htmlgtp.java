import java.io.*;
import java.net.*;

public class Html {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String endereco, nome;

            endereco = reader.readLine();
            while (!endereco.equals("FIM")) {
                nome = reader.readLine();

                if (endereco.startsWith("http://") || endereco.startsWith("https://")) {
                    // Realiza uma requisição HTTP para obter o código-fonte da página web
                    String html = getHtml(endereco);

                    // Conta as ocorrências
                    int[] counts = contarOcorrencias(html);

                    // Exibe os resultados
                    System.out.println(formatResultado(counts, nome));
                } else {
                    System.out.println("Endereço inválido: " + endereco);
                }

                endereco = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getHtml(String endereco) {
        StringBuilder html = new StringBuilder();
        try {
            URL url = new URL(endereco);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                html.append(line);
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html.toString();
    }

    public static int[] contarOcorrencias(String html) {
        int[] counts = new int[28]; // Agora inclui índices 26 e 27 para <br> e <table>

        int len = html.length();
        for (int i = 0; i < len; i++) {
            char c = html.charAt(i);
            if (Character.isLetter(c)) {
                // Converte para minúscula
                c = Character.toLowerCase(c);
                counts[c - 'a']++;
            } else if (c == '<') {
                if (i + 4 < len && html.charAt(i + 1) == 'b' && html.charAt(i + 2) == 'r' && html.charAt(i + 3) == '>') {
                    counts[26]++; // "<br>"
                } else if (i + 6 < len && html.charAt(i + 1) == 't' && html.charAt(i + 2) == 'a' && html.charAt(i + 3) == 'b'
                        && html.charAt(i + 4) == 'l' && html.charAt(i + 5) == 'e' && html.charAt(i + 6) == '>') {
                    counts[27]++; // "<table>"
                }
            }
        }

        return counts;
    }

    public static String formatResultado(int[] counts, String nome) {
        StringBuilder result = new StringBuilder();
        result.append(nome).append(" ");
        result.append("a(").append(counts[0]).append(") ");
        result.append("e(").append(counts[4]).append(") ");
        result.append("i(").append(counts[8]).append(") ");
        result.append("o(").append(counts[14]).append(") ");
        result.append("u(").append(counts[20]).append(") ");
        result.append("á(").append(counts[1]).append(") ");
        result.append("é(").append(counts[5]).append(") ");
        result.append("í(").append(counts[9]).append(") ");
        result.append("ó(").append(counts[15]).append(") ");
        result.append("ú(").append(counts[21]).append(") ");
        result.append("à(").append(counts[2]).append(") ");
        result.append("è(").append(counts[6]).append(") ");
        result.append("ì(").append(counts[10]).append(") ");
        result.append("ò(").append(counts[16]).append(") ");
        result.append("ù(").append(counts[22]).append(") ");
        result.append("ã(").append(counts[3]).append(") ");
        result.append("õ(").append(counts[17]).append(") ");
        result.append("â(").append(counts[7]).append(") ");
        result.append("ê(").append(counts[11]).append(") ");
        result.append("î(").append(counts[12]).append(") ");
        result.append("ô(").append(counts[13]).append(") ");
        result.append("û(").append(counts[18]).append(") ");
        result.append("consoante(").append(counts[23]).append(") ");
        result.append("<br>(").append(counts[26]).append(") ");
        result.append("<table>(").append(counts[27]).append(")");

        return result.toString();
    }
}

