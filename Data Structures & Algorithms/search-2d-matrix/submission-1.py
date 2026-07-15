class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        # If the target > than 1st number of a row, then target COULD be inside the row ONLY if 
        # target is smaller than the last number of the row

        # we know that if the target is smaller than the 1st number of the row, 
        # then target must live inside the previous row

        top, bot = 0, len(matrix) - 1

        while top <= bot:
            mid = (top + bot ) // 2
            first_ele = matrix[mid][0]

            if first_ele > target:
                bot = mid - 1
            elif first_ele <= target:
                if first_ele == target:
                    return True
                
                l, r = 0, len(matrix[mid]) - 1
                while l <= r:
                    m = (l+r) // 2
                    element = matrix[mid][m]
                    if element < target:
                        l = m + 1
                    elif element > target:
                        r = m - 1
                    else:
                        return True
                top = mid + 1

        return False