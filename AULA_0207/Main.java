import java.util.ArrayList;
import java.util.Scanner;


public class Main{
    
    public static void main(String[] args) {
        System.out.println("Testando...");
        Gato cat = new Gato(2);
        cat.setNome("Luna");
        cat.setRaça("Siamês");
        cat.setPeso(7.2f);
        cat.Miar();
        System.out.println(cat.getNome());
        System.out.println(cat.getRaça());
        System.out.println(cat.getPeso());
        System.out.println(cat.getID());
    }
}
