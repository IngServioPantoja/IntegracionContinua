package co.com.sp.capapersistencia.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sp.capadominio.Rol;
import co.com.sp.capapersistencia.RolDao;

@Service
public class RolDaoImpl extends GenericDaoImpl<Rol> implements RolDao,Serializable {

	private static final long serialVersionUID = 8687698728894900360L;

	@Autowired
	public RolDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	
}
