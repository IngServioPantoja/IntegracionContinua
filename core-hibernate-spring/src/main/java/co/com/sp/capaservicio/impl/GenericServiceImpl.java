package co.com.sp.capaservicio.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.sp.capapersistencia.GenericDao;
import co.com.sp.capapersistencia.excepciones.PersistenceException;
import co.com.sp.capaservicio.GenericService;
import co.com.sp.capaservicio.excepciones.BusinessException;

@Service
@Transactional(rollbackFor=BusinessException.class)
public abstract class GenericServiceImpl<T> implements Serializable, GenericService<T> {

	private static Logger log = Logger.getLogger(GenericServiceImpl.class);

	private static final long serialVersionUID = 5213654477241088294L;

	private GenericDao<T> genericDao;

	public List<T> listar() throws BusinessException {
		try {
			log.debug("Consultando listados");
			return genericDao.listar();
		} catch (PersistenceException e) {
			log.debug("Capa de servicio: Error al consultar listados", e);
			throw new BusinessException("Capa de servicio: Error al consultar listados", e);
		}
	}

	public T insertar(T t) throws BusinessException {
		try {
			log.debug("Registrando entidad");
			System.out.println("Registrando entidad");
			genericDao.insertar(t);
			return genericDao.insertar(t);
		} catch (PersistenceException e) {
			log.debug("Capa de servicio: Error Registrando entidad", e);
			throw new BusinessException("Capa de servicio: Error Registrando entidad", e);
		}
	}

	public T encontrarPorId(Long id) throws BusinessException {
		try {
			log.debug("Consultando entidad por id");
			return genericDao.encontrarPorId(id);
		} catch (PersistenceException e) {
			log.debug("Capa de servicio: Error Consultando entidad por id", e);
			throw new BusinessException("Capa de servicio: Error Consultando entidad por id", e);
		}
	}

	public T actualizar(T t) throws BusinessException {
		try {
			log.debug("Actualizando entidad");
			return genericDao.actualizar(t);
		} catch (PersistenceException e) {
			log.debug("Capa de servicio: Error Actualizando entidad", e);
			throw new BusinessException("Capa de servicio: Error Actualizando entidad", e);
		}
	}

	public void eliminar(T t) throws BusinessException {
		try {
			log.debug("Eliminando entidad");
			this.genericDao.eliminar(t);
		} catch (PersistenceException e) {
			log.debug("Capa de servicio: Error Eliminando entidad", e);
			throw new BusinessException("Capa de servicio: Error Eliminando entidad", e);
		}
	}

	protected void setGenericDao(GenericDao<T> genericDao) {
		this.genericDao = genericDao;
	}

	public GenericDao<T> getGenericDao() {
		return genericDao;
	}

}
