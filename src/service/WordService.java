package service;

import java.nio.file.Path;

import model.Word;

public interface WordService {

	public int save22(Word w);
	public int save();
	public int export();
	public int addWord(Word w, Path pathImageOrigin);
	public int newCode();
	public void readFile();
}
