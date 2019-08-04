package sd.atv.rmi;

import sd.atv.rmi.interfaces.Identity;
import sd.atv.rmi.util.IdentityManagerImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Identity MAnager Server
 */
public class Servidor {
    public static void main(String[] args) throws RemoteException {

        System.out.println("Executando servidor...");

        // Cria uma nova instancia de Identity(),
        // recebendo uma instancia de IdentityManagerImpl()
        Identity identity = new IdentityManagerImpl();

        // O método LocateRegistry.createRegistry() é usado para criar uma referência do registro local, na porta 1099
        Registry registry = LocateRegistry.createRegistry(1099);

//        System.out.println(LocateRegistry.getRegistry());

        // O método rebind() é então usado para vincular o nome ao objeto.
        registry.rebind("identity", identity);

    }
}
