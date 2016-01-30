package co.com.sp.capapersistencia;

import co.com.sp.capadominio.Persona;
import co.com.sp.capapersistencia.excepciones.PersistenceException;

public interface PersonaDao extends GenericDao<Persona> {
	
	long contadorPersonas();

	Persona getPersonaByEmail(Persona persona);
	
	boolean encontrarCedula(String cedula)throws PersistenceException;

	Persona encontrarPorIdCompleta(Long idPersona)throws PersistenceException;
}
