package view;

import javax.swing.JPanel;

import utils.Constans;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Word;
import service.WordService;
import serviceImpl.WordServiceImpl;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

public class Pnl_Add_Word extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel pnlAddWord;
	private JTextField txtWord;
	private JTextField txtMeaning;
	private JTextField txtImage;
	private JLabel lblWord;
	private JLabel lblMeaning;
	private JLabel lblExample;
	private JLabel lblImage;
	private JLabel lblGroup;
	private JLabel lblImportant;
	private JComboBox cboGroup;
	private JCheckBox chImportant;
	private JTextArea txtsExample;
	private JButton btnAgregar;
	private JButton btnSearchImage;
	private JButton btnSave;

	private WordService serviceWord = new WordServiceImpl();
	private JPanel pnlPrincipal;

	// imagenes que se guardaran cuando se de click en guardar.
	static public List<Path[]> pathsImageArray = new ArrayList<Path[]>();
	private String extensionImage = ".jpg";
	private boolean hasChanges = false;

	/**
	 * Create the panel.
	 */
	public Pnl_Add_Word() {
		setLayout(null);

		pnlAddWord = new JPanel();
		pnlAddWord.setBounds(0, 0, 740, 470);
		pnlAddWord.setBackground(Constans.HOJA_CREMA_OSCURO);
		pnlAddWord.setLayout(null);
		add(pnlAddWord);

		pnlPrincipal = new JPanel();
		pnlPrincipal.setBounds(10, 10, 720, 450);
		pnlPrincipal.setLayout(null);
		pnlPrincipal.setBorder(new LineBorder(new Color(150, 150, 150)));
		pnlPrincipal.setBackground(Constans.HOJA_CREMA_OSCURO);
		pnlAddWord.add(pnlPrincipal);

		lblWord = new JLabel("Word :");
		lblWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWord.setHorizontalAlignment(SwingConstants.LEFT);
		lblWord.setBounds(15, 42, 70, 22);
		pnlPrincipal.add(lblWord);

		lblMeaning = new JLabel("Meaning :");
		lblMeaning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMeaning.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeaning.setBounds(15, 69, 70, 22);
		pnlPrincipal.add(lblMeaning);

		lblExample = new JLabel("Example :");
		lblExample.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExample.setHorizontalAlignment(SwingConstants.LEFT);
		lblExample.setBounds(15, 96, 70, 22);
		pnlPrincipal.add(lblExample);

		lblImage = new JLabel("Image :");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImage.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage.setBounds(15, 169, 70, 22);
		pnlPrincipal.add(lblImage);

		lblGroup = new JLabel("Group :");
		lblGroup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGroup.setHorizontalAlignment(SwingConstants.LEFT);
		lblGroup.setBounds(15, 15, 70, 22);
		pnlPrincipal.add(lblGroup);

		lblImportant = new JLabel("Important :");
		lblImportant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImportant.setHorizontalAlignment(SwingConstants.LEFT);
		lblImportant.setBounds(15, 196, 70, 22);
		pnlPrincipal.add(lblImportant);

		txtWord = new JTextField();
		txtWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtWord.addKeyListener(this);
		txtWord.setBounds(100, 43, 170, 22);
		txtWord.setColumns(10);
		pnlPrincipal.add(txtWord);

		txtMeaning = new JTextField();
		txtMeaning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMeaning.setColumns(10);
		txtMeaning.setBounds(100, 70, 170, 22);
		pnlPrincipal.add(txtMeaning);

		txtImage = new JTextField();
		txtImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtImage.setText("image.jpg");
		txtImage.setEditable(false);
		txtImage.setColumns(10);
		txtImage.setBounds(100, 169, 170, 22);
		pnlPrincipal.add(txtImage);

		cboGroup = new JComboBox();
		cboGroup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboGroup.setModel(
				new DefaultComboBoxModel(new String[] { "Grupo 01", "Grupo 02", "Grupo 03", "Grupo 04", "Grupo 05" }));
		cboGroup.setBounds(100, 15, 170, 22);
		pnlPrincipal.add(cboGroup);

		chImportant = new JCheckBox("");
		chImportant.setSelected(true);
		chImportant.setBounds(100, 196, 22, 22);
		pnlPrincipal.add(chImportant);

		txtsExample = new JTextArea();
		txtsExample.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtsExample.setLineWrap(true);
		txtsExample.setBounds(100, 98, 170, 66);
		pnlPrincipal.add(txtsExample);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(10, 298, 271, 23);
		btnAgregar.addActionListener(this);
		pnlPrincipal.add(btnAgregar);

		btnSearchImage = new JButton("Search");
		btnSearchImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearchImage.setEnabled(false);
		btnSearchImage.setBounds(280, 169, 89, 23);
		btnSearchImage.addActionListener(this);
		pnlPrincipal.add(btnSearchImage);

		btnSave = new JButton("Guardar All");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBounds(359, 298, 271, 23);
		btnSave.addActionListener(this);
		pnlPrincipal.add(btnSave);
	}

	/*
	 * 1. almacenar la path de la imagen que se usara para hacer una copia de esta.
	 * 2. obtener los valores de los campos de texto y guardarlos en un objeto Word.
	 * 3. guardar el objeto Word en la lista que corresponada segun su grupo.
	 */
	Word getValues() {
		String[] groups = { "g1", "g2", "g3", "g4", "g5" };

		String group = cboGroup.getSelectedIndex() != -1 ? groups[cboGroup.getSelectedIndex()] : "";
		String word = txtWord.getText().trim();
		String meaning = txtMeaning.getText().trim();
		String example = txtsExample.getText().trim();
		String image = word.concat(extensionImage);
		String important = chImportant.isSelected() ? "1" : "0";

		if (word.isEmpty() || meaning.isEmpty()) {
			return null;
		}

		return new Word(word, meaning, example, image, group, important);
	}

	/* Desabilita el nombre del archivo de la ventana de seleccion */
	public boolean disableFileName(Container container) {
		Component[] comps = container.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JTextField) {
				((JTextField) comp).setEnabled(false);
				return true;
			}
			if (comp instanceof Container) {
				if (disableFileName((Container) comp))
					return true;
			}
		}
		return false;
	}

	void searchImage() { // READY
		Path pathImageOrigin = null;
		Path pathImageDestiny = null;
		String word = txtWord.getText().trim();
		JFileChooser ventSeleccion = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen", "jpg", "png");
		ventSeleccion.setFileFilter(filtro);
		ventSeleccion.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
		ventSeleccion.setDialogTitle("Search Image");
		ventSeleccion.setAcceptAllFileFilterUsed(true);
		disableFileName(ventSeleccion);

		if (ventSeleccion.showDialog(null, "Upload") == JFileChooser.APPROVE_OPTION) {
			// ruta original de la imagen.
			pathImageOrigin = ventSeleccion.getSelectedFile().toPath();
			// encontramos la extencion de la imagen original.
			int dotIndex = pathImageOrigin.toString().lastIndexOf('.');
			if (dotIndex > 0) {
				extensionImage = pathImageOrigin.toString().substring(dotIndex);
			}
			// ruta destino de la imagen pero con el nombre de la palabra.
			pathImageDestiny = Paths.get(Constans.PATH_IMAGES + word.concat(extensionImage));
			// guardamos ambas rutas en un array de paths.
			Path[] paths = { pathImageOrigin, pathImageDestiny };
			pathsImageArray.add(paths);
		}
	}

	void addWord(Word word) {
		switch (word.getGroup()) {
		case "g1":
			JF_Main.lista_words_grupo_01.add(word);
			break;
		case "g2":
			JF_Main.lista_words_grupo_02.add(word);
			break;
		case "g3":
			JF_Main.lista_words_grupo_03.add(word);
			break;
		case "g4":
			JF_Main.lista_words_grupo_04.add(word);
			break;
		case "g5":
			JF_Main.lista_words_grupo_05.add(word);
			break;
		}
		hasChanges = true;
	}

	//
	void cleanFields() {
		txtWord.setText("");
		txtMeaning.setText("");
		txtsExample.setText("");
		txtImage.setText("image.jpg");
		chImportant.setSelected(true);
	}

	void removeChanges() {
		hasChanges = false;
		pathsImageArray.clear();
	}

	public void paint(Graphics hoja) { // -> El orden es importante porque los ultimos dibujos sobreenciman a los
										// anteriores, asi como los colores y alisados.
		// >>>>>>> BASIC <<<<<
		super.paint(hoja);
		Graphics2D hoja2d = (Graphics2D) hoja;

		hoja2d.setColor(Constans.GRIS_140);
		hoja2d.drawLine(0, 0, 740, 0); // sombra: borde superior de todo el panel.
		hoja2d.setColor(Constans.GRIS_200);
		hoja2d.drawLine(0, 469, 740, 469); // sombra: borde inferior de todo el panel.
	}
	
	void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(pnlPrincipal, mensaje, "Error", 0);
	}

	void mensajeExito(String mensaje) {
		JOptionPane.showMessageDialog(pnlPrincipal, mensaje, "Sistema", 1);
	}

	// ==================================================================================================

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearchImage) {
			searchImage();
		}
		if (e.getSource() == btnAgregar) {
			Word word = getValues();
			if (word == null) {
				mensajeError("Ni la palabra ni el significado pueden estar vacios.");
				return;
			}
			addWord(word);
			cleanFields();
		}
		if (e.getSource() == btnSave) { // no se tiene que limpiar los cambios de las palabras en las listas, porque si se guardan en el archivo deben visualizarce aca tambien.
			serviceWord.save();
			removeChanges(); // solo limpia las imagenes.
		}
	}

	// ==================================================================================================

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtWord) {
			if (txtWord.getText().trim().length() > 0) {
				btnSearchImage.setEnabled(true);
				txtImage.setText(txtWord.getText().trim().concat(extensionImage));
			} else {
				btnSearchImage.setEnabled(false);
				txtImage.setText("image.jpg");
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyReleasedTxtWord(KeyEvent e) {
	}
}
