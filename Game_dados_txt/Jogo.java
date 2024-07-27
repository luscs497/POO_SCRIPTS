import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;


public class Jogo {
    public int qtdJogadores;
    public int resultado;
    ArrayList<String> names = new ArrayList<>();
    public ArrayList <Jogador> jogadores = new ArrayList<>();
    public Dado dado1 = new Dado();
    public Dado dado2 = new Dado();
    Jogador j1 = new Jogador();
    Scanner r = new Scanner(System.in);
    

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.InserirJogadores();
        jogo.InserirApostas();
        jogo.jogarDados();
        jogo.mostrarResultado();
        jogo.mostrarVencedor();
        jogo.r.close();
    }

    public void SaveName(String name){
        String filePath = "Jogadores.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String data = name + "\n";
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void InserirJogadores(){
        int cod;
        while(true){
            System.out.print("Quantos jogadores participarão da partida? [1 - 11] ");
            cod = r.nextInt();
            if(cod <= 11 && cod >= 1){
                break;
            }else{
                System.out.println("Você inseriu um valor inválido! Digite um valor entre 1 e 11. ");
            }
        }
        setQtdJogadores(cod);
        r.nextLine();
        qtdJogadores = getQtdJogadores();
        for(int i=1; i<=qtdJogadores; i++){
            System.out.print("Qual é o seu nome? ");
            this.names.add(r.nextLine());
        }
    }

    public void InserirApostas(){
        for(int i=0; i< getQtdJogadores(); i++){
            int cod;
            while (true) {
                System.out.print(names.get(i) + ", digite o valor que você deseja apostar para o somatório das faces: ");
                cod = r.nextInt();
                if(cod>=2 && cod <= 12){
                    break;
                }else{
                    System.out.println("Você digitou uma aposta inválida! Digite um valor entre 2 e 12...");
                }
            }
            this.names.set(i,this.names.get(i)+", "+cod);
            SaveName(this.names.get(i));
        }

    }

    public void jogarDados(){
        dado1.setValorFace();
        dado2.setValorFace();
    }

    public void mostrarResultado(){
        setResultado(dado1.getValorFace() + dado2.getValorFace());
        System.out.println("O resultado do lançamento de dados foi "+ getResultado() + ".");

    }

    public boolean mostrarVencedor(){
        try {
            String PathFile = "Jogadores.txt";
            byte[] bytes = Files.readAllBytes(Paths.get(PathFile));
            String conteudo = new String(bytes);
            String[] nomes = conteudo.split("\n");
            //System.out.println(conteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String x : this.names) {
            String[] aux = x.split(", ");
            //System.out.println(aux[0] + ", " + aux[1]);
            if(getResultado() == Integer.parseInt(aux[1])){
               System.out.println("O jogador de nome "+ aux[0]  + " venceu! Parabéns!");
               
               return true;
            }
        }

        System.out.println("Nenhum jogador venceu! Rs, pelo visto, eu (máquina), venci!");
        return false;
    }

    public int getQtdJogadores(){
        return this.qtdJogadores;
    }

    public void setQtdJogadores(int newQtdJogadores){
        this.qtdJogadores = newQtdJogadores;
    }

    public int getResultado(){
        return this.resultado;
    }

    public void setResultado(int newResultado){
        this.resultado = newResultado;
    }

    public void guardarJogadores(){
        
    }
}
