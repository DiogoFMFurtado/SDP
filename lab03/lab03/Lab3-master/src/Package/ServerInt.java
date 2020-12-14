package Package;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInt extends Remote{

    double media(Double[] prices) throws RemoteException;
    double desvioP(Double[] prices) throws RemoteException;
    double maxValue(Double[] prices) throws RemoteException;
    double minValue(Double[] prices) throws RemoteException;

}
