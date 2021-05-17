import java.util.Random;

public class Dados {
	
	private Random rnd;
	private int num;
	
	public int tirarDados() {
		rnd = new Random();
		num = (int)(rnd.nextDouble() * 6 + 0);
		return num;
	}

}
