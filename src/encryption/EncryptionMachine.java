package encryption;

import java.util.Scanner;  // Import the Scanner class for user input

/**
 * The main class for the EncryptionMachine application.
 */
public class EncryptionMachine {
	
	// Constants
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static final int SHIFT = 3;

	/**
	 * The entry point of the program.
	 * 
	 * @param args command-line arguments passed to the program
	 */
	public static void main(String[] args) {
		
		// Print the introductory message
		printIntroMessage();
		
		//-- Start the encryption process --//
		
		// Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
		
		// Encrypt the key
		performKeyEncryption(scanner);
		
		// Encrypt the plaintext
		performPlaintextEncryption(scanner);
		
		// Print the ending message
		printEndingMessage();
	}
	
	/**
	 * The method that prints the introductory message.
	 */
	public static void printIntroMessage() {
		System.out.println("CSCI 717 Assignment 1 - Encryption Machine");
		System.out.println("This program lets you encrypt a message with a key " +
						   "that your recipient can decrypt.\n");
	}
	
	/**
	 * The method that prints the ending message.
	 */
	public static void printEndingMessage() {
		System.out.println("Message is fully encrypted!");
		System.out.println("Ending the Encryption Machine.");
	}
	
	/**
	 * The method that encrypts a single letter.
	 * 
	 * @param letter the single plaintext letter to encrypt
	 * @return the single encrypted letter
	 */
	public static char encryptSingleLetter(char letter) {
		
		// First, check if the letter is not a valid lowercase letter in the alphabet.
		// Note that String.indexOf(char) will return -1 if the string does not contain the char.
		if (ALPHABET.indexOf(letter) == -1)
		{
			System.out.println("'" + letter + "' is not a valid lowercase letter in the alphabet.");
			System.out.println("Therefore, not encrypting '" + letter + "'.\n");
			return letter;
		}
		
		// Get the index of ALPHABET that the letter is at
		int originalIndex = ALPHABET.indexOf(letter);
		
		// Now get the index of ALPHABET that the letter is at after applying the SHIFT
		int shiftedIndex = (originalIndex + SHIFT) % ALPHABET.length();
		
		// Finally, return the encrypted letter
		char encryptedLetter = ALPHABET.charAt(shiftedIndex);
		return encryptedLetter;
	}
	
	/**
	 * The method that encrypts a single word.
	 * 
	 * @param word the single plaintext word to encrypt
	 * @return the single encrypted word
	 */
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
	
	/**
	 * The method that asks the user for a key, encrypts it, and prints out the encrypted key.
	 * 
	 * @param scanner the Scanner object used to read the input
	 */
	public static void performKeyEncryption(Scanner scanner) {
		
		// Ask the user to enter a key
		System.out.println("Enter key:");
		String plainTextKey = scanner.nextLine();
		
		// Encrypt the key
		String encryptedKey = encryptSingleWord(plainTextKey);
		
		// Print out the encrypted key
		System.out.println(plainTextKey + " has been encrypted to: " + encryptedKey + "\n");
	}
	
	/**
	 * The method that asks the user for the number of words
	 * and prints out the encrypted ciphertext for each word.
	 * 
	 * @param scanner the Scanner object used to read the input
	 */
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
