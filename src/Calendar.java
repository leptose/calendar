import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS={31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int month;
        Calendar calendar=new Calendar();
        while(true){
            System.out.println("월을 입력하세요.");
            System.out.print("> ");
            month=scanner.nextInt();
            if(month==-1){
                break;
            }
            else if(month>12){
                continue;
            }
            calendar.normalCalendar(month);

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

    public int getMaxDays(int month) {
        return MAX_DAYS[month-1];
    }

    public void normalCalendar(int month){
        System.out.println("일  월 화  수 목  금 토");
        System.out.println("---------------------");
        int maxDay=getMaxDays(month);
        for(int i=1;i<=maxDay;i++){
            if(i<10){
                if((i-1)%7==0){
                    System.out.print(" ");
                }
                else {
                    System.out.print("  ");
                }
            }
            else if((i-1)%7!=0){
                System.out.print(" ");
            }
            System.out.print(i);
            if(i%7==0){
                System.out.println();
            }
        }
        if(month!=2) {
            System.out.println();
        }
//        System.out.println(" 1  2  3  4  5  6  7");
//        System.out.println(" 8  9 10 11 12 13 14");
//        System.out.println("15 16 17 18 19 20 21");
//        System.out.println("22 23 24 25 26 27 28");

    }
}
