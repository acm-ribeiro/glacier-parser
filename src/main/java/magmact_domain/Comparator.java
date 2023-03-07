package magmact_domain;

import java.io.Serializable;

@SuppressWarnings("ALL")
public class Comparator implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String comparator;
	
	public Comparator(String comparator) {
		this.comparator = comparator;
	}

	public String getComparator() {
		return comparator;
	}

	@Override
	public String toString() {
		return comparator;
	}
}
