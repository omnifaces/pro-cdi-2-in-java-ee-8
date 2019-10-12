package org.omnifaces.procdi.events.payment;

import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;
import static javax.interceptor.Interceptor.Priority.APPLICATION;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

import org.omnifaces.procdi.events.payment.scope.OrderScoped;

@OrderScoped
public class OrderService {

	private static final Logger logger = Logger.getLogger(OrderService.class.getName());

	public void onSuccessfulPayment(
			@Observes(during = AFTER_SUCCESS)
			@Priority(APPLICATION + 5)
			@PaymentReceived Order order) {
		updateOrderStatus(order);
	}

	private void updateOrderStatus(Order order) {
		logger.info("Updating status for order: " + order);
	}
}
