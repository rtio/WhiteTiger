/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.persistence.facade;

import br.com.jupitertec.domain.People;
import br.com.jupitertec.persistence.dao.GenericDAO;
import br.com.jupitertec.persistence.dao.PeopleDAO;
import java.util.Collection;

/**
 *
 * @author Rafael
 */
public class PeopleFacade implements PeopleDAO{
    
    private GenericDAO<People,Integer> dao = new GenericDAO<People,Integer>();

    @Override
    public void save(People people) {
        if(people.getPeopleId() == null){
            dao.save(people);
        }else{
            dao.merge(people);
        }
    }

    @Override
    public void delete(People people) {
        dao.delete(people);
    }

    @Override
    public People findById(Integer id) {
        return dao.findById(People.class, id);
    }

    @Override
    public Collection<People> listar() {
        return dao.list(People.class);
    }
    
}
