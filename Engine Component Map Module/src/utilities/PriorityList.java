package utilities;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PriorityList<T extends Prioritable> {

	/* ========== Public ========== */
	public void add(T t) {

		priorityList.add(t);
		// TODO optimalization needed

		sortList(priorityList);

	}

	public T peek() {

		if (!priorityList.isEmpty())
			return priorityList.get(0);

		else
			return null;

		// TODO obs³uga pustej listy
	}

	public T poll() {

		if (!priorityList.isEmpty()) {

			T t = priorityList.get(0);
			priorityList.remove(0);

			return t;
		}

		else
			return null;
		// TODO obs³uga pustej listy

	}

	/* ========== Private ========== */
	private List<T> priorityList = new LinkedList<T>();

	private void sortList(List<T> priorityList) {

		Comparator<Prioritable> comparator = new Comparator<Prioritable>() {
			@Override
			public int compare(Prioritable o1, Prioritable o2) {
				return o1.getPriority().compare(o2.getPriority());
			}
		};

		Collections.sort(priorityList, comparator);
	}

}
