package org.hryciuk.stayinshape.data_structures.graph;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.unify(edge[0], edge[1]);
        }
        return uf.numberOfComponents();
    }
}

class UnionFind {
    private int size;
    private int numberOfComponents;
    private int[] id;
    private int[] sizes;

    public UnionFind(int size) {
        this.size = size;
        this.numberOfComponents = size;
        this.id = new int[size];
        this.sizes = new int[size];

        for (int i = 0; i < size; ++i) {
            this.id[i] = i;
            this.sizes[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        if (root1 == root2) {
            return;
        }

        if (sizes[root1] > sizes[root2]) {
            sizes[root1] += sizes[root2];
            id[root2] = root1;
        } else {
            sizes[root2] += sizes[root1];
            id[root1] = root2;
        }
        numberOfComponents--;
    }

    public int numberOfComponents() {
        return numberOfComponents;
    }
}