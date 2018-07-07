package by.rubakhin.iba;

import com.sun.jna.platform.win32.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class RegistryKeyReader {

    public static final String REGISTRYKEYSFILE_PATH = "C:\\Users\\pika4\\Documents\\IBA\\src\\by\\rubakhin\\iba\\registryKeys.txt";

    public void RegistryKeyRead(String value, String regName) {




        // Read a string
        String productName = Advapi32Util.registryGetStringValue(
                WinReg.HKEY_LOCAL_MACHINE, value /*"SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion",  "ProductName" */, regName );

        System.out.printf("Product Name: %s%n", productName);

        PrintWriter out = null;
        try {
            out = new PrintWriter(REGISTRYKEYSFILE_PATH);
            out.println(productName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            //После чего мы должны закрыть файл
            //Иначе файл не запишется
            out.close();}


        // Read a string
        String Bios = Advapi32Util.registryGetStringValue(
                WinReg.HKEY_LOCAL_MACHINE, "HARDWARE\\DESCRIPTION\\System\\BIOS", "SystemProductName");

        System.out.printf("Product Name: %s%n", Bios);

        // Read an int (& 0xFFFFFFFFL for large unsigned int)
        int timeout = Advapi32Util.registryGetIntValue(
                WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Windows", "ShutdownWarningDialogTimeout");
        System.out.printf("Shutdown Warning Dialog Timeout: %d (%d as unsigned long)%n", timeout, timeout & 0xFFFFFFFFL);

    }
}







