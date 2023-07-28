package com.antoniorizerio.workshopmongo.service.exceptions;

/**
 * Exceção personalizada quando eu utilizo um ID que não existe para buscar
 * um usuário.
 * 
 * RuntimeException é uma exceção padrão que o compilador n exige que eu a trate. Interessante utilizar 
 * RuntimeException pois com isso nossa classe central de tratamento de exceções vai tratar, não precisa 
 * colocar as clausulas no codigo. Se colocassemos Exception teriamos que tratar no código.
 * 
 * @author kakab
 *
 */
//  //

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3445660384462485801L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
