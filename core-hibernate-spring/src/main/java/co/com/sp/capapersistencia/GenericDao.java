package co.com.sp.capapersistencia;

import java.util.List;

import co.com.sp.capapersistencia.excepciones.PersistenceException;

public interface GenericDao<T> {
	
	T insertar(T t)throws PersistenceException;

    void eliminar(T t)throws PersistenceException;

    T encontrarPorId(Long id)throws PersistenceException;

    T actualizar(T t)throws PersistenceException;  

    List<T> listar()throws PersistenceException;  
}
