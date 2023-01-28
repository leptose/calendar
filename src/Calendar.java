import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS={31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args){
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
        Scanner scanner=new Scanner(System.in);
        int month=scanner.nextInt();
        Calendar calendar=new Calendar();
        System.out.println(month+"월은 "+calendar.getMaxDays(month)+"까지 있습니다.");
        scanner.close();
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
}
