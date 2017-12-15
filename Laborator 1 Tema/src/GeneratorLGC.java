
public class GeneratorLGC implements IGenerator{

	private int seed;
	
	private int a;
	
	private int m;
	
	private int c;
	
	private int n;

	public GeneratorLGC(int seed, int a, int m, int c) {
		n = 0;
		this.seed = seed;
		this.a = a;
		this.m = m;
		this.c = c;
	}

	@Override
	public float next() {	
		
		int seed2 = (a * seed + c) % m;
		seed = seed2;
		return seed;
	}

}
