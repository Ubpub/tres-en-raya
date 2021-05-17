
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
	private static EscritorDeArchivos log;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//Se crea un archivo de log
		log = new EscritorDeArchivos();
		//Se inicializan los jugadores
		jugador1 = new Jugador();
		jugador2 = new Jugador();
		//Se inicializa el dado de la clase Dados
		dado = new Dados();
		boolean noEmpate = false;
		//Se pone un nombre a cada jugador
		System.out.print("Jugador 1: ");
		jugador1.setNombre(sc.next());
		System.out.print("Jugador 2: ");
		jugador2.setNombre(sc.next());
		System.out.println("Van a jugar " + jugador1.getNombre() + " y " + jugador2.getNombre());
		log.escribirFichero("Van a jugar " + jugador1.getNombre() + " y " + jugador2.getNombre());
		
		//Tiran los dados para ver quién empieza
		do {
			num1 = dado.tirarDados();
			num2 = dado.tirarDados();
			System.out.println(jugador1.getNombre() + " ha tirado el dado y ha sacado un " + num1);
			log.escribirFichero(jugador1.getNombre() + " ha tirado el dado y ha sacado un " + num1);
			System.out.println(jugador2.getNombre() + " ha tirado el dado y ha sacado un " + num2);
			log.escribirFichero(jugador2.getNombre() + " ha tirado el dado y ha sacado un " + num2);
			if(num1 > num2) {
				jugador1.setPrimero(true);
				System.out.println(jugador1.getNombre() + " va a tirar primero");
				log.escribirFichero(jugador1.getNombre() + " va a tirar primero");
				noEmpate = true;
				//Al jugador que empieza primero se le asigna la ficha X. Al segundo la O.
				jugador1.setFicha("X");
				jugador2.setFicha("O");
				primero = jugador1.getNombre();
				segundo = jugador2.getNombre();
			}
			else if(num2 > num1) {
				jugador2.setPrimero(true);;
				System.out.println(jugador2.getNombre() + " va a tirar primero");
				log.escribirFichero(jugador2.getNombre() + " va a tirar primero");
				noEmpate = true;
				primero = jugador2.getNombre();
				segundo = jugador1.getNombre();
				jugador1.setFicha("O");
				jugador2.setFicha("X");
			}
			//Si hay empate en la tirada, vuelven a tirar
			else {
				System.out.println("Empate. Vuelven a tirar.");
				log.escribirFichero("Ha quedado empate. Vuelven a tirar");
			}
		}while(!noEmpate);
		
		//Se invoca al método juego() donde empieza el juego de Tres en raya
		juego();
	}
	
	public static void juego() {
		Scanner sc = new Scanner(System.in);
		boolean terminado = false;
		String posicion;
		String ganador = "";
		//Se crea el tablero de la clase Tablero
		tablero = new Tablero();
		tablero.imprimirTablero();
		//En este bucle se van intercambiando los turnos dependiendo del número que hayan sacado
		//en los dados, el más mayor empieza y luego se cambia para que el más mayor
		//sea el del segundo, así contínuamente.
		do {
			if(num1 > num2) {
				System.out.print("Escribe la posición, " + jugador1.getNombre() + " : ");
				posicion = sc.next().toUpperCase();
				log.escribirFichero(jugador1.getNombre() + " ha escrito la posición " + posicion);
				tablero.jugada(posicion, jugador1.getFicha());
				num1 = 0;
				num2 = 1;
			}
			else {
				System.out.print("Escribe la posición, " + jugador2.getNombre() + " : ");
				posicion = sc.next().toUpperCase();
				log.escribirFichero(jugador2.getNombre() + " ha escrito la posición " + posicion);
				tablero.jugada(posicion, jugador2.getFicha());
				num2 = 0;
				num1 = 1;
			}
			tablero.imprimirTablero();
			//Se comprueba mediante el método ganador() de la clase Tablero
			//si ha ganado el jugador1. Termina el bucle si se cumple la condición
			if(tablero.ganado() == 1) {
				terminado = true;
				ganador = primero;
			}
			//Comprueba si ha ganado el jugador2 y termina el bucle si es cierto.
			else if(tablero.ganado() == 2) {
				terminado = true;
				ganador = segundo;
			}
			//Se comprueba si el tablero está lleno y no quedan huecos para rellenar. Termina el bucle si
			//se cumple la condición.
			if(tablero.tableroLleno()) {
				terminado = true;
			}
		} while(!terminado);
		if(tablero.ganado() == 0) {
			System.out.println("Ha habido un empate");
			log.escribirFichero("Ha habido un empate");
		}
		else {
			System.out.println("Ha ganado " + ganador);
			log.escribirFichero("Ha ganado " + ganador);
		}
		System.out.println("Juego terminado.");
	}
}
