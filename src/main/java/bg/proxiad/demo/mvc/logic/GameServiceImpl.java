package bg.proxiad.demo.mvc.logic;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
	public static final char[] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	
	@Autowired
	private WordsService wordsService;
	
	private Map<String, Game> games = new ConcurrentHashMap<>();
	
	@Override
	public Game createGame() {
		Game game = new Game();
		game.setId(UUID.randomUUID().toString());
		game.setWord(wordsService.generateWord());
		initGame(game);
		games.put(game.getId(), game);
		return game;
	}
	
	@Override
	public Game getGame(String id) {
		return games.get(id);
	}
	
	private void initGame(Game game) {
		String word = game.getWord();
		char fc = word.charAt(0);
		char lc = word.charAt(word.length() -1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char current = word.charAt(i);
			char c = current == fc || current == lc ? current : '.';
			sb.append(c);
		}
		game.setMaskedWord(sb.toString());
		
		
		Set<Character> letters = new TreeSet<Character>();
		for (char c : ALPHABET) {
			letters.add(c);
		}
		letters.remove(fc);
		letters.remove(lc);
		game.setLettersLeft(letters);
	}
}
