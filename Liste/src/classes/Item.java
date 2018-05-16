package classes;

public class Item {

	private String name;
	private Item next;

	public Item(String name) {

		this.name = name;
	}

	public void addOnTop(Item n) {
		if (this.next == null) {
			next = n;
		} else {
			next.addOnTop(n);
		}
	}

	public void addAtIndex(Item n, int index, int curr) {
		curr++;
		if (index == curr) {
			Item buff = this.getNext();
			this.setNext(n);
			n.setNext(buff);
		} else {
			getNext().addAtIndex(n, index, curr);
		}
	}

	public void removeSpecificItem(Item i) {
		if (next != null) {
			if (next == i) {
				Item buff = next.getNext();
				this.clearNext();
				if (buff != null) {
					this.addOnTop(buff);
				}
			} else {
				next.removeSpecificItem(i);
			}
		}
	}

	public Item getLast() {
		if (this.next == null) {
			return this;
		} else {
			return this.getNext().getLast();
		}
	}

	public Item searchPerIndex(int index, int curr) {

		if (curr == index) {
			return this;
		} else {
			curr++;
			return this.getNext().searchPerIndex(index, curr);
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getNext() {
		return this.next;
	}

	private void clearNext() {
		this.next = null;
	}

	public int getSize(int curr) {
		curr++;
		if (this.next != null) {
			return this.next.getSize(curr);
		} else {
			return curr;
		}
	}

	public int searchPerItem(Item i, int curr) {
		if (this == i) {
			return curr;
		} else {
			curr++;
			return this.getNext().searchPerItem(i, curr);
		}
	}

	public void setNext(Item i) {
		this.next = i;
	}

	public Item searchPerName(String name) {
		if (this.getName().equals(name)) {
			return this;
		} else {
			if (this.getNext() != null) {
				return getNext().searchPerName(name);
			}
			return null;
		}
	}

	public Item searchPerItem(Item i) {
		if (this.getNext() == i) {
			return this;
		} else {
			return getNext().searchPerItem(i);
		}
	}

	public boolean sortByAlphabet(Item first, boolean changed) {

		if (this.getNext() != null) {
			if (this.getNext().getNext() != null) {
				if (this.getNext().getName().compareTo(this.getNext().getNext().getName()) > 0) {
					Item buff = this.getNext().getNext().getNext();
					Item buff2 = this.getNext();
					this.setNext(buff2.getNext());
					this.getNext().setNext(buff2);
					this.getNext().getNext().setNext(buff);
					return this.getNext().sortByAlphabet(first, true);
				} else {
					return this.getNext().sortByAlphabet(first, changed);
				}
			} else {
				return changed;
			}
		} else {
			return changed;
		}

	}

}
