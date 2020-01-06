package global.coda.hospital.login;

import java.util.HashMap;

public enum LoginEnum {
PATIENT(1),DOCTOR(2),BRANCH(3),GLOBAL(4);

private final int value;
private static HashMap<Object, Object> map = new HashMap<>();


private LoginEnum(int value) {
    this.value = value;
}

static {
    for (LoginEnum pageType : LoginEnum.values()) {
        map.put(pageType.value, pageType);
    }
}


public int getValue() {
    return value;
}
public static LoginEnum valueOf(int pageType) {
	if(pageType>6) {
		return (LoginEnum) map.get(7);
	}
	return (LoginEnum) map.get(pageType);
}
}
