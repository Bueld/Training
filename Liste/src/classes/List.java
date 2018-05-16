package classes;

public class List {

//	List-Objects

	private Item first;
	private Item last;

	public List(Item f, Item l) {

		this.first = f;
		this.last = l;
		f.addOnTop(l);

	}

	public Item getFirst() {
		return first;
	}

	public Item getLast() {
		return last;
	}

	public Item getPerIndex(int index) {
		return first.searchPerIndex(index, 0);
	}

	public Item getPerName(String name) {
		return first.searchPerName(name);
	}

//	List-Handling-Methods

	public void addInFirst(Item i) {
		Item buff = this.first;
		this.first = i;
		i.addOnTop(buff);
	}

	public void addInLast(Item i) {
		this.last.addOnTop(i);
		this.last = i;
	}

	public void addInIndex(Item i, int index) {
		if (index == 0) {
			addInFirst(i);
		}
		if (index >= this.getSize()) {
			addInLast(i);
		}
		first.addAtIndex(i, index, 0);
	}

	public void addBeforeItem(Item i, Item before) {
		first.searchPerItem(before).setNext(i);
		i.setNext(before);

	}

	public void addAfterItem(Item i, Item after) {
		Item buff = after.getNext();
		after.setNext(i);
		i.addOnTop(buff);
	}

	public void removeFirst() {
		this.first = first.getNext();
	}

	public void removeLast() {
		first.removeSpecificItem(last);
		last = getPerIndex(getSize() - 1);
	}

	public void removeAtIndex(int index) {
		first.removeSpecificItem(getPerIndex(index));
	}

	public void removeSpecificItem(Item i) {
		first.removeSpecificItem(i);
	}

	public void removeBeforeItem(Item before) {
		Item buff = first.searchPerItem(before);
		buff = first.searchPerItem(buff);
		removeSpecificItem(buff.getNext());
		buff.setNext(before);
	}

	public void removeAfterItem(Item after) {
		removeSpecificItem(after.getNext());
	}

	public void sortByAlphabet() {

		if (first.getNext() != null) {
			if (first.getNext().getNext() != null) {
				if (first.getName().compareTo(first.getNext().getName()) > 0) {
					Item buff = first.getNext().getNext();
					Item buff2 = first;
					first = first.getNext();
					first.setNext(buff2);
					first.getNext().setNext(buff);
				}
			} else {
				if (first.getName().compareTo(first.getNext().getName()) > 0) {
					Item buff = first;
					first = first.getNext();
					first.setNext(buff);
				}
			}
		}

		if (first.sortByAlphabet(first, false)) {
			sortByAlphabet();
		}

	}

	public int getSize() {
		return first.getSize(0);
	}

	public int getItemIndex(Item i) {
		return first.searchPerItem(i, 0);
	}

}
