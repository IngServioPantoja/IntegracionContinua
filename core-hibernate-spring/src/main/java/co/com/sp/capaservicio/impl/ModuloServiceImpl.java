package co.com.sp.capaservicio.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sp.capadominio.Modulo;
import co.com.sp.capapersistencia.ModuloDao;
import co.com.sp.capaservicio.ModuloService;

@Service
public class ModuloServiceImpl extends GenericServiceImpl<Modulo> implements Serializable, ModuloService {

	private static final long serialVersionUID = 6400612977269447353L;

	@Autowired
	private ModuloDao moduloDao;
	
	@Autowired
	public ModuloServiceImpl(ModuloDao moduloDao) {
		this.setGenericDao(moduloDao);
	}

	public List<Modulo> findByPadre(Modulo modulo) {
		return moduloDao.findByPadre(modulo);
	}

}
