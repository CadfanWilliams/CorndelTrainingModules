import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
       String[] arrayToSearch = textToSearch();
       linearSearch(arrayToSearch.clone(), "&c");
       binarySearch(arrayToSearch.clone(), "&c");
    }

    public static String[] textToSearch() throws IOException {
        List<String> listOfStrings = new ArrayList<>();

        BufferedReader bf = new BufferedReader(
            new FileReader("text.txt"));

        String line = bf.readLine();
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();

       return listOfStrings.toArray(new String[0]);
    }

    public static Boolean linearSearch(String[] array, String search) {
        long start = System.nanoTime();
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(search)) {
                System.out.printf("Search Successful after %s nano seconds \n", System.nanoTime() - start);
                return true;
            }
        }
        System.out.printf("Search Failed after %s nano seconds \n", System.nanoTime() - start);
        return false;
    }

    public static Boolean binarySearch(String[] array, String search) {
        long start = System.nanoTime();
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = search.compareTo(array[mid]);
            if (res == 0) {
                System.out.printf("Search Successful after %s nano seconds \n", System.nanoTime() - start);
                return true;
            }
            if (res > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.printf("Search Failed after %s nano seconds \n", System.nanoTime() - start);
        return false;
    }
}