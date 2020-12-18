/*
Leetcode 1367
*/
public boolean isSubPath(ListNode head, TreeNode root) {
	    if ( head == null ) return true;
	    if ( root == null ) return false;
	    return isSubPath(head, root.left) || isSubPath(head, root.right) || Callback(head, root);
	}
private boolean Callback(ListNode head, TreeNode root) {
	    if ( head == null ) return true;
	    if ( root == null ) return false;
	    
	    return head.val == root.val && (Callback(head.next, root.left) || 
	        Callback(head.next,root.right));
	}

/*
Leetcode 563
*/
private int count;
    public int findTilt(TreeNode root) {
        dfs(root);
        return count;
        
    }
    
    private int dfs( TreeNode root ) {
        if ( root == null ) return 0;
        
        int leftsum = dfs( root.left );
        int rightsum = dfs( root.right );
        count += Math.abs(leftsum - rightsum);
        
        return root.val + leftsum + rightsum;
        
    }

/*
Leetcode 617
*/
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if ( t1 == null ) return t2;
    if ( t2 == null ) return t1;
    
    t1.val = t1.val + t2.val;
    t1.left = mergeTrees( t1.left, t2.left );
    t1.right = mergeTrees( t1.right, t2.right );
    
    return t1;
}

/*
Construct a Binary tree from Inorder and Preorder traversal
*/
HashMap <Integer, Integer> map = new HashMap<>();
    int [] preorder;
    int [] inorder;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for ( int i = 0; i < inorder.length; i++  ) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return helper(0, inorder.length);
    }
    
    private  TreeNode helper( int start, int end ) {
        if (start >= end) 
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        index ++;
        
        int rootIndex = map.get(root.val);
        
            
        root.left = helper( start, rootIndex );
        root.right = helper( rootIndex + 1, end );
        return root;
    }

/*
Leetcode 1245
*/
List < ArrayList<Integer> > list = new ArrayList<>();
int max = 0;
//int node;
public int treeDiameter(int[][] edges) {
    
    for ( int i = 0; i < edges.length + 1; i ++) {
        list.add(new ArrayList<Integer> ());
    }
    
    for (int [] edge : edges) {
        list.get(edge[0]).add(edge[1]);
        list.get(edge[1]).add(edge[0]);
    }
    HashSet<Integer> visited = new HashSet<>();
    findFurthestNode(0, visited);
    return max;
    
}
public int findFurthestNode(int current, HashSet<Integer> visited) {
    visited.add(current);
    int max1 = 0;
    int max2 = 0;
    for ( int i : list.get(current) ) {
        int dist = 0;
        if ( !visited.contains(i) ) {
            dist = 1 + findFurthestNode(i, visited);
        }
        
        if (dist >= max1) {
            max2 = max1;
            max1 = dist; 
        }
        else if (dist > max2) max2 = dist;
        max = Math.max( max, max1 + max2);
        //System.out.println(max);
    }
    return max1;
}










