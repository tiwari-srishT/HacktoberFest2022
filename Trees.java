import java.util.*;


public class Trees{
    static class Node{
        int data;
        Node left;
        Node right;
        public int hd;
        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
  // building tree
    static class BinaryT{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1)
             return null;
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;

        }
    }
    //Recursive Preorder Traversal
    // public static void preorder(Node root){
    //     if(root==null)
    //      return;
    //     System.out.print(root.data+ " ");
    //     preorder(root.left);
    //     preorder(root.right);
    // }
   static void iterPreorder(Node root){
        if(root==null)
          return;

        Stack <Node> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node curr=st.pop();
            System.out.print(curr.data+" ");
            if(curr.right!=null)
             st.push(curr.right);
            if(curr.left!=null)
              st.push(curr.left);
           
        }

    }
    //Recursive Inorder Traversal
    // public static void inorder(Node root){
    //     if(root==null)
    //      return;
    //      inorder(root.left);
    //      System.out.print(root.data+ " ");
    //      inorder(root.right);
      
    // }
    public static void iterInorder(Node root){
      
        Stack <Node> st= new Stack<>();
        Node curr=root;
         while(curr!=null||!st.empty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }   
            else{
                curr=st.pop();
                System.out.print(curr.data+" ");
                curr=curr.right;
            }
        
        }
    }
    // Recursive PostOrder Traversal
    // public static void postorder(Node root){
    //     if(root==null)
    //      return;
    //     postorder(root.left);
    //      postorder(root.right);
    //     System.out.print(root.data+ " ");
       
    // }
    static void IterPostorder(Node root){
        if(root==null)
          return;
        Stack <Node> st=new Stack<>();
        st.push(root);
        Stack <Integer> s=new Stack<>();
        while(!st.empty()){
            Node curr=st.pop();
            s.push(curr.data);
            if(curr.left!=null){
                st.push(curr.left);
                
            } 
            if(curr.right!=null){
                st.push(curr.right);
                
            }   
          
        }
        while(!s.empty()){
            System.out.print(s.pop()+" ");
        }

    }
    //LevelOrder Traversal
    public static void LevelOrder(Node root){
        if(root==null) 
          return;
        Queue <Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curNode=q.remove();
            if(curNode==null){
             System.out.println();
            if(q.isEmpty())
             break;
            else{
                q.add(null);
            }
        }
        else{
            System.out.print(curNode.data+" ");
            if(curNode.left!=null){
                q.add(curNode.left);
            }
            if(curNode.right!=null){
                q.add(curNode.right);
            }
        }
    }
    } 
    public static void printLeftView(Node root){
        if(root==null)
           return;
           Queue<Node> q= new LinkedList<>();
           q.add(root);
           while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                if(i==0)
                System.out.println(curr.data+" ");
                if(curr.left!=null)
                 q.add(curr.left);
                if(curr.right!=null)
                 q.add(curr.right);
            }
 }
    }
    public static void printRightview(Node root){
        if(root==null)
         return;
         Queue<Node> q= new LinkedList<>();
         q.add(root);
         while(!q.isEmpty()){
            int c=q.size();
            for(int i=0;i<c;i++){
                Node curr=q.peek();
                q.remove();
                if(i==c-1){
                    System.out.print(curr.data+" ");
                    System.out.println();
                }
                if(curr.left!=null)
                 q.add(curr.left);
                if(curr.right!=null)
                  q.add(curr.right);
            }
        }

    }
    //
    // diameter of a binary tree
    public static int diameter(Node root){
        if(root==null)
         return 0;
        int lh= diameter(root.left);
        int rh= diameter(root.right);
        int h= height(root.left)+height(root.right)+1;
        return Math.max(h,Math.max(lh,rh));
    }
    // height of binary tree
    public static int height(Node root){
        if(root == null)
          return 0;
        int leftht=height(root.left);
        int rightht=height(root.right);
        int myht= Math.max(leftht,rightht)+1;
        return myht;
    }
     static ArrayList <Integer> Zigzag(Node root){
        ArrayList<Integer>ans= new ArrayList<>();
        if(root==null)
         return ans;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        boolean flag= true;
        while(q.size()>0){
            int size=q.size();
            ArrayList<Integer>li=new ArrayList<>();
            for(int i=0;i<q.size();i++){
                Node curr=q.poll();
                if(curr.left!=null)
                q.add(curr.left);
               if(curr.right!=null)
                 q.add(curr.right);
                li.add(curr.data);
            }
            if(flag){}
            else{
                Collections.reverse(li);
            }
            for(int i=0;i<li.size();i++){
                li.add(ans.get(i));
            }
            flag=!(flag);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
       BinaryT tree= new BinaryT();
        Node root= tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("Preorder Traversal");
        iterPreorder(root);
        System.out.println();
        System.out.println("Inorder Traversal");
       iterInorder(root);
        System.out.println();
        System.out.println("Postorder Traversal");
        IterPostorder(root);
        System.out.println();
        System.out.println( "LevelOrderTraversal");
        LevelOrder(root);
        System.out.println("The left view of tree");
        printLeftView(root);
        System.out.println("The right view of tree");
        printRightview(root);
        // System.out.println("The bottom view of tree");
        // bottomView(root);
        System.out.println("The height of binary tree is : "+  height(root));
        System.out.println("The diameter of binary tree is : " +  diameter(root));
        ArrayList<Integer> ans;
        System.out.println("The zig zag trvaersal is ");
        ans = Zigzag(root);
        for (int i = 0; i < ans.size(); i++) { // to print the order
       System.out.print(ans.get(i) + " ");
   }
    
       

    }
    private static Trees.Node buildTree(int[] nodes) {
        return null;
    }
}
