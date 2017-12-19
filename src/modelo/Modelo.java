package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sql.conexion;


public class Modelo extends conexion {
     
    
    public DefaultTableModel ListadoPacientes(){
    DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Rut","Nombre","Genero","Edad","Direccion","Ciudad","Isapre","Donante"};
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM paciente");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
      Object[][] data = new String[registros][9];
      
      try{
          PreparedStatement pstm = this.getConexion().prepareStatement("SELECT rut,nombre,genero,edad,direccion,ciudad,isapre,donante FROM paciente ;");
        /*if(!departamento.isEmpty()){
            System.out.println("ok");
            pstm = this.getConexion().prepareStatement("SELECT codigo,rut,nombre,apellido,celular,email,sueldo_bruto,est_civil,nom_depto FROM empleado where nom_depto='"+departamento+"' ;");
        */
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "rut");
                data[i][1] = res.getString( "nombre" );
                data[i][2] = res.getString( "genero" );
                data[i][3] = res.getString( "edad" );
                data[i][4] = res.getString( "direccion" );
                data[i][5] = res.getString( "ciudad" );
                data[i][6] = res.getString( "isapre" );
                data[i][7] = res.getString( "donante" );                
            i++;
         }
         res.close();
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
}
    
    public String[] buscarPaciente(int rut){
        String[] datos=new String[9];
        if(existe(rut)){
            String query = "SELECT rut,nombre,genero,edad,direccion,ciudad,isapre,donante FROM paciente  where rut="+rut+";";
            try{
            PreparedStatement pstm = this.getConexion().prepareStatement(query);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
            datos[0]=res.getString("rut");
            datos[1]=res.getString("nombre");
            datos[2]=res.getString("genero");
            datos[3]=res.getString("edad");
            datos[4]=res.getString("direccion");
            datos[5]=res.getString("ciudad");
            datos[6]=res.getString("isapre");
            datos[7]=res.getString("donante");
            }
            res.close();        
            }
            catch(SQLException e){
            System.err.println( e.getMessage() );
            }
            return datos;}
            JOptionPane.showMessageDialog(null,"No se ha encontrado al paciente "+rut+" ");
        return datos;
    }
    
    public boolean ingresoEmpleado(String rut, String nombre, String genero, int edad, String direccion, String ciudad, String isapre, String donante){
        //if(valida_datos(codigo,rut,nombre,apellido,celular,email,sueldo,eCivil,depto)){
            String query = "INSERT INTO usuario01.empleado (rut,nombre,genero,edad,direccion,ciudad,isapre,donante) values ('"+rut+"','"+nombre+"','"+genero+"','"+edad+"','"+direccion+"','"+ciudad+"','"+isapre+"','"+donante+"');";
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(query);               
                pstm.execute();               
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        //}
        //else{
            //return false;
        }
    
    
    public boolean modificaEmpleado(String rut, String nombre, String genero, int edad, String direccion, String ciudad, String isapre, String donante){
        //if(valida_datos(codigo,rut,nombre,apellido,celular,email,sueldo,eCivil,depto)){
            String query = "UPDATE consultamedica.paciente SET nombre='"+nombre+"',genero='"+genero+"',edad='"+edad+"',direccion='"+direccion+"',ciudad='"+ciudad+"',isapre='"+isapre+"',donante='"+donante+"' where rut='"+rut+"';";
            try {
                PreparedStatement pstm = this.getConexion().prepareStatement(query);               
                pstm.execute();               
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        //}
        //else{
        //    return false;
        //}
}
    
    public boolean eliminaEmpleado(int rut){
       //if(existe(codigo)){
        String query = "DELETE FROM consultamedica.paciente where rut="+rut+";";
        try {
                PreparedStatement pstm = this.getConexion().prepareStatement(query);               
                pstm.execute();               
                pstm.close();
                JOptionPane.showMessageDialog(null,"Paciente "+rut+" ha sido eliminado de la base de datos");
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            JOptionPane.showMessageDialog(null,"Paciente "+rut+" no ha sido encontrado, no se puede eliminar");
            return false;
    //}
       //return false;
    }
    
    
    private boolean existe(int rut){
        int registros=0;
        try{
            String query = "select count(*) as total from empleado where rut="+rut+";";
            PreparedStatement pstm = this.getConexion().prepareStatement(query);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        if(registros==0){
         return false;
        }else{
            return true;
        }
    }
    //agregar FocusListener a controlador
            
    private boolean valida_datos(String rut, String nombre, String genero, int edad, String direccion, String ciudad, String isapre, String donante){//enviar parametros a validar
        if(rut.length()<9){
            JOptionPane.showMessageDialog(null,"Rut invalido, ingrese nuevamente");
            return false;
        } 
        else{
            return true;
        }
    }
    
    }