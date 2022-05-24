import java.util.Scanner;

public class Cadastro {
    private Funcionario[] funcionarios;
    private int tam = 0;
    
    public Cadastro() { 
        funcionarios = new Funcionario[1000];
        funcionarios[tam ++] = new Funcionario("Joana", "84848488222", 12.5, 44, false);
        funcionarios[tam ++] = new Funcionario("Iuri", "85473957020", 20.0, 40, true);
        funcionarios[tam ++] = new Funcionario("Pedro", "95781348021", 15.0, 46, false);
        funcionarios[tam ++] = new Funcionario("Cristina", "12478597050", 11.0, 30, false);
        funcionarios[tam ++] = new Funcionario("Gabriel", "02178591049", 13.8, 32, true);   
    }
    
    public void cadastrarFuncionario() {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o nome do funcionário: ");
        String nome = s.nextLine();
        System.out.print("Digite o CPF do funcionário: ");
        String cpf = s.nextLine();
        System.out.print("Digite o valor da hora do funcionário: ");
        double valor_hora = s.nextDouble();
        System.out.print("Digite a carga horária semanal do funcionário: ");
        double carga_horaria = s.nextDouble();
        System.out.println("O funcionário tem filhos? [true / false]");
        boolean filhos = s.nextBoolean();
        funcionarios[tam++] = new Funcionario(nome, cpf, valor_hora, carga_horaria, filhos);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void listarFuncionarios() {
        for (int i = 0; i < tam; i++) {
            System.out.println(funcionarios[i]);
        }
    }

    /* public void removerFuncionario(String cpf){
        System.out.print("Informe o CPF do funcionário a ser removido: ");
        for (int i = 0; i < tam; i++) {
            if(funcionarios[i].getCpf() = cpf){

            }
        }
    }
    */

     /* public void editarSalario(String cpf){
        System.out.print("Informe o CPF do funcionário: ");
        for (int i = 0; i < tam; i++) {
            if(funcionarios[i].getCpf() = cpf){
                funcionarios[i].setValor_hora();
                funcionarios[i].CalculaSalario();
            }
        }
    }

    */

    public Funcionario maiorSalario() {
        Funcionario maior = funcionarios[0];
        for (int i = 1; i < tam; i++) {
            if (funcionarios[i].CalculaSalario(funcionarios[i].getCarga_horaria(), funcionarios[i].getValor_hora()) > maior.CalculaSalario(funcionarios[i].getCarga_horaria(), funcionarios[i].getValor_hora())) {
                maior = funcionarios[i];
            }
        }
        return maior;
    }

    public double percentualFilhos() {
        int filhos = 0;
        for (int i = 0; i < tam; i++) {
            if (funcionarios[i].getFilhos() == true){
                filhos ++;
            }
        }
        return filhos/tam;
    }
    
    public static void main (String[] args){

        Cadastro c = new Cadastro();
        Scanner s = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1 - Cadastrar novo funcionário");
        System.out.println("2 - Listar funcionários cadastrados");
        System.out.println("3 - Remover funcionário");
        System.out.println("4 - Editar salário do funcionário");
        System.out.println("5 - Imprimir funcionário com maior salário");
        System.out.println("6 - Imprimir percentual de funcionários que possuem filhos");
        System.out.println("7 - Sair do programa");
        System.out.print("Digite a opção desejada: ");

        int opcao = s.nextInt();

        switch (opcao){
            case 1:
                c.cadastrarFuncionario();
                break;

            case 2:
                c.listarFuncionarios();
                break;

            case 3:

            case 4:

            case 5:
                c.maiorSalario();
                break;
            
            case 6:
                c.percentualFilhos();
                break;

            case 7:
                System.out.println("Saindo...");
                break;
        }
        s.close();
    }
}
