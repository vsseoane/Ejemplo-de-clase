/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejercicio.finances;

/**
 *
 * @author Diego
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Diego
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QueueFinances")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class QueueFinancesBean implements MessageListener {
    
    public QueueFinancesBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("MENSAJE EN TOPIC = " + msg.getText());
        } catch (JMSException ex) {
            Logger.getLogger(QueueFinancesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
