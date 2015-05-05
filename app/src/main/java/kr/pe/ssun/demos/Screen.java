package kr.pe.ssun.demos;

/**
 * Created by x1210x on 15. 5. 5..
 */
public enum Screen {
	NORMAL,
	LARGE_LAND;

	private static Screen current;

	public static Screen getCurrent() {
		return current;
	}

	public static void setCurrent(Screen current1) {
		current = current1;
	}
}
