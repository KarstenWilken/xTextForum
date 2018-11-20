package org.xtext.example.mydsl.output;

import java.util.Set;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class MyOutputConfigProvider implements IOutputConfigurationProvider {
  private final static String GEN_DEFAULT_SRC = ("./" + "src-gen");
  
  public final static String GEN_ONCE = "GEN_ONCE";
  
  private final static String GEN_ONCE_SRC = ("./" + "src-gen-once");
  
  @Override
  public Set<OutputConfiguration> getOutputConfigurations() {
    final OutputConfiguration genDefault = new OutputConfiguration(IFileSystemAccess2.DEFAULT_OUTPUT);
    genDefault.setDescription("Generated Code Folder");
    genDefault.setOutputDirectory(MyOutputConfigProvider.GEN_DEFAULT_SRC);
    genDefault.setOverrideExistingResources(true);
    genDefault.setCreateOutputDirectory(true);
    genDefault.setCleanUpDerivedResources(true);
    final OutputConfiguration genOnce = new OutputConfiguration(MyOutputConfigProvider.GEN_ONCE);
    genOnce.setDescription("Generation Gap Folder");
    genOnce.setOutputDirectory(MyOutputConfigProvider.GEN_ONCE_SRC);
    genOnce.setOverrideExistingResources(false);
    genOnce.setCreateOutputDirectory(true);
    genOnce.setCanClearOutputDirectory(false);
    genOnce.setCleanUpDerivedResources(false);
    return CollectionLiterals.<OutputConfiguration>newHashSet(genDefault, genOnce);
  }
}
