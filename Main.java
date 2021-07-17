import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float num = 0;
        Scanner scan = new Scanner(System.in);
        
        // Execução da classe Eleicao.java
        Eleicao eleicao = new Eleicao();
        System.out.print("Execução da classe Eleição\nTotal de eleitores: ");
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

        //Execução da classe BubbleSort.java
        System.out.print("\n\nExecução da classe BubbleSort\nNúmero de elementos da lista a ser ordenada: ");
        num = scan.nextFloat();
        System.out.println("Insira os elementos da lista");
        int[] lista = new int[(int) num];
        for (int i = 0; i < num; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            lista[i] = scan.nextInt();
        }
        BubbleSort.ordenar(lista, lista.length);
        StringBuilder listaOrdenada = new StringBuilder("{ ");
        for(int i = 0; i < num; i++){
            listaOrdenada.append((i != num - 1) ? lista[i] + ", " : lista[i] + " }");
        }
        System.out.println("Lista ordenada:\t" + listaOrdenada.toString());
        
        scan.close();
    }
}
