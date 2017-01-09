package com.algorithms.qartks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Searching {
	
	public static int findFirstOccuranceOfK(List<Integer> arr, int k) {
		int left = 0;
		int right = arr.size() - 1;
		int result = -1;
		
		while(left <= right) {
			int mid = left + ((right - left)/2);
			if (arr.get(mid) > k) {
				right = mid - 1;
			} else if (arr.get(mid) == k) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return result;
	}
	
	public static int findLastOccuranceOfK(List<Integer> arr, int k) {
		int left = 0;
		int right = arr.size() - 1;
		int result = -1;
		
		while(left <= right) {
			int mid = left + ((right - left)/2);
			if (arr.get(mid) > k) {
				right = mid - 1;
			} else if (arr.get(mid) == k) {
				result = mid;
				left = mid + 1;
			} else {
				left = mid + 1;
			}
		}
		
		return result;
	}
	
	public static int findPrefixBinary(List<String> arr, String pre) {
		int left = 0;
		int right = arr.size() - 1;
		int result = -1;
		
		while(left <= right) {
			int mid = left + ((right-left)/2);
			String check = arr.get(mid).substring(0, pre.length());
			int compare = pre.compareToIgnoreCase(check);
			if (compare == 0) {
				return mid;
			} else if (compare < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static int findSameIndexNumber(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = left + ((right - left)/2);
			int difference = arr[mid] - mid;
			
			if (difference == 0) {
				return mid;
			} else if (difference > 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static int findSameIndexNumberForDupes(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = left + ((right - left)/2);
			int difference = arr[mid] - mid;
			
			if (difference == 0) {
				return mid;
			} else if (difference > 0) {
				if (arr[mid] <= arr.length-1) {
					if (arr[arr[mid]] == arr[mid]) {
						return arr[mid];
					} else {
						
					}
				} else {
					right = mid - 1;
				}
			} else {
				if (arr[mid] >= 0) {
					if (arr[arr[mid]] == arr[arr[mid]]) {
						return arr[mid];
					} else {
						
					}
				} else {
					left = mid + 1;
				}
			}
		}
		
		return -1;
	}
	
	public static int findSmallest(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			int mid = left + (right-left)/2;
			
			if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return left;
	}
	
	public static int findMax(int[] arr, int low, int high) {
		if (low > high) return -1;
		if (low == high) return high;
		
		int mid = low + (high-low)/2;
		if (mid < high && arr[mid] > arr[mid + 1])
		       return mid;
	    if (mid > low && arr[mid] < arr[mid - 1])
	       return (mid-1);
	    if (arr[low] >= arr[mid])
	       return findMax(arr, low, mid-1);
	    
	    return findMax(arr, mid + 1, high);
	}

	public static void main(String[] args) {
//		List<Integer> arr = new ArrayList<Integer>();
//
//		arr.add(8);
//		arr.add(12);
//		arr.add(12);
//		arr.add(12);
//		arr.add(13);
//
//		System.out.println(findFirstOccuranceOfK(arr, 12));
//		System.out.println(findLastOccuranceOfK(arr, 12));
//		System.out.println(findLastOccuranceOfK(arr, 12) - findFirstOccuranceOfK(arr, 12) + 1);
//
//		System.out.println("\nPrefix:");
//		List<String> strings = new ArrayList<String>();
//		strings.add("abc");
//		strings.add("abfe");
//		strings.add("xcv");
//		strings.add("dfdf");
//		strings.add("asd");
//		strings.add("pre");
//		strings.add("ace");
//		strings.add("nbc");
//		strings.add("zxcv");
//
//		Collections.sort(strings);
//		System.out.println(strings.toString());
//		System.out.println(findPrefixBinary(strings, "pre"));
//
//		System.out.println("\nSame Index Number");
////		int[] arr2 = {-2, 0, 2, 4, 6, 7, 9};
//		int[] arr2 = {-2, 0, 2, 4, 6, 7, 9};
//		int[] arrDupes = {1, 2, 3, 3, 27, 27, 6, 9, 10};
//
//		System.out.println(findSameIndexNumber(arr2));
////		System.out.println(findSameIndexNumberForDupes(arrDupes));
//
//		int[] arrRot = {17, 18, 19, 20, 21, 22, 13, 14, 15, 16};
//
//		System.out.println(findSmallest(arrRot));
//		System.out.println(findMax(arrRot, 0, arrRot.length-1));
//
//        List<Integer> ar = new ArrayList<Integer>();
//
//        ar.add(-2);
//        ar.add(2);
//        ar.add(-5);
//        ar.add(61);
//        ar.add(-12);
//        ar.add(13);
//        ar.add(6);
//
//        System.out.println(findMinMax(ar));

        List<Integer> ar = new ArrayList<Integer>();

        ar.add(3);
        ar.add(5);
        ar.add(1);
        ar.add(2);
        ar.add(4);
        ar.add(6);

        System.out.println(findKLargest(ar, 2));

	}

	static int findKLargest(List<Integer> A, int k) {
	    int left = 0;
	    int right = A.size() - 1;
	    Random r = new Random(0);

	    while (left <= right) {
            int index = r.nextInt(right - left + 1) + left;
            System.out.println(A.toString());
            int pivotIndex = pivotOnIndex(A, left, right, index);

            if (pivotIndex == k-1) {
                return A.get(pivotIndex);
            } else if (pivotIndex > k-1) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }

        return -1;
    }

    private static int pivotOnIndex(List<Integer> A, int left, int right, int index) {
        int value = A.get(index);
        int curr = left;

        Collections.swap(A, index, right);
        for (int i = left; i< right; i++) {
            if (A.get(i).compareTo(value) > 0) {
                Collections.swap(A, i, curr++);
            }
        }
        Collections.swap(A, right, curr);
        return curr;
    }

    static class MinMax {
		int min;
		int max;

		MinMax(int min, int max) {
			this.max = max;
			this.min = min;
		}

        static MinMax setMinMax(Integer a, Integer b) {
            return Integer.compare(a,b) < 0 ? new MinMax(a, b) : new MinMax(b, a);
        }

        public String toString() {
            return new StringBuilder().append("min:").append(min).append("\nmax:").append(max).toString();
        }
    }

	private static MinMax findMinMax(List<Integer> arr) {
		if (arr.size() <= 1) {
			return new MinMax(arr.get(0), arr.get(0));
		}

		MinMax result = new MinMax(arr.get(0), arr.get(1));
		for (int i = 2; i+1 < arr.size(); i+=2) {
            MinMax temp = MinMax.setMinMax(arr.get(i), arr.get(i+1));
            result = new MinMax(
                    Math.min(result.min, temp.min),
                    Math.max(result.max, temp.max));

		}

		if (arr.size()%2 != 0) {
            result = new MinMax(
                    Math.min(result.min, arr.get(arr.size()-1)),
                    Math.max(result.max, arr.get(arr.size()-1)));
        }

		return result;
	}

}
