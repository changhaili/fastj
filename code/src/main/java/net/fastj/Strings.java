package net.fastj;

public class Strings {

	public static boolean leftEquals(CharSequence str, CharSequence sub, boolean ignoreCase) {

		if (str == sub)
			return true;

		if (str == null)
			return false;

		if (sub == null)
			return false;

		if (str.length() < sub.length())
			return false;

		for (int i = 0, size = sub.length(); i < size; i++) {

			if (ignoreCase && Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(sub.charAt(i)))
				return false;

			if (!ignoreCase && str.charAt(i) != sub.charAt(i))
				return false;
		}

		return true;
	}

	public static String leftPart(String str, String delimeter) {

		int index = str.indexOf(delimeter);
		return (index == -1) ? str : str.substring(0, index);
	}

	public static boolean containsAll(String str, String[] subs) {
		for (String sub : subs) {
			if (str.indexOf(sub) == -1)
				return false;
		}

		return true;
	}

	public static String rightPart(String str, String delimeter) {

		int index = str.lastIndexOf(delimeter);
		return (index == -1) ? str : str.substring(index + delimeter.length());
	}

	public static String trimRight(String str) {

		int len = str.length();

		while ((str.charAt(len - 1) <= ' ')) {
			len--;
		}
		return (len < str.length()) ? str.substring(0, len) : str;
	}

	public static String trimLeft(String str) {

		int len = str.length();

		int st = 0;
		while ((st < len) && (str.charAt(st) <= ' ')) {
			st++;
		}

		return (st != 0) ? str.substring(st) : str;
	}

	public static int indexOfLeftEquals(String[] subs, CharSequence str) {

		String t = str.toString();

		for (int i = 0; i < subs.length; i++) {

			if (t.startsWith(subs[i]))
				return i;
		}

		return -1;
	}

	public static int indexOfNot(String s, char c) {

		for (int i = 0, size = s.length(); i < size; i++) {

			if (s.charAt(i) != c) {
				return i;
			}
		}

		return -1;
	}

}
