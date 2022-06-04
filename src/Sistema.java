import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Sistema {

    private LinkedList<Funcionario> funcionarios;

    public Sistema(Funcionario funcionario) {
        this.funcionarios = new LinkedList<>();
        addFuncionario(funcionario);
    }

    public Sistema() {
        this.funcionarios = lerBaseDados("baseDados.txt");
    }




    public Double calcSalLiq(double salario) {
        Reajuste valor = percentual(salario);
        switch (valor) {
            case BONUS10:
                return salario + Reajuste.BONUS10.valorReajuste(salario);
            case BONUS20:
                return salario + Reajuste.BONUS20.valorReajuste(salario);
            case DESCONTO10:
                return salario - Reajuste.DESCONTO10.valorReajuste(salario);
            default:
        }
        return 0.0;
    }


    public Double valorReajuste(double salario) {
        Reajuste valor = percentual(salario);
        switch (valor) {
            case BONUS10:
                return Reajuste.BONUS10.valorReajuste(salario);
            case BONUS20:
                return Reajuste.BONUS20.valorReajuste(salario);
            case DESCONTO10:
                return Reajuste.DESCONTO10.valorReajuste(salario);
            default:
        }
        return 0.0;
    }


    public Reajuste percentual(double salario) {
        if (salario <= 1000) {
            return Reajuste.BONUS20;
        } else if (salario > 1000 && salario <= 2000) {
            return Reajuste.BONUS10;
        } else {
            return Reajuste.DESCONTO10;
        }
    }


    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }


    public String imprimirRelatorio() {
        StringBuilder sb = new StringBuilder("RELATORIO" + "\n");
        for (Funcionario funcionario : this.funcionarios) {
            sb.append("Funcionario: " + funcionario.getNome() + "\n");
            sb.append("Salario: " + funcionario.getSalario() + "\n");
            if(percentual(funcionario.getSalario()) == Reajuste.DESCONTO10){
                sb.append("Desconto: " + valorReajuste(funcionario.getSalario()) + "\n");
            }else{
                sb.append("Bonus: " + valorReajuste(funcionario.getSalario()) + "\n");
            }
            sb.append("Salario Linquido: " + calcSalLiq(funcionario.getSalario()) + "\n");
            sb.append("========================================" + "\n");
        }
        return sb.toString();
    }


    public LinkedList<Funcionario> lerBaseDados(String arquivo) {
        LinkedList<Funcionario> conjuntoUsuarios = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            while (linha != null) {
                Scanner sc = new Scanner(linha);
                sc.useDelimiter(",");
                conjuntoUsuarios.add(new Funcionario(sc.next(), sc.nextDouble()));
                linha = br.readLine();
                sc.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao encontra o arquivo");
        }
        return conjuntoUsuarios;
    };


    public void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("baseDados.txt", true))) {
            for (Funcionario funcionario : funcionarios) {
                bw.write(funcionario.getNome());
                bw.write(",");
                bw.write(funcionario.getSalario().toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao encontra o arquivo");
        }
    };

    public String toString() {
        return funcionarios.toString();
    }

}
