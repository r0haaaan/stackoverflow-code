package in.rohaan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CreateDevice {
    static List<FogDevice> fogDevices = new ArrayList<FogDevice>();
    static List<String> Mylist = new ArrayList<String>();

    public static class FogDevice {
        public FogDevice(String name) {

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/madhu/Desktop/demo.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            String st = sc.nextLine();
            Mylist.add(st);
        }
        String list[] = new String[Mylist.size()];

        Object[] obj = Mylist.toArray();
        String[] str = Arrays.copyOf(obj,obj.length,String[].class);
        FogDevice[] fogDevices = addFogDevices(str);
    }

    /**
     * Create an array of FogDevice objects
     *
     * @param str an array of strings
     * @return FogDevice[] array
     */
    private static FogDevice[] addFogDevices(String[] str) {
        FogDevice[] fdArray = new FogDevice[str.length - 1];
        for (int i = 0; i < str.length - 1; i++) {
            // Delegate Single FogDevice creation to your old method;
            fdArray[i] = addFogDevice(str[i]);
        }
        return fdArray;
    }

    /**
     * Create FogDevice
     * @param inputStr provided string from which to extract details
     * @return FogDevice
     */
    private static FogDevice addFogDevice(String inputStr) {
        return new FogDevice(inputStr);
    }

}

