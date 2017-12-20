package evaluacion3;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import vista.Agregar;
import vista.Consultas;
import vista.Listar;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import modelo.Modelo;

/**
 *
 * @author diego
 */
public class Controlador extends JComponent implements ActionListener, MouseListener,FocusListener,TableModelListener, Scrollable, TableColumnModelListener, ListSelectionListener, CellEditorListener, Accessible, RowSorterListener{
    
    
    private Consultas vistaPrincipal;
    private Agregar addEmp = new Agregar();
    private Listar list = new Listar();

    String[] empleado;
    String departamento = "";

    String genero;
    String isapre;
    String donante;

    
    private Modelo modelo = new Modelo();

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void columnAdded(TableColumnModelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void columnRemoved(TableColumnModelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void columnMoved(TableColumnModelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void columnMarginChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void columnSelectionChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editingStopped(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sorterChanged(RowSorterEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum Accion{
        
        menuSalir, //cierra el programa
        MenuAgregarEmpleados,//abre vista Agregar
        MenuListarEmpleados, //abre vista Listar
        MenuBuscarEmpleado, //abre vista Buscar
        MenuEliminarEmpleado,//abre vista Eliminar
        btnAgregar, //agrega empleado
        btnLimpiar,//limpia pantalla agregar
        btnVolver, //regresa a vista consultas
        radioSi,
        radioNo,
        radioSi1,
        radioNo1,
        btnBuscar,        
        btnModificar,
        btnVolver2,
        radioMasculino,
        radioFemenino,
        radioMasculino2,
        radioFemenino2,
        radioSi2,
        radioNo2,
        radioSi3,
        radioNo3,
        btnEliminar,        
        MenuFunciones,
        menuFile
        
        
        
        
    }
    
    
    public Controlador (JFrame padre){
        
        this.vistaPrincipal = (Consultas) padre;
    }
    
   
    
    public void iniciar(){
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vistaPrincipal);
            SwingUtilities.updateComponentTreeUI( this.addEmp );           
            SwingUtilities.updateComponentTreeUI( this.list);           
            this.vistaPrincipal.setLocationRelativeTo(null);
            this.vistaPrincipal.setTitle("Consulta Médica");
            this.vistaPrincipal.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
        
        
        this.vistaPrincipal.MenuAgregarEmpleados.addActionListener(this);
        this.vistaPrincipal.MenuAgregarEmpleados.setActionCommand("MenuAgregarEmpleados");
        
        this.vistaPrincipal.MenuBuscarEmpleado.setActionCommand("MenuBuscarEmpleado");
        this.vistaPrincipal.MenuBuscarEmpleado.addActionListener(this);
        
        this.vistaPrincipal.MenuEliminarEmpleado.setActionCommand("MenuEliminarEmpleado");
        this.vistaPrincipal.MenuEliminarEmpleado.addActionListener(this);
        
        this.vistaPrincipal.MenuListarEmpleados.setActionCommand("MenuListarEmpleados");
        this.vistaPrincipal.MenuListarEmpleados.addActionListener(this);
        
        this.vistaPrincipal.MenuFunciones.setActionCommand("MenuFunciones");
        this.vistaPrincipal.MenuFunciones.addActionListener(this);
        
        this.vistaPrincipal.menuFile.setActionCommand("menuFile");
        this.vistaPrincipal.menuFile.addActionListener(this);
        
        this.vistaPrincipal.menuSalir.setActionCommand("menuSalir");
        this.vistaPrincipal.menuSalir.addActionListener(this);
        
        this.addEmp.btnAgregar.setActionCommand("btnAgregar");
        this.addEmp.btnAgregar.addActionListener(this);
        
        this.addEmp.btnLimpiar.setActionCommand("btnLimpiar");
        this.addEmp.btnLimpiar.addActionListener(this);
        
        this.addEmp.btnVolver.setActionCommand("btnVolver");
        this.addEmp.btnVolver.addActionListener(this);
        
        
        this.addEmp.radioMasculino.setActionCommand("radioMasculino");
        
        this.addEmp.radioFemenino.setActionCommand("radioFemenino");
        
        
        this.addEmp.radioSi.setActionCommand("radioSi");
        
        
        this.addEmp.radioNo.setActionCommand("radioNo");
       
        
        this.addEmp.radioSi1.setActionCommand("radioSi1");
        
        this.addEmp.radioNo1.setActionCommand("radioNo1");
        
        this.list.btnBuscar.setActionCommand("btnbuscar");
        this.list.btnBuscar.addActionListener(this);
        
        this.list.btnEliminar.setActionCommand("btnEliminar");
        this.list.btnEliminar.addActionListener(this);
        
        this.list.btnModificar.setActionCommand("btnModificar");
        this.list.btnModificar.addActionListener(this);
        
        this.list.btnVolver2.setActionCommand("btnVolver2");
        this.list.btnVolver2.addActionListener(this);
        
        this.list.radioFemenino2.setActionCommand("radioFemenino2");
        
        this.list.radioMasculino2.setActionCommand("radioMasculino2");
        
        this.list.radioNo2.setActionCommand("radioNo2");
        
        this.list.radioNo3.setActionCommand("radioNo3");
        
        this.list.radioSi2.setActionCommand("radioSi2");
        
        this.list.radioSi3.setActionCommand("radioSi3");
        
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch ( Accion.valueOf( e.getActionCommand() ) )
        {
            case MenuAgregarEmpleados:
                this.addEmp.setLocationRelativeTo(null);
                this.addEmp.setTitle("Agregar Pacientes");
                this.addEmp.setVisible(true);
                this.vistaPrincipal.setVisible(false);
                this.addEmp.txtEdad.setText("");
                this.addEmp.txtNombre.setText("");
                this.addEmp.txtDireccion.setText("");
                this.addEmp.txtCiudad.setText("");
                this.addEmp.txtRut.setText("");                
                this.addEmp.radioFemenino.setSelected(false);
                this.addEmp.radioMasculino.setSelected(false);
                this.addEmp.radioNo.setSelected(false);
                this.addEmp.radioNo1.setSelected(false);
                this.addEmp.radioSi.setSelected(false);
                this.addEmp.radioSi1.setSelected(false);
                
                
                break;
                
            case MenuListarEmpleados:                
                this.list.setLocationRelativeTo(null);
                this.list.setTitle("Listar Pacientes");
                this.list.setVisible(true);
                this.vistaPrincipal.setVisible(false);
                this.list.tablaEmpleados.setModel(this.modelo.ListadoPacientes());
                this.list.txtEdad2.setText("");
                this.list.txtNombre2.setText("");
                this.list.txtDireccion2.setText("");
                this.list.txtCiudad2.setText("");
                this.list.txtRut2.setText("");                
                this.list.radioFemenino2.setSelected(false);
                this.list.radioMasculino2.setSelected(false);
                this.list.radioNo2.setSelected(false);
                this.list.radioNo3.setSelected(false);
                this.list.radioSi2.setSelected(false);
                this.list.radioSi3.setSelected(false);
                break;
                
            case MenuBuscarEmpleado:
                this.list.setLocationRelativeTo(null);
                this.list.setTitle("Buscar Pacientes");
                this.list.setVisible(true);
                this.vistaPrincipal.setVisible(false);
                this.list.tablaEmpleados.setModel(this.modelo.ListadoPacientes());
                this.list.txtEdad2.setText("");
                this.list.txtNombre2.setText("");
                this.list.txtDireccion2.setText("");
                this.list.txtCiudad2.setText("");
                this.list.txtRut2.setText("");                
                this.list.radioFemenino2.setSelected(false);
                this.list.radioMasculino2.setSelected(false);
                this.list.radioNo2.setSelected(false);
                this.list.radioNo3.setSelected(false);
                this.list.radioSi2.setSelected(false);
                this.list.radioSi3.setSelected(false);
                break;
                
            case MenuEliminarEmpleado:
                this.list.setLocationRelativeTo(null);
                this.list.setTitle("Eliminar Pacientes");
                this.list.setVisible(true);
                this.vistaPrincipal.setVisible(false);
                this.list.tablaEmpleados.setModel(this.modelo.ListadoPacientes());
                this.list.txtEdad2.setText("");
                this.list.txtNombre2.setText("");
                this.list.txtDireccion2.setText("");
                this.list.txtCiudad2.setText("");
                this.list.txtRut2.setText("");                
                this.list.radioFemenino2.setSelected(false);
                this.list.radioMasculino2.setSelected(false);
                this.list.radioNo2.setSelected(false);
                this.list.radioNo3.setSelected(false);
                this.list.radioSi2.setSelected(false);
                this.list.radioSi3.setSelected(false);
                break;
                
            case menuSalir:
                System.exit(0);
                
            case btnAgregar:
                if(this.addEmp.radioFemenino.isSelected()){
                    genero = "f";
                }
                if(this.addEmp.radioMasculino.isSelected()){
                    genero = "m";
                           
                }
                if(this.addEmp.radioNo.isSelected()){
                    isapre= "s";
                }
                if(this.addEmp.radioSi.isSelected()){
                    isapre = "n";
                }
                if(this.addEmp.radioNo1.isSelected()){
                    donante = "n";
                }
                if(this.addEmp.radioSi1.isSelected()){
                    donante = "s";
                }
                if(this.modelo.ingresoEmpleado(this.addEmp.txtRut.getText(), this.addEmp.txtNombre.getText(),genero, Integer.parseInt(this.addEmp.txtEdad.getText()),this.addEmp.txtDireccion.getText(), this.addEmp.txtCiudad.getText(), isapre,donante)){
                    
                    JOptionPane.showMessageDialog(null,"Paciente agregado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null,"No se pudo agregar paciente");
                }
                break;    
                
            case btnLimpiar:
                this.addEmp.txtEdad.setText("");
                this.addEmp.txtNombre.setText("");
                this.addEmp.txtDireccion.setText("");
                this.addEmp.txtCiudad.setText("");
                this.addEmp.txtRut.setText("");                
                this.addEmp.radioFemenino.setSelected(false);
                this.addEmp.radioMasculino.setSelected(false);
                this.addEmp.radioNo.setSelected(false);
                this.addEmp.radioNo1.setSelected(false);
                this.addEmp.radioSi.setSelected(false);
                this.addEmp.radioSi1.setSelected(false);
                break;

            
                
            case btnEliminar:
            
                this.modelo.eliminaEmpleado(this.list.txtRut2.getText());
                break;
             
            
            case btnBuscar:
                empleado= this.modelo.buscarPaciente(this.list.txtRut2.getText());
                this.list.txtRut2.setText(empleado[0]);
                this.list.txtNombre2.setText(empleado[1]);
                
                this.list.txtEdad2.setText(empleado[3]);
                this.list.txtDireccion2.setText(empleado[4]);
                this.list.txtCiudad2.setText(empleado[5]);
                
                if(empleado[2].equals("f")){
                    this.list.radioFemenino2.setSelected(true);
                }
                if(empleado[2].equals("m")){
                    this.list.radioMasculino2.setSelected(true);
                }
                if(empleado[6].equals("s")){
                    this.list.radioSi2.setSelected(true);
                }
                if(empleado[6].equals("n")){
                    this.list.radioNo2.setSelected(true);
                }
                 if(empleado[7].equals("s")){
                    this.list.radioSi3.setSelected(true);
                }
                if(empleado[7].equals("n")){
                    this.list.radioNo3.setSelected(true);
                }
                break;

       
                
            case btnVolver:
                this.addEmp.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
                
           
            case btnVolver2:
                this.list.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
                
            case btnModificar:
                if(this.list.radioFemenino2.isSelected()){
                    genero = "f";
                }
                if(this.list.radioMasculino2.isSelected()){
                    genero = "m";
                           
                }
                if(this.list.radioNo2.isSelected()){
                    isapre= "s";
                }
                if(this.list.radioSi2.isSelected()){
                    isapre = "n";
                }
                if(this.list.radioNo3.isSelected()){
                    donante = "n";
                }
                if(this.list.radioSi3.isSelected()){
                    donante = "s";
                }
               if(this.modelo.modificaEmpleado(this.list.txtRut2.getText(), this.list.txtNombre2.getText(),genero, Integer.parseInt(this.list.txtEdad2.getText()),this.list.txtDireccion2.getText(), this.list.txtCiudad2.getText(), isapre,donante)){
                
                JOptionPane.showMessageDialog(null,"paciente modificado correctamente");
                
                }else{
                   JOptionPane.showMessageDialog(null,"No se pudo modificar paciente");
               }

        }
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      if( e.getButton()== 1)//boton izquierdo
        {
            //Muestro datos de producto a modificar
             int fila = this.list.tablaEmpleados.rowAtPoint(e.getPoint());
             if (fila > -1){
               
                this.list.txtRut2.setText(String.valueOf(this.list.tablaEmpleados.getValueAt(fila, 0) ));
                this.list.txtNombre2.setText(String.valueOf(this.list.tablaEmpleados.getValueAt(fila, 1) )); 
                this.list.buttonGroup1.setSelected(String.valueOf(this.list.tablaEmpleados.getValueAt(fila, 2) ));
                this.list.txtEdad2.setText(String.valueOf(this.list.tablaEmpleados.getValueAt(fila, 3) ));
                this.list.txtDireccion2.setText(String.valueOf(this.list.tablaEmpleados.getValueAt(fila, 4) ));
                this.list.txtCiudad2.setText(String.valueOf(this.list.tablaEmpleados.getValueAt(fila, 5) ));
                this.list.buttonGroup2.setSelected(String.valueOf(this.list.tablaEmpleados.getValueAt(fila, 5) ));
                this.list.buttonGroup3.setSelected(String.valueOf(this.list.tablaEmpleados.getValueAt(fila, 5) ));
           
             }
        }
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
