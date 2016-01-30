package co.com.sp.capaservicio.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.sp.capadominio.Usuario;
import co.com.sp.capadominio.UsuarioRol;
import co.com.sp.capapersistencia.UsuarioDao;
import co.com.sp.capaservicio.UsuarioService;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService,UserDetailsService, Serializable {

	private static final long serialVersionUID = 2807572921740573681L;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioDao usuarioDao) {
		this.setGenericDao(usuarioDao);
	}

	public Usuario iniciarSesion(String usuario, String password) throws SQLException  {
		return usuarioDao.iniciarSesion(usuario, password);
	}

	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		Usuario user = null;
		try {
			user = usuarioDao.findByUserName(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUsuarioRoles());

		return buildUserForAuthentication(user, authorities);
		

	}

	private User buildUserForAuthentication(Usuario user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isActivo(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<UsuarioRol> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (UsuarioRol userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRol().getSigla()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
