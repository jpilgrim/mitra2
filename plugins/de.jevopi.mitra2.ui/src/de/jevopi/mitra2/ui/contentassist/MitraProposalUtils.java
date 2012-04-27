/*******************************************************************************
 * Copyright (c) 2012 FernUniversitaet in Hagen
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package de.jevopi.mitra2.ui.contentassist;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.engine.VariableScopeHelper;
import de.jevopi.mitra2.metamodel.Metamodel;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 26, 2012
 */
public class MitraProposalUtils {

	public static Type findReceiverType(EObject selector,
			TypeResolver typeResolver) {
		try {
			Type[] receiverTypes = typeResolver.visit(selector);
			if (receiverTypes != null && receiverTypes.length == 1
					&& receiverTypes != typeResolver.getDefaultReturnValue()) {
				return receiverTypes[0];
			}
		} catch (Exception ex) {
			// may happen, we are in editing mode
		}
		return null;

	}

	/**
	 * Returns preceding leaf node. Let's look at the following tree:
	 * 
	 * <pre>
	 * <code>
	 *                         c3
	 *                        /|\
	 *                       / | \ 
	 *                 ..  c4 l3  c2 ..
	 *                     / \   / \
	 *                   c5  l4 c2  c0
	 *                   / \   / \   ..
	 *                 l6  l5 l2  l1 
	 * </code>
	 * </pre>
	 * 
	 * ci are composion nodes, li leaf nodes. Calling this method with a node xi
	 * (in which x is either c or l), will return l(i+1).
	 * <p>
	 * The depth-first search of the children of a container node is performed
	 * by {@link #findLeafNodeInChildren(CompositeNode, int)}.
	 * </p>
	 * 
	 * @param currentNode
	 * @param iOffset
	 * @return
	 */
	public static LeafNode findPecedingLeafNode(/*Xtext 1.x AbstractNode */
			/*Xtext 2.x */INode currentNode) {

		if (currentNode == null)
			return null;

		ICompositeNode parent = currentNode.getParent();
		if (parent == null) {
			return null;
		}
		
		Iterable<INode> nodesReversed = parent.getChildren().reverse();
		boolean leftOfCurrent = false;
		for (INode child: nodesReversed) {
			if (!leftOfCurrent) {
				leftOfCurrent = child==currentNode;
			} else {
				if (child instanceof CompositeNode) {
					LeafNode leafNode = findRightMostLeafNodeInChildren((CompositeNode) child);
					if (leafNode != null) {
						return leafNode;
					}
				}
				if (child instanceof LeafNode) {
					return (LeafNode) child;
				}
			}
		}
		
		return findPecedingLeafNode(parent);
	}

	protected static LeafNode findRightMostLeafNodeInChildren(CompositeNode node) {
		LeafNode leafNode;
		
		for (INode child: node.getChildren().reverse()) {
			if (child instanceof CompositeNode) {
				leafNode = findRightMostLeafNodeInChildren((CompositeNode) child);
				if (leafNode != null) {
					return leafNode;
				}
			}
			if (child instanceof LeafNode) {
				return (LeafNode) child;
			}
		}
		return null;
	}

	/**
	 * Returns predecessor model element, starting with current node.
	 * <p>
	 * The search algorithm is identically to
	 * {@link #findLeafNode(AbstractNode, int)}, so read on there for more
	 * details.
	 * </p>
	 * 
	 * @param i_currentNode
	 */
	public static EObject findPrevElement(INode currentNode) {

		if (currentNode == null)
			return null;

		ICompositeNode parent = currentNode.getParent();
		if (parent == null) {
			return null;
		}
		
		Iterable<INode> nodesReversed = parent.getChildren().reverse();
		boolean leftOfCurrent = false;
		for (INode child: nodesReversed) {
			if (!leftOfCurrent) {
				leftOfCurrent = child==currentNode;
			} else {
				if (child instanceof CompositeNode) {
					EObject element = findLastElementInChildren((CompositeNode) child);
					if (element != null) {
						return element;
					}
				}

				EObject element = child.getSemanticElement();
				if (element != null) {
					return element;
				}

			}
		}
		
		return findPrevElement(parent);
	}

	/**
	 * Method recursively called by {@link #findPrevElement(AbstractNode)}
	 * 
	 * @param node
	 * @return
	 */
	protected static EObject findLastElementInChildren(CompositeNode node) {
		EObject element;
		for (INode child: node.getChildren().reverse()) {
			if (child instanceof CompositeNode) {
				element = findLastElementInChildren((CompositeNode) child);
				if (element != null) {
					return element;
				}
			}
			element = child.getSemanticElement();
			if (element != null) {
				return element;
			}
		}
		return null;
	}

	/**
	 * @param lastNode
	 * @param projectContext
	 * @return
	 */
	public static Type findReceiverTypeBefore(/*Xtext 1.x AbstractNode */
			/*Xtext 2.x */INode lastNode,
			ProjectContext projectContext) {
		LeafNode precedingNode = findPecedingLeafNode(lastNode);
		if (precedingNode == null)
			return null;
		EObject element = NodeModelUtils.findActualSemanticObjectFor(precedingNode);
		// Xtext 1.x  NodeUtil.findASTElement(precedingNode);
		Type type = null;
		if (element != null) {
			Type[] types = projectContext.getTypeResolver().visit(element);
			if (types.length > 0) {
				type = types[0];
				if (Metamodel.isVoid(type) || Metamodel.isAny(type)) {
					type = null;
				}
			}
		}
		if (type == null) {
			String text = precedingNode.getText();
			element = findVariableDeclaration(text, precedingNode,
					projectContext);
			if (element != null) {
				Type[] types = projectContext.getTypeResolver().visit(element);
				if (types.length > 0) {
					return types[0];
				}
			}
		}
		return type;
	}

	public static VarDeclaration findVariableDeclaration(String variableName,
			AbstractNode location, ProjectContext projectContext) {
		EObject astElement = NodeModelUtils.findActualSemanticObjectFor(location);
		// Xtext 1.x  NodeUtil.findASTElement(location);
		
		if (astElement == null)
			return null;
		Map<String, VarDeclaration> variables = VariableScopeHelper
				.getVisibleVariablesAtLocation(astElement,
						projectContext.getMetamodelManager());
		return variables.get(variableName);

	}

}
