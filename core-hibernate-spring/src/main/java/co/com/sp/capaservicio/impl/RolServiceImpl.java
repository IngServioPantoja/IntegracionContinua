package co.com.sp.capaservicio.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sp.capadominio.Rol;
import co.com.sp.capapersistencia.RolDao;
import co.com.sp.capaservicio.RolService;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol> implements Serializable, RolService {

	private static final long serialVersionUID = 1291988624242430482L;
	
	@Autowired
	public RolServiceImpl(RolDao rolDao) {
		this.setGenericDao(rolDao);
	}
	
}
