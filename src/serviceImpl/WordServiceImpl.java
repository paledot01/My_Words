package serviceImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Word;
import service.WordService;
import utils.Constans;
import view.JF_Main;
import view.Pnl_Add_Word;

public class WordServiceImpl implements WordService {

	// Constantes
	final String file = Constans.PATH_FILE;

	@Override
	public int save() { // guardar la palabra en el archivo de texto
		int respuesta = -1;

		File fileStorage = new File(file);
		if (fileStorage.exists()) {
			fileStorage.delete();
		}

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			if(Pnl_Add_Word.pathsImageArray.size() > 0) {
				for (Path[] p : Pnl_Add_Word.pathsImageArray) {
					Files.copy(p[0], p[1], StandardCopyOption.REPLACE_EXISTING);
				}
			}

			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);

			for (Word w : JF_Main.lista_words_grupo_01) {
				String linea = w.toString();
				bw.write(linea.concat("\n"));
			}
			for (Word w : JF_Main.lista_words_grupo_02) {
				String linea = w.toString();
				bw.write(linea.concat("\n"));
			}
			for (Word w : JF_Main.lista_words_grupo_03) {
				String linea = w.toString();
				bw.write(linea.concat("\n"));
			}
			for (Word w : JF_Main.lista_words_grupo_04) {
				String linea = w.toString();
				bw.write(linea.concat("\n"));
			}
			for (Word w : JF_Main.lista_words_grupo_05) {
				String linea = w.toString();
				bw.write(linea.concat("\n"));
			}
//			for (String linea : JF_Main.lista_important) {
//				bw.write(linea.concat("\n"));
//			}

			respuesta = 1;

		} catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException io) {
			}
		}

		return respuesta;
	}

	@Override
	public int save22(Word w) { // guardar la palabra en el archivo de texto
		int respuesta = -1;

		try {
			File archivo;
//			FileInputStream archivoEntrada = null;
			FileOutputStream archivoSalida = null;

			JFileChooser ventSeleccion = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
			ventSeleccion.setFileFilter(filtro);
			ventSeleccion.setDialogTitle("Guardar Archivo");
			ventSeleccion.setAcceptAllFileFilterUsed(true); // true: muestra el tambien filtro de todos los tipos de
															// archivos, false : muestra solo el filtro seleccionado

			/**
			 * showDialog(componentePadre, nombreBotonAprobado) -- devuelve un numero que
			 * representa la eleccion del usuario.
			 */
			if (ventSeleccion.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {

				// toString(), transforma el archivo seleccionado en un cadena de la ruta del
				// archivo, a�adiendole el formarto.
				String ruta = ventSeleccion.getSelectedFile().toString().concat(".txt");
				archivo = new File(ruta); // archivo = ventSeleccion.getSelectedFile();

				String linea = "";
				String data = linea;

				linea = w.getWord() + ';' + w.getMeaning() + ';' + w.getExample() + ';' + w.getImage();

				data += linea;

				byte[] dataByte = data.getBytes();

				archivoSalida = new FileOutputStream(archivo); // <<<
				archivoSalida.write(dataByte); // <<<<
				archivoSalida.close();
				respuesta = 1;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		}

		return respuesta;
	}

	@Override
	public int export() {
		int respuesta = -1;

		try {
			File archivo;
			FileOutputStream archivoSalida = null;

			JFileChooser ventSeleccion = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
			ventSeleccion.setFileFilter(filtro);
			ventSeleccion.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			ventSeleccion.setDialogTitle("Guardar Archivo");
			ventSeleccion.setAcceptAllFileFilterUsed(true); // true: muestra el tambien filtro de todos los tipos de
															// archivos, false : muestra solo el filtro seleccionado

			/**
			 * showDialog(componentePadre, nombreBotonAprobado) -- devuelve un numero que
			 * representa la eleccion del usuario.
			 */
			if (ventSeleccion.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {

				// toString(), transforma el archivo seleccionado en un cadena de la ruta del
				// archivo, a�adiendole el formarto.
				String ruta = ventSeleccion.getSelectedFile().toString().concat(".txt");
				archivo = new File(ruta); // archivo = ventSeleccion.getSelectedFile();

				String data = "";
				for (String linea : JF_Main.lista_important) {
					data += linea + "\n";
				}

				byte[] dataByte = data.getBytes();

				archivoSalida = new FileOutputStream(archivo); // <<<
				archivoSalida.write(dataByte); // <<<<
				archivoSalida.close();
				respuesta = 1;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia export() --> " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error en la sentencia export() --> " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en la sentencia export() --> " + e.getMessage());
		}

		return respuesta;
	}

	@Override
	public int addWord(Word w, Path pathImageOrigin) {
		int respuesta = -1;

		File archivoExistente = new File(file);
		if (archivoExistente.exists()) {
			archivoExistente.delete();
		}

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {

			fw = new FileWriter("C:/Users/KEVIN/Desktop/file.txt", true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			String linea = w.getWord() + ';' + w.getMeaning() + ';' + w.getExample() + ';' + w.getImage();

			pw.println(linea); // <<<
			pw.flush();
			respuesta = 1;

		} catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		} finally {
			try {
				pw.close();
				bw.close();
				fw.close();
			} catch (IOException io) {
			}
		}

		return respuesta;
	}

	@Override
	public int newCode() {

		int code = 1;

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			if ((linea = br.readLine()) != null) {
				System.out.println("linea: " + linea);
				String s[] = linea.split(";");
				code = Integer.parseInt(s[0]);
			}
			System.out.println("codigo: " + code);

		} catch (Exception e) {

		}
		return code;

	}

	@Override
	public void readFile() { // esto debe ejecutarse al inicio
		Word obj;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String linea = new String();
			while (br.ready()) {
				linea = br.readLine();
				String s[] = linea.split(";");
				if (s[5].equals("1"))
					JF_Main.lista_important.add(s[0] + "-------------------------" + s[1]);
				obj = new Word(s[0], s[1], s[2], s[3], s[4], s[5]);
//				JF_Main.lista_words.add(obj);
				switch (obj.getGroup()) {
				case "g1":
					JF_Main.lista_words_grupo_01.add(obj);
					break;
				case "g2":
					JF_Main.lista_words_grupo_02.add(obj);
					break;
				case "g3":
					JF_Main.lista_words_grupo_03.add(obj);
					break;
				case "g4":
					JF_Main.lista_words_grupo_04.add(obj);
					break;
				case "g5":
					JF_Main.lista_words_grupo_05.add(obj);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR AL ENCONTRAR EL ARCHIVO - en el metodo readFile(): " + e.getMessage());
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("ERROR en el metodo readFile(): " + e.getMessage());
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException io) {
			}
		}
		System.out.println(">>< SERVICE IMPL - LEYO EL ARCHIVO FILE");
	}

}
