import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;


public class serveur_RMI extends UnicastRemoteObject
implements interface_RMI {

	LinkedList<Integer> listeClients;
	LinkedList<message> listeMessages;
	String message;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	// Implémentation du constructeur
	public serveur_RMI(String msg) throws java.rmi.RemoteException {
	message = msg;
	}
	
	// Implémentation de la méthode distante
	public void sayHello() throws java.rmi.RemoteException {
	System.out.println(message);
	}

	public void connect(int id) throws RemoteException {
		listeClients.add(id);
		//code pour s'assurer que l'id n'est pas déjà pris
	}

	public void send(String msg) throws RemoteException {
		message m = new message(0,msg); //? reccupérer l'id de l'appelant
		listeMessages.add(m);			
	}

	public void bye() throws RemoteException {
		listeMessages.remove(0);//?	reccupérer l'id de l'appelant 
	}

	public void who() throws RemoteException {
		for(int i=0; i<listeClients.size(); i++){
			System.out.println("Client"+ listeClients.get(i) +"est connecte");
		}		
	}
	
		
	//main
		public static void main(String args[]) {
		
		System.out.println("Lancement du serveur");
		
		int port; 
		String URL;
		
		try { // transformation d ’une chaîne de caractères en entier
		Integer I = new Integer(args[0]); port = I.intValue();
		} catch (Exception ex) {
		System.out.println("Please enter: Server <port>"); 
		return;
		}
		try {
		// Création du serveur de nom - rmiregistry
		Registry registry = LocateRegistry.createRegistry(port);
		System.out.println ("Creation du serveur de nom");
		// Création d ’une instance de l’objet serveur
		interface_RMI obj = new serveur_RMI("hello");
		// Calcul de l’URL du serveur
		URL = "//"+ InetAddress.getLocalHost().getHostName()+":"+
		port+"/mon_serveur";
		Naming.rebind(URL, obj);
		} catch (Exception exc) {System.out.println ("Exeption exc serveur");}
		System.out.println ("Serveur lance");
		}
}
