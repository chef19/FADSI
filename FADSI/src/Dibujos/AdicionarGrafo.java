/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dibujos;

import Interfaz.Pprincipal;
import java.util.HashMap;

import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.Random;

public class AdicionarGrafo extends Pprincipal {
ArrayList<Integer> eX = new ArrayList();
ArrayList<Integer> eY = new ArrayList();
    public AdicionarGrafo(String nome) {
        for(int i =0;i<500;i++){
            eX.add(i+29);
            eY.add(i+9);
        }
        Random e = new Random();
        Random f = new Random();
        
        int x = eX.get(e.nextInt(499));
        int y = eY.get(f.nextInt(499));
        
        System.out.println("NOME: "+nome+" X: "+ x+" Y: "+y);
        this.getGraph().getModel().beginUpdate();
        Object parent = this.getGraph().getDefaultParent();
        Object v1 = this.getGraph().insertVertex(parent, null, nome, x, y, 10, 10,"fontSize=16;fillColor=GREEN;shape=ellipse");//primero x ,segundo y,tercero ancho,alto
        this.getM().put(nome, v1);
        this.getGraph().getModel().endUpdate();
    }

}
