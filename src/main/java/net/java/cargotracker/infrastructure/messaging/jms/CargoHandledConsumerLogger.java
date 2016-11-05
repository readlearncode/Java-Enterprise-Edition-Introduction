package net.java.cargotracker.infrastructure.messaging.jms;

import net.java.cargotracker.application.CargoInspectionService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Consumes JMS messages and delegates notification of misdirected cargo to the
 * tracking service.
 *
 * This is a programmatic hook into the JMS infrastructure to make cargo
 * inspection message-driven.
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", 
        propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", 
        propertyValue = "java:app/jms/CargoHandledQueue")
})
public class CargoHandledConsumerLogger implements MessageListener {

    @Inject
    private CargoInspectionService cargoInspectionService;
    private static final Logger logger = Logger.getLogger(
            CargoHandledConsumerLogger.class.getName());

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;

            logger.log(Level.INFO, "Cargo Handled {0}: ", textMessage.getText());

        } catch (JMSException e) {
            logger.log(Level.SEVERE, "Error processing JMS message", e);
        }
    }
}
