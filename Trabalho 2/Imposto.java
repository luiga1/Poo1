import java.util.Scanner;

public class Imposto {

    public static double[] coletaSalario(Scanner entrada, int pessoas){
        double[] salarios = new double[pessoas];
        for(int i=0; i< pessoas;i++){
            System.out.println("Digite o salario da pessoa "+ (i+1) + ": ");
            salarios[i] = entrada.nextDouble();
        }
        return salarios;
    }
    
    public static double[] verificaImposto(double[] lista){
        for(int i=0; i< lista.length; i++){
            if(lista[i]>5000){
                //aplica 22%
                lista[i] -= (lista[i] * 22/100);
            }else if (lista[i] >3500) {
                // aplica 15%
                lista[i] -= (lista[i] * 15/100);
            }else if (lista[i] > 2000) {
                //aplica 8%
                lista[i] -= (lista[i] * 8/100);
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char verifica;
        do { 
            System.out.println("Digite o numero de pessoas: ");
            int pessoas = entrada.nextInt();

            double[] lista = new double[pessoas];
            lista = coletaSalario(entrada, pessoas);

            lista = verificaImposto(lista);

            for (int idx = 0; idx < lista.length; idx++) {
                System.out.println("Salario liquido " + (idx +1) + ": " + lista[idx]);
            }

            System.out.println("Deseja fazer outro imposto de renda?: y/N");
            verifica = entrada.next().charAt(0);
        } while (verifica == 'Y' || verifica == 'y');

        entrada.close();

    }

}
