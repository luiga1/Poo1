import java.util.Scanner;

public class Notas {

    public static void enterExamMarks(Scanner entrada, int[] students){

        for(int i=0;i<students.length;i++){

            System.out.println("Digite a nota do aluno" + i);
            students[i] = entrada.nextInt();

            if(students[i]<0 || students[i]<10){
                System.out.println("Entrada invalida, insira o valor denovo");
                i--;
            }
        }

    }

    public static int[] increseMarks(int[] students){
        for(int t : students){
            t = t+3;
        }
        return students;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] javaStudents = new int[4];

        entrada.close();
    }
}
