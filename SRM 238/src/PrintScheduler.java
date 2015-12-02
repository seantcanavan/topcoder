import java.util.ArrayList;

public class PrintScheduler {
	
	private static final int THREAD_NUMBER_INDEX = 0;
	private static final int THREAD_TIME_INDEX = 1;

	public static void main(String[] args) {
		System.out.println(PrintScheduler.getOutput(new String[]{"AB","CD"} , new String[]{"0 1","1 1","0 1","1 2"} ));
		System.out.println(PrintScheduler.getOutput(new String[]{"ABCDE"} , new String[]{"0 20","0 21"} ));
		System.out.println(PrintScheduler.getOutput(new String[]{"A","B"} , new String[]{"1 10","0 1","1 10","0 2"} ));
		System.out.println(PrintScheduler.getOutput(new String[]{"A"} , new String[]{"0 1"} ));
	}

	public static String getOutput(String[] threads, String[] slices) {
		ArrayList<CircularArrayList<Character>> circularLists = new ArrayList<CircularArrayList<Character>>();
		StringBuilder sb = new StringBuilder();

		for (int x = 0; x < threads.length; x++)
			circularLists.add(new CircularArrayList<Character>());

		for (int x = 0; x < threads.length; x++)
			for (int y = 0; y < threads[x].length(); y++)
				circularLists.get(x).add(threads[x].charAt(y));

		for (int x = 0; x < slices.length; x++) {
			String threadPieces[] = slices[x].split(" ");
			int threadNumber = Integer.valueOf(threadPieces[PrintScheduler.THREAD_NUMBER_INDEX]);
			int threadTime = Integer.valueOf(threadPieces[PrintScheduler.THREAD_TIME_INDEX]);

			for (int y = 0; y < threadTime; y++) {
				sb.append(circularLists.get(threadNumber).getNext());
			}
		}
		return sb.toString();
	}
}
