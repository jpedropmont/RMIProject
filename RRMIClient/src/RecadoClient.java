import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;


public class RecadoClient {
	
	
	public static void main(String arg[]) {
		try {
			IMural mural = (IMural) Naming.lookup("//localhost:9999/MuralRecado");
			Recado recadoJoaoPedro = new Recado(25,"Bom dia, Vitor. Aula online normal hoje ?", "João Pedro Bandeira");		
			mural.registrarRecado(recadoJoaoPedro);
			
			Recado recadoVitor = new Recado(30,"Bom dia, João. Sim, aula normal.", "Victor");
			mural.registrarRecado(recadoVitor);
			
			
			Recado novoRecadoVitor = new Recado(30,"Bom dia, João. Desculpe, mas não poderei dar aula hoje. Estou deletando a mensagem anterior", "Victor");
			mural.registrarRecado(novoRecadoVitor);
			
			System.out.println(mural.removerRecado(recadoVitor));
			
			List<Recado> recados = mural.consultarRecados();
			
			for(Recado cont: recados)
				System.out.println(cont.getNome() + " " + cont.getTexto());
			
		}catch(Exception e) {
			System.out.println("Client exception: " + e.getMessage());
		}
	}
}
