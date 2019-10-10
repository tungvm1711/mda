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
 * @author tung1711
 */
public class KendrickModelComposite implements KendrickModelComponent{
    private List<KendrickModelComponent> kenModels;
 
    public KendrickModelComposite(List<KendrickModelComponent> kenModels) {
        this.kenModels = kenModels;
    }
    @Override
    public void showProperty() {
        for (KendrickModelComponent kenModel : kenModels) {
            kenModel.showProperty();
        }
    }

    @Override
    public void handleValues(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
