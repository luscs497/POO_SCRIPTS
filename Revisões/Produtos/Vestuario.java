public class Vestuario extends Produtos{
    public static final float DESCONTO_QTD = 0.05f;
    private int quantidade;

    public Vestuario(int quantidade, String nome, float preco) {
        super(nome, preco);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public float calcularPreco(){
        if(getQuantidade() > 5){
            return getPreco() - (DESCONTO_QTD * getPreco());
        }else{
            return getPreco();
        }
    }


}
