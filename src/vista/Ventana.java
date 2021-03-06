package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Logger;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.AccesoDatos;

public class Ventana extends javax.swing.JFrame {

	// Variables declaration - do not modify
	private JButton jButton2;
	private JComboBox<String> jComboBox1;
	private JComboBox<String> jComboBox2;
	private JList<String> jList1;
	private JScrollPane jScrollPane1;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	// End of variables declaration

	/**
	 * Creates new form Ventana
	 */
	public Ventana() {
		inicio();
		this.setTitle("Ventana 1");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void inicio() {
		
		//Obtener las bd, con el metodo de AccesoDatos
		ArrayList<String> lista = new AccesoDatos().getSchema();
		String[] datos = lista.toArray(new String[lista.size()]);

		Container contenido = this.getContentPane();
		this.setLayout(new BorderLayout());

		// Se puede quitar los javax.swing, solo hay que importarlos
		jScrollPane1 = new JScrollPane();
		jList1 = new JList<>();
		jComboBox1 = new JComboBox<>();
		jButton2 = new JButton();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		jComboBox2 = new JComboBox<>();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//Muestra las bases de datos con el ArrayList lista y String[] datos
		jList1 = new JList<>(datos);

		/*//Muestra las bases de datos
		jList1.setModel(new AbstractListModel<String>() {
			

			public int getSize() {
				return datos.length;
			}

			public String getElementAt(int i) {
				return datos[i];
			}
			
		});*/
		
		jList1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				jList1ValueChanged(evt);
			}
		});
		
		jScrollPane1.setViewportView(jList1);

	/*	jComboBox1.setModel(new DefaultComboBoxModel<>(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4" }));*/

		jButton2.setText("PulsaMe!");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		/*jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Lanzarote", "Fuerteventura", "Gran Canaria",
				"Tenerife", "La Palma", "La Gomera", "El Hierro" }));
		jComboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jComboBox2ActionPerformed(evt);
			}
		});*/

		/*
		 * GroupLayout layout = new GroupLayout(getContentPane());
		 * getContentPane().setLayout(layout); layout.setHorizontalGroup(
		 * layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(layout.createSequentialGroup() .addContainerGap()
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(layout.createSequentialGroup() .addComponent(jScrollPane1,
		 * GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
		 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 108,
		 * GroupLayout.PREFERRED_SIZE) .addComponent(jComboBox1,
		 * GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
		 * .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 108,
		 * GroupLayout.PREFERRED_SIZE)) .addGap(18, 18, 18)
		 * .addComponent(jComboBox2, 0, 116, Short.MAX_VALUE))
		 * .addGroup(layout.createSequentialGroup() .addComponent(jTextField2,
		 * GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
		 * .addGap(132, 132, 132) .addComponent(jTextField3)))
		 * .addContainerGap()) ); layout.setVerticalGroup(
		 * layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(layout.createSequentialGroup() .addContainerGap()
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(layout.createSequentialGroup()
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		 * .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE,
		 * GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 * .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE,
		 * GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) .addGap(18,
		 * 18, 18) .addComponent(jButton2) .addGap(18, 18, 18)
		 * .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE,
		 * GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 * .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 145,
		 * GroupLayout.PREFERRED_SIZE))
		 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		 * .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE,
		 * GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 * .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE,
		 * GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 * .addContainerGap(39, Short.MAX_VALUE)) );
		 */

		// Ahora se a�aden los elementos ventana...

		contenido.add(jScrollPane1, BorderLayout.WEST);
		contenido.add(jComboBox2, BorderLayout.CENTER);
		/*contenido.add(jButton2, BorderLayout.SOUTH);
		contenido.add(jTextField1, BorderLayout.CENTER);*/
		

		pack();
	}// </editor-fold>

	private void jButton2ActionPerformed(ActionEvent evt) {
		Calendar Cal = Calendar.getInstance();
		String fec = Cal.get(Cal.DATE) + "/" + (Cal.get(Cal.MONTH) + 1) + "/" + Cal.get(Cal.YEAR) + " "
				+ Cal.get(Cal.HOUR_OF_DAY) + ":" + Cal.get(Cal.MINUTE) + ":" + Cal.get(Cal.SECOND);
		jTextField1.setText(fec);
	}

	private void jList1ValueChanged(ListSelectionEvent evt) {
		
		JList objetoEvento = (JList) evt.getSource();
		String texto = objetoEvento.getSelectedValue().toString();
		jTextField2.setText(texto);
		
		ArrayList<String> tablas = new AccesoDatos().getTablesSchema(texto);
		String[] arrayTablas = tablas.toArray(new String[tablas.size()]);
		
		DefaultComboBoxModel modelo = new DefaultComboBoxModel<>(arrayTablas);
		jComboBox1.setModel(modelo);
		

	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {
		JComboBox listaCombo = (JComboBox) evt.getSource();
		jTextField3.setText(listaCombo.getSelectedItem().toString());

	}

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Ventana().setVisible(true);
			}
		});
	}

}
