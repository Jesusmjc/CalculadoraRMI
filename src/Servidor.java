import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            int puerto = 8080;
            String servidor = "192.168.56.108";

            System.out.println("Iniciando servidor en:");
            System.out.println("hostname: " + servidor);
            System.out.println("puerto: " + puerto);

            Registry registro = LocateRegistry.createRegistry(puerto);
            System.setProperty("java.rmi.server.hostname", servidor);
            registro.rebind("Calculadora", new CalcRMI());

            System.out.println("Servidor en ejecución en espera de clientes...");
        } catch (RemoteException ex) {
            System.err.println(ex);
        }
    }
}
