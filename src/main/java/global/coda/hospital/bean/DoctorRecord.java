package global.coda.hospital.bean;

public class DoctorRecord {
    private int id;
    private int age;
    private String name;
    private String location;
    private String password;
    private String phone;
    private String speciality;
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    @Override
    public String toString() {
        return "DoctorRecord{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
