public class Informatica extends Produtos{
    public static final float DESCONTO_A_VISTA = 0.1f;
    private String tipoPagamento;

    public Informatica(String tipoPagamento, String nome, float preco) {
        super(nome, preco);
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoPagamento() {
        return this.tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public float calcularPreco(){
        if(getTipoPagamento().equalsIgnoreCase("À vista")){
            return getPreco() - (getPreco() * DESCONTO_A_VISTA);
        }else{
            return getPreco();
        }
    }

}
