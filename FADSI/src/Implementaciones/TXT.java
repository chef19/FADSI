/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author MICHAEL
 */
public class TXT {

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
                String provincia = "";
                String direccion = "";
                String espacio = " ";
                boolean flag1 = true;
                boolean flag2 = true;
                boolean flag3 = true;
                char[] informacion = linea.toCharArray();

                int i = 0;
                while (i < informacion.length) {
                    //***********************************************************DIRECCION
                    if (flag3 == false) {
                        char elemento = informacion[i];

                        if (linea.equals("PUNTOS")) {
                            break;
                        }

                        direccion += String.valueOf(elemento);

                        if (linea.equals("MAPA")) {
                            return;
                        }
                        i++;
                    }
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
                    //***********************************************************PROVINCIA
                    if (flag2 == false) {
                        char elemento = informacion[i];

                        if (String.valueOf(elemento).equals(espacio)) {
                            flag3 = false;
                            flag2 = true;

                        }

                        provincia += String.valueOf(elemento);

                        if (linea.equals("MAPA")) {
                            return;
                        }
                        i++;
                    }

                }
                System.out.println(codigo);
                System.out.println(provincia);
                System.out.println(direccion);
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
                    System.out.println(principal);
                    System.out.println(enlaces);
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
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
