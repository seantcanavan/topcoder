import java.util.HashSet;

public class LibraryElement {

	private String documentName;
	private String room;
	private String userGroup;

	public LibraryElement(String documentName, String room, String userGroup) {
		this.documentName = documentName;
		this.room = room;
		this.userGroup = userGroup;
	}

	public boolean canAccessElement(HashSet<String> userGroups, HashSet<String> roomRights) {
		if (roomRights.contains(this.room) && userGroups.contains(this.userGroup))
			return true;
		return false;
	}

	public String getRoom() {
		return this.room;
	}

	public String getDocumentName() {
		return this.documentName;
	}

	@Override
	public boolean equals(Object otherElement) {
		LibraryElement other = (LibraryElement) otherElement;
		if (other.getRoom().compareTo(this.room) == 0 && other.getDocumentName().compareTo(this.documentName) == 0)
			return true;
		else
			return false;
	}

}
