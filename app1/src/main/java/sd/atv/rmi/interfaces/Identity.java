package sd.atv.rmi.interfaces;

import java.rmi.Remote;

public interface Identity extends Remote {

    int getIdentity(String appName);

}
