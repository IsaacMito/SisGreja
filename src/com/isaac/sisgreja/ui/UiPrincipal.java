package com.isaac.sisgreja.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.isaac.sisgreja.util.Constantes;
import com.isaac.sisgreja.util.UiFiel;
import com.isaac.sisgreja.util.UiPastor;
import com.isaac.sisgreja.util.UiSobre;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiPrincipal {

	public static boolean fieisS; 
	
	private JFrame form;

	/**
	 * Create the application.
	 */
	public UiPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		form = new JFrame();
		form.setResizable(false);
		form.setTitle(Constantes.NOME_SISTEMA);
		form.setBounds(100, 100, 620, 255);
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.getContentPane().setLayout(null);

		JLabel lblSisGreja = new JLabel("SIS GREJA");
		lblSisGreja.setFont(new Font("Tahoma", Font.BOLD, 57));
		lblSisGreja.setBounds(146, 59, 313, 75);
		form.getContentPane().add(lblSisGreja);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		form.getContentPane().add(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmFiel = new JMenuItem("Fiel");
		mntmFiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UiFiel(form).setVisible(true);
				fieisS = true;
			}
		});
		mnCadastro.add(mntmFiel);
		
		JMenuItem mntmPastor = new JMenuItem("Pastor");
		mntmPastor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UiPastor(form).setVisible(true);
				fieisS= false;
			}
		});
		mnCadastro.add(mntmPastor);
		
		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnCadastro.add(mntmSair);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UiSobre(form).setVisible(true);
			}
		});
		mnAjuda.add(mntmSobre);
	}

	public void setVisible(boolean b) {
		form.setVisible(true);
	}
}
