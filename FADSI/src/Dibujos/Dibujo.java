/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dibujos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author MICHAEL
 */
public class Dibujo {
    public void Dibujar(Graphics g,String codigo){
        int N=500;
        int M=215;
        int x=(int)(Math.random()*N + 1);
        int y=(int)(Math.random()*M + 1);
        
        g.setColor(Color.RED);
        g.fillOval(x, y, 15, 15);
        g.setColor(Color.BLACK);
        g.drawString(codigo, x, y);
    }
}   
