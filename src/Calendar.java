import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS={31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] LEAP_MAX_DAYS={31,29,31,30,31,30,31,31,30,31,30,31};
    private static final String[] WEEKDAY = {"일", "월", "화", "수", "목", "금", "토"};
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int month;
        int year;
        String weekDay;
        Calendar calendar=new Calendar();
        while(true){
            System.out.println("년을 입력하세요.");
            System.out.print("> ");
            year=scanner.nextInt();
            System.out.println("월을 입력하세요.");
            System.out.print("> ");
            month=scanner.nextInt();
            System.out.println("요일을 입력하세요.");
            System.out.print("> ");
            weekDay=scanner.next();

            if(month==-1){
                break;
            }
            else if(month>12){
                continue;
            }
            calendar.normalCalendar(year,month,weekDay);

        }
//        System.out.println("일  월 화  수 목  금 토");
//        System.out.println("---------------------");
//        for (int i=0;i<4;i++){
//            for(int j=1;j<8;j++){
//                if(i<2&&j==1){
//                    System.out.print(" ");
//                }
//                else if(i*7+j<10){
//                    System.out.print("  ");
//                }
//                System.out.print(j+i*7);
//                if(i*7+j>=9){
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//       1  2  3  4  5  6  7  8  9 10 11 12
//      31 28 31 30 31 30 31 31 30 31 30 31
//        Scanner scanner=new Scanner(System.in);
//        int count=scanner.nextInt();
//
//        List<Integer> month=new ArrayList<>();
//        for(int i=0;i<count;i++){
//            int mon=scanner.nextInt();
//            month.add(mon);
//        }
//
//        Calendar calendar=new Calendar();
//
//        for(int i:month){
//            System.out.println(i + "월은 " + calendar.getMaxDays(i) + "까지 있습니다.");
//        }
//        scanner.close();
//        if(month%2==0){
//            if(month==2){
//                System.out.println(month+"월은 28일까지 있습니다.");
//            }
//            else if(month<7){
//                System.out.println(month+"월은 30일까지 있습니다.");
//            }
//            else{
//                System.out.println(month+"월은 31일까지 있습니다.");
//            }
//        }
//        else{
//            if(month<7){
//                System.out.println(month+"월은 31일까지 있습니다.");
//            }
//            else{
//                System.out.println(month+"월은 30일까지 있습니다.");
//            }
//        }

    }

    public int getMaxDays(int year,int month) {
        boolean leapYear=isLeapYear(year);
        if(leapYear){
            return LEAP_MAX_DAYS[month-1];
        }
        else {
            return MAX_DAYS[month - 1];
        }
    }

    public void normalCalendar(int year,int month,String whatDay){
        int maxDay=getMaxDays(year,month);
        int startDay=startDay(whatDay);
        if(startDay==-1){
            return;
        }
        System.out.println("일  월 화  수 목  금 토");
        System.out.println("---------------------");
        for(int i=0;i<startDay;i++){
            if(i!=startDay-1) {
                System.out.print("   ");
            }
            else{
                System.out.print("  ");
            }
        }
        for(int i=1;i<=maxDay;i++){
            if(i<10){
                if((i-1+startDay)%7==0){
                    System.out.print(" ");
                }
                else {
                    System.out.print("  ");
                }
            }
            else if((i-1+startDay)%7!=0){
                System.out.print(" ");
            }
            System.out.print(i);
            if((i+startDay)%7==0) {
                System.out.println();
            }
        }
        if(month!=2||maxDay==29) {
            System.out.println();
        }
    }

    public int startDay(String whatDay){
        int result=-1;
        for(int i = 0; i< WEEKDAY.length; i++){
            if(whatDay.equals(WEEKDAY[i])){
                result=i;
            }
        }
        return result;
    }

    public boolean isLeapYear(int year){
        return year%4==0&&(year%100!=0||year%400==0);
    }
}
