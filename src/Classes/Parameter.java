/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author em tung
 */
public class Parameter {

    private String name;
    private String value;

    public Parameter(String n, String v) {
        name = n;
    }

    public Parameter(String n) {
        name = n;
        value = "0";
    }

    @Override
    public String toString() {
        return String.format("Name: %s\r\nValue: %s",
                name, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
