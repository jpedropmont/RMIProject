import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class IMuralImpl extends UnicastRemoteObject implements IMural{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Recado> listRecados;
	
	protected IMuralImpl() throws RemoteException {
		listRecados = new ArrayList<>();
	}
		
	@Override
	public void registrarRecado(Recado recado) throws RemoteException {
		Recado valorRecado = consultarRecado(recado.getCodigo());
		if(valorRecado == null) {
			listRecados.add(recado);
		}else {
			valorRecado.setTexto(recado.getTexto());
			valorRecado.setNome(recado.getNome());			
		}
		
	}

	@Override
	public Recado consultarRecado(int codigo) throws RemoteException {
		for(Recado valorRecado : listRecados) {
			if(valorRecado.getCodigo() == codigo) {
				return valorRecado;
			}
		}
		return null;
	}

	@Override
	public List<Recado> consultarRecados() throws RemoteException {
		return listRecados;
	}

	@Override
	public String removerRecado(Recado recado) throws RemoteException {
		String mensagem = "\n******** recado removido com Sucesso! ********\n";
		listRecados.remove(recado);
		return mensagem;
		
	}

}
