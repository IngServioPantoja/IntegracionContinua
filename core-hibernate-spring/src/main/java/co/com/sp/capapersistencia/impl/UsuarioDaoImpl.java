package co.com.sp.capapersistencia.impl;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.sp.capadominio.Usuario;
import co.com.sp.capapersistencia.UsuarioDao;

@Repository
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario> implements UsuarioDao, Serializable {


	private static final long serialVersionUID = -3367343963076410688L;

	@Autowired
	public UsuarioDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public Usuario findByUserName(String username) {

		List<Usuario> users = new ArrayList<Usuario>();

		Query query = currentSession().createQuery("from Usuario where username=?");
		query.setParameter(0, username);
		users = query.list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
	public Usuario iniciarSesion(String usuario, String contrasena)throws SQLException{
		Query query = currentSession().createQuery("FROM Usuario u "
		+ "LEFT JOIN FETCH u.usuarioRoles as uuR "
		+ "LEFT JOIN FETCH uuR.rol as uuRr "
		+ "WHERE u.username = :username AND u.password = :password");
		query.setParameter("username", usuario);
		MessageDigest md;
		try {
		md = MessageDigest.getInstance("MD5");
		
	    md.update(contrasena.getBytes());

	    byte byteData[] = md.digest();

	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < byteData.length; i++)
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

	    System.out.println("Digest(in hex format):: " + sb.toString());
		query.setParameter("password", sb.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return (Usuario) query.uniqueResult();
		
	}

}
