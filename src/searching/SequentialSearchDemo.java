package searching;

public class SequentialSearchDemo {

    public static void main(String[] args) {

        int elementToSearch = 67;

        int index = searchElementByLinearApp(elementToSearch);
        System.out.println(index);

    }

    private static int searchElementByLinearApp(int elementToSearch) {
        int[] integers = {3, 22, 27, 47, 57, 67, 89, 91, 95, 99};

        for(int i=0;i<=integers.length;i++){
            if(integers[i] == elementToSearch){
                return i;
            }
        }
        return -1;
    }
}
