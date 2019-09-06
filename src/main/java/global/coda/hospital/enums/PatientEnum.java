package global.coda.hospital.enums;

import java.util.*;

public enum PatientEnum {
	CREATE(1), READ(2), UPDATE(3), DELETE(4), DISPLAY_ALL(5),EXIT(6),DEFAULT(7);
	private final int value;
	private static HashMap<Object, Object> map = new HashMap<>();
	

    private PatientEnum(int value) {
        this.value = value;
    }

    static {
        for (PatientEnum pageType : PatientEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    
    public int getValue() {
        return value;
    }
	public static PatientEnum valueOf(int pageType) {
		if(pageType>6) {
			return (PatientEnum) map.get(7);
		}
		return (PatientEnum) map.get(pageType);
	}
}
