package Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientProgram {
    public static void main(String[] args){
        File filename = new File("data.csv");
        List<String> sValues = new ArrayList<>();
        File file = new File(String.valueOf(filename));
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            scanner.nextLine();
        }
        assert scanner != null;
        if (scanner.hasNextLine()) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] split = line.split(";");
                sValues.add(split[1]);
            }
        }
        scanner.close();
        Double[] values = new Double[sValues.size()];

        int i = 0;
        for(String sValue : sValues){
            values[i] = Double.parseDouble(sValue);
            i++;
        }

        Client client = new Client();
        try {
            System.out.println("A media é: " + client.media(values));
            System.out.println("O desvio padrão é: " + client.desvioP(values));
            System.out.println("O valor maximo é: " + client.maxValue(values));
            System.out.println("O valor minimo é " + client.minValue(values));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
