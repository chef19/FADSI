/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import Interfaz.Pprincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author MICHAEL
 */
public class HiloCronometro implements Runnable{
    public Pprincipal Admi = new Pprincipal();
    public int tiempo;
    public Timer t;

    public int s, cs, sF;

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        System.out.println("Arranca cronometro");
        t = new Timer(10, acciones);
        t.start();
        System.out.println("Tiempo: "+ this.tiempo);
        sF = tiempo;
        s = 0;
        cs = 0;
        actualizarLabel();

    }
    public ActionListener acciones = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Entra metodo acciones");
            cs++;
            if (cs == 100) {
                cs = 0;
                s++;
                sF--;
            }
            if (sF == 0) {
                t.stop();
            }
            actualizarLabel();
        }
    };

    public void actualizarLabel() {
        System.out.println("Actualiza la hora");
        String tiempo = (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
        Admi.TiempoT1.setText(tiempo);
        String tiempoF = (sF <= 9 ? "0" : "") + sF;
        System.out.println(tiempoF);
        Admi.TiempoF1.setText(tiempoF);
    }

}
