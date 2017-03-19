package net.fastj.lang.invoker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.fastj.lang.LangException;

public class FileBuffered implements Iterable<String> {

	private String file;

	public FileBuffered(String file) {
		this.file = file;
	}

	public String content() throws IOException {

		return FileUtils.readFileToString(new File(file));
	}

	public List<String> lines() throws IOException {
		return FileUtils.readLines(new File(this.file));
	}

	public BufferedReader buffered() throws FileNotFoundException {
		return new BufferedReader(new FileReader(file));
	}

	@Override
	public String toString() {
		try {
			return this.content();
		} catch (IOException e) {
			throw new LangException(e);
		}
	}

	@Override
	public Iterator<String> iterator() {

		final BufferedReader reader;
		try {
			reader = this.buffered();
		} catch (FileNotFoundException e) {
			throw new LangException(e);
		}

		return new Iterator<String>() {

			String line = null;

			@Override
			public String next() {
				return line;

			}

			@Override
			public boolean hasNext() {
				try {
					line = reader.readLine();
				} catch (IOException e) {
					throw new LangException(e);
				}
				return line != null;
			}
		};
	}

}
