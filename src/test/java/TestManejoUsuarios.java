import datos.*;
import domain.UsuarioDTO;

import java.sql.*;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioDaoJDBC usuarioDAO = new UsuarioDaoJDBC(conexion);

            UsuarioDTO updateUsuarioDTO = new UsuarioDTO(3, "CoscuMarica", "12345");
            usuarioDAO.update(updateUsuarioDTO);
            UsuarioDTO newUsuarioDTO = new UsuarioDTO("FrodoCrack", "12345");
            usuarioDAO.insert(newUsuarioDTO);

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
