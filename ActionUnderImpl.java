/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.Serializable;

/**
 *
 * @author osamu
 */
public class ActionUnderImpl implements Serializable {
    int no;
    PlyActions pla;

    public ActionUnderImpl(int no, PlyActions pla) {
        this.no = no;
        this.pla = pla;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public PlyActions getPla() {
        return pla;
    }

    public void setPla(PlyActions pla) {
        this.pla = pla;
    }
    
    
}
