/**
 * An Enum representing the US months of the year.
 */
public enum Month {
    JANUARY(0),
    FEBRUARY(1),
    MARCH(2),
    APRIL(3),
    MAY(4),
    JUNE(5),
    JULY(6),
    AUGUST(7),
    SEPTEMBER(8),
    OCTOBER(9),
    NOVEMBER(10),
    DECEMBER(11);
    
    private int _monthNumber;
    
    private Month(int monthNumber)
    {
        _monthNumber = monthNumber;
    }

    /**
     * Get the number of days in the month. Leap years are not considered.
     * Ex: January -> 31
     * @return the number of days in a month
     */
    public int getLength() {
        switch(this)
        {
            case JANUARY: return 31;
            case FEBRUARY: return 28;
            case MARCH: return 31;
            case APRIL: return 30;
            case MAY: return 31;
            case JUNE: return 30;
            case JULY: return 31;
            case AUGUST: return 31;
            case SEPTEMBER: return 30;
            case OCTOBER: return 31;
            case NOVEMBER: return 30;
            case DECEMBER: return 31;
            default: return 0;
        }
    }

    /**
     * Adds numberOfMonths to the current Month and returns what month it will then be.
     * @param numberOfMonths the number of months to look ahead
     * @return what month it will be numberOfMonths after the current month
     */
    public Month plus(int numberOfMonths) {
        
        int thisPlus = this._monthNumber + numberOfMonths;
        while(thisPlus >= 12)
            thisPlus-=12;
        
        for(Month month : Month.values())
        {
            if(month._monthNumber == thisPlus)
                return month;
        }
            
        throw new IllegalStateException("Som'n done gone screwed up, bitch!");
    }

    /**
     * Return the name of the month in the requested style, either SHORT or default to LONG. For some months,
     * SHORT may be equal to LONG.
     * Ex: A SHORT style would return 'Jan' and the LONG style would return 'January'
     * @param style - the style the month should be returned in
     * @return the display name of the current month according to the requested style.
     */
    public String getDisplayName(DisplayStyle style) {
        String thisMonth = this.toString();
        if(style == DisplayStyle.LONG)
        {
            return thisMonth.substring(0,1) + thisMonth.substring(1).toLowerCase();
            /*case JANUARY: return "January";
            case FEBRUARY: return "February";
            case MARCH: return "March";
            case APRIL: return "April";
            case MAY: return 31;
            case JUNE: return 30;
            case JULY: return 31;
            case AUGUST: return 31;
            case SEPTEMBER: return 30;
            case OCTOBER: return 31;
            case NOVEMBER: return 30;
            case DECEMBER: return 31;
            default: return 0;*/
        }
        if(style == DisplayStyle.SHORT)
        {
            return thisMonth.substring(0,1) + thisMonth.substring(1,3).toLowerCase();
        }
        return "";
    }
}
