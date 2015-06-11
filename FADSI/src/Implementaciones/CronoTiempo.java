/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import Interfaz.Pprincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Ricardo Araya
 */
public class CronoTiempo implements Runnable {
    
    
    public Timer t;
    public int indice;
    public int tiempo;
    public int s, cs, sF;
    public CronoTiempo(int T,int indice){
        this.tiempo=T;
        this.indice=indice;
    }
    private ActionListener acciones = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
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
        Pprincipal Admi = new Pprincipal();
        String tiempo = (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
        Admi.TiempoT1.setText(tiempo);
        String tiempoF = (sF <= 9 ? "0" : "") + sF;
        Admi.TiempoF1.setText(tiempoF);
    }

    @Override
    public void run() {
        t= new Timer(10, acciones);
        t.start();
        sF = tiempo;
        s = 0;
        cs = 0;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CronoTiempo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
