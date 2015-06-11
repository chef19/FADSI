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

    public String recibe;
    public String llegada;
    public int encargosMaximos;
    public int encargos = 0;

    public Repartidor() {
    }
    
    public void setDatos(String recibe, String Llegada, int encargosMaximos) {
        this.recibe = recibe;
        this.llegada = Llegada;
        this.encargosMaximos = encargosMaximos;
    }

    public String getRecibe() {
        return this.recibe;
    }

    public String getLlegada() {
        return this.llegada;
    }

    public boolean addEncargo() {
        if (encargos + 1 < encargosMaximos) {
            encargos += 1;
            return true;
        } else {
            return false;
        }
    }
}
