package com.ejercicio.book;

import com.ejercicio.author.Author;
import javax.jms.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.ejb.LocalBean;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;


@Stateless
@LocalBean
public class BookBean {

    @Resource(lookup = "jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/QueueFinances")
    private Queue queue;
    
    @Resource(lookup = "jms/TopicDeliveryAndMarketing")
    private Topic topic;
    
   public Book GetBook(){
       return new Book("232","El libro de la selva", new Author("211", "Pedro"), 135000);
   }
   
   public Book createBook(Book book) {
        FinanceDto financeBook = toFinanceDto(book);
        DeliveryAndMarketingDto deliveryAndMarketingBook = toDeliveryAndMarketingDto(book);
        sendFinanceNotification(financeBook);
        sendDeliveryAndMarketingNotification(deliveryAndMarketingBook);
        return book;
    }
  
    private void sendFinanceNotification(FinanceDto book) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession();
            ObjectMessage msg = session.createObjectMessage(book);
            MessageProducer producer = session.createProducer(queue);
            producer.send(msg);
            session.close();
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendDeliveryAndMarketingNotification(DeliveryAndMarketingDto book) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession();
            ObjectMessage msg = session.createObjectMessage(book);
            MessageProducer producer = session.createProducer(topic);
            producer.send(msg);
            session.close();
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private FinanceDto toFinanceDto(Book entity) {
        FinanceDto dto = new FinanceDto();
        dto.setAuthorName(entity.getAuthor().getName());
        dto.setName(entity.getName());
        dto.setComision(entity.getComision());
        return dto;
    }
    
    private DeliveryAndMarketingDto toDeliveryAndMarketingDto(Book entity) {
        DeliveryAndMarketingDto dto = new DeliveryAndMarketingDto();
        dto.setAuthorName(entity.getAuthor().getName());
        dto.setName(entity.getName());
        return dto;
    }
}
