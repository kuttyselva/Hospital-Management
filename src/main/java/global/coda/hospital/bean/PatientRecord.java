package global.coda.hospital.bean;

import java.util.List;

public class PatientRecord {
    private String id;
    private String age;
    private String name;
    private String location;

    public PatientRecord() {
    }

    public PatientRecord(String id, String name, String age, String location) {
        this.setId(id);
        this.setAge(age);
        this.setName(name);
        this.setLocation(location);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location2) {
        this.location = location2;
    }

    public void BeanRecordInsert(String id,String age, String name,String location) {
        this.setAge(age);
        this.setId(id);
        this.setName(name);
        this.setLocation(location);
    }
}
