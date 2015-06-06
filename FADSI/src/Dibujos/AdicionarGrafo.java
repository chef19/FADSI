/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dibujos;

import Interfaz.Pprincipal;

/**
 *
 * @author MICHAEL
 */
public class AdicionarGrafo extends Pprincipal {

    public AdicionarGrafo(String nombre) {
        this.getGraph().getModel().beginUpdate();
        Object parent = this.getGraph().getDefaultParent();
        Object v1 = this.getGraph().insertVertex(parent, null, nombre, 20, 20, 20, 20);
        this.getGraph().getModel().endUpdate();

    }
}
