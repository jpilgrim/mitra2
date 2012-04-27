package de.jevopi.mitra2.ui.sourceViewer;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.utils.StringUtils;

/**
 * Shows code specific information, such as types or features, in a hover.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 5, 2012
 * @see MitraSourceViewerConfiguration
 */
public class MitraTextHover implements ITextHover {

	private ISourceViewer sourceViewer;

	public MitraTextHover(ISourceViewer i_sourceViewer) {
		sourceViewer = i_sourceViewer;
	}

	protected ProjectContext getProjectContext(EObject eobject) {
		return ProjectContext.getProjectContext(eobject);
	}

	@Override
	public IRegion getHoverRegion(ITextViewer i_textViewer, int i_offset) {
		return new Region(i_offset, 0);
	}

	@Override
	public String getHoverInfo(ITextViewer i_textViewer, IRegion i_hoverRegion) {
		final int offset = i_hoverRegion.getOffset();
		final IXtextDocument model =
			(IXtextDocument) sourceViewer.getDocument();
		String message =
			model.readOnly(new IUnitOfWork<String, XtextResource>() {

				public String exec(XtextResource state) throws Exception {
					IParseResult parseResult = state.getParseResult();
					Assert.isNotNull(parseResult);
					ICompositeNode rootNode = parseResult.getRootNode();
					INode currentNode =
						NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
					// XTxt 1.x: ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, offset);

					EObject eObject =
						NodeModelUtils.findActualSemanticObjectFor(currentNode);
					//						NodeUtil.getNearestSemanticObject(currentNode);

					ProjectContext projectContext = getProjectContext(eObject);
					if (projectContext != null) {
						MitraHoverInfoProvider hoverInfoProvider =
							new MitraHoverInfoProvider(projectContext);
						String s = hoverInfoProvider.doSwitch(eObject);
						return StringUtils.wrapByWord(s, 80, 4, "-*");
					} else {
						return null;
					}
				}
			});
		return message;
	}

}
