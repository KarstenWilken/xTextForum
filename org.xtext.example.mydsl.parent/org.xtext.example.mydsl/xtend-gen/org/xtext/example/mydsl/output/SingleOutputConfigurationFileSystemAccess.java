package org.xtext.example.mydsl.output;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccessExtension;
import org.eclipse.xtext.generator.IFileSystemAccessExtension2;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class SingleOutputConfigurationFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2 {
  protected IFileSystemAccess fsa;
  
  protected String outputConfigurationName;
  
  public SingleOutputConfigurationFileSystemAccess(final IFileSystemAccess fsa, final String outputConfigurationName) {
    this.fsa = fsa;
    this.outputConfigurationName = outputConfigurationName;
  }
  
  @Override
  public void generateFile(final String fileName, final CharSequence contents) {
    this.fsa.generateFile(fileName, this.outputConfigurationName, contents);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    this.fsa.generateFile(fileName, outputConfigurationName, contents);
  }
  
  @Override
  public void deleteFile(final String fileName) {
    this.deleteFile(fileName, this.outputConfigurationName);
  }
  
  @Override
  public void deleteFile(final String fileName, final String ignoredOutputConfigurationName) {
    ((IFileSystemAccessExtension) this.fsa).deleteFile(fileName, this.outputConfigurationName);
  }
  
  @Override
  public URI getURI(final String fileName) {
    URI _xblockexpression = null;
    {
      InputOutput.<String>println(("getURI, fileName: " + fileName));
      _xblockexpression = ((IFileSystemAccessExtension2) this.fsa).getURI(fileName, this.outputConfigurationName);
    }
    return _xblockexpression;
  }
  
  @Override
  public URI getURI(final String fileName, final String outputConfiguration) {
    URI _xblockexpression = null;
    {
      InputOutput.<String>println(((("getURI, fileName: " + fileName) + " outputConfiguration: ") + outputConfiguration));
      _xblockexpression = ((IFileSystemAccessExtension2) this.fsa).getURI(fileName, this.outputConfigurationName);
    }
    return _xblockexpression;
  }
}
