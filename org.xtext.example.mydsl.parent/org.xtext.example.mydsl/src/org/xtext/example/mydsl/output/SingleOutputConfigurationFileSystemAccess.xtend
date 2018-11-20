package org.xtext.example.mydsl.output

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccessExtension
import org.eclipse.xtext.generator.IFileSystemAccessExtension2

class SingleOutputConfigurationFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2 {

	protected IFileSystemAccess fsa;
	protected String outputConfigurationName;

	new(IFileSystemAccess fsa, String outputConfigurationName) {
		this.fsa = fsa
		this.outputConfigurationName = outputConfigurationName
	}

	override generateFile(String fileName, CharSequence contents) {
//		println("generateFile fileName(2):" + fileName)
		fsa.generateFile(fileName, outputConfigurationName, contents)
	}

	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
//		println("generateFile fileName(3):" + fileName)
		fsa.generateFile(fileName, outputConfigurationName, contents)
	}

	override deleteFile(String fileName) {
		deleteFile(fileName, outputConfigurationName)
	}

	override deleteFile(String fileName, String ignoredOutputConfigurationName) {
		(fsa as IFileSystemAccessExtension).deleteFile(fileName, outputConfigurationName)
	}

	override getURI(String fileName) {
		println("getURI, fileName: " + fileName)
		(fsa as IFileSystemAccessExtension2).getURI(fileName, outputConfigurationName)
	}

	override getURI(String fileName, String outputConfiguration) {
		println("getURI, fileName: " + fileName + " outputConfiguration: " +outputConfiguration)
		(fsa as IFileSystemAccessExtension2).getURI(fileName, outputConfigurationName)
	}

}