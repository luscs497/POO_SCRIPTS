public class Jogavel extends Personagem implements Controle{
    private int nivel;

    public Jogavel(int nivel, String nome, int vitalidade, Jogo jogo) {
        super(nome, vitalidade, jogo);
        this.nivel = nivel;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        if(nivel >= 1 && nivel <= 5){
            this.nivel = nivel;
        }else{
            System.out.println("Nível inválido!");
        }
    }

    @Override
    public void aplicarGolpeEspecial(Personagem adversario){
        adversario.setVitalidade(adversario.getVitalidade() - (10*getNivel()));
    }

    @Override
    public void botaoA(Personagem personagem, Personagem adversario){
        this.aplicarGolpeNormal(adversario);
    }

    @Override
    public void botaoB(Personagem personagem, Personagem adversario){
        this.aplicarGolpeEspecial(adversario);
    }





    
}
