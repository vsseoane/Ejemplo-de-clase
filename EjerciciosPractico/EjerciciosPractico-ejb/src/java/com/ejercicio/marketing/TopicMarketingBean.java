/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejercicio.marketing;

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
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/TopicDeliveryAndMarketing")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/TopicDeliveryAndMarketing")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/TopicDeliveryAndMarketing")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class TopicMarketingBean implements MessageListener {
    
    public TopicMarketingBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("MENSAJE EN TOPIC = " + msg.getText());
        } catch (JMSException ex) {
            Logger.getLogger(TopicMarketingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
