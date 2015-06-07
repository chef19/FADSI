/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class Dijkstra {
    Grafo grafo;
    LinkedList ListaNodos;
    
    public Dijkstra(Grafo grafo){
        this.grafo = grafo;
        ListaNodos = new LinkedList<NodosDijkstra>();
        int i = 0;
        NodosDijkstra Nuevo;
        grafo.Lista.goToStart();
        while(i < grafo.Lista.size){
            Nuevo = new NodosDijkstra((NodoGrafo) grafo.Lista.getElement());
            ListaNodos.append(Nuevo);
            grafo.Lista.next();
            i++;
        }
        ListaNodos.goToStart();
    }
    private LinkedList Recorrer(NodosDijkstra NodoInicial){
        ListaNodos.goToPos(ListaNodos.getPositionOfElement(NodoInicial));
        NodoInicial.Pesoacumulado = 0;
        NodoInicial.setRelacionado(NodoInicial);
        ListaNodos.current.element = NodoInicial;
        ListaNodos.goToStart();
        LinkedList ListaTemp = ListaNodos;
        NodosDijkstra Temp = NodoInicial; //Se asigna el NodoInicial a Temp
        NodosDijkstra Temporal;
        NodosDijkstra Temp3; //Se declara una variable temporal
        NodoInicial.setRecorrido(); //Se marca el nodo como recorrido
        int i=0; //Variable para saber cuando se recorren todas las relaciones del nodo
        NodosDijkstra Temp2 = null; //Se inicializa una variable temporal
        //System.out.println("Va a entrar al while para recorrer las relaciones del NodoInicial");
        Temp.Nodo.Relaciones.goToStart();
        Temp.Nodo.Distancias.goToStart();
        while(i < Temp.Nodo.Relaciones.size()){ //while para recorrer las relaciones del NodoInicial
            int y = 0;
            ListaTemp.goToStart();
            while(y < ListaTemp.size()){
                Temporal = (NodosDijkstra) ListaTemp.getElement();
                NodoGrafo Temp4 = (NodoGrafo) Temp.Nodo.Relaciones.getElement();
                if(Temporal.Nodo == Temp.Nodo.Relaciones.getElement()){
                    Temp2 = Temporal;
                    y = ListaTemp.size();
                }
                y++;
                ListaTemp.next();
            }
            //System.out.println("Valor asignado a temp2 " + Temp2.Nodo.Dato);
            ListaNodos.goToStart();
            if(ListaNodos.getPositionOfElement(Temp2)!=-1){ //if de cuando se encuentra el NodoD
                //System.out.println("(if)Encuentra el NodoD");
                ListaNodos.goToPos(ListaNodos.getPositionOfElement(Temp2));
                Temp3 = (NodosDijkstra) ListaNodos.getElement(); //se asigna el NodoD a Temp3
                if (Temp3.Recorrido==false){ //if para saber si el pesoacumulado no es el final
                    if(Temp3.Pesoacumulado != null){ //if para saber si existe un pesoacumulado
                        if(Temp.Pesoacumulado + (int)Temp2.Nodo.Distancias.getElement()<Temp3.Pesoacumulado){ //if para saber si el nuevo peso es menor al anterior
                            Temp3.Pesoacumulado = Temp.Pesoacumulado + (int)Temp.Nodo.Distancias.getElement(); //Se Asigna el pesoacumulado
                            Temp3.setRelacionado(Temp); //Se asigna el nodoDijkstra con el que se relaciona
                        }
                    }
                    else{
                        Temp3.Pesoacumulado = Temp.Pesoacumulado + (int)Temp.Nodo.Distancias.getElement(); //Se Asigna el pesoacumulado
                        Temp3.setRelacionado(Temp); //Se asigna el nodoDijkstra con el que se relaciona
                    }
                }
                ListaNodos.current.element=Temp3;
            }
            i++; //Se aunmenta para saber que ya se recorrio una relacion del NodoInicial
            Temp.Nodo.Relaciones.next(); //Se avanza a la siguiente relacion
            Temp.Nodo.Distancias.next(); //Se avanza a la siguiente distancia
        }
        ListaNodos.goToStart();
        int e = 0;
        NodosDijkstra Comparativo = (NodosDijkstra) ListaNodos.getElement();
        while(e < ListaNodos.size()){
            Temp = (NodosDijkstra) ListaNodos.getElement();
            if(Temp.Recorrido==false){
                if(Temp.Pesoacumulado!=null){
                    if(Comparativo.Pesoacumulado==null){
                        Comparativo=Temp;
                    }
                    else if (Temp.Pesoacumulado<Comparativo.Pesoacumulado){
                        Comparativo=Temp;
                    }
                    else if (Comparativo.Pesoacumulado == 0){
                        Comparativo=Temp;
                    }
                }
            }
            ListaNodos.next();
            e++;
        }
        if(Comparativo.Pesoacumulado==0){
            int h = 0;
            ListaNodos.goToStart();
            NodosDijkstra Temp9;
            while(h< ListaNodos.size){
                Temp9 = (NodosDijkstra) ListaNodos.getElement();
                ListaNodos.next();
                h++;
            }
            return ListaNodos;
        }
        else{
            return Recorreraux(Comparativo);
        }
    }
    
    private LinkedList Recorreraux(NodosDijkstra NodoInicial){
        //System.out.println("Se inicia Recorrer");
        ListaNodos.goToPos(ListaNodos.getPositionOfElement(NodoInicial));
        ListaNodos.goToStart();
        LinkedList ListaTemp = ListaNodos;
        NodosDijkstra Temp = NodoInicial; //Se asigna el NodoInicial a Temp
        NodosDijkstra Temporal;
        NodosDijkstra Temp3; //Se declara una variable temporal
        NodoInicial.setRecorrido(); //Se marca el nodo como recorrido
        int i=0; //Variable para saber cuando se recorren todas las relaciones del nodo
        NodosDijkstra Temp2 = null; //Se inicializa una variable temporal
        //System.out.println("Va a entrar al while para recorrer las relaciones del NodoInicial");
        Temp.Nodo.Relaciones.goToStart();
        Temp.Nodo.Distancias.goToStart();
        while(i < Temp.Nodo.Relaciones.size()){ //while para recorrer las relaciones del NodoInicial
            int y = 0;
            ListaTemp.goToStart();
            while(y < ListaTemp.size()){
                Temporal = (NodosDijkstra) ListaTemp.getElement();
                NodoGrafo Temp4 = (NodoGrafo) Temp.Nodo.Relaciones.getElement();
                if(Temporal.Nodo == Temp.Nodo.Relaciones.getElement()){
                    Temp2 = Temporal;
                    y = ListaTemp.size();
                }
                y++;
                ListaTemp.next();
            }
            ListaNodos.goToStart();
            if(ListaNodos.getPositionOfElement(Temp2)!=-1){ //if de cuando se encuentra el NodoD
                ListaNodos.goToPos(ListaNodos.getPositionOfElement(Temp2));
                Temp3 = (NodosDijkstra) ListaNodos.getElement(); //se asigna el NodoD a Temp3
                if (Temp3.Recorrido==false){ //if para saber si el pesoacumulado no es el final
                    if(Temp3.Pesoacumulado != null){ //if para saber si existe un pesoacumulado
                        if(Temp.Pesoacumulado + (int)Temp2.Nodo.Distancias.getElement()<Temp3.Pesoacumulado){ //if para saber si el nuevo peso es menor al anterior
                            Temp3.Pesoacumulado = Temp.Pesoacumulado + (int)Temp.Nodo.Distancias.getElement(); //Se Asigna el pesoacumulado
                            Temp3.setRelacionado(Temp); //Se asigna el nodoDijkstra con el que se relaciona
                        }
                    }
                    else{
                        Temp3.Pesoacumulado = Temp.Pesoacumulado + (int)Temp.Nodo.Distancias.getElement(); //Se Asigna el pesoacumulado
                        Temp3.setRelacionado(Temp); //Se asigna el nodoDijkstra con el que se relaciona
                    }
                }
                ListaNodos.current.element=Temp3;
            }
            i++; //Se aunmenta para saber que ya se recorrio una relacion del NodoInicial
            Temp.Nodo.Relaciones.next(); //Se avanza a la siguiente relacion
            Temp.Nodo.Distancias.next(); //Se avanza a la siguiente distancia
        }
        ListaNodos.goToStart();
        int e = 0;
        NodosDijkstra Comparativo = (NodosDijkstra) ListaNodos.getElement();
        while(e < ListaNodos.size()){
            Temp = (NodosDijkstra) ListaNodos.getElement();
            if(Temp.Recorrido==false){
                if(Temp.Pesoacumulado!=null){
                    if(Comparativo.Pesoacumulado==null){
                        Comparativo=Temp;
                    }
                    else if (Temp.Pesoacumulado<Comparativo.Pesoacumulado){
                        Comparativo=Temp;
                    }
                    else if (Comparativo.Pesoacumulado == 0){
                        Comparativo=Temp;
                    }
                }
            }
            else{
            }
            ListaNodos.next();
            e++;
        }
        if(Comparativo.Pesoacumulado==0){
            int h = 0;
            ListaNodos.goToStart();
            NodosDijkstra Temp9;
            while(h< ListaNodos.size){
                Temp9 = (NodosDijkstra) ListaNodos.getElement();
                ListaNodos.next();
                h++;
            }
            return ListaNodos;
        }
        else{
            return Recorreraux(Comparativo);
        }
    }
    
    public LinkedList rutamasCorta(NodosDijkstra Inicial, NodosDijkstra Final){
        Recorrer(Inicial);
        ListaNodos.goToStart(); //Se va al inicio de las lista de Nodos
        int e = 0; //para recorrer la lista y poder buscar el camino
        NodosDijkstra Comparativo = new NodosDijkstra(); // Se inicializa una variable para buscar el camino
        LinkedList Camino = new LinkedList(); //Lista que tendra el camino
        Comparativo = (NodosDijkstra) Final; //Se asigna el elemento actual a Comparativo
        if (Comparativo == Final){ //if para saber si ya se encontro el nodo final
            while(Comparativo != Inicial){ //While para saber cuando ya esta el listo camino
                Camino.append(Comparativo.getRelacionado()); //Se añade el elemento al camino
                Comparativo = Comparativo.getRelacionado();
            }
        }
        return Camino;
    }
}
