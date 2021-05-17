
public class Jugador extends Main {

	//Almacena el nombre del jugador
	private String nombre;
	//Almacena la ficha asignada al jugador
	private String ficha;
	//Almacena si es el primero en tirar o no
	private boolean primero;
	
	public Jugador() {
		nombre = "";
		ficha = "";
		primero = false;
	}
	
	//Escribe el nombre del jugador
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Obtener el nombre del jugador
	public String getNombre() {
		return nombre;
	}
	
	//Escribir la ficha del jugador
	public void setFicha(String ficha) {
		this.ficha = ficha;
	}
	
	//Obtener la ficha del jugador
	public String getFicha() {
		return ficha;
	}
	
	public void setPrimero(boolean primero) {
		this.primero = primero;
	}
	
	public boolean esPrimero() {
		return primero;
	}
}
