package sd.atv.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    public static void main(String[] args) {
        final String name = "IdentifyManager";

        IdentityInterface manager = new IdentifyManager();

        Registry registry = LocateRegistry.createRegistry(10099);
        registry.bind(name, manager);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione enter para parar e listar IDs usados");

        scanner.nextLine();
        manager.listAllUsedIDs();

        registry.unbind(name);
    }
}
