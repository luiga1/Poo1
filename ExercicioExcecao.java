public class ExercicioExcecao {

    public static void main(String[] args) {
        try {

            int numero = obterNumero(args);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Erro: nenhum argumento foi informado");

        } catch (NumberFormatException e) {
            System.out.println("Erro: argumento deve se um numero inteiro");
        }
    }


    public static int obterNumero(String[] args){
        return Integer.parseInt(args[0]);
    }

    public static void exibirNumero(int numero){
        System.out.println("N´mero informado: " + numero);
    }

}