/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jupitertec.util;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Rafael
 */
public class IconApplication {
    
    private final String ICON = "/br/com/jupitertec/view/img/test.png";
    
    public void setIcon(JFrame frame) {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON)));
    }
}
