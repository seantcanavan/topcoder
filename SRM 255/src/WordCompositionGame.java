import java.util.HashSet;

public class WordCompositionGame {
	
	public static void main(String args[])
	{
		System.out.println(WordCompositionGame.score(new String[]{"cat", "dog", "pig", "mouse"}, new String[]{"cat", "pig"}, new String[]{"dog", "cat"}));
		System.out.println(WordCompositionGame.score(new String[]{"mouse"}, new String[]{"cat", "pig"}, new String[]{"dog", "cat"}));
		System.out.println(WordCompositionGame.score(new String[]{"dog", "mouse"}, new String[]{"dog", "pig"}, new String[]{"dog", "cat"}));
		System.out.println(WordCompositionGame.score(new String[]{"bcdbb","aaccd","dacbc","bcbda","cdedc","bbaaa","aecae"}, new String[]{"bcdbb","ddacb","aaccd","adcab","edbee","aecae","bcbda"}, new String[]{"dcaab","aadbe","bbaaa","ebeec","eaecb","bcbba","aecae","adcab","bcbda"}));
	}

	public static String score(String[] listA, String[] listB, String[] listC) {
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		HashSet<String> set3 = new HashSet<String>();
		int score1 = 0;
		int score2 = 0;
		int score3 = 0;

		for (String currentString : listA)
			set1.add(currentString);
		for (String currentString : listB)
			set2.add(currentString);
		for (String currentString : listC)
			set3.add(currentString);

		for (String currentString : set1)
			score1 = score1 + WordCompositionGame.calculateScore(set2.contains(currentString), set3.contains(currentString));

		for (String currentString : set2)
			score2 = score2 + WordCompositionGame.calculateScore(set1.contains(currentString), set3.contains(currentString));

		for (String currentString : set3)
			score3 = score3 + WordCompositionGame.calculateScore(set1.contains(currentString), set2.contains(currentString));

		StringBuilder returnThis = new StringBuilder();
		returnThis.append(score1);
		returnThis.append("/");
		returnThis.append(score2);
		returnThis.append("/");
		returnThis.append(score3);
		return returnThis.toString();
	}

	public static int calculateScore(boolean firstVal, boolean secondVal) {
		if (firstVal && secondVal)
			return 1;
		else if (!firstVal && !secondVal)
			return 3;
		else
			return 2;
	}
}
