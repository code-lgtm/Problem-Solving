def gD(node):
  if not node: return (0, 0, 0)
  l = [x if i==2 else x+1 for i, x in enumerate(gD(node.left))] if node.left else (0, 0, 0)
  r = [x if i==2 else x+1 for i, x in enumerate(gD(node.right))] if node.right else (0, 0, 0)
  ll = max(l[0], l[1])
  rl = max(r[0], r[1])
  return (ll, rl, max(ll+rl, l[2], r[2]))
            
    
def diameterOfBinaryTree(root):
  return gD(root)[2]
