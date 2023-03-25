public class LoopDemo1
 {
    public static void main(String[] args) throws Exception {
        int count = 0, sum = 0;

        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
            sum += count;
        }
        System.out.println("Sum: " + sum);
    }
}
