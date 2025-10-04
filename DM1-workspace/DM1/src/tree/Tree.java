package tree;

import java.util.HashMap;

public class Tree<E> {
        private Node<E> root;
        private HashMap<E,Node<E>> nodes;

        public Tree(E rootElement){
            this.root = new Node<E>(rootElement);
            this.nodes = new HashMap<E,Node<E>>();
            nodes.put(rootElement, root);
        }

        public void addChild(E parent, E child) {
            Node<E> parentNode = nodes.get(parent);  
            
            if(nodes.containsKey(child)){
                System.out.println("Child already exists");;
            }
            else{
                Node<E> childNode = new Node<>(child);
                parentNode.addChild(childNode); 
                nodes.put(child, childNode);    
            }            
        }

        public int height(){
            return this.root.height();
        }

        public int size(){
            return this.root.size(); 
        }

        public String toString(){
            return this.root.toString();
        }
}
