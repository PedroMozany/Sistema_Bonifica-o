public class Funcionario {
    private String nome;
    private Double salario;


    Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalario() {
        return salario;
    }


    @Override
    public String toString() {
        return "Funcionario: " + nome + "\n"+
                "salario: " + salario;
    }
}
