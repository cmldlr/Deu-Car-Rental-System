public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day,int month,int year){

    	this.day=day;
        this.month=month;
        this.year=year;
    }
    public Date(){

    }
    public void  addDay(int day){ //addDay for startday of the system

        if(this.getDay()+day<=31){
            this.day=this.day+day;
        }
        else{
            if(this.month==2){
                if(this.getDay()+day<=28){
                    this.day=this.day+day;
                }
                else{
                    this.day=1;
                    this.month=this.month+1;
                }
            }
            else if(this.month==1 ||this.month==3 ||this.month==5 ||this.month==7 ||this.month==8 ||this.month==10 ||this.month==12){
                if(this.getDay()+day<=31){
                    this.day=this.day+day;
                }
                else{
                    this.day=1;
                    this.month=this.month+1;
                }
            }
            else if(this.month==4 ||this.month==6 ||this.month==9 ||this.month==11){
                if(this.getDay()+day<=30){
                    this.day=this.day+day;
                }
                else{
                    this.day=1;
                    this.month=this.month+1;
                }
            }


        }
    }
    public void setDay(int day) {
        if (day<=31 && day>=1) {
            this.day = day;
        }
        else{
            System.out.println("!!!ERROR Day cannot be less than 1 and greater than 31.");
        }

    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        if (month<=12 &&  month>=1) {
            this.month=month;
        }
        else{
            System.out.println("!!!ERROR Month cannot be less than 1 and greater than 12.");
        }

    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        if (year<0) {
            System.out.println("!!!ERROR Year cannot be negative");
        }
        else{
            this.year = year;
        }
    }

    public int getYear() {
        return year;
    }

    public boolean isSameday(Date date1, Date date2) {
        if(date1.getDay()==date2.getDay()&&date1.getMonth()==date2.getMonth()&&date1.getYear()==date2.getYear())
            return true;
        else
            return false;

    }
    
	public boolean getChecker(int day1, int month1, int year1,int day2, int month2, int year2) { //function for checking dates
		boolean checker=true;
		if(day1<=31 && day1>0 && month1<=12  && month1>0 && day2<=31 && day2>0 && month2<=12  && month2>0) {
			switch(month1) { 
				case 2:
					if((day1>28 && year1 %4!=0) || (day1>29 && year1%4==0)) {
						checker= false;
					}break;
				case 4:
					if(day1>30) {
						checker=false;
						
					}break;
				case 6:
					if(day1>30) {
						checker=false;
					}break;
				case 9:
					if(day1>30) {
						checker=false;
					}break;
				case 11:
					if(day1>30) {
						checker=false;
					}break;
					
			} 
			switch(month2) {
			case 2:
				if((day2>28 && year2 %4!=0) || (day2>29 && year2%4==0)) {
					checker= false;
				}break;
			case 4:
				if(day2>30) {
					checker=false;
					
				}break;
			case 6:
				if(day2>30) {
					checker=false;
				}break;
			case 9:
				if(day2>30) {
					checker=false;
				}break;
			case 11:
				if(day2>30) {
					checker=false;
				}break;
			}
			if(year2<year1) {
				checker=false;
			}
			else {
				if(year1==year2 && month2<month1) {
					checker=false;
				}
				else if(year1==year2 && month2==month1 && day2<day1) {
					 checker=false;
				}
			}
		}
		else {
			checker=false;
		}
		return checker;
	}
}