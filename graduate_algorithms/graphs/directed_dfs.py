clock = 1

def connected_comp_dfs(g):
    global clock
    pre = [None] * g.V()
    post = [None] * g.V()
    visited = [False] * g.V()
    for i in range(g.V()):
        if not visited[i]:
            explore(g, i, visited, pre, post)

    return post

def explore(g, v, visited, pre, post):
    global clock
    pre[v] = clock
    clock += 1
    visited[v] = True
    for w in g.adj[v]:
        if not visited[w]:
            explore(g, w, visited, pre, post)
    post[v] = clock
    clock += 1

if __name__ == "__main__":
    from dgraph import DirectedGraph
    g = DirectedGraph(7)

    g.add_edge(0, 5)
    g.add_edge(0, 2)
    g.add_edge(0, 1)
    g.add_edge(3, 6)
    g.add_edge(3, 5)
    g.add_edge(3, 4)
    g.add_edge(5, 2)
    g.add_edge(6, 4)
    g.add_edge(6, 0)
    g.add_edge(3, 2)
    g.add_edge(1, 4)

    print(connected_comp_dfs(g))
    
    


