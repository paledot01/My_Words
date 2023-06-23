package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import model.Word;
import serviceImpl.WordServiceImpl;
import utils.Constans;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Cursor;
import java.awt.Desktop;

public class Dlg_DetailWord extends JDialog implements MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_fondo;
	private JPanel panel;
	private JLabel lbl_significado;
	private JLabel lbl_ejemplo;
	private JLabel lbl_imagen;
	private Font fuente_17 = new Font("Segoe Print", Font.PLAIN, 17);
	private Font fuente_15 = new Font("Segoe Print", Font.PLAIN, 15);
	private Font fuente_interrogacion = new Font("DialogInput", Font.BOLD | Font.ITALIC, 20);
	private Font fuente_ejemplo = new Font("Kristen ITC", Font.PLAIN, 14);

	public static int posicionPalabra = 0;
	private Word palabra;
	private String pathImage;
	private JLabel lbl_zoom;
//	private String imagen2 = "C:/MyWords/imgs/fetch.jpg";
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dlg_DetailWord dialog = new Dlg_DetailWord();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dlg_DetailWord() {
		setResizable(false);
		setModal(true); // <<<<< Bloquea el fondo
		setBounds(100, 100, 350, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Constans.HOJA_CREMA);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(10, 11, 314, 389);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lbl_significado = new JLabel("? ? ?");
		lbl_significado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_significado.setFont(fuente_interrogacion);
		lbl_significado.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_significado.addMouseListener(this);
		lbl_significado.setBounds(32, 5, 250, 30);
		panel.add(lbl_significado);
		
		lbl_ejemplo = new JLabel("");
//		lbl_ejemplo = new JLabel(palabra.getExample()); // <<<<<<<<<<<<<<< 2
		lbl_ejemplo.setFont(fuente_ejemplo);
		lbl_ejemplo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ejemplo.setBounds(17, 43, 280, 51);
		panel.add(lbl_ejemplo);
		
		lbl_zoom = new JLabel("");
		lbl_zoom.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_zoom.addMouseListener(this);
		lbl_zoom.setIcon(new ImageIcon(Dlg_DetailWord.class.getResource("/img/zoom_0.png")));
		lbl_zoom.setBounds(276, 98, 19, 19);
		panel.add(lbl_zoom);
		
		lbl_imagen = new JLabel("");
		lbl_imagen.setBorder(new LineBorder(new Color(187, 200, 212)));
		lbl_imagen.setBounds(16, 97, 280, 280);
		lbl_imagen.setIcon(new ImageIcon(Dlg_DetailWord.class.getResource("/img/no_image.png"))); // <<<<<<
		panel.add(lbl_imagen);
		
		lbl_fondo = new JLabel("");
		lbl_fondo.setVerticalAlignment(SwingConstants.TOP);
		lbl_fondo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fondo.setIcon(new ImageIcon(Dlg_DetailWord.class.getResource("/img/detail_fondo.png")));
		lbl_fondo.setBounds(0, 0, 334, 411);
		contentPanel.add(lbl_fondo);
		
		// -------------------
		getPalabra(); // obtenemos al palabras de la lista.
		setTitle(); // colocamos la palabra como titulo de la ventana.
		getPathImage(); // obtenemos la ruta de la imagen.
		setImage(pathImage); // modifica la imagen asociada a la palabra si la tiene.
		setEjemploEnMultilinea(palabra.getExample()); // cambia el ejemplo en dos lineas si pasa los 38 caracteres.
	} // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	public void getPalabra() {
		palabra = Pnl_Hoja.lista.get(posicionPalabra);
	}
	void getPathImage() {
		pathImage = Constans.PATH_IMGS + palabra.getImage();
	}
	public void setTitle() {
		setTitle(palabra.getWord()); // <<<<<<<<<<<<<<< 1
	}
	
	// >>> Modifica la Imagen si existe y lo redimenciona solo si es necesario. si no hay imagen no modifica nada y vuelve invisible el zoom.
	public void setImage(String rutaImagen) { // BufferedImage extiende de image.
		Image imagen = null;
		BufferedImage imagenOriginal = null;
		try {
			imagenOriginal = ImageIO.read(new File(rutaImagen));
			imagen = imagenOriginal;
			int ancho = imagenOriginal.getWidth();
			int alto = imagenOriginal.getHeight();
			
			if (ancho > 280 || alto > 280) {
				int mayor = ancho;
				if(alto > mayor) {
					mayor = alto;
				}
				double razon = mayor/280.0;
				Double newAncho = ancho/razon;
				Double newAlto = alto/razon;
				imagen = imagenOriginal.getScaledInstance(newAncho.intValue(), newAlto.intValue(), Image.SCALE_SMOOTH);
			}
			lbl_imagen.setIcon(new ImageIcon(imagen));
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("Error en el metodo SetImage(): --> " + e.getMessage());
			lbl_zoom.setVisible(false); // oculta el boton de zoom.
		}
	}
	
	// >>> Inserta el ejemplo en el JLabel y si este supera un limite de caracteres entonces lo convierte en 2 lineas.
	public void setEjemploEnMultilinea(String frase) { // <html><br></html>
		
		String newFrase = frase;
		
		if(frase.length() >=38) { // Solo si la frase es mayor a 34 caracteres.
			
			newFrase = "";
			int cantCharXPalabra[] = new int [18]; // arreglo de valores
			int posicionDeInsercion = 0;
			String s[] = frase.split(" "); // arreglo de todas las palabras que contiene la frase
			
			for(int i = 0; i < s.length; i++) { // ## 1. agrega espacios al final de cada palabra excepto del ultimo
				if(i == s.length-1) break;
				s[i] += " ";
			}
			
			for(int i = 0; i < s.length; i++) { // ## 2. dependiendo del numero de caracteres por palabra, SI la cantidad de caracteres es mayor a 34 inserta el salto de linea en la palabra anterior.
				cantCharXPalabra[i] = s[i].length();
				posicionDeInsercion += cantCharXPalabra[i];
				if(posicionDeInsercion >= 38) { // si pasa este limite toma el valor anterior y sale del bucle.
					s[i-1] = s[i-1].trim() + "<br>";
					break;
				}
			}
			for(int i = 0; i < s.length; i++) { // ## 3. forma la frase
				newFrase += s[i];
			}
			newFrase = "<html>" + newFrase + "</html>";
			
//			System.out.println(">>>> " + newFrase);
		}
		
		lbl_ejemplo.setText(newFrase);
		
	}
	
	void openImage() { // abre la imagen en Windows
		File f = new File(pathImage);
		
	    Desktop dt = Desktop.getDesktop();
	    try {
			dt.open(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	// ============================  EVENTOS  ===================================
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == lbl_zoom) {
			openImage();
		}
		if (e.getSource() == lbl_significado) {
			lbl_significado.setText(palabra.getMeaning());
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == lbl_zoom) {
			lbl_zoom.setIcon(new ImageIcon(Dlg_DetailWord.class.getResource("/img/zoom_1.png")));
		}
		if (e.getSource() == lbl_significado) {
			lbl_significado.setForeground(Color.RED);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == lbl_zoom) {
			lbl_zoom.setIcon(new ImageIcon(Dlg_DetailWord.class.getResource("/img/zoom_0.png")));
		}
		if (e.getSource() == lbl_significado) {
			lbl_significado.setForeground(Color.BLACK);
		}		
	}
}



// --
