import java.util.*;
public class MaxSubarrayDivideConquer {
static void printSubarray(int[] arr, int start, int end) {
System.out.print(&quot;{ &quot;);
for (int i = start; i &lt;= end; i++) {
System.out.print(arr[i] + &quot; &quot;);
}
System.out.print(&quot;}&quot;);
}
static int max(int a, int b) {
return (a &gt; b) ? a : b;
}
static int max_of_three(int a, int b, int c) {
return max(max(a, b), c);
}
static int maxCrossingSum(int[] arr, int low, int mid, int high) {
int sum = 0;
int left_sum = Integer.MIN_VALUE;
for (int i = mid; i &gt;= low; i--) {
sum = sum + arr[i];

if (sum &gt; left_sum) {
left_sum = sum;
}
}
sum = 0;
int right_sum = Integer.MIN_VALUE;
for (int i = mid + 1; i &lt;= high; i++) {
sum = sum + arr[i];
if (sum &gt; right_sum) {
right_sum = sum;
}
}
return max_of_three(left_sum + right_sum, left_sum,
right_sum);
}
static int maxSumRecursive(int[] arr, int low, int high) {
if (low == high) {
System.out.printf(&quot;Individual element found: %d\n&quot;,
arr[low]);
return arr[low];
}
int mid = low + (high - low) / 2;
System.out.print(&quot;\n--- Dividing array segment &quot;);
printSubarray(arr, low, high);
System.out.print(&quot; ---\n&quot;);
System.out.print(&quot;First subarray: &quot;);
printSubarray(arr, low, mid);
System.out.print(&quot;\nSecond subarray: &quot;);

printSubarray(arr, mid + 1, high);
System.out.println();
int left_max_sum = maxSumRecursive(arr, low, mid);
int right_max_sum = maxSumRecursive(arr, mid + 1, high);
int cross_max_sum = maxCrossingSum(arr, low, mid, high);
System.out.print(&quot;\n--- Applying Concept for segment &quot;);
printSubarray(arr, low, high);
System.out.print(&quot; ---\n&quot;);
System.out.printf(&quot;Max sum in left half: %d\n&quot;, left_max_sum);
System.out.printf(&quot;Max sum in right half: %d\n&quot;,
right_max_sum);
System.out.printf(&quot;Max sum for crossing subarray: %d\n&quot;,
cross_max_sum);
int result = max_of_three(left_max_sum, right_max_sum,
cross_max_sum);
System.out.printf(&quot;=&gt; Maximum of (%d, %d, %d) is %d\n&quot;,
left_max_sum, right_max_sum, cross_max_sum, result);
return result;
}
public static void main(String[] args) {
int[] originalArray = {1, 2, 3, 4, 5, 6, 7};
int size = originalArray.length;
System.out.println(&quot;Applying Maximum Sum Subarray using
Divide and Conquer:&quot;);
System.out.print(&quot;Original Array: &quot;);
printSubarray(originalArray, 0, size - 1);
System.out.println();

int maxSum = maxSumRecursive(originalArray, 0, size - 1);
System.out.println(&quot;\n------------------------------------------------&quot;);
System.out.printf(&quot;Final Maximum Sum of a Contiguous
Subarray is: %d\n&quot;, maxSum);
System.out.println(&quot;------------------------------------------------&quot;);
}
}