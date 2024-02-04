package service;

import model.Word;

public interface WordService {

	public int save(Word w);
	public int add(Word w);
	public int newCode();
	public void readFile();
}
