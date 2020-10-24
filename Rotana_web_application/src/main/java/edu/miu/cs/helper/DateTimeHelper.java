package edu.miu.cs.helper;

import java.time.LocalDate;
import java.time.Period;

public class DateTimeHelper {
        public int intervalPeriodString(LocalDate dateFrom, LocalDate dateTo){
            Period intervalPeriod = Period.between(dateFrom, dateTo);
            if (intervalPeriod.getDays() <= 31) return intervalPeriod.getDays();
            if (intervalPeriod.getDays() <= 365) return intervalPeriod.getMonths();
            if (intervalPeriod.getDays() <= 365) return intervalPeriod.getYears();
            return 0;
        }


//



}