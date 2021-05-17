
import java.util.Scanner;

public class Main {
	
	private static Dados dado;
	private static Jugador jugador1;
	private static Jugador jugador2;
	private static Tablero tablero;
	private static int num1;
	private static int num2;
	private static String primero;
	private static String segundo;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		dado = new Dados();
		boolean noEmpate = false;
		System.out.print("Jugador 1: ");
		jugador1.setNombre(sc.next());
		System.out.print("Jugador 2: ");
		jugador2.setNombre(sc.next());
		System.out.println("Van a jugar " + jugador1.getNombre() + " y " + jugador2.getNombre());
		
		do {
			num1 = dado.tirarDados();
			num2 = dado.tirarDados();
			System.out.println(jugador1.getNombre() + " ha tirado el dado y ha sacado un " + num1);
			System.out.println(jugador2.getNombre() + " ha tirado el dado y ha sacado un " + num2);
			if(num1 > num2) {
				jugador1.setPrimero(true);
				System.out.println(jugador1.getNombre() + " va a tirar primero");
				noEmpate = true;
				jugador1.setFicha("X");
				jugador2.setFicha("O");
				primero = jugador1.getNombre();
				segundo = jugador2.getNombre();
			}
			else if(num2 > num1) {
				jugador2.setPrimero(true);;
				System.out.println(jugador2.getNombre() + " va a tirar primero");
				noEmpate = true;
				primero = jugador2.getNombre();
				segundo = jugador1.getNombre();
				jugador1.setFicha("O");
				jugador2.setFicha("X");
			}
			else {
				System.out.println("Empate. Vuelven a tirar.");
			}
		}while(!noEmpate);
		
		juego();
	}
	
	public static void juego() {
		Scanner sc = new Scanner(System.in);
		boolean terminado = false;
		String posicion;
		String ganador = "";
		tablero = new Tablero();
		tablero.imprimirTablero();
		do {
			if(num1 > num2) {
				System.out.print("Escribe la posición, " + jugador1.getNombre() + " : ");
				posicion = sc.next().toUpperCase();
				tablero.jugada(posicion, jugador1.getFicha());
				num1 = 0;
				num2 = 1;
			}
			else {
				System.out.print("Escribe la posición, " + jugador2.getNombre() + " : ");
				posicion = sc.next().toUpperCase();
				tablero.jugada(posicion, jugador2.getFicha());
				num2 = 0;
				num1 = 1;
			}
			tablero.imprimirTablero();
			if(tablero.ganado() == 1) {
				terminado = true;
				ganador = primero;
			}
			else if(tablero.ganado() == 2) {
				terminado = true;
				ganador = segundo;
			}
			if(tablero.tableroLleno()) {
				terminado = true;
			}
		} while(!terminado);
		if(tablero.ganado() == 0) {
			System.out.println("Ha habido un empate");
		}
		else {
			System.out.println("Ha ganado " + ganador);
		}
		System.out.println("Juego terminado.");
	}
}
