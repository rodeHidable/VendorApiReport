package net.virtela.vendor.api.report.util;

public class CliProgressBar {
	
	private static final char[] WORKCHARS = { '|', '/', '-', '\\' };
	private static final String OUT_FORMAT = "\r%3d%% %s %c";
	
	private StringBuilder progress;
	private int total;
	private int workIndex;

	
	public CliProgressBar() {
		init();
	}

	public CliProgressBar(int total) {
		this.total = total;
		init();
	}

	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * called whenever the progress bar needs to be updated. that is whenever
	 * progress was made.
	 *
	 * @param done an int representing the work done so far
	 * @param total an int representing the total work
	 */
	public void update(int done) {
		
		int percent = (done * 100) / this.total;
		int extrachars = (percent / 2) - this.progress.length();

		while (extrachars-- > 0) {
			progress.append('█');
		}
		
		if (workIndex < (WORKCHARS.length -1)) {
			workIndex++;
		} else {
			workIndex = 0;
		}

		System.out.printf(OUT_FORMAT, percent, progress, WORKCHARS[workIndex]);
		
		if (done == this.total) {
			System.out.flush();
			System.out.println();
			init();
		}
	}

	private void init() {
		this.progress = new StringBuilder(60);
		workIndex = -1;
	}
}
