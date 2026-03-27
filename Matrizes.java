import java.util.Scanner;

public class Matrizes {
    
    public static void imprimeMatriz(int[][] Matriz){
        for(int i=0; i < Matriz.length;i++){
            for(int j=0; j < Matriz[i].length;j++){
                System.out.println("Elemento["+i+j+"]= "+ Matriz[i][j]);
            }
        }
    }

    public static int[][] Multiplica(int[][] matriza, int[][] matrizb){
        
    }

    public static int[][] pegaMatriz(Scanner entrada, int linha, int coluna){

        int[][] Matriz = new int[linha][coluna];

        for(int i=0; i < linha;i++){
            for (int j = 0; j < coluna; j++) {
                System.out.println("Digite o elemento ["+ i+ j +"]");
                Matriz[i][j] = entrada.nextInt();
            }
        }

        return Matriz;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o numero de linhas e colunas de A");
        int linhaA = entrada.nextInt();
        int colunaA = entrada.nextInt();

        System.out.println("Digite o numero de linhas e colunas de B");
        int linhaB = entrada.nextInt();
        int colunaB = entrada.nextInt();

        if(colunaA == linhaB){
            int[][] MatrizA = new int[linhaA][colunaA];
            MatrizA = pegaMatriz(entrada, linhaA, colunaB);

            int[][] MatrizB = new int[linhaB][colunaB];
            MatrizB = pegaMatriz(entrada, linhaB, colunaB);

            int[][] MatrizR = new int[colunaA][linhaB];
            MatrizR = Multiplica(MatrizA,MatrizB);



        }else{
            System.out.println("Não é possivel multiplicar a matriz");
        }

        entrada.close();
    }
}
