/**
 * generated by Xtext 2.14.0
 */
package org.xtext.example.mydsl.tests;

import com.google.inject.Inject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xtext.example.mydsl.myDsl.DomainModel;
import org.xtext.example.mydsl.tests.MyDslInjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(MyDslInjectorProvider.class)
@SuppressWarnings("all")
public class MyDslParsingTest {
  @Inject
  private ParseHelper<DomainModel> parseHelper;
  
  @Test
  public void loadModel() {
  }
}
