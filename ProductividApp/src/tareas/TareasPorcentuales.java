package tareas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class TareasPorcentuales extends JLabel implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel tituloTP;
	TareaSimple ts;
	JProgressBar pb;
	ArrayList<TareaSimple> alTSP;
	JButton btnRecompensa;
	boolean reclamada = false;
	Icon iRec = new ImageIcon("recursos/botones/recompensa.png");
	Icon iReclamada = new ImageIcon("recursos/botones/reclamada.png");

	public TareasPorcentuales(String titulo, ArrayList<String> alTareasSimplesTP) {

		int tamY;
		tamY = alTareasSimplesTP.size() * 50 + 90;
		this.setBounds(0, 0, 350, tamY);
		this.setLayout(null);
		alTSP = new ArrayList<TareaSimple>();

		btnRecompensa = new JButton();
		btnRecompensa.setBounds(30, 0, 30, 30);
		btnRecompensa.setIcon(iRec);
		btnRecompensa.setOpaque(false);
		btnRecompensa.setContentAreaFilled(false);
		btnRecompensa.setFocusPainted(false);
		btnRecompensa.setBorder(null);
		btnRecompensa.setVisible(false);

		tituloTP = new JLabel(titulo, SwingConstants.LEFT);
		tituloTP.setBounds(70, 0, 200, 50);
		tituloTP.setVisible(true);

		pb = new JProgressBar(0, 100);
		pb.setBounds(30, 40, 300, 30);
		pb.setValue(0);
		pb.setStringPainted(true);
		pb.setVisible(true);

		for (int i = 0; i < alTareasSimplesTP.size(); i++) {

			ts = new TareaSimple(50 * i + 90, alTareasSimplesTP.get(i), i);
			alTSP.add(ts);
			ts.btnCompletada.addActionListener(this);

			this.add(ts);
		}

		btnRecompensa.addActionListener(this);
		this.add(tituloTP);
		this.add(pb);
		this.add(btnRecompensa);

		this.setVisible(true);
	}

	public void actualizarPorcentajes() {
		Thread locomoroco = new Thread() {
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int valorPorTarea = 100 / alTSP.size();
				// System.out.print(valorPorTarea);
				int valorTotal = 0;
				for (int i = 0; i < alTSP.size(); i++) {

					if (alTSP.get(i).tscompletada == 1) {

						valorTotal = valorPorTarea + valorTotal;
						// System.out.print(valorTotal);

					}
				}
				pb.setValue(valorTotal);
				if (valorTotal > 95) {
					pb.setValue(100);
				}

				pb.repaint();
			}
		};
		locomoroco.start();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (alTSP.size() > 0) {
			actualizarPorcentajes();
		}
		if (event.getSource() == btnRecompensa) {

			if (reclamada) {

			} else if (!reclamada) {
				btnRecompensa.setIcon(iReclamada);
			}
		}

		Thread crazy = new Thread() {
			public void run() {

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				actualizarPorcentajes();
				if (pb.getValue() == 100) {
					btnRecompensa.setVisible(true);
				} else {
					btnRecompensa.setVisible(false);
				}
			}
		};
		crazy.start();

	}

}
