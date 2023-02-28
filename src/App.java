import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        System.out.println(factorial(5)); // expecting 120
        System.out.println(factorialContrived(5)); // expecting 120
        System.out.println(factorialForLoop(5)); // expecting 120

    }

    // making a method static, means that it does not belong to any particular created object, it belongs to the class itself
    // i.e. you can just call it by doing App.methodName

    /*
        accept an integer n
        find the product of n * every positive integer below it
        return product
     */

    // time complexity: O(n)
    // space complexity: O(1)
    public static int factorial(int n){
        int product = 1;
        while (n > 1) {
            product *= n;
            n--;
        }
        return product;
    }

    // time complexity: O(n)
    // space complexity: O(n)
        // because we have introduced a new variable which changes in size in relation to the input
        // the space complexity is now linear, instead of constant
    public static int factorialContrived(int n){
        int product = 1;
        int[] products = new int[n];
        while (n > 1) {
            product *= n;
            products[n-1] = product;
            n--;
        }
        return product;
    }

    // equivalent method using the for loop
    public static int factorialForLoop(int n){
        int product = 1;
        // the initial expression is not needed in this case, because we already have n
        for (; n > 1 ; n--) {
            product *= n;
        }
        return product;
    }


    /*
        accept an int[] arr
        check if it has any duplicate values
        if it does, return true, else return false
     */
    // time complexity: O(n^2) quadratic time
        // this is a naive solution, as we are looping through the array again, in every loop of the array
    // space complexity: O(1)
    public static boolean hasDuplicates(int[] arr){

        for(int i = 0; i < arr.length; i++){
            for (int other = arr.length - 1; other >= 0; other--){
                // This is a guard clause: if the two pointers are looking at the same index, then we skip this, because that's not a duplicate
                if(i == other) continue;
                else if(arr[i] == arr[other]){
                    return true;
                }

            }
        }

        return false;
    }
    // A big part of DSA is finding ways to do things more efficiently:
    // How do we make this more efficient?

    // Big O always refers to the 'worst case scenario' for the time and space complexity
    // n == 'size of input'

    // time-complexity: O(n) linear time
    // space-complexity: O(n)

    // we reduced the time complexity from quadratic to linear
    // the trade-off we had with this is that we had to increase space complexity to O(n)
    // but this sacrifice is fine, because a bit of memory sacrifice is fine for a lot of time complexity improvement
    // this is because time complexity affects the end user experience
        // if your time complexity is too high, it can choke the system
        // the choice between slightly better memory consumption and far better time efficiency will always have time efficiency as the right choice

    // We are using the Integer wrapper instead of the int primitive because we need to use the collection as an optimisation
    public static boolean hasDuplicatesEfficient(Integer[] arr){

        // A HashSet is like an ArrayList, but every element in it is unique
        // Finding an element inside a set is constant time, because it uses a hashkey to find the value
        // Our HashSet generates a unique hash index for every element, so search is O(1), constant time
        //// This is similair to how HashMap generates a unique key for every value

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++){

            if(set.contains(arr[i])) {
                return true;
            }
            else {
                set.add(arr[i]);
            }

        }
        return false;
    }
}


// Parentheses Checker
