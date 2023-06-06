package service;

import java.util.List;

import model.Word;

public interface WordService {

	public int save(Word w);
	public int add(Word w);
	public int newCode();
	public List<Word> readFile();
}
