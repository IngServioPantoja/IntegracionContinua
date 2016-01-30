package co.com.sp.capapersistencia.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.sp.capadominio.Modulo;
import co.com.sp.capapersistencia.ModuloDao;

@Repository
public class ModuloDaoImpl extends GenericDaoImpl<Modulo> implements Serializable, ModuloDao {


	@Autowired
	public ModuloDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	private static final long serialVersionUID = -4559384297575001821L;
	
	@SuppressWarnings({ "unchecked", "unused" })	
	public List<Modulo> findByPadre(Modulo modulo) {
		Query query = null;
		if(modulo.getIdModulo() == null){
			query = currentSession().getNamedQuery("Modulo.findByPadreNull");
		}else{
			query = currentSession().getNamedQuery("Modulo.findByPadre");
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("moduloPadre", modulo.getIdModulo());
			for(String parameter : parameters.keySet()){
				query.setParameter("moduloPadre", modulo.getIdModulo());
			}
		}
		List<Modulo> lstModulos =  query.list(); 
		return lstModulos;
	}



}
