package sd.atv.rmi.util;

import sd.atv.rmi.interfaces.Identity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementaçao do IdentityManager
 */
public class IdentityManagerImpl extends UnicastRemoteObject implements Identity {

    int id = 0;

    /**
     * @throws RemoteException
     */
    public IdentityManagerImpl() throws RemoteException {
        super();
    }

    /**
     * @param appName
     * @return retorna um novo identificador
     */
    public synchronized int getIdentity(String appName) {
        return id+1;
    }
}

