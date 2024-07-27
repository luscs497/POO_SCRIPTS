public abstract class Produtos {
    public static final float FRETE_POR_KM = 2.0f;
    private String nome;
    private float preco;


    public Produtos(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public abstract float calcularPreco();

    public static float calcularFrete(float distancia){
        return (float) distancia*FRETE_POR_KM;
    }

    public float calcularTotal(float distancia){
        return calcularFrete(distancia) + calcularPreco();
    }

}
