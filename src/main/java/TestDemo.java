import java.util.Random;

/**
 * 
 */

/**
 * @author hmack
 *
 */
public class TestDemo {

	public int addPositive(int a, int b) {
		
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive.");
		}
	}
	
	int randomNumberedSquared() {
		return getRandomInt() * getRandomInt();
	}

	/**
	 * 
	 */
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
		
	}
	
}
