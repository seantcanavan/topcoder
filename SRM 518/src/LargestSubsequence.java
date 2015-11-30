
public class LargestSubsequence {

	public static void main(String args[]) {
		System.out.println(LargestSubsequence.getLargest("test"));
		System.out.println(LargestSubsequence.getLargest("a"));
		System.out.println(LargestSubsequence.getLargest("example"));
		System.out.println(LargestSubsequence.getLargest("aquickbrownfoxjumpsoverthelazydog"));
	}

	public static String getLargest(String s) {
		StringBuffer result = new StringBuffer();
		char currentHighest = 'a';

		for (int x = s.length() - 1; x >= 0; x--) {
			char currentChar = s.charAt(x);
			if (currentChar >= currentHighest) {
				result.append(currentChar);
				currentHighest = currentChar;
			}
		}
		return result.reverse().toString();
	}
}
