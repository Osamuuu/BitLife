/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.Serializable;

/**
 *
 * @author daniel.constantin
 */
public class MultiChoiceEvents implements Serializable{
    private plyEvents eventObj;
    private String op1;
    private String op2;
    private String op3;
    int turns2;
    String message2;
    int modCredibility2;
    int modMotivation2;
    int modFinacial2;
    int turns3;
    String message3;
    int modCredibility3;
    int modMotivation3;
    int modFinacial3;
    int yourchoice=0;
    int remTurns;

    public MultiChoiceEvents(plyEvents eventObj, String op1, String op2, String op3, int turns2, String message2, int modCredibility2, int modMotivation2, int modFinacial2, int turns3, String message3, int modCredibility3, int modMotivation3, int modFinacial3, int yourchoice,int remTurns) {
        this.eventObj = eventObj;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.turns2 = turns2;
        this.message2 = message2;
        this.modCredibility2 = modCredibility2;
        this.modMotivation2 = modMotivation2;
        this.modFinacial2 = modFinacial2;
        this.turns3 = turns3;
        this.message3 = message3;
        this.modCredibility3 = modCredibility3;
        this.modMotivation3 = modMotivation3;
        this.modFinacial3 = modFinacial3;
        this.yourchoice=yourchoice;
        this.remTurns=remTurns;
    }

    public plyEvents getEventObj() {
        return eventObj;
    }

    public void setEventObj(plyEvents eventObj) {
        this.eventObj = eventObj;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public int getTurns2() {
        return turns2;
    }

    public void setTurns2(int turns2) {
        this.turns2 = turns2;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public int getModCredibility2() {
        return modCredibility2;
    }

    public void setModCredibility2(int modCredibility2) {
        this.modCredibility2 = modCredibility2;
    }

    public int getModMotivation2() {
        return modMotivation2;
    }

    public void setModMotivation2(int modMotivation2) {
        this.modMotivation2 = modMotivation2;
    }

    public int getModFinacial2() {
        return modFinacial2;
    }

    public void setModFinacial2(int modFinacial2) {
        this.modFinacial2 = modFinacial2;
    }

    public int getTurns3() {
        return turns3;
    }

    public void setTurns3(int turns3) {
        this.turns3 = turns3;
    }

    public String getMessage3() {
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    public int getModCredibility3() {
        return modCredibility3;
    }

    public void setModCredibility3(int modCredibility3) {
        this.modCredibility3 = modCredibility3;
    }

    public int getModMotivation3() {
        return modMotivation3;
    }

    public void setModMotivation3(int modMotivation3) {
        this.modMotivation3 = modMotivation3;
    }

    public int getModFinacial3() {
        return modFinacial3;
    }

    public void setModFinacial3(int modFinacial3) {
        this.modFinacial3 = modFinacial3;
    }

    public int getYourchoice() {
        return yourchoice;
    }

    public void setYourchoice(int yourchoice) {
        this.yourchoice = yourchoice;
    }

    public int getRemTurns() {
        return remTurns;
    }

    public void setRemTurns(int remTurns) {
        this.remTurns = remTurns;
    }
    
    
}
