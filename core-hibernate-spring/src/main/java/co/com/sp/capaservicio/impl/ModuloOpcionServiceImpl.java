package co.com.sp.capaservicio.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sp.capadominio.ModuloOpcion;
import co.com.sp.capadominio.Rol;
import co.com.sp.capapersistencia.ModuloOpcionDao;
import co.com.sp.capaservicio.ModuloOpcionService;

@Service
public class ModuloOpcionServiceImpl extends GenericServiceImpl<ModuloOpcion>  implements Serializable, ModuloOpcionService {

	private static final long serialVersionUID = 6091732389977597476L;

	@Autowired
	private ModuloOpcionDao moduloOpcionDao;
	
	@Autowired
	public ModuloOpcionServiceImpl(ModuloOpcionDao moduloOpcionDao) {
		this.setGenericDao(moduloOpcionDao);
	}

	public List<ModuloOpcion> findByRol(Rol rol)throws SQLException {
		return moduloOpcionDao.findByRol(rol);
	}
}
