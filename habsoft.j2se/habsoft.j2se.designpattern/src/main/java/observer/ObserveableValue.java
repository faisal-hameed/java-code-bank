package observer;

import java.util.Observable;

public class ObserveableValue extends Observable {
	private int value;

	public ObserveableValue(int value) {
		this.setValue(value);
	}

	public void setValue(int value) {
		System.out.println("SET VALUE " + value);
		this.value = value;
		setChanged();
		if (hasChanged())
			notifyObservers();
	}

	public int getValue() {
		return value;
	}

}
