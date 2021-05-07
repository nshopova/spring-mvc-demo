package bg.proxiad.demo.mvc.logic;

import java.util.Set;

public class Game {
	private String id;
	private String word;
	private String maskedWord;
	private Set<Character> lettersLeft;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMaskedWord() {
		return maskedWord;
	}
	public void setMaskedWord(String maskedWord) {
		this.maskedWord = maskedWord;
	}
	public Set<Character> getLettersLeft() {
		return lettersLeft;
	}
	public void setLettersLeft(Set<Character> lettersLeft) {
		this.lettersLeft = lettersLeft;
	}
}
