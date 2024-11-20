/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String processedstr1 = preProcess(str1);
		String processedstr2 = preProcess(str2);
		while (processedstr1.length() > 0) {
			int counter = 0;
			if (processedstr2.indexOf(processedstr1.charAt(counter)) == -1)
				return false;
			else {
				processedstr1 = processedstr1.substring(counter);
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String letters = "qwertyuiopasdfghjklzxcvbnm";
		String processedString = "";
		for (int i = 0; i < str.length(); i++) {
			if (letters.indexOf(str.toLowerCase()) > -1) {
				processedString += str.charAt(i);
			}
		}
		return processedString;
	}
	   
	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String remainingStr = str;
		String anagram = "";
		while (remainingStr.length() > 0) {
			int random = (int) (Math.random() * remainingStr.length());
			anagram += remainingStr.charAt(random);
			remainingStr = remainingStr.substring(0, random) + remainingStr.substring(random + 1);
		}
		return anagram;
	}
}