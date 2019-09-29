
public class MainClienteTCP {
	public static void main(String[] args) {
		ClienteTCP cliente = new ClienteTCP("127.0.0.1", 5050);
		cliente.iniciar();
	}
}
