package chapter2.srp;

/**
 * 예제 2-1 고객 애그리게이트 (page 89)
 */
public class Customer {


    private String id;
    private String name;

    private BirthDaySrp birthday;
    private String landLinePhone;
    private String mobilePhone;
    private String gender;

    private String surveyorId;

    public Customer(String id, String name, BirthDaySrp birthday, String gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(BirthDaySrp birthday) {
        this.birthday = birthday;
    }

    public void setLandLinePhone(String landLinePhone) {
        this.landLinePhone = landLinePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSurveyorId(String surveyorId) {
        this.surveyorId = surveyorId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BirthDaySrp getBirthday() {
        return birthday;
    }

    public String getLandLinePhone() {
        return landLinePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getGender() {
        return gender;
    }

    public String getSurveyorId() {
        return surveyorId;
    }

}
