import java.util.HashMap;

public class Tablero {

	private HashMap<String, String> tablero;
	
	public Tablero() {
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
	
	public void imprimirTablero() {
		System.out.println("\n    1   2   3");
		System.out.println("A | " + tablero.get("A1") + " | " + tablero.get("A2") + " | " + tablero.get("A3") + " |");
		System.out.println("B | " + tablero.get("B1") + " | " + tablero.get("B2") + " | " + tablero.get("B3") + " |");
		System.out.println("C | " + tablero.get("C1") + " | " + tablero.get("C2") + " | " + tablero.get("C3") + " |");
		System.out.println("\n");
	}
	
	public void jugada(String posición, String ficha) {
		tablero.put(posición, ficha);
	}
	
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
