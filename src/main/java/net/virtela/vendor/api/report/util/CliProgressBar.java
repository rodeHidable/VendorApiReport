package net.virtela.vendor.api.report.util;

public class CliProgressBar {
	
	private static final char[] WORKCHARS = { '|', '/', '-', '\\', ' '};
	private static final String OUT_FORMAT = "\r%3d%% %s %c";
	private static final int MAX_BAR_SIZE = 50;
	
	private StringBuilder progress;

	private int total;
	private int workIndex;
	private int filledBar;

	
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
		
		double percent = new Double(done) / this.total;
		int doneBars =  (int) (MAX_BAR_SIZE * percent);
		
		while (doneBars > this.filledBar) {
			progress.setCharAt(this.filledBar,'█');
			this.filledBar++;
		}
		
		if (done == this.total) {
			workIndex = WORKCHARS.length -1;
		} else if (workIndex < (WORKCHARS.length -2)) {
			workIndex++;
		} else {
			workIndex = 0;
		}

		System.out.printf(OUT_FORMAT, (done * 100) / this.total, progress, WORKCHARS[workIndex]);
		
		if (done == this.total) {
			System.out.flush();
			System.out.println();
			init();
		}
		
	}
	
	private void init() {
		this.progress = new StringBuilder(MAX_BAR_SIZE);
		int emptyBar = MAX_BAR_SIZE;
		while (emptyBar-- > 0) {
			progress.append('░');
		}
		this.filledBar = 0;
	}

}
