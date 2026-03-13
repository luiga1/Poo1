import java.util.Scanner;

public class Cambio {
    public static double obterValor(Scanner entrada){
        
        System.out.println("Digite a quantidade que sera convertida");
        double valor = entrada.nextDouble();

        return valor;
    }

    public static double obterTaxaCambio(Scanner entrada){

        System.out.println("Digite a taxa de cambio das moedas");
        double taxa = entrada.nextDouble();

        return taxa;
    }

    public static double converter(double moeda, double taxa){
        double valor = moeda*taxa;
        return valor;
    }
    public static void mostrarResultado(double moeda, double taxa ,double resultado){
        System.out.println("A converão de " + moeda + "a uma taxa de " + taxa + " é de "+ resultado);
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char escolha;
        do { 
            System.out.println("Cambio Monetario");

            double valor = obterValor(entrada);
            double taxa = obterTaxaCambio(entrada);

            double resultado = converter(valor, taxa);

            mostrarResultado(valor, taxa, resultado);

            System.out.println("Deseja converter outro valores?");
            escolha = entrada.next().charAt(0);

        } while (escolha == 'y' || escolha == 's' || escolha == 'Y' || escolha == 'S');
        entrada.close();
    }
}
