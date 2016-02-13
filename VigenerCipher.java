//Joe Foley
//2/16/2015
//Project one

import java.util.*;
import java.text.*;
public class VigenerCipher {
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter something you want to encrypt"); //ask for thing they want to encrypt
		String plainText = in.nextLine(); //read
	    System.out.println("Enter a key, that use wish to use to encrypt with"); //ask for word they want to be the key
	    String key = in.nextLine(); //read

        String enc = encrypt(plainText, key);
        System.out.println("encryption: " + enc);  //calling
        System.out.println("Decryption: " + decrypt(enc, key)); //calling
	
	//This does the relative frequencies
        String s = "" + enc ;
        Map<Character, Float> m = new TreeMap<Character, Float>();
        for (char c : s.toCharArray()) {
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else
                m.put(c, 1f);
        }

        for (char c : s.toCharArray()) {
            float freq = (m.get(c)) / s.length();
            System.out.println(c + " " + freq);
        }
	}  
	//encryption
	 static String encrypt(String text, final String key) {
	        String res = "";
	        text = text.toUpperCase();
	        String key1 = key.toUpperCase();
	        for (int i = 0, j = 0; i < text.length(); i++) {
	            char c = text.charAt(i);
	            if (c < 'A' || c > 'Z') continue;
	            res += (char)((c + key1.charAt(j) - 2 * 'A') % 26 + 'A');
	            //System.out.println(res += (char)((c + key1.charAt(j) - 2 * 'A') % 26 + 'A'));
	            j = ++j % key1.length();
	        }
	        return res;
	    }
	 
	 //decryption
	    static String decrypt(String text, final String key) {
	        String res = "";
	        text = text.toUpperCase();
	        String key1 = key.toUpperCase();
	       for (int i = 0, j = 0; i < text.length(); i++) {
	            char c = text.charAt(i);
	            if (c < 'A' || c > 'Z') continue;
	            res += (char)((c - key1.charAt(j) + 26) % 26 + 'A');
	           //System.out.println(res += (char)((c - key1.charAt(j) + 26) % 26 + 'A'));
	            j = ++j % key.length();
	        }
	        return res;
	    }
	
	    
}

