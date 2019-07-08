import proprietario.Veiculo;
import veiculo.Veiculo;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		EscreverMenu();
		Scanner tecladoMenu = new Scanner(System.in);
		String opcaoMenu = tecladoMenu.nextLine();
		
		
		do {
			if(opcaoMenu == "1") {
				opcaoMenu = "Cadastrar Veículo";
			}else if(opcaoMenu == "0") {
				opcaoMenu = "Sair";
			}
			MenuEscolha(opcaoMenu);
		}while(opcaoMenu != null);
		
	}
	
	private static void EscreverMenu() {
		System.out.println("Bem vindo!!");
		System.out.println("Escolha uma opção para acessar o menu: ");
		System.out.println("	- 1 'Cadastrar Veículo'");
		System.out.println("	- 0 'Sair'");
		
	}
	
	private static void MenuEscolha(String opcaoMenu) {
		switch(opcaoMenu) {
		case "Cadastrar Veículo":
			Scanner teclado = new Scanner(System.in);
			System.out.println("Digite o nome do veículo que deseja cadastrar: ");
			String nomeVeiculo = teclado.nextLine();
			System.out.println("Digite a marca do veículo que deseja cadastrar: ");
			String marcaVeiculo = teclado.nextLine();
			System.out.println("Digite a motorizacao do veículo que deseja cadastrar: ");
			String motorizacao = teclado.nextLine();
			System.out.println("Digite cor do veículo que deseja cadastrar: ");
			String cor = teclado.nextLine();
			System.out.println("Digite a placa do veículo que deseja cadastrar: ");
			int placa = teclado.nextInt();
			System.out.println("Digite o renavam do veículo que deseja cadastrar: ");
			int renavam = teclado.nextInt();
			System.out.println("Digite a capacidade do veículo que deseja cadastrar: ");
			double capacidade = teclado.nextDouble();

			Veiculo Ana = new Veiculo(nomeVeiculo, marcaVeiculo, motorizacao, cor, placa, renavam, capacidade);
			System.out.println("Veículo " + Ana.nome + "Cadastrado com sucesso");
			break;
		case "":
			break;
		}
		
	}

}
