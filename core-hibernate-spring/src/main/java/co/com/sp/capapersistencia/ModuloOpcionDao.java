package co.com.sp.capapersistencia;

import java.sql.SQLException;
import java.util.List;

import co.com.sp.capadominio.ModuloOpcion;
import co.com.sp.capadominio.Rol;

public interface ModuloOpcionDao extends GenericDao<ModuloOpcion>{

	public List<ModuloOpcion> findByRol(Rol rol)throws SQLException;
}
