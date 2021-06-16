import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection conexion = null;

        //INSERT

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //hace referencia a la librería
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proyectofinalprueba",
                    "root", "********");
        } catch (ClassNotFoundException exception) {
            exception.getStackTrace();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

        String queryInsert = "INSERT INTO user(nombre, documento) VALUES (?,?);"; //no pongo iduser porque
        //es autoincremental
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.prepareStatement(queryInsert);
            sentencia.setString(1, "Karen");
            sentencia.setInt(2, 40);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

        //SELECT

        String querySelect = "SELECT * FROM proyectofinalprueba.user;";
        ResultSet rs = null;

        try {
            sentencia = conexion.prepareStatement(querySelect);
            rs = sentencia.executeQuery(querySelect);

            while (rs.next()){
               String iduser = rs.getString("iduser");
               String nombre = rs.getString("nombre");
               String documento = rs.getString("documento");

                System.out.println(iduser + " " + nombre + " " + documento);
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }

        //DELETE

        String queryDelete = "DELETE FROM `proyectofinalprueba`.`user` WHERE (`iduser` = '2');";

        try {
            sentencia = conexion.prepareStatement(queryDelete);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

       querySelect = "SELECT * FROM proyectofinalprueba.user;";

        try {
            sentencia = conexion.prepareStatement(querySelect);
            rs = sentencia.executeQuery(querySelect);

            while (rs.next()){
                String iduser = rs.getString("iduser");
                String nombre = rs.getString("nombre");
                String documento = rs.getString("documento");

                System.out.println(iduser + " " + nombre + " " + documento);
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }

    }

}
