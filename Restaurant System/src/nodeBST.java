public class nodeBST<T> {
    nodeBST<T> left, right;
    double data;
    T value;

    /* Constructor */
    public nodeBST() {
        right = null;
        left = null;
        data = 0;
    }

    /* Constructor */
    public nodeBST(T x, double order) {
        right = null;
        right = null;
        data = order;
        value = x;
    }

    /* Function to set left node */
    public void setLeft(nodeBST<T> x) {
        left = x;
    }

    /* Function to set right node */
    public void setRight(nodeBST<T> x) {
        right = x;
    }

    public nodeBST<T> getLeft() {
        return left;
    }

    public nodeBST<T> getRight() {
        return right;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }
    public T getValue(){return value;}
}
