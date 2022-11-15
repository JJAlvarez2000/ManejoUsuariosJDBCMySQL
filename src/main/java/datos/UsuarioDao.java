package datos;
import domain.UsuarioDTO;

import java.sql.*;
import java.util.List;

// por patrones de diseno utilizamos esta clase para que sea unica y no se repita, ademas
// logramos una alta cohesion y bajo acoplamiento. Luego la podemos usar con cualquier tecnologia


public interface UsuarioDao {

    public List<UsuarioDTO> select() throws SQLException;

    public int insert(UsuarioDTO usuarioDTO) throws SQLException;

    public int update(UsuarioDTO usuarioDTO) throws SQLException;

    public int delete(UsuarioDTO usuarioDTO) throws SQLException;

}
