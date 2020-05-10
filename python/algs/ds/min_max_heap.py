import math

class MinMaxHeap:
  def __init__(self):
    self.A = [0]
    self.N = 0  

  def DeleteMin(self):
    if not self.N: return None
    self.A[1], self.A[self.N] = self.A[self.N], self.A[1]
    minElem = self.A[self.N]
    self.N -= 1
    self.TrickleDown(1)
    return minElem

  def DeleteMax(self):
    if not self.N: return None
    maxElem = None
    if self.N == 1 or self.N == 2:
      maxElem = self.A[self.N]
      self.N -= 1
    else:
      maxIndex = 2 if self.A[2] >= self.A[3] else 3
      self.A[maxIndex], self.A[self.N] = self.A[self.N], self.A[maxIndex]
      maxElem = self.A[self.N]
      self.N -= 1
      self.TrickleDown(maxIndex)
    return maxElem

  def Insert(self, n):
    self.N += 1
    if len(self.A) < self.N+1: self.A.append(n)
    else: self.A[self.N] = n
    self.BubbleUp(self.N)

  def FindMin(self):
    if not self.N: return None
    return self.A[1]

  def FindMax(self):
    if self.N >= 3:
      return max(self.A[2], self.A[3]) 
    elif self.N == 2:
      return self.A[2]
    return None

  def BubbleUp(self, i):
    level = int(math.log2(i))
    if not level: return
    parent = i//2
    if not level%2:
      if parent>0 and self.A[i] > self.A[parent]:
        self.A[i], self.A[parent] = self.A[parent], self.A[i]
        self.BubbleUpMax(parent)
      else:
        self.BubbleUpMin(i)
    else:
      if parent>0 and self.A[i] < self.A[parent]:
        self.A[i], self.A[parent] = self.A[parent], self.A[i]
        self.BubbleUpMin(parent)
      else:
        self.BubbleUpMax(i)

  def BubbleUpMin(self, i):
    grandparent = i//4
    if grandparent > 0 and self.A[i] < self.A[grandparent]:
      self.A[i], self.A[grandparent] = self.A[grandparent], self.A[i]
      self.BubbleUpMin(grandparent)

  def BubbleUpMax(self, i):
    grandparent = i//4
    if grandparent > 0 and self.A[i] > self.A[grandparent]:
      self.A[i], self.A[grandparent] = self.A[grandparent], self.A[i]
      self.BubbleUpMax(grandparent)

  def TrickleDown(self, i):
    level = int(math.log2(i))
    if not level: return
    if not level%2: self.TrickleDownMin(i)
    else: self.TrickleDownMax(i)

  def TrickleDownMax(self, i):
    max_child = self.findMaxChildren(i)
    grandchild_left = self.findMaxChildren(2*i)
    grandchild_right = self.findMaxChildren(2*i+1)
    if not max_child: return

    max_grandchild = None
    if grandchild_left and grandchild_right: 
      max_grandchild = max(grandchild_left, grandchild_right)
    elif grandchild_left: 
      max_grandchild = grandchild_left

    if max_grandchild and max_grandchild > max_child:
      if self.A[max_grandchild[1]] > self.A[i]:
        self.A[max_grandchild[1]], self.A[i] = self.A[i], self.A[max_grandchild[1]]
        self.TrickleDownMax(max_grandchild[1])
    else:
      if self.A[max_child[1]] > self.A[i]:
        self.A[max_child[1]], self.A[i] = self.A[i], self.A[max_child[1]]

  def TrickleDownMin(self, i):
    min_child = self.findMinChildren(i)
    grandchild_left = self.findMinChildren(2*i)
    grandchild_right = self.findMinChildren(2*i+1)
    if not min_child: return

    # Minimum Grand Child
    min_grandchild = None
    if grandchild_left and grandchild_right: 
      min_grandchild = min(grandchild_left, grandchild_right)
    elif grandchild_left: 
      min_grandchild = grandchild_left

    # Minimum Child or Grand Child
    if min_grandchild and min_grandchild < min_child:
      if self.A[min_grandchild[1]] < self.A[i]:
        self.A[min_grandchild[1]], self.A[i] = self.A[i], self.A[min_grandchild[1]]
        self.TrickleDownMin(min_grandchild[1])
    else:
      if self.A[min_child[1]] < self.A[i]:
        self.A[min_child[1]], self.A[i] = self.A[i], self.A[min_child[1]]

  def findMinChildren(self, i):
    if 2*i > self.N: return None 
    min_val = (self.A[2*i], 2*i)
    if 2*i+1 <= self.N: min_val = min(min_val, (self.A[2*i+1], 2*i+1))
    return min_val 
    
  def findMaxChildren(self, i):
    if 2*i > self.N: return None 
    max_val = (self.A[2*i], 2*i)
    if 2*i+1 <= self.N: max_val = max(max_val, (self.A[2*i+1], 2*i+1))
    return max_val 

def test():
  h = MinMaxHeap()
  h.Insert(3)
  h.Insert(1)
  h.Insert(-1)
  h.Insert(-2)
  h.Insert(2)
  h.Insert(5)
  h.Insert(7)

  print(h.DeleteMax())
  h.Insert(9)
  h.Insert(-5)
  print(h.A[:h.N+1])

test()



