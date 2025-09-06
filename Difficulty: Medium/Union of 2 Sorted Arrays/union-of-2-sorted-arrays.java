class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int prev = Integer.MIN_VALUE; 

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                if (a[i] != prev) {
                    ans.add(a[i]);
                    prev = a[i];
                }
                i++;
                j++;
            } 
            else if (a[i] < b[j]) {
                if (a[i] != prev) {
                    ans.add(a[i]);
                    prev = a[i];
                }
                i++;
            } else { 
                if (b[j] != prev) {
                    ans.add(b[j]);
                    prev = b[j];
                }
                j++;
            }
        }

        while (i < a.length) {
            if (a[i] != prev) {
                ans.add(a[i]);
                prev = a[i];
            }
            i++;
        }

        while (j < b.length) {
            if (b[j] != prev) {
                ans.add(b[j]);
                prev = b[j];
            }
            j++;
        }

        return ans;
    }
}
