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

    public String nombre;
    public int tiempo;
    public static int encargosMaximos;
    public static ArrayList encargos;

    public Repartidor(String nombre, int encargosM) {
        this.nombre = nombre;
        this.encargosMaximos = encargosM;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void seTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    public int addEncargo(Pedidos encargo){
        if(encargos.size()==encargosMaximos-1){
            return -1;
        }
        else{
            encargos.add(encargo);
            return 0;
        }
    }

}
