package program;

import java.util.Scanner;
import controllers.BibliotecaController;
import model.Livro;
import model.Usuario;
import model.Emprestimo;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BibliotecaController controller = new BibliotecaController();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== SISTEMA BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuario");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Listar Emprestimos");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Ano de lançamento: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, ano);
                    controller.cadastrarLivro(livro);

                    System.out.println("Livro cadastrado com sucesso!");

                    break;

                case 2:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    Usuario usuario = new Usuario(id, nome, email, telefone, cpf);
                    controller.cadastrarUsuario(usuario);

                    System.out.println("Usuario cadastrado!");

                    break;

                case 3:

                    System.out.println("Digite o índice do livro:");
                    int indiceLivro = scanner.nextInt();

                    System.out.println("Digite o índice do usuario:");
                    int indiceUsuario = scanner.nextInt();

                    scanner.nextLine();

                    Livro livroEmprestimo = controller.getLivros().get(indiceLivro);
                    Usuario usuarioEmprestimo = controller.getUsuarios().get(indiceUsuario);

                    boolean emprestado = controller.emprestarLivro(livroEmprestimo, usuarioEmprestimo);

                    if (emprestado) {
                        System.out.println("Livro emprestado com sucesso!");
                    } else {
                        System.out.println("Livro indisponivel.");
                    }

                    break;

                case 4:

                    System.out.println("Digite o índice do emprestimo:");
                    int indiceEmprestimo = scanner.nextInt();

                    scanner.nextLine();

                    Emprestimo emprestimo = controller.getEmprestimos().get(indiceEmprestimo);

                    boolean devolvido = controller.devolverLivro(emprestimo);

                    if (devolvido) {
                        System.out.println("Livro devolvido!");
                    } else {
                        System.out.println("Esse emprestimo ja foi devolvido.");
                    }

                    break;

                case 5:

                    for (int i = 0; i < controller.getEmprestimos().size(); i++) {

                        System.out.println("\nEmprestimo " + i);

                        System.out.println(
                                controller.getEmprestimos()
                                        .get(i)
                                        .mostrarInformacoes()
                        );
                    }

                    break;

                case 0:

                    System.out.println("Encerrando sistema...");
                    break;

                default:

                    System.out.println("Opção invalida.");

            }

        }

    }

}