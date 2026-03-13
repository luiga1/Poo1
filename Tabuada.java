import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        
        char continuar;
        do {     
            int multiply=0;
            while(multiply<2){
                System.out.println("Digite o numero que quer a tabuada e seja maior que 2");
                multiply= entrada.nextInt();
            }
            
            for (int i = 1; i < 13; i++) {
                System.out.println(i + "x" + multiply + "=" + i*multiply);
            }

            System.out.println("Deseja continuar?");
            continuar = entrada.next().charAt(0);
        } while (continuar == 'Y' || continuar == 'y');
        

        entrada.close();
    }
}

