package co.com.sp.capaservicio.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.sp.capadominio.Persona;
import co.com.sp.capapersistencia.PersonaDao;
import co.com.sp.capaservicio.PersonaService;
import co.com.sp.capaservicio.excepciones.BusinessException;

@Service("personaService")
@Transactional
public class PersonaServiceImpl extends GenericServiceImpl<Persona>  implements PersonaService {
	
	private static Logger log = Logger.getLogger(PersonaServiceImpl.class);
	
	private static final long serialVersionUID = 6641349706597372948L;

	@Autowired
	private PersonaDao personaDao;

	@Autowired
	public PersonaServiceImpl(PersonaDao personaDao) {
		this.setGenericDao(personaDao);
	}
	
	@Autowired
	protected SessionFactory sessionFactory;

	public boolean encontrarCedula(String cedula)throws BusinessException{
		System.out.println(cedula);
		try {
			log.debug("Consultando persona por cedula");
			return personaDao.encontrarCedula(cedula);
		} catch (Exception e) {
			log.debug("Capa Persistencia: Error Consultando persona por cedula "+e);
			throw new BusinessException("Capa Persistencia: Consultando persona por cedula",e);
		}
	}
	
	public Persona encontrarPorIdCompleta(Long idPersona) throws BusinessException{
		try {
			log.debug("Consultando persona por id y completa");
			return personaDao.encontrarPorIdCompleta(idPersona);
		} catch (Exception e) {
			log.debug("Capa Persistencia: Error Consultando persona por id y completa "+e);
			throw new BusinessException("Capa Persistencia: Consultando persona por id y completa",e);
		}
	}
	
	public List<Persona> listarServiceArray()throws BusinessException{
		return sessionFactory.getCurrentSession().createCriteria(Persona.class).list();
	}
}