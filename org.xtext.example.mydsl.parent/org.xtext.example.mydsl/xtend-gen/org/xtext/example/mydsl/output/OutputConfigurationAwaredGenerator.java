package org.xtext.example.mydsl.output;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.xtext.example.mydsl.output.OutputConfigurationAdapter;
import org.xtext.example.mydsl.output.SingleOutputConfigurationFileSystemAccess;

@SuppressWarnings("all")
public class OutputConfigurationAwaredGenerator extends JvmModelGenerator {
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    EList<EObject> contents = input.getContents();
    for (final EObject obj : contents) {
      {
        String outputConfigName = null;
        EList<Adapter> _eAdapters = obj.eAdapters();
        for (final Adapter adapter : _eAdapters) {
          if ((adapter instanceof OutputConfigurationAdapter)) {
            outputConfigName = ((OutputConfigurationAdapter) adapter).getOutputConfigurationName();
          }
        }
        if ((outputConfigName == null)) {
          this.internalDoGenerate(obj, fsa);
        } else {
          SingleOutputConfigurationFileSystemAccess _singleOutputConfigurationFileSystemAccess = new SingleOutputConfigurationFileSystemAccess(fsa, outputConfigName);
          this.internalDoGenerate(obj, _singleOutputConfigurationFileSystemAccess);
        }
      }
    }
  }
}
