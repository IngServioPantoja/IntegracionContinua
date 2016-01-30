package co.com.sp.capapersistencia;

import java.sql.SQLException;

import co.com.sp.capadominio.Usuario;

public interface UsuarioDao extends GenericDao<Usuario> {

	/**
	 * @author ServioAndres
	 * @Return Usuario con datos de la cuenta en caso de exitir o sin datos en caso erroneo
	 */
	Usuario iniciarSesion(String usuario, String contrasena)throws SQLException;
	
	Usuario findByUserName(String username)throws SQLException;
}
