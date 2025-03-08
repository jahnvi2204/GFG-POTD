
class Solution:
    def longestPalindrome(self, s):
        # code here
        n = len(s)
        maxi, res = -1e9, ""
        for i in range(n):
            l, r = i, i
            while(l >= 0 and r < n):
                if s[l] == s[r]:
                    if maxi < r - l + 1:
                        maxi = r - l + 1
                        res = s[l: r+1]
                    l -= 1
                    r += 1
                else:
                    break
            l, r = i, i+1
            while(l >= 0 and r < n):
                if s[l] == s[r]:
                    if maxi < r - l + 1:
                        maxi = r - l + 1
                        res = s[l: r+1]
                    l -= 1
                    r += 1
                else:
                    break
        return res

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

    t = int(input())

    for _ in range(t):
        S = input()

        ob = Solution()

        ans = ob.longestPalindrome(S)

        print(ans)
        print("~")
# } Driver Code Ends