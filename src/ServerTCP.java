import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTCP {

	ServerSocket servidor;
	Socket cliente;
	int puerto;
	
	PrintStream salida;
	Scanner entrada;
	
	String mensajeSolicitud = " ";
	String mensajeRespuesta = " ";
	
	public ServerTCP(int p) {
		puerto = p;
	}
	
	public void iniciar() {
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("*** Servidor TCP iniciado***");
			System.out.println("... espertando al cliente");
			
			while(true) {
				cliente = servidor.accept();
				PrintStream mensajeBienvenida = new PrintStream(cliente.getOutputStream());
				mensajeBienvenida.println(" ***** Bienvenido al Programa FIBONACCI  ****");
				
				//esperando un mensaje
				entrada = new Scanner(cliente.getInputStream());
				salida = new PrintStream(cliente.getOutputStream());
				// mensaje solicitud en este caso n del fibo
				int n = Integer.parseInt(entrada.nextLine());
				
				mensajeRespuesta = "Respuesta del Servidor: " + fibo(n) ; 
				salida.println(mensajeRespuesta);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			finalizar();
		}finally {
			finalizar();
		}
	}

	private String fibo(int n) {
		String resultado = "";
		int a = -1, b = 1,f = 0, c = 0;
		while (c < n) {
			f = a + b;
			resultado =  resultado + f+", ";
			a = b;
			b = f;
			c++;
		}
		return resultado;
	}

	public void finalizar() {	
		try {
			salida.close();
			entrada.close();
			servidor.close();
			cliente.close();
			System.out.println("conexion finalizada.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
