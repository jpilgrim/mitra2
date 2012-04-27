package de.jevopi.mitra2;

import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.emf.mwe2.runtime.workflow.Workflow;
import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.builder.BuilderIntegrationFragment;
import org.eclipse.xtext.generator.ecore.EcoreGeneratorFragment;
import org.eclipse.xtext.generator.exporting.QualifiedNamesFragment;
import org.eclipse.xtext.generator.exporting.SimpleNamesFragment;
import org.eclipse.xtext.generator.formatting.FormatterFragment;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment;
import org.eclipse.xtext.generator.parseTreeConstructor.ParseTreeConstructorFragment;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.ex.ExternalAntlrLexerFragment;
import org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment;
import org.eclipse.xtext.generator.resourceFactory.ResourceFactoryFragment;
import org.eclipse.xtext.generator.scoping.ImportNamespacesScopingFragment;
import org.eclipse.xtext.generator.serializer.SerializerFragment;
import org.eclipse.xtext.generator.types.TypesGeneratorFragment;
import org.eclipse.xtext.generator.validation.JavaValidatorFragment;
import org.eclipse.xtext.ui.generator.compare.CompareFragment;
import org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment;
import org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment;
import org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment;
import org.eclipse.xtext.ui.generator.outline.QuickOutlineFragment;
import org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment;
import org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment;
import org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment;

@SuppressWarnings("restriction")
public class GenerateMitra2 {

	public static void main(String[] args) {

		final String grammarURI = "classpath:/de/jevopi/mitra2/Mitra2.xtext";
		final String file_extensions = "mitra";
		final String projectName = "de.jevopi.mitra2";
		final String runtimeProject = "../" + projectName;
		final String uiProject = runtimeProject + ".ui";

		Workflow workflow = new Workflow() {
			{
				addBean(new StandaloneSetup() {
					{
						setPlatformUri(runtimeProject + "/..");
						setScanClassPath(true);
						// setPlatformUri(runtimeProject+"/../../../org.eclipse.xtext");
					}
				});

				addComponent(new DirectoryCleaner() {
					{
						setDirectory("" + runtimeProject + "/src-gen");
					}
				});

				addComponent(new DirectoryCleaner() {
					{
						setDirectory("" + runtimeProject + ".ui/src-gen");
					}
				});

				addComponent(new Generator() {
					{
						setPathRtProject(runtimeProject);
						setPathUiProject(uiProject);
						setProjectNameRt(projectName);
						setProjectNameUi("" + projectName + ".ui");

						addLanguage(new LanguageConfig() {
							{
								setUri(grammarURI);
								setFileExtensions(file_extensions);

								// Java API to access grammar elements (required by several other fragments)
								addFragment(new GrammarAccessFragment());

								addFragment(new EcoreGeneratorFragment());

								// the serialization component
								// addFragment(new SerializerFragment());
								addFragment(new ParseTreeConstructorFragment());

								// a custom ResourceFactory for use with EMF
								ResourceFactoryFragment resourceFragment =
									new ResourceFactoryFragment();
								resourceFragment
									.setFileExtensions(file_extensions);
								addFragment(resourceFragment);

								AntlrGeneratorFragment antlrGeneratorFragment =
									new AntlrGeneratorFragment();
								AntlrOptions antlrOptions = new AntlrOptions();
								antlrOptions.setBacktrack(true);
								antlrOptions.setMemoize(true);
								antlrOptions.setK(2);
								antlrGeneratorFragment.setOptions(antlrOptions);
								addFragment(antlrGeneratorFragment);

								//									ExternalAntlrLexerFragment antlrFragment1 = new ExternalAntlrLexerFragment();
								//									antlrFragment1.setLexerGrammar("org.eclipse.emf.mwe2.language.lexer.Mwe2Lexer");
								//									antlrFragment1.setRuntime(true);
								//									antlrFragment1.addAntlrParam("-lib");
								//									antlrFragment1.addAntlrParam(""+runtimeProject+"/src-gen/org/eclipse/emf/mwe2/language/parser/antlr/lexer");
								//									addFragment(antlrFragment1);

								// java-based API for validation 
								JavaValidatorFragment validationFragment =
									new JavaValidatorFragment();
								validationFragment
									.addComposedCheck("org.eclipse.xtext.validation.ImportUriValidator");
								addFragment(validationFragment);

								// scoping API 
								addFragment(new ImportNamespacesScopingFragment());

								addFragment(new SimpleNamesFragment());
								// addFragment(new QualifiedNamesFragment());

								// java types 
								// addFragment(new TypesGeneratorFragment());

								addFragment(new BuilderIntegrationFragment());

								// formatter API 
								addFragment(new FormatterFragment());

								// labeling API 
								addFragment(new LabelProviderFragment());

								// outline API 
								addFragment(new OutlineTreeProviderFragment());
								addFragment(new QuickOutlineFragment());

								// quickfix API
								addFragment(new QuickfixProviderFragment());

								// java-based API for content assistance 
								addFragment(new JavaBasedContentAssistFragment());

								XtextAntlrUiGeneratorFragment xtextAntlrUiGeneratorFragment =
									new XtextAntlrUiGeneratorFragment();
								AntlrOptions antlrOptions2 = new AntlrOptions();
								antlrOptions2.setBacktrack(true);
								antlrOptions2.setMemoize(true);
								antlrOptions2.setK(2);
								xtextAntlrUiGeneratorFragment
									.setOptions(antlrOptions2);
								addFragment(xtextAntlrUiGeneratorFragment);

								// addFragment(new ContentAssistParserGeneratorFragment());

								//  refactoring
								//  RefactorElementNameFragment refactoringFragment = new RefactorElementNameFragment();
								//  refactoringFragment.setUseJdtRefactoring(true);
								//	addFragment(refactoringFragment);
								//			
								//	CompareFragment compareFragment = new CompareFragment();
								//	CompareFragment.setFileExtensions(file_extensions);
								//	addFragment(compareFragment);
								//									
								//	addFragment(new CodetemplatesGeneratorFragment());
							}
						});
					}
				});
			}
		};

		workflow.preInvoke();
		workflow.run(new WorkflowContextImpl());
		workflow.postInvoke();
	}

}
