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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import javax.swing.JTextPane;
import java.awt.Color;

public class Pnl_Hoja extends JPanel {
	private JPanel pnl_hoja;
	private JPanel pnl_principal;
	
	private String textito = "House";
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public Pnl_Hoja() {
		setLayout(null);
		
		pnl_hoja = new JPanel();
		pnl_hoja.setBounds(0, 0, 400, 510);
		pnl_hoja.setLayout(null);
		add(pnl_hoja);

		
		pnl_principal = new JPanel();
		pnl_principal.setBackground(Constans.HOJA_CREMA);
		pnl_principal.setBorder(new LineBorder(Constans.GRIS_220));
		pnl_principal.setBounds(10, 10, 380, 490);
		pnl_principal.setLayout(null);
		pnl_hoja.add(pnl_principal);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pnl_Hoja.class.getResource("/img/image_w15.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(356, 9, 15, 15);
		pnl_principal.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Pnl_Hoja.class.getResource("/img/image_2_w15.png")));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(356, 31, 15, 15);
		pnl_principal.add(lblNewLabel_1);

	}
	
	
	public void paint(Graphics hoja){ // Metodo para dibujar la hoja de descripcion del calzado.
		
		/* Los dibujos se pocisionan de la parte superior-izquierda
		 * Los String se pocisionan de la parte inferior-izquierda
		 * */
		
		super.paint(hoja);
		Graphics2D hoja2d = (Graphics2D)hoja;
		BasicStroke grosor1 = new BasicStroke(2);
		
		// El Rectangulo Crema es un Panel de color Crema no se dibuja
		
		Font fuente = new Font("Segoe Print", Font.PLAIN, 15);
		hoja2d.setStroke(grosor1);
		hoja2d.setFont(fuente);
		hoja2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // >>>>> ALISADO
		//hoja2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		//hoja2d.setRenderingHint( RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE);
		hoja2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB); // <<< ALISADO para el texto
		for(int i=1 ; i<23;i++) {
			hoja2d.drawString("" + i + ".", 60, 10 + i*22);
			hoja2d.drawString("" + i + ".", 250, 10 + i*22);
		}
		
		hoja2d.drawString("House", 100, 32);
		hoja2d.drawString("Casa", 260, 32);
		hoja2d.drawString("Congratulations", 100, 54);
		hoja2d.drawString("Felicidades", 260, 54);
		
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
		
		// la sombra
		hoja2d.setColor(Constans.GRIS_160);
		for (int i = 0; i < 22; i++) {
			hoja2d.fillRect(10, 24 + i*22, 20, 4); //15
		}
		
		for (int j = 0; j < 22; j++) {
			hoja2d.fillOval(20, 19 + j*22, 14, 14);//16 - 
		}
		hoja2d.drawLine(10, 500, 389, 500);
//		hoja2d.drawLine(390, 10, 390, 500);
		
		
		// la perforacion de la hoja
		hoja2d.setColor(Constans.GRIS_240);
		for (int i = 0; i < 22; i++) {
			hoja2d.fillRect(10, 25 + i*22, 20, 4); //15
		}
		
		for (int j = 0; j < 22; j++) {
			hoja2d.fillOval(20, 20 + j*22, 14, 14);//16 - 
		}
		
		// las cuadriculas de la hoja
		hoja2d.setStroke(grosor1);
		
		hoja2d.setColor(Constans.HOJA_CELESTE);
		for (int k = 0; k < 21; k++){
			hoja2d.drawLine(11, 37 + k*22, 389, 37 + k*22 );
		}
		
		hoja2d.setColor(Constans.HOJA_ROJO);
		hoja2d.drawLine(50, 11, 50, 499);

		
	}
}
