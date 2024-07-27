import java.util.ArrayList;

public class Ingresso {
    private int code;
    private String cpf_client;
    private String movie_name;
    private int position;
    private int value;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCpf_client() {
        return this.cpf_client;
    }

    public void setCpf_client(String cpf_client) {
        this.cpf_client = cpf_client;
    }

    public String getMovie_name() {
        return this.movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean VerifyCPF(ArrayList<Ingresso> ingressos){
        int aux = 1;
        if(ingressos.size()==0){
            return true;
        }
        String cpf = getCpf_client();
        for(int i=0; i < ingressos.size(); i++){
            if(cpf.equals(ingressos.get(i).getCpf_client())){
                return false;
            }
        }
        return true;
    }

    public boolean VerifyChair(ArrayList<Object> lugares){
        int cont = 0;
        for (Object x : lugares) {
            cont++;
            if(cont == getPosition()){
                if(x == " X "){
                    System.out.println("Essa poltrona já está em uso...escolha apenas alguma sem o X.");
                    return true;
                }
            }
        }
        return false;
    }

}
