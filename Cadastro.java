import java.util.Scanner;

public class Cadastro {
    
    public static void main (String[] args){
        
        Scanner s = new Scanner(System.in);
        Funcionario funcionarios[] = new Funcionario[5];

        funcionarios[0] = new Funcionario("Joana", "84848488222", 12.5, 44, false);
        funcionarios[1] = new Funcionario("Iuri", "85473957020", 20.0, 40, true);
        funcionarios[2] = new Funcionario("Pedro", "95781348021", 15.0, 46, false);
        funcionarios[3] = new Funcionario("Cristina", "12478597050", 11.0, 30, false);
        funcionarios[4] = new Funcionario("Gabriel", "02178591049", 13.8, 32, true);

        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Cadastrar novo funcionário");
        System.out.println("2 - Listar funcionários cadastrados");
        System.out.println("3 - Remover funcionário");
        System.out.println("4 - Editar salário do funcionário");
        System.out.println("5 - Imprimir funcionário com maior salário");
        System.out.println("6 - Imprimir percentual de funcionários que possuem filhos");
        System.out.println("7 - Sair do programa");

        int opcao = s.nextInt();

        switch (opcao){
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:
                break;
        }

    }
}
