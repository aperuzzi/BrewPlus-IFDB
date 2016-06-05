/*
 
 *
 *  This file is part of BrewPlus.
 *
 *  BrewPlus is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  BrewPlus is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with BrewPlus; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package jmash;

import atp.cHotEqn;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Alessandro
 */
public class ShowFormula extends ModalInternalFrame {
	private cHotEqn viewer = new cHotEqn();

	/** Creates new form ShowFormula */
	public ShowFormula(String msg, String formula) {
		this(msg, new String[] { formula });
	}

	public ShowFormula(String msg, String[] formulas) {
		initComponents();
		JPanel pnl = new JPanel();
		GridLayout GL = new GridLayout();
		pnl.setLayout(GL);
		GL.setColumns(1);
		GL.setRows(formulas.length);
		jTextArea1.setText(msg);
		for (int i = 0; i < formulas.length; i++) {
			cHotEqn V = new cHotEqn();
			V.setEditable(false);
			V.setDebug(false);
			V.setHAlign("center");
			V.setVAlign("middle");
			V.setEquation(formulas[i]);
			pnl.add(V);
		}
		getContentPane().add(pnl, java.awt.BorderLayout.CENTER);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {// GEN-BEGIN:initComponents
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		setClosable(true);
		setIconifiable(true);
		setResizable(true);
		setTitle("Formula");
		jScrollPane1.setPreferredSize(new java.awt.Dimension(164, 80));
		jTextArea1.setColumns(20);
		jTextArea1.setRows(4);
		jScrollPane1.setViewportView(jTextArea1);

		getContentPane().add(jScrollPane1, java.awt.BorderLayout.NORTH);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 400) / 2, (screenSize.height - 300) / 2, 400, 300);
	}// GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	// End of variables declaration//GEN-END:variables

}
