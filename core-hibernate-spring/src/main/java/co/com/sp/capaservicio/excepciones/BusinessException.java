/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sp.capaservicio.excepciones;

import java.io.Serializable;

/**
 *
 * @author Servio Pantoja
 */
public class BusinessException extends Exception implements Serializable{


	private static final long serialVersionUID = 8651949497748825971L;

	public BusinessException(String mensaje, Exception e){
		super(mensaje, e);
	}
	public BusinessException(String mensaje){
		super(mensaje);
	}

}
