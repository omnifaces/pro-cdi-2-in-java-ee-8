package org.omnifaces.procdi.events.payment;

import java.util.UUID;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import org.omnifaces.procdi.events.payment.scope.OrderScopeContext;

public class PaymentServiceDemo {

	@Inject
	private PaymentService paymentService;

	@Inject
	private OrderScopeContext orderScopeContext;

	public void run() {
		var orderId = UUID.randomUUID().toString();

		orderScopeContext.start(orderId);
		try {
			// Simulate processing a payment for a certain order.
			var order = new Order(orderId);
			paymentService.processPayment(order);
		}
		finally {
			orderScopeContext.destroy(orderId);
		}
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			container.select(PaymentServiceDemo.class).get().run();
		}
	}
}
