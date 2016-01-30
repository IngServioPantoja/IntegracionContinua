package co.com.sp.capapersistencia;

import java.util.List;

import co.com.sp.capadominio.Modulo;

public interface ModuloDao extends GenericDao<Modulo> {
	
	public List<Modulo> findByPadre(Modulo modulo);
}
