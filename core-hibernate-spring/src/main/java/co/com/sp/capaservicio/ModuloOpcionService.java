package co.com.sp.capaservicio;

import java.sql.SQLException;
import java.util.List;

import co.com.sp.capadominio.ModuloOpcion;
import co.com.sp.capadominio.Rol;

public interface ModuloOpcionService extends GenericService<ModuloOpcion> {
	
	public List<ModuloOpcion> findByRol(Rol rol)throws SQLException;
}
