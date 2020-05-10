class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def checkBST(root):
    return isBST(root, None, None)
    
def isBST(x, minNode, maxNode):
    if x is None:
        return True
    
    if minNode and x.data <= minNode.data:
        return False
    
    if maxNode and x.data >= maxNode.data:
        return False
    
    return isBST(x.left, minNode, x) and isBST(x.right, x, maxNode)

def test():
    x = node(5)
    x.left = node(3)
    x.right = node(8)

    print checkBST(x)

test()

