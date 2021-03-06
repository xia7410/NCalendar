package com.necer.calendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.Toast;

import com.necer.adapter.BaseCalendarAdapter;
import com.necer.adapter.WeekCalendarAdapter;
import com.necer.listener.OnClickWeekViewListener;
import com.necer.listener.OnWeekSelectListener;
import com.necer.utils.Attrs;
import com.necer.utils.Util;

import org.joda.time.LocalDate;

/**
 * Created by necer on 2018/9/11.
 * qq群：127278900
 */
public class WeekCalendar extends BaseCalendar implements OnClickWeekViewListener {


    private OnWeekSelectListener onWeekSelectListener;

    public WeekCalendar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected BaseCalendarAdapter getCalendarAdapter(Context context, Attrs attrs, int calendarSize, int currNum) {
        return new WeekCalendarAdapter(context, attrs, calendarSize, currNum, this);
    }

    @Override
    protected int getCalendarSize(LocalDate startDate, LocalDate endDate, int type) {
        return Util.getIntervalWeek(startDate, endDate, type) + 1;
    }

    @Override
    protected int getTwoDateNum(LocalDate startDate, LocalDate endDate, int type) {
        return Util.getIntervalWeek(startDate, endDate, type);
    }

    @Override
    protected LocalDate getDate(LocalDate localDate, int count) {
        return localDate.plusWeeks(count);
    }

    @Override
    protected LocalDate getLastSelectDate(LocalDate currectSelectDate) {
        return currectSelectDate.plusWeeks(-1);
    }

    @Override
    protected LocalDate getNextSelectDate(LocalDate currectSelectDate) {
        return currectSelectDate.plusWeeks(1);
    }

    @Override
    protected void onSelcetDate(LocalDate localDate) {
        mOnClickDate = localDate;
        if (onWeekSelectListener != null) {
            onWeekSelectListener.onWeekSelect(localDate);
        }
    }

    @Override
    public void onClickCurrentWeek(LocalDate date) {
        onSelcetDate(date);
        onDateChanged(date,true);
        onYearMonthChanged(date.getYear(),date.getMonthOfYear());
        notifyView(date,true);
      //  Toast.makeText(getContext(), date.toString(), Toast.LENGTH_SHORT).show();
    }


    public void setOnWeekSelectListener(OnWeekSelectListener onWeekSelectListener) {
        this.onWeekSelectListener = onWeekSelectListener;
    }
}
