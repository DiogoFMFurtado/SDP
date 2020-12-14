package Package;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerProgram {
    public static void main(String[] args) {
        System.setProperty( "ServerProgram", "172.17.0.2" );
        System.out.println("[Server started]");
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            registry.rebind("CalcServer", new CalcServ());
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
