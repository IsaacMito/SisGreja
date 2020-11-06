package com.isaac.sisgreja.util;

import java.awt.TextArea;

import javax.swing.JDialog;

import com.isaac.sisgreja.domain.Fiel;
import com.isaac.sisgreja.domain.Pastor;
import com.isaac.sisgreja.persist.BancoDados;
import com.isaac.sisgreja.ui.UiPrincipal;

public class UiListar {

	private JDialog form;

	/**
	 * Create the dialog.
	 */
	public UiListar(JDialog uiPai) {
		initialize(uiPai);
	}

	private void initialize(JDialog uiPai) {

		form = new JDialog(uiPai);
		form.getContentPane().setEnabled(false);
		form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		form.setTitle(Constantes.NOME_SISTEMA + " | Listar");
		form.setBounds(100, 100, 230, 331);
		form.getContentPane().setLayout(null);
		
		TextArea textLista = new TextArea();
		textLista.setEditable(false);
		textLista.setBounds(10, 30, 193, 255);
		form.getContentPane().add(textLista);
		
		if (UiPrincipal.fieisS == true) {
			
			for (String key : BancoDados.fieis.keySet()) {
				Fiel value = BancoDados.fieis.get(key);
				textLista.setText(value.getNome());
			}
		} else {
			for (String key : BancoDados.pastores.keySet()) {
				Pastor value = BancoDados.pastores.get(key);
				textLista.setText(value.getNome());
			}
		}
	}

	public void setVisible(boolean b) {
		form.setVisible(b);
	}
}