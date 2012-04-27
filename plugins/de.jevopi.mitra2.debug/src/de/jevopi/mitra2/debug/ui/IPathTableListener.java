package de.jevopi.mitra2.debug.ui;

import de.jevopi.mitra2.debug.ui.IPathTableListener.Event;

public interface IPathTableListener {

	public static class Event {
		private PathTable source;
		private String name;
		private String path;
		private String oldPath;

		/**
		 * @param source
		 * @param name
		 * @param path
		 * @param oldPath
		 */
		public Event(PathTable source, String name, String path, String oldPath) {
			this.source = source;
			this.name = name;
			this.path = path;
			this.oldPath = oldPath;
		}

		public PathTable getSource() {
			return source;
		}

		public String getName() {
			return name;
		}

		public String getPath() {
			return path;
		}

		public String getOldPath() {
			return oldPath;
		}

	}

	void pathTableRowChanged(Event event);

}
