package global.coda.hospital.enums;

import java.util.*;

public enum PersonEnum {
	MODIFY(1),VIEW(2);
	private final int value;
	private static HashMap<Object, Object> map = new HashMap<>();
	

    private PersonEnum(int value) {
        this.value = value;
    }

    static {
        for (PersonEnum pageType : PersonEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    
    public int getValue() {
        return value;
    }
	public static PersonEnum valueOf(int pageType) {
		if(pageType>6) {
			return (PersonEnum) map.get(7);
		}
		return (PersonEnum) map.get(pageType);
	}
}
