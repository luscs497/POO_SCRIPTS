public class Main{
    public static void main(String[] args) {
        Produtos p1 = new Informatica("À vista", "Computador", 5000);
        Produtos p2 = new Informatica("Parcelado", "Celular", 1500);
        Produtos p3 = new Vestuario(6, "Camisa", 150);
        System.out.println("O valor de p1 é: " + p1.calcularTotal(15));
        System.out.println("O valor de p2 é: " + p2.calcularTotal(14));
        System.out.println("O valor de p3 é: " + p3.calcularTotal(13));
    }

}