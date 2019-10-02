/**
 * 使用循环语句输出下列图形(每行分别有1,3,5,7,9个＃)
 *   #
 *   ###
 *   #####
 *   #######
 *   #########
 */

public class third_task {

    public static void main(String[] args) {
        for (int n = 1; n <= 5; n++) {
            for (int count = 1; count <= 2 * n - 1; count++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

}
