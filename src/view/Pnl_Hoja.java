package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Word;
import utils.Constans;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class Pnl_Hoja extends JPanel implements MouseListener, PropertyChangeListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel pnl_hoja;
	private JPanel pnl_principal;
	private JLabel lbl_right_arrow;
	private JLabel lbl_left_arrow;
	public static JLabel lbl_grupo; // <<<<<<<<<<<<<<
	public static JLabel lbl_pagination; // <<<<<<<<<<<<<<
	
	private JLabel lbl_1 = new JLabel("");
	private JLabel lbl_2 = new JLabel("");
	private JLabel lbl_3 = new JLabel("");
	private JLabel lbl_4 = new JLabel("");
	private JLabel lbl_5 = new JLabel("");
	private JLabel lbl_6 = new JLabel("");
	private JLabel lbl_7 = new JLabel("");
	private JLabel lbl_8 = new JLabel("");
	private JLabel lbl_9 = new JLabel("");
	private JLabel lbl_10 = new JLabel("");
	private JLabel lbl_11 = new JLabel("");
	private JLabel lbl_12 = new JLabel("");
	private JLabel lbl_13 = new JLabel("");
	private JLabel lbl_14 = new JLabel("");
	private JLabel lbl_15 = new JLabel("");
	private JLabel lbl_16 = new JLabel("");
	private JLabel lbl_17 = new JLabel("");
	private JLabel lbl_18 = new JLabel("");
	private JLabel lbl_19 = new JLabel("");
	private JLabel lbl_20 = new JLabel("");
	private JLabel lbl_21 = new JLabel("");
	private JLabel lbl_22 = new JLabel("");
	private JLabel lbl_23 = new JLabel("");
	private JLabel lbl_24 = new JLabel("");
	private JLabel lbl_25 = new JLabel("");
	private JLabel lbl_26 = new JLabel("");
	private JLabel lbl_27 = new JLabel("");
	private JLabel lbl_28 = new JLabel("");
	private JLabel lbl_29 = new JLabel("");
	private JLabel lbl_30 = new JLabel("");
	private JLabel lbl_31 = new JLabel("");
	private JLabel lbl_32 = new JLabel("");
	private JLabel lbl_33 = new JLabel("");
	private JLabel lbl_34 = new JLabel("");
	private JLabel lbl_35 = new JLabel("");
	private JLabel lbl_36 = new JLabel("");
	private JLabel lbl_37 = new JLabel("");
	private JLabel lbl_38 = new JLabel("");
	private JLabel lbl_39 = new JLabel("");
	private JLabel lbl_40 = new JLabel("");
	private JLabel lbl_41 = new JLabel("");
	private JLabel lbl_42 = new JLabel("");
	private JLabel lbl_43 = new JLabel("");
	private JLabel lbl_44 = new JLabel("");
	private JLabel lbl_45 = new JLabel("");
	private JLabel lbl_46 = new JLabel("");
	private JLabel lbl_47 = new JLabel("");
	private JLabel lbl_48 = new JLabel("");
	private JLabel lbl_49 = new JLabel("");
	private JLabel lbl_50 = new JLabel("");
	private JLabel lbl_51 = new JLabel("");
	private JLabel lbl_52 = new JLabel("");
	private JLabel lbl_53 = new JLabel("");
	private JLabel lbl_54 = new JLabel("");
	private JLabel lbl_55 = new JLabel("");
	private JLabel lbl_56 = new JLabel("");
	private JLabel lbl_57 = new JLabel("");
	private JLabel lbl_58 = new JLabel("");
	private JLabel lbl_59 = new JLabel("");
	private JLabel lbl_60 = new JLabel("");
	private JLabel lbl_61 = new JLabel("");
	private JLabel lbl_62 = new JLabel("");
	private JLabel lbl_63 = new JLabel("");
	private JLabel lbl_64 = new JLabel("");
	private JLabel lbl_65 = new JLabel("");
	private JLabel lbl_66 = new JLabel("");
	private JLabel lbl_67 = new JLabel("");
	private JLabel lbl_68 = new JLabel("");
	private JLabel lbl_69 = new JLabel("");
	private JLabel lbl_70 = new JLabel("");
	private JLabel lbl_71 = new JLabel("");
	private JLabel lbl_72 = new JLabel("");
	private JLabel lbl_73 = new JLabel("");
	private JLabel lbl_74 = new JLabel("");
	private JLabel lbl_75 = new JLabel("");
	private JLabel lbl_76 = new JLabel("");
	private JLabel lbl_77 = new JLabel("");
	private JLabel[] labels = {lbl_1,lbl_2,lbl_3,lbl_4,lbl_5,lbl_6,lbl_7,lbl_8,lbl_9,lbl_10,lbl_11,lbl_12,lbl_13,lbl_14,lbl_15,lbl_16,lbl_17,lbl_18,lbl_19,lbl_20,lbl_21,lbl_22,lbl_23,lbl_24,lbl_25,lbl_26,lbl_27,lbl_28,lbl_29,lbl_30,lbl_31,lbl_32,lbl_33,lbl_34,lbl_35,lbl_36,lbl_37,lbl_38,lbl_39,lbl_40,lbl_41,lbl_42,lbl_43,lbl_44,lbl_45,lbl_46,lbl_47,lbl_48,lbl_49,lbl_50,lbl_51,lbl_52,lbl_53,lbl_54,lbl_55,lbl_56,lbl_57,lbl_58,lbl_59,lbl_60,lbl_61,lbl_62,lbl_63,lbl_64,lbl_65,lbl_66,lbl_67,lbl_68,lbl_69,lbl_70,lbl_71,lbl_72,lbl_73,lbl_74,lbl_75,lbl_76,lbl_77};
	
	private Font fuente = new Font("Segoe Print", Font.PLAIN, 15);
	public static List<Word> lista = JF_Main.lista_words_grupo_01; // << lista para llenar la hoja, muestra inicialmente el grupo 1
	public static List<Integer> labelsResaltados  = new ArrayList<Integer>(); // << guarda la pocision de los JLabels importantes (para cambiarlos de color)


	/**
	 * Create the panel.
	 */
	public Pnl_Hoja() {
		setLayout(null);
		pnl_hoja = new JPanel();
		pnl_hoja.setBounds(0, 0, 740, 470);
		pnl_hoja.setBackground(Constans.HOJA_CREMA_OSCURO);
		pnl_hoja.setLayout(null);
		add(pnl_hoja);
		
		pnl_principal = new JPanel();
		pnl_principal.setBackground(Constans.HOJA_CREMA);
		pnl_principal.setBorder(new LineBorder(Constans.GRIS_200));
		pnl_principal.setBounds(10, 10, 720, 450);
		pnl_principal.setLayout(null);
		pnl_hoja.add(pnl_principal);
		
		lbl_left_arrow = new JLabel("←");
		lbl_left_arrow.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_left_arrow.setFont(new Font("Segoe Print", Font.ITALIC, 22));
		lbl_left_arrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_left_arrow.setBounds(500, 426, 45, 18);
		lbl_left_arrow.addMouseListener(this);
		lbl_left_arrow.setEnabled(false);
		pnl_principal.add(lbl_left_arrow);
		
		lbl_right_arrow = new JLabel("→");
		lbl_right_arrow.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_right_arrow.setFont(new Font("Segoe Print", Font.ITALIC, 22));
		lbl_right_arrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_right_arrow.setBounds(576, 426, 45, 18);
		lbl_right_arrow.addMouseListener(this);
		lbl_right_arrow.setEnabled(false);
		pnl_principal.add(lbl_right_arrow);
		
		lbl_grupo = new JLabel("GRUPO I");
		lbl_grupo.setForeground(Constans.HOJA_VERDE);
		lbl_grupo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_grupo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lbl_grupo.setBounds(478, 402, 166, 20);
		lbl_grupo.addPropertyChangeListener(this);
		pnl_principal.add(lbl_grupo);
		
		lbl_pagination = new JLabel(JF_Main.pagina_actual + "/" + JF_Main.cantidad_paginas);
		lbl_pagination.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_pagination.setForeground(Color.BLACK);
		lbl_pagination.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lbl_pagination.setBounds(533, 424, 60, 20);
		pnl_principal.add(lbl_pagination);
		
		createLabels();
		fillLabels(lista, 1); // inicia en pagina 1
		enableAndDisableArrow();
		System.out.println("<<< JPANEL HOJA [END] - EJECUCION DEL CONSTRUCTOR");
	}
	

	public void createLabels() { // Crea y llena los JLABELS
		int label = 1; // enumeracion de Labels
		for(int i = 0 ; i < 4; i++) {
			for(int j = 1; j < 21; j++) {
				labels[label-1].setFont(fuente);
				labels[label-1].setBounds(60 + 160*i, -16 + j*22, 135, 19); // 90 -> 60
				labels[label-1].addMouseListener(this);
				labels[label-1].setEnabled(false);
				pnl_principal.add(labels[label-1]);
				label++;
				if(label > 77) break;
			}
			if(label > 77) break;
		}
		System.out.println("1. Crea los Labels");
	}
	
	
	public void fillLabels(List<Word> l, int pag) { // llena el contenido de los JLabels y los colorean dependiendo de su prioridad - pagina que quieres que se muestre en los labels
		if(JF_Main.cantidad_palabras != 0) {
			int n = 0 + 77*(pag-1); // enumeracion de  inicio de palabras por pagina: pag1(1), pag2(58) ...
			labelsResaltados.clear(); // limpia la lista de JLabel importantes
			for(int i = 0; i < 77; i++) {
				labels[i].setText(lista.get(n).getWord());
				labels[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				labels[i].setEnabled(true);
				if(lista.get(n).getImportant().equals("1")) {
					labels[i].setForeground(Constans.HOJA_MORADO);
					labelsResaltados.add(i);
				} else {
					labels[i].setForeground(Color.BLACK);
				}
				n++;
				if(n == JF_Main.cantidad_palabras) break;
			}
		}
		System.out.println("2. Llena los Labels");
	}
	
	
	public void clearLabels() { // Limpia los JLabel que deben estar vacios, es decir solo a la ultima pagina, por eso no se aplica cuando retroces de pagina.
		if(JF_Main.pagina_actual == JF_Main.cantidad_paginas) {
			int inicio = 77 - (JF_Main.cantidad_paginas * 77 - JF_Main.cantidad_palabras); // si cantidadPalabras = 58 -> inicio = 1 -> debe empezar por el 2do Label -> ES CORRECTO.
			for(int i = inicio; i < 77; i++) {
				labels[i].setText("");
				labels[i].setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				labels[i].setEnabled(false);
			}
		}
		System.out.println("3. Limpia los Labels");
	}
	
	
	public void enableAndDisableArrow() {
		if(JF_Main.pagina_actual == 1) {
			lbl_left_arrow.setEnabled(false);
		} else {
			lbl_left_arrow.setEnabled(true);
		}
		if(JF_Main.pagina_actual == JF_Main.cantidad_paginas) {
			lbl_right_arrow.setEnabled(false);
		} else {
			lbl_right_arrow.setEnabled(true);
		}
	}
	
	public void paint(Graphics hoja){ // -> El orden es importante porque los ultimos dibujos sobreenciman a los anteriores, asi como los colores y alisados.
		
		/* UBICACION:
		 * 1. Los dibujos se pocisionan de la parte superior-izquierda
		 * 2. Los String se pocisionan de la parte inferior-izquierda
		 * DEGRADADO:
		 * 1. Inclinacion(pendiente = tag) y intesidad( logitud de la hipotenusa: distancia entre el punto mas intenso del 1er color y 2do color) [0,0 - 4,12]
		 * 2. Inicio de la fuente, para esto desplaza la fecha, aumentando el mismo valor tanto al punto de inicio como el punto final. [0+50, 0+50 - 57+50, 150+50]
		 * */

//		ImageIcon fondo = new ImageIcon(getClass().getResource("/img/fondo_1.jpg"));
//		hoja2d.drawImage(fondo.getImage(), 0,0,730,470,this);
		
		// >>>>>>> BASIC <<<<<
		super.paint(hoja);
		Graphics2D hoja2d = (Graphics2D)hoja;
		BasicStroke grosor1 = new BasicStroke(1);
		BasicStroke grosor2 = new BasicStroke(2);
		
		hoja2d.setFont(fuente);
		
		//hoja2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // >>>>> ALISADO
		hoja2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB); // >>>>> ALISADO PARA TEXTO
		//hoja2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		//hoja2d.setRenderingHint( RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE);
		
		
		// >>>>>>> NUMERACION (ocupaba mucho espacio) <<<<<
//		int n = 1 + (JF_Main.pagina_actual-1)*57; // inicio de la enumeracion, pag 1 = 1, pag 2 = 58. Hasta el maximo de palabras o el fin de la pagina.
//		for(int i = 0 ; i < 3; i++) {
//			for(int j = 1; j < 21; j++) {
//				hoja2d.drawString("" + n + ".", 60 + 215*i, 10 + j*22); // x + 215
//				n++;
//				if(n > JF_Main.cantidad_palabras || n > JF_Main.pagina_actual*57) break;
//			}
//			if(n > JF_Main.cantidad_palabras || n > JF_Main.pagina_actual*57) break;
//		}

		// >>>>>>> DOBLEZ DE LA HOJA - TRIANGULO INFERIOR
		int x2 [] = {629, 729, 729, 629};
		int y2 [] = {459, 459, 430, 459};
		GradientPaint degradado2 = new GradientPaint(68,68,Constans.HOJA_CREMA,83,113,Constans.GRIS_140,true);// 0,0 - 15,45
		hoja2d.setPaint(degradado2);
		hoja2d.fillPolygon(x2, y2, 3);
		
		hoja2d.setColor(Constans.HOJA_CREMA);// 8-24 : triangulito(inferior) de luz crema.
		int x3 [] = {705, 729, 729, 705};
		int y3 [] = {459, 459, 451, 459};
		hoja2d.fillPolygon(x3, y3, 3);
		
		// >>>>>>> CUADRICULA DE LA HOJA : DEBE ESTAR ANTES DEL ALISADO, O SU GROSOR AUMENTARÁ.
		hoja2d.setStroke(grosor2);
		hoja2d.setColor(Constans.HOJA_CELESTE);
		for (int k = 0; k < 19; k++){
			hoja2d.drawLine(11, 37 + k*22, 728, 37 + k*22 );
		}
		hoja2d.setColor(Constans.HOJA_ROJO);
		hoja2d.drawLine(50, 11, 50, 459);
		
		
		
		hoja2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // >>>>> ALISADO
		
		
		
		// >>>>>>> DOBLEZ DE LA HOJA - TRIANGULO SUPERIOR
		hoja2d.setStroke(grosor1);
		int x [] = {630, 729, 710, 630};
		int y [] = {458, 430, 405, 458};
		GradientPaint degradado1 = new GradientPaint(5,5,Constans.HOJA_CREMA,9,17,Constans.GRIS_200,true);
		hoja2d.setPaint(degradado1);
		hoja2d.fillPolygon(x, y, 3); // Contenido
		hoja2d.setColor(Constans.GRIS_200);
		hoja2d.drawPolygon(x, y, 3); // Borde
		
		
		// >>>>>>> SOMBRA : Debe crearse antes de la perforacion.
		hoja2d.setColor(Constans.GRIS_120); // PERFORACION
		for (int i = 0; i < 20; i++) {
			hoja2d.fillRect(10, 24 + i*22, 20, 4); //15
		}
		for (int j = 0; j < 20; j++) {
			hoja2d.fillOval(20, 19 + j*22, 14, 14);//16 - 
		}
		hoja2d.setColor(Constans.GRIS_140);
		hoja2d.drawLine(10, 459, 729, 459); // sombra: hoja inferior
		hoja2d.drawLine(0, 0, 740, 0); // sombra: borde superior de todo el panel.
		hoja2d.setColor(Constans.GRIS_200);
		hoja2d.drawLine(0, 469, 740, 469); // sombra: borde inferior de todo el panel.
		
		
		// >>>>>>> PERFORACION DE LA HOJA
		hoja2d.setColor(Constans.HOJA_CREMA_OSCURO);
		for (int i = 0; i < 20; i++) {
			hoja2d.fillRect(10, 25 + i*22, 20, 4); //15
		}
		for (int j = 0; j < 20; j++) {
			hoja2d.fillOval(20, 20 + j*22, 14, 14);//16 - 
		}
		
		System.out.println(">>> JPANEL - EJECUCION DEL METODO PAINT");
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == lbl_right_arrow && lbl_right_arrow.isEnabled()) {
			JF_Main.pagina_actual++;
			lbl_pagination.setText(JF_Main.pagina_actual + "/" + JF_Main.cantidad_paginas);
			clearLabels();
			paint(this.getGraphics()); // repinta los numeros
			fillLabels(lista, JF_Main.pagina_actual);
			enableAndDisableArrow();
		}
		if (e.getSource() == lbl_left_arrow && lbl_left_arrow.isEnabled()) {
			JF_Main.pagina_actual--;
			lbl_pagination.setText(JF_Main.pagina_actual + "/" + JF_Main.cantidad_paginas);
			paint(this.getGraphics());
			fillLabels(lista, JF_Main.pagina_actual);
			enableAndDisableArrow();
		}
		for(int i=0; i<77; i++) {
			if (e.getSource() == labels[i] && labels[i].isEnabled()) { // se desabilita para que los labels vacios no funcionen.
				if(e.getButton() == MouseEvent.BUTTON1) { // BUTTON1 (izquierda) BUTTON2 (medio) BUTTON3(derecha)
					Dlg_DetailWord.posicionPalabra = (JF_Main.pagina_actual-1)*77 + i;
					Dlg_DetailWord detallePalabra = new Dlg_DetailWord();
					detallePalabra.setLocationRelativeTo(pnl_principal);
					detallePalabra.setVisible(true);
				} else {
//					int pocision = (JF_Main.pagina_actual-1)*57 + i;
					System.out.println("click derecho");
				}

			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lbl_right_arrow) {
			lbl_right_arrow.setForeground(Color.RED);
		}
		if (e.getSource() == lbl_left_arrow) {
			lbl_left_arrow.setForeground(Color.RED);
		}
		for(int i=0; i<77; i++) {
			if (e.getSource() == labels[i]) labels[i].setForeground(Constans.HOJA_NARANJA);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lbl_right_arrow) {
			lbl_right_arrow.setForeground(Color.BLACK);
		}
		if (e.getSource() == lbl_left_arrow) {
			lbl_left_arrow.setForeground(Color.BLACK);
		}
		for(int i=0; i<77; i++) {
			if (e.getSource() == labels[i]) {
				if(labelsResaltados.contains(i)) {
					labels[i].setForeground(Constans.HOJA_MORADO);
				}else {
					labels[i].setForeground(Color.BLACK);
				}
			}
		}
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent e) { // para detectar el cambio de pagina que viene de la clase JF_Main y actualizar los labels
		if (e.getSource() == lbl_grupo && e.getPropertyName().equals("text")) { // Se activa solo con el evento de modificacion de texto.
			clearLabels();
			paint(this.getGraphics());
			fillLabels(lista, JF_Main.pagina_actual);
			enableAndDisableArrow();
//			labelsResaltados.clear();
			System.out.println("Pnl_Hoja : evento_cambiado -> " + e.getPropertyName());
		}
	}
}







// --