package net.fastj;

import org.apache.commons.lang.StringUtils;

import net.fastj.lang.LangException;
import net.fastj.lang.node.SourceInfo;

public class CompileException extends LangException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1182732614021852331L;

	private static String getMessage(SourceInfo source, String message) {

		if (source == null)
			return message;

		int line = source.getStartLine();
		String code = source.getCode();

		String s = "";
		if (StringUtils.isNotBlank(code)) {
			s = "Error Line: " + line + "  Code : " + code;
		} else {
			s = "Error Line: " + line;
		}

		if (StringUtils.isBlank(message))
			return s;

		return s + " , " + message;
	}

	public CompileException(SourceInfo source, String message) {
		super(getMessage(source, message));
	}

	public CompileException(SourceInfo source, String message, Throwable cause) {
		super(getMessage(source, message), cause);
	}

}
