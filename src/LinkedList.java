public class LinkedList {
    private static int binarySearch(int[] sortedArray, int numToFind){
        int first = 0;
        int last = sortedArray.length - 1;

        while (first < last) {
            int mid = (first + last) / 2;
            if (sortedArray[mid] > numToFind) {
                last = mid;
            } else if(sortedArray[mid] < numToFind) {
                first = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] sortedArray = {1, 12, 124, 1245, 14569, 23434234, 349342122};
        System.out.println("Looking for 12 - " + binarySearch(sortedArray, 12));
    }
}