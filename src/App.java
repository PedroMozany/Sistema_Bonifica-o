import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        menu();
    }



    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Gerar Relatorio");
        try {
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    Sistema sistema = new Sistema();
                    System.out.println(sistema.imprimirRelatorio());
                    break;
                default:
            }
        }catch (InputMismatchException iex){
            System.out.println("Digitar '1' para cadastra ou '2' imiprimri relatorio");
            menu();
        }
    };


    public static void cadastrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do Funcionario:");
        String nome = sc.nextLine().toUpperCase();
        System.out.println("Valor do salario: ");
        double salario = sc.nextDouble();
        Sistema sistema = new Sistema(new Funcionario(nome, salario));
        sistema.salvarDados();
        System.out.println("Cadastro realizado com sucesso");
        menu();
    };

}
