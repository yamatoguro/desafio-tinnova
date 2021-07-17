import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Execução da classe Eleicao.java
        Eleicao eleicao = new Eleicao();

        Scanner scan = new Scanner(System.in);
        System.out.print("Execução da classe Eleição\nTotal de eleitores: ");
        float num = scan.nextFloat();
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
        scan.close();
    }
}
