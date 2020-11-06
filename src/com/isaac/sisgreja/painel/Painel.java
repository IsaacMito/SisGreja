package com.isaac.sisgreja.painel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.isaac.sisgreja.domain.Fiel;
import com.isaac.sisgreja.domain.Pastor;
import com.isaac.sisgreja.persist.BancoDados;

public class Painel {

	private Scanner entrada = new Scanner(System.in);
	private int opcao = 0;
	private boolean sair = false;
	private String dados;

	private void menuPricipal() {

		System.out.println("------SisGreja------");

		System.out.println("1 - Fiel");
		System.out.println("2 - Pastor");
		System.out.println("3 - Sair");

		System.out.print("Digite: ");
	}

	private void menuFiel() {

		System.out.println("\n----Menu Fiel----\n");
		menuSecundario();
	}

	private void menuPastor() {
		System.out.println("\n----Menu Pastor----\n");
		menuSecundario();
	}

	private void menuSecundario() {

		System.out.println("------SisGreja------");

		System.out.println("1 - cadastrar");
		System.out.println("2 - Alterar");
		System.out.println("3 - Apagar");
		System.out.println("4 - listar");
		System.out.println("5 - Voltar");

		System.out.print("Digite: ");
	}

	public void executa() throws ParseException {

		while (sair != true) {

			menuPricipal();
			opcao = entrada.nextInt();
			if (opcao == 1) {
				menuFiel();
				opcao = entrada.nextInt();
				if (opcao == 1) {
					Fiel fiel = new Fiel();
					System.out.print("Qual seu nome: ");
					dados = entrada.next();
					fiel.setNome(dados);

					System.out.print("Qual seu cpf: ");
					dados = entrada.next();
					int cpf = Integer.parseInt(dados);
					fiel.setCpf(Integer.parseInt(dados));

					// Verifica data
					while (true) {
						try {
							System.out.print("Qual sua data de Nascimento: ");
							dados = entrada.next();
							SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							Date data = format.parse(dados);
							fiel.setDataNacimento(data);
							break;
						} catch (ParseException e) {
							System.out.println("\nDATA INCORRETA!\n");
						}
					}

					String keyToSearch = Integer.toString(cpf);

					if (BancoDados.fieis.containsKey(keyToSearch)) {
						System.out.println("\nEsta conta já está cadastrada");
					} else {
						BancoDados.fieis.put(Integer.toString(fiel.getCpf()), fiel);
						System.out.println("\nCadastro efetuado com sucesso\n");
					}

				} else if (opcao == 2) {

					int cpf;
					String nome = null;
					Date dataDeNascimento = null;

					Fiel fiel = new Fiel();

					System.out.print("Qual seu cpf: ");
					dados = entrada.next();
					cpf = Integer.parseInt(dados);

					if (BancoDados.fieis.containsKey(Integer.toString(cpf))) {

						System.out.println("O que deseja alterar");
						System.out.println("1 - cpf");
						System.out.println("2 - nome");
						System.out.println("3 - Data de Nascimento");

						opcao = entrada.nextInt();

						if (opcao == 1) {

							System.out.print("Qual seu cpf: ");
							dados = entrada.next();
							cpf = Integer.parseInt(dados);
							fiel.setCpf(cpf);
							System.out.println("Alterado com susesso");

						} else if (opcao == 2) {

							System.out.print("Qual seu nome: ");
							dados = entrada.next();
							nome = dados;
							fiel.setNome(nome);
							System.out.println("Alterado com susesso");

						} else if (opcao == 3) {

							while (true) {
								try {
									System.out.print("Qual sua data de Nascimento: ");
									dados = entrada.next();
									SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
									Date data = format.parse(dados);
									fiel.setDataNacimento(data);
									fiel.setDataNacimento(dataDeNascimento);
									System.out.println("Alterado com susesso");
									break;
								} catch (ParseException e) {
									System.out.println("\nDATA INCORRETA!\n");
								}
							}

						}

						BancoDados.fieis.put(Integer.toString(cpf), fiel);
					} else {
						System.out.println("Conta não encontrada");
					}

				} else if (opcao == 3) {

					int cpf;
					System.out.print("Qual seu cpf: ");
					dados = entrada.next();
					cpf = Integer.parseInt(dados);

					String keyToSearch = Integer.toString(cpf);
					if (BancoDados.fieis.containsKey(keyToSearch)) {

						BancoDados.fieis.remove(Integer.toString(cpf));
						System.out.println("\nPessoa:" + cpf + " Deletada\n");
					} else {
						System.out.println("pessoa não encontrada");
					}
					opcao = 0;

				} else if (opcao == 4) {

					for (String key : BancoDados.fieis.keySet()) {
						Fiel value = BancoDados.fieis.get(key);
						System.out.println(value.getNome());
					}
					System.out.println("");
				} else if(opcao == 5){
					
				}else {
					
					System.out.println();
					System.out.println("\tMenu Invalido");
					System.out.println();
				}

			} else if (opcao == 2) {

				menuPastor();
				opcao = entrada.nextInt();
				if (opcao == 1) {
					Pastor pastor = new Pastor();
					System.out.print("Qual seu nome: ");
					dados = entrada.next();
					pastor.setNome(dados);

					System.out.print("Qual seu cpf: ");
					dados = entrada.next();
					int cpf = Integer.parseInt(dados);
					pastor.setCpf(Integer.parseInt(dados));

					// Verifica data
					while (true) {
						try {
							System.out.print("Qual sua data de Nascimento: ");
							dados = entrada.next();
							SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							Date data = format.parse(dados);
							pastor.setDataNacimento(data);
							break;
						} catch (ParseException e) {
							System.out.println("\nDATA INCORRETA!\n");
						}
					}
					String keyToSearch = Integer.toString(cpf);

					if (BancoDados.pastores.containsKey(keyToSearch)) {
						System.out.println("\nEsta conta já está cadastrada");
					} else {
						BancoDados.pastores.put(Integer.toString(pastor.getCpf()), pastor);
						System.out.println("\nCadastro efetuado com sucesso\n");
					}

				} else if (opcao == 2) {

					int cpf;
					String nome = null;
					Date dataDeNascimento = null;

					Pastor pastor = new Pastor();

					System.out.print("Qual seu cpf: ");
					dados = entrada.next();
					cpf = Integer.parseInt(dados);

					System.out.println("O que deseja alterar");
					System.out.println("1 - cpf");
					System.out.println("2 - nome");
					System.out.println("3 - Data de Nascimento");

					opcao = entrada.nextInt();

					String keyToSearch = Integer.toString(cpf);
					if (BancoDados.pastores.containsKey(keyToSearch)) {

						if (opcao == 1) {

							System.out.print("Qual seu cpf: ");
							dados = entrada.next();
							cpf = Integer.parseInt(dados);
							pastor.setCpf(cpf);

						} else if (opcao == 2) {

							System.out.print("Qual seu nome: ");
							dados = entrada.next();
							nome = dados;
							pastor.setNome(nome);

						} else if (opcao == 3) {

							while (true) {
								try {
									System.out.print("Qual sua data de Nascimento: ");
									dados = entrada.next();
									SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
									Date data = format.parse(dados);
									pastor.setDataNacimento(data);
									pastor.setDataNacimento(dataDeNascimento);
									break;
								} catch (ParseException e) {
									System.out.println("\nDATA INCORRETA!\n");
								}
							}

						} else {
							System.out.println();
							System.out.println("\tMenu Invalido");
							System.out.println();
						}

						BancoDados.pastores.put(Integer.toString(pastor.getCpf()), pastor);
						System.out.println("\nConta alterada com susesso efetuado com sucesso\n\n");
					} else {
						System.out.println("Conta não encontrada");
					}
				} else if (opcao == 3) {

					int cpf;
					System.out.print("Qual seu cpf: ");
					dados = entrada.next();
					cpf = Integer.parseInt(dados);

					String keyToSearch = Integer.toString(cpf);
					if (BancoDados.pastores.containsKey(keyToSearch)) {

						BancoDados.pastores.remove(Integer.toString(cpf));
						System.out.println("\nPessoa:" + cpf + " Deletada!\n");
					} else {
						System.out.println("pessoa não encontrada!");
					}
					opcao = 0;

				} else if (opcao == 4) {

					for (String key : BancoDados.pastores.keySet()) {

						Pastor value = BancoDados.pastores.get(key);

						System.out.println(value.getNome());
					}
				} else {
					System.out.println();
					System.out.println("\tMenu Invalido");
					System.out.println();
				}

			} else if (opcao == 3) {
				System.out.println("\n\tAdeus\n");
				sair = true;
				System.exit(0);
				entrada.close();
			} else {
				System.out.println();
				System.out.println("\tMenu Invalido");
				System.out.println();
			}
		}
	}
}
