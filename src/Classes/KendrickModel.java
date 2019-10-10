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
public class KendrickModel implements KendrickModelComponent{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
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
                    List<Parameter> listParams = new ArrayList<>();
                    for (int i = 0; i < newParams.length; i++) {
                        Parameter parameter = new Parameter(newParams[i]);
                        listParams.add(parameter);
                    }
                    parameters = listParams;
                    break;
                case "transitions":
                    Scanner tranScanner = new Scanner(kenPropsVal);
                    List<Transition> listTrans = new ArrayList<>();
                    while (tranScanner.hasNextLine()) {
                        String line = tranScanner.nextLine().replaceAll("\\s", "").replaceAll("\\.", "");
                        if (line.length() == 0) {
                            continue;
                        }
                        String[] newTrans = line.split("-->");
                        String newToStatus = newTrans[1];
                        String[] parcerRate = newTrans[0].split("--");
                        String newFromStatus = parcerRate[0];
                        String newRate = parcerRate[1];
                        Transition transition = null;
                        if (newFromStatus.equals(attribute.getName())) {
                            for (int i = 0; i < attribute.getValue().size(); i++) {
                                transition = new Transition(attribute.getValue().get(i), newToStatus, newRate);
                                listTrans.add(transition);
                            }
                        } else {
                            transition = new Transition(newFromStatus, newToStatus, newRate);
                            listTrans.add(transition);
                        }
                        transitions = listTrans;
                    }
                    tranScanner.close();
                    break;
            }
        }
        scanner.close();
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public Attribute getKenModel() {
        return attribute;
    }

    @Override
    public void showProperty() {
        System.out.println(getAttribute());
    }
}
