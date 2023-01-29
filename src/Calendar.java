import java.util.*;

public class Calendar {
    private static final int[] MAX_DAYS={31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] LEAP_MAX_DAYS={31,29,31,30,31,30,31,31,30,31,30,31};
    private static final String[] DAYS={"01","02","03","04","05","06","07","08","09","10","11","12","13","14",
    "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    private static HashMap<String, List<String>> planList=new HashMap<>();
    public static void main(String[] args){
        Calendar cal=new Calendar();
        cal.prompt();
    }

    public static int getMaxDays(int year,int month) {
        boolean leapYear=isLeapYear(year);
        if(leapYear){
            return LEAP_MAX_DAYS[month-1];
        }
        else {
            return MAX_DAYS[month - 1];
        }
    }

    public void normalCalendar(int year,int month,String[] plan){
        int maxDay=getMaxDays(year,month);
        int startDay=startDay(year,month);
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
            if((i+startDay)%7==0||i==maxDay) {
                System.out.println();
                if(!(plan[(i-1+startDay)/7].isBlank())){
                    System.out.println(plan[(i-1+startDay)/7]);
                }
                else if(i==maxDay&&plan[(i-1+startDay)/7].isBlank()){
                    System.out.println();
                }
            }
        }
    }
    public static String[] planDot(int year, int month){
        int maxDay=getMaxDays(year,month);
        int startDay=startDay(year,month);
        String[] result={"","","","","",""};
        for(int i=0;i<startDay;i++){
            if(i!=startDay-1) {
                result[0]+="   ";
            }
            else{
                result[0]+="  ";
            }
        }
        for(int i=1;i<=maxDay;i++){
            if(i<10){
                if((i-1+startDay)%7==0){
                    result[(i-1+startDay)/7]+=" ";
                }
                else {
                    result[(i-1+startDay)/7]+="  ";
                }
            }
            else if((i-1+startDay)%7!=0){
                result[(i-1+startDay)/7]+=" ";
            }
            result[(i-1+startDay)/7]+=dotMark(year,month,i);
        }
        return result;

    }

    public static String dotMark(int year,int month,int day){
        String searchDay;
        if(month<10){
            searchDay=year+"-0"+month+"-"+DAYS[day-1];
        }
        else{
            searchDay=year+"-"+month+"-"+DAYS[day-1];
        }
        if(planList.get(searchDay)!=null){
            if(day<10) {
                return ".";
            }
            else{
                return " .";
            }
        }
        else{
            if(day<10) {
                return " ";
            }
            else{
                return "  ";
            }
        }

    }
    public static int startDay(int year,int month){
        //1995.1.1 sun
        int standardDay=leapYearCheck(year);
        for(int i=1;i<month;i++){
            standardDay+=getMaxDays(year,i);
        }
        return standardDay%7;
    }
    public static int leapYearCheck(int year){
        //1995.1.1 sun
        int diffYear=year-1995;
        int startYear,lastYear,leapYear=0;
        if(diffYear<0){
            startYear=year;
            lastYear=1995;
        }
        else{
            startYear=1995;
            lastYear=year;
        }
        for(int i=startYear;i<lastYear;i++){
            if(i%4==0&&(i%100!=0||i%400==0)){
                leapYear++;
            }
        }
        leapYear+=Math.abs(diffYear);
        return (diffYear>=0? leapYear%7:(7-(leapYear%7))%7);
    }

    public void prompt(){
        Scanner scanner=new Scanner(System.in);
        int month;
        int year;
        Calendar calendar=new Calendar();
        printScreen(0);
        while(true){
            printScreen(4);
            String context=scanner.next();
            if(context.equals("1")){
                printScreen(1);
                String day=scanner.nextLine();
                day=scanner.nextLine();
                printScreen(2);
                String plan=scanner.nextLine();
                repositoryPlan(day,plan);
            }
            else if(context.equals("2")){
                printScreen(3);
                String day=scanner.nextLine();
                day=scanner.nextLine();
                getPlan(day);
            }
            else if(context.equals("3")){
                System.out.println("년을 입력하세요.");
                System.out.print("> ");
                year=scanner.nextInt();
                if(year==-1){
                    break;
                }
                System.out.println("월을 입력하세요.");
                System.out.print("> ");
                month=scanner.nextInt();
                if(month==-1){
                    break;
                }
                else if(month>12){
                    continue;
                }
                String[] plan=planDot(year,month);
                calendar.normalCalendar(year,month,plan);
            }
            else if(context.equals("h")){
                continue;
            }
            else if(context.equals("q")){
                printScreen(6);
                break;
            }


        }
    }
    public static void printScreen(int con){
        if(con==0) {
            System.out.println("+-------------------+");
            System.out.println("| 1. 일정 등록");
            System.out.println("| 2. 일정 검색");
            System.out.println("| 3. 달력 보기");
            System.out.println("| h. 도움말 q. 종료");
            System.out.println("+-------------------+");
        }
        else if(con==1){
            System.out.println("[일정 등록] 날짜를 입력하세요.");

        }else if(con==2){
            System.out.println("일정을 입력하세요.");
        }
        else if(con==3){
            System.out.println("[일정 검색] 날짜를 입력하세요.");
        }
        else if(con==4){
            System.out.println("명령 (1, 2, 3, h, q)");
        }
        else if(con==5){
            System.out.println("일정이 등록되었습니다.");
        }
        else if(con==6){
            System.out.println("Bye");
        }


    }
    public static void planScroll(List<String> plan){
        for(int i=0;i<plan.size();i++){
            System.out.println((i+1)+"."+plan.get(i));
        }
    }
    public static void repositoryPlan(String day, String plan){
        if(planList.get(day)==null){
            List<String> savePlan=new ArrayList<>();
            savePlan.add(plan);
            planList.put(day,savePlan);
        }
        else{
            planList.get(day).add(plan);
        }
    }

    public static void getPlan(String day){
        if(planList.get(day).isEmpty()){
            System.out.println("일정이 없습니다.");
        }
        else{
            System.out.println(planList.get(day).size()+"개의 일정이 있습니다.");
            planScroll(planList.get(day));
        }
    }
    public static boolean isLeapYear(int year){
        return year%4==0&&(year%100!=0||year%400==0);
    }
}
