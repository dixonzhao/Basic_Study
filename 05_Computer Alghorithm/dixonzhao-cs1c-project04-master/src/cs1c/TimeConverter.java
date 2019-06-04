package cs1c;

import java.util.concurrent.TimeUnit;

/**
 * Converts duration into a string representation.
 *
 * @author CS1C, Foothill College, Bita M
 * @version 1.0
 */
public class TimeConverter 
{
	/**
	 * class method that converts seconds into format:
	 * hours : minutes : seconds
	 */
	public static String convertTimeToString(int time) 
	{
		int hours, minutes, seconds;

		hours = time / 60 / 60; // 1 hour = 60 minutes *  60 seconds;
		minutes = time / 60;    // 1 minute = 60 seconds;
		seconds = time % 60;

		return hours + ":" + minutes + ":" + seconds;
	}

	/**
	 * class method that converts nano-seconds into format:
	 * hours : minutes : seconds : milli-seconds : nano-seconds
	 */
	public static String convertTimeToString(long nanos) 
	{
		if(nanos < 0)
		{
			throw new IllegalArgumentException("ERROR : Duration is less than zero!");
		}


		long hours = TimeUnit.NANOSECONDS.toHours(nanos);
		nanos -= TimeUnit.HOURS.toNanos(hours);
		long minutes = TimeUnit.NANOSECONDS.toMinutes(nanos);
		nanos -= TimeUnit.MINUTES.toNanos(minutes);
		long seconds = TimeUnit.NANOSECONDS.toSeconds(nanos);
		nanos -= TimeUnit.SECONDS.toNanos(seconds);
		long milliseconds = TimeUnit.NANOSECONDS.toMillis(nanos);
		nanos -= TimeUnit.MILLISECONDS.toNanos(milliseconds);

		StringBuilder sb = new StringBuilder(64);
		sb.append(hours);
		sb.append(" hrs : ");
		sb.append(minutes);
		sb.append(" mins : ");
		sb.append(seconds);
		sb.append(" sec : ");
		sb.append(milliseconds);
		sb.append(" ms : ");
		sb.append(nanos);
		sb.append(" ns");

		return(sb.toString());
	}
}
