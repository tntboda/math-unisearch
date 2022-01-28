import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        double avg = 0D;
        long div = 0L;
        int median;
        int fileIntSize;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите путь к фалу :");
        Path path = Path.of(scanner.nextLine());
        List<String> fileString = Files.readAllLines(path);
        List<Integer> fileInt = new ArrayList<>();
        for (String string : fileString) {
            fileInt.add(Integer.parseInt(string));
        }
        List<Integer> fileIntCopy = new ArrayList<>(fileInt);
        fileIntSize = fileInt.size();


        //сортировка, макс, мин
        Collections.sort(fileInt);
        System.out.println("Максимальное число " + fileInt.get(fileIntSize - 1));
        System.out.println("Минимальное число " + fileInt.get(0));


        //Медиана
        if (fileIntSize % 2 == 0) {
            median = (fileInt.get(fileIntSize / 2) + fileInt.get((fileIntSize / 2) - 1)) / 2;
        } else {
            median = fileInt.get((fileIntSize / 2) + 1);
        }
        System.out.println("Медиана " + median);

        
        //среднее арифметическое значение
        for (Integer x : fileInt) {
            avg = avg + x;
            div++;
        }
        System.out.println("Среднее арифметическое значение " + avg / div);

        
        //Наибольшая последовательность идущих подряд чисел, которая увеличивается
        System.out.println("Наибольшую последовательность идущих подряд чисел, которая увеличивается : " + RowSearcher.getIncreaseRow(fileIntCopy));

        
        //Наибольшая последовательность идущих подряд чисел, которая уменьшается
        System.out.println("Наибольшую последовательность идущих подряд чисел, которая уменьшается : " + RowSearcher.getDecreaseRow(fileIntCopy));

        scanner.close();
    }
}

