import java.util.InputMismatchException;
import java.util.Scanner;

public class Imc {
    
    public static float pegaEntrada(String nome){
        Scanner entrada = new Scanner(System.in);

        while (true) { 
            
            try{
                System.out.println("Digite" + nome);
                float saida = entrada.nextFloat();
                return saida;
            }catch(InputMismatchException e){
                System.out.println("Erro: entrada invalida");
            }

            entrada.close();
        }
    }

    public static float calcImc(float altura, float peso){
        float imc =0;
        try {
            imc = peso / (altura * altura);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Calculo do imc não é possivel");
        }
        return imc;
    }

    public static void main(String[] args) {
        float peso = pegaEntrada("o peso");
        float altura = pegaEntrada("a altura");

        float imc = calcImc(altura, peso);

        System.out.println("Imc: " +imc);
    }


}
