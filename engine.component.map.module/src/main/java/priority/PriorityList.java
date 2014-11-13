package priority;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PriorityList<T extends Prioritable> implements List<T> {

	/* ========== Public ========== */
	@Override
	public void add(int index, T element) {
		priorityList.add(index, element);
	}

	@Override
	public boolean add(T t) {

		boolean add = priorityList.add(t);
		// TODO optimalization needed

		sortList(priorityList);

		return add;
	}

	public T peek() {

		if (!priorityList.isEmpty())
			return priorityList.get(0);

		else
			return null;

		// TODO obs�uga pustej listy
	}

	public T poll() {

		if (!priorityList.isEmpty()) {

			T t = priorityList.get(0);
			priorityList.remove(0);

			return t;
		}

		else
			return null;
		// TODO obs�uga pustej listy

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

	@Override
	public int size() {
		return priorityList.size();
	}

	@Override
	public boolean isEmpty() {
		return priorityList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return priorityList.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return priorityList.iterator();
	}

	@Override
	public Object[] toArray() {
		return priorityList.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return priorityList.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return priorityList.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return priorityList.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return priorityList.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return priorityList.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return priorityList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return priorityList.retainAll(c);
	}

	@Override
	public void clear() {
		priorityList.clear();
	}

	@Override
	public T get(int index) {
		return priorityList.get(index);
	}

	@Override
	public T set(int index, T element) {
		return priorityList.set(index, element);
	}

	@Override
	public T remove(int index) {
		return priorityList.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return priorityList.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return priorityList.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return priorityList.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return priorityList.listIterator(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return priorityList.subList(fromIndex, toIndex);
	}

}
