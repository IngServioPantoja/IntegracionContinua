package co.com.sp.capaservicio;

import java.util.List;

import co.com.sp.capadominio.ParametroPersona;
import co.com.sp.capaservicio.excepciones.BusinessException;

public interface ParametroPersonaService extends GenericService<ParametroPersona>{
	
	public List<ParametroPersona> findByTipo(Long idTipo)throws BusinessException;
	
}
