/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tung Minh Vu
 */
public class Attribute {

    private String name;
    private List<String> values;

    public Attribute(String n, String v) {
        name = n;
        String[] newAttribute = v.split(" ");
        values = new ArrayList<>();
        for (int i = 0; i < newAttribute.length; i++) {
            values.add(newAttribute[i]);
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s\r\nValue: %s",
                name, values);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValue() {
        return values;
    }

    public void setValue(List<String> value) {
        this.values = values;
    }
}
