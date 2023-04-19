package tasks;

import java.util.HashMap;
import java.util.Map;

//Подсчитать количество всех элементов списка/массива и вернуть ассоциативных массив, где ключ – элемент списка, значение – количество этих элементов в списке. Порядок не имеет значения.
//Пример: [1, 3, 4, 5, 1, 5, 4] -> {1 : 2, 3 : 1, 4 : 2, 5 : 2}
public class AssociativeArray {

    public static Map<Integer, Integer> returnAssociativeArray(int[] input) {
        Map<Integer, Integer> mapHelper = new HashMap<>();
        for (int n : input) {
            if (!mapHelper.containsKey(n)) {
                mapHelper.put(n, 1);
            } else {
                mapHelper.merge(n, 1, Integer::sum);
            }
        }
        return mapHelper;
    }

}
