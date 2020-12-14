package Package;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class CalcServ extends UnicastRemoteObject implements ServerInt {

    public CalcServ() throws RemoteException { }

    public double media(Double[] prices) {

        double result = 0;
        for (Double price : prices) {
            result += price;
        }
        return result / prices.length;
    }

    public double desvioP(Double[] prices) {

        double sum = 0.0;
        double desvioPadrao = 0.0;
        for(double i : prices) {
            sum += i;
        }
        double media = sum/ prices.length;
        for(double i : prices) {
            desvioPadrao += Math.pow(i - media, 2);
        }
        return Math.sqrt(desvioPadrao/ prices.length);
    }

    public double maxValue(Double[] prices) {

        double max = prices[0];
        for (Double price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    public double minValue(Double[] prices) {

        double min = prices[0];
        for (Double price : prices) {
            if (price < min) {
                min = price;
            }
        }
        return min;
    }
}
