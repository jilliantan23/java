package labs6;
import java.util.Scanner;
public class PigLatin {
	private static Scanner scnr;
	public static void main (String[] args){
	     scnr = new Scanner(System.in);
	     String[] words = scnr.nextLine().split(" ");
	     print(translate(words));
	     //print the translations
	  }

	  private static String[] translate(String[] words){
	      for (int i = 0; i < words.length; i++) {
	         String consonants = "";
	         if (words[i].charAt(0) == 'y' || !isVowel(words[i].charAt(0))) {
	            if (words[i].charAt(0) == 'y') {
	               consonants = words[i].substring(0, findFirstVowel(words[i].substring(1))+1);
	               words[i] = words[i].substring(findFirstVowel(words[i].substring(1))+1, words[i].length()) + consonants + "ay";
	            }
	            else {
	               consonants = words[i].substring(0, findFirstVowel(words[i]));
	               words[i] = words[i].substring(findFirstVowel(words[i]), words[i].length()) + consonants + "ay";
	            }
	         }
	         //if word begins with 'y' or a consonant, move beginning consonants to the end and add "ay"
	         else {
	            words[i] += "ay";
	         }
	         
	         //if word begins with a vowel, add "ay"
	      }
	      return words;
	  }

	  private static int findFirstVowel(String s){
	     int checker = -1;
	     for (int i = 0; i < s.length(); i++) {
	        if (isVowel(s.charAt(i))) {
	           checker = i;
	           break;
	        }
	        //count the indexes until first vowel is found
	     }
	     return checker;
	  }
	  
	  private static boolean isVowel(char c){
	     boolean isVowel = false;
	     if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
	        isVowel = true;
	     }
	     return isVowel;
	  }

	  private static void print(String[] words){
	     for (int i = 0; i < words.length; i++) {
	        System.out.println(words[i]);
	  }
	}
	}