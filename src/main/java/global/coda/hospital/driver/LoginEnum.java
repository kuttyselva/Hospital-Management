package global.coda.hospital.driver;

import java.util.HashMap;

/**
 * @author VC
 *
 */
public enum LoginEnum {
	PATIENT(1), DOCTOR(2), BRANCH(3), GLOBAL(4);

	private final int value;
	/**
	 * hashmap of data.
	 */
	private static HashMap<Integer, LoginEnum> map = new HashMap<>();

	/**
	 * @param value of role.
	 */
	private LoginEnum(int value) {
		this.value = value;
	}

	static {
		for (LoginEnum pageType : LoginEnum.values()) {
			map.put(pageType.value, pageType);
		}
	}

	/**
	 * @return value of role.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param pageType of role.
	 * @return default value.
	 */
	public static LoginEnum valueOf(int pageType) {
		if (pageType > 6) {
			return (LoginEnum) map.get(7);
		}
		return (LoginEnum) map.get(pageType);
	}
}
