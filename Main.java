import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float num = 0;
        int opt = 10000;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("\nExecução dos exercícios 1 a 4, escolha qual classe executar\n1 - Eleicao\n2 - BubbleSort\n3 - Fatorial\n4 - Multiplos\n0 - Encerrar\nOpção: ");
            opt = scan.nextInt();
            switch (opt) {
                case 1:
                    // Execução da classe Eleicao.java
                    Eleicao eleicao = new Eleicao();
                    System.out.print("\nExecução da classe Eleição\nTotal de eleitores: ");
                    num = scan.nextFloat();
                    eleicao.setnEleitores(num);
                    System.out.print("Total de votos válidos: ");
                    num = scan.nextFloat();
                    eleicao.setVotosValidos(num);
                    System.out.print("Total de votos em branco: ");
                    num = scan.nextFloat();
                    eleicao.setVotosBrancos(num);
                    System.out.print("Total de votos nulos: ");
                    num = scan.nextFloat();
                    eleicao.setVotosNulos(num);
                    System.out.println("\nPercentuais de votos:\nVotos válidos:\t" + eleicao.percentualValido());
                    System.out.println("Votos válidos:\t" + eleicao.percentualBranco());
                    System.out.println("Votos válidos:\t" + eleicao.percentualNulos());
                    break;
                case 2:
                    // Execução da classe BubbleSort.java
                    System.out.print("\nExecução da classe BubbleSort\nNúmero de elementos da lista a ser ordenada: ");
                    num = scan.nextFloat();
                    System.out.println("Insira os elementos da lista");
                    int[] lista = new int[(int) num];
                    for (int i = 0; i < num; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        lista[i] = scan.nextInt();
                    }
                    BubbleSort.ordenar(lista, lista.length);
                    StringBuilder listaOrdenada = new StringBuilder("{ ");
                    for (int i = 0; i < num; i++) {
                        listaOrdenada.append((i != num - 1) ? lista[i] + ", " : lista[i] + " }");
                    }
                    System.out.println("Lista ordenada:\t" + listaOrdenada.toString());
                    break;
                case 3:
                    System.out.print("\nExecução da classe Fatorial\nFatorial do número: ");
                    num = scan.nextFloat();
                    System.out.println("Fatorial do número " + ((int) num) + ": " + Fatorial.fatorial((int) num));
                    break;
                case 4:
                    System.out.print("\nExecução da classe Multiplos\nNúmero base para soma dos múltiplos de 3 e 5: ");
                    num = scan.nextFloat();
                    System.out.println("Soma dos múltiplos de 3 e 5 menores que " + (int) num + ": " + Multiplos.somarMultiplos((int) num));
                    break;

                default:
                    System.out.println((opt == 0) ? "Programa encerrado." : "Opção inválida");
                    break;
            }
        } while (opt > 0);

        scan.close();
    }
}
