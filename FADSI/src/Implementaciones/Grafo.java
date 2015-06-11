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
public class Grafo<T> {
    
    public static LinkedList Lista;
    public int NumeroAristas;
    public int NumeroNodos;
    
    public Grafo(){
        Lista = new LinkedList<NodoGrafo>();
        NumeroAristas = 0;
        NumeroNodos = 0;
    }
    
    public void Agregar (NodoGrafo Nuevo){
        Lista.append(Nuevo);
        System.out.println("Se agrega un Nodo al grafo");
        NumeroNodos++;
    }
    
    public void AgregarRelacion(NodoGrafo R1, NodoGrafo R2, int Distancia){
        R1.añadirRelacion(R2, Distancia);
        NumeroAristas++;
    }
    
    public void EliminarRelacion(NodoGrafo R1, NodoGrafo R2){
        R1.eliminarRelacion(R2);
        R2.eliminarRelacion(R1);
        NumeroAristas--;
    }
    
    public void EliminarNodo(NodoGrafo R1){
        int i=0;
        while(i<=Lista.size()){
            NodoGrafo Rx = (NodoGrafo) Lista.current.getElemento();
            if(Rx.Relaciones.getPositionOfElement(R1)!=-1){
                Rx.eliminarRelacion(R1);
                Lista.current.element=Rx;
            }
            i++;
            Lista.next();
        }
    }
    
    public static void main (String[] args){
        Grafo Graf = new Grafo();
        NodoGrafo NodoA = new NodoGrafo("A");
        NodoGrafo NodoB = new NodoGrafo("B");
        NodoGrafo NodoC = new NodoGrafo("C");
        NodoGrafo NodoD = new NodoGrafo("D");
        NodoGrafo NodoE = new NodoGrafo("E");
        NodoGrafo NodoF = new NodoGrafo("F");
        NodoGrafo NodoG = new NodoGrafo("G");
        NodoGrafo NodoH = new NodoGrafo("H");
        NodoGrafo NodoI = new NodoGrafo("I");
        NodoGrafo NodoJ = new NodoGrafo("J");
        NodoGrafo NodoK = new NodoGrafo("K");
        System.out.println("Se crean los Nodos Grafo");
        //************************************
        //************************************
        Graf.Agregar(NodoA);
        Graf.Agregar(NodoB);
        Graf.Agregar(NodoC);
        Graf.Agregar(NodoD);
        Graf.Agregar(NodoE);
        Graf.Agregar(NodoF);
        Graf.Agregar(NodoG);
        Graf.Agregar(NodoH);
        Graf.Agregar(NodoI);
        Graf.Agregar(NodoJ);
        Graf.Agregar(NodoK);
        System.out.println("Se agregan al grafo");
        //************************************
        //************************************
        Graf.AgregarRelacion(NodoA, NodoB, 14);
        Graf.AgregarRelacion(NodoA, NodoD, 8);
        Graf.AgregarRelacion(NodoA, NodoF, 19);
        Graf.AgregarRelacion(NodoB, NodoD, 31);
        Graf.AgregarRelacion(NodoB, NodoE, 3);
        Graf.AgregarRelacion(NodoD, NodoG, 5);
        Graf.AgregarRelacion(NodoD, NodoC, 46);
        Graf.AgregarRelacion(NodoG, NodoE, 31);
        Graf.AgregarRelacion(NodoG, NodoJ, 45);
        Graf.AgregarRelacion(NodoG, NodoK, 46);
        Graf.AgregarRelacion(NodoE, NodoI, 9);
        Graf.AgregarRelacion(NodoI, NodoH, 30);
        Graf.AgregarRelacion(NodoI, NodoF, 26);
        Graf.AgregarRelacion(NodoF, NodoH, 27);
        Graf.AgregarRelacion(NodoF, NodoC, 4);
        
        Graf.AgregarRelacion(NodoB, NodoA, 14);
        Graf.AgregarRelacion(NodoD, NodoA, 8);
        Graf.AgregarRelacion(NodoF, NodoA, 19);
        
        Graf.AgregarRelacion(NodoD, NodoB, 31);
        Graf.AgregarRelacion(NodoE, NodoB, 3);
        
        Graf.AgregarRelacion(NodoG, NodoD, 5);
        Graf.AgregarRelacion(NodoC, NodoD, 46);
        
        Graf.AgregarRelacion(NodoE, NodoG, 31);
        Graf.AgregarRelacion(NodoJ, NodoG, 45);
        Graf.AgregarRelacion(NodoJ, NodoG, 46);
        
        Graf.AgregarRelacion(NodoI, NodoE, 9);
        
        Graf.AgregarRelacion(NodoH, NodoI, 30);
        Graf.AgregarRelacion(NodoF, NodoI, 26);
        
        Graf.AgregarRelacion(NodoH, NodoF, 27);
        Graf.AgregarRelacion(NodoC, NodoF, 4);
        
        System.out.println("Se añaden las relaciones");
        //***************************************
        //***************************************
        /**NodoGrafo Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        Temp.Relaciones.next();
        Temp.Distancias.next();
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        System.out.println("/************************");
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        Temp.Relaciones.next();
        Temp.Distancias.next();
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        System.out.println("/************************");
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        System.out.println("/************************");
        Graf.Lista.next();
        Temp = (NodoGrafo) Graf.Lista.current.element;
        System.out.println(Temp.Relaciones.current.getElemento());
        System.out.println(Temp.Distancias.current.getElemento());
        **/
        //***************************************
        //***************************************
        
        System.out.println("Se va a crear el D");
        Dijkstra dijkstra = new Dijkstra(Graf);
        System.out.println("Se crean el Dijkstra");
        dijkstra.ListaNodos.goToStart();
        NodosDijkstra NodoInicio = (NodosDijkstra) dijkstra.ListaNodos.getElement();
        dijkstra.ListaNodos.goToPos(7);
        NodosDijkstra NodoFinal = (NodosDijkstra) dijkstra.ListaNodos.getElement();
        LinkedList Temp = dijkstra.rutamasCorta(NodoInicio, NodoFinal);
        NodosDijkstra Temp2 = (NodosDijkstra) Temp.current.element;
        System.out.println(Temp2.Nodo.Dato);
        Temp.next();
        Temp2 = (NodosDijkstra) Temp.current.element;
        System.out.println(Temp2.Nodo.Dato);
        Temp.next();
        Temp2 = (NodosDijkstra) Temp.current.element;
        System.out.println(Temp2.Nodo.Dato);
        Temp.next();
        Temp2 = (NodosDijkstra) Temp.current.element;
        System.out.println(Temp2.Nodo.Dato);
        System.out.println(dijkstra.PesoTotal);
    }
}
