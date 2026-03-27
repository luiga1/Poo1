import java.util.Scanner;

/**
 * desenvolva um programa em Java que calcule a conta de energia elétrica para vários consumidores.
 * O programa deve solicitar a quantidade de consumidores e armazenar, em vetores, o consumo de energia em kWh
 * e o tipo de instalação (R para residencial, C para comercial e I para industrial).
 * para instalações residenciais, até 100 kWh cobrar R$ 0,50 por kWh e acima disso cobrar R$ 0,75 por kWh;
 * para instalações comerciais, até 200 kWh cobrar R$ 0,65 por kWh e acima disso cobrar R$0,80 por kWh;
 * para instalações industriais, até 500 kWh cobrar R$ 0,55 por kWh e acima disso cobrar R$ 0,70 por kWh.
 * Além disso, se o consumo for superior a 300 kWh, aplicar um desconto de 5% sobre ovalor calculado.
 * Caso o consumo ultrapasse 500 kWh, adicionar uma taxa fixa de R$ 50,00. 
 * Armazene o valor final de cada consumidor em um vetor.
 */

public class Energia {
    
    /*para instalações industriais, até 500 kWh cobrar R$ 0,55 por kWh e acima disso cobrar R$ 0,70 por kWh*/
    public static float calcConsumo(int consumo, char instalacao){
        float out=0;
        int aux=0;
        int limite=0;
        float taxa1=0;
        float taxa2=0;

        switch (instalacao) {
                case 'r' :
                    limite = 100;
                    taxa1 = 0.5f;
                    taxa2 = 0.75f;
                    break;
                case 'c' :
                    limite = 200;
                    taxa1 = 0.65f;
                    taxa2 = 0.80f;
                    break;
                case 'i':
                    limite = 500;
                    taxa1 = 0.55f;
                    taxa2 = 0.7f;
                    break;
                default:
            }

        if((consumo - limite) > 0){
            aux = consumo - limite;
            out += aux * taxa2;
            out += limite * taxa1;
        }else{
            out += consumo * taxa1;
        }

        //geral
        if(consumo > 300){
            out -= out * 0.05f;
        }
        if(consumo > 500){
            out += 50;
        }

        return out;
    }

    /**
     * Ao final do programa, exiba para cada consumidor o tipo de instalação, o consumo e o valor a pagar.
     *  Em seguida, calcule e exiba: o maior valor pago, o menor valor pago, a média das contas
     * e a quantidade de consumidores cujo valor da conta foi superior à média.
     */
    public static void exiba(int[] consumo, char[] instalacao,float[] valor){
        float maior=0;
        float menor = valor[0];
        float media = valor[0];
        int acima=0;

        for (int idx = 0; idx < consumo.length; idx++) {
            System.out.println("Instalação: "+instalacao[idx]+" Consumo: "+consumo[idx]+" Valor: "+ valor[idx]);
            if(valor[idx]> maior){
                maior = valor[idx];
            }
            if(valor[idx] < menor){
                menor = valor[idx];
            }
            if(idx != 0){
                media = (media + valor[idx]) /2;
            }
        }

        for (float v : valor) {
            if(v>media) acima++;
        }

        System.out.println("Maior valor: "+ maior + " Menor valor: "+menor+" Media: "+media+" Acima da Media: "+acima);

    }

    public static void Distribuicao(int[] consumo, char[] instalacao){
        float valor[] = new float[consumo.length];

        for(int i=0;i<consumo.length;i++){
            switch (instalacao[i]) {
                case 'r' :
                    valor[i] = calcConsumo(consumo[i],instalacao[i]);
                    break;
                case 'c' :
                    valor[i] = calcConsumo(consumo[i],instalacao[i]);
                    break;
                case 'i':
                    valor[i] = calcConsumo(consumo[i],instalacao[i]);
                    break;
            }
        }

        exiba(consumo,instalacao,valor);

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a quantidade de consumidores ");
        int qnt = entrada.nextInt();

        char instalacao[] = new char[qnt];
        int consumo[] = new int[qnt];
        
        for(int i=0;i<qnt;i++){

            do { 
                System.out.println("Digite o tipo de intalação em " +(i+1));
                instalacao[i] = entrada.next().charAt(0);
            } while(instalacao[i] != 'r' && instalacao[i] != 'c' && instalacao[i] != 'i');
            
            do { 
                System.out.println("Digite o consumo em " + (i+1));
                consumo[i] = entrada.nextInt();
            } while (consumo[i]<=0);

        }

        Distribuicao(consumo, instalacao);

        entrada.close();
    }

}
