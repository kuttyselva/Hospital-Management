package global.coda.hospital.enums;

import java.util.HashMap;

/**
 * @author VC
 *
 */
public enum GlobalEnum {

	CREATEBRANCH(1), MODIFYBRANCH(2), CREATEHOSPITAL(3), MODIFYHOSPITAL(4), USEROPTION(5);

	private final int value;
	/**
	 * hashmap of data.
	 */
	private static HashMap<Integer, GlobalEnum> map = new HashMap<Integer, GlobalEnum>();

	/**
	 * @param value of role.
	 */
	private GlobalEnum(int value) {
		this.value = value;
	}

	static {
		for (GlobalEnum pageType : GlobalEnum.values()) {
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
	public static GlobalEnum valueOf(int pageType) {
		if (pageType > 6) {
			return (GlobalEnum) map.get(7);
		}
		return (GlobalEnum) map.get(pageType);
	}
}
