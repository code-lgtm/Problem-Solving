def connected_comp_dfs(g):
    cc = 0
    ccnum = [None] * g.V()
    visited = [False] * g.V()
    for i in range(g.V()):
        if not visited[i]:
            explore(g, i, visited, cc, ccnum)
            cc += 1

    return ccnum

def connected_comp_dfs_order(g, order):
    cc = 0
    ccnum = [None] * g.V()
    visited = [False] * g.V()
    for i in order:
        if not visited[i]:
            explore(g, i, visited, cc, ccnum)
            cc += 1

    return ccnum

def explore(g, v, visited, cc, ccnum):
    ccnum[v] = cc
    visited[v] = True
    for w in g.adj[v]:
        if not visited[w]:
            explore(g, w, visited, cc, ccnum)


if __name__ == "__main__":
    from graph import Graph
    g = Graph(13)
    
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(0, 6)
    g.add_edge(0, 5)
    g.add_edge(4, 6)
    g.add_edge(4, 3)
    g.add_edge(5, 3)
    g.add_edge(5, 4)

    g.add_edge(7, 8)

    g.add_edge(9, 10)
    g.add_edge(9, 11)
    g.add_edge(9, 12)
    g.add_edge(11, 12)

    print(connected_comp_dfs(g))
