
import java.util.Scanner;

/**
 * solicite o valor do empréstimo, o número de parcelas e o tipo de cliente
 * C para comum, P para premium.
 * Cliente comum paga 2,5% de juros ao mês e pode parcelar em até 24 vezes.
 * Cliente premium paga 1,5% ao mês e pode parcelar em até 36 vezes.
 * Caso ultrapasse o limite permitido, exiba mensagem de erro.
 * Calcule o valor total a pagar e o valor de cada parcela.
 */

//(for -> parcelas) total += total * juros 
public class Emprestimo {

    public static void Parcelas(float valor, int parcelas, float juros){
        float total=valor;
        for(int i=0;i<parcelas;i++){
            total += total * juros;
        }

        float pagar = total / parcelas;

        System.out.println("Total a ser pago: " + total);
        System.out.println("Parcelas: "+ parcelas+ " de " + pagar);

    }

    public static void calcParcelas(float valor,int parcelas,char tipo){
        if(tipo == 'c'){
            if(parcelas > 24){
                System.out.println("Erro: quantidade de parcelas");
                return;
            }
            
            Parcelas(valor, parcelas, 0.025f);
        }else{
            if(parcelas > 36){
                System.out.println("Erro: quantidade de parcelas");
                return;
            }

            Parcelas(valor, parcelas, 0.015f);
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        float valor=-1;
        do {
            System.out.println("Digite o valor do emprestimo");
             valor = entrada.nextFloat();
        } while(valor < 0);
        
        int parcelas=0;
        do {
            System.out.println("Digite o numero de parcelas");
            parcelas = entrada.nextInt();
        } while(parcelas<=0);

        char tipo;
        do {
            System.out.println("Digite o tipo de cliente");
            tipo = entrada.next().charAt(0);
        } while (tipo != 'c' && tipo != 'p');

        calcParcelas(valor, parcelas, tipo);

        entrada.close();

    }

}
