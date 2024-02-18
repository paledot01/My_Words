package model;

import java.util.Date;

public class Word {

	// Atributos
	private String word; // palabra
	private String meaning; // significado
	private String example;
	private String image;
	private String group; //
	private String important; // importancia
	//private Integer number; // cantidad de palabras
	
	// Constructores
	public Word() {}

	public Word(String word, String meaning, String example, String image, String group, String important) {
		super();
		this.word = word;
		this.meaning = meaning;
		this.example = example;
		this.image = image;
		this.group = group;
		this.important = important;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getImportant() {
		return important;
	}

	public void setImportant(String important) {
		this.important = important;
	}

	@Override
	public String toString() {
		return word + ";" + meaning + ";" + example + ";" + image + ";" + group + ";" + important;
	}
	
}
