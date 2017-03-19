package net.fastj.collection;

public class ArrayKey {

	private Object[] objects;

	public ArrayKey(Object... objects) {
		this.objects = objects;
	}

	public ArrayKey addAll(Object... objects) {

		Object[] newObjects = new Object[this.objects.length + objects.length];

		for (int i = 0; i < this.objects.length; i++) {
			newObjects[i] = this.objects[i];
		}

		for (int i = 0; i < objects.length; i++) {
			newObjects[i + this.objects.length] = objects[i];
		}

		return new ArrayKey(newObjects);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;

		if (!(obj instanceof ArrayKey)) {
			return false;
		}

		ArrayKey other = (ArrayKey) obj;
		if (this.objects == other.objects)
			return true;

		if (this.objects == null || other.objects == null)
			return false;

		if (this.objects.length != other.objects.length)
			return false;

		for (int i = 0; i < this.objects.length; i++) {
			if (this.objects[i] != other.objects[i]) {

				if (this.objects[i] == null)
					return false;

				if (!this.objects[i].equals(other.objects[i]))
					return false;

			}
		}

		return true;
	}

	@Override
	public int hashCode() {

		if (this.objects == null)
			return 0;

		int hashCode = 1;

		for (int i = 0; i < this.objects.length; i++) {

			if (this.objects[i] != null) {
				hashCode |= this.objects[i].hashCode();
			}
		}

		return hashCode;
	}

}
