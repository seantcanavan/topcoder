

public class HuffmanDecoding {
	
	private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String args[])
	{
		System.out.println(HuffmanDecoding.decode("101101", new String[]{"00","10","01","11"}));
		System.out.println(HuffmanDecoding.decode("10111010", new String[]{"0","111","10"}));
		System.out.println(HuffmanDecoding.decode("0001001100100111001", new String[]{"1","0"}));
		System.out.println(HuffmanDecoding.decode("111011011000100110", new String[]{"010","00","0110","0111","11","100","101"}));
		System.out.println(HuffmanDecoding.decode("001101100101100110111101011001011001010", new String[]{"110","011","10","0011","00011","111","00010","0010","010","0000"}));
	}

	public static String decode(String archive, String[] dictionary)
	{
		String leftToDecode = archive;
		String currentlyDecoding = "";
		String decodedMessage = "";
		
		do // do while prevents a second check inside a while loop to check for length of toDecode before adding to decoding
		{
			currentlyDecoding = currentlyDecoding + leftToDecode.substring(0, 1); // grab the first character to work with and add it to 
			leftToDecode = leftToDecode.substring(1, leftToDecode.length()); // remove the first character from what's left to decode
			
			for(int x = 0; x < dictionary.length; x++) // for each string in the dictionary
			{
				if (currentlyDecoding.length() == dictionary[x].length()) // check if the value we have currently matches the length of any of the characters in the dictionary
				{
					if(dictionary[x].compareTo(currentlyDecoding) == 0) // if the lengths are the same compare the contents and if they're the same, decode
					{
						decodedMessage = decodedMessage + HuffmanDecoding.LETTERS.charAt(x);
						currentlyDecoding = "";
						break; // don't check any extra strings than we have to, break on the first hit
					}
				}
			}
		}while(leftToDecode.length() != 0); // while there are characters in the input left to decode
		
		return decodedMessage;
	}
}
