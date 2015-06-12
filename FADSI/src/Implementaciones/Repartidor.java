/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import java.util.ArrayList;

/**
 *
 * @author MICHAEL
 */
public class Repartidor {

    public int encargosMaximos;
    public int encargos = 0;
    public LinkedList recibe = new LinkedList();
    public LinkedList llegada = new LinkedList();
    public NodoGrafo PosActual;
    public LinkedList Camino = new LinkedList();

    public Repartidor(int i, NodoGrafo Inicial) {
        this.encargosMaximos = i;
        PosActual = Inicial;
    }
    public boolean permiso(){
        if(encargos+1<encargosMaximos){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void agregar(String recoje, String llega) {
        recibe.append(recoje);
        llegada.append(llega);

    }

    public LinkedList getRecibe() {
        return this.recibe;
    }

    public LinkedList getLlegada() {
        return this.llegada;
    }
}
