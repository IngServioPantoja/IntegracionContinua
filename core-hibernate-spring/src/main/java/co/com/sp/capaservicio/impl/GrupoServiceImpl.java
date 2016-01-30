package co.com.sp.capaservicio.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sp.capadominio.Grupo;
import co.com.sp.capapersistencia.GrupoDao;
import co.com.sp.capaservicio.GrupoService;

@Service
public class GrupoServiceImpl extends GenericServiceImpl<Grupo> implements GrupoService, Serializable {

	private static final long serialVersionUID = 8638893934358266592L;

	@Autowired
	public GrupoServiceImpl(GrupoDao grupoDao) {
		this.setGenericDao(grupoDao);
	}


}
