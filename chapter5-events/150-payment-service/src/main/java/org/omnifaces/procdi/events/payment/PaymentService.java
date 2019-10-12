package org.omnifaces.procdi.events.payment;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class PaymentService {

	@Inject
	@PaymentReceived
	private Event<Order> paymentSuccessfulEvent;

	public void processPayment(Order order) {
		// This method will only be called when the order scope is active.
		paymentSuccessfulEvent.fire(order);
	}
}
