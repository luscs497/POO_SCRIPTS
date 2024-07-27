import java.util.ArrayList;
import java.util.Scanner;
//Os bglh não podem ser String, mas object --> MUDE, LOGO!
public class Aluno {
    private String nome, situacao;
    private int matricula;
    private float nota1, nota2, nota3, media;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String r){
        this.nome = r;
    }

    public String getSituacao() {
        if(getMedia()>=7){
            return "aprovado";
        }else if(getMedia()<3){
            return "reprovado";
        }else{
            return "recuperação";
        }
    }

    public void setSituacao(String n){
        this.situacao = n;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public float getNota1() {
        return this.nota1;
    }

    public float getNota2() {
        return this.nota2;
    }

    public float getNota3() {
        return this.nota3;
    }

    public void setNota(int cod, float valorNota) {
        switch(cod){
            case 1:
                this.nota1 = valorNota;
                break;
            case 2:
                this.nota2 = valorNota;
                break;
            case 3:
                this.nota3 = valorNota;
                break;
            default:
                System.out.println("Código inválido! Os códigos variam entre 1 e 3. ");
        }
    }

    public float getMedia() {
        return this.media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public void calcularMedia(){
        setMedia((getNota1() + getNota2() + getNota3())/3);
    }

    public void menu(){
        Scanner reader = new Scanner(System.in);
        ArrayList<Object> aux = new ArrayList<>();
        while(true){
            impress(60, '-');
            System.out.println("MENU PRINCIPAL");
            impress(60, '-');
            System.out.println("1 - CADASTRAR ALUNOS");
            System.out.println("2 - CADASTRAR NOTAS");
            System.out.println("3 - CALCULAR MÉDIAS");
            System.out.println("4 - INFORMAR SITUAÇÕES");
            System.out.println("5 - INFORMAR DADOS DE UM ALUNO");
            System.out.println("6 - ALTERAR NOTA");
            System.out.println("7 - SAIR");
            impress(60, '-');
            int cod = reader.nextInt();
            if(cod!=7){
                switch(cod){
                    case 1:
                        System.out.println("OPÇÃO SELECIONADA: CADASTRAR ALUNO");
                        System.out.println("Insira a matrícula do aluno 1: ");
                        a1.setMatricula(reader.nextInt());
                        System.out.println("Insira o nome do aluno 1: ");
                        reader.nextLine();
                        a1.setNome(reader.nextLine());


                        System.out.println("Insira a matrícula do aluno 2: ");
                        a2.setMatricula(reader.nextInt());
                        reader.nextLine();
                        System.out.println("Insira o nome do aluno 2: ");
                        a2.setNome(reader.nextLine());
                        

                        System.out.println("Insira a matrícula do aluno 3: ");
                        a3.setMatricula(reader.nextInt());
                        reader.nextLine();
                        System.out.println("Insira o nome do aluno 3: ");
                        a3.setNome(reader.nextLine());

                        aux.add(a1.matricula);
                        aux.add(a2.matricula);
                        aux.add(a3.matricula);
                        
                        break;
                    case 2:
                        //System.out.println("TESTANDO, O NOME DO ALUNO 1 É "+a1.nome);
                        System.out.println("Insira a 1° nota do aluno 1: ");
                        a1.setNota(1, reader.nextFloat());
                        System.out.println("Insira a 2° nota do aluno 1: ");
                        a1.setNota(2, reader.nextFloat());
                        System.out.println("Insira a 3° nota do aluno 1: ");
                        a1.setNota(3, reader.nextFloat());
                
                        System.out.println("Insira a 1° nota do aluno 2: ");
                        a2.setNota(1, reader.nextFloat());
                        System.out.println("Insira a 2° nota do aluno 2: ");
                        a2.setNota(2, reader.nextFloat());
                        System.out.println("Insira a 3° nota do aluno 2: ");
                        a2.setNota(3, reader.nextFloat());

                
                        System.out.println("Insira a 1° nota do aluno 3: ");
                        a3.setNota(1, reader.nextFloat());
                        System.out.println("Insira a 2° nota do aluno 3: ");
                        a3.setNota(2, reader.nextFloat());
                        System.out.println("Insira a 3° nota do aluno 3: ");
                        a3.setNota(3, reader.nextFloat());
                        
                        //System.out.println("A nota 1 do 1° aluno é: "+a1.nota1);
                        
                        
                        
                        break;
                    case 3:
                        //System.out.println("TESTANDO, AS NOTAS DO ALUNO 1 SÃO "+a1.nota1+", "+a1.nota2+", "+a1.nota3);
                        //System.out.println("TESTANDO, AS NOTAS DO ALUNO 2 SÃO "+a2.nota1+", "+a2.nota2+", "+a2.nota3);
                        //System.out.println("TESTANDO, AS NOTAS DO ALUNO 3 SÃO "+a3.nota1+", "+a3.nota2+", "+a3.nota3);
                        
                        a1.calcularMedia();
                        //System.out.println(a1.media);
                        a1.setSituacao(a1.getSituacao());
                        
                        a2.calcularMedia();
                        //System.out.println(a2.media);
                        a2.setSituacao(a2.getSituacao());
                        
                        a3.calcularMedia();
                        //System.out.println(a3.media);
                        a3.setSituacao(a3.getSituacao());
                        
                        break;
                    case 4:
                        System.out.println("O aluno 1 está (em) "+ a1.situacao);
                        System.out.println("O aluno 2 está (em) "+ a2.situacao);
                        System.out.println("O aluno 3 está (em) "+ a3.situacao);
                        break;
                    case 5:
                        System.out.println("OPÇÃO SELECIONADA: 5");
                        System.out.print("Insira a matrícula do aluno cujo deseja ver os dados: ");
                        int c = reader.nextInt();
                        switch(aux.indexOf(c)){
                            case 0:
                                System.out.println("O nome do aluno com a matrícula "+ c + " é " + a1.nome +", suas notas 1, 2 e 3, respectivamente, foram " + a1.nota1 + ", " + a1.nota2 + " e " + a1.nota3 + "; sua média foi " + a1.media + " e sua situação é " + a1.situacao);
                                break;
                            case 1:
                                System.out.println("O nome do aluno com a matrícula "+ c + " é " + a2.nome +", suas notas 1, 2 e 3, respectivamente, foram " + a2.nota1 + ", " + a2.nota2 + " e " + a2.nota3 + "; sua média foi " + a2.media + " e sua situação é " + a2.situacao);
                                break;
                            case 2:
                                System.out.println("O nome do aluno com a matrícula "+ c + " é " + a3.nome +", suas notas 1, 2 e 3, respectivamente, foram " + a3.nota1 + ", " + a3.nota2 + " e " + a3.nota3 + "; sua média foi " + a3.media + " e sua situação é " + a3.situacao);                               
                                break;
                            default:
                                System.out.println("O aluno com a matrícula " + c + " não foi encontrado.");
                                break;
                        }
                        break;
                    case 6:
                        System.out.println("OPÇÃO SELECIONADA: 6");
                        System.out.print("Insira a matrícula do aluno cujo deseja ver os dados: ");
                        int d = reader.nextInt();
                        int c1;
                        float n1;
                        switch(aux.indexOf(d)){
                            case 0:
                                System.out.println("O aluno com a matrícula "+d+" é " + a1.nome + "! Qual das 3 notas você deseja modificar? [1/2/3]");
                                c1 = reader.nextInt();
                                System.out.println("Insira a nota nova: ");
                                n1 = reader.nextFloat();
                                a1.setNota(c1,n1);
                                a1.calcularMedia();
                                a1.setSituacao(a1.getSituacao());
                                System.out.println("A nova situação do aluno é "+a1.situacao);
                                break;
                            case 1:
                                System.out.println("O aluno com a matrícula "+d+" é " + a2.nome + "! Qual das 3 notas você deseja modificar? [1/2/3]");
                                c1 = reader.nextInt();
                                System.out.println("Insira a nota nova: ");
                                n1 = reader.nextFloat();
                                a2.setNota(c1,n1);
                                a2.calcularMedia();
                                a2.setSituacao(a2.getSituacao());
                                System.out.println("A nova situação do aluno é "+a2.situacao);
                                break;
                            case 2:
                                System.out.println("O aluno com a matrícula "+d+" é " + a3.nome + "! Qual das 3 notas você deseja modificar? [1/2/3]");
                                c1 = reader.nextInt();
                                System.out.println("Insira a nota nova: ");
                                n1 = reader.nextFloat();
                                a3.setNota(c1,n1);
                                a3.calcularMedia();
                                a3.setSituacao(a3.getSituacao());
                                System.out.println("A nova situação do aluno é "+a3.situacao);
                                break;
                            default:
                                System.out.println("O aluno com a matrícula " + d + " não foi encontrado.");
                                break;
                        }
                        //break;
                    default:
                        break;
                }
            }else{
                break;
            }

        }
        reader.close();
    }

    public void impress(int qtd, char ch){
        for(int i=0; i < qtd; i++){
            System.out.print(ch);
        }
        System.out.println();
    }
}
