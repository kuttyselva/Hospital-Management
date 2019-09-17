package global.coda.hospital.services;

import global.coda.hospital.Hospital;
import global.coda.hospital.bean.HospitalRecord;
import global.coda.hospital.hospitaldao.HospitalDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class HospitalServices {
    private HospitalDao hospitalDao = new HospitalDao();

    public boolean createHospital(HospitalRecord hospitalRecord) {
        return hospitalDao.createHospital(hospitalRecord);
    }

    public boolean modifyHospital(String hospitalName, String newValue) {
        HospitalRecord hospitalRecord = new HospitalRecord();
        hospitalRecord.setHospitalName(newValue);
        return hospitalDao.updateHospital(hospitalName, hospitalRecord);
    }

}
