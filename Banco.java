import java.util.Scanner;

public class Banco {

    public static double conta(char entrada){
        if(entrada == 'A' || entrada == 'a'){
            return 1.5;
        }
        else if(entrada == 'B' || entrada == 'b'){
            return 2.0;
        }
        else if(entrada == 'C' || entrada == 'c'){
            return 2.5;
        }
        else if(entrada == 'X' || entrada == 'x'){
            return 5.0;
        }
        else{
            System.out.println("Entrada Invalida");
            return 0;
        }
    }

    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o seu tipo de conta");
        char banco = entrada.next().charAt(0);
        System.out.println("Digite o dinheiro a ser invertido");
        double investimento = entrada.nextDouble();

        Double anuidade = conta(banco);

        if(anuidade != 0){
            investimento = investimento + (investimento * anuidade /100);
        } else{
            System.out.println("Entrada de banco invalida");
            return;
        }

        System.out.println("O valor final depois de um ano é" + investimento);
        
        entrada.close();
    }
}