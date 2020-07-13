package pricipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import tareas.PanelAddTarea;
import tareas.TareaSimple;
import tareas.TareasPorcentuales;

public class Pantalla extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JScrollPane scrollMenuTareas;

	JPanel menus;
	JButton btnMenuTiempo, btnMenuTareas, btnMenuYo, btnMenuMetas, btnMenuHabitos, btnMenuJuego;
	JPanel menuTiempo;
	public static JLabel lbPuntuacion;
	static JPanel menuTareas;
	JPanel menuYo;
	JPanel menuMetas;
	JScrollPane sMetas, sMetasRealjaja;
	JPanel menuHabitos;
	JPanel menuJuego;
	public static int puntuacion = 0;
	JLabel lbTituloTareas, lbHoy, lbCantidadSubtareas, lbTituloMetas;
	JLabel lbTituloDeLaTarea, lbSubtareasTitle;
	JLabel lbTituloDeLaMeta, lbCantidadSubMetas;
	JTextField tfTituloDeLaTarea, tfCantidadSubtareas;
	JTextField tfTituloDeLaMeta, tfCantadidSubMetas;
	String strTituloDeLaTarea, strTituloDeLaMeta;
	JButton btnAddTarea, btnCancelAddTarea, btnAddCrearTarea, btnRefreshNumT;
	JButton btnAddMeta, btnCancelAddMeta, btnAddCrearMeta, btnRefreshNumM;
	PanelAddTarea panelAddTarea;
	JPanel panelAddMeta;
	TareaSimple ts1, tsTemp;
	TareasPorcentuales tp1, tpTemp;
	static int totalTareasSimples = 0;
	static ArrayList<TareaSimple> alTareasSimples;
	static ArrayList<TareasPorcentuales> alTareasPorcentuales, alMetas;
	ArrayList<String> alNombresTP, alNombresSubMetas;
	int cualTipo;
	int cuantasSubtareas, cuantasSubMetas;

	ArrayList<JTextField> alSubtareasRellenar, alSubMetasRellenar;

	JFormattedTextField ftfCantidadSubtareas = new JFormattedTextField(new Integer(2));

	JFormattedTextField ftfCantidadSubMetas = new JFormattedTextField(new Integer(2));

	Color colorFondoAzul = new Color(141, 200, 255);
	Color colorFondoMorado = new Color(177, 141, 255);
	Color colorFondoMoradoF = new Color(133, 106, 192);
	Color colorFondoVerde = new Color(153, 255, 141);
	Color colorFondoAmarillo = new Color(250, 255, 141);
	Color colorFondoRojo = new Color(255, 141, 141);
	Color colorFondoRojoF = new Color(210, 141, 141);
	Color colorFondoAzulF = new Color(141, 148, 255);

	Font fuente = new Font("Windows", 1, 30);
	Font fuenteMediana = new Font("Calibri", 1, 20);

	JComboBox<String> elegirTipoTarea;

	Icon iconMenuTiempoOff = new ImageIcon("recursos/botones/reloj_blanco.png");
	Icon iconMenuTiempoOn = new ImageIcon("recursos/botones/reloj_negro.png");

	Icon iconMenuTareasOff = new ImageIcon("recursos/botones/tareas_blanco.png");
	Icon iconMenuTareasOn = new ImageIcon("recursos/botones/tareas_negro.png");

	Icon iconPlus = new ImageIcon("recursos/botones/plus.png");

	Icon iconUsuarioOff = new ImageIcon("recursos/botones/Usuario_blanco.png");
	Icon iconUsuarioOn = new ImageIcon("recursos/botones/Usuario.png");

	public Pantalla() {

		this.setPreferredSize(new Dimension(426, 700));
		this.setTitle("Glow Up");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLACK);

		alTareasSimples = new ArrayList<TareaSimple>();
		alTareasPorcentuales = new ArrayList<TareasPorcentuales>();
		alMetas = new ArrayList<TareasPorcentuales>();
		alSubtareasRellenar = new ArrayList<JTextField>();
		alSubMetasRellenar = new ArrayList<JTextField>();

		alNombresTP = new ArrayList<String>();
		alNombresSubMetas = new ArrayList<String>();
		menuTiempo = new JPanel();
		menuTiempo.setBounds(0, 0, 426, 610);
		menuTiempo.setBackground(colorFondoAzul);
		menuTiempo.setVisible(false);

		menuTareas = new JPanel();
		sMetas = new JScrollPane();
		sMetas.setBounds(0, 0, 420, 610);
		sMetas.setViewportView(menuTareas);
		menuTareas.setLayout(null);
		menuTareas.setPreferredSize(new Dimension(426, 2000));

		// menuTareas.setBounds(0, 0, 426, 610);
		menuTareas.setBackground(colorFondoMorado);
		sMetas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sMetas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sMetas.setVisible(false);

		// menuTareas.setVisible(false);
		menuYo = new JPanel();

		menuYo.setBounds(0, 0, 426, 610);
		menuYo.setBackground(colorFondoVerde);
		menuYo.setVisible(true);
		menuYo.setLayout(null);

		menuJuego = new JPanel();
		menuJuego.setBounds(0, 0, 426, 610);
		menuJuego.setBackground(colorFondoAmarillo);
		menuJuego.setVisible(false);

		menuMetas = new JPanel();
		sMetasRealjaja = new JScrollPane();
		sMetasRealjaja.setBounds(0, 0, 420, 610);
		sMetasRealjaja.setViewportView(menuMetas);
		menuMetas.setLayout(null);
		menuMetas.setPreferredSize(new Dimension(426, 2000));
		menuMetas.setBackground(colorFondoRojo);
		sMetasRealjaja.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sMetasRealjaja.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sMetasRealjaja.setVisible(false);

		menuHabitos = new JPanel();
		menuHabitos.setBounds(0, 0, 426, 610);
		menuHabitos.setBackground(colorFondoAzulF);
		menuHabitos.setVisible(false);

		menus = new JPanel();
		menus.setBounds(0, 610, 430, 60);
		menus.setBackground(Color.black);
		menus.setLayout(null);
		menus.setVisible(true);

		btnMenuTiempo = new JButton();
		btnMenuTiempo.setBounds(0, 0, 70, 60);
		btnMenuTiempo.setIcon(iconMenuTiempoOff);
		btnMenuTiempo.setFocusPainted(false);
		btnMenuTiempo.setBackground(Color.BLACK);
		btnMenuTiempo.setBorder(null);
		btnMenuTiempo.setVisible(true);

		btnMenuTareas = new JButton();
		btnMenuTareas.setBounds(70, 0, 70, 60);
		btnMenuTareas.setIcon(iconMenuTareasOff);
		btnMenuTareas.setFocusPainted(false);
		btnMenuTareas.setBackground(Color.BLACK);
		btnMenuTareas.setBorder(null);
		btnMenuTareas.setVisible(true);

		btnMenuYo = new JButton();
		btnMenuYo.setBounds(140, 0, 70, 60);
		btnMenuYo.setIcon(iconUsuarioOn);
		btnMenuYo.setFocusPainted(false);
		btnMenuYo.setBackground(colorFondoVerde);
		btnMenuYo.setBorder(null);
		btnMenuYo.setVisible(true);

		btnMenuJuego = new JButton();
		btnMenuJuego.setBounds(210, 0, 70, 60);
		btnMenuJuego.setIcon(iconMenuTareasOff);
		btnMenuJuego.setFocusPainted(false);
		btnMenuJuego.setBackground(Color.BLACK);
		btnMenuJuego.setBorder(null);
		btnMenuJuego.setVisible(true);

		btnMenuMetas = new JButton();
		btnMenuMetas.setBounds(280, 0, 70, 60);
		btnMenuMetas.setIcon(iconMenuTareasOff);
		btnMenuMetas.setFocusPainted(false);
		btnMenuMetas.setBackground(Color.BLACK);
		btnMenuMetas.setBorder(null);
		btnMenuMetas.setVisible(true);

		btnMenuHabitos = new JButton();
		btnMenuHabitos.setBounds(350, 0, 70, 60);
		btnMenuHabitos.setIcon(iconMenuTareasOff);
		btnMenuHabitos.setFocusPainted(false);
		btnMenuHabitos.setBackground(Color.BLACK);
		btnMenuHabitos.setBorder(null);
		btnMenuHabitos.setVisible(true);

		btnMenuTiempo.addActionListener(this);
		btnMenuTareas.addActionListener(this);
		btnMenuYo.addActionListener(this);
		btnMenuJuego.addActionListener(this);
		btnMenuMetas.addActionListener(this);
		btnMenuHabitos.addActionListener(this);

		menus.add(btnMenuTiempo);
		menus.add(btnMenuTareas);
		menus.add(btnMenuYo);
		menus.add(btnMenuJuego);
		menus.add(btnMenuMetas);
		menus.add(btnMenuHabitos);

		cargarPanelTareas();
		cargarPanelMetas();
		cargarPanelYo();

		btnAddTarea.addActionListener(this);
		btnCancelAddTarea.addActionListener(this);
		btnAddCrearTarea.addActionListener(this);
		btnRefreshNumT.addActionListener(this);
		btnRefreshNumM.addActionListener(this);
		btnAddMeta.addActionListener(this);
		btnCancelAddMeta.addActionListener(this);
		btnAddCrearMeta.addActionListener(this);

		this.add(menus);
		this.add(menuTiempo);
		// this.add(menuTareas);
		this.add(menuYo);
		this.add(menuJuego);
		// this.add(menuMetas);
		this.add(menuHabitos);
		this.getContentPane().add(sMetas);
		this.getContentPane().add(sMetasRealjaja);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnMenuTiempo) {
			apagarBotones();
			ocultarPaneles();
			btnMenuTiempo.setBackground(colorFondoAzul);
			btnMenuTiempo.setIcon(iconMenuTiempoOn);
			menuTiempo.setVisible(true);
		}
		if (event.getSource() == btnMenuTareas) {
			actualizarTareasSimples();
			apagarBotones();
			ocultarPaneles();
			btnMenuTareas.setBackground(colorFondoMorado);
			btnMenuTareas.setIcon(iconMenuTareasOn);
			menuTareas.setVisible(true);
			sMetas.setVisible(true);
		}

		if (event.getSource() == btnMenuYo) {

			apagarBotones();
			ocultarPaneles();
			btnMenuYo.setBackground(colorFondoVerde);
			btnMenuYo.setIcon(iconUsuarioOn);
			menuYo.setVisible(true);
		}

		if (event.getSource() == btnMenuJuego) {

			apagarBotones();
			ocultarPaneles();
			btnMenuJuego.setBackground(colorFondoAmarillo);
			btnMenuJuego.setIcon(iconMenuTareasOn);
			menuJuego.setVisible(true);
		}

		if (event.getSource() == btnMenuMetas) {

			apagarBotones();
			ocultarPaneles();
			btnMenuMetas.setBackground(colorFondoRojo);
			btnMenuMetas.setIcon(iconMenuTareasOn);
			menuMetas.setVisible(true);
			sMetasRealjaja.setVisible(true);
		}
		if (event.getSource() == btnMenuHabitos) {

			apagarBotones();
			ocultarPaneles();
			btnMenuHabitos.setBackground(colorFondoAzulF);
			btnMenuHabitos.setIcon(iconMenuTareasOn);
			menuHabitos.setVisible(true);
		}
		if (event.getSource() == btnAddTarea) {
			panelAddTarea.setVisible(true);
		}
		if (event.getSource() == btnCancelAddTarea) {
			panelAddTarea.setVisible(false);
		}

		if (event.getSource() == btnAddCrearTarea) {

			if (elegirTipoTarea.getSelectedIndex() == 0) {

				totalTareasSimples = alTareasSimples.size();

				strTituloDeLaTarea = tfTituloDeLaTarea.getText();
				tsTemp = new TareaSimple(totalTareasSimples * 50 + 120, strTituloDeLaTarea, totalTareasSimples);
				alTareasSimples.add(tsTemp);
				totalTareasSimples = alTareasSimples.size();
				tfTituloDeLaTarea.setText(null);

			} else if (elegirTipoTarea.getSelectedIndex() == 1) {
				int posYtp = 0;
				int totalSubtareas = alSubtareasRellenar.size();
				String nombreTmp;
				for (int i = 0; i < totalSubtareas; i++) {
					nombreTmp = alSubtareasRellenar.get(i).getText();
					alNombresTP.add(nombreTmp);
				}

				strTituloDeLaTarea = tfTituloDeLaTarea.getText();
				tpTemp = new TareasPorcentuales(strTituloDeLaTarea, alNombresTP);
				alTareasPorcentuales.add(tpTemp);

			}
			alNombresTP.clear();
			actualizarTareasSimples();
			this.repaint();
			panelAddTarea.setVisible(false);
		}

		if (event.getSource() == btnRefreshNumT) {

			int diferencia;
			diferencia = (int) ftfCantidadSubtareas.getValue() - cuantasSubtareas;

			if ((int) ftfCantidadSubtareas.getValue() > cuantasSubtareas) {
				for (int i = 0; i < diferencia; i++) {
					JTextField lbSub = new JTextField();
					lbSub.setBounds(30, (i + cuantasSubtareas) * 30 + 200, 200, 30);
					lbSub.setVisible(true);
					alSubtareasRellenar.add(lbSub);
					panelAddTarea.add(lbSub);

				}
			} else {
				for (int i = 0; i < Math.abs(diferencia); i++) {

					System.out.println(i);
					panelAddTarea.remove(alSubtareasRellenar.get(alSubtareasRellenar.size() - 1));
					alSubtareasRellenar.remove(alSubtareasRellenar.size() - 1);

				}

			}
			cuantasSubtareas = (int) ftfCantidadSubtareas.getValue();
			panelAddTarea.repaint();
		}
		if (event.getSource() == btnRefreshNumM) {

			int diferencia;
			diferencia = (int) ftfCantidadSubMetas.getValue() - cuantasSubMetas;
			System.out.println(diferencia);

			if ((int) ftfCantidadSubMetas.getValue() > cuantasSubMetas) {
				for (int i = 0; i < diferencia; i++) {
					JTextField lbSub = new JTextField();
					lbSub.setBounds(30, (i + cuantasSubMetas) * 30 + 150, 200, 30);
					lbSub.setVisible(true);
					alSubMetasRellenar.add(lbSub);
					panelAddMeta.add(lbSub);

				}
			} else {
				for (int i = 0; i < Math.abs(diferencia); i++) {

					System.out.println(i);
					panelAddMeta.remove(alSubMetasRellenar.get(alSubMetasRellenar.size() - 1));
					alSubMetasRellenar.remove(alSubMetasRellenar.size() - 1);

				}

			}
			cuantasSubMetas = (int) ftfCantidadSubMetas.getValue();

			panelAddMeta.repaint();
		}

		if (event.getSource() == btnAddMeta) {
			panelAddMeta.setVisible(true);
			cuantasSubMetas = (int) ftfCantidadSubMetas.getValue();

			for (int i = 0; i < cuantasSubMetas; i++) {

				JTextField lbSub = new JTextField();
				lbSub.setBounds(30, i * 30 + 150, 200, 30);
				lbSub.setVisible(true);
				alSubMetasRellenar.add(lbSub);
				panelAddMeta.add(lbSub);
			}

			panelAddMeta.repaint();

		}

		if (event.getSource() == btnCancelAddMeta) {
			panelAddMeta.setVisible(false);

		}
		if (event.getSource() == btnAddCrearMeta) {

			int totalSubMetas = alSubMetasRellenar.size();
			String nombreTmp;
			for (int i = 0; i < totalSubMetas; i++) {
				nombreTmp = alSubMetasRellenar.get(i).getText();
				alNombresSubMetas.add(nombreTmp);
			}

			strTituloDeLaMeta = tfTituloDeLaMeta.getText();
			tpTemp = new TareasPorcentuales(strTituloDeLaMeta, alNombresSubMetas);
			alMetas.add(tpTemp);

			alNombresSubMetas.clear();
			actualizarMetas();
			this.repaint();
			panelAddMeta.setVisible(false);
			for (int i = 0; i < alSubMetasRellenar.size(); i++) {
				panelAddMeta.remove(alSubMetasRellenar.get(i));

			}
			alSubMetasRellenar.clear();
		}

	}

	public void apagarBotones() {
		btnMenuTiempo.setBackground(Color.BLACK);
		btnMenuTiempo.setIcon(iconMenuTiempoOff);

		btnMenuTareas.setBackground(Color.BLACK);
		btnMenuTareas.setIcon(iconMenuTareasOff);

		btnMenuYo.setBackground(Color.BLACK);
		btnMenuYo.setIcon(iconUsuarioOff);

		btnMenuJuego.setBackground(Color.BLACK);
		btnMenuJuego.setIcon(iconMenuTareasOff);

		btnMenuMetas.setBackground(Color.BLACK);
		btnMenuMetas.setIcon(iconMenuTareasOff);

		btnMenuHabitos.setBackground(Color.BLACK);
		btnMenuHabitos.setIcon(iconMenuTareasOff);
	}

	public void ocultarPaneles() {
		menuTiempo.setVisible(false);
		menuTareas.setVisible(false);
		menuYo.setVisible(false);
		menuJuego.setVisible(false);
		menuMetas.setVisible(false);
		menuHabitos.setVisible(false);
		sMetas.setVisible(false);
		sMetasRealjaja.setVisible(false);

	}

	public void cargarPanelTareas() {

		lbTituloTareas = new JLabel("Tareas", SwingConstants.CENTER);
		lbTituloTareas.setBounds(0, 0, 420, 70);
		lbTituloTareas.setVisible(true);
		lbTituloTareas.setBackground(colorFondoMoradoF);
		lbTituloTareas.setOpaque(true);
		lbTituloTareas.setFont(fuente);

		String tiposTareas[] = { "Tarea simple", "Tarea porcentual" };

		elegirTipoTarea = new JComboBox<String>(tiposTareas);
		elegirTipoTarea.setBounds(20, 20, 200, 40);

		lbHoy = new JLabel("Hoy", SwingConstants.CENTER);
		lbHoy.setBounds(70, 80, 240, 30);
		lbHoy.setVisible(true);
		lbHoy.setFont(fuenteMediana);

		btnAddTarea = new JButton();
		btnAddTarea.setBounds(110, 20, 30, 30);
		btnAddTarea.setContentAreaFilled(false);
		btnAddTarea.setFocusPainted(false);
		btnAddTarea.setBorder(null);
		btnAddTarea.setOpaque(false);
		btnAddTarea.setIcon(iconPlus);
		btnAddTarea.setVisible(true);

		// tp1 = new TareasPorcentuales("Matenme",120,alTareasSimples,porcentajes);

		// ts1 = new TareaSimple(120, "Primera tarea");

		btnCancelAddTarea = new JButton("Cancelar");
		btnCancelAddTarea.setBounds(20, 460, 100, 30);
		btnCancelAddTarea.setVisible(true);

		btnAddCrearTarea = new JButton("Crear");
		btnAddCrearTarea.setBounds(220, 460, 100, 30);
		btnAddCrearTarea.setVisible(true);

		lbTituloDeLaTarea = new JLabel("Titulo:", SwingConstants.LEFT);
		lbTituloDeLaTarea.setBounds(20, 70, 100, 30);
		lbTituloDeLaTarea.setVisible(true);

		tfTituloDeLaTarea = new JTextField();
		tfTituloDeLaTarea.setBounds(130, 70, 200, 30);
		tfTituloDeLaTarea.setVisible(true);

		lbCantidadSubtareas = new JLabel("Numero de subtareas: ", SwingConstants.LEFT);
		lbCantidadSubtareas.setBounds(20, 120, 150, 30);
		lbCantidadSubtareas.setVisible(false);

		// ftfCantidadSubtareas = new JTextField();
		ftfCantidadSubtareas.setBounds(190, 120, 50, 30);
		ftfCantidadSubtareas.setVisible(false);

		btnRefreshNumT = new JButton();
		btnRefreshNumT.setBounds(260, 120, 30, 30);
		btnRefreshNumT.setVisible(false);

		lbSubtareasTitle = new JLabel("Subtareas:", SwingConstants.LEFT);
		lbSubtareasTitle.setBounds(30, 170, 100, 30);
		lbSubtareasTitle.setVisible(false);

		panelAddTarea = new PanelAddTarea();
		panelAddTarea.add(btnCancelAddTarea);
		panelAddTarea.add(lbTituloDeLaTarea);
		panelAddTarea.add(tfTituloDeLaTarea);
		panelAddTarea.add(btnAddCrearTarea);
		panelAddTarea.add(elegirTipoTarea);
		panelAddTarea.add(lbCantidadSubtareas);
		panelAddTarea.add(ftfCantidadSubtareas);
		panelAddTarea.add(btnRefreshNumT);
		panelAddTarea.add(lbSubtareasTitle);

		actualizarTareasSimples();

		elegirTipoTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cualTipo = elegirTipoTarea.getSelectedIndex();
				switch (cualTipo) {
				case 0:
					lbCantidadSubtareas.setVisible(false);
					ftfCantidadSubtareas.setVisible(false);
					btnRefreshNumT.setVisible(false);
					lbSubtareasTitle.setVisible(false);

					int totalSubRellenar = alSubtareasRellenar.size();
					for (int i = 0; i < totalSubRellenar; i++) {
						panelAddTarea.remove(alSubtareasRellenar.get(i));
					}
					panelAddTarea.repaint();

					break;
				case 1:
					lbCantidadSubtareas.setVisible(true);
					ftfCantidadSubtareas.setVisible(true);
					lbSubtareasTitle.setVisible(true);
					cuantasSubtareas = (int) ftfCantidadSubtareas.getValue();

					for (int i = 0; i < cuantasSubtareas; i++) {

						JTextField lbSub = new JTextField();
						lbSub.setBounds(30, i * 30 + 200, 200, 30);
						lbSub.setVisible(true);
						alSubtareasRellenar.add(lbSub);
						panelAddTarea.add(lbSub);
					}

					panelAddTarea.repaint();

					btnRefreshNumT.setVisible(true);

					break;
				}
			}
		});

		menuTareas.add(panelAddTarea);
		menuTareas.add(btnAddTarea);
		menuTareas.add(lbTituloTareas);
		menuTareas.add(lbHoy);
		// menuTareas.add(ts1);

	}

	public void cargarPanelMetas() {

		lbTituloMetas = new JLabel("Metas", SwingConstants.CENTER);
		lbTituloMetas.setBounds(0, 0, 420, 70);
		lbTituloMetas.setVisible(true);
		lbTituloMetas.setBackground(colorFondoRojoF);
		lbTituloMetas.setOpaque(true);
		lbTituloMetas.setFont(fuente);

		btnAddMeta = new JButton();
		btnAddMeta.setBounds(110, 20, 30, 30);
		btnAddMeta.setContentAreaFilled(false);
		btnAddMeta.setFocusPainted(false);
		btnAddMeta.setBorder(null);
		btnAddMeta.setOpaque(false);
		btnAddMeta.setIcon(iconPlus);
		btnAddMeta.setVisible(true);

		panelAddMeta = new JPanel();
		panelAddMeta.setBounds(30, 90, 350, 500);
		panelAddMeta.setVisible(false);
		panelAddMeta.setLayout(null);

		btnCancelAddMeta = new JButton("Cancelar");
		btnCancelAddMeta.setBounds(20, 460, 100, 30);
		btnCancelAddMeta.setVisible(true);

		btnAddCrearMeta = new JButton("Crear");
		btnAddCrearMeta.setBounds(220, 460, 100, 30);
		btnAddCrearMeta.setVisible(true);

		lbTituloDeLaMeta = new JLabel("Titulo:", SwingConstants.LEFT);
		lbTituloDeLaMeta.setBounds(20, 30, 100, 30);
		lbTituloDeLaMeta.setVisible(true);

		tfTituloDeLaMeta = new JTextField();
		tfTituloDeLaMeta.setBounds(130, 30, 200, 30);
		tfTituloDeLaMeta.setVisible(true);

		lbCantidadSubMetas = new JLabel("Numero de submetas: ", SwingConstants.LEFT);
		lbCantidadSubMetas.setBounds(20, 70, 150, 30);
		lbCantidadSubMetas.setVisible(true);

		ftfCantidadSubMetas.setBounds(190, 70, 50, 30);
		ftfCantidadSubMetas.setVisible(true);

		btnRefreshNumM = new JButton();
		btnRefreshNumM.setBounds(260, 70, 30, 30);
		btnRefreshNumM.setVisible(true);

		panelAddMeta.add(btnAddCrearMeta);
		panelAddMeta.add(btnCancelAddMeta);
		panelAddMeta.add(lbTituloDeLaMeta);
		panelAddMeta.add(tfTituloDeLaMeta);
		panelAddMeta.add(lbCantidadSubMetas);
		panelAddMeta.add(ftfCantidadSubMetas);
		panelAddMeta.add(btnRefreshNumM);

		menuMetas.add(panelAddMeta);
		menuMetas.add(btnAddMeta);
		menuMetas.add(lbTituloMetas);

	}

	public static void actualizarTareasSimples() {
		// if (totalTareasSimples > 0) {
		totalTareasSimples = alTareasSimples.size();
		for (int i = 0; i < totalTareasSimples; i++) {
			menuTareas.add(alTareasSimples.get(i));
		}

		int tamTareasPorcentualesY = 0;

		for (int i = 0; i < alTareasPorcentuales.size(); i++) {
			if (i > 0) {
				tamTareasPorcentualesY = alTareasPorcentuales.get(i - 1).getHeight() + tamTareasPorcentualesY;
			}
			alTareasPorcentuales.get(i).setLocation(20, (totalTareasSimples * 50 + 120) + tamTareasPorcentualesY);
			menuTareas.add(alTareasPorcentuales.get(i));
		}

		// }
		// Pantalla.repaint();
	}

	public void actualizarMetas() {
		// if (totalTareasSimples > 0) {
		int totalMetas = alMetas.size();
		for (int i = 0; i < totalMetas; i++) {
			menuMetas.add(alMetas.get(i));
		}

		int tamTareasPorcentualesY = 0;

		for (int i = 0; i < alMetas.size(); i++) {
			if (i > 0) {
				tamTareasPorcentualesY = alMetas.get(i - 1).getHeight() + tamTareasPorcentualesY;
			}
			alMetas.get(i).setLocation(20, 70 + tamTareasPorcentualesY);
			menuMetas.add(alMetas.get(i));
		}

		// }
		// Pantalla.repaint();
	}

	public static void eliminarTS(int index) {
		totalTareasSimples = alTareasSimples.size();
		for (int i = 0; i < totalTareasSimples; i++) {
			menuTareas.remove(alTareasSimples.get(i));
		}
		alTareasSimples.remove(index);

		actualizarIdArreglo();
		actualizarTareasSimples();
		menuTareas.repaint();

	}

	public static void actualizarIdArreglo() {
		totalTareasSimples = alTareasSimples.size();
		for (int i = 0; i < totalTareasSimples; i++) {
			alTareasSimples.get(i).actulizarIdTS(i);
			alTareasSimples.get(i).actualizarY(i * 50 + 125);
		}
	}

	public void cargarPanelYo() {

		lbPuntuacion = new JLabel("Puntuacion: " + puntuacion, SwingConstants.CENTER);
		lbPuntuacion.setBounds(0, 0, 420, 50);
		lbPuntuacion.setFont(fuente);
		lbPuntuacion.setVisible(true);

		menuYo.add(lbPuntuacion);

	}

}
