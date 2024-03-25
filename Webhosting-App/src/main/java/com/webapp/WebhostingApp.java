package com.webapp;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

public class WebhostingApp {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final Pattern dataPattern = Pattern.compile("C (\\d+(?:\\.\\d+)?) (\\d+(?:\\.\\d+(?:\\.\\d+)?)?) (P|N) (\\d{2}\\.\\d{2}\\.\\d{4}) (\\d+)");
    private static final Pattern queryPattern = Pattern.compile("D (\\*|\\d+(?:\\.\\d+)?) (\\*|\\d+(?:\\.\\d+(?:\\.\\d+)?)?) (P|N) (\\d{2}\\.\\d{2}\\.\\d{4})(?:-(\\d{2}\\.\\d{2}\\.\\d{4}))?");

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int recordCount = Integer.parseInt(reader.readLine());
        List<Record> records = new ArrayList<>();

        for (int i = 0; i < recordCount; i++) {
            String line = reader.readLine();
            if (line.startsWith("C")) {
                Matcher matcher = dataPattern.matcher(line);
                if (matcher.matches()) {
                    Record record = new Record(matcher.group(1), matcher.group(2), matcher.group(3).charAt(0),
                            dateFormat.parse(matcher.group(4)), Integer.parseInt(matcher.group(5)));
                    records.add(record);
                }
            } else if (line.startsWith("D")) {
                Matcher matcher = queryPattern.matcher(line);
                if (matcher.matches()) {
                    String serviceId = matcher.group(1);
                    String questionTypeId = matcher.group(2);
                    char responseType = matcher.group(3).charAt(0);
                    Date dateFrom = dateFormat.parse(matcher.group(4));
                    Date dateTo = matcher.group(5) != null ? dateFormat.parse(matcher.group(5)) : new Date();

                    double average = records.stream()
                            .filter(r -> r.matches(serviceId, questionTypeId, responseType, dateFrom, dateTo))
                            .mapToInt(Record::getTime)
                            .average()
                            .orElse(Double.NaN);

                    if (!Double.isNaN(average)) {
                        System.out.println(Math.round(average));
                    } else {
                        System.out.println("-");
                    }
                }
            }
        }
    }

    static class Record {
        String serviceId;
        String questionTypeId;
        char responseType;
        Date responseDate;
        int time;

        public Record(String serviceId, String questionTypeId, char responseType, Date responseDate, int time) {
            this.serviceId = serviceId;
            this.questionTypeId = questionTypeId;
            this.responseType = responseType;
            this.responseDate = responseDate;
            this.time = time;
        }

        public boolean matches(String serviceId, String questionTypeId, char responseType, Date dateFrom, Date dateTo) {
            return (serviceId.equals("*") || this.serviceId.startsWith(serviceId)) &&
                    (questionTypeId.equals("*") || this.questionTypeId.startsWith(questionTypeId)) &&
                    this.responseType == responseType &&
                    !this.responseDate.before(dateFrom) &&
                    !this.responseDate.after(dateTo);
        }

        public int getTime() {
            return time;
        }
    }
}
