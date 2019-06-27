if __name__ == "__main__":
    from dgraph import DirectedGraph
    from directed_dfs import connected_comp_dfs
    from dfs import connected_comp_dfs_order
    g = DirectedGraph(13)
    
    g.add_edge(0, 1)
    g.add_edge(0, 5)
    g.add_edge(2, 0)
    g.add_edge(2, 3)
    g.add_edge(3, 2)
    g.add_edge(3, 5)
    g.add_edge(4, 2)
    g.add_edge(4, 3)
    g.add_edge(5, 4)
    g.add_edge(6, 0)
    g.add_edge(6, 4)
    g.add_edge(6, 8)
    g.add_edge(6, 9)
    g.add_edge(7, 6)
    g.add_edge(7, 9)
    g.add_edge(8, 6)
    g.add_edge(9, 10)
    g.add_edge(9, 11)
    g.add_edge(10, 12)
    g.add_edge(11, 4)
    g.add_edge(11, 12)
    g.add_edge(12, 9)

    g_r = g.reverse()
    postorder = [i[0] for i in sorted(list(enumerate(connected_comp_dfs(g_r))), key = lambda x : x[1], reverse=True)]

    print(list(enumerate(connected_comp_dfs_order(g, postorder))))

