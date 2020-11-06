package com.isaac.sisgreja.util;

import javax.swing.JDialog;
import javax.swing.JTextField;

import com.isaac.sisgreja.domain.Fiel;
import com.isaac.sisgreja.domain.Pastor;
import com.isaac.sisgreja.persist.BancoDados;
import com.isaac.sisgreja.ui.UiPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class UiCadastrar {

	private JDialog form;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textDataNascimento;

	/**
	 * Create the dialog.
	 */
	public UiCadastrar(JDialog uiPai) {
		initialize(uiPai);
	}

	private void initialize(JDialog uiPai) {

		form = new JDialog(uiPai);
		form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		form.setTitle(Constantes.NOME_SISTEMA + " | Cadastrar");
		form.setBounds(100, 100, 394, 283);
		form.getContentPane().setLayout(null);

		textNome = new JTextField();
		textNome.setBounds(121, 37, 200, 27);
		form.getContentPane().add(textNome);
		textNome.setColumns(10);

		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(121, 78, 200, 27);
		form.getContentPane().add(textCpf);

		textDataNascimento = new JTextField();
		textDataNascimento.setColumns(10);
		textDataNascimento.setBounds(121, 116, 200, 27);
		form.getContentPane().add(textDataNascimento);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(23, 40, 46, 14);
		form.getContentPane().add(lblNome);

		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(23, 81, 46, 14);
		form.getContentPane().add(lblCpf);

		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(23, 119, 114, 14);
		form.getContentPane().add(lblDataNascimento);

		JButton btnCadastrar = new JButton("Cadastar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (UiPrincipal.fieisS == true) {
					try {
						Fiel fiel = new Fiel();
						fiel.setNome(textNome.getText());
						fiel.setCpf(Integer.parseInt(textCpf.getText()));

						SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date data = format.parse(textDataNascimento.getText());
						fiel.setDataNacimento(data);

						int cpf = Integer.parseInt(textCpf.getText());

						String keyToSearch = Integer.toString(cpf);

						if (BancoDados.fieis.containsKey(keyToSearch)) {
							JOptionPane.showMessageDialog(form, "Esta conta já está cadastrada");
						} else {
							BancoDados.fieis.put(Integer.toString(fiel.getCpf()), fiel);
							JOptionPane.showMessageDialog(form, "Cadastro efetuado com sucesso");
						}

					} catch (ParseException w) {
						JOptionPane.showMessageDialog(form, "Data incorreta!");

					} catch (java.lang.NumberFormatException w) {
						JOptionPane.showMessageDialog(form, "Credenciais erradas ou Vasias");
					}
				} else {
					try {
						Pastor pastor = new Pastor();
						pastor.setNome(textNome.getText());
						pastor.setCpf(Integer.parseInt(textCpf.getText()));

						SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date data = format.parse(textDataNascimento.getText());
						pastor.setDataNacimento(data);

						int cpf = Integer.parseInt(textCpf.getText());

						String keyToSearch = Integer.toString(cpf);

						if (BancoDados.pastores.containsKey(keyToSearch)) {
							JOptionPane.showMessageDialog(form, "Esta conta já está cadastrada");
						} else {
							BancoDados.pastores.put(Integer.toString(pastor.getCpf()), pastor);
							JOptionPane.showMessageDialog(form, "Cadastro efetuado com sucesso");
						}

					} catch (ParseException w) {
						JOptionPane.showMessageDialog(form, "Data incorreta!");

					} catch (java.lang.NumberFormatException w) {
						JOptionPane.showMessageDialog(form, "Credenciais erradas ou Vasias");
					}
				}

			}
		});
		btnCadastrar.setBounds(135, 162, 89, 23);
		form.getContentPane().add(btnCadastrar);
	}

	public void setVisible(boolean b) {
		form.setVisible(b);
	}

}