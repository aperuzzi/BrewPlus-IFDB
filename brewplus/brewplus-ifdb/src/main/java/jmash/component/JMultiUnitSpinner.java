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

package jmash.component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import jmash.Main;

/**
 *
 * @author AChiari
 */
public abstract class JMultiUnitSpinner extends javax.swing.JPanel {

	/** Creates new form JVolumeSpinner */
	public JMultiUnitSpinner(String[] list) {
		initComponents();
		for (int i = 0; i < list.length; i++)
			list[i] = " " + list[i];
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(list));
		jMashSpinner1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ev) {
				Main.putIntoCache(nome + "_V", getRealValue());
			}
		});
		jComboBox1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				Main.putIntoCache(nome + "_U", jComboBox1.getSelectedIndex());
			}
		});
	}

	protected abstract double getRealValue();

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jMashSpinner1 = new jmash.component.JMashSpinner();
		jComboBox1 = new javax.swing.JComboBox();

		jMashSpinner1.setBorder(null);
		jMashSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jMashSpinner1StateChanged(evt);
			}
		});

		jComboBox1.setAlignmentX(0.0F);
		jComboBox1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox1ItemStateChanged(evt);
			}
		});
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout.createSequentialGroup()
						.add(jMashSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
						.add(jMashSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>//GEN-END:initComponents

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed

	}// GEN-LAST:event_jComboBox1ActionPerformed

	private int showing = 0;
	protected String nome;
	protected boolean skipRicalcoli = false;

	protected void setValues(double factor) {
		skipRicalcoli = true;
		((SpinnerNumberModel) jMashSpinner1.getModel())
				.setMaximum((Double) ((SpinnerNumberModel) jMashSpinner1.getModel()).getMaximum() * factor);
		((SpinnerNumberModel) jMashSpinner1.getModel())
				.setMinimum((Double) ((SpinnerNumberModel) jMashSpinner1.getModel()).getMinimum() * factor);
		double T = jMashSpinner1.getDoubleValue();
		jMashSpinner1.setDoubleValue(T * factor);
		skipRicalcoli = false;
	}

	private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jComboBox1ItemStateChanged
		int i = jComboBox1.getSelectedIndex();
		if (i == showing)
			return;
		skipRicalcoli = true;
		changeUnit(showing, i);
		skipRicalcoli = false;
		showing = i;
	}// GEN-LAST:event_jComboBox1ItemStateChanged

	protected int unit;

	public void setDoubleValue(double V) {
		getSpinner().setDoubleValue(V);
		Main.putIntoCache(nome + "_V", V);
	}

	protected void changeUnit(int from, int to) {
		unit = to;
	}

	private void jMashSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_jMashSpinner1StateChanged
		fireChangeEvent(evt);
	}// GEN-LAST:event_jMashSpinner1StateChanged

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JComboBox jComboBox1;
	private jmash.component.JMashSpinner jMashSpinner1;

	// End of variables declaration//GEN-END:variables
	public JMashSpinner getSpinner() {
		return jMashSpinner1;
	}

	public JComboBox getComboBox() {
		return jComboBox1;
	}

	/*
	 * public void setModel(double def, double min, double max, double step,
	 * String format, String name){ jMashSpinner1.setModel(def,min,max,step);
	 * nome=name; if(name.startsWith("0."))throw new RuntimeException(name); }
	 */
	public void setModel(double def, double min, double max, double step, String format, String name) {
		if (name != null)
			def = Main.getFromCache(name + "_V", def);
		if (def < min)
			def = min;
		if (def > max)
			def = max;
		jMashSpinner1.setModel(def, min, max, step);
		jMashSpinner1.setFormat(format);
		nome = name;
		if (name != null)
			jComboBox1.setSelectedIndex(Main.getFromCache(name + "_U", new Integer(0)));
	}

	public void setModelFormat(double def, double min, double max, double step, String format, String name) {
		if (name != null)
			def = Main.getFromCache(name + "_V", def);
		if (def < min)
			def = min;
		if (def > max)
			def = max;
		jMashSpinner1.setModel(def, min, max, step);
		jMashSpinner1.setFormat(format);
		nome = name;
		if (name != null)
			jComboBox1.setSelectedIndex(Main.getFromCache(name + "_U", new Integer(0)));
	}

	public void setFormat(String format) {
		jMashSpinner1.setFormat(format);
	}

	private List<ChangeListener> listeners = new ArrayList();

	public void addChangeListener(ChangeListener listener) {
		listeners.add(listener);
	}

	public void removeChangeListener(ChangeListener listener) {
		listeners.remove(listener);
	}

	public ChangeListener[] getChangeListeners() {
		return (ChangeListener[]) listeners.toArray();
	}

	private void fireChangeEvent(javax.swing.event.ChangeEvent evt) {
		if (!skipRicalcoli) {
			for (ChangeListener listener : listeners) {
				listener.stateChanged(evt);
			}
		}
	}

	@Override
	public void setEnabled(boolean flag) {
		getSpinner().setEnabled(flag);
		if (!flag) {
			getSpinner().setFont(getSpinner().getFont().deriveFont(Font.BOLD));
		} else {
			getSpinner().setFont(getSpinner().getFont().deriveFont(Font.PLAIN));
		}
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
}
