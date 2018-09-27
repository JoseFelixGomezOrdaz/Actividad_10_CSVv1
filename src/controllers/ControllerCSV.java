/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewCSV;
import models.ModelCSV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jose Felix
 */
public class ControllerCSV {
    ModelCSV modelCSV; 
    ViewCSV viewCSV;
    ActionListener actionlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCSV.jb_limpiar) {
                jb_limpiar_action_performed();
            }
            else if (e.getSource() == viewCSV.jb_guardar) { 
                jm_guardar_action_performed();
            }
        }
    };
    
    
    public ControllerCSV(ModelCSV modelCSV, ViewCSV viewCSV) {
        this.modelCSV = modelCSV;
        this.viewCSV = viewCSV;
        this.viewCSV.jb_limpiar.addActionListener(actionlistener);
        this.viewCSV.jb_guardar.addActionListener(actionlistener);
        initComponents();
    }
    
    
    public void jm_guardar_action_performed() {
        modelCSV.setMessage(viewCSV.jtf_nombre.getText() + "," + viewCSV.jtf_email.getText()); 
        modelCSV.writeFile(modelCSV.getPath(), modelCSV.getMessage()); 
    }
    public void jb_limpiar_action_performed() {
        viewCSV.jtf_nombre.setText("");
        viewCSV.jtf_email.setText("");
    }
    
    public void initComponents() {
        viewCSV.setVisible(true);
    }
}
