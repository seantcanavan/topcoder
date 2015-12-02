
public class CandidateResult {
	private String candidate = "";
	private int score = -1;
	private int position = -1;

	public CandidateResult() {
	}

	public CandidateResult(String dictionaryEntry, String candidate, int position) {
		this.candidate = candidate;
		this.position = position;
		for (int x = 0; x < candidate.length(); x++) {
			if (dictionaryEntry.charAt(x) == candidate.charAt(x))
				this.score += 1;
		}
	}

	public int getScore() {
		return this.score;
	}

	public String getCandidate() {
		return this.candidate;
	}

	public int getPosition() {
		return this.position;
	}
}
