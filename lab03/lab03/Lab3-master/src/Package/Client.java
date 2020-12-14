package Package;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private ServerInt serverInt;
    public Client() {
        try {
            Registry registry = LocateRegistry.getRegistry("172.17.0.2",1099);
            serverInt =(ServerInt) registry.lookup("CalcServer");
            System.out.println("[Connected]");
        } catch(NotBoundException | RemoteException e){
            e.printStackTrace();
        }
    }
    public double media(Double[] prices) throws RemoteException {
        return serverInt.media(prices);
    }
    public double desvioP(Double[] prices) throws RemoteException {
        return serverInt.desvioP(prices);
    }
    public double maxValue(Double[] prices) throws RemoteException {
        return serverInt.maxValue(prices);
    }
    public double minValue(Double[] prices) throws RemoteException {
        return serverInt.minValue(prices);
    }
}
