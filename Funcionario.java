public class Funcionario{

    private String nome;
    private String cpf;
    private double valor_hora;
    private double carga_horaria;
    private boolean filhos;

    public Funcionario(String nome, String cpf, double valor_hora, double carga_horaria, boolean filhos) {
        this.nome = nome;
        this.cpf = cpf;
        this.valor_hora = valor_hora;
        this.carga_horaria = carga_horaria;
        this.filhos = filhos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public double getCarga_horaria() {
        if(carga_horaria > 44){
            carga_horaria = 44;
        } 
        return carga_horaria;
    }

    public void setCarga_horaria(double carga_horaria) {
        if(carga_horaria > 44){
            this.carga_horaria = 44;
        }else{
            this.carga_horaria = carga_horaria;
        } 
    }

    public boolean getFilhos() {
        return filhos;
    }

    public void setFilhos(boolean filhos) {
        this.filhos = filhos;
    }

    public String toString() {
        return "Funcionario (a) " + nome + ", carga horaria: " + carga_horaria + ", CPF = " + cpf + ", valor da hora = " + valor_hora + ", filhos = " + filhos;
    }

    public double CalculaSalario(){
        if(carga_horaria > 44){
            carga_horaria = 44;
        }
        double salario = carga_horaria * valor_hora * 4;
        return salario;
    }  
  
}