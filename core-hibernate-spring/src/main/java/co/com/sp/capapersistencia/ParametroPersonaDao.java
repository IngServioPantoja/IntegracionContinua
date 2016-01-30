package co.com.sp.capapersistencia;

import java.util.List;

import co.com.sp.capadominio.ParametroPersona;
import co.com.sp.capapersistencia.excepciones.PersistenceException;


public interface ParametroPersonaDao extends GenericDao<ParametroPersona> {

	public List<ParametroPersona> findByTipo(Long idTipo)throws PersistenceException;
	
}
