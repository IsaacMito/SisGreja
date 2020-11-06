package com.isaac.sisgreja.util;

import javax.swing.JDialog;

public class UiRemover {

	private JDialog form;

	/**
	 * Create the dialog.
	 */
	public UiRemover(JDialog uiPai) {
		initialize(uiPai);
	}

	private void initialize(JDialog uiPai) {

		form = new JDialog(uiPai);
		form.getContentPane().setEnabled(false);
		form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		form.setTitle(Constantes.NOME_SISTEMA + " | Alterar");
		form.setBounds(100, 100, 394, 429);
		form.getContentPane().setLayout(null);
	}

	public void setVisible(boolean b) {
		form.setVisible(b);
	}

}