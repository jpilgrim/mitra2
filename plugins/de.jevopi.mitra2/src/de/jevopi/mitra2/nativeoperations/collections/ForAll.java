package de.jevopi.mitra2.nativeoperations.collections;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;

public class ForAll extends AbstractCollectionOperationWithIteratorExpression {

	public ForAll(ProjectContext i_projectContext) {
		super(i_projectContext);
	}

	@Override
	public String getDescription() {
		return "Returns true if condition holds for all elements, returns true for empty collections";
	}
	
	@Override
	public Type getTypeFromIteratorExpressionCall(Type receiverType,
			Type iteratorVariableType, Type expressionType) {
		return PrimitiveMetamodel.BOOLEAN;
	}

	@Override
	protected MObject initResult(MObject i_receiver,
			IteratorExpression iteratorExpression) {
		return MObject.TRUE;
	}

	@Override
	protected void process(MObject v, MObject i_evalWithV,
			ProcessResult io_processResult) {
		boolean testElement = (Boolean) i_evalWithV.getValue();
		if (! testElement) {
			io_processResult.result = MObject.FALSE;
			io_processResult.doBreak = true;
		}
	}

}
