import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReader {
    public static void main(String[] args) {
        String csvFile = "ranking.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll();
            for (String[] record : records) {
                for (String field : record) {
                    System.out.print(field + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
