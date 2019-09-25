package global.coda.hospital.enums;

import java.util.*;

public enum PatientEnum {
	MODIFY(1),VIEW(2),DEFAULT(3);
	private final int value;
	private static HashMap<Integer, PatientEnum> map = new HashMap<Integer, PatientEnum>();
	

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
