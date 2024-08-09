package chapter2;

import java.util.*;

public class AssignService {

    /**
     * 배정 비즈니스 로직
     * 1. 30세 이상인 고객 추출
     * 2. 나이를 오름차순으로 정렬
     * 3. 나이 계산은 calculateAge 메소드로 분리, 단순함 유지를 위해 년도만 사용
     */
    public List<Customer> assign(List<Customer> customers,
                                 List<Surveyor> surveyors) {

        List<Customer> filteredCustomer = new ArrayList<>();

        // 1
        for (Customer customer : customers) {
            if (this.calculateAge(customer) >= 30) {
                filteredCustomer.add(customer);
            }
        }
        // 2
        filteredCustomer.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer customer1, Customer customer2) {
                return calculateAge(customer1).compareTo(calculateAge(customer2));
            }
        });

        // 3
        int i = 0;
        for (Customer customer : customers) {
            Surveyor surveyor = surveyors.get(i % surveyors.size());
            customer.setSurveyorId(surveyor.getId());
        }

        return filteredCustomer;

    }

    public Integer calculateAge(Customer customer) {
        String year = customer.getBirthday().substring(0, 4);
        String month = customer.getBirthday().substring(5, 6);
        String day = customer.getBirthday().substring(7, 8);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(year));
        calendar.set(Calendar.MONTH, Integer.valueOf(month) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));

        Date birthDate = calendar.getTime();

        Calendar birthdayCalender = Calendar.getInstance();
        birthdayCalender.setTime(birthDate);
        Calendar todayCalendar = Calendar.getInstance();

        return todayCalendar.get(Calendar.YEAR) - birthdayCalender.get(Calendar.YEAR);
    }

}
