
public class GrafixCorrupt {

	public static void main(String[] args) {
		System.out.println(GrafixCorrupt.selectWord(new String[]{"cat", "cab", "lab"} , "dab"));
		System.out.println(GrafixCorrupt.selectWord(new String[]{"cat", "cab", "lab"} , "lag"));
		System.out.println(GrafixCorrupt.selectWord(new String[]{"cat", "cab", "lab"} , "bic"));
		System.out.println(GrafixCorrupt.selectWord(new String[]{"zkv", "izs", "fed", "waa", "ttx", "bgt", "quy", "dtq", "dgo", "yrs", "cid", "nln", "pvz", "txt", "zun", "erd", "jen", "klh", "kxy", "emf", "mqt", "lza", "dzb", "ndx", "vfr", "jhs", "dkm", "elb"} , "cwd" ));
		System.out.println(GrafixCorrupt.selectWord(new String[]{"zhadjsg", "vzptftx", "fbaslxs", "ejejncm", "xpxkeae", "ixrrtzw", "ovctbzx", "sfzekhh", "lxzixjk", "jixdpik", "bkianck", "laclyin", "uqmdkfx", "dimswqo", "fojhetr", "grntrce", "obdtqwx", "bhojwcy", "zuuuvst", "mvqtoly", "aftmupx", "govuidx", "qklpret", "yptccki", "uxdnslh", "wudrusz", "uwxbvou", "ouytqun", "pjdexqe", "xraaqdw", "lxmoncl", "sjnjfgb", "qrlqgvc", "fgvoadm", "yohsrxw", "udpvrsr", "mklucgt"} , "vklikgf" ));
	}

	public static int selectWord(String[] dictionary, String candidate) {
		CandidateResult highestResult = new CandidateResult();

		for (int x = dictionary.length - 1; x >= 0; x--) {
			CandidateResult newResult = new CandidateResult(dictionary[x], candidate, x);
			if (highestResult.getScore() <= newResult.getScore() && newResult.getScore() != -1)
				highestResult = newResult;
		}
		return highestResult.getPosition();
	}
}
