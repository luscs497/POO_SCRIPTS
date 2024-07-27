public class Animal{
    public int id;
    
    public Animal(int id){
        this.id = id;
    }
    public String nome;
    public String raça;
    public float peso;

    public int getID(){
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaça() {
        return this.raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void Soar(){
        System.out.print("O animal diz: ");
    }
    //Grafo é a estrutura de dados mais importantes
    
}

//Polimorfismo é a sobrescrita e sobrecarga, refere-se apenas À métodos! Realiza-se através da recodificação de um ou mais métodos
//SOBRECARGA:
//Temos um método com um nome igual, mas a lista de parâmetros é diferente. Seja pela quantidade e/ou tipo.
//Nem é preciso da herança

//SOBRESCRITA:
//Permite que métodos da classe pai sejam reescritos nas classes filhas, transformando métodos genéricos em específicos e implementando outras funcionalidades;
//Os métodos que serão sobrescritos devem possuirr o mesmo nome, tipo de retorno e quantidade de parâmetros do 
//método inicial. COmo uma calculadora científica que puxa o método somar! Na calc orirginal ele só soma int, mas na científica, soma quaisquer.
//Em cima do método da sobrescrita, coloque o @override;

//Testar a inicialização de uma variável fora do builder
