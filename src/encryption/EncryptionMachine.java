package encryption;

public class EncryptionMachine {

	// TODO: Add description for main() method
	public static void main(String[] args) {
		// Create an instance of the EncryptionMachine class
		EncryptionMachine app = new EncryptionMachine();
		
		// Call the method to print the introductory message
		app.printIntroMessage();
		
		// Encrypt a single letter
		// Note that this iteration of encryptSingleLetter shifts 'a' by 3
		System.out.println("Iteration #1 - Single Letter");
		char result = encryptSingleLetter();
		System.out.println("Result of shifting 'a' by 3: " + result);
	}
	
	// TODO: Add description for printIntroMessage() method
	public void printIntroMessage() {
		System.out.println("CSCI 717 Assignment 1 - Encryption Machine");
		System.out.println("This program lets you encrypt a message with a key " +
						   "that your recipient can decrypt.\n");
	}
	
	public static char encryptSingleLetter() {
		// NOTE:
		//   - This iteration of encryptSingleLetter() is to encrypt a fixed single letter
		//     with a fixed shift of 3
		char letter = 'a';
		int shift = 3;
		
		char encryptedLetter = (char)(letter + shift);
		return encryptedLetter;
	}

}
