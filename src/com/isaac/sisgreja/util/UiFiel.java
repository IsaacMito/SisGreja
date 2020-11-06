package com.isaac.sisgreja.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class UiFiel  {

	private JDialog form;
	
	/**
	 * Create the dialog.
	 */
	public UiFiel(JFrame uiPai) {
		initialize(uiPai);
	}

	private void initialize(JFrame uiPai) {
		
		form = new JDialog(uiPai);
		form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		form.setTitle(Constantes.NOME_SISTEMA+ " | Fiel");
		form.setBounds(100, 100, 211, 236);
		form.getContentPane().setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UiCadastrar(form).setVisible(true);
			}
		});
		btnCadastrar.setBounds(47, 24, 89, 23);
		form.getContentPane().add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UiAlterar(form).setVisible(true);
			}
		});
		btnAlterar.setBounds(47, 58, 89, 23);
		form.getContentPane().add(btnAlterar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new UiListar(form).setVisible(true);
			}	
		});
		btnListar.setBounds(47, 92, 89, 23);
		form.getContentPane().add(btnListar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UiRemover(form).setVisible(true);
			}
		});
		btnRemover.setBounds(47, 126, 89, 23);
		form.getContentPane().add(btnRemover);
	}

	public void setVisible(boolean b) {
		form.setVisible(b);
	}
}
