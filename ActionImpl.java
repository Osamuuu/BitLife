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
public class ActionImpl implements Serializable{
    int id;
    PlyActions pai;

    public ActionImpl(int id, PlyActions pai) {
        this.id = id;
        this.pai = pai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlyActions getPai() {
        return pai;
    }

    public void setPai(PlyActions pai) {
        this.pai = pai;
    }
    
    
}
