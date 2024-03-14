import java.io.*;

public class LeituraReversa {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Digite o número de valores a serem lidos: ");
            int n = Integer.parseInt(reader.readLine());

            // Abrir o arquivo para escrita
            RandomAccessFile arquivo = new RandomAccessFile("valores.txt", "rw");

            // Ler e salvar os valores sequencialmente
            for (int i = 0; i < n; i++) {
                System.out.print("Digite o valor " + (i + 1) + ": ");
                double valor = Double.parseDouble(reader.readLine());
                arquivo.writeDouble(valor);
            }

            // Fechar o arquivo
            arquivo.close();

            // Reabrir o arquivo para leitura de trás para frente
            arquivo = new RandomAccessFile("valores.txt", "r");

            // Posicionar o ponteiro no final do arquivo
            arquivo.seek(arquivo.length());

            System.out.println("Valores lidos de trás para frente:");

            // Ler e imprimir os valores de trás para frente
            while (arquivo.getFilePointer() > 0) {
                arquivo.seek(arquivo.getFilePointer() - 8); // Tamanho de um double é 8 bytes
                double valor = arquivo.readDouble();
                System.out.println(valor);
            }

            // Fechar o arquivo novamente
            arquivo.close();

        } catch (IOException e) {
            System.err.println("Erro ao manipular o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Formato inválido. Certifique-se de inserir números válidos.");
        }
    }
}

