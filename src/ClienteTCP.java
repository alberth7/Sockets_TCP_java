import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
	Socket cliente;
	
	
	
	String host;
	int puerto;
	
	
	public ClienteTCP(String h, int p) {
		host = h;
		puerto = p;
	}
	
	public void iniciar() {
		try {
			cliente = new Socket(host, puerto);
			Scanner mensajeBienvenida = new Scanner(cliente.getInputStream());
			System.out.println(mensajeBienvenida.nextLine());
			
		} catch (Exception e) {
			e.printStackTrace();
			finalizar();
		} finally {
			finalizar();
		}
		
	}

	public void finalizar() {
		try {
		
			cliente.close();
			System.out.println("conexion finalizada ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
