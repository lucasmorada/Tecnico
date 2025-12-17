package sistema.escolar

import java.util.ArrayList;
import java.util.Scanner
import java.time.LocalDate;

public class SistemaEscolar {

    static ArrayList<Aluno> alunos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaEscolar sistema = new SistemaEscolar()
        sistema.menuPrincipal();
    }

    public void menuPrincipal() {
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("=== MENU ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();

            if (opcao == 1) {
                cadastrarAluno();
            } else if (opcao == 2) {
                listarAlunos();
            } else if (opcao == 3) {
                buscarAluno();
            } else if (opcao == 4) {
                System.out.println("Encerrando sistema...");
            } else {
                System.out.println("Opção inválida")
            }
        }
    }

    private void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        String idade = scanner.nextInt();

        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();

        Aluno aluno = new Aluno(nome, idade, matricula);
        alunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void listarAlunos() {
        if (alunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return
        }

        for (Aluno a : alunos) {
            System.out.println(a.exibirDados());
        }
    }

    private void buscarAluno() {
        System.out.print("Digite a matrícula: ");
        int mat = scanner.nextInt();

        boolean encontrado = false;

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() = mat) {
                System.out.println(aluno);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Aluno não encontrado");
        }
    }
}

class Aluno {

    private String nome;
    private int idade;
    private int matricula;
    private LocalDate dataCadastro;

    public Aluno(String nome, int idade, int matricula) {
        this.nome = nome;
        this.idade = idade
        this.matricula = matricula;
        dataCadastro = LocalDate.now();
    }

    public String exibirDados() {
        return "Aluno: " + nome +
               ", Idade: " + idade +
               ", Matrícula: " + matricula +
               ", Cadastro: " + dataCadastro.toString();
    }

    public int getMatricula() {
        return matricula
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
