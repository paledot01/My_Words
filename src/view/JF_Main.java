package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.Word;
import service.WordService;
import serviceImpl.WordServiceImpl;
import utils.Constans;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.List;

public class JF_Main extends JFrame implements MouseListener, ActionListener, MouseMotionListener {

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
	

	// variables 
	private WordService servicio = new WordServiceImpl();
	private int xMouse, yMouse; // PASO 1: EVENTO 'ARRASTRAR' DE LA BARRA - Creacion de la variable
	private DefaultTableModel modelo;
	static private double xRound = 50;
	static private double yRound = 50;
	static private JPanel pnl_principal;


	
	
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
		setBounds(100, 100, 402, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new LineBorder(Constans.GRIS_80));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnl_superior = new JPanel();
		pnl_superior.setBounds(1, 1, 400, 30);
//		pnl_superior.setBorder(new LineBorder(Color.cyan));
		pnl_superior.setBackground(Color.BLACK);
		pnl_superior.addMouseMotionListener(this);
		pnl_superior.addMouseListener(this);
		pnl_superior.setLayout(null);
		contentPane.add(pnl_superior);
		
		pnl_strip= new JPanel();
		pnl_strip.setBounds(1, 31, 400, 30);
		pnl_strip.setBackground(Constans.GRIS_200);
		pnl_strip.setLayout(null);
		contentPane.add(pnl_strip);
		
		pnl_inferior= new JPanel();
		pnl_inferior.setBounds(1, 571, 400, 30);
		pnl_inferior.setBackground(Constans.GRIS_200);
		pnl_inferior.setLayout(null);
		contentPane.add(pnl_inferior);
		
		lbl_total_words = new JLabel("TOTAL: 456");
		lbl_total_words.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_total_words.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_total_words.setBounds(288, 0, 100, 30);
		pnl_inferior.add(lbl_total_words);
		lbl_total_words.setForeground(Color.BLACK);
		
		pnl_close = new JPanel();
		pnl_close.setBounds(370, 0, 30, 30);
		pnl_close.addMouseListener(this);
		pnl_close.setBackground(Color.BLACK);
		pnl_close.setLayout(null);
		pnl_superior.add(pnl_close);
		
		lbl_01 = new JLabel("");
		lbl_01.setBounds(10, 10, 10, 10);
		lbl_01.setIcon(new ImageIcon(JF_Main.class.getResource("/img/close.png")));
		pnl_close.add(lbl_01);
		
		pnl_minimizar = new JPanel();
		pnl_minimizar.setBounds(340, 0, 30, 30);
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
		lbl_03.setIcon(new ImageIcon(JF_Main.class.getResource("/img/close.png")));
		pnl_superior.add(lbl_03);
		
		lbl_app_nombre = new JLabel("My Words");
		lbl_app_nombre.setForeground(new Color(192, 192, 192));
		lbl_app_nombre.setBounds(35, 0, 100, 30);
		pnl_superior.add(lbl_app_nombre);
		
		pnl_principal = new JPanel();
		pnl_principal.setBounds(1, 61, 400, 510);
		contentPane.add(pnl_principal);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("palabras");
		modelo.addColumn("significado");
		
		
		servicio.readFile();
		Pnl_Hoja pnl_hoja = new Pnl_Hoja();
		MostrarEnPanelPrincipal(pnl_hoja);
		listar();
	} // ===> Fin del Constructor
	
	
	void mensajeError(String mensaje){
		JOptionPane.showMessageDialog(contentPane, mensaje, "Error", 0);
	}
	void mensajeExito(String mensaje){
		JOptionPane.showMessageDialog(contentPane, mensaje, "Sistema", 1);
	}
	
	void listar() {
		modelo.setRowCount(0);
		
		Object[] fila = {"House", "casa"};
		Object[] fila2 = {"Hope", "esperanza"};
		Object[] fila3 = {"House", "casa"};
		Object[] fila4 = {"Hope", "esperanza"};
		Object[] fila5 = {"House", "casa"};
		Object[] fila6 = {"Hope", "esperanza"};
		Object[] fila7 = {"House", "casa"};
		Object[] fila8 = {"Hope", "esperanza"};
		Object[] fila9= {"House", "casa"};
		Object[] fila10 = {"Hope", "esperanza"};
		modelo.addRow(fila);
		modelo.addRow(fila2);
		modelo.addRow(fila3);
		modelo.addRow(fila4);
		modelo.addRow(fila5);
		modelo.addRow(fila6);
		modelo.addRow(fila7);
		modelo.addRow(fila8);
		modelo.addRow(fila9);
		modelo.addRow(fila10);
	}
		
	// Mostrar en el panel "p" dentro del panel principal
	static void MostrarEnPanelPrincipal(JPanel p){
		p.setSize(400, 510);
		p.setLocation(0, 0);
		pnl_principal.removeAll();
		pnl_principal.setLayout(null);
		pnl_principal.add(p);
		pnl_principal.revalidate();
		pnl_principal.repaint();
	}
	

	// =======================================
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
	// ========================================
	public void mouseDragged(MouseEvent e) { // PASO 3: EVENTO 'ARRASTRAR' DE LA BARRA - EVENTO ARRASTRAR
		if (e.getSource() == pnl_superior) {
			int x = e.getXOnScreen();  
			int y = e.getYOnScreen();
			this.setLocation(x-xMouse, y-yMouse);	
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	// =======================================
	public void actionPerformed(ActionEvent e) {
	}
}
