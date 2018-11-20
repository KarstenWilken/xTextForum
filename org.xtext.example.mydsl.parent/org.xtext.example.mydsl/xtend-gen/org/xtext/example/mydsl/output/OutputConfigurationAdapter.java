package org.xtext.example.mydsl.output;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class OutputConfigurationAdapter implements Adapter {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String outputConfigurationName;
  
  public OutputConfigurationAdapter(final String outputConfigurationName) {
    this.outputConfigurationName = outputConfigurationName;
  }
  
  @Override
  public Notifier getTarget() {
    return null;
  }
  
  @Override
  public boolean isAdapterForType(final Object type) {
    return false;
  }
  
  @Override
  public void notifyChanged(final Notification notification) {
  }
  
  @Override
  public void setTarget(final Notifier newTarget) {
  }
  
  @Pure
  public String getOutputConfigurationName() {
    return this.outputConfigurationName;
  }
}
