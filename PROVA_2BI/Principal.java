public class Principal{
    public static void main(String[] args) {
        Jogo j1 = new Jogo("easy");
        Jogavel JO1 = new Jogavel(4, "Lucas", 50, j1);
        NaoJogavel JN2 = new NaoJogavel(true, "Arthur", 90, j1);
        NaoJogavel JN3 = new NaoJogavel(false, "Jonas", 100, j1);
        j1.addPersonagens(JO1);
        j1.addPersonagens(JN2);
        j1.addPersonagens(JN3);
        JO1.botaoA(JO1, JN2);
        JO1.botaoA(JO1, JN2);
        JO1.botaoB(JO1, JN2);
        System.out.println("A vida do jogador " + JN2.getNome() + ", é " + JN2.getVitalidade()); 
        

        //OUTROS TESTES
        j1.removePersonagens(JO1);
        JN3.aplicarGolpeEspecial(JN2);
        System.out.println("A vida do jogador " + JN2.getNome() + ", é " + JN2.getVitalidade());
    }
}