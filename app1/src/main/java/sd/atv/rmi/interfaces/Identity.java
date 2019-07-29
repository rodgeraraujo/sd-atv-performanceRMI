package sd.atv.rmi;

import java.rmi.Remote;

public interface Identity extends Remote {

    int getIdentity(String appName);

}
