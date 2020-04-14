import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {

	public static void main(String args[]) {
		try {
			IMuralImpl recado = new IMuralImpl();
			LocateRegistry.createRegistry(9999);
			Naming.rebind("//localhost:9999/MuralRecado",recado);
			
			System.out.println("Servidor Mural ativo");
			
		}catch(Exception e) {
			System.out.println("Erro de servidor:" + e);
			e.printStackTrace();
		}
	}
}
