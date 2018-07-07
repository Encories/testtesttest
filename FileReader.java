package by.rubakhin.iba;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileReader {
 //   public static final String INPUTFILE_PATH = "C:\\Users\\pika4\\Documents\\IBA\\src\\by\\rubakhin\\iba\\input.txt";
    public static final String OTPUTFILE_PATH = "C:\\Users\\pika4\\Documents\\IBA\\src\\by\\rubakhin\\iba\\output.txt";


    public void Read(String value){

    try {
        try (Scanner in = new Scanner(new File(value))) {
            StringBuilder data = new StringBuilder();
            try (PrintWriter out = new PrintWriter(OTPUTFILE_PATH)) {
                while (in.hasNext())
                    data.append(in.nextLine()).append("\n");

                String s = new String(data.toString());


             //   String[] words = s.split("\\s");

                Pattern p3 = Pattern.compile("^«a»=«b»$");
                String[] words = p3.split(s);
                for (String word : words)
                    System.out.println(word);



                for(String subStr:words) {
                    System.out.println(subStr);
                }
                //System.out.println(s);
                try {
                   // String tofile = data.toString();
                    String tofile = data.toString();
                    //Записываем текст у файл
                    out.println(tofile);
                }

                finally {
                    //После чего мы должны закрыть файл
                    //Иначе файл не запишется
                    out.close();
                }
            }
        }

    } catch ( Exception ex ) {
        ex.printStackTrace();
    }
    }


    void writeData(){




    }



}











