import java.util.Scanner;

public class Cadastro {
    private Funcionario[] funcionarios;
    private int tam = 0;
    
    public Cadastro() { 
        funcionarios = new Funcionario[1000];
        funcionarios[tam ++] = new Funcionario("Joana", "84848488222", 12.5, 44, false);
        funcionarios[tam ++] = new Funcionario("Iuri", "85473957020", 20.0, 40, true);
        funcionarios[tam ++] = new Funcionario("Pedro", "95781348021", 15.0, 20, false);
        funcionarios[tam ++] = new Funcionario("Cristina", "12478597050", 11.0, 30, false);
        funcionarios[tam ++] = new Funcionario("Gabriel", "02178591049", 13.8, 32, true);   
    }
    
    public boolean cadastrarFuncionario() {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o nome do (a) funcionário (a): ");
        String nome = s.nextLine();
        System.out.print("Digite o CPF do (a) funcionário (a): ");
        String cpf = s.nextLine();
        System.out.print("Digite o valor da hora do (a) funcionário (a): ");
        double valor_hora = s.nextDouble();
        System.out.print("Digite a carga horária semanal do (a) funcionário (a): ");
        double carga_horaria = s.nextDouble();
        if(carga_horaria > 44){
            carga_horaria = 44;
        }
        System.out.print("O (a) funcionário (a) tem filhos? [true / false] ");
        boolean filhos = s.nextBoolean();

        funcionarios[tam++] = new Funcionario(nome, cpf, valor_hora, carga_horaria, filhos);

        System.out.println("Funcionário (a) cadastrado (a) com sucesso!");
        return true;
        
    }

    public void listarFuncionarios() {
        for (int i = 0; i < tam; i++) {
            System.out.println(funcionarios[i]);
        }
    }

     public void removerFuncionario(String cpf){
        int pos = 0;
        boolean achou = false;
        for (int i = 0; i < tam; i++) {
            if(funcionarios[i].getCpf().equals(cpf)){
                funcionarios[i] = null;
                achou = true;
                pos = i;
                tam --;
                break;
            }
        }
        if (achou == true){
            for(int j = pos; j < tam; j ++){
                funcionarios[j] = funcionarios[j + 1];
            }
            System.out.println("Funcionário (a) removido (a)!");
        }else{
            System.out.println("Funcionário (a) não encontrado (a)!");
        }
    }
    
    public void editarSalario(String cpf, double valor_hora){
        boolean encontrou = false;
        for (int i = 0; i < tam; i++) {
            if(funcionarios[i].getCpf().equals(cpf)){
                funcionarios[i].setValor_hora(valor_hora);
                encontrou = true;
                break;
            }
        }
        if (encontrou == true){
            System.out.println("Salário do (a) funcionário (a) editado!");
        }else{
            System.out.println("Funcionário (a) não encontrado (a)!");
        } 
    }

     public Funcionario maiorSalario() {
        Funcionario maior = funcionarios[0];
        for (int i = 1; i < tam; i++) {
            if (funcionarios[i].CalculaSalario() > maior.CalculaSalario()) {
                maior = funcionarios[i];
            }
        } 
        return maior;
    }

    public void percentualFilhos() {
        int filhos = 0;
        for (int i = 0; i < tam; i++) {
            if (funcionarios[i].getFilhos() == true){
                filhos ++;
            }
        }
        System.out.println((double)filhos/tam + "%");
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

        String opcao = s.nextLine();
        boolean sair = false;

        while (sair == false){
            switch (opcao){
                case "1":  
                    c.cadastrarFuncionario();
                    break;
    
                case "2":  
                    c.listarFuncionarios();
                    System.out.println();
                    break;
    
                case "3": 
                    System.out.print("Digite o CPF do (a) funcionário (a) a ser removido (a): ");
                    String cpf_remover = s.nextLine();
                    c.removerFuncionario(cpf_remover);
                    break;
    
                case "4":
                    System.out.print("Digite o CPF do (a) funcionário (a): ");
                    String cpf_editar = s.nextLine();
                    System.out.print("Digite o novo valor da hora do (a) funcionário (a): ");
                    double valor_hora = s.nextDouble();
                    c.editarSalario(cpf_editar, valor_hora);
                    break;
    
                case "5":
                    System.out.println(c.maiorSalario());
                    break;
                
                case "6": 
                    c.percentualFilhos();
                    break;
    
                case "7": 
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                
                default: 
                    System.out.println("Opção inválida!");
                    break;
            }
    
            if (sair == false){
                System.out.println();
                System.out.println("Menu");
                System.out.println("1 - Cadastrar novo (a) funcionário (a)");
                System.out.println("2 - Listar funcionários cadastrados");
                System.out.println("3 - Remover funcionário (a)");
                System.out.println("4 - Editar salário do (a) funcionário (a)");
                System.out.println("5 - Imprimir funcionário (a) com maior salário");
                System.out.println("6 - Imprimir percentual de funcionários que possuem filhos");
                System.out.println("7 - Sair do programa");
                System.out.print("Digite a opção desejada: ");
        
                opcao = s.nextLine();
            }
        }
        s.close();
    }
}