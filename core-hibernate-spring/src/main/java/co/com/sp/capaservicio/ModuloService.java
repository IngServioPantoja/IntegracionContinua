package co.com.sp.capaservicio;

import java.util.List;

import co.com.sp.capadominio.Modulo;

public interface ModuloService extends GenericService<Modulo> {
	
	public List<Modulo> findByPadre(Modulo modulo);
}
