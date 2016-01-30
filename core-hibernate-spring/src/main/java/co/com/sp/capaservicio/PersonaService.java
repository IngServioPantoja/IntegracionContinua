package co.com.sp.capaservicio;

import java.util.List;

import co.com.sp.capadominio.Persona;
import co.com.sp.capaservicio.excepciones.BusinessException;

public interface PersonaService extends GenericService<Persona> {
	boolean encontrarCedula(String cedula) throws BusinessException;

	Persona encontrarPorIdCompleta(Long idPersona) throws BusinessException;

	List<Persona> listarServiceArray()throws BusinessException;
}
