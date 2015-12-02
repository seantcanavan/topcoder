
public class PrimeSoccer {

	private static final double rounds = 90/5; // the number of "rounds" we roll the dice in ninety minutes. it equals 18.
	private static final double[] PRIMES = {2, 3, 5, 7, 11, 13, 17};
	
	public static void main(String[] args) {
		System.out.println(PrimeSoccer.getProbability(50, 50));
		System.out.println(PrimeSoccer.getProbability(100, 100));
		System.out.println(PrimeSoccer.getProbability(12 ,89 ));
	}

	static double getProbability(int skillOfTeamA, int skillOfTeamB)
	{
		// there are 18 rounds possible
		// the number of prime numbers between 1 and 18 is 7: 2, 3, 5, 7, 11, 13, 17,
		// todo: reduce these equations to their binomial distribution equivalents in n^k / k! notation
		
		double probabilityA = 0;
		double probabilityB = 0;
		
		for(int x = 0; x < PRIMES.length; x++)
		{
			probabilityA += (skillOfTeamA / 100.0) * (PrimeSoccer.PRIMES[x] / PrimeSoccer.rounds);
		}
		
		for(int y = 0; y < PRIMES.length; y++)
		{
			probabilityB += (skillOfTeamB / 100.0) * (PrimeSoccer.PRIMES[y] / PrimeSoccer.rounds);
		}
		
		return probabilityA + probabilityB;
	}
}
