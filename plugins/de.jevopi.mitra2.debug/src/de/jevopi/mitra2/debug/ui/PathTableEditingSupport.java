package de.jevopi.mitra2.debug.ui;

import java.io.File;
import java.util.Map.Entry;

import javax.activation.FileDataSource;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;

class PathTableEditingSupport extends EditingSupport {

	int col;
	int fileDialogStyle;

	public PathTableEditingSupport(ColumnViewer viewer, int column,
			final int fileDialogStyle) {
		super(viewer);
		col = column;
		this.fileDialogStyle = fileDialogStyle;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if (col == 1) {
			final PathTableRow row = (PathTableRow) element;
			return new DialogCellEditor(((TableViewer) getViewer()).getTable()) {
				@Override
				protected Object openDialogBox(Control i_cellEditorWindow) {
					IWorkspaceRoot workspaceRoot =
						ResourcesPlugin.getWorkspace().getRoot();
					File f = workspaceRoot.getRawLocation().toFile();
					FileDialog fileDialog =
						new FileDialog(i_cellEditorWindow.getShell(),
							fileDialogStyle);
					fileDialog.setFilterPath(f.getAbsolutePath());

					String[] filterExtensions = row.getExtensions();
					if (filterExtensions!=null && filterExtensions.length > 0) {
						fileDialog.setFilterExtensions(filterExtensions);
						fileDialog.setFilterIndex(0);
					}
					if (fileDialogStyle == SWT.OPEN) {
						fileDialog.setFileName((String) getValue());
					} else {
						// fileDialog.setOverwrite(true);
					}
					String name = fileDialog.open();
					if (name != null) {
						return name;
					} else {
						return getValue();
					}
				}

			};
		}
		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		return col == 1;
	}

	@Override
	protected Object getValue(Object element) {
		PathTableRow row = (PathTableRow) element;
		return row.get(col);
	}

	@Override
	protected void setValue(Object element, Object value) {
		PathTableRow row = (PathTableRow) element;
		String stringValue = (String) value;
		if (col == 1) row.setPath(stringValue);
		getViewer().update(element, null);
	}

}