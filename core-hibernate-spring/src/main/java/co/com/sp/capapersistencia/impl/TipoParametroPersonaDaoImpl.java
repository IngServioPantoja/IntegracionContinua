package co.com.sp.capapersistencia.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.sp.capadominio.TipoParametroPersona;
import co.com.sp.capapersistencia.TipoParametroPersonaDao;

public class TipoParametroPersonaDaoImpl extends GenericDaoImpl<TipoParametroPersona> implements TipoParametroPersonaDao, Serializable {
	

	private static final long serialVersionUID = -438777477023653218L;
	
	@Autowired
	public TipoParametroPersonaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
