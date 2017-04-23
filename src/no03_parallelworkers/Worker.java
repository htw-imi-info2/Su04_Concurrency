package no03_parallelworkers;

/**
 * Worker is one of the several Workers.
 * It contains some logic for a neat visualization, but it's also 
 * an example of a class implementing the Runnable interface
 * as well as using a flag to indicate whether the thread should be running.
 * s
 * @author Barne Kleinen
 *
 */
public class Worker implements Runnable {
	int number, remainderBars;
	boolean shouldRun = true;
	long delay = 1000;
	long counter = 0;

	public Worker(int number, int totalNumber, long delay) {
		this.number = number;
		this.delay = delay;
		this.remainderBars = totalNumber - number;
	}
    @Override
	public void run() {
		while (shouldRun) {
			counter++;
			System.out.println(nSpaces(number - 1) + " " + number + " "
					+ nSpaces(remainderBars));
		}
	}

	public void stop() {
		shouldRun = false;
	}

	public String nSpaces(int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += " | ";
		}
		return result;
	}

	@Override
	public String toString() {
		return "#" + number + " (" + counter + ")";
	}

	public int getNumber() {
		return number;
	}

	public long getCounter() {
		return counter;
	}
}
