package com.company;
import java.security.KeyException;
import java.util.Random;

public class Main{
	public static String generateString(Random rng, String characters, int length)
	{
		char[] text = new char[length];
		for (int i = 0; i < length; i++)
		{
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

    public static void main(String[] args) throws KeyException {
		MyCollection <Integer, String> collection = new MyCollection<>();
		for(int i = 0; i < 10000; i++){
			collection.put(generateString(new Random(), "abcdefg", 10), i);
		}
		System.out.println(collection.get(1));
		System.out.println(collection.get(4));
		System.out.println(collection.get(6666));
    }
}
