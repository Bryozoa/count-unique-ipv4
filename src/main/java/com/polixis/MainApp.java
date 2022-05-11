package main.java.com.polixis;

import main.java.com.polixis.searchalgoritms.BitSetUniqueIpCounter;
import main.java.com.polixis.searchalgoritms.UniqueIpCounter;

import java.io.File;

public class MainApp {

    public static String parseFileName(String[] args) {
        File folder = new File("src\\resources\\");
        File[] listOfFiles = folder.listFiles();

        return listOfFiles[0].getAbsolutePath();
    }

    public static void main(String[] args) {

        String fileName = parseFileName(args);
        if (fileName == null) {
            System.out.println("Wrong arguments. Use '-file file_name' to specify file for processing");
            return;
        }

        UniqueIpCounter counter = new BitSetUniqueIpCounter();
        long numberOfUniqueIp = counter.countUniqueIp(fileName);
        if (numberOfUniqueIp != -1) {
            System.out.println("Found " + numberOfUniqueIp + " unique IP's");
        } else {
            System.out.println("Some errors here. Check log for details.");
        }
    }
}
