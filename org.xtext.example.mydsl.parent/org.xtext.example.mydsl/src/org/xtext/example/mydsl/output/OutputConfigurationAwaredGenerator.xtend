package org.xtext.example.mydsl.output

import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.ecore.resource.Resource

class OutputConfigurationAwaredGenerator extends JvmModelGenerator {
		override doGenerate(Resource input, IFileSystemAccess fsa) {
		var contents = input.contents

		for (obj : contents) {
			var String outputConfigName = null
			for (adapter : obj.eAdapters) {
				if (adapter instanceof OutputConfigurationAdapter) {
					outputConfigName = (adapter as OutputConfigurationAdapter).outputConfigurationName
				}
			}
			if (outputConfigName === null) {
//				println("outputConfigName==null, internalDoGenerate fsa")
//				println("obj to use:" + obj.toString)
				this.internalDoGenerate(obj, fsa)
			} else {
//				println("outputConfigName!=null, internalDoGenerate SingleOutputConfigurationFileSystemAccess, outputConfigName:" + outputConfigName)
				this.internalDoGenerate(obj, new SingleOutputConfigurationFileSystemAccess(fsa, outputConfigName))
			}
		}
	}
}