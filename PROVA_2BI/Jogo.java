import java.util.ArrayList;

public class Jogo {
    private String dificuldade;
    private ArrayList <Personagem> listaPersonagens;

    public Jogo(String dificuldade) {
        this.dificuldade = dificuldade;
        this.listaPersonagens = new ArrayList<>();
    }

    public String getDificuldade() {
        return this.dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public ArrayList <Personagem> getListaPersonagens() {
        return this.listaPersonagens;
    }

    public void addPersonagens(Personagem personagem) {
        this.listaPersonagens.add(personagem);
    }

    public void removePersonagens(Personagem personagem) {
        this.listaPersonagens.remove(personagem);
    }
}
