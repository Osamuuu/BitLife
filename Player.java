/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Osamu
 */
public class Player implements Serializable{

    public void setName(String name) {
        this.name = name;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void setFinance(int finance) {
        this.finance = finance;
    }

    public void setCredibility(int credibility) {
        this.credibility = credibility;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int[] getFinev() {
        return finev;
    }

    public void setFinev(int[] finev) {
        this.finev = finev;
    }

    public String getName() {
        return name;
    }

    public int getTurns() {
        return turns;
    }

    public int getFinance() {
        return finance;
    }

    public int getCredibility() {
        return credibility;
    }

    public int getPeople() {
        return people;
    }
    private String name;
    //String compName;
    private String persoana;
    private int turns;
    private int finance;
    private int credibility;
    private int people;
    private int gender;

    public List<ActionUnderImpl> getPlyactionList() {
        return PlyactionList;
    }

    public void setPlyactionList(List<ActionUnderImpl> PlyactionList) {
        this.PlyactionList = PlyactionList;
    }

    public List<ActionImpl> getPlyImplAList() {
        return PlyImplAList;
    }

    public void setPlyImplAList(List<ActionImpl> PlyImplAList) {
        this.PlyImplAList = PlyImplAList;
    }

    public int[] getLblenable() {
        return lblenable;
    }

    public void setLblenable(int[] lblenable) {
        this.lblenable = lblenable;
    }

    public List<String> getMessg() {
        return messg;
    }

   public void setMessg(List messg) {
        this.messg = messg;
    } 
    private List<ActionUnderImpl> PlyactionList;
    private List<ActionImpl> PlyImplAList;   
    private int[] lblenable;
    private int[] lblrevenue;
    private  List<String> messg = new ArrayList<String>();;
    private int[] finev=new int[53];
    private List<MultiChoiceEvents> multiEventList=new ArrayList();
    private List<MultiChoiceEvents> multiEventImpl=new ArrayList();

    public List<MultiChoiceEvents> getMultiEventList() {
        return multiEventList;
    }

    public void setMultiEventList(List<MultiChoiceEvents> multiEventList) {
        this.multiEventList = multiEventList;
    }

    public List<MultiChoiceEvents> getMultiEventImpl() {
        return multiEventImpl;
    }

    public void setMultiEventImpl(List<MultiChoiceEvents> multiEventImpl) {
        this.multiEventImpl = multiEventImpl;
    }
    
    public Player(String name, String persoana,  int turns, int finance, int credibility, int people, int gender) {
     
  
        this.name = name;
        this.persoana=persoana;
        this.turns = turns;
        this.finance = finance;
        this.credibility = credibility;
        this.people = people;
        this.gender =gender;
    
    }
 //   public void addWeek(){
 //   this.turns++;
//}
    public Player(){
     
    }
    public String getPersoana() {
        return persoana;
    }

    public void setPersoana(String persoana) {
        this.persoana = persoana;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    
    public void addMesg(String msg) {
        messg.add(msg);
    }

    public int[] getLblrevenue() {
        return lblrevenue;
    }

    public void setLblrevenue(int[] lblrevenue) {
        this.lblrevenue = lblrevenue;
    }

}
