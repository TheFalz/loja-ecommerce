package br.edu.unifacisa.lojaecommerce;

import br.edu.unifacisa.lojaecommerce.entidades.Cadastro;
import br.edu.unifacisa.lojaecommerce.entidades.Produtos;
import br.edu.unifacisa.lojaecommerce.repositorios.CadastroRepository;
import br.edu.unifacisa.lojaecommerce.repositorios.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LojaEcommerceApplication implements CommandLineRunner {

	@Autowired
	private CadastroRepository cadastroRepository;

	@Autowired
	private ProdutosRepository produtosRepository;

	@Override
	public void run(String... args) throws Exception {

		Scanner teclado = new Scanner(System.in);
		Produtos lojaProdutos = new Produtos();
		Cadastro usuario = new Cadastro();

		boolean menu = true;

		System.out.println("=====================================================\n" +
				"1) Efetuar Login\n"
				+ "2) Criar Conta\n"
				+ "3) Sair\n"
				+ "=====================================================\n");
		int log = Integer.parseInt(teclado.nextLine());

//	LISTANDO LOGINS PARA TESTES
//		for (Cadastro teste : cadastroRepository.findAll()) {
//			System.out.println("Cod: " + teste.getId() + "|Nome: " + teste.getCadastroNome() + "|Email: " + teste.getCadastroEmail() + "|Senha: " + teste.getCadastroSenha());
//		}

		while (log != 3) {
			//Login e Verificação
			if (log == 1) {

				System.out.println("Login");
				String login = teclado.nextLine();
				System.out.println("Senha");
				String senha = teclado.nextLine();

				usuario = cadastroRepository.findByCadastroNome(login);

				if (usuario != null && usuario.getCadastroSenha().equals(senha)) {
					System.out.println("Logado com sucesso!");
					break;
				} else {
					System.out.println("Usuario ou Senha incorretos!");
				}
			//Cadastro
			} else if (log == 2) {
				Cadastro novoUsuario = new Cadastro();

				System.out.println("Usuario: ");
				String nomeCadastro = teclado.nextLine();


				System.out.println("Email: ");
				String emailCadastro = teclado.nextLine();

				System.out.println("Senha: ");
				String senhaCadastro = teclado.nextLine();

				if (!nomeCadastro.isEmpty() && !emailCadastro.isEmpty() && !senhaCadastro.isEmpty()) {

					novoUsuario.setCadastroNome(nomeCadastro);
					novoUsuario.setCadastroEmail(emailCadastro);
					novoUsuario.setCadastroSenha(senhaCadastro);

					cadastroRepository.save(novoUsuario);
					System.out.println("Conta Criada com sucesso!");

					System.out.println("=====================================================\n" +
							"1) Efetuar Login\n"
							+ "2) Criar Conta\n"
							+ "3) Sair\n"
							+ "=====================================================\n");
					log = Integer.parseInt(teclado.nextLine());

				} else {
					System.out.println("Uma das opções está vazia!");
				}
			} else if (log == 3) {
				menu = false;
				break;
			} else {
				System.out.println("Digite uma opção valida!");
				System.out.println("=====================================================\n" +
						"1) Efetuar Login\n"
						+ "2) Criar Conta\n"
						+ "3) Sair\n"
						+ "=====================================================\n");
				log = Integer.parseInt(teclado.nextLine());
			}
		}

		while (menu) {
			System.out.println("\n" + "Loja Ecommerce\n" +
					"=====================================================\n" + "1) Listar Produtos\n"
					+ "2) Comprar produto por Codigo\n" + "3) Adicionar Produto\n" + "4) Sair\n"
					+ "=====================================================\n");

			int menuOption = Integer.parseInt(teclado.nextLine());

			if(menuOption == 1){
				for (Produtos p : produtosRepository.findAll()){
					System.out.println("Cod: "+p.getIdProduto() +"|Nome: "+ p.getProdutoNome()+ "|Valor: "+p.getProdutoValor());
				}
			} else if (menuOption == 2) {

				//Criar classe carrinho

			} else if (menuOption == 3) {

				System.out.println("Nome: ");
				String produtoNome = teclado.nextLine();
				System.out.println("Valor: ");
				String produtoValor = teclado.nextLine();

				lojaProdutos.setProdutoNome(produtoNome);
				lojaProdutos.setProdutoValor(produtoValor);
				produtosRepository.save(lojaProdutos);

			}
			else if (menuOption == 4) {
				menu = false;
			}else{
				System.out.println("Opção Invalida");
			}
		}
		System.out.println("Obrigado por testar a nossa Loja!!!");
	}

	public static void main(String[] args) {
		SpringApplication.run(LojaEcommerceApplication.class, args);
	}
}
