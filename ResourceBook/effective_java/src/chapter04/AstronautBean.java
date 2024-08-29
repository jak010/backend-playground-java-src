package chapter04;

// 113page
// JavaBean
public class AstronautBean {

    private String name;
    private boolean retired;


    public AstronautBean() {
    }

    public AstronautBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }


}
