package co.com.sp.capapersistencia.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.sp.capapersistencia.GenericDao;
import co.com.sp.capapersistencia.excepciones.PersistenceException;

@Repository
public abstract class GenericDaoImpl<T> implements Serializable, GenericDao<T> {
	
	/**Log de la clase*/
	private static Logger log = Logger.getLogger(GenericDaoImpl.class);
	
	private static final long serialVersionUID = 1020243919685111719L;
	
	protected SessionFactory sessionFactory;

	private Class<T> entityClass;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Autowired
	public GenericDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.entityClass = (Class) pt.getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listar()throws PersistenceException {
		try {
			log.debug("Consultando listados");
			return currentSession().createQuery("SELECT e FROM "+this.entityClass.getSimpleName()+" e").list();
		} catch (Exception e) {
			log.debug("Capa Persistencia: Error al consultar listados "+e);
			throw new PersistenceException("Capa Persistencia: Error al consultar listados",e);
		}
	}

	@SuppressWarnings("unchecked")
	public T encontrarPorId(Long t) throws PersistenceException{
		try {
			log.debug("Consultando entidad por id");
			return (T) currentSession().get(this.entityClass, t);
		} catch (Exception e) {
			log.debug("Capa Persistencia: Error Consultando entidad por id");
			throw new PersistenceException("Capa Persistencia: Error Consultando entidad por id",e);
		}
	}

	public T insertar(T t)throws PersistenceException {
		try {
			log.debug("Registrando entidad");
			currentSession().saveOrUpdate(t);
			return t;
		} catch (Exception e) {
			log.debug("Capa Persistencia: Error Registrando entidad "+e);
			throw new PersistenceException("Capa Persistencia: Error Registrando entidad",e);
		}
	}

	public T actualizar(T t)throws PersistenceException {
		try {
			log.debug("Actualizando entidad");
			currentSession().merge(t);
			return t;
		} catch (Exception e) {
			log.debug("Capa Persistencia: Error Actualizando entidad");
			throw new PersistenceException("Capa Persistencia: Error Actualizando entidad",e);
		}
	}

	public void eliminar(T t)throws PersistenceException {
		try {
			log.debug("Eliminando entidad");
			currentSession().delete(t);
		} catch (Exception e) {
			log.debug("Capa Persistencia: Error Eliminando entidad");
			throw new PersistenceException("Capa Persistencia: Error Eliminando entidad",e);
		}
	}
	
}
