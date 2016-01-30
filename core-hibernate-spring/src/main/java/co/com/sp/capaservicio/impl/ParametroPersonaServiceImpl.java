package co.com.sp.capaservicio.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.sp.capadominio.ParametroPersona;
import co.com.sp.capapersistencia.ParametroPersonaDao;
import co.com.sp.capapersistencia.excepciones.PersistenceException;
import co.com.sp.capaservicio.ParametroPersonaService;
import co.com.sp.capaservicio.excepciones.BusinessException;

@Service
@Transactional
public class ParametroPersonaServiceImpl extends GenericServiceImpl<ParametroPersona> implements Serializable, ParametroPersonaService {
	
	private static Logger log = Logger.getLogger(ParametroPersonaServiceImpl.class);
	
	private static final long serialVersionUID = 853093025615386971L;

	@Autowired
	private ParametroPersonaDao parametroPersonaDao;
	
	@Autowired
	public ParametroPersonaServiceImpl(ParametroPersonaDao parametroPersonaDao) {
		this.setGenericDao(parametroPersonaDao);
	}

	public List<ParametroPersona> findByTipo(Long idTipo)throws BusinessException {
		try {
			log.debug("Consultando parametros por tipo");
			return parametroPersonaDao.findByTipo(idTipo);
		} catch (PersistenceException e) {
			log.debug("Capa de servicio: Error Consultando parametros por tipo", e);
			throw new BusinessException("Capa de servicio: Error Consultando parametros por tipo", e);
		}
	}

}
