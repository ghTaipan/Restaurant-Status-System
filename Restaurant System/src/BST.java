import java.util.ArrayList;
import java.util.StringTokenizer;

public class BST<T> implements BSTInterface<T> {
    AList<nodeBST<T>> alist = new AList<>();
    Stack<Object> stack = new Stack<>();
    Queue<nodeBST<T>> queue = new Queue<>();
    private nodeBST<T> root;
    private int order;

    public BST() {
        root = null;
    }

    public BST(int order) {
        root = null;
        if (order > 3)
            this.order = order - 3;
        else
            this.order = order;
    }

    public nodeBST<T> getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public nodeBST<T> add(nodeBST<T> node, T anEntry, double data) {
        StringTokenizer st = new StringTokenizer(anEntry.toString(), ",");
        double x;
        if (node == null) {
            for (int i = 0; i < order; i++) {
                st.nextToken();
            }
            node = new nodeBST<T>(anEntry, Double.parseDouble(st.nextToken()));
            alist.add(node);
        } else {
            for (int i = 0; i < order; i++) {
                st.nextToken();
            }
            x = Double.parseDouble(st.nextToken());
            Comperator comp = new Comperator((double) node.getData(), x);
            if (comp.compareTo() > 0)
                node.left = add(node.left, anEntry, x);
            else
                node.right = add(node.right, anEntry, x);
        }
        return node;
    }

    @Override
    public void add(T anEntry) {
        root = add(root, anEntry, 0);
    }

    @Override
    public void delete(T x) {
        if (isEmpty())
            System.out.println("The tree is empty");
        else if (search(x) == false)
            System.out.println("Sorry " + x + " is not in the tree");
        else {
            root = delete(root, x);
        }
    }

    @Override
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(nodeBST<T> r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    public nodeBST<T> delete(nodeBST<T> root, T in) {
        StringTokenizer st = new StringTokenizer(in.toString(), ",");
        double a;
        for (int i = 0; i < order; i++) {
            st.nextToken();
        }
        a = Double.parseDouble(st.nextToken());
        nodeBST<T> x, y, z;
        if (root.getData() == a) {
            nodeBST<T> lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                x = rt;
                return x;
            } else if (rt == null) {
                x = lt;
                return x;
            } else {
                y = rt;
                x = rt;
                while (x.getLeft() != null)
                    x = x.getLeft();
                x.setLeft(lt);
                return y;
            }
        }
        if (a < root.getData()) {
            z = delete(root.getLeft(), in);
            root.setLeft(z);
        } else {
            z = delete(root.getRight(), in);
            root.setRight(z);
        }
        return root;
    }

    @Override
    public boolean search(T value) {
        return search(root, value);
    }

    public boolean search(nodeBST<T> r, T value) {
        StringTokenizer st = new StringTokenizer(value.toString(), ",");
        double a;
        for (int i = 0; i < order; i++) {
            st.nextToken();
        }
        a = Double.parseDouble(st.nextToken());
        boolean found = false;
        while ((r != null) && !found) {
            double rvalue = r.getData();
            if (a < rvalue)
                r = r.getLeft();
            else if (a > rvalue)
                r = r.getRight();
            else {
                found = true;
                break;
            }
            found = search(r, value);
        }
        return found;
    }

    @Override
    public void DescendingInOrder() {
        DescendingInOrder(root);
    }

    public void DescendingInOrder(nodeBST<T> r) {
        if (r != null) {
            DescendingInOrder(r.getLeft());
            stack.push(r.getValue());

            DescendingInOrder(r.getRight());
        }
    }

    @Override
    public void AscendingInOrder() {
        AscendingInOrder(root);
    }

    public void AscendingInOrder(nodeBST<T> r) {
        if (r != null) {
            AscendingInOrder(r.getRight());
            stack.push(r.getValue());
            AscendingInOrder(r.getLeft());
        }
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    public void preorder(nodeBST<T> r) {
        if (r != null) {
            stack.push(r.getValue());
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    private T levelOrderNext() {
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            nodeBST<T> currentNode = queue.dequeue();
            T result = (T) currentNode;
            if (currentNode.left != null)
                queue.enqueue(currentNode.left);
            if (currentNode.right != null)
                queue.enqueue(currentNode.right);
            return result;
        }
        return null;

    }

    @Override
    public void postorder() {
        postorder(root);
    }

    public void postorder(nodeBST<T> r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            stack.push(r.getValue());
        }
    }
}

