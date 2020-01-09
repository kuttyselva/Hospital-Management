package global.coda.hospital.enums;

import java.util.HashMap;

/**
 * @author VC
 *
 */
public enum PersonEnum {
	MODIFY(1), VIEW(2), DEFAULT(3);

	private final int value;
	/**
	 * hashmap of data.
	 */
	private static HashMap<Integer, PersonEnum> map = new HashMap<>();

	/**
	 * @param value of role.
	 */
	private PersonEnum(int value) {
		this.value = value;
	}

	static {
		for (PersonEnum pageType : PersonEnum.values()) {
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
	public static PersonEnum valueOf(int pageType) {
		if (pageType > 6) {
			return (PersonEnum) map.get(7);
		}
		return (PersonEnum) map.get(pageType);
	}
}
