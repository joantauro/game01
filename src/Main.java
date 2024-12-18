import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Matriz de números del conjunto separados por espacio(M):");
        String input = scanner.nextLine();
        String[] inputNumbers = input.split(" ");
        int[] M = Arrays.stream(inputNumbers).mapToInt(Integer::parseInt).toArray();

        System.out.println("Valor de Número (N):");
        int N = scanner.nextInt();

        int[] result = find(M, N);

        if (result.length == 2) {
            System.out.println("Conjunto encontrado: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No se encontró ningún subconjunto.");
        }

        scanner.close();
    }

    public static int[] find(int[] M, int N) {
        Set<Integer> seen = new HashSet<>();

        for (int num : M) {
            int complement = N - num;
            if (seen.contains(complement)) {
                return new int[]{complement, num};
            }
            seen.add(num);
        }
        return new int[]{};
    }
}