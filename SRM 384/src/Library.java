import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Library {
	
	private static final int DOCUMENT_NAME_INDEX = 0;
	private static final int ROOM_INDEX = 1;
	private static final int USER_GROUP_INDEX = 2;

	public static void main(String[] args) {
		System.out.println(Library.documentAccess(new String[]{"diary computers editor","fairytale gardening editor","comix cars author","comix cars librarian"}, new String[]{"employee","editor","author"}, new String[]{"history","cars","computers"}));
		System.out.println(Library.documentAccess(new String[]{"diary computers editor","fairytale gardening editor","comix cars author","comix cars librarian"}, new String[]{"employee","editor","author","librarian"}, new String[]{"history","cars","computers"}));
		System.out.println(Library.documentAccess(new String[]{"diary computers editor","fairytale gardening editor","comix cars author","comix cars librarian"}, new String[]{"employee","editor","author","librarian"}, new String[]{}));
		System.out.println(Library.documentAccess(new String[]{"a b c","a b d","b b c","b b d","e c d","e c b","e c c","t d e"}, new String[]{"c","d","x"}, new String[]{"a","b","c"}));
	}

	public static int documentAccess(String[] records, String[] userGroups, String[] roomRights) {
		ArrayList<LibraryElement> libraryElements = new ArrayList<LibraryElement>();
		HashSet<String> userGroupList = new HashSet<String>();
		HashSet<String> roomRightsList = new HashSet<String>();

		for (int x = 0; x < records.length; x++) {
			String[] currentRecord = records[x].split(" ");
			LibraryElement newElement = new LibraryElement(currentRecord[Library.DOCUMENT_NAME_INDEX],
					currentRecord[Library.ROOM_INDEX], currentRecord[Library.USER_GROUP_INDEX]);
			if (!libraryElements.contains(newElement)) // better to use a HashSet here but overriding hashcode() is harder than overriding equals()
				libraryElements.add(newElement);
		}

		Collections.addAll(userGroupList, userGroups);
		Collections.addAll(roomRightsList, roomRights);

		int recordAccessCount = 0;

		for (LibraryElement currentElement : libraryElements)
			if (currentElement.canAccessElement(userGroupList, roomRightsList))
				recordAccessCount++;

		return recordAccessCount;
	}

}
