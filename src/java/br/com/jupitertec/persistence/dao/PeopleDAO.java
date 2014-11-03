/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.persistence.dao;

import br.com.jupitertec.domain.People;
import java.util.Collection;

/**
 *
 * @author Rafael
 */
public interface PeopleDAO {
    
    	public void save(People people);
	
	public void delete(People people);
	
	public People findById(Integer id);
	
	public Collection<People> listar();
    
}
