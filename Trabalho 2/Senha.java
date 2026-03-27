import java.util.Scanner;

public class Senha {

    public static boolean verifiyPassword(String user, String password){
        if("admin".equals(user)){
            if("1234".equals(password)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int i=0;
        boolean acesso=false;
        do { 
            
        System.out.println("Digite o Usuario: ");
        String user = entrada.nextLine();

        System.out.println("Digite a senha: ");
        String password = entrada.nextLine();

        acesso = verifiyPassword(user, password);

        if(acesso){
            System.out.println("Acesso Conceido");
        }else{
            System.out.println("Acesso Negado");
            i++;
        }
        
        } while (i<3 && acesso == false);

        entrada.close();

    }
}
