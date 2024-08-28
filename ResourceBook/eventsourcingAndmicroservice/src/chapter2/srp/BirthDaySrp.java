package chapter2.srp;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * "생일"을 유비쿼터스 언어로 사용하면서 값 객체인 Birthday 분리하고 현재 나이를 계산하는 책임을 부여
 */
public class BirthDaySrp {

    private Date birthday;

    public BirthDaySrp(String birthday) {

        String year = birthday.substring(0, 4);
        String month = birthday.substring(5, 6);
        String day = birthday.substring(7, 8);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(year));
        calendar.set(Calendar.MONTH, Integer.valueOf(month) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));

        this.birthday = calendar.getTime();

    }

    public Integer getAge() {
        Calendar birthdayCalendar = Calendar.getInstance();
        birthdayCalendar.setTime(birthday);

        Calendar todayCalender = Calendar.getInstance();
        return todayCalender.get(Calendar.YEAR) - birthdayCalendar.get(Calendar.YEAR);

    }

}
