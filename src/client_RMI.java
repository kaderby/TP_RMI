import java.rmi.*;

public class client_RMI {
	
	public void connect(int id) throws RemoteException {
		try {
			// Récupération d'un stub sur l'objet serveur.
			System.out.println("Recuperation d'un stub sur l'objet serveur");
			interface_RMI obj = (interface_RMI) Naming.lookup("//ma_machine/mon_serveur");
			// Appel d'une méthode sur l'objet distant.
			System.out.println("Appel de connect sur l'objet distant");
			obj.connect(id);
			} catch (Exception exc) {System.out.println ("Exeption exc client");}
			System.out.println ("Connect lance");
	}

	public void send(String msg) throws RemoteException {
		try {
			// Récupération d'un stub sur l'objet serveur.
			System.out.println("Recuperation d'un stub sur l'objet serveur");
			interface_RMI obj = (interface_RMI) Naming.lookup("//ma_machine/mon_serveur");
			// Appel d'une méthode sur l'objet distant.
			System.out.println("Appel de la methode send sur l'objet distant");
			obj.send(msg);
			} catch (Exception exc) {System.out.println ("Exeption exc client");}
			System.out.println ("Send lance");		
	}

	public void bye() throws RemoteException {
		try {
			// Récupération d'un stub sur l'objet serveur.
			System.out.println("Recuperation d'un stub sur l'objet serveur");
			interface_RMI obj = (interface_RMI) Naming.lookup("//ma_machine/mon_serveur");
			// Appel d'une méthode sur l'objet distant.
			System.out.println("Appel de la methode sur l'objet distant");
			obj.bye();
			} catch (Exception exc) {System.out.println ("Exeption exc client");}
			System.out.println ("Bye lance");		
	}

	public void who() throws RemoteException {
		try {
			// Récupération d'un stub sur l'objet serveur.
			System.out.println("Recuperation d'un stub sur l'objet serveur");
			interface_RMI obj = (interface_RMI) Naming.lookup("//ma_machine/mon_serveur");
			// Appel d'une méthode sur l'objet distant.
			System.out.println("Appel de la methode who sur l'objet distant");
			obj.who();
			} catch (Exception exc) {System.out.println ("Exeption exc client");}
			System.out.println ("who lance");		
	}	
}