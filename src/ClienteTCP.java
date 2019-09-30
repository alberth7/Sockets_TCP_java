import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
	Socket cliente;
	
	Scanner entrada;
	PrintStream salida;
	
	String host;
	int puerto;
	
	String mensajeSolicitud = "";
	String mensajeRespuesta= "";
	Scanner lectura;
	
	public ClienteTCP(String h, int p) {
		host = h;
		puerto = p;
	}
	
	public void iniciar() {
		try {
			cliente = new Socket(host, puerto);
			Scanner mensajeBienvenida = new Scanner(cliente.getInputStream());
			System.out.println(mensajeBienvenida.nextLine());
			
			salida = new PrintStream(cliente.getOutputStream());
			entrada = new Scanner(cliente.getInputStream());
			
			
			Scanner leer = new Scanner(System.in);
			System.out.println("ingrese n: ");
			mensajeSolicitud =  leer.nextLine();
			salida.println(mensajeSolicitud);
			
			mensajeRespuesta = entrada.nextLine();
			System.out.println(mensajeRespuesta);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			finalizar();
		} finally {
			finalizar();
		}
		
	}

	public void finalizar() {
		try {
			entrada.close();
			salida.close();
			cliente.close();
			System.out.println("conexion finalizada ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
