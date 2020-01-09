package global.coda.hospital.services;

import global.coda.hospital.bean.HospitalRecord;
import global.coda.hospital.hospitaldao.HospitalDao;
/**
 * @author VC
 */
public class HospitalServices {
    private HospitalDao hospitalDao = new HospitalDao();
/**
 * returns created hospital check.
 * @param hospitalRecord to store in DB.
 * @return boolean for successful creation.
 */
    public boolean createHospital(HospitalRecord hospitalRecord) {
        return hospitalDao.createHospital(hospitalRecord);
    }
/**
 * modify hospital details.
 * @param hospitalName from admin.
 * @param newValue from admin.
 * @return bool for successful updation.
 */
    public boolean modifyHospital(String hospitalName, String newValue) {
        HospitalRecord hospitalRecord = new HospitalRecord();
        hospitalRecord.setHospitalName(newValue);
        return hospitalDao.updateHospital(hospitalName, hospitalRecord);
    }

}
