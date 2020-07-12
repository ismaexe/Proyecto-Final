package tareas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import pricipal.Pantalla;

public class TareaSimple extends JLabel implements ActionListener {

	private static final long serialVersionUID = 1L;

	String textoTarea;
	JLabel lbTextoTarea;
	JButton btnCompletada, btnOpcTS, btnEdit, btnDelete;
	int tscompletada = 0;
	boolean opcDesplegadas = false;
	int idTS;
	int posY;

	Color colorFondoMoradoF = new Color(133, 106, 192);

	Icon nocompletado = new ImageIcon("recursos/botones/nocompletado.png");
	Icon completado = new ImageIcon("recursos/botones/completado.png");
	Icon opcTS = new ImageIcon("recursos/botones/opcTresPuntos.png");
	Icon eliminarTS = new ImageIcon("recursos/botones/eliminar.png");

	public TareaSimple(int posY, String textoTarea, int idTS) {

		this.idTS = idTS;

		this.setBounds(30, posY, 350, 50);
		this.setLayout(null);
		this.textoTarea = textoTarea;
		this.setBackground(colorFondoMoradoF);
		this.setOpaque(true);

		lbTextoTarea = new JLabel(textoTarea, SwingConstants.LEFT);
		lbTextoTarea.setBounds(70, 0, 250, 50);
		lbTextoTarea.setVisible(true);
		lbTextoTarea.setLayout(null);

		btnCompletada = new JButton();
		btnCompletada.setBounds(20, 10, 30, 30);
		btnCompletada.setIcon(nocompletado);
		btnCompletada.setOpaque(false);
		btnCompletada.setContentAreaFilled(false);
		btnCompletada.setFocusPainted(false);
		btnCompletada.setBorder(null);
		btnCompletada.setVisible(true);

		btnOpcTS = new JButton();
		btnOpcTS.setBounds(320, 10, 30, 30);
		btnOpcTS.setIcon(opcTS);
		btnOpcTS.setOpaque(false);
		btnOpcTS.setContentAreaFilled(false);
		btnOpcTS.setFocusPainted(false);
		btnOpcTS.setBorder(null);
		btnOpcTS.setVisible(true);

		btnEdit = new JButton();
		btnEdit.setBounds(290, 10, 30, 30);
		btnEdit.setIcon(opcTS);
		btnEdit.setOpaque(false);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setFocusPainted(false);
		btnEdit.setBorder(null);
		btnEdit.setVisible(false);

		btnDelete = new JButton();
		btnDelete.setBounds(260, 10, 30, 30);
		btnDelete.setIcon(eliminarTS);
		btnDelete.setOpaque(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setFocusPainted(false);
		btnDelete.setBorder(null);
		btnDelete.setVisible(false);

		this.add(lbTextoTarea);
		this.add(btnCompletada);
		this.add(btnOpcTS);
		this.add(btnDelete);
		this.add(btnEdit);
		this.setVisible(true);
		btnCompletada.addActionListener(this);
		btnOpcTS.addActionListener(this);
		btnDelete.addActionListener(this);

	}

	public void marcarComoCompletada() {

		this.tscompletada = 1;
		btnCompletada.setIcon(completado);
	}

	public void desmarcar() {

		this.tscompletada = 0;
		btnCompletada.setIcon(nocompletado);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCompletada) {

			if (tscompletada == 1) {
				desmarcar();

			} else if (tscompletada == 0) {
				marcarComoCompletada();
			}
		}

		if (event.getSource() == btnOpcTS) {

			if (opcDesplegadas) {
				btnEdit.setVisible(false);
				btnDelete.setVisible(false);
				opcDesplegadas = false;
			} else {
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				opcDesplegadas = true;
			}

		}
		if (event.getSource() == btnDelete) {

			Pantalla.eliminarTS(idTS);
		}

	}

	public void actulizarIdTS(int idTS) {
		this.idTS = idTS;

	}

	public void actualizarY(int posY) {
		this.setLocation(30, posY);
	}

}
