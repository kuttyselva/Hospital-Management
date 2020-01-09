package global.coda.hospital.enums;

import java.util.HashMap;

/**
 * @author VC
 *
 */
public enum PatientEnum {
	MODIFY(1), VIEW(2), DEFAULT(3);

	private final int value;
	/**
	 * hashmap of data.
	 */
	private static HashMap<Integer, PatientEnum> map = new HashMap<Integer, PatientEnum>();

	/**
	 * @param value of role.
	 */
	private PatientEnum(int value) {
		this.value = value;
	}

	static {
		for (PatientEnum pageType : PatientEnum.values()) {
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
	public static PatientEnum valueOf(int pageType) {
		if (pageType > 6) {
			return (PatientEnum) map.get(7);
		}
		return (PatientEnum) map.get(pageType);
	}
}
