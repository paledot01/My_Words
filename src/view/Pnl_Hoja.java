package view;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import utils.Constans;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import javax.swing.JTextPane;
import java.awt.Color;

public class Pnl_Hoja extends JPanel {
	private JPanel pnl_hoja;
	private JPanel pnl_principal;
	
	private String textito = "House";

	/**
	 * Create the panel.
	 */
	public Pnl_Hoja() {
		setLayout(null);
		
		pnl_hoja = new JPanel();
		pnl_hoja.setBounds(0, 0, 730, 470);
		pnl_hoja.setLayout(null);
		add(pnl_hoja);
		
		pnl_principal = new JPanel();
		pnl_principal.setBackground(Constans.HOJA_CREMA);
		pnl_principal.setBorder(new LineBorder(Constans.GRIS_200));
		pnl_principal.setBounds(10, 10, 710, 450);
		pnl_principal.setLayout(null);
		pnl_hoja.add(pnl_principal);

	}
	
	
	public void paint(Graphics hoja){ // Metodo para dibujar la hoja de descripcion del calzado.
		
		/* Los dibujos se pocisionan de la parte superior-izquierda
		 * Los String se pocisionan de la parte inferior-izquierda
		 * */
		
		super.paint(hoja);
		Graphics2D hoja2d = (Graphics2D)hoja;
		BasicStroke grosor1 = new BasicStroke(1);
		BasicStroke grosor2 = new BasicStroke(2);
		// El Rectangulo Crema es un Panel de color Crema no se dibuja
		
		
		
		Font fuente = new Font("Segoe Print", Font.PLAIN, 15);
		
		hoja2d.setFont(fuente);
		hoja2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // >>>>> ALISADO
		//hoja2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		//hoja2d.setRenderingHint( RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE);
		hoja2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB); // <<< ALISADO para el texto
		for(int i=1 ; i<21;i++) {
			hoja2d.drawString("" + i + ".", 60, 10 + i*22);
			hoja2d.drawString("" + i + ".", 275, 10 + i*22);
			hoja2d.drawString("" + i + ".", 490, 10 + i*22);
		}
		
		hoja2d.drawString("House", 100, 32);
		hoja2d.drawString("Casa", 315, 32);
		hoja2d.drawString("Congratulations", 100, 54);
		hoja2d.drawString("Congratulations", 315, 54);
		hoja2d.drawString("Casa", 530, 32);
		hoja2d.drawString("Congratulations", 530, 54);
		
		hoja2d.drawString("House", 100, 76);
		hoja2d.drawString("Congratulations", 100, 98);
		hoja2d.drawString("House", 100, 120);
		hoja2d.drawString("Congratulations", 100, 142);
		hoja2d.drawString("House", 100, 164);
		hoja2d.drawString("Congratulations", 100, 186);
		hoja2d.drawString("House", 100, 208);
		hoja2d.drawString("Congratulations", 100, 230);
		hoja2d.drawString("House", 100, 252);
		hoja2d.drawString("Congratulations", 100, 274);
		Font fuente2 = new Font("Segoe Print", Font.BOLD, 36);
		hoja2d.setFont(fuente2);
		hoja2d.drawString("<=  ← →", 100, 300);
		Font fuente3 = new Font("Segoe Print", Font.PLAIN, 36);
		hoja2d.setFont(fuente3);
		hoja2d.drawString("<=  ← →", 100, 320);
		Font fuente4 = new Font("Segoe Print", Font.PLAIN, 34);
		hoja2d.setFont(fuente4);
		hoja2d.drawString("<=  ← →", 100, 343);
		Font fuente5 = new Font("Segoe Print", Font.PLAIN, 30);
		hoja2d.setFont(fuente5);
		hoja2d.drawString("<=  ← →", 100, 362);
		Font fuente6 = new Font("Segoe Print", Font.PLAIN, 28);
		hoja2d.setFont(fuente6);
		hoja2d.drawString("<=  ← →", 100, 384);
		
		// la sombra
		hoja2d.setColor(Constans.GRIS_120);
		for (int i = 0; i < 20; i++) {
			hoja2d.fillRect(10, 24 + i*22, 20, 4); //15
		}
		
		for (int j = 0; j < 20; j++) {
			hoja2d.fillOval(20, 19 + j*22, 14, 14);//16 - 
		}
		hoja2d.setColor(Constans.GRIS_140);
		hoja2d.drawLine(10, 459, 719, 459);
//		hoja2d.drawLine(390, 10, 390, 500);
		
		
		// la perforacion de la hoja
		hoja2d.setColor(Constans.GRIS_240);
		for (int i = 0; i < 20; i++) {
			hoja2d.fillRect(10, 25 + i*22, 20, 4); //15
		}
		
		for (int j = 0; j < 20; j++) {
			hoja2d.fillOval(20, 20 + j*22, 14, 14);//16 - 
		}

		
		int x2 [] = {620, 719, 719, 620};
		int y2 [] = {459, 459, 430, 459};
		GradientPaint degradado2 = new GradientPaint(68,68,Constans.HOJA_CREMA,83,113,Constans.GRIS_140,true);// 0,0 - 15,45
		hoja2d.setPaint(degradado2);
		hoja2d.fillPolygon(x2, y2, 3);
		
		hoja2d.setColor(Constans.HOJA_CREMA);// 8-24
		int x3 [] = {695, 719, 719, 695};
		int y3 [] = {459, 459, 451, 459};
		hoja2d.fillPolygon(x3, y3, 3);
		
		
		// las cuadriculas de la hoja
		hoja2d.setStroke(grosor2);
		
		hoja2d.setColor(Constans.HOJA_CELESTE);
		for (int k = 0; k < 19; k++){
			hoja2d.drawLine(11, 37 + k*22, 718, 37 + k*22 );
		}
		
		hoja2d.setColor(Constans.HOJA_ROJO);
		hoja2d.drawLine(50, 11, 50, 459);
		
		
		// DOBLEZ
		hoja2d.setStroke(grosor1);
		int x [] = {620, 719, 700, 620};
		int y [] = {458, 430, 405, 458};
		hoja2d.setColor(Constans.HOJA_CREMA);
		// 1. inclinacion(pendiente = tag) y intesidad( logitud de la hipotenusa: distancia entre el punto mas intenso del 1er color y 2do color) [0,0 - 4,12]
		// 2. inicio de la fuente, para esto desplaza la fecha, aumentando el mismo valor tanto al punto de inicio como el punto final. [0+50, 0+50 - 57+50, 150+50]
		GradientPaint degradado1 = new GradientPaint(5,5,Constans.HOJA_CREMA,9,17,Constans.GRIS_200,true);
		
		hoja2d.setPaint(degradado1);
		hoja2d.fillPolygon(x, y, 3);
		hoja2d.setColor(Constans.GRIS_200);
		//hoja2d.drawPolygon(x, y, 3);
		hoja2d.drawPolygon(x, y, 3);
		
		


		
	}
}
