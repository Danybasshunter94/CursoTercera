package vista;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.Interface;

public class ManejoEventos
		extends JFrame /* implements ActionListener, Interface */ {

	// Interface intf1;
	private JButton boton;
	private JButton boton2;
	private JLabel etiqueta;
	private TextField texto;
	private Object evt;
	private JComboBox combo;

	public ManejoEventos() throws HeadlessException {

		super();
		// this.intf1.metodo1("123", 8);
		this.boton = new JButton();
		this.boton2 = new JButton();
		this.etiqueta = new JLabel();
		this.setTitle("Manejo de Eventos");
		Container contenido = this.getContentPane();

		boton.setText("Inicio");
		texto = new TextField("Texto inicial");
		boton2.setText("Cancelar");

		// combo box con Array
		String[] numero = { "uno", "dos", "tres" };
		combo = new JComboBox<>(numero);

		this.setLayout(new FlowLayout());

		// getview centralizada del evento
		/*
		 * boton.addActionListener(this); boton2.addActionListener(this);
		 * combo.addActionListener(this);
		 */
		ComboListener cl = new ComboListener();
		boton.addActionListener(new BotonListener());
		boton2.addActionListener(new CerrarBotonListener());
		combo.addActionListener(cl);
		contenido.add(boton);
		contenido.add(boton2);
		contenido.add(combo);
		contenido.add(texto);

		this.pack();
		this.setVisible(true);

	}

	class BotonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object objeto = e.getSource();

			JButton boton = (JButton) e.getSource();

			texto.setText(boton.getText());
		}

	}

	class CerrarBotonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
	
	class ComboListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JComboBox combo = (JComboBox) e.getSource();

			texto.setText(combo.getSelectedItem().toString());
		}
		
		
	}

	// @Override
	/*
	 * public void actionPerformed(ActionEvent evt) {
	 * 
	 * JButton bt = (JButton) evt.getSource(); texto.setText(bt.getText());
	 * 
	 * this.pack();
	 * 
	 * }
	 */

	public static void main(String[] args) {

		ManejoEventos manejo = new ManejoEventos();

	}

	/*
	 * @Override public int metodo1(String param1, int param2) { // TODO
	 * Auto-generated method stub return 0; }
	 * 
	 * @Override public int metodo2(Float param) { // TODO Auto-generated method
	 * stub return 0; }
	 * 
	 * @Override public Integer[] metodo3(float param1) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * Interna interna = new Interna();
	 * 
	 * public class Interna {
	 * 
	 * }
	 */

}
