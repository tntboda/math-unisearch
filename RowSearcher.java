import java.util.ArrayList;
import java.util.List;

public class RowSearcher {

    private static List<Integer> incRow = new ArrayList<>();
    private static List<Integer> decRow = new ArrayList<>();
    private static List<Integer> tmp = new ArrayList<>();

    public static List<Integer> getIncreaseRow(List<Integer> list) {
        for (Integer x : list) {
            if (tmp.isEmpty() || x > tmp.get(tmp.size() - 1)) {
                tmp.add(x);
            } else {
                if (tmp.size() > incRow.size()) {
                    incRow = new ArrayList<>(tmp);
                }
                tmp.clear();
            }
        }
        if (tmp.size() > incRow.size()) {
            incRow = new ArrayList<>(tmp);
        }
        tmp.clear();
        return incRow;
    }

    public static List<Integer> getDecreaseRow(List<Integer> list) {
        for (Integer x : list) {
            if (tmp.isEmpty() || x < tmp.get(tmp.size() - 1)) {
                tmp.add(x);
            } else {
                if (tmp.size() > decRow.size()) {
                    decRow = new ArrayList<>(tmp);
                }
                tmp.clear();
            }
        }
        if (tmp.size() > decRow.size()) {
            decRow = new ArrayList<>(tmp);
        }
        tmp.clear();
        return decRow;
    }
}
