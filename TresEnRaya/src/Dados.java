import java.util.Random;

public class Dados {
	
	//Variable para utilizar la clase Random
	private Random rnd;
	//Almacena el número random conseguido
	private int num;
	
	//Se almacena un número random del 1 al 6 en una variable y la devuelve.
	public int tirarDados() {
		rnd = new Random();
		num = (int)(rnd.nextDouble() * 6 + 0);
		return num;
	}

}
