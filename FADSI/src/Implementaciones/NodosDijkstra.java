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
public class NodosDijkstra {
    
    public NodoGrafo Nodo;
    public Integer Pesoacumulado;
    private NodosDijkstra Relacionado;
    public boolean Recorrido;
    
    public NodosDijkstra(NodoGrafo Nodo){
        this.Nodo = Nodo;
        this.Pesoacumulado = null;
        this.Recorrido = false;
    }
    
    public NodosDijkstra(){
        this.Nodo = null;
        this.Pesoacumulado = null;
        this.Recorrido = false;
    }
    
    public NodosDijkstra(NodoGrafo Nodo, int Pesoacumulado, NodosDijkstra Relacionado){
        this.Nodo = Nodo;
        this.Pesoacumulado = Pesoacumulado;
        this.Relacionado = Relacionado;
        this.Recorrido = false;
    }
    
    public NodosDijkstra(NodoGrafo Nodo, int Pesoacumulado){
        this.Nodo = Nodo;
        this.Pesoacumulado = Pesoacumulado;
        this.Relacionado = this;
        this.Recorrido = false;
    }
    
    public void setPesoacumulado(int Peso){
        this.Pesoacumulado = Peso;
    }
    
    public void setRelacionado(NodosDijkstra Relacionado){
        this.Relacionado = Relacionado;
    }
    
    public NodosDijkstra getRelacionado(){
        return this.Relacionado;
    }
    
    public void setNodo(NodoGrafo Nodo){
        this.Nodo = Nodo;
    }
    
    public void setRecorrido(){
        this.Recorrido = true;
    }
}
