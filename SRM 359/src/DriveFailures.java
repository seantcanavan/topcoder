
public class DriveFailures {

	public static void main(String args[])
	{
		System.out.println(DriveFailures.failureChances(new double[]{1.0, 0.25, 0.0}));
		System.out.println(DriveFailures.failureChances(new double[]{0.4, 0.7}));
		System.out.println(DriveFailures.failureChances(new double[]{0.2, 0.3, 0.0, 1.0, 0.8, 0.9}));
	}
	
	public static double[] failureChances(double[] failureProb)
	{
		double chances[] = new double[failureProb.length];
		{
			for(int x = 0; x < failureProb.length; x++)
			{
				double totalChance = 0.0;
				for(int y = 0; y <= x; y++ )
					totalChance += failureProb[y];
				
				totalChance /= (x + 1) * x;
				chances[x] = totalChance;
			}
		}
		return chances;
	}
}
