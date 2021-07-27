import java.lang.reflect.Array;
import java.util.*;

class Collector {
    public Integer key;
    public Integer value;

    public Collector(Integer key, Integer value) {
        this.key = key;
        this.value= value;
    }
}

class SortableByValue implements Comparator<Collector> {
    public int compare(Collector a, Collector b) {
        return b.value - a.value;
    }
}

public class Task1 {

    static void removeMajority(Integer numbers[]) {
        List<Collector> numColelects = new ArrayList<>();

        for(Integer number : numbers) {

            Integer foundPosition = -1;

            for (Integer i =0; i < numColelects.size(); i++) {
                if(numColelects.get(i).key == number) {
                    foundPosition = i;
                }
            }

            if(foundPosition < 0) {
                numColelects.add(new Collector(number, 1));
            } else {
                numColelects.set(foundPosition, new Collector(number, numColelects.get(foundPosition).value + 1));
            }
        }

        Collections.sort(numColelects, new SortableByValue());

       numColelects.remove(0);

       List<Integer> finalArrays = new ArrayList<>();

       for (Integer num : numbers) {
           boolean hasFound  = false;
           for (Collector whitelist : numColelects) {
               if(num == whitelist.key) {
                   hasFound = true;
               }
           }
           if(hasFound) {
               finalArrays.add(num);
           }
       }

       System.out.println(finalArrays);
    }

    public static void main(String[] args) {
        Integer arrayBase[] = {4, 4, 4, 1, 1, 1, 2, 2};
        removeMajority(arrayBase);
    }
}
