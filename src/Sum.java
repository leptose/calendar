import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("두 수를 입력하세요");
        String answer = scanner.nextLine();
        String[] answerSplit=answer.split(" ");
        int result = Integer.parseInt(answerSplit[0]) + Integer.parseInt(answerSplit[1]);
        System.out.println("두 수의 합은 "+result+"입니다.");
        scanner.close();
    }
}
