import java.io.*;
import java.util.Scanner;

public class editarvore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arvore arvore = new arvore();


        try (BufferedReader br = new BufferedReader(new FileReader("alunos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";", 2);
                int rgm = Integer.parseInt(partes[0]);
                String nome = partes[1];
                arvore.inserir(rgm, nome);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }

        int opcao;
        do {
            System.out.println("1 – INSERIR – fornecer RGM e Nome");
            System.out.println("2 – REMOVER UM NÓ – fornecer o RGM a remover");
            System.out.println("3 – PESQUISAR – fornecer o RGM a pesquisar");
            System.out.println("4 – ESVAZIAR A ÁRVORE");
            System.out.println("5 – EXIBIR A ÁRVORE – PRÉ, IN ou PÓS");
            System.out.println("0 – SAIR");
            System.out.print("DIGITE SUA OPÇÃO: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("RGM: ");
                    int rgm = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    arvore.inserir(rgm, nome);
                    break;
                case 2:
                    System.out.print("RGM a remover: ");
                    arvore.remover(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Digite o RGM: ");
                    alunos aluno = arvore.pesquisar(scanner.nextInt());
                    System.out.println(aluno != null ? aluno.rgm + " - " + aluno.nome : "Aluno não encontrado.");
                    break;
                case 4:
                    arvore.esvaziar();
                    break;
                case 5:
                    System.out.println("Exibir (1-PRÉ | 2-IN | 3-PÓS): ");
                    int tipo = scanner.nextInt();
                    switch (tipo) {
                        case 1: arvore.exibirpreordem(); break;
                        case 2: arvore.exibirinordem(); break;
                        case 3: arvore.exibirposordem(); break;
                        default: System.out.println("Tipo inválido.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
