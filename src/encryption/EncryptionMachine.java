package encryption;

public class EncryptionMachine {
	
	// Constants
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	// TODO: Add description for main() method
	public static void main(String[] args) {
		// Create an instance of the EncryptionMachine class
		EncryptionMachine app = new EncryptionMachine();
		
		// Call the method to print the introductory message
		app.printIntroMessage();
		
		// Encrypt a single word
		// Note that this iteration of encryptSingleWord() encrypts each character of the specified word by 3
		System.out.println("Iteration #3 - Single word");
		String wordToEncrypt = ALPHABET;
		String encryptedWord = encryptSingleWord(wordToEncrypt);
		System.out.println(" Original Word: " + wordToEncrypt);
		System.out.println("Encrypted Word: " + encryptedWord);
	}
	
	// TODO: Add description for printIntroMessage() method
	public void printIntroMessage() {
		System.out.println("CSCI 717 Assignment 1 - Encryption Machine");
		System.out.println("This program lets you encrypt a message with a key " +
						   "that your recipient can decrypt.\n");
	}
	
	// TODO: Add description for encryptSingleLetter() method
	public static char encryptSingleLetter(char letter) {
		// NOTE:
		//   - This iteration of encryptSingleLetter() is to encrypt any letter in the lowercase alphabet
		//     with a fixed shift of 3
		int shift = 3;
		
		// First, check if the letter is not a valid lowercase letter in the alphabet.
		// Note that String.indexOf(char) will return -1 if the string does not contain the char.
		if (ALPHABET.indexOf(letter) == -1)
		{
			// TODO: Do we want to throw an exception?
			// For now, just return the letter unchanged
			return letter;
		}
		
		// Get the index of ALPHABET that the letter is at
		int originalIndex = ALPHABET.indexOf(letter);
		
		// Now get the index of ALPHABET that the letter is at after applying the shift
		int shiftedIndex = (originalIndex + shift) % ALPHABET.length();
		
		// Finally, return the encrypted letter
		char encryptedLetter = ALPHABET.charAt(shiftedIndex);
		return encryptedLetter;
	}
	
	// TODO: Add description for encryptSingleWord() method
	public static String encryptSingleWord(String word) {
		
		// Instantiate a character array that will hold each encrypted character from the single word
		char[] encryptedChars = new char[word.length()];
		
		// Encrypt each letter in the word
		for (int i=0; i<word.length(); i++)
		{
			encryptedChars[i] = encryptSingleLetter(word.charAt(i));
		}
		
		// Concatenate all characters from the character array into a final String to return
		String encryptedWord = new String(encryptedChars);
		return encryptedWord;
	}

}
