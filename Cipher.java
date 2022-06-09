/**
 * Program 3b
 * Using Cipher Methods
 * CS108-3
 * 21-Feb-2018
 * @author Jillian Tan
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Cipher {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Usage: Cipher fileToCipher cipherKey 1forEncode/2forDecode");
	
	}
	public static Scanner openInput(String filename) { //Opens input from a file
        Scanner in = null;
        try {
            File infile = new File(filename);
            in = new Scanner(infile);
        }
        catch (FileNotFoundException e)  {
            System.out.println(filename + " could not be found");
          	         }

        return in;
    }
		
	// Use: distance is synonymous with the position in the alphabet of a letter from 'a':  a=0, b=1, c=2, ...  
	// Call:  shiftUpByK(theCharacterInTheMessage, alphabet.indexOf(theCharacterInTheCipherKey)

    public static final int NUM_LETTERS = 26;

    // shifting up for the encoding process
    public char shiftUpByK(char c, int distance) {
        if ('a' <= c && c <= 'z')
            return (char) ('a' + (c - 'a' + distance) % NUM_LETTERS);
        if ('A' <= c && c <= 'Z')
            return (char) ('A' + (c - 'A' + distance) % NUM_LETTERS);
        return c; // don't encrypt if not an alphabetic character
    }

    // shifting down for the decoding process
    public char shiftDownByK(char c, int distance) {
        return shiftUpByK(c, NUM_LETTERS - distance);
    }
}

