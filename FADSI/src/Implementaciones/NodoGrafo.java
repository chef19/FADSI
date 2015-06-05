/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

/**
 *
 * @author Max
 */
public class NodoGrafo <T>{
    
    public T Dato;
    public LinkedList Relaciones = new LinkedList<NodoGrafo>();
    public LinkedList Distancias = new LinkedList();
    
    public NodoGrafo(T Dato){
        this.Dato = Dato;
    }
    
    public NodoGrafo(T Dato, LinkedList Relaciones, LinkedList Distancias){
        this.Dato = Dato;
        this.Relaciones = Relaciones;
        this.Distancias = Distancias;
    }
    
    public void añadirRelacion(NodoGrafo R1, int Distancia){
        Relaciones.append(R1);
        Distancias.append(Distancia);
    }
    
    public void eliminarRelacion(NodoGrafo R1){
        int Pos = Relaciones.getPositionOfElement(R1);
        if(Pos!=-1){
            Relaciones.goToPos(Pos);
            Relaciones.remove();
            Distancias.goToPos(Pos);
            Distancias.remove();
        }
    }
}
