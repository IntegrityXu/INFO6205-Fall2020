/*Q1
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int k =  0;
        StringBuilder result = new StringBuilder();
        while ( l1 >= 0 || l2 >= 0) {
            int res = 0;
            if ( l1 < 0 ) {
                res = (num2.charAt(l2) - '0') + k;
            }
            else if ( l2 < 0 ) {
                res = (num1.charAt(l1) - '0') + k;
            }
            else {
                res = (num1.charAt(l1) - '0') + (num2.charAt(l2) - '0') + k;
                
            } 
            result.insert(0, res % 10);
            k = res / 10;
            l1 --;
            l2 --;
        }
        if(k != 0) {
            result.insert(0, k);
        }
        return result.toString();
    }

/*Q2
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/
 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode current = new ListNode();
        root = current;
        while( l1 != null && l2 != null ) {
            if ( l1.val < l2.val ) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if ( l2 == null ) {
            current.next = l1;
        }
        else {
            current.next = l2;
        }
        return root.next;
    }

/*Q3
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and
removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

Example:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
*/
public String removeDuplicates(String s, int k) {
        if ( s.length() < k ) return s;
        Stack <Integer> counts = new Stack<>();
        char [] ch = s.toCharArray();
        int i = 0;
        for ( int j = 0; j < ch.length; j++ ) {
            ch[i] = ch[j];
            if ( i == 0 || ch[i] != ch[i - 1] ) {
                counts.push(1);
            }
            else {
                int n = counts.pop() + 1;
                if ( n == k ) {
                    i -= k;
                }
                else {
                    counts.push(n);
                }
            }
            i++;
        }
        return new String(ch, 0, i);
    }


/*Q4
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/
char[][] board;
public boolean exist(char[][] board, String word) {
    this.board = board;
    for ( int i = 0; i < board.length; i++ ) {
        for ( int j = 0; j < board[0].length; j++ ) {
            if ( exist( word, i, j, 0) ) {
                return true;
            }
        }
    }
    return false;
  }
private boolean exist(String word, int i, int j, int n) {
    if ( n == word.length() ) return true;
    else if ( i >= board.length || j >= board[0].length || i < 0 || j < 0) {
        return false;
    }
    else if ( board[i][j] != word.charAt(n) ) return false;
    
    boolean ref = false;
    board[i][j] = '-';
    ref = exist(word, i + 1, j, n + 1) || exist(word, i, j + 1, n + 1) ||
        exist(word, i - 1, j, n + 1) || exist(word, i, j - 1, n + 1);
    
    board[i][j] = word.charAt(n);
    
    return ref;
  }

/*Q5
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
*/
public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        return isSubtree(s.left, t) || isSubtree(s.right, t) || Callback(s,t);
    }
    private boolean Callback( TreeNode s, TreeNode t) {
        if (s == null && t == null)  return true;
        if (s == null || t == null) return false;
        return s.val == t.val && Callback(s.left, t.left) && Callback(s.right, t.right);
    }

/*Q6
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/

HashSet <Integer> set = new HashSet<>();
public boolean findTarget(TreeNode root, int k) {
    
    if (root == null) {
        return false;
    }
    else {
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    } 
    //return false;
  }

/*Q7
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,k.
For example, there won't be input like 3a or 2[4].

Example:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
public String decodeString(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ']') {
            List<Character> decodedString = new ArrayList<>();
            while (stack.peek() != '[') {
                decodedString.add(stack.pop());
            }
            stack.pop();
            int base = 1;
            int k = 0;
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                k = k + (stack.pop() - '0') * base;
                base *= 10;
            }
            while (k != 0) {
                for (int j = decodedString.size() - 1; j >= 0; j--) {
                    stack.push(decodedString.get(j));
                }
                k--;
            }
        }
        else {
            stack.push(s.charAt(i));
        }
    }      
    char[] result = new char[stack.size()];
    for (int i = result.length - 1; i >= 0; i--) {
        result[i] = stack.pop();
    }
    return new String(result);
  }

/*Q8
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

public int numIslands(char[][] grid) {
    int result = 0;
    for ( int i = 0; i < grid.length; i++ ) {
        for ( int j = 0; j < grid[0].length; j++ ) {
            if ( grid[i][j] == '1') {
                result ++;
                dfs(grid, i, j);
            }
        }
    }
    return result;  
  }
private void dfs( char[][] grid, int i, int j ) {
    if ( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' ) 
        return;
    grid[i][j] = '0';
    dfs( grid, i - 1, j );
    dfs( grid, i, j - 1 );
    dfs( grid, i + 1, j );
    dfs( grid, i, j + 1);
  }

/*Q9
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

HashSet <Integer> done = new HashSet<>();
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      int [][] grid = new int [numCourses][numCourses + 1];
      for (int i = 0; i < prerequisites.length; i ++) {
          grid[prerequisites[i][0]][prerequisites[i][1]] = 1;
          grid[prerequisites[i][0]][numCourses] += 1;
      }
      HashSet <Integer> set = new HashSet<>();
      for(int i = 0; i < numCourses; i++) {
          if (grid[i][numCourses] == 0 && !done.contains(i)) {
              set.add(i);
          }
      }
      helper(set, grid, numCourses);
      if (done.size() == numCourses) return true;
      return false;
      
  }
  
  private void helper(HashSet<Integer> set, int [][] grid, int numCourses)  {
      if (set.isEmpty()) return;
      else {
          for (int i : set) {
              done.add(i);
              for (int j = 0; j < grid.length; j++)  {
                  if (grid[j][i] == 1) {
                      grid[j][i] = 0;
                      grid[j][grid.length] --;
                  }
              }
          }
          set.clear();
      }
      for(int i = 0; i < numCourses; i++) {
          if (grid[i][numCourses] == 0 && !done.contains(i)) {
              set.add(i);
          }
      }
      helper(set, grid, numCourses);
  }

/*Q10
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/

public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0) return 0;
    Arrays.sort(intervals, new Comparator<int[]> () {
        @Override
        public int compare(int[] e1, int[]e2) {
            if (e1[0] < e2[0])
                return -1;
            else 
                return 1;
        }
    });
    
    List<Integer> meeting = new ArrayList<>();
    meeting.add( intervals[0][1] ) ;
    for (int i = 1; i < intervals.length; i++) {
        int k = -1;
        for ( int end : meeting ) {
            if ( end <= intervals[i][0] ) {
                k = end;
                break;
            }
        }
        if ( k != -1 ) {
            meeting.remove((Object) k);
        }
        meeting.add( intervals[i][1] );
    }
    return meeting.size();
  }



    