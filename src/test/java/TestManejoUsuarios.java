import datos.*;
import domain.Usuario;

import java.sql.*;
import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);

            Usuario updateUsuario = new Usuario(3, "CoscuMarica", "12345");
            usuarioDAO.update(updateUsuario);
            Usuario newUsuario = new Usuario("FrodoCrack", "12345");
            usuarioDAO.insertar(newUsuario);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transacción");

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


    }
}
