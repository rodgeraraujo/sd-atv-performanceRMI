package sd.atv.rmi;

import sd.atv.rmi.interfaces.Identity;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App1 {
    private static String INSTANCE;

    public static void main(String[] args) throws IOException, NotBoundException {

        INSTANCE = "app1";

        Registry registry = LocateRegistry.getRegistry();
        Identity identity = (Identity) registry.lookup("Identity");


//        while (contador == 10)
            int contador = identity.getIdentity(INSTANCE);
        System.out.println(contador);
    }

}
