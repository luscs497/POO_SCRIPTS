public abstract class Personagem {
    private String nome;
    private int vitalidade;
    protected Jogo jogo;
    
    public Personagem(String nome, int vitalidade, Jogo jogo) {
        this.nome = nome;
        this.vitalidade = vitalidade;
        this.jogo = jogo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVitalidade() {
        return this.vitalidade;
    }

    public void setVitalidade(int vitalidade) {
        if(vitalidade >= 0 && vitalidade <= 100){
            this.vitalidade = vitalidade;
        }else{
            System.out.println("O valor inserido é inválido.");
        }
        
    }

    public Jogo getJogo() {
        return this.jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public void aplicarGolpeNormal(Personagem adversario){
        adversario.setVitalidade(adversario.getVitalidade() - 10);
    }

    public abstract void aplicarGolpeEspecial(Personagem adversario);



}
