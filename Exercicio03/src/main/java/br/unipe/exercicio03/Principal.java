package main.java.br.unipe.exercicio03;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        CD cd = new CD();
        Livro livro = new Livro();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do CD:");
        String nomeCD = scanner.nextLine();
        cd.setNome(nomeCD);
        System.out.println("Digite o preço do CD:");
        double precoCD = scanner.nextDouble();
        cd.setPreco(precoCD);
        System.out.println("Digite o número de faixas do CD:");
        int numFaixas = scanner.nextInt();
        cd.setNumFaixas(numFaixas);
        System.out.println(cd.exibeInformacoes());  


        scanner.close();
    }
}
