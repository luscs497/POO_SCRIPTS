import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                
            String line;
            while ((line = reader.readLine()) != null) {
                // Manipule os dados aqui (por exemplo, convertendo para maiúsculas)
                String manipulatedLine = line.toUpperCase();
                writer.write(manipulatedLine);
                writer.newLine();
            }

            System.out.println("Manipulação de dados concluída com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
