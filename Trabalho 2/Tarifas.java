
import java.time.DayOfWeek;
import java.util.Scanner;

/**
 * Sistema de Tarifas de Estacionamento:
 * solicite o número de horas estacionadas e o tipo de veículo 
 * C para carro, M para moto. 
 * Carro paga 8 reais por hora e moto paga 5 reais por hora.
 * Se ultrapassar 5 horas, aplicar desconto de 10% no total.
 * Se for final de semana, aplicar acréscimo de 5%. 
 * Exiba o valor final a pagar.
 */

public class Tarifas {

    public static boolean verifyHora(int hora){
        int mil = hora/100;
        int uni = hora%100;
        if(mil < 0 || mil >=24){
            return false;
        }
        if(uni < 0 || uni > 59){
            return false;
        }
        return true;
    }

    public static int verifyVeiculo(char veiculo) {
        switch (veiculo) {
            case 'M' -> {
                return 5;
            }
            case 'm' -> {
                return 5;
            }
            case 'C' -> {
                return 8;
            }
            case 'c' -> {
                return 8;
            }
            
        }
        return 0;
    }

    public static boolean verifySemana(String semana) {
        try {
            DayOfWeek.valueOf(semana.toUpperCase());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static float calcHoras(int horac, int horaf){
        //garantir em tranformar em float devidamente
        float i = (horac/100) + (horac %100) /60f;
        
        float j = (horaf/100) + (horaf %100) /60f;

        float saida = j-i;
        return saida;
    }

    /* Foi considerado que primeiro vai ser aplicado o desconto de 10% e depois a taxa de final de semana
    ex: 6h carro sabado -> 6*8 = 48 - 4,80 = 43,2 + 2,16 = 45,36
    ex: 6h carro segunda ->  6*8 = 48 - 4,80 = 43,20
    ex -> 3h carro segunda -> 3*8 = 24
     */
    public static float calcTarifa(float horas, int veiculo, String semana){
        float tarifa = horas * veiculo;
        if (horas > 5){
            tarifa = tarifa * 0.9f; // tarifa de 10%
        }
        if(semana.matches("(?i)saturday|sunday")){ // vai averiguar como caso insensitive
            tarifa = tarifa * 1.05f; //tarifa de 5%
        }
        return tarifa;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean verifica = true;
        float tarifa=0;

        System.out.println("digite o dia da semana(ingles): ");
        String semana = entrada.nextLine();

        if(!verifySemana(semana)){
            System.out.println("ERRO: Dia da semana invalido");
            verifica = false;
        }

        System.out.println("Digite a hora de entrada(formato 2400): ");

        int horac = entrada.nextInt();

        if(!verifyHora(horac)){
            System.out.println("ERRO: Hora invalida");
            verifica = false;
        }
        
        System.out.println("Digite a hora de saida (formato 2400): ");

        int horaf = entrada.nextInt();

        if(!verifyHora(horaf)){
            System.out.println("ERRO: Hora invalida");
            verifica = false;
        }

        System.out.println("Digite o tipo de veiculo: ");

        char veiculo = entrada.next().charAt(0);

        if(verifyVeiculo(veiculo) == 0){
            System.out.println("ERRO: veiculo invalido");
            verifica = false;
        }
        
        if(verifica){
            float hora = calcHoras(horac, horaf);
            tarifa = calcTarifa(hora, verifyVeiculo(veiculo), semana);
            System.out.println("tarifa: "+ tarifa);
        }

        entrada.close();
    }
}
