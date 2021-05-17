
public class Jugador extends Main {

	private String nombre;
	private String ficha;
	private boolean primero;
	
	public Jugador() {
		nombre = "";
		ficha = "";
		primero = false;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setFicha(String ficha) {
		this.ficha = ficha;
	}
	
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
