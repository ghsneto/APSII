package br.unipe.cadastromoveis;

import br.unipe.cadastromoveis.model.Cadeira;
import br.unipe.cadastromoveis.model.Mesa;
import br.unipe.cadastromoveis.model.Movel;
import br.unipe.cadastromoveis.model.Sofa;
import br.unipe.cadastromoveis.repository.MovelRepositoryMemoria;
import br.unipe.cadastromoveis.service.MovelService;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MovelService service = new MovelService(MovelRepositoryMemoria.getInstancia());
        int opcao;

        do {
            System.out.println();
            System.out.println("===== CADASTRO DE MOVEIS =====");
            System.out.println("1 - Cadastrar movel");
            System.out.println("2 - Listar moveis");
            System.out.println("3 - Buscar movel por ID");
            System.out.println("4 - Remover movel");
            System.out.println("0 - Sair");
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1 -> cadastrar(service);
                case 2 -> listar(service);
                case 3 -> buscar(service);
                case 4 -> remover(service);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrar(MovelService service) {
        System.out.println("Tipo: 1 - Cadeira | 2 - Mesa | 3 - Sofa");
        int tipo = lerInteiro("Escolha o tipo: ");
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo invalido!");
            return;
        }

        String nome = lerTexto("Nome: ");
        String material = lerTexto("Material: ");
        double preco = lerDouble("Preco: ");

        Movel movel;
        if (tipo == 1) {
            movel = new Cadeira(nome, material, preco, lerSimNao("Tem rodinhas? (s/n): "));
        } else if (tipo == 2) {
            movel = new Mesa(nome, material, preco, lerInteiro("Quantidade de lugares: "));
        } else {
            movel = new Sofa(nome, material, preco, lerSimNao("E retratil? (s/n): "));
        }

        try {
            service.cadastrar(movel);
            System.out.println("Movel cadastrado com sucesso! ID: " + movel.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listar(MovelService service) {
        List<Movel> moveis = service.listar();
        if (moveis.isEmpty()) {
            System.out.println("Nenhum movel cadastrado.");
            return;
        }
        for (Movel movel : moveis) {
            System.out.println(movel);
        }
    }

    private static void buscar(MovelService service) {
        Movel movel = service.buscar(lerInteiro("ID do movel: "));
        System.out.println(movel != null ? movel : "Movel nao encontrado.");
    }

    private static void remover(MovelService service) {
        boolean removido = service.remover(lerInteiro("ID do movel: "));
        System.out.println(removido ? "Movel removido com sucesso!" : "Movel nao encontrado.");
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(mensagem).trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                return Double.parseDouble(lerTexto(mensagem).trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor valido.");
            }
        }
    }

    private static boolean lerSimNao(String mensagem) {
        return lerTexto(mensagem).trim().equalsIgnoreCase("s");
    }
}
