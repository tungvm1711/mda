/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author em tung
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static final String xmlFilePath = "src/xmlfile.xml";
    public static final String PARAGRAPH_SPLIT_REGEX = "\\s*\\r?\\n\\s*\\r?\\n";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //src/Mosquito.kendrick
        System.out.println("hihi");

        String currentLine;

        final BufferedReader bf = new BufferedReader(new FileReader("src/Mosquito.kendrick"));

        currentLine = bf.readLine();

        final StringBuilder stringBuilder = new StringBuilder();
        while (currentLine != null) {

            stringBuilder.append(currentLine);
            stringBuilder.append(System.lineSeparator());
            currentLine = bf.readLine();
        }

        String[] paragraph = new String[stringBuilder.length()];

        if (stringBuilder != null) {

            final String value = stringBuilder.toString();
            paragraph = value.split(PARAGRAPH_SPLIT_REGEX);
        }

        for (final String s : paragraph) {
            String firstword = s.contains(" ") ? s.split(" ")[0] : s;
            switch (firstword) {
                case "KendrickModel":
                    Scanner scanner = new Scanner(s);
                    scanner.useDelimiter(";");
                    scanner.nextLine();
                    while (scanner.hasNext()) {
                        String token = scanner.next();
                        Scanner reader = new Scanner(token);
                        reader.useDelimiter(": #\\(*");
                        System.out.println(reader.next());
                        System.out.println(reader.next());  
                        System.out.println("hihi");
                    }
                    scanner.close();
//                        System.out.println(details[0]);
                    break;
                case "Composition":
                    //System.out.println("hehe");
                    break;
                case "Scenario":
                    //System.out.println("haha");
                    break;
            }
        }
    }

}
