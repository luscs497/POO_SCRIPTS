import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args) {
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Pessoa> a  = new ArrayList<>();
        Pessoa x = new Pessoa();
        x.nome = "Lucas";
        Pessoa y = new Pessoa();
        Pessoa z = new Pessoa();
        a.add(x);
        a.add(y);
        a.add(z);
        //a.set(1,setNome("Bruno"));

        for(Pessoa i : a){
            System.out.println(i.getNome());
        }
        //a.add(p1);
        //a.add(p2);
        //a.add(p3);


        

        b.add(7);
        b.add(2);
        b.add(3);
        b.add(-2);
        //for...each
        for(int i : b){
            System.out.println(i);
        }
        b.set(2,50); //comando bom demaisi, muda o caba na posição 2 p 
        b.remove(2); //remove o bglh do índice 3;
        System.out.println("o tamanho novo é " + b.size());
        
        //se b fosse um int [] b, funcionava tbm

        //sorting --> organiza em ordem
        b.sort(null); //ordem crescente
        b.sort(Collections.reverseOrder());
        for(int i : b){
            System.out.println(i);
        }


    }
}
