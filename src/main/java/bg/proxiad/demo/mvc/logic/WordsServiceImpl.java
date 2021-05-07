package bg.proxiad.demo.mvc.logic;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class WordsServiceImpl implements WordsService {
	private static final String[] WORDS = { "Penguin", "Goose", "Tortoise", "Anaconda", "Condor", "Antelope",
			"Armadillo", "Turkey", "Eagle", "Beetle", "Boa", "Bonobo", "Owl", "Butterfly", "Camel", "Capybara",
			"Chameleon", "Caracal", "Cheetah", "Chimpanzee", "Chinchilla", "Salamander", "Leopard", "Cobra", "Dolphin",
			"Dragonfly", "Elephant", "Emu", "Flamingo", "Panda", "Giraffe", "Goat", "Sheep", "Gorilla", "Guanaco",
			"Hedgehog", "Hippopotamus", "Hummingbird", "Iguana", "Jaguar", "Kangaroo", "Kiwi", "Koala", "Ladybug",
			"Lemur", "Gecko", "Shark", "Lion", "Lizard", "Orangutan", "Ostrich", "Otter", "Opossum", "Peaflow",
			"Peccary", "Raccon", "Rattlesnake", "Reindeer", "Rhinoceros", "Scorpion", "Crocodile", "Hyena", "Whale" };

	@Override
	public String generateWord() {
		int index = new Random().nextInt(WORDS.length);
		return WORDS[index];
	}
}
