package global.coda.hospital.enums;

import java.util.HashMap;

/**
 * @author VC
 *
 */

public enum BranchEnum {

	ADDDOCTOR(3), ADDPATIENT(1), MODIFYDOCTOR(4), MODIFYPATIENT(2), BRANCHENTRY(5), DEFAULT(6);

	private final int value;
	/**
	 * hashmap of data.
	 */
	private static HashMap<Integer, BranchEnum> map = new HashMap<Integer, BranchEnum>();

	/**
	 * @param value of role.
	 */
	private BranchEnum(int value) {
		this.value = value;
	}

	static {
		for (BranchEnum pageType : BranchEnum.values()) {
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
	public static BranchEnum valueOf(int pageType) {
		if (pageType > 6) {
			return (BranchEnum) map.get(7);
		}
		return (BranchEnum) map.get(pageType);
	}
}
