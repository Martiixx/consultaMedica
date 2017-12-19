package evaluacion3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.Agregar;
import vista.Consultas;
import vista.Listar;
import javax.swing.*;
import modelo.Modelo;

/**
 *
 * @author diego
 */
public class Controlador implements ActionListener, MouseListener,FocusListener{
    
    
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
            SwingUtilities.updateComponentTreeUI( this.delete);
            SwingUtilities.updateComponentTreeUI( this.list);
            SwingUtilities.updateComponentTreeUI( this.search);
            //SwingUtilities.updateComponentTreeUI( this.modProd );
            this.vistaPrincipal.setLocationRelativeTo(null);
            this.vistaPrincipal.setTitle("Examen");
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
                
            case btnVolver3:
                this.search.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
                
            case btnVolver4:
                this.delete.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
            
            case btnVolver2:
                this.list.setVisible(false);
                this.vistaPrincipal.setVisible(true);
                break;
                
            case btnModificar:
                if(this.search.radioCasado2.isSelected()){
                    est_civil = "c";
                }
                if(this.search.radioSoltero2.isSelected()){
                    est_civil = "s";
                }
                if(this.search.radioViudo2.isSelected()){
                    est_civil = "v";
                }
                depto = String.valueOf(this.search.comboDepto2.getSelectedItem());
               if(this.modelo.modificaEmpleado(Integer.parseInt(this.search.txtCodigo2.getText()), this.search.txtRut2.getText(), this.search.txtNombre2.getText(),this.search.txtApellido2.getText(), Integer.parseInt(this.search.txtCelular2.getText()), this.search.txtEmail2.getText(), Integer.parseInt(this.search.txtSueldo2.getText()), est_civil, depto)){
                
                JOptionPane.showMessageDialog(null,"Empleado modificado correctamente");
                
                }else{
                   JOptionPane.showMessageDialog(null,"No se pudo modificar empleado");
               }

        }
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
