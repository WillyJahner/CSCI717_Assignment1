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
		
		// Encrypt a single letter
		// Note that this iteration of encryptSingleLetter() encrypts the specified letter in the lowercase alphabet by 3
		System.out.println("Iteration #2 - Parametrized letters");
		for (int i=0; i<ALPHABET.length(); i++)
		{
			char letterToEncrypt = ALPHABET.charAt(i);
			char result = encryptSingleLetter(letterToEncrypt);
			System.out.println("Result of shifting '" + letterToEncrypt + "' by 3: " + result);
		}
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

}
