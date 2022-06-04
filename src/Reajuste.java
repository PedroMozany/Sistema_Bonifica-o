public enum Reajuste {

    BONUS10(0.1),
    BONUS20(0.2),
    DESCONTO10(0.1);

    double percentual;


    Reajuste(double percentual ){
        this.percentual = percentual;
    }

    public double getPercentual() {
        return percentual;
    }


    public double valorReajuste(Double salario){
        return this.percentual * salario;
    }

}
