package tecinfo.poo.model;

public class Player {
    public String name;
    public int wins;
    public int id;

    public Player(String name, int wins) {
        this.name = name;
        this.wins = wins;
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

    @Override
    public String toString() {
        return "Player{id=" + id + ", name='" + name + "', wins=" + wins + "}";
    }



}