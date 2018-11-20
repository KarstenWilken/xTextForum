package org.xtext.example.mydsl.output

import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.generator.IFileSystemAccess2

class MyOutputConfigProvider implements IOutputConfigurationProvider {

	static val GEN_DEFAULT_SRC = "./" + "src-gen"
	public static val GEN_ONCE = "GEN_ONCE"
	static val GEN_ONCE_SRC = "./" + "src-gen-once"

	override getOutputConfigurations() {
		val OutputConfiguration genDefault = new OutputConfiguration(IFileSystemAccess2.DEFAULT_OUTPUT);
		genDefault.description = "Generated Code Folder"
		genDefault.outputDirectory = GEN_DEFAULT_SRC
		genDefault.overrideExistingResources = true
		genDefault.createOutputDirectory = true
		genDefault.cleanUpDerivedResources = true
		// setderivedProperty??
		val OutputConfiguration genOnce = new OutputConfiguration(GEN_ONCE);
		genOnce.description = "Generation Gap Folder"
		genOnce.outputDirectory = GEN_ONCE_SRC
		genOnce.overrideExistingResources = false
		genOnce.createOutputDirectory = true
		genOnce.canClearOutputDirectory = false
		genOnce.cleanUpDerivedResources = false
		// Hinweis: cleanupDerivedResources löscht alle Klassen, die nicht bei der letzten Änderung angefasst wurden
		return newHashSet(genDefault, genOnce);
	}

}
