class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n); // Initialize a UnionFind data structure with 'n' nodes.
        for (int i = 0; i < n; i++) {
            if (leftChild[i] >= 0 && !uf.union(i, leftChild[i])) {
                return false; // If union fails, it means there's a cycle; return false.
            }
            if (rightChild[i] >= 0 && !uf.union(i, rightChild[i])) {
                return false; // If union fails, it means there's a cycle; return false.
            }
        }
        return uf.components() == 1; // Check if there's only one connected component.
    }
}
class UnionFind {
    private final int n;
    private final int[] roots;
    private int components;
    
    UnionFind(int n) {
        this.n = n;
        roots = new int[n]; // Initialize an array to store root nodes for each element.
        for (int i = 0; i < n; i++) {
            roots[i] = i; // Initially, each element is its own root.
        }
        components = n; // Initially, there are 'n' components (one per node).
    }
    
    public boolean union(int parent, int child) {
        int rootParent = findRoot(parent);
        int rootChild = findRoot(child);
        
        if (rootParent == rootChild || rootChild != child) {
            return false; // If the parent and child have the same root or the child is not found, it's a cycle.
        }
        
        roots[rootChild] = rootParent; // Perform the union by making the root of the child the same as the root of the parent.
        components--; // Decrease the number of components, as they are merged.
        return true;
    }
    
    private int findRoot(int v) {
        while (v != roots[v]) {
            roots[v] = roots[roots[v]]; // Path compression: Flatten the tree by making nodes point directly to their root.
            v = roots[v];
        }
        return v; // Return the root of the set containing 'v'.
    }
    
    public int components() {
        return components; // Return the number of connected components in the UnionFind structure.
    }
}