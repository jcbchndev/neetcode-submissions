class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        # 1 is the slowest time, max(piles) is the fastest time koko can eat bananas at
        # k is the number of bananas to eat from that pile DURING the hour



        k = 1
        l, r = 1, max(piles);
    
        while l <= r:
            mid = (l + r) // 2
            total_time = 0

            for pile in piles:
                total_time += math.ceil(pile / mid)
            
            if total_time <= h:
                k = mid
                r = mid - 1
            else:
                l = mid + 1
        
        return k
                