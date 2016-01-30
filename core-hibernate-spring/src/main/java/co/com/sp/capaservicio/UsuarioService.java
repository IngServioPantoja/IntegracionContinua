package co.com.sp.capaservicio;

import java.sql.SQLException;

import org.springframework.security.core.userdetails.UserDetails;

import co.com.sp.capadominio.Usuario;

public interface UsuarioService extends GenericService<Usuario>  {

	Usuario iniciarSesion(String usuario, String password) throws SQLException ;
	
	UserDetails loadUserByUsername(String username) throws SQLException ;
}
