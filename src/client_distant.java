import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class client_distant extends UnicastRemoteObject{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
    
    public client_distant (int i) throws RemoteException {
	id = i;
	System.out.println("Client distant cree : " + id);
    }	
    
    public void AfficheEtat() throws RemoteException {
	System.out.println("C'est le client distant avec l'état : " + id);
    };   
}