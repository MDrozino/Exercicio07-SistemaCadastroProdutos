package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n --- Menu --- ");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Opção de cadastro selecionada.");
                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    boolean codigoExistente = false;
                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigo) {
                            codigoExistente = true;
                            break;
                        }
                    }

                    if (codigoExistente) {
                        System.out.println("Erro: Já existe um produto com o código " + codigo + ".");
                    } else {
                        System.out.print("Digite o nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o preço do produto: ");
                        double preco = scanner.nextDouble();

                        Produto produto = new Produto(codigo, nome, preco);
                        produtos.add(produto);
                        System.out.println("Produto cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("Opção de busca selecionada.");

                    if(produtos != null ) {
                        System.out.println("\nInforme o código do produto: ");
                        int codigoDaBusca = scanner.nextInt();


                        for (Produto produto1 : produtos) {
                            if (produto1.getCodigo() == codigoDaBusca) {
                                System.out.println("Produto encontrado : " + produto1);
                            } else {
                                System.out.println("Produto não encontrado...");
                            }
                        }
                    }else{
                        System.out.println("Nenhum produto cadastrado");
                    }
                    break;

                case 3:
                    System.out.println("Saindo ... ");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
        scanner.close();
    }
}