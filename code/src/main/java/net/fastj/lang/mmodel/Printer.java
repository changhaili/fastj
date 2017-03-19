package net.fastj.lang.mmodel;

public interface Printer {

	void print(String text);

	void println(String text);

	public final static Printer Nothing = new Printer() {

		@Override
		public void println(String text) {
			
		}

		@Override
		public void print(String text) {
		}
	};
	
	public final static Printer Console = new Printer() {

		@Override
		public void println(String text) {			
			System.out.println(text);
		}

		@Override
		public void print(String text) {
			System.out.print(text);
		}
	};


}
