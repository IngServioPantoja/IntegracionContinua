package co.com.sp.capapersistencia.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.sp.capadominio.Persona;
import co.com.sp.capapersistencia.PersonaDao;
import co.com.sp.capapersistencia.excepciones.PersistenceException;

@Repository
public class PersonaDaoImpl extends GenericDaoImpl<Persona> implements PersonaDao {
	
	private static final long serialVersionUID = -1745907453415561590L;

	@Autowired
	public PersonaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public long contadorPersonas() {
		Long contador = (Long) currentSession().createCriteria(Persona.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		return contador.longValue();
	}

	public Persona getPersonaByEmail(Persona persona) {
		Example personaEjemplo = Example.create(persona);
		return (Persona) currentSession().createCriteria(Persona.class)
				.add(personaEjemplo).uniqueResult();
	}
	
	public boolean encontrarCedula(String cedula)throws PersistenceException{
		
		try{
		 	Query query = currentSession().createQuery("from Persona p where p.identificacion = :identificacion");
			query.setParameter("identificacion", cedula);
			@SuppressWarnings("unused")
			Persona persona = (Persona) query.list();
			return true;
	    } catch(NoResultException e) {
	        return false;
	    }
	}
	
	@SuppressWarnings("unchecked")
	public Persona encontrarPorIdCompleta(Long idPersona)throws PersistenceException{
		Query query = currentSession().getNamedQuery("personaComplete");
		query.setParameter("idPersona", idPersona);
		query.setMaxResults(1);
		List<Persona> personas = query.list();
		return personas.get(0);
	}
}