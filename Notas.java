import java.util.Scanner;

public class Notas {

    public static void enterExamMarks(Scanner entrada, int[] students){

        for(int i=0;i<students.length;i++){

            System.out.println("Digite a nota do aluno " + i);
            students[i] = entrada.nextInt();

            if(students[i]<0 || students[i]>10){
                System.out.println("Entrada invalida, insira o valor denovo");
                i--;
            }
        }

    }

    public static int[] increseMarks(int[] students){

        for(int i=0; i< students.length ;i++){

            students[i] = students[i] +3;

            if(students[i] >10){
                students[i] = 10;
            }

            System.out.println("Aluno" + i +": Nota:" + students[i]);
        }
        return students;
    }

    public static void allHavePassed(int[] students){
        for (int i=0;i<students.length;i++) {
            int j= i+1;
            if(students[i] >= 5){
                System.out.println("Aluno "+ j + ": Aprovado");
            }
            else{
                System.out.println("Aluno " + j+ ": Reprovado");
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] javaStudents = new int[4];

        enterExamMarks(entrada, javaStudents);

        javaStudents = increseMarks(javaStudents);

        allHavePassed(javaStudents);

        entrada.close();
    }
}
