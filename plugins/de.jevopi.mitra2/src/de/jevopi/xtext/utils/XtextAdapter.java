package de.jevopi.xtext.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;

import de.jevopi.xtext.utils.IXtextAdapter;

/**
 * Adapter for hiding some  Xtext 1.x to 2.x changes.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Apr 10, 2012
 */
public class XtextAdapter implements IXtextAdapter {

	@Override
	public int getStartLine(EObject eobj) {
		INode node = NodeModelUtils.getNode(eobj);
		return node == null ? -1 : node.getStartLine();
	}

	@Override
	public int getEndLine(EObject eobj) {
		INode node = NodeModelUtils.getNode(eobj);
		return node == null ? -1 : node.getEndLine();
	}

	@Override
	public String model2Text(EObject eobj) {
		INode node = NodeModelUtils.getNode(eobj);
		if (node == null) return "";

		StringBuilder strb = new StringBuilder();
		node2Text(strb, node);
		return strb.toString();
	}

	protected void node2Text(StringBuilder strb, INode node) {

		for (INode child : node instanceof ICompositeNode
			? ((ICompositeNode) node).getChildren() : node.getLeafNodes()) {

			if (child instanceof ILeafNode) {
				ILeafNode leaf = (ILeafNode) child;
				strb.append(leaf.getText());
				strb.append(" ");
			} else {
				node2Text(strb, child);
			}
		}
	}

	@Override
	public CancelIndicator getCancelIndicator() {
		return CancelIndicator.NullImpl;
	}

}

// Xtext 1.x:
/*
   public class XtextAdapter implements IXtextAdapter {
	
	static {
		XtextUtils.INSTANCE.adapter = new XtextAdapter();
	}

	@Override
	public int getStartLine(EObject eobj) {
		AbstractNode node = NodeUtil.getNode(eobj);
		return node == null ? -1 : node.getLine();
	}

	@Override
	public int getEndLine(EObject eobj) {
		AbstractNode node = NodeUtil.getNode(eobj);
		return node == null ? -1 : node.getTotalLine(); // TODO unclear
	}

	@Override
	public String model2Text(EObject eobj) {
		CompositeNode node = NodeUtil.getNode(eobj);
		if (node == null) return "";

		StringBuilder strb = new StringBuilder();
		node2Text(strb, node);
		return strb.toString();
	}

	protected void node2Text(StringBuilder strb, CompositeNode node) {

		for (AbstractNode child: node.getChildren()) {
			if (child instanceof LeafNode) {
				LeafNode leaf = (LeafNode) child;
				strb.append(leaf.getText());
				strb.append(" ");
			}
			else {
				node2Text(strb, (CompositeNode) child);
			}
		}
	}
	
	@Override
	public CancelIndicator getCancelIndicator() {
		return new CancelIndicator.NullImpl();
	}

}
*/
