import java.util.HashMap;

public class Tablero {

	//Almacenar los valores del tablero y sus coordenadas
	private HashMap<String, String> tablero;
	
	public Tablero() {
		//Se inicializa el tablero
		tablero = new HashMap<String, String>();
		tablero.put("A1", "_");
		tablero.put("A2", "_");
		tablero.put("A3", "_");
		tablero.put("B1", "_");
		tablero.put("B2", "_");
		tablero.put("B3", "_");
		tablero.put("C1", "_");
		tablero.put("C2", "_");
		tablero.put("C3", "_");
	}
	
	//Imprime el tablero
	public void imprimirTablero() {
		System.out.println("\n    1   2   3");
		System.out.println("A | " + tablero.get("A1") + " | " + tablero.get("A2") + " | " + tablero.get("A3") + " |");
		System.out.println("B | " + tablero.get("B1") + " | " + tablero.get("B2") + " | " + tablero.get("B3") + " |");
		System.out.println("C | " + tablero.get("C1") + " | " + tablero.get("C2") + " | " + tablero.get("C3") + " |");
		System.out.println("\n");
	}
	
	//Pone los par?metros posici?n(clave) y ficha(valor) en el HashMap tablero
	//sustituyendo los valores anteriores que tuviesen esa clave.
	public void jugada(String posici?n, String ficha) {
		tablero.put(posici?n, ficha);
	}
	
	//Comprueba si el tablero est? lleno o no y devuelve un boolean.
	public boolean tableroLleno() {
		boolean lleno = false;
		if((tablero.get("A1") != "_") && (tablero.get("A2") != "_") && (tablero.get("A3") != "_")) {
			if((tablero.get("B1") != "_") && (tablero.get("B2") != "_") && (tablero.get("B3") != "_")) {
				if((tablero.get("C1") != "_") && (tablero.get("C2") != "_") && (tablero.get("C3") != "_")) {
					lleno = true;
				}
			}
		}
		return lleno;
	}
	
	//Es bastante largo y poco pr?ctico pero no pude hacerlo de otra manera.
	//Se comprueba las diferentes posibilidades de ganar de cada jugador.
	public int ganado() {
		int ganado = 0;
		if((tablero.get("A1").equals("X")) && (tablero.get("A2").equals("X")) && (tablero.get("A3").equals("X"))) {
			ganado = 1;
		}
		if((tablero.get("B1").equals("X")) && (tablero.get("B2").equals("X")) && (tablero.get("B3").equals("X"))) {
			ganado = 1;
		}
		if((tablero.get("C1").equals("X")) && (tablero.get("C2").equals("X")) && (tablero.get("C3").equals("X"))) {
			ganado = 1;
		}
		if((tablero.get("A1").equals("X")) && (tablero.get("C1").equals("X")) && (tablero.get("B1").equals("X"))) {
			ganado = 1;
		}
		if((tablero.get("A2").equals("X")) && (tablero.get("C2").equals("X")) && (tablero.get("B2").equals("X"))) {
			ganado = 1;
		}
		if((tablero.get("A3").equals("X")) && (tablero.get("C3").equals("X")) && (tablero.get("B3").equals("X"))) {
			ganado = 1;
		}
		if((tablero.get("A1").equals("X")) && (tablero.get("B2").equals("X")) && (tablero.get("C3").equals("X"))) {
			ganado = 1;
		}
		if((tablero.get("A3").equals("X")) && (tablero.get("B2").equals("X")) && (tablero.get("C1").equals("X"))) {
			ganado = 1;
		}
		
		
		if((tablero.get("A1").equals("O")) && (tablero.get("A2").equals("O")) && (tablero.get("A3").equals("O"))) {
			ganado = 2;
		}
		if((tablero.get("B1").equals("O")) && (tablero.get("B2").equals("O")) && (tablero.get("B3").equals("O"))) {
			ganado = 2;
		}
		if((tablero.get("C1").equals("O")) && (tablero.get("C2").equals("O")) && (tablero.get("C3").equals("0"))) {
			ganado = 2;
		}
		if((tablero.get("A1").equals("O")) && (tablero.get("C1").equals("O")) && (tablero.get("B1").equals("O"))) {
			ganado = 2;
		}
		if((tablero.get("A2").equals("O")) && (tablero.get("C2").equals("O")) && (tablero.get("B2").equals("O"))) {
			ganado = 2;
		}
		if((tablero.get("A3").equals("O")) && (tablero.get("C3").equals("O")) && (tablero.get("B3").equals("O"))) {
			ganado = 2;
		}
		if((tablero.get("A1").equals("O")) && (tablero.get("B2").equals("O")) && (tablero.get("C3").equals("O"))) {
			ganado = 2;
		}
		if((tablero.get("A3").equals("O")) && (tablero.get("B2").equals("O")) && (tablero.get("C1").equals("O"))) {
			ganado = 2;
		}
		return ganado;
	}
}
