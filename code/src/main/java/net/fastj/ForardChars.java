package net.fastj;

import java.util.Arrays;
import java.util.Iterator;

public class ForardChars implements CharSequence, Iterable<Character> {

	private final char[] buffers;

	private volatile int begin;

	public ForardChars(int begin, CharSequence cs) {

		if (cs.length() < begin) {
			throw new RuntimeException("index error!");
		}

		this.begin = begin;

		buffers = new char[cs.length() - begin];
		for (int i = 0, size = buffers.length; i < size; i++) {
			buffers[i] = cs.charAt(i + begin);
		}
	}

	public ForardChars(CharSequence cs) {
		this(0, cs);
	}

	public boolean isEmpty() {
		return this.begin >= this.buffers.length;
	}

	public ForardChars(int begin, char[] cs) {

		if (cs.length <= begin) {
			throw new RuntimeException("index error!");
		}

		this.begin = begin;

		buffers = new char[cs.length - begin];
		for (int i = 0, size = buffers.length; i < size; i++) {
			buffers[i] = cs[i + begin];
		}
	}

	public ForardChars(char[] cs) {
		this(0, cs);
	}

	@Override
	public int length() {
		return buffers.length - begin;
	}

	@Override
	public char charAt(int index) {

		assert (this.begin + index < this.buffers.length);
		return this.buffers[this.begin + index];
	}

	@Override
	public ForardChars subSequence(int start, int end) {

		char[] chars = Arrays.copyOfRange(this.buffers, start + begin, end + begin);
		return new ForardChars(0, chars);

	}

	public ForardChars subSequence(int start) {
		return this.subSequence(start, this.length());
	}

	public void skip(int skip) {

		assert (this.begin + skip < this.buffers.length);

		this.begin += skip;
	}

	public char top() {
		return this.buffers[this.begin];
	}

	@Override
	public Iterator<Character> iterator() {

		return new Iterator<Character>() {

			int index = begin;

			@Override
			public void remove() {
			}

			@Override
			public Character next() {
				return buffers[index++];
			}

			@Override
			public boolean hasNext() {
				return index < buffers.length;
			}
		};
	}

	@Override
	public String toString() {
		return new String(buffers, this.begin, this.length());
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ForardChars))
			return false;

		ForardChars other = (ForardChars) obj;
		return other.begin == this.begin && Arrays.equals(this.buffers, other.buffers);

	}

	public boolean leftEquals(CharSequence chars) {

		if (this.length() < chars.length())
			return false;

		for (int i = 0, size = chars.length(); i < size; i++) {

			if (this.charAt(i) != chars.charAt(i))
				return false;
		}

		return true;
	}

	public void reset() {
		this.begin = 0;
	}

	public int countLeftBlank() {

		for (int i = 0, size = this.length(); i < size; i++) {
			if (this.charAt(i) > ' ')
				return i;
		}

		return this.length();
	}

	public void skipBlank() {
		this.skip(this.countLeftBlank());
	}

	public int indexOf(CharSequence subs) {

		return this.toString().indexOf(subs.toString());
	}

	public int indexOf(char c) {

		for (int i = 0, size = this.length(); i < size; i++) {

			if (this.charAt(c) == c)
				return i;
		}

		return -1;
	}

	public char[] toArray() {
		return Arrays.copyOfRange(this.buffers, this.begin, this.buffers.length);
	}

}
