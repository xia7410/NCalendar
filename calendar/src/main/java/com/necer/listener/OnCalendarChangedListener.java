package com.necer.listener;

import org.joda.time.LocalDate;

/**
 * Created by necer on 2017/7/4.
 */

public interface OnCalendarChangedListener {
    void onCalendarDateChanged(LocalDate date);

    void onCalendarStateChanged(boolean isMonthSate);

}
