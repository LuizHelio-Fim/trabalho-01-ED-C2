package view;

import java.util.Scanner;
import model.Aluno;
import service.AlunoService;

public class Menu {

    private Scanner scanner;
    private AlunoService service;

    public Menu() {
        scanner = new Scanner(System.in);
        service = new AlunoService();
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - Remover aluno");
            System.out.println("3 - Transferir aluno para outra escola");
            System.out.println("4 - Buscar aluno por nome");
            System.out.println("5 - Sair");
            System.out.print(">: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    inserirAluno();
                    break;
                case 2:
                    removerAluno();
                    break;
                case 3:
                    transferirAluno();
                    break;
                case 4:
                    buscarAluno();
                    break;
                case 5:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);
    }

    private void inserirAluno() {
        System.out.print("Matricula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Aluno aluno = new Aluno(matricula, nome, endereco, telefone);
        service.inserirAluno(aluno);

        System.out.println("Aluno inserido!");
    }

    private void removerAluno() {
        System.out.print("Matricula: ");
        int matricula = scanner.nextInt();

        if (service.removerAluno(matricula)) {
            System.out.println("Aluno removido!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void transferirAluno() {
        System.out.print("Matricula: ");
        int matricula = scanner.nextInt();

        if (service.transferirAluno(matricula)) {
            System.out.println("Aluno transferido!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void buscarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Aluno aluno = service.buscarPorNome(nome);

        if (aluno != null) {
            System.out.println(aluno.toString());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}
