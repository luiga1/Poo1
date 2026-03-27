/**
 * solicite vários anos (defina a quantidade) e armazene em um vetor.
 * Utilize um laço de repetição para verificar quais anos são bissextos.
 * Exiba o resultadopara cada ano.
 */

import java.util.Scanner;

public class Bissexto {
    
    public static int[] pegaAno(int qnt, Scanner entrada){
        int[] saida = new int[qnt];
        for (int i = 0; i < qnt; i++) {
            System.out.println("Digite o " + (i +1) + " ano: ");
            saida[i] = entrada.nextInt();
        }
        return saida;
    }

    public static boolean[] verifyBissexto(int[] anos){
        boolean[] saida = new boolean[anos.length];
        for (int i=0;i<anos.length;i++) {
            if((anos[i] % 4) == 0){ 
                saida[i] = true;
            }else{
                saida[i] = false;
            }
            
        }
        return saida;
    }

    public static void printBissexto(boolean[] bissexto, int[] anos){
        for (int idx = 0; idx < bissexto.length; idx++) {
            if(bissexto[idx]){
                System.out.println("O ano " + anos[idx] + " é bissexto");
            }else{
                System.out.println("O ano " + anos[idx] + " não é bissexto");
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int qnt=0;
        

        do { 
            System.out.println("Digite quantos anos serão digitados");
            qnt = entrada.nextInt();
        } while (qnt<1);

        int[] anos = new int[qnt];
        boolean[] bissexto = new boolean[qnt];

        anos = pegaAno(qnt, entrada);

        bissexto = verifyBissexto(anos);

        printBissexto(bissexto, anos);
    }

}
