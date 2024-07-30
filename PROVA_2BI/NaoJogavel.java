public class NaoJogavel extends Personagem{
    private boolean aliado;

    public NaoJogavel(boolean aliado, String nome, int vitalidade, Jogo jogo) {
        super(nome, vitalidade, jogo);
        this.aliado = aliado;
    }

    public boolean isAliado() {
        return this.aliado;
    }

    public boolean getAliado() {
        return this.aliado;
    }

    public void setAliado(boolean aliado) {
        this.aliado = aliado;
    }

    public void aplicarGolpeEspecial(Personagem adversario){
        switch (jogo.getDificuldade()) {
            case "easy":
                adversario.setVitalidade(adversario.getVitalidade() - 20);
                break;
            case "medium":
                adversario.setVitalidade(adversario.getVitalidade() - 30);
                break;
            case "hard":
                adversario.setVitalidade(adversario.getVitalidade() - 40);
                break;
            default:
                System.out.println("Erro! Dificuldade não é válida.");
                break;
        }
    }
}
