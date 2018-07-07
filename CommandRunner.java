package by.rubakhin.iba;

import java.io.*;

public class CommandRunner {

    public static final String CMDFILE_PATH = "C:\\Users\\pika4\\Documents\\IBA\\src\\by\\rubakhin\\iba\\cmd_out.txt";

    public void excCommand(String value) {
        ProcessBuilder builder = new ProcessBuilder(value
                /*"cmd.exe"  , "/c", "cd \"C:\\Program Files\\MySQL\" && dir" */);
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                break;
            }

            PrintWriter out = null;
            try {
                out = new PrintWriter(CMDFILE_PATH);
                out.println(line);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();}



            System.out.println(line);
        }
    }
}
