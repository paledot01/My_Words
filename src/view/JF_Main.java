package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import model.Word;
import service.WordService;
import serviceImpl.WordServiceImpl;
import utils.Constans;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class JF_Main extends JFrame implements MouseListener, ActionListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnl_superior;
	private JPanel pnl_inferior;
	private JPanel pnl_strip;
	private JPanel pnl_minimizar;
	private JPanel pnl_close;
	private JLabel lbl_01;
	private JLabel lbl_02;
	private JLabel lbl_03;
	private JLabel lbl_app_nombre;
	private JLabel lbl_total_words;
	private Pnl_Hoja pnl_hoja;
	private JButton btn_grupo01;
	private JButton btn_grupo02;
	private JButton btn_grupo03;
	private JButton btn_grupo04;
	private JButton btn_grupo05;
	private JButton btn_export;

	// variables
	private WordService servicio = new WordServiceImpl();
	private int xMouse, yMouse; // PASO 1: EVENTO 'ARRASTRAR' DE LA BARRA - Creacion de la variable
	
	// variables estaticas.
	//static public List<Word> lista_words = new ArrayList<Word>(); // lista grupo 0, su valor se obtiene en el metodo readFile(), del servicio.
	static public List<Word> lista_words_grupo_01 = new ArrayList<Word>();
	static public List<Word> lista_words_grupo_02 = new ArrayList<Word>();
	static public List<Word> lista_words_grupo_03 = new ArrayList<Word>();
	static public List<Word> lista_words_grupo_04 = new ArrayList<Word>();
	static public List<Word> lista_words_grupo_05 = new ArrayList<Word>();
	static public List<String> lista_important = new ArrayList<String>();
	static public int cantidad_palabras = 0; // Requiere verificacion.
	static public int cantidad_paginas = 1;
	static public int pagina_actual = 1;
	
	static private JPanel pnl_principal;
	
	private int grupoActual = 0; // para saber que grupo es el que se esta mostrando en la pantalla principal.


	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_Main frame = new JF_Main();
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // --> CAMBIA EL LOOK AND FEEL ( DISENIO )
					SwingUtilities.updateComponentTreeUI(frame); // <<<
					//frame.setShape(new RoundRectangle2D.Double(xRound, yRound, 400, 600, 50, 50));
					//frame.setSize(400, 600);
					frame.setVisible(true);
					/** CENTRAR LA VENTANA **/
					frame.setLocationRelativeTo(null); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JF_Main() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 562); // 660 x 600
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new LineBorder(Constans.GRIS_80));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnl_superior = new JPanel();
		pnl_superior.setBounds(1, 1, 740, 30);
