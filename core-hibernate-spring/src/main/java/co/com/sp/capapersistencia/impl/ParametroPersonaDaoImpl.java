package co.com.sp.capapersistencia.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.sp.capadominio.ParametroPersona;
import co.com.sp.capapersistencia.ParametroPersonaDao;
import co.com.sp.capapersistencia.excepciones.PersistenceException;

@Repository
public class ParametroPersonaDaoImpl extends GenericDaoImpl<ParametroPersona> implements ParametroPersonaDao,Serializable {
	
	/**Log de la clase*/
	private static Logger log = Logger.getLogger(ParametroPersonaDaoImpl.class);
	
	@Autowired
	public ParametroPersonaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	private static final long serialVersionUID = -438777477023653218L;
	
	@SuppressWarnings("unchecked")
	public List<ParametroPersona> findByTipo(Long idTipo)throws PersistenceException{
		try {
			log.debug("Consultando parametros de un determinado tipo");
			Query query = currentSession().getNamedQuery("ParametroPersona.findByTipo");
			query.setParameter("idTipoParametroPersona", idTipo);
			return query.list(); 
		} catch (Exception e) {
			log.debug("Capa Persistencia: Error al consultar parametros de un tipo "+e);
			throw new PersistenceException("Capa Persistencia: Error al consultar parametros de un tipo",e);
		}
			

	}
}
