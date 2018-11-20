package org.xtext.example.mydsl.output

import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.xtend.lib.annotations.Accessors

class OutputConfigurationAdapter implements Adapter {
	@Accessors(PUBLIC_GETTER)
	String outputConfigurationName;

	new(String outputConfigurationName) {
		this.outputConfigurationName = outputConfigurationName
	}

	override getTarget() {
		null
	}

	override isAdapterForType(Object type) {
		false
	}

	override notifyChanged(Notification notification) {
	}

	override setTarget(Notifier newTarget) {
	}

}
