/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Dibujos.AdicionarGrafo;
import Dibujos.AgregarArista;
import Implementaciones.Cola;
import Implementaciones.Direcciones;
import Implementaciones.Enlaces;
import Implementaciones.EnviarCorreo;
import Implementaciones.HiloCronometro;
import Implementaciones.Pedidos;
import Implementaciones.LinkedList;
import Implementaciones.TXT;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author MICHAEL
 */
public class Pprincipal extends JFrame {

    public static ArrayList EntraPedidos = new ArrayList();
    public static Cola ColaPedidos = new Cola();
    protected static mxGraph graph = new mxGraph();
    private mxGraphComponent graphComponent;
    public int tiempo;
    public DefaultListModel modelo;
    public DefaultListModel modelo1;
    protected static HashMap m = new HashMap();
    public int repartidores;
    public static ArrayList<HiloCronometro> HilosCronometros = new ArrayList();
            
            
    public static HashMap getM() {
        return m;
    }

    public static mxGraph getGraph() {
        return graph;
    }

    public Timer t;

    public int s, cs, sF;

    /**
     * Creates new form Pprincipal
     */
    public Pprincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultListModel();
        modelo1 = new DefaultListModel();
        ListaPedidos.setModel(modelo);
        ListaDirecciones.setModel(modelo1);
        t = new Timer(10, acciones);

