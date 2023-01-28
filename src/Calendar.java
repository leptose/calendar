public class Calendar {
    public static void main(String[] args){
        System.out.println("일  월 화  수 목  금 토");
        System.out.println("---------------------");
        for (int i=0;i<4;i++){
            for(int j=1;j<8;j++){
                if(i<2&&j==1){
                    System.out.print(" ");
                }
                else if(i*7+j<10){
                    System.out.print("  ");
                }
                System.out.print(j+i*7);
                if(i*7+j>=9){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
