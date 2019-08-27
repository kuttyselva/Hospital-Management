package global.coda.hospital.operations;

import java.util.*;
import java.util.Map.Entry;

import global.coda.hospital.patientdao.PatientDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.Hospital;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.creation.HospitalRecord;
import global.coda.hospital.exceptions.HospitalExceptions;

public class Operations {
    PatientRecord record;
    PatientDAO patientdao;
    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(Hospital.class);
    // resource bundle initialization
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());
    HospitalRecord hospital = new HospitalRecord();

    //create patient service function
    public PatientRecord create(int passedkey) throws HospitalExceptions {
        String key = String.valueOf(passedkey);
        Scanner in = new Scanner(System.in);
        String location = "";
        try {
            PatientRecord bean = new PatientRecord();
            StringBuilder locations = new StringBuilder();
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2000D"));
            String name = in.next();
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001D"));
            String age = in.next();
            Integer.parseInt(age);
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002D"));
            location = in.next();
            locations.append(location);
            locations.append(" ");
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002D"));
            location = in.next();
            locations.append(location);
            locations.append(" ");
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002D"));
            location = in.next();
            locations.append(location);
            location = locations.toString();

            bean = new PatientRecord();
            bean.BeanRecordInsert(key, age, name, location);
            LOGGER.info("Created");

            return bean;
        } catch (NumberFormatException e) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
            throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));

        }
    }

    //delete patient service function
    public List<PatientRecord> Delete(List<PatientRecord> recordmap) throws HospitalExceptions {

        Scanner in = new Scanner(System.in);
        int flag = 0;
        if (recordmap == null) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002I"));
        }
        try {
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS5000D"));
            String name = in.next();


            assert recordmap != null;
            for (int index = 0; index < recordmap.size(); index++) {

                record = recordmap.get(index);
                if (name.equals(record.getId())) {
                    recordmap.remove(index);
                    this.DisplayAll(recordmap);
                    flag = 1;
                    LOGGER.info("Record Deleted");

                }

            }
            if (flag == 0) {
                if (flag == 0) {
                    LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001I"));
                }
            }
            return recordmap;
        } catch (NumberFormatException e) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
            throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
        }
    }

    //display all records function
    public void DisplayAll(List<PatientRecord> recordmap) {
        PatientRecord record;
        if (recordmap.isEmpty()) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002I"));
        }

        for (int index = 0; index < recordmap.size(); index++) {
            record = recordmap.get(index);
            LOGGER.debug("Patient Key 	:" + record.getId());
            LOGGER.debug("Patient Name 	:" + record.getName());
            LOGGER.debug("Patient Age 	:" + record.getAge());
            LOGGER.debug("Patient Location 	:" + record.getLocation());
            System.out.println();

        }

    }

    //read a record function
    public void Read(List<PatientRecord> recordmap) throws HospitalExceptions {

        Scanner in = new Scanner(System.in);
        int flag = 0;
        if (recordmap.isEmpty()) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002I"));
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS3000D"));
        try {
            String name = in.next();

            for (int index = 0; index < recordmap.size(); index++) {

                record = recordmap.get(index);
                if (name.equals(record.getId())) {
                    LOGGER.debug("Patient Key 	:" + record.getId());
                    LOGGER.debug("Patient Name 	:" + record.getName());
                    LOGGER.debug("Patient Age 	:" + record.getAge());
                    LOGGER.debug("Patient Location 	:" + record.getLocation());
                    flag = 1;
                }

            }

            if (flag == 0) {
                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001I"));
            }
        } catch (NumberFormatException e) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
            throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));

        }

    }

    // update record function
    public List<PatientRecord> Update(List<PatientRecord> recordmap) throws HospitalExceptions {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int flag = 0;
        if (recordmap.isEmpty()) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002I"));
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS3000D"));
        try {
            String name = in.next();
            String location;
            for (int index = 0; index < recordmap.size(); index++) {

                record = recordmap.get(index);
                if (name.equals(record.getId())) {

                    StringBuilder locations = new StringBuilder();
                    LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2000D"));
                    String names = in.next();
                    LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001D"));
                    String age = in.next();
                    Integer.parseInt(age);
                    LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002D"));
                    location = in.next();
                    locations.append(location);
                    locations.append(" ");
                    LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002D"));
                    location = in.next();
                    locations.append(location);
                    locations.append(" ");
                    LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002D"));
                    location = in.next();
                    locations.append(location);
                    location = locations.toString();
                    record.setAge(age);
                    record.setLocation(location);
                    record.setName(names);
                    LOGGER.info("Updated");
                    flag = 1;

                }
            }
            if (flag == 0) {
                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001I"));
            }
            return recordmap;
        } catch (NumberFormatException e) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
            throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));

        } catch (NullPointerException e) {
            LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1003E"));
            throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1003E"));

        }

    }
}
