import java.util.Random;

public class DefaultGenerator implements IGenerator{

	Random rnd = new Random();
	
	@Override
	public float next() {
		return (Float.valueOf(rnd.nextInt(1000) + 1)) / 1000 ;
	}

}
