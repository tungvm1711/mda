/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tung Minh Vu
 */
public class KendrickModel {

    private Attribute attribute;
    private List<Parameter> parameters;
    private List<Transition> transitions;
    //collect data about the book

    public void visit(Attribute attribute) {
        System.out.println("huhu");
    }

    public void handleValues(String data) {
        Scanner scanner = new Scanner(data);
        scanner.useDelimiter(";");
        scanner.nextLine();
        while (scanner.hasNext()) {
            String token = scanner.next();
            Scanner reader = new Scanner(token);
            reader.useDelimiter(": #\\(*");
            String kenProps = reader.next().replaceAll("\\s", "");
            String kenPropsVal = reader.next().replaceAll("\\)", "");
            switch (kenProps) {
                case "attribute":
                    String[] newAttribute = kenPropsVal.split(" -> ");
                    attribute = new Attribute(newAttribute[0], newAttribute[1]);
                    //System.out.println(attribute.getValue());
                    for (int i = 0; i < attribute.getValue().size(); i++) {
                        //System.out.println(attribute.getValue().get(i));
                    }
                    break;
                case "parameters":
                    String[] newParams = kenPropsVal.split(" ");
                    for (int i = 0; i < newParams.length; i++) {
                        Parameter parameter = new Parameter(newParams[i]);
                        parameters = new ArrayList<>();
                        parameters.add(parameter);
                        //System.out.println(parameters);
                    }
                    break;
                case "transitions":
                    Scanner tranScanner = new Scanner(kenPropsVal);
                    while (tranScanner.hasNextLine()) {
                        String line = tranScanner.nextLine().replaceAll("\\s", "");
                        System.out.println(line);
                    }
                    tranScanner.close();
                    break;
            }
        }
        scanner.close();
    }

    public Attribute getKenModel() {
        return attribute;
    }
}
