package tecinfo.poo.model;

public class Player {
    public String name;
    public int aposta;
    public int wins;
    public int id;

    public Player(String name, int wins, int aposta){
        this.name = name;
        this.wins = wins;
        this.aposta = aposta;
    }

    public Player(String name, int aposta) {
        this(name, 0, aposta);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return this.wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Integer getAposta(){
        return this.aposta;
    }

    public void setAposta(int aposta){
        this.aposta = aposta;
    }

    @Override
    public String toString() {
        return "Player{id=" + id + ", name='" + name + "', wins=" + wins + "}";
    }



}