        graphComponent = new mxGraphComponent(graph);
        graphComponent.setPreferredSize(new Dimension(580, 200));
        Panel.add("GRAFO", graphComponent);
        Panel.setLayout(new FlowLayout(FlowLayout.CENTER));

    }

    public class Hilo implements Runnable {

        @Override
        public void run() {
            while (true) {
                Buscando.setText("BUSCANDO PEDIDOS");
                Buscando.setForeground(Color.BLUE);
                int temp = EntraPedidos.size();
                EnviarCorreo correo = new EnviarCorreo();
                correo.Correo();
                int temp2 = EntraPedidos.size();

                if (temp2 > temp) {
                    Buscando.setText("NUEVOS PEDIDOS");
                    Buscando.setForeground(Color.green);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Pprincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    modelo.removeAllElements();
                    int i = 0;

                    while (i < EntraPedidos.size()) {

                        Pedidos agregar = (Pedidos) EntraPedidos.get(i);
                        System.out.println(agregar.getCliente());

                        String Cliente = "Cliente: " + agregar.getCliente();
                        String Recibe = " - Recibe: " + agregar.getRecoje();
                        String Entrega = " - Entrega:" + agregar.getEntrega();

                        System.out.println(Cliente);
                        System.out.println(Recibe);
                        System.out.println(Entrega);
                        String Datos = String.valueOf(Cliente + Recibe + Entrega);

                        modelo.addElement(Datos);

                        i++;
                    }

                    temp = temp2;
                }
                Buscando.setText("SIN PEDIDOS");
                Buscando.setForeground(Color.red);
                try {
                    Thread.sleep(20 * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pprincipal.class.getName()).log(Level.SEVERE,
                            null, ex);
                }

            }
        }

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
                t.start();
                sF = tiempo;
                s = 0;
                cs = 0;

            }
            actualizarLabel();
        }
    };

    public void actualizarLabel() {
        String tiempo = (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
        TiempoT.setText(tiempo);
        String tiempoF = (sF <= 9 ? "0" : "") + sF;
        TiempoF.setText(tiempoF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaDirecciones = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaPedidos = new javax.swing.JList();
        Panel = new javax.swing.JPanel();
        TiempoT = new javax.swing.JLabel();
        TiempoF = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        RepartidoresLista = new javax.swing.JComboBox();
        ComboTiempo = new javax.swing.JComboBox();
        Buscando = new javax.swing.JButton();
        TiempoF1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        TiempoT1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel9.setText("MAPA");

        jLabel7.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel7.setText("REPARTIDORES");

        jLabel8.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel8.setText("TIEMPO SALIDA P.");

        jLabel10.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel10.setText("REPARTIDORES EN RUTA");

        ListaDirecciones.setEnabled(false);
        jScrollPane1.setViewportView(ListaDirecciones);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen1.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel6.setText("LISTA DE PEDIDOS");

        ListaPedidos.setEnabled(false);
        jScrollPane2.setViewportView(ListaPedidos);

        Panel.setBackground(new java.awt.Color(153, 153, 153));
        Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        TiempoT.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        TiempoT.setText("00:00");

        TiempoF.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        TiempoF.setText("00");

        jLabel11.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel11.setText("TIEMPO X REPARTIDOR");

        ComboTiempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ComboTiempoMousePressed(evt);
            }
        });
        ComboTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTiempoActionPerformed(evt);
            }
        });

        Buscando.setEnabled(false);

        TiempoF1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        TiempoF1.setText("00");

        TiempoT1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        TiempoT1.setText("00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ComboTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(141, 141, 141))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(TiempoF1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TiempoT1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(107, 107, 107)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Buscando, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(10, 10, 10)
                                .addComponent(RepartidoresLista, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(TiempoF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(TiempoT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(RepartidoresLista, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(TiempoF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TiempoT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Buscando, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addGap(9, 9, 9)))
                                .addGap(7, 7, 7))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ComboTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TiempoF1)
                                    .addComponent(TiempoT1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

        

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //*******************************************************CREA MAPA  GRAFICO
        TXT leer = new TXT();

        int i = 0;
        int j = 0;
        int h = 0;
        leer.PUNTOS.goToStart();
        while (i < leer.PUNTOS.size()) {
            if (i != 0) {
                Direcciones temp = (Direcciones) leer.PUNTOS.getElement();
                AdicionarGrafo agregar = new AdicionarGrafo(temp.getCodigo());
            }
            leer.PUNTOS.next();
            i++;

        }
        i = 0;
        leer.PUNTOS.goToStart();
        while (i < leer.PUNTOS.size()) {
            if (i != 0) {
                while (j < leer.MAPA.size()) {
                    Direcciones temp = (Direcciones) leer.PUNTOS.getElement();
                    System.out.println("Busca elemento a comparar");
                    Enlaces enlace = (Enlaces) leer.MAPA.getElement();
                    System.out.println("Codigo:" + temp.getCodigo() + "Enlace:" + enlace.getCodigo() + "--");
                    if (temp.getCodigo().equals(enlace.getCodigo())) {
                        System.out.println("Encontro enlace para sacar aristas");
                        LinkedList enl = (LinkedList) enlace.getEnlace();
                        LinkedList peso = (LinkedList) enlace.getPesos();
                        while (h < enl.size()) {
                            System.out.println("Codigo: " + temp.getCodigo());
                            System.out.println("Arista: " + enl.getElement());
                            System.out.println("Peso: " + peso.getElement());
                            String v1 = temp.getCodigo();
                            String enl1 = String.valueOf(enl.getElement());
                            String peso1 = String.valueOf(peso.getElement());

                            AgregarArista arist = new AgregarArista(peso1, v1, enl1+ " ");

                            enl.next();
                            peso.next();
                            h++;
                        }
                        break;

                    }
                    leer.MAPA.next();
                    j++;
                }
            }
            h = 0;
            j = 0;
            leer.MAPA.goToStart();
            leer.PUNTOS.next();
            i++;

        }
        //new Thread(new Hilo()).start();
    }//GEN-LAST:event_formWindowOpened

    private void ComboTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTiempoActionPerformed
        // TODO add your handling code here:
        if(ComboTiempo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog (null, "Usuario seleccione un repartidor dentro de esta listque se le muestra", "Title", JOptionPane.ERROR_MESSAGE);
            
        }
        else{
            HiloCronometro hilo =(HiloCronometro) HilosCronometros.get(ComboTiempo.getSelectedIndex());
            System.out.println("Asigana el Hilo");
            hilo.setTiempo(Integer.valueOf(jTextField1.getText()));
            Thread hilo1 = new Thread(hilo);
            hilo1.start();
            
        }
        
    }//GEN-LAST:event_ComboTiempoActionPerformed

    private void ComboTiempoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboTiempoMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ComboTiempoMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pprincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscando;
    public javax.swing.JComboBox ComboTiempo;
    private javax.swing.JList ListaDirecciones;
    public javax.swing.JList ListaPedidos;
    private javax.swing.JPanel Panel;
    public javax.swing.JComboBox RepartidoresLista;
    public javax.swing.JLabel TiempoF;
    public static javax.swing.JLabel TiempoF1;
    public javax.swing.JLabel TiempoT;
    public static javax.swing.JLabel TiempoT1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