//		pnl_superior.setBorder(new LineBorder(Color.cyan));
		pnl_superior.setBackground(Color.BLACK);
		pnl_superior.addMouseMotionListener(this);
		pnl_superior.addMouseListener(this);
		pnl_superior.setLayout(null);
		contentPane.add(pnl_superior);
		
		pnl_strip= new JPanel();
		pnl_strip.setBounds(1, 31, 740, 30);
		pnl_strip.setBackground(Constans.HOJA_CREMA);
		contentPane.add(pnl_strip);
		pnl_strip.setLayout(null);
		
		btn_grupo01 = new JButton("");
		btn_grupo01.setIcon(new ImageIcon(JF_Main.class.getResource("/img/number_1.png")));
		btn_grupo01.addActionListener(this);
		btn_grupo01.setFocusable(false);
		btn_grupo01.setBounds(1, 1, 28, 28);
		pnl_strip.add(btn_grupo01);
		
		btn_grupo02 = new JButton("");
		btn_grupo02.setIcon(new ImageIcon(JF_Main.class.getResource("/img/number_2.png")));
		btn_grupo02.addActionListener(this);
		btn_grupo02.setFocusable(false);
		btn_grupo02.setBounds(29, 1, 28, 28);
		pnl_strip.add(btn_grupo02);
		
		btn_grupo03 = new JButton("");
		btn_grupo03.setIcon(new ImageIcon(JF_Main.class.getResource("/img/number_3.png")));
		btn_grupo03.addActionListener(this);
		btn_grupo03.setFocusable(false);
		btn_grupo03.setBounds(57, 1, 28, 28);
		pnl_strip.add(btn_grupo03);
		
		btn_grupo04 = new JButton("");
		btn_grupo04.setIcon(new ImageIcon(JF_Main.class.getResource("/img/number_4.png")));
		btn_grupo04.addActionListener(this);
		btn_grupo04.setFocusable(false);
		btn_grupo04.setBounds(85, 1, 28, 28);
		pnl_strip.add(btn_grupo04);
		
		btn_grupo05 = new JButton("");
		btn_grupo05.setIcon(new ImageIcon(JF_Main.class.getResource("/img/number_5.png")));
		btn_grupo05.addActionListener(this);
		btn_grupo05.setFocusable(false);
		btn_grupo05.setBounds(113, 1, 28, 28);
		pnl_strip.add(btn_grupo05);
		
		btn_export = new JButton("");
		btn_export.addActionListener(this);
		btn_export.setFocusable(false);
		btn_export.setBounds(712, 1, 28, 28);
		pnl_strip.add(btn_export);
		
		pnl_inferior= new JPanel();
		pnl_inferior.setBounds(1, 531, 740, 30);
		pnl_inferior.setBackground(Constans.HOJA_CREMA);
		pnl_inferior.setLayout(null);
		contentPane.add(pnl_inferior);
		
		lbl_total_words = new JLabel(""); // <<<<<<<<<<<<<<<<<<
		lbl_total_words.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_total_words.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_total_words.setBounds(600, 0, 120, 30);
		pnl_inferior.add(lbl_total_words);
		lbl_total_words.setForeground(Color.BLACK);
		
		pnl_close = new JPanel();
		pnl_close.setBounds(710, 0, 30, 30);
		pnl_close.addMouseListener(this);
		pnl_close.setBackground(Color.BLACK);
		pnl_close.setLayout(null);
		pnl_superior.add(pnl_close);
		
		lbl_01 = new JLabel("");
		lbl_01.setBounds(10, 10, 10, 10);
		lbl_01.setIcon(new ImageIcon(JF_Main.class.getResource("/img/close.png")));
		pnl_close.add(lbl_01);
		
		pnl_minimizar = new JPanel();
		pnl_minimizar.setBounds(680, 0, 30, 30);
		pnl_minimizar.addMouseListener(this);
		pnl_minimizar.setBackground(Color.BLACK);
		pnl_minimizar.setLayout(null);
		pnl_superior.add(pnl_minimizar);
		
		lbl_02 = new JLabel("");
		lbl_02.setBounds(10, 10, 10, 10);
		lbl_02.setIcon(new ImageIcon(JF_Main.class.getResource("/img/minimizar.png")));
		pnl_minimizar.add(lbl_02);
		
		lbl_03 = new JLabel("");
		lbl_03.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_03.setBounds(0, 0, 30, 30);
		lbl_03.setIcon(new ImageIcon(JF_Main.class.getResource("/img/logo_white_20.png")));
		pnl_superior.add(lbl_03);
		
		lbl_app_nombre = new JLabel("My Words");
		lbl_app_nombre.setForeground(new Color(192, 192, 192));
		lbl_app_nombre.setBounds(35, 0, 100, 30);
		pnl_superior.add(lbl_app_nombre);
		
		pnl_principal = new JPanel();
		pnl_principal.setBounds(1, 61, 740, 470);
		contentPane.add(pnl_principal);
		
		

		// ACCIONES INICIALES
		servicio.readFile(); // obtenemos la lista de palabras
		getCantidadPalabras(lista_words_grupo_01);
		getCantidadPaginas(lista_words_grupo_01);
		setTotalPalabras();
		
		pnl_hoja = new Pnl_Hoja();
		MostrarEnPanelPrincipal(pnl_hoja);

		
		System.out.println(">>> JFRAME MAIN [END] - EJECUCION DEL CONSTRUCTOR");
		
	} // =====> Fin del Constructor

	
	

	void mensajeError(String mensaje){
		JOptionPane.showMessageDialog(contentPane, mensaje, "Error", 0);
	}
	void mensajeExito(String mensaje){
		JOptionPane.showMessageDialog(contentPane, mensaje, "Sistema", 1);
	}
		
	void getCantidadPalabras(List<Word> list) {
		cantidad_palabras = list.size();
	}
	
	int getCantidadPalabrasTotales() {
		int total = 0;
		total = lista_words_grupo_01.size() + lista_words_grupo_02.size() + lista_words_grupo_03.size() + lista_words_grupo_04.size() + lista_words_grupo_05.size();
		return total;
	}
	
	void getCantidadPaginas(List<Word> list) { // NO PUEDE SER 0
		cantidad_paginas = (int) Math.ceil(cantidad_palabras/77.0);
		if(cantidad_paginas == 0) cantidad_paginas = 1;
	}
	
	void setTotalPalabras(){
//		String total = Integer.toString(cantidad_palabras);
		lbl_total_words.setText("Total: " + getCantidadPalabrasTotales() + " words");
	}
	
	// Mostrar en el panel "p" dentro del panel principal
	static void MostrarEnPanelPrincipal(JPanel p){

		p.setSize(740, 470);
		p.setLocation(0, 0);
		pnl_principal.removeAll();
		pnl_principal.setLayout(null);
		pnl_principal.add(p);
//		pnl_principal.revalidate();
//		pnl_principal.repaint();
	}
	

	// ===========================================
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == pnl_close) {
			pnl_close.setBackground(Color.RED);
		}
		if (e.getSource() == pnl_minimizar) {
			pnl_minimizar.setBackground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == pnl_close) {
			pnl_close.setBackground(Color.BLACK);
		}
		if (e.getSource() == pnl_minimizar) {
			pnl_minimizar.setBackground(Color.BLACK);
		}
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == pnl_close) {
			System.exit(0);
		}
		if (e.getSource() == pnl_minimizar) {
			this.setExtendedState(ICONIFIED);
		}
		if (e.getSource() == pnl_superior) { // PASO 2: EVENTO 'ARRASTRAR' DE LA BARRA - EVENTO PRESIONAR
			xMouse = e.getX();  
			yMouse = e.getY();
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	// ============================================
	public void mouseDragged(MouseEvent e) { // PASO 3: EVENTO 'ARRASTRAR' DE LA BARRA - EVENTO ARRASTRAR
		if (e.getSource() == pnl_superior) {
			int x = e.getXOnScreen();  
			int y = e.getYOnScreen();
			this.setLocation(x-xMouse, y-yMouse);	
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	// ============================================
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_grupo01 && grupoActual != 1) {
			getCantidadPalabras(lista_words_grupo_01);
			getCantidadPaginas(lista_words_grupo_01);
			pagina_actual = 1;
			Pnl_Hoja.lbl_pagination.setText(JF_Main.pagina_actual + "/" + JF_Main.cantidad_paginas);
			Pnl_Hoja.lista = lista_words_grupo_01;
			Pnl_Hoja.lbl_grupo.setText("GRUPO I");
			grupoActual = 1;
		}
		if (e.getSource() == btn_grupo02 && grupoActual != 2) {
			getCantidadPalabras(lista_words_grupo_02);
			getCantidadPaginas(lista_words_grupo_02);
			pagina_actual = 1;
			Pnl_Hoja.lbl_pagination.setText(JF_Main.pagina_actual + "/" + JF_Main.cantidad_paginas);
			Pnl_Hoja.lista = lista_words_grupo_02;
			Pnl_Hoja.lbl_grupo.setText("GRUPO II");
			grupoActual = 2;
		}
		if (e.getSource() == btn_grupo03 && grupoActual != 3) {
			getCantidadPalabras(lista_words_grupo_03);
			getCantidadPaginas(lista_words_grupo_03);
			pagina_actual = 1;
			Pnl_Hoja.lbl_pagination.setText(JF_Main.pagina_actual + "/" + JF_Main.cantidad_paginas);
			Pnl_Hoja.lista = lista_words_grupo_03;
			Pnl_Hoja.lbl_grupo.setText("GRUPO III");
			grupoActual = 3;
		}
		if (e.getSource() == btn_grupo04 && grupoActual != 4) {
			getCantidadPalabras(lista_words_grupo_04);
			getCantidadPaginas(lista_words_grupo_04);
			pagina_actual = 1;
			Pnl_Hoja.lbl_pagination.setText(JF_Main.pagina_actual + "/" + JF_Main.cantidad_paginas);
			Pnl_Hoja.lista = lista_words_grupo_04;
			Pnl_Hoja.lbl_grupo.setText("GRUPO IV");
			grupoActual = 4;
		}
		if (e.getSource() == btn_grupo05 && grupoActual != 5) {
			getCantidadPalabras(lista_words_grupo_05);
			getCantidadPaginas(lista_words_grupo_05);
			pagina_actual = 1;
			Pnl_Hoja.lbl_pagination.setText(JF_Main.pagina_actual + "/" + JF_Main.cantidad_paginas);
			Pnl_Hoja.lista = lista_words_grupo_05;
			Pnl_Hoja.lbl_grupo.setText("GRUPO V");
			grupoActual = 5;
		}
		if (e.getSource() == btn_export) {
			servicio.export();
		}
	}
}
