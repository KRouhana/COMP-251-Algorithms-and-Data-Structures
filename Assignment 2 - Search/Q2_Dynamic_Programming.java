import java.util.*;

public class Q2_Dynamic_Programming {

	public static int weight(int[] plates) {


		ArrayList<Integer> list = new ArrayList<Integer>();

		//Copy to array list
		for(int n : plates){
			list.add(n);
		}

		return findTargetSum(list);
	}



	private static int findTargetSum(ArrayList<Integer> plates){

		int currentSum = 0;
		int tempSum = 0;

		//While we are not at 1000 kg
		while(currentSum != 1000 ){

			//If my choice of plates is empty stop
			if(plates.size() == 0) break;

			//Get the next weight
			int currentWeight = plates.remove( 0);

			//Check which is closer to 1000 : the current weight or the sum we have right now
			//If it's the currentWeight, replace the sum with the currentWeight value
			if(evaluatePlate(currentWeight, currentSum)) currentSum = currentWeight;


			//Check for all weights
			for(Integer nextWeight : plates){
				//Sum the currentWeight with the nextWeight
				int nextSum = currentWeight + nextWeight;

				//If the nextSum is closer to 1000 than the current sum, replace the sum with the nextSum
				if(evaluatePlate(nextSum, currentSum)) currentSum = nextSum;

				//If with the last currentWeight and the nextSum is closer to 1000 than the current sum, replace it
				if(evaluatePlate(tempSum + nextSum, currentSum)) currentSum = tempSum + nextSum;
			}

			//keep the last currentWeight
			tempSum = currentWeight;

		}

		return currentSum;
	}


	private static boolean evaluatePlate(int x, int y) {

		//Check which is closer to 1000 in absolute value
		int X = Math.abs(1000-x);
		int Y = Math.abs(1000-y);

		//If X < Y then x is closer to 1000 than y
		if(X < Y) return X < Y;

		//If X == Y then x = y but we need to get the weight further away from 1000, so we return if x > y
		if(X==Y) return x > y;

		//Last case is that X > Y, which means that y is closer to 1000 than x, so return false
		return false;


	}
	
}
