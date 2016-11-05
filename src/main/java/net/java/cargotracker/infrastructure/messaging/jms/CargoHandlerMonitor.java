package net.java.cargotracker.infrastructure.messaging.jms;

import net.java.cargotracker.domain.model.cargo.Cargo;
import net.java.cargotracker.domain.model.cargo.CargoRepository;
import net.java.cargotracker.infrastructure.events.cdi.CargoInspected;
import net.java.cargotracker.interfaces.tracking.web.HandledCargo;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Consumes JMS messages and delegates notification of misdirected cargo to the
 * tracking service.
 *
 * This is a programmatic hook into the JMS infrastructure to make cargo
 * inspection message-driven.
 */
@Singleton
public class CargoHandlerMonitor {

    private static final Logger logger = Logger.getLogger(
            CargoHandlerMonitor.class.getName());

    @Inject
    private CargoRepository cargoRepository;

    @Inject
    private HandledCargo handledCargo;

    public void onCargoInspected(@Observes @CargoInspected Cargo cargo) {


            handledCargo.addHandledCargo(cargo.getTrackingId().getIdString());


    }
}
