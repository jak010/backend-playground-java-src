package chapter03;

public class HtmlExporter implements Exporter {

    /**
     * XXX: 책의 예제에서는 보시다시피 HTML 생성에 대해 하드코딩 되었지만 이는 별다른 클래스를 정의해서 풀어내는게 더 좋을 듯 싶다.
     */
    @Override
    public String export(final SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
