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

        // Cria uma nova instancia de Identity(),
        // recebendo uma instancia de IdentityManagerImpl()
        Identity identity = new IdentityManagerImpl();

        // O método LocateRegistry.createRegistry() é usado para criar uma referência do registro local, na porta 4321
        Registry registry = LocateRegistry.createRegistry(4321);

        // O método rebind () é então usado para vincular o nome ao objeto.
        registry.rebind("Identity", identity);
    }
}
