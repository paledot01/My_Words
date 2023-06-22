package model;

import java.util.Date;

public class Word {

	// Atributos
	private Integer id;
	private String word; // palabra
	private String meaning; // significado
	private String example;
	private String image;
	//private Integer number; // cantidad de palabras
	private String grupo; //
	private Date date;
	
	// Constructores
	public Word() {}
	
	// CON ID
	public Word(Integer id, String word, String meaning, String example, String image, String grupo, Date date) {
		super();
		this.id = id;
		this.word = word;
		this.meaning = meaning;
		this.example = example;
		this.image = image;
		this.grupo = grupo;
		this.date = date;
	}

	// SIN ID
	public Word(String word, String meaning, String example, String image, String grupo, Date date) {
		super();
		this.word = word;
		this.meaning = meaning;
		this.example = example;
		this.image = image;
		this.grupo = grupo;
		this.date = date;
	}

	// Metodos get-set
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	// Metodo TO STRING
	@Override
	public String toString() {
		return "Word [id=" + id + ", word=" + word + ", meaning=" + meaning + ", example=" + example + ", image="
				+ image + ", grupo=" + grupo + ", date=" + date + "]";
	}
	
	
	
	
	
	
}
