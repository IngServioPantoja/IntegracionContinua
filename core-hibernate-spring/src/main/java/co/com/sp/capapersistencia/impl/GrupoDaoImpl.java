package co.com.sp.capapersistencia.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.sp.capadominio.Grupo;
import co.com.sp.capapersistencia.GrupoDao;

@Repository
public class GrupoDaoImpl extends GenericDaoImpl<Grupo> implements GrupoDao, Serializable {

	private static final long serialVersionUID = -2477192798003721698L;

	@Autowired
	public GrupoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
