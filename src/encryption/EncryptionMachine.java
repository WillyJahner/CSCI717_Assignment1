package encryption;

import java.util.Scanner;  // Import the Scanner class for user input

public class EncryptionMachine {
	
	// Constants
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	// TODO: Add description for main() method
	public static void main(String[] args) {
		
		// Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
		
		// Print the introductory message
		printIntroMessage();
		
		//-- Start the encryption process --//
		
		// Encrypt the key
		performKeyEncryption(scanner);
		
		// Encrypt the plaintext
		performPlaintextEncryption(scanner);
		
		// Print the ending message
		printEndingMessage();
	}
	
	// TODO: Add description for printIntroMessage() method
	public static void printIntroMessage() {
		System.out.println("CSCI 717 Assignment 1 - Encryption Machine");
		System.out.println("This program lets you encrypt a message with a key " +
						   "that your recipient can decrypt.\n");
	}
	
	// TODO: Add description for printEndingMessage() method
	public static void printEndingMessage() {
		System.out.println("Message is fully encrypted!");
		System.out.println("Ending the Encryption Machine.");
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
	
	// TODO: Add description for performKeyEncryption() method
	public static void performKeyEncryption(Scanner scanner) {
		
		// Ask the user to enter a key
		System.out.println("Enter key:");
		String plainTextKey = scanner.nextLine();
		
		// Encrypt the key
		String encryptedKey = encryptSingleWord(plainTextKey);
		
		// Print out the encrypted key
		System.out.println(plainTextKey + " has been encrypted to: " + encryptedKey + "\n");
	}
	
	public static void performPlaintextEncryption(Scanner scanner) {
		
		// Ask the user for the number of words in their message
		System.out.println("How many words are in your message?");
		int numWords = scanner.nextInt();
		scanner.nextLine(); // Advance the scanner to the next line
		
		// Read in that many words and		
		// Print out the encrypted ciphertext for each word
		for (int i=0; i<numWords; i++)
		{
			if (i == 0)
			{
				System.out.println("Enter the first word:");
			}
			else
			{
				System.out.println("Enter the next word:");
			}
			String plainTextWord = scanner.nextLine();
			
			// Encrypt the plaintext word
			String encryptedWord = encryptSingleWord(plainTextWord);
			
			// Print out the encrypted word
			System.out.println(plainTextWord + " has been encrypted to: " + encryptedWord + "\n");
		}
	}

}
