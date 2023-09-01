class Solution(object):
    def isPalindrome(self, x):
        if x >= 0:
            reversed_x = 0
            temp = x
            while temp != 0:
                curr_digit = temp % 10
                reversed_x = reversed_x * 10 + curr_digit
                temp = temp // 10
            if x - reversed_x == 0:
                return True
            
            else:
                return False
        else:
            return False