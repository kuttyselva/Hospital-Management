package global.coda.hospital.bean;


public class PatientRecord {
    @Override
	public String toString() {
		return "PatientRecord [id=" + id + ", age=" + age + ", name=" + name + ", location=" + location + "]";
	}

	private String id;
    private String age;
    private String name;
    private String location;
    private String password;
    private String phone;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    private String disease;




	public PatientRecord() {
    }

    public PatientRecord(String id, String name, String age, String location,String disease) {
        this.setId(id);
        this.setAge(age);
        this.setName(name);
        this.setLocation(location);
        this.setDisease(disease);
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

    public void BeanRecordInsert(String id,String age, String name,String location,String password,String phone,String disease) {
        this.setAge(age);
        this.setId(id);
        this.setName(name);
        this.setLocation(location);
        this.setPassword(password);
        this.setPhone(phone);
        this.setDisease(disease);
    }
}
