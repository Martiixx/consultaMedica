/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author diego
 */
public class Consultas extends javax.swing.JFrame {

    /**
     * Creates new form Consultas
     */
    public Consultas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        MenuFunciones = new javax.swing.JMenu();
        MenuAgregarEmpleados = new javax.swing.JMenuItem();
        MenuListarEmpleados = new javax.swing.JMenuItem();
        MenuEliminarEmpleado = new javax.swing.JMenuItem();
        MenuBuscarEmpleado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menuFile.setText("Archivo");

        menuSalir.setText("Salir");
        menuFile.add(menuSalir);

        jMenuBar1.add(menuFile);

        MenuFunciones.setText("Procesos");

        MenuAgregarEmpleados.setText("Agregar Paciente");
        MenuAgregarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAgregarEmpleadosActionPerformed(evt);
            }
        });
        MenuFunciones.add(MenuAgregarEmpleados);

        MenuListarEmpleados.setText("Listar Pacientes");
        MenuFunciones.add(MenuListarEmpleados);

        MenuEliminarEmpleado.setText("Eliminar Paciente");
        MenuEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEliminarEmpleadoActionPerformed(evt);
            }
        });
        MenuFunciones.add(MenuEliminarEmpleado);

        MenuBuscarEmpleado.setText("Buscar Paciente");
        MenuFunciones.add(MenuBuscarEmpleado);

        jMenuBar1.add(MenuFunciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAgregarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAgregarEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAgregarEmpleadosActionPerformed

    private void MenuEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEliminarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuEliminarEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem MenuAgregarEmpleados;
    public javax.swing.JMenuItem MenuBuscarEmpleado;
    public javax.swing.JMenuItem MenuEliminarEmpleado;
    public javax.swing.JMenu MenuFunciones;
    public javax.swing.JMenuItem MenuListarEmpleados;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu menuFile;
    public javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
}
