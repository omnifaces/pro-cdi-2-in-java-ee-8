package org.omnifaces.procdi.events.payment.scope;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

public class OrderScopeExtension implements Extension {

	public void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {
		bbd.addScope(OrderScoped.class, true, false);
	}

	public void processAnnotatedType(@Observes ProcessAnnotatedType<OrderScopeContext> pat) {
		// Make CDI ignore this class so we can provide our won dynamic bean for it.
		pat.veto();
	}

	public void afterBeanDiscovery(@Observes AfterBeanDiscovery abd) {
		OrderScopeContext context = new OrderScopeContext();
		abd.addContext(context);
		abd.addBean().types(OrderScopeContext.class).produceWith(instance -> context).id("OrderScopeContextId");
	}
}
