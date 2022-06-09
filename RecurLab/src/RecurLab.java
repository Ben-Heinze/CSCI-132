public class RecurLab
{

    public static int largestArrayItem(int [] numbers)
    {
        return largestArrayItemAuxiliary(numbers, 0);
    }

    private static int largestArrayItemRecursive(int [] numbers, int index)
    {
        /// your code goes here and below......
    }
}
    private static int max(int a, int b)
    {
        ////Your code also goes here......
    }
    public static void main(String [] args)
    {
        int [] numbers1 = {8, 6, 10, 4, 2};
        int [] numbers2 = {9, 1, 7, 3, 5, 6};
        int [] numbers3 = {2, 4, 6, 7, 5, 3, 1, 8};

        System.out.println("In Lab: Recursion");
        System.out.println("-----------------\n");

        System.out.println("\nLargest Array Item Method ... \n");

        System.out.println("The largest array item is " + RecurLab.largestArrayItem(numbers1));
        System.out.println("The largest array item is " + RecurLab.largestArrayItem(numbers2));
        System.out.println("The largest array item is " + RecurLab.largestArrayItem(numbers3));
    }

}