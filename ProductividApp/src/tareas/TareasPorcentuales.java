package tareas;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TareasPorcentuales extends JLabel {

	private static final long serialVersionUID = 1L;
	JLabel tituloTP;

	TareasPorcentuales(String titulo, int posY, ArrayList<TareaSimple> alTareasSimplesTP,
			ArrayList<Integer> porcentajes) {

		int tamY;
		tamY = alTareasSimplesTP.size() * 50 + 50;
		this.setBounds(30, posY, 350, tamY);

		tituloTP = new JLabel(titulo, SwingConstants.LEFT);

		this.setVisible(true);

	}

}
