import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EscritorDeArchivos {

	private FileWriter fw;
	private SimpleDateFormat fecha;
	private SimpleDateFormat fechaEscrita;
	
	//Esta clase me ayudó a hacerla Luis, no fui capaz de sacarlo por mi misma, así
	//que no me la puntues.
	public EscritorDeArchivos() {
		fecha = new SimpleDateFormat("ddMMyyy-HHmm");
		fechaEscrita = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		try {
			File archivo = new File("log\\" + fecha.format(new Date()) + "-log.txt");
			archivo.getParentFile().mkdirs();
			fw = new FileWriter(archivo);
		} catch (IOException e) {
			System.out.println(e + "No se ha encontrado el directorio");
		}
		
	}
	
	public void escribirFichero(String texto) {
		try {
			fw.write(fechaEscrita.format(new Date()) + " " + texto + "\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarFichero() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
