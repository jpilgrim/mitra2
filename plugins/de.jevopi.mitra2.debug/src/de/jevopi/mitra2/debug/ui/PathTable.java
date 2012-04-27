package de.jevopi.mitra2.debug.ui;

import static java.util.Collections.emptyMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 21, 2012
 */
public class PathTable extends Composite {

	class PathTableContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {}

		@Override
		public void
				inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		@Override
		public Object[] getElements(Object object) {
			Map<String, String> map = (Map<String, String>) object;
			PathTableRow[] rows = new PathTableRow[map.size()];
			int i = 0;
			for (String key : map.keySet()) {
				rows[i++] = new PathTableRow(PathTable.this, map, key, extensions.get(key));
			}
			return rows;
		}

	}

	static class PathTableLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		@Override
		public String getColumnText(Object object, int columnIndex) {
			PathTableRow row = (PathTableRow) object;
			return row.get(columnIndex);
		}

		@Override
		public Image getColumnImage(Object object, int columnIndex) {
			return null;
		}

	}

	protected TableViewer viewer;
	private Map<String, String[]> extensions;

	public PathTable(Composite parent, int fileDialogStyle) {
		super(parent, SWT.NONE);
		init(fileDialogStyle);
	}

	private void init(final int fileDialogStyle) {
		GridLayout layout = new GridLayout(1, false);
		setLayout(layout);

		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;

		Table table = new Table(this, SWT.BORDER);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		viewer = new TableViewer(table); //, SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		String[] headers = {
			"Parameter", "Model File"
		};
		int[] colWidths = {
			120, 500
		};

		for (int i = 0; i < headers.length; i++) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(headers[i]);
			column.getColumn().setWidth(colWidths[i]);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
			column.getColumn().setAlignment(SWT.LEFT);
			column.setEditingSupport(new PathTableEditingSupport(viewer, i,
				fileDialogStyle));
		}

		PathTableContentProvider contentProvider =
			new PathTableContentProvider();
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new PathTableLabelProvider());
		Map<String, String[]> noExtensions = emptyMap();
		setMap(new HashMap<String, String>(), noExtensions);
	}

	public void setMap(Map<String, String> map, Map<String, String[]> extensions) {
		viewer.setInput(map);
		this.extensions = extensions;
	}

	public Map<String, String> getMap() {
		return (Map<String, String>) viewer.getInput();
	}

	Set<IPathTableListener> pathTableListeners =
		new HashSet<IPathTableListener>();

	public void addPathTableListener(IPathTableListener listener) {
		pathTableListeners.add(listener);
	}

	public void removePathTableListener(IPathTableListener listener) {
		pathTableListeners.remove(listener);
	}

	public void refresh() {
		viewer.refresh();

	}

	public void fireChange(String name, String path, String old) {
		for (IPathTableListener listener : pathTableListeners) {
			try {
				listener.pathTableRowChanged(new IPathTableListener.Event(this,
					name, path, old));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
