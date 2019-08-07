package sd.atv.rmi.util;

import sd.atv.rmi.interfaces.Identity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class IdentityManagerImpl extends UnicastRemoteObject implements Identity {

    AtomicInteger atomic = new AtomicInteger(0);

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
        // id++;
        // return id;
        return atomic.incrementAndGet();
    }
}

