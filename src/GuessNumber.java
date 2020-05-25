import java.util.Scanner;

/**
 * 猜数字游戏
 * <p>Create time: 2020-05-08 15:51</p>
 *
 * @author 周光兵
 **/
public class GuessNumber {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        // 游戏设置
        int rangeStart = getMinValue();
        int rangeEnd = getMaxValue();

        int mod = rangeEnd - rangeStart;

        if (mod <= 1) {
            System.out.println("非法的数字范围：（" + rangeStart + "，" + rangeEnd + "）");
            return;
        }

        System.out.print("请输入单轮最大猜测次数：");
        int guessTotal = scanner.nextInt();

        // 统计信息
        int totalGameCount = 0;
        int correctGuessCount = 0;

        // 是否结束游戏
        boolean gameEnd = false;

        while (!gameEnd) {
            // 生成指定范围内的随机数

            int bigRandom = (int) (Math.random() * rangeEnd * 100.0);
            int numberToGuess = (bigRandom % mod) + rangeStart;

            if (numberToGuess <= rangeStart) {
                numberToGuess = rangeStart + 1;
            } else {
                numberToGuess = rangeEnd - 1;
            }

            // 剩余的猜测次数
            int leftToGuess = guessTotal;

            boolean currentGameCounted = false;
            boolean correctGuess = false;

            System.out.println("数字范围：（" + rangeStart + "，" + rangeEnd + "）。输入-1代表游戏结束");
            while (leftToGuess > 0) {
                System.out.print("请输入范围内的数字（剩余次数：" + leftToGuess + "）：");
                int guess = scanner.nextInt();
                if (guess == -1) {
                    gameEnd = true;
                    System.out.println("用户退出游戏");
                    break;
                }

                if (!currentGameCounted) {
                    // 表示进入游戏
                    totalGameCount++;
                    currentGameCounted = true;
                }

                leftToGuess--;

                if (guess > numberToGuess) {
                    System.out.println("太大");
                } else if (guess < numberToGuess) {
                    System.out.println("太小");
                } else {
                    correctGuess = true;
                    correctGuessCount++;
                    System.out.println("正确!");
                    break;
                }
            }

            if (!correctGuess) {
                System.out.println("目标数字：" + numberToGuess);
            }

            System.out.println("共进行" + totalGameCount + "次游戏，猜中" + correctGuessCount + "次");
        }
    }

    private static int getMinValue() {
        int value;

        do {
            System.out.print("请输入最小值：");
            value = scanner.nextInt();

            if (value >= 0) {
                break;
            }

            System.out.println("最小值必须是正数或者0");
        } while (true);

        return value;
    }

    private static int getMaxValue() {
        int value;

        do {
            System.out.print("请输入最大值：");
            value = scanner.nextInt();

            if (value >= 0) {
                return value;
            }
            System.out.println("最大值必须是正数或者0");
        } while (true);
    }
}
