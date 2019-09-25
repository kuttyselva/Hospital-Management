package global.coda.hospital.enums;

import java.util.HashMap;

public enum BranchEnum {


        ADDDOCTOR(3),ADDPATIENT(1),MODIFYDOCTOR(4),MODIFYPATIENT(2),BRANCHENTRY(5),DEFAULT(6);
        private final int value;
        private static HashMap<Integer, BranchEnum> map = new HashMap<Integer, BranchEnum>();


        private BranchEnum(int value) {
            this.value = value;
        }

        static {
            for (BranchEnum pageType : BranchEnum.values()) {
                map.put(pageType.value, pageType);
            }
        }


        public int getValue() {
            return value;
        }
        public static BranchEnum valueOf(int pageType) {
            if(pageType>6) {
                return (BranchEnum) map.get(7);
            }
            return (BranchEnum) map.get(pageType);
        }
    }
