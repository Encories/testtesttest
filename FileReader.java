package by.rubakhin.iba;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {
 //   public static final String INPUTFILE_PATH = "C:\\Users\\pika4\\Documents\\IBA\\src\\by\\rubakhin\\iba\\input.txt";
    public static final String OTPUTFILE_PATH = "C:\\Users\\pika4\\Documents\\IBA\\src\\by\\rubakhin\\iba\\output.txt";
    final String regex = "[«].+[»][=][«].+[»]";


    public void Read(String value){

    try (Scanner in = new Scanner(new File(value))) {
            StringBuilder data = new StringBuilder();

            while (in.hasNext()){
                data.append(in.nextLine()).append("\n");}



            try (PrintWriter out = new PrintWriter(OTPUTFILE_PATH)) {
                final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                final Matcher matcher = pattern.matcher(data);


             /*   if (matcher.matches() == true){
                    System.out.println(data);

                } */


                    while (matcher.find()) {
                        System.out.println("Full match: " + matcher.group(0));


                        String tofile = matcher.group(0);

                        String[] subStr;
                        String delimeter = "="; // Разделитель
                        subStr = tofile.split(delimeter); // Разделения строки str с помощью метода split()


                        for (int i = 0; i < subStr.length; i++) {
                            System.out.println(subStr[i]);

                            //Записываем текст у файл
                            out.println(subStr[i]);
                        }

                    }

            }
        }catch ( Exception ex ) {
            ex.printStackTrace();
    }

    }

}





//  try {
// String tofile = data.toString();

//  }

//   finally {
//После чего мы должны закрыть файл
//Иначе файл не запишется
//        out.close();
//   }







