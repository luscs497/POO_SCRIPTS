import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculator {
    // Atributos
    Object valueA;
    Object valueB;
    ArrayList<Object> arrayList = new ArrayList<>();
    char op;
    char base;

    // Métodos
    public char getBase(){
        return this.base;
    }

    public void setBase(char base){
        this.base = base;
    }

    public Object getValueA() {
        return this.valueA;
    }

    public void setValueA(Object valueA) {
        this.valueA = valueA;
    }

    public Object getValueB() {
        return this.valueB;
    }

    public void setValueB(Object valueB) {
        this.valueB = valueB;
    }

    public ArrayList<Object> getArrayList() {
        return this.arrayList;
    }

    public void setArrayList(ArrayList<Object> arrayList) {
        this.arrayList = arrayList;
    }

    public char getOp() {
        return this.op;
    }

    public void setOp(char op) {
        this.op = op;
    }


    public ArrayList<Object> calculate_n() {
        ArrayList<Object> list = new ArrayList<>();
        Object valueA;
        Object valueB;
        Object aux;
        switch(base){
            case 'd':
                valueA = (float) getValueA();
                valueB = (float) getValueB();
                aux = (float) 0;
                switch (getOp()) {
                    case '+':
                        aux = (float) valueA + (float) valueB;
                        break;
                    case '-':
                        aux = (float) valueA - (float) valueB;
                        break;
                    case '*':
                        aux = (float) valueA * (float) valueB;
                        break;
                    case '/':
                        aux = (float) valueA / (float) valueB;
                        break;
                    default:
                        System.out.println("Você digitou um operador inválido!");
                }
                list.add(aux);
                break;
            case 'b':
                //setValueA(String.valueOf(getValueA()));
                setValueA(toDec(getValueA().toString()));
                setValueB(toDec(getValueB().toString()));
                valueA = Integer.parseInt(getValueA().toString());
                valueB = Integer.parseInt(getValueB().toString());
                aux = 0;
                switch(getOp()){
                    case '+':
                        aux = (int) valueA + (int) valueB;
                        break;
                    case '-':
                        aux = (int) valueA - (int) valueB;
                        break;
                    case '*':
                        aux = (int) valueA * (int) valueB;
                        break;
                    case '/':
                        aux = (int) valueA / (int) valueB;
                        break;
                }
                setBase('d');
                list.add(toBinarie(String.valueOf(aux)));
                System.out.println(aux);
                String aux1 = String.valueOf(aux);
                System.out.println(toBinarie(aux1));
                break;
            case 'h':
                //setValueA(String.valueOf(getValueA()));
                setValueA(toDec(getValueA().toString()));
                setValueB(toDec(getValueB().toString()));
                valueA = Integer.parseInt(getValueA().toString());
                valueB = Integer.parseInt(getValueB().toString());
                aux = 0;
                switch(getOp()){
                    case '+':
                        aux = (int) valueA + (int) valueB;
                        break;
                    case '-':
                        aux = (int) valueA - (int) valueB;
                        break;
                    case '*':
                        aux = (int) valueA * (int) valueB;
                        break;
                    case '/':
                        aux = (int) valueA / (int) valueB;
                        break;
                }
                //System.out.println(aux);
                setBase('d');
                list.add(toHexa(String.valueOf(aux)));
                break;
            case 'o':
                setValueA(toDec(getValueA().toString()));
                setValueB(toDec(getValueB().toString()));
                valueA = Integer.parseInt(getValueA().toString());
                valueB = Integer.parseInt(getValueB().toString());
                aux = 0;
                switch(getOp()){
                    case '+':
                        aux = (int) valueA + (int) valueB;
                        break;
                    case '-':
                        aux = (int) valueA - (int) valueB;
                        break;
                    case '*':
                        aux = (int) valueA * (int) valueB;
                        break;
                    case '/':
                        aux = (int) valueA / (int) valueB;
                        break;
                }
                setBase('d');
                list.add(toOctal(String.valueOf(aux)));
                break;
        }
        
        setArrayList(list);
        return getArrayList();
    }



    public ArrayList<Object> toBinarie(String resu1){
        ArrayList<Object> resp = new ArrayList<>();
        int aux=0;
        switch (getBase()){
            case 'd':
                int resu = Integer.parseInt(resu1);
                while (resu >= 2) {
                    resp.add(resu % 2);
                    resu = resu / 2;
                }
                resp.add(resu);
                Collections.reverse(resp);
                break;
            case 'h':
                aux = toDec(resu1);
                setBase('d');
                resp = toBinarie(String.valueOf(aux));
                break;
            case 'o':
                aux = toDec(resu1);
                setBase('d');
                resp = toBinarie(String.valueOf(aux));
                break;
        }
        return resp;
    }



    public ArrayList<Object> toHexa(String resu1){
        ArrayList<Object> resp = new ArrayList<>();
        if(getBase() == 'h'){
            System.out.println("Você quer converter hexadecimal pra hexadecimal? Tente novamente.");
            resp.add(resu1);
        }else{
            int res = 0, v1;
            String n;
            int resu = Integer.parseInt(resu1);
            switch(getBase()){
            case 'd':
                System.out.println(resu);
                while (resu > 0) {
                    res = resu % 16;
                    if(res>9){
                        switch(res){
                            case 10:
                                resp.add('A');
                                break;
                            case 11:
                                resp.add('B');
                                break;
                            case 12:
                                resp.add('C');
                                break;
                            case 13:
                                resp.add('D');
                                break;
                            case 14:
                                resp.add('E');
                                break;
                            case 15:
                                resp.add('F');
                        }
                    }else{
                        resp.add(res);
                    }
                    resu = resu / 16;
                }
                Collections.reverse(resp);
                break;
            case 'o':
                v1 = toDec(resu1);
                n = String.valueOf(v1);
                setBase('d');
                resp = toHexa(n);
                break;
            case 'b':
                v1 = toDec(resu1);
                n = String.valueOf(v1);
                setBase('d');
                resp = toHexa(n);
                break;
            }
        }
        return resp;
    }



    public ArrayList<Object> toOctal(String resu1){
        ArrayList<Object> resp = new ArrayList<>();
        int aux=0;
        switch (getBase()){
            case 'd':
                int resu = Integer.parseInt(resu1);
                while (resu >= 8) {
                    resp.add(resu % 8);
                    resu = resu / 8;
                }
                resp.add(resu);
                Collections.reverse(resp);
                break;
            case 'h':
                aux = toDec(resu1);
                setBase('d');
                resp = toOctal(String.valueOf(aux));
                break;
            case 'o':
                aux = toDec(resu1);
                setBase('d');
                resp = toOctal(String.valueOf(aux));
                break;
        }
        return resp;



    }



    public int pot(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int resultado = 1;
        for (int i = 0; i < n; i++) {
            resultado *= a;
        }
        return resultado;
    }



    public int toDec(String num){
        int tam = num.length()-1;
        int resp = 0;
        switch(getBase()){
            case 'b':
                for(int i=0; i <= tam; i++){
                    resp = resp + (Character.getNumericValue(num.charAt(i))*(int) pot(2,tam-i));
                }
                break;
            case 'h':
                for(int i=0; i <= tam; i++){
                    if(Character.getNumericValue(num.charAt(i)) == 'A'){
                        resp = resp + (10*pot(16,tam-i));
                    }else if(Character.getNumericValue(num.charAt(i)) == 'B'){
                        resp = resp + (11*pot(16,tam-i));
                    }else if(Character.getNumericValue(num.charAt(i)) == 'C'){
                        resp = resp + (12*pot(16,tam-i));
                    }else if(Character.getNumericValue(num.charAt(i)) == 'D'){
                        resp = resp + (13*pot(16,tam-i));
                    }else if(Character.getNumericValue(num.charAt(i)) == 'E'){
                        resp = resp + (14*pot(16,tam-i));
                    }else if(Character.getNumericValue(num.charAt(i)) == 'F'){
                        resp = resp + (15*pot(16,tam-i));
                    }else{
                        resp = resp + (Character.getNumericValue(num.charAt(i))*pot(16,tam-i));
                    }
                }
                break;
            case 'o':
                for(int i=0; i <= tam; i++){
                    resp = resp + (Character.getNumericValue(num.charAt(i))*pot(8,tam-i));
                }
                break;    
        }
        return resp;
    }



    public ArrayList<Object> calculate_a() {
        ArrayList <Object> aux = new ArrayList<>();
        switch (getOp()) {
            case 'b':
                setArrayList(toBinarie(String.valueOf(getValueA())));
                break;
            case 'd': 
                setValueB(toDec(String.valueOf(getValueA())));
                aux.add(getValueB());
                setArrayList(aux);
                break;
            case 'h':
                setArrayList(toHexa(String.valueOf(getValueA())));
                break;
            case 'o':
                setArrayList(toOctal(String.valueOf(getValueA())));
                break;
        }
        return getArrayList();
    }



    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        imprimir('-', 51);
        System.out.println("--------------------CALCULADORA--------------------");
        imprimir('-', 51);
        char r = 'x';
        System.out.println("CALCULADORA:");
        System.out.println("Com qual base decimal você deseja trabalhar? [d|h|o|b]");
        setBase(scanner.nextLine().charAt(0));
        System.out.println("Operações: [digite 'o'] ----");
        System.out.println("Conversões: [digite 'c'] ----");
        System.out.println("Fechar código: [digite 's']");
        
        
        r = scanner.nextLine().charAt(0);

        if(menuOpe(r)){
            switch(getBase()){
                case 'd':
                    System.out.print("Insira o valor A: ");
                    setValueA(scanner.nextFloat());
                    System.out.print("Insira o operador [+|-|*|/]: ");
                    setOp(scanner.next().charAt(0));
                    System.out.print("Insira o valor B: ");
                    setValueB(scanner.nextFloat());
                    //------->System.out.println("O resultado é: " + calculate_n());
                    break;
                case 'b':
                    System.out.print("Insira o valor A: ");
                    setValueA(scanner.nextLine());
                    System.out.print("Insira o operador [+|-|*|/]: ");
                    setOp(scanner.nextLine().charAt(0));
                    System.out.print("Insira o valor B: ");
                    setValueB(scanner.nextLine());
                    break;
                case 'h':
                    System.out.print("Insira o valor A: ");
                    setValueA(scanner.nextLine());
                    System.out.print("Insira o operador [+|-|*|/]: ");
                    setOp(scanner.nextLine().charAt(0));
                    System.out.print("Insira o valor B: ");
                    setValueB(scanner.nextLine());
                    //System.out.println("O resultado é: " + calculate_n());
                    break;
                case 'o':
                    System.out.print("Insira o valor A: ");
                    setValueA(scanner.nextLine());
                    System.out.print("Insira o operador [+|-|*|/]: ");
                    setOp(scanner.nextLine().charAt(0));
                    System.out.print("Insira o valor B: ");
                    setValueB(scanner.nextLine());
                    //System.out.println("O resultado é: " + calculate_n());
                    break;
                default:
                    System.out.println("Base decimal não conhecida.");
                    break;
            }
            System.out.println("O resultado é: " + calculate_n());
        }else{
            System.out.print("Insira o valor A: ");
            //setValueA(scanner.nextLine());
            
            setValueA(scanner.nextLine());
            //String aux = scanner.nextLine();

            System.out.print("Insira o operador [d|b|h|o]: ");
            setOp(scanner.nextLine().charAt(0));


            System.out.println("O resultado é: " + calculate_a());


        }
        scanner.close();
        //System.out.println("Digite a base: (decimal [digite 'd'], binário ['b'], hexadecimal ['h'], octal ['o'])");


    }



    public void imprimir(char a, int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.print(a);
        }
        System.out.println();
    }



    public boolean menuOpe(char a) {
        if (a == 'o') {
            imprimir('-', 51);
            System.out.println("Bem-vindo a calculadora de OPERAÇÕES!");
            imprimir('-', 51);
            System.out.println("Essas são as operações possíveis: ");
            System.out.println("-'+' <=> soma;");
            System.out.println("-'-' <=> subtração;");
            System.out.println("-'*' <=> multiplicação;");
            System.out.println("-'/' <=> divisão;");
            //menuOpe(r);
            //scanner.close();
            return true;

        } else {
            imprimir('-', 51);
            System.out.println("Bem-vindo a calculadora de CONVERSÕES!");
            imprimir('-', 51);
            System.out.println("Essas são as conversões popssíveis: ");
            System.out.println("pBinário => [digite 'b']");
            System.out.println("pDecimal => [digite 'd']");
            System.out.println("<=> pHexa => [digite 'h']");
            System.out.println("<=> pOctal => [digite 'o'];");
            return false;
            
        }
    }


    
}
