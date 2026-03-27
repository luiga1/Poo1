import java.util.Scanner;

public class Calculadora {

    public static double inputCalc(char operacao, double primeiro, double segundo){
        double resposta = 0;
        switch (operacao) {
            case '+' :
                resposta = primeiro + segundo;
                break;

            case '-' :
                resposta = primeiro - segundo;
                break;

            case '*' :
                resposta = primeiro * segundo;
                break;

            case '/' :
                try {
                    resposta = primeiro / segundo;
                } catch (ArithmeticException e) {
                    System.out.println("Erro: Operação invalida");
                }
                break;

            default:
                System.out.println("Erro: não é uma operação");
        }
        return resposta;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char verifica = 'n';
        do { 
            System.out.println("Digite o primeiro numero: ");
            double primeiro = entrada.nextDouble();

            System.out.println("Digite o segundo numero: ");
            double segundo = entrada.nextDouble();

            System.out.println("Digite a operação: ");
            char operacao = entrada.next().charAt(0);

            double resposta = inputCalc(operacao, primeiro, segundo);

            System.out.println("Resposta: "+ resposta);

            System.out.println("Deseja fazer outra conta? y/N");
            verifica = entrada.next().charAt(0);
        } while (verifica == 'Y' || verifica == 'y');
        entrada.close();
    }
}
