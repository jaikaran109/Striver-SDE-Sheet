class Pair {
    Node node;
    int hd;
    Pair(Node _node, int _hd) {
        node = _node;
        hd = _hd;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair it = q.remove();
            Node temp = it.node;
            int hd = it.hd;

            map.put(hd, temp.data);   // bottom view: baad wali value overwrite karti hai (yahi sahi hai)

            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));   // yaha bhi ek bug hai neeche dekho
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
