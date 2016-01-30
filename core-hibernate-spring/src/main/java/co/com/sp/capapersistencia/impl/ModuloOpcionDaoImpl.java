package co.com.sp.capapersistencia.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sp.capadominio.ModuloOpcion;
import co.com.sp.capadominio.Rol;
import co.com.sp.capapersistencia.ModuloOpcionDao;

@Service
public class ModuloOpcionDaoImpl extends GenericDaoImpl<ModuloOpcion> implements Serializable, ModuloOpcionDao {

	private static final long serialVersionUID = 3741212114809244607L;
	
	@Autowired
	public ModuloOpcionDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<ModuloOpcion> findByRol(Rol rol)throws SQLException {
		Query query = null;
		query = currentSession().getNamedQuery("ModuloOpcion.findByRol");
		query.setParameter("idRol", rol.getIdRol());
		List<ModuloOpcion> lstModuloOpcion =  query.list(); 
		return lstModuloOpcion;
	}


}
