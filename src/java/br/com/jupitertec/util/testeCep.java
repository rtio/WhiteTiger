/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class testeCep {
    
    public static void main(String[] args){
        
        FindCep busca = new FindCep();
        
        try {
            String cep = "60348150";
            StringBuffer end = new StringBuffer();
            end.append(busca.getEndereco(cep) + " ");
            end.append(busca.getBairro(cep) + " ");
            end.append(busca.getCidade(cep) + " ");
            end.append(busca.getUF(cep));
            System.out.println(end.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ops! Não encontrei o CEP.");
        }
        
        
        
    }
    
}
