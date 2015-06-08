/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dibujos;

import Interfaz.Pprincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author MICHAEL
 */
public class AgregarArista extends Pprincipal {

    public AgregarArista(String peso,String v3,String v4) {
        Object parent = this.getGraph().getDefaultParent();
        Object v1 = this.getM().get(v3);
        Object v2 = this.getM().get(v4);
        System.out.println("INSERTANDO");
        this.getGraph().insertEdge(parent, null, peso, v1, v2, "strokeColor=red");
        System.out.println("INSERTOOO!!!!");
    }
}
