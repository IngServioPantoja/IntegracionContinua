package co.com.sp.capaservicio;

import java.util.List;

import co.com.sp.capaservicio.excepciones.BusinessException;

public interface GenericService<T> {

    List<T> listar()throws BusinessException; 

    T insertar(T t)throws BusinessException; 

    T encontrarPorId(Long id)throws BusinessException; 

    T actualizar(T t)throws BusinessException;   

    void eliminar(T t)throws BusinessException; 
}
