package NonLinear.BinaryTree.Model;

public abstract class TreeObject<Thing> implements Comparable<Thing> {
    
    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compareTo(Thing thing);
    public abstract String toString();
    
}
