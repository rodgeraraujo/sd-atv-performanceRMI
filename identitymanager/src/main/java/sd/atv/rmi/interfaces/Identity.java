package sd.atv.rmi.interfaces;

import java.io.IOException;
import java.rmi.Remote;

/**
 *
 */
public interface Identity extends Remote {

    /**
     * @param appName
     * @return retorna um novo indentificador
     * @throws IOException
     */
    int getIdentity(String appName) throws IOException;

}
