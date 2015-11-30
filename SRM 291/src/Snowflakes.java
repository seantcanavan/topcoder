import java.util.ArrayList;
import java.util.Arrays;

public class Snowflakes {

	public static void main(String args[]) {
		System.out.println(Arrays.toString(Snowflakes.flareOut(new String[] { ".", "..", "*.*" })));
		System.out.println(Arrays.toString(Snowflakes.flareOut(new String[] { "*", "..", ".*.", ".**.", ".*.**" })));
		System.out.println(Arrays.toString(Snowflakes.flareOut(new String[] { ".", "..", "***" })));
		System.out.println(Arrays.toString(Snowflakes.flareOut(new String[] { "*", ".*", "***" })));
		System.out.println(Arrays.toString(Snowflakes.flareOut(new String[] { ".", "..", "***", "...." })));
	}

	public static String[] flareOut(String[] snowflake) {
		int height = snowflake.length;
		ArrayList<ArrayList<String>> snowflakepieces = new ArrayList<ArrayList<String>>();

		for (int x = 0; x < height; x++)
			snowflakepieces.add(new ArrayList<String>());

		for (int x = 0; x < height; x++)
			snowflakepieces.get(x).add(snowflake[x]);

		// add each element from the back one at a time to each row in the flake
		// this reverses the triangle pattern and creates a square
		int counter = snowflake.length - 1;
		for (ArrayList<String> currentRow : snowflakepieces) {
			currentRow.add(snowflake[counter]);
			counter -= 1;
		}

		for (ArrayList<String> currentList : snowflakepieces) // for each row of pieces
		{
			ArrayList<String> reversed = new ArrayList<String>();
			for (String currentValue : currentList)
				reversed.add(currentValue);

			for (String currentValue : reversed) // add the reverse to the front of each list
				currentList.add(0, currentValue); // this is terrible for ArrayLists
		}

		// the final operation undoes the first fold which cuts the paper in half
		// so height needs to be doubled - we'll just add each element twice from our lists
		// we'll need to add from the end to the beginning to mirror the bottom-top fold behavior

		ArrayList<String> finalSnowFlake = new ArrayList<String>();

		for (int x = snowflakepieces.size() - 1; x >= 0; x--) {
			ArrayList<String> currentList = snowflakepieces.get(x);
			for (String currentPiece : currentList)
				finalSnowFlake.add(currentPiece);
		}

		for (ArrayList<String> currentList : snowflakepieces)
			for (String currentPiece : currentList)
				finalSnowFlake.add(currentPiece);
		return finalSnowFlake.toArray(new String[finalSnowFlake.size()]);
	}
}