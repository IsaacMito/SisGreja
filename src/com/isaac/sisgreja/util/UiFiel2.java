package com.isaac.sisgreja.util;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JTextField;

public class UiFiel2  {

	private JDialog form;
	private Panel pnlCentral;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Create the dialog.
	 */
	public UiFiel2(JFrame uiPai) {
		initialize(uiPai);
	}

	private void initialize(JFrame uiPai) {
		
		form = new JDialog(uiPai);
		form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		form.setTitle(Constantes.NOME_SISTEMA+ " | Fiel");
		form.setBounds(100, 100, 584, 436);
		form.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel pnlNavegador = new Panel();
		form.getContentPane().add(pnlNavegador, BorderLayout.SOUTH);
		
		JButton btnPrimeiro = new JButton("<<");
		pnlNavegador.add(btnPrimeiro);
		
		JButton btnAnterio = new JButton("<");
		pnlNavegador.add(btnAnterio);
		
		JButton btnSeguinte = new JButton(">");
		pnlNavegador.add(btnSeguinte);
		
		JButton btnUltimo = new JButton(">>");
		pnlNavegador.add(btnUltimo);
		
		Panel pnlControles = new Panel();
		form.getContentPane().add(pnlControles, BorderLayout.EAST);
		pnlControles.setLayout(new BoxLayout(pnlControles, BoxLayout.Y_AXIS));
		
		JSeparator separator_4 = new JSeparator();
		pnlControles.add(separator_4);
		
		JButton btnNovo = new JButton("Novo");
		pnlControles.add(btnNovo);
		
		JButton btnAlterar = new JButton("Alterar");
		pnlControles.add(btnAlterar);
		
		JSeparator separator_1 = new JSeparator();
		pnlControles.add(separator_1);
		
		JButton btnSalvar = new JButton("Salvar");
		pnlControles.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		pnlControles.add(btnCancelar);
		
		JSeparator separator_2 = new JSeparator();
		pnlControles.add(separator_2);
		
		JButton btnApagar = new JButton("Apagar");
		pnlControles.add(btnApagar);
		
		JSeparator separator = new JSeparator();
		pnlControles.add(separator);
		
		JButton btnFechar = new JButton("Fechar");
		pnlControles.add(btnFechar);
		
		JSeparator separator_3 = new JSeparator();
		pnlControles.add(separator_3);
		
		Panel pnlTitulo = new Panel();
		form.getContentPane().add(pnlTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Cadastro de Fiel");
		pnlTitulo.add(lblTitulo);
		
		pnlCentral = new Panel();
		form.getContentPane().add(pnlCentral, BorderLayout.CENTER);
		pnlCentral.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cpf");
		lblNewLabel.setBounds(12, 12, 55, 16);
		pnlCentral.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 40, 114, 20);
		pnlCentral.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(12, 72, 55, 16);
		pnlCentral.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 100, 459, 20);
		pnlCentral.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data");
		lblNewLabel_2.setBounds(12, 132, 55, 16);
		pnlCentral.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 161, 175, 20);
		pnlCentral.add(textField_2);
		textField_2.setColumns(10);
	}
}
