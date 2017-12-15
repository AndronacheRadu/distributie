import java.util.ArrayList;
import java.util.List;

public class GeneratorMiddleSquare implements IGenerator {

	private Integer seed;
	
	private int lenghtOfSeed;
	
	private  int[] arrayOfNumbers = new int[10000];
	
	private int iterratorOfArray = 0;
	
	public GeneratorMiddleSquare(int seed) {
		this.seed = (int) seed;
	}
	
	@Override
	public float next() {
		return (float) (calculateMidOfNumber()/Math.pow(10, calculateLenghtOfNumber(seed)));	
	}

	private int calculateLenghtOfNumber(int n){
		return new Integer(n).toString().length();
	}
	
	private int calculateMidOfNumber(){
		int number = seed * seed;
		int lenght = calculateLenghtOfNumber(number);
		number = (int) (number /  Math.pow((double)10, (double)(lenght/(lenght / 2))));
		int number2 = (int) (number % Math.pow((double)10, (double)lenght/2));
		if(calculateLenghtOfNumber(number2) < calculateLenghtOfNumber(seed)) {
			number2 = modifyLenght(number2);
		}
//		number2 = checkIfNumberIsUnic(number2);
		
		seed = number2;
		
		return seed;
	}

	private int checkIfNumberIsUnic(int number2) {
		for (int i = 0; i <= iterratorOfArray; i++) {
			if(number2 == arrayOfNumbers[i]) {
				number2 ++;
			}
		}
		arrayOfNumbers[iterratorOfArray] = number2;
		if(iterratorOfArray < 10000) iterratorOfArray++;
		return number2;
	}

	private int modifyLenght(int number2) {
		while(calculateLenghtOfNumber(number2) < calculateLenghtOfNumber(seed)) {
			number2 = number2 * 10 + 1;
		}
		return number2;
	}			
}
