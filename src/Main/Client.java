/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Classes.Attribute;
import Classes.KendrickModel;
import Classes.KendrickModelComponent;
import Classes.KendrickModelComposite;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author em tung
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static final String xmlFilePath = "src/xmlfile.xml";
    public static final String PARAGRAPH_SPLIT_REGEX = "\\s*\\r?\\n\\s*\\r?\\n";

    public static void main(String[] args) throws java.io.FileNotFoundException, IOException {
        // TODO code application logic here
        List<KendrickModelComponent> kensModel = new ArrayList<>();
        String currentLine;

        final BufferedReader bf = new BufferedReader(new FileReader("src/Influenza.kendrick"));

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
                    System.out.println(s.split("\\s+")[1]);
                    KendrickModelComponent kendrickModel = new KendrickModel();
                    kendrickModel.handleValues(s);
                    kensModel.add(kendrickModel);
                    break;
                case "Composition":
                    KendrickModelComponent kendrickComposite = new KendrickModelComposite(kensModel);
                    kendrickComposite.showProperty();
                    //System.out.println(kendrickModel.getAttribute());
                    break;
                case "Scenario":
                    //System.out.println("haha");
                    break;
            }
        }
    }
}
