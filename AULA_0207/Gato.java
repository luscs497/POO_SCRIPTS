public class Gato extends Animal{

    public Gato(int newID){
        super(newID);
    }
    public int numColeira;

    public int getNumColeira() {
        return this.numColeira;
    }

    public void setNumColeira(int numColeira) {
        this.numColeira = numColeira;
    }
    
    public void Miar(){
        Soar();
        System.out.println("miaaaau!");
    }
}