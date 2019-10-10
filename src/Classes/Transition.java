/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Tung Minh Vu
 */
public class Transition {
    private String fromStatus;
    private String toStatus;
    private String rate;
    public Transition(String fromStatus, String toStatus, String rate) {
        this.fromStatus = fromStatus;
        this.toStatus = toStatus;
        this.rate = rate;
    }
    @Override
    public String toString() {
        return String.format("fromStatus: %s, ToStatus: %s rate: %s", 
                fromStatus, toStatus, rate);
    }
    public String getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(String fromStatus) {
        this.fromStatus = fromStatus;
    }

    public String getToStatus() {
        return toStatus;
    }

    public void setToStatus(String toStatus) {
        this.toStatus = toStatus;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
