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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Word;
import service.WordService;
import utils.Constans;
import view.JF_Main;

public class WordServiceImpl implements WordService{

	// Constantes []
	final String file = Constans.PATH_FILE;

	
	
	@Override
	public int save(Word w) {
		int respuesta = -1;
		
		try {
			
			File archivo;
//			FileInputStream archivoEntrada = null;
			FileOutputStream archivoSalida = null;
			
			
			JFileChooser ventSeleccion = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
			ventSeleccion.setFileFilter(filtro);
			ventSeleccion.setDialogTitle("Guardar Archivo");
	        ventSeleccion.setAcceptAllFileFilterUsed(true); // true: muestra el tambien filtro de todos los tipos de archivos, false : muestra solo el filtro seleccionado
			
			
			/** showDialog(componentePadre, nombreBotonAprobado) -- devuelve un numero que representa la eleccion del usuario.*/
			if(ventSeleccion.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION){
				
				// toString(), transforma el archivo seleccionado en un cadena de la ruta del archivo, a�adiendole el formarto.
				String ruta = ventSeleccion.getSelectedFile().toString().concat(".txt"); 
				archivo = new File(ruta); //archivo = ventSeleccion.getSelectedFile();
				
				String linea = "";
				String data = linea;
				
				linea = w.getWord() + ';' +
						w.getMeaning() + ';' +
						w.getExample() + ';' + 
						w.getImage();
				
				data += linea;
				
				byte[] dataByte = data.getBytes();
				
				archivoSalida = new FileOutputStream(archivo); //<<<
				archivoSalida.write(dataByte); // <<<<
				archivoSalida.close();
				respuesta = 1;
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		}catch (IOException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		}
		
		return respuesta;
	}

	@Override
	public int add(Word w) {
		int respuesta = -1;
		
		FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
		
		try {
			
			fw = new FileWriter("C:/Users/KEVIN/Desktop/file.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
			
			String linea = w.getWord() + ';' +
					w.getMeaning() + ';' +
					w.getExample() + ';' + 
					w.getImage();
			
			pw.println(linea); // <<<
			pw.flush();
			respuesta = 1;
			
		}catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		}catch (IOException e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en la sentencia save() --> " + e.getMessage());
		}finally {
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
			if((linea = br.readLine()) != null) {
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
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = new String();
			while (br.ready()) {
				linea = br.readLine();
				String s[] = linea.split(";");
//				System.out.println("linea:" + linea);
				obj = new Word(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4], s[5], null, Integer.parseInt(s[7]));
//				JF_Main.lista_words.add(obj);
				switch (s[5]) {
				case "g1":JF_Main.lista_words_grupo_01.add(obj);break;
				case "g2":JF_Main.lista_words_grupo_02.add(obj);break;
				case "g3":JF_Main.lista_words_grupo_03.add(obj);break;
				case "g4":JF_Main.lista_words_grupo_04.add(obj);break;
				case "g5":JF_Main.lista_words_grupo_05.add(obj);break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR AL ENCONTRAR EL ARCHIVO - en el metodo readFile(): " + e.getMessage());
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("ERROR en el metodo readFile(): " + e.getMessage());
		}
		System.out.println(">>< SERVICE IMPL - LEYO EL ARCHIVO FILE");
	}


	
}
