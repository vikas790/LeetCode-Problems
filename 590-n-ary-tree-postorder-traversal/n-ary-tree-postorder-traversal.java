/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
      private List<Integer> node=new ArrayList<>();
    private void post(Node root)
    {
        if(root!=null)
        {
            int siz=root.children.size();
            //System.out.println(siz);
            for(int i=0;i<siz;i++)
            {
                post(root.children.get(i));
            }
            node.add(root.val);

        }
    }
    public List<Integer> postorder(Node root) {
        post(root);
        return node;
    }
}
