# Problem : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/submissions/

def findMinArrowShots(points) -> int:
  n = len(points)
  if not n: return 0
        
  points.sort()
  marrows = 0
  i = 0
        
  while i < n:
    marrows += 1
    j = i+1
    point = points[i]

    while j < n:
      if points[j][0] > point[1]:
        # Line j does not overlap with the previous cluster
        break
                    
      # Point is part of the cluster of lines representing arrows which
      # can be shot with a single arrow. A new line can be part of the cluster
      # if it overlaps with the line representing the point at the farthest place
      # a ballon in cluster is starting and earliest place a ballon in cluster is
      # ending. 
                
      # Calculate the new strongest cluster line that subsequent points need to overlap
      # with to be part of the cluster
      point = (max(points[j][0], point[0]), min(points[j][1], point[1]))
        j += 1
    i = j
            
  return marrows
