import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Ingrese el número que desea particionar.");
		Scanner input = new Scanner(System.in);
		int n = Integer.valueOf(input.nextLine());
		input.close();
        System.out.println("Particiones:");
        List<String> list = Partitions.getPartitions(n);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(Integer.toString(i+1)+": "+list.get(i));
        }
	}
}
