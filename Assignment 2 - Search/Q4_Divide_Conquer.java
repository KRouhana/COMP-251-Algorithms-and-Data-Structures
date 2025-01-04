import java.math.BigInteger;

public class Q4_Divide_Conquer {

	public static String mod_fibonacci(int N, BigInteger K) {

		BigInteger[] fibValues = getNFibonaccies(N);

		while (true) {
			if (N == 1) return "X";
			if (N == 2) return "Y";
			if (K.compareTo(fibValues[N - 2]) <= 0) {

				N = N - 2;

			} else {
				K = K.subtract(fibValues[N - 2]);
				N--;
			}
		}
	}
	private static BigInteger[] getNFibonaccies(int N){

		BigInteger[] nFibo = new BigInteger[N];

		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
		BigInteger c; 
		nFibo[0] = a;
		nFibo[1] = b;
		
		for (int j=2 ; j<N ; j++)
		{
			c =  a.add(b);
			a = b;
			b = c;
			nFibo[j] = c;
		}
		
	return nFibo;
	}
}



