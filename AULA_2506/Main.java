import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        ArrayList<Ingresso> ingressos = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        int code = 0;
        int cod = 0;
        int poltrona = 0;
        ArrayList<Object> lugares = new ArrayList<>();
        do {
            code++;
            System.out.println("<------------------------------------->");
            System.out.println("Digite 1 para comprar um ingresso [1]");
            System.out.println("Digite 2 para visualizar/alterar um ingresso [2]");
            System.out.println("Digite 3 para desistir de um ingresso [3]");
            System.out.println("Digite 999 para encerrar o sistema [999]");
            System.out.println("<------------------------------------->");
            cod = reader.nextInt();
            Ingresso ing = new Ingresso();
            switch(cod){
                case 1:
                    ing.setCode(code);
                    int codig = 1;
                    System.out.print("Insira o cpf: ");
                    String resp = reader.next();
                    ing.setCpf_client(resp);
                    if(ing.VerifyCPF(ingressos)){
                        reader.nextLine();

                        System.out.print("Qual é o filme? ");
                        ing.setMovie_name(reader.nextLine());

                        System.out.print("Você paga meia? [sim/não] ");
                        String aux = reader.nextLine();

                        if(aux.toLowerCase().equals("sim")){
                            ing.setValue(8);
                        }else{
                            ing.setValue(16);
                        }

                        if (lugares.isEmpty()) {
                            for (int i = 1; i <= 120; i++) {
                                lugares.add(i);
                            }
                        }

                        do {
                            System.out.println("Qual posição você escolhe? ");
                            
                            int contador = 0;
                            for (Object x : lugares) {
                                contador++;
                                System.out.print(x + " ");
                                if(contador%10 == 0){
                                    System.out.println();
                                }
                            }
                            poltrona = reader.nextInt();
                            ing.setPosition(poltrona);
                            
                        } while (ing.VerifyChair(lugares));
                        lugares.set((poltrona-1)," X ");
                    }else{
                        System.out.println("O CPF inserido já foi utilizado! Só é permitido um ingresso por CPF");
                    }
                    ingressos.add(ing);
                    break;
                    
                case 2:
                    System.out.print("Insira o seu CPF: ");
                    String cpf = reader.next();
                    int aux_1 = 121;
                    for(int i=0; i < ingressos.size(); i++){
                        if(cpf.equals(ingressos.get(i).getCpf_client())){
                            aux_1 = i;
                            break;
                        }
                    }
                    if(aux_1 !=121 ){
                        do {
                            System.out.println("------------------------");
                            System.out.println("Encontramos o seu ingresso!");
                            System.out.println("------------------------");
                            System.out.println("Code:               " + ingressos.get(aux_1).getCode());
                            System.out.println("CPF: [digite 1]     " + ingressos.get(aux_1).getCpf_client());
                            System.out.println("Filme: [digite 2]   " + ingressos.get(aux_1).getMovie_name());
                            System.out.println("Posição: [digite 3] " + ingressos.get(aux_1).getPosition());
                            System.out.println("Valor: [digite 4]   " + ingressos.get(aux_1).getValue());
                            System.out.println("------------------------");
                            System.out.print("O que você deseja alterar?");
                            cod = reader.nextInt();
                            switch (cod) {
                                case 1:
                                    System.out.print("Digite o seu novo CPF: ");
                                    resp = reader.next();
                                    ingressos.get(aux_1).setCpf_client(resp);
                                    if(ingressos.get(aux_1).VerifyCPF(ingressos) || resp.equals(ingressos.get(aux_1).getCpf_client())){
                                        break;
                                    }
                                    System.out.println("Você digitou um CPF inválido. Ele já está em uso. Tente novamente :)");
                                    System.out.println("--------------------------------------------------------------------");
                                    break;
                                case 2:
                                    System.out.print("Digite o novo nome do filme: ");
                                    resp = reader.next();
                                    ingressos.get(aux_1).setMovie_name(resp);
                                    break;
                                case 3:
                                    do {
                                        System.out.println("Qual posição você escolhe? ");
                                        
                                        int contador = 0;
                                        
                                        int index = ingressos.get(aux_1).getPosition();
                                        lugares.set(index-1, index);

                                        for (Object x : lugares) {
                                            contador++;
                                            System.out.print(x + " ");
                                            if(contador%10 == 0){
                                                System.out.println();
                                            }
                                        }
                                        System.out.println("---------------------------------------");
                                        poltrona = reader.nextInt();
                                        ing.setPosition(poltrona);
                                        int c = reader.nextInt();
                                    } while (ing.VerifyChair(lugares));
                                    lugares.set((poltrona-1)," X ");
                                    break;
                                case 4:
                                    System.out.print("Você quer alterar o valor? você paga meia? [sim/não]");
                                    String aux = reader.nextLine();
                                    if(aux.toLowerCase().equals("sim")){
                                        ingressos.get(aux_1).setValue(8);
                                    }else{
                                        ingressos.get(aux_1).setValue(16);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (cod != 999);

                    }else{
                        System.out.println("Não encontramos o seu ingresso(:/).");
                    }
                    break;
                case 3:
                    System.out.print("Insira o seu CPF: ");
                    cpf = reader.next();
                    aux_1 = 121;
                    for(int i=0; i < ingressos.size(); i++){
                        if(cpf.equals(ingressos.get(i).getCpf_client())){
                            aux_1 = i;
                            break;
                        }
                    }
                    if(aux_1!=121){
                        System.out.println("Encontramos o seu ingresso! Você tem certeza que deseja o apagar? [sim/não] ");
                        resp = reader.nextLine();
                        if(resp.toLowerCase().equals("sim")){
                            System.out.println("Ingresso excluído com sucesso!");
                            ingressos.remove(aux_1);
                        }
                    }else{
                        System.out.println("CABA DE PEIA! Não achamos seu ingresso. Vaza.");
                    }
                    break;
                default:
                    break;
            }
            

            
        } while (cod != 999);
        reader.close();
    }
}