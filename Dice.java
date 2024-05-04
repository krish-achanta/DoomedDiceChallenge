import java.util.Arrays;

public class Dice
{
    public static int[] afterLokiSpots(int[] dice) 
    {
        int[] loki_Dice = new int[dice.length];

        for (int i = 0; i < dice.length; i++) 
            if (dice[i] > 4) 
                loki_Dice[i] = 4; 
            else 
                loki_Dice[i] = dice[i]; 
			
        return loki_Dice;
    }
	
	public static void main(String[]args)
	{
		
		int[] diceA = {1, 2, 3, 4, 5, 6};			
    	int[] diceB = {1, 2, 3, 4, 5, 6};
        int total_Comb = diceA.length * diceB.length;
		
        System.out.println("\nTotal Combinations: " + total_Comb);
        System.out.println("\nCombinations Distribution:");
		
        int[][] comb_Distribution = new int[diceA.length][diceB.length];
        for (int i = 0; i < diceA.length; i++) 
		{
            for (int j = 0; j < diceB.length; j++) 
			{
                comb_Distribution[i][j] = diceA[i] + diceB[j];
				System.out.print("(" + diceA[i] + "," + diceB[j] + ") ");
    	    }
			System.out.println();
    	}
		
        System.out.println("\nOccurence of Combinations:");
		int[][] Occ = new int[6][6];
        for (int Occ_A : diceA) 
            for (int Occ_B : diceB) 
                Occ[Occ_A - 1][Occ_B - 1]++;

        for (int i = 0; i < 6; i++)
		{	
            for (int j = 0; j < 6; j++) 
                System.out.print(Occ[i][j] + " ");
			System.out.println();
		}
		
        float[] prob_Sums = new float[13]; 
        for (int i = 0; i < diceA.length; i++) 
            for (int j = 0; j < diceB.length; j++) 
                prob_Sums[diceA[i] + diceB[j]]++;

        System.out.println("\nProbability of Sums:");
        for (int sum = 2; sum <= 12; sum++) {
            prob_Sums[sum] /= total_Comb;
            System.out.println("P(Sum = " + sum + ") = " + prob_Sums[sum]);
        }

		System.out.println("\nAfter Loki Dice face position:");

        int[] dice_Loki= Arrays.copyOf(diceA, diceA.length); 
        int[] loki_DiceA = afterLokiSpots(diceA);
        int[] loki_DiceB = Arrays.copyOf(loki_DiceA, loki_DiceA.length); 

        System.out.println("New Dice A: " + Arrays.toString(loki_DiceA));
        System.out.println("New Dice B: " + Arrays.toString(loki_DiceB));

  }
}
