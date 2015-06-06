/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author MICHAEL
 */
public class TXT {

    public static LinkedList PUNTOS = new LinkedList();
    public static LinkedList MAPA = new LinkedList();

    public ArrayList<LinkedList> INFO = new ArrayList<LinkedList>();

    public void Puntos(String file) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            while ((linea = br.readLine()) != null) {
                String codigo = "";
                String direccion = "";
                String espacio = " ";
                boolean flag1 = true;
                boolean flag2 = true;
                char[] informacion = linea.toCharArray();

                int i = 0;
                while (i < informacion.length) {
                    //***********************************************************CODIGO
                    if (flag1) {
                        char elemento = informacion[i];

                        if (linea.equals("PUNTOS")) {
                            break;
                        }

                        if (String.valueOf(elemento).equals(espacio)) {
                            flag1 = false;
                            flag2 = false;
                        }
                        if (linea.equals("MAPA")) {
                            return;
                        }

                        codigo += String.valueOf(elemento);

                        i++;
                    }
                    //***********************************************************DIRECCION
                    if (flag2 == false) {
                        char elemento = informacion[i];

                        direccion += String.valueOf(elemento);

                        if (linea.equals("MAPA")) {
                            return;
                        }
                        i++;
                    }

                }

                Direcciones punto = new Direcciones(codigo, direccion);
                PUNTOS.append(punto);

            }

            //****SIN IMPORTANCIA
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                    System.out.println("DONE!!  :"+ PUNTOS.size());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void Mapa(String file) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            boolean FLAG = true;

            while ((linea = br.readLine()) != null) {
                if (linea.equals("MAPA")) {
                    FLAG = false;
                }

                if (FLAG == false) {
                    String principal = "";
                    String enlaces = "";
                    String espacio = " ";

                    boolean flag1 = true;
                    boolean flag2 = true;
                    char[] informacion = linea.toCharArray();

                    int i = 0;
                    while (i < informacion.length) {

                        //***********************************************************CODIGO
                        if (flag1) {
                            char elemento = informacion[i];

                            if (String.valueOf(elemento).equals(espacio)) {
                                flag1 = false;
                                flag2 = false;
                            }

                            principal += String.valueOf(elemento);

                            i++;
                        }
                        //***********************************************************PROVINCIA
                        if (flag2 == false) {
                            char elemento = informacion[i];

                            enlaces += String.valueOf(elemento);

                            if (linea.equals("MAPA")) {
                                return;
                            }
                            i++;
                        }

                    }
                    EnlazePeso(enlaces);

                    Enlaces Map = new Enlaces(principal, INFO.get(0), INFO.get(1));
                    MAPA.append(Map);
                    INFO.clear();

                }
            }

            //****SIN IMPORTANCIA
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                    System.out.println("DONE!!");
                    System.out.println(MAPA.size());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ArrayList EnlazePeso(String linea) {
        LinkedList ENLACES = new LinkedList();
        LinkedList PESOS = new LinkedList();

        char[] arreglo = linea.toCharArray();

        int i = 0;
        String enlace = "";
        String peso = "";
        char espacio = ' ';
        char abre = '(';
        char cierra = ')';
        boolean flag = true;
        boolean flag1 = true;
        while (i < arreglo.length) {

            if (flag) {
                if ((arreglo[i] != espacio) && (arreglo[i] != abre)) {
                    enlace += arreglo[i];
                }
                if (arreglo[i] == abre) {
                    flag = false;
                    flag1 = false;
                    ENLACES.append(enlace);
                    enlace = "";
                }

            }
            if (flag1 == false) {
                if ((arreglo[i] != cierra) && (arreglo[i] != abre)) {
                    peso += arreglo[i];
                }
                if (arreglo[i] == cierra) {
                    flag = true;
                    flag1 = true;
                    PESOS.append(peso);
                    peso = "";
                }

            }
            i++;
        }
        INFO.add(ENLACES);
        INFO.add(PESOS);
        return INFO;
    }
    //public 

}
