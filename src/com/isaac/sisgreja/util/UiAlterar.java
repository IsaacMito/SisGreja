package com.isaac.sisgreja.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.isaac.sisgreja.domain.Fiel;
import com.isaac.sisgreja.domain.Pastor;
import com.isaac.sisgreja.persist.BancoDados;
import com.isaac.sisgreja.ui.UiPrincipal;

public class UiAlterar {

	private JDialog form;
	private JTextField textCpfAlterar;
	private JTextField textNovoCpf;
	private JTextField textNovoNome;
	private JTextField textNovaData;

	/**
	 * Create the dialog.
	 */
	public UiAlterar(JDialog uiPai) {
		initialize(uiPai);
	}

	private void initialize(JDialog uiPai) {

		form = new JDialog(uiPai);
		form.getContentPane().setEnabled(false);
		form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		form.setTitle(Constantes.NOME_SISTEMA + " | Alterar");
		form.setBounds(100, 100, 394, 429);
		form.getContentPane().setLayout(null);

		textCpfAlterar = new JTextField();
		textCpfAlterar.setBounds(184, 28, 170, 30);
		form.getContentPane().add(textCpfAlterar);
		textCpfAlterar.setColumns(10);

		JLabel lblDigiteCpf = new JLabel("Digite seu antigo cpf");
		lblDigiteCpf.setBounds(22, 36, 120, 14);
		form.getContentPane().add(lblDigiteCpf);

		textNovoCpf = new JTextField();
		textNovoCpf.setColumns(10);
		textNovoCpf.setBounds(184, 125, 170, 30);
		form.getContentPane().add(textNovoCpf);

		JLabel lblDigiteSeuNovoCpf = new JLabel("Digite seu novo cpf");
		lblDigiteSeuNovoCpf.setBounds(22, 133, 120, 14);
		form.getContentPane().add(lblDigiteSeuNovoCpf);

		textNovoNome = new JTextField();
		textNovoNome.setColumns(10);
		textNovoNome.setBounds(184, 161, 170, 30);
		form.getContentPane().add(textNovoNome);

		JLabel lblDigiteSeuNovoNome = new JLabel("Digite seu novo nome");
		lblDigiteSeuNovoNome.setBounds(22, 169, 120, 14);
		form.getContentPane().add(lblDigiteSeuNovoNome);

		textNovaData = new JTextField();
		textNovaData.setColumns(10);
		textNovaData.setBounds(184, 202, 170, 30);
		form.getContentPane().add(textNovaData);

		JLabel lblDigiteSuaNovaData = new JLabel("Digite sua data de nascimento");
		lblDigiteSuaNovaData.setBounds(22, 205, 173, 14);
		form.getContentPane().add(lblDigiteSuaNovaData);

		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UiPrincipal.fieisS == true) {
					try {
						int cpf;
						Fiel fiel = new Fiel();
						cpf = Integer.parseInt(textCpfAlterar.getText());

						if (BancoDados.fieis.containsKey(Integer.toString(cpf))) {

							SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							Date data = format.parse(textNovaData.getText());
							fiel.setDataNacimento(data);

							cpf = Integer.parseInt(textNovoCpf.getText());
							fiel.setNome(textNovoNome.getText());
							fiel.setDataNacimento(data);
							fiel.setCpf(cpf);

							BancoDados.fieis.put(Integer.toString(cpf), fiel);
							JOptionPane.showMessageDialog(form, "Conta alterada com susesso!");
							
						} else {
							JOptionPane.showMessageDialog(form, "Conta não Encotrada!");
						}
					} catch (ParseException w) {
						JOptionPane.showMessageDialog(form, "Data incorreta!");

					} catch (java.lang.NumberFormatException w) {
						JOptionPane.showMessageDialog(form, "Credenciais erradas ou Vasias");
					}
				} else {
					try {
						int cpf;
						Pastor pastor = new Pastor();
						cpf = Integer.parseInt(textCpfAlterar.getText());

						if (BancoDados.fieis.containsKey(Integer.toString(cpf))) {

							SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							Date data = format.parse(textNovaData.getText());
							pastor.setDataNacimento(data);

							cpf = Integer.parseInt(textNovoCpf.getText());
							pastor.setNome(textNovoNome.getText());
							pastor.setDataNacimento(data);
							pastor.setCpf(cpf);
							
							BancoDados.pastores.put(Integer.toString(cpf), pastor);
							JOptionPane.showMessageDialog(form, "Conta alterada com susesso!");
						} else {
							JOptionPane.showMessageDialog(form, "Conta não Encotrada!");
						}
					} catch (ParseException w) {
						JOptionPane.showMessageDialog(form, "Data incorreta!");

					} catch (java.lang.NumberFormatException w) {
						JOptionPane.showMessageDialog(form, "Credenciais erradas ou Vasias");
					}
				}

			}
		});
		btnConfirma.setBounds(106, 238, 89, 23);
		form.getContentPane().add(btnConfirma);
	}

	public void setVisible(boolean b) {
		form.setVisible(b);
	}

}