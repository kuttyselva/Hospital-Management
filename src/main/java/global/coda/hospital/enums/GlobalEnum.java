package global.coda.hospital.enums;

import java.util.HashMap;

public enum GlobalEnum {

CREATEBRANCH(1),MODIFYBRANCH(2),CREATEHOSPITAL(3),MODIFYHOSPITAL(4),USEROPTION(5);  private final int value;
    private static HashMap<Integer, GlobalEnum> map = new HashMap<Integer, GlobalEnum>();


    private GlobalEnum(int value) {
        this.value = value;
    }

    static {
        for (GlobalEnum pageType : GlobalEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }


    public int getValue() {
        return value;
    }
    public static GlobalEnum valueOf(int pageType) {
        if(pageType>6) {
            return (GlobalEnum) map.get(7);
        }
        return (GlobalEnum) map.get(pageType);
    }
}
