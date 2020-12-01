package org.hryciuk.stayinshape.fundamentals.data_structures.unionfind;

public class UnionFind {
    // number of elements in the union find
    private int size;

    // tracks the sizes of each of the components;
    private int[] sizes;

    // id[i] points to the parent of i; if id[i] == i then i is a root node
    private int[] id;

    // tracks the number of components in the union find
    private int numberOfComponents;

    private boolean hasCycle;

    public UnionFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size <= 0 is not allowed");
        }
        this.size = size;
        this.numberOfComponents = size;
        this.sizes = new int[size];
        this.id = new int[size];

        for (int i = 0; i < size; ++i) {
            id[i] = i;       // link to itself (self root)
            sizes[i] = 1;    // each component is originally of size 1
        }
    }

    // find which component/set 'p' belongs to
    // takes amortized constant time
    public int find(int p) {
        // find the root of the component/set
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        // compress the path leading back to the root.
        // doing this operation is called "path compression"
        // and is what gives us amortized constant time complexity.
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    // Returns whether or not the elements are in the same component/set
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // returns the size of the component/set 'p' belongs to
    public int componentSize(int p) {
        return sizes[find(p)];
    }

    // returns the number of elements in this UnionFind/DisjointSet
    public int size() {
        return size;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    // returns the number of cremaining components/sets
    public int components() {
        return numberOfComponents;
    }

    // Unifies the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        // elements are already in the same group
        if (root1 == root2) {
            hasCycle = true;
            return;
        }

        // merge 2 components/sets together
        // merge smaller componen/set into the larger one
        if (sizes[root1] < sizes[root2]) {
            sizes[root2] += sizes[root1];
            id[root1] = root2;
        } else {
            sizes[root1] += sizes[root2];
            id[root2] = root1;
        }

        // since the roots found are different we know that the number of components/sets has decreased by one
        numberOfComponents--;
    }
}
