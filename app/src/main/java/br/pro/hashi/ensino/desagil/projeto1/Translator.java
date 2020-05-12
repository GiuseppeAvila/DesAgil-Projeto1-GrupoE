/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import android.widget.ArrayAdapter;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;



    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {
        this.root = root;
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');
        Node i = new Node('i');
        Node j = new Node('j');
        Node k = new Node('k');
        Node l = new Node('l');
        Node m = new Node('m');
        Node n = new Node('n');
        Node o = new Node('o');
        Node p = new Node('p');
        Node q = new Node('q');
        Node r = new Node('r');
        Node s = new Node('s');
        Node t = new Node('t');
        Node u = new Node('u');
        Node v = new Node('v');
        Node w = new Node('w');
        Node x = new Node('x');
        Node y = new Node('y');
        Node z = new Node('z');
        Node n_0 = new Node('0');
        Node n_1 = new Node('1');
        Node n_2 = new Node('2');
        Node n_3 = new Node('3');
        Node n_4 = new Node('4');
        Node n_5= new Node('5');
        Node n_6 = new Node('6');
        Node n_7 = new Node('7');
        Node n_8 = new Node('8');
        Node n_9 = new Node('9');
        Node nullnode = new Node(' ');
        Node nullnode1 = new Node(' ');
        Node nullnode2 = new Node(' ');
        Node nullnode3 = new Node(' ');


        linkNodes(e,i,a,root);
        linkNodes(i,s,u,e);
        linkNodes(s,h,v,i);
        linkNodes(h,n_5,n_4,s);
        linkNodes(v,nullnode,n_3,s);
        linkNodes(u,f,nullnode1,i);
        linkNodes(nullnode1,nullnode,n_2,u);


        linkNodes(a,r,w,e);
        linkNodes(r,l,nullnode,a);
        linkNodes(w ,p,j,a);
        linkNodes(j,nullnode,n_1,w);

        linkNodes(t,n,m,root);
        linkNodes(n,d,k,t);
        linkNodes(d,b,x,n);
        linkNodes(b,n_6,nullnode,d);
        linkNodes(k,c,y,n);

        linkNodes(m,g,o,t);
        linkNodes(g,z,q,m);
        linkNodes(z,n_7,nullnode,g);
        linkNodes(o,nullnode2,nullnode3,m);
        linkNodes(nullnode2,n_8,nullnode,o);
        linkNodes(nullnode3,n_9,n_0,o);


        n_5.setParent(h);
        n_4.setParent(h);
        n_3.setParent(v);
        n_2.setParent(f);
        n_1.setParent(j);
        n_6.setParent(b);
        n_7.setParent(z);
        n_8.setParent(nullnode2);
        n_9.setParent(nullnode3);
        n_0.setParent(nullnode3);
        f.setParent(u);
        l.setParent(r);
        p.setParent(w);
        x.setParent(d);
        c.setParent(k);
        y.setParent(k);
        q.setParent(g);


        this.map=new HashMap<>();
        map.put('a',a);
        map.put('b',b);
        map.put('c',c);
        map.put('d',d);
        map.put('e',e);
        map.put('f',f);
        map.put('g',g);
        map.put('h',h);
        map.put('i',i);
        map.put('j',j);
        map.put('k',k);
        map.put('l',l);
        map.put('m',m);
        map.put('n',n);
        map.put('o',o);
        map.put('p',p);
        map.put('q',q);
        map.put('r',r);
        map.put('s',s);
        map.put('t',t);
        map.put('u',u);
        map.put('v',v);
        map.put('w',w);
        map.put('x',x);
        map.put('y',y);
        map.put('z',z);
        map.put('0',n_0);
        map.put('1',n_1);
        map.put('2',n_2);
        map.put('3',n_3);
        map.put('4',n_4);
        map.put('5',n_5);
        map.put('6',n_6);
        map.put('7',n_7);
        map.put('8',n_8);
        map.put('9',n_9);


    }

    private Node nodeparent;
    private Node noderight;
    private Node nodeleft;



    public void linkNodes(Node atual, Node nodeleft, Node noderight, Node nodeparent){
        atual.setLeft(nodeleft);
        atual.setRight(noderight);
        atual.setParent(nodeparent);
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        Node nodeAtual = root;
        for (int i = 0; i < code.length(); i++) {
            char caractere = code.charAt(i);
            if (caractere == '.') {
                if (nodeAtual.getLeft() != null) {
                    nodeAtual = nodeAtual.getLeft();
                }
            } else if (caractere == '_') {
                if (nodeAtual.getRight() != null) {
                    nodeAtual = nodeAtual.getRight();
                }
            } else {
                return ' ';
            }
        }
        return nodeAtual.getValue();
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        String morse = "";
        while (node != root){
            Node acima = node.getParent();
            if (node == acima.getLeft()){
                morse += '.';
            } else if (node == acima.getRight()){
                morse += '_';
            }
            node = acima;
        }
        return morse;
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        LinkedList translated = new LinkedList();
        String[] morseChars = new String[] {".", "-","..",".-","-.","--","...","..-",".-.",".--","-..","-.-","--.","---","....","...-","..-.",".-..",".--.",".---","-...","-..-","-.-.","-.--","--..","--.-",".....","....-","...--","..---",".----","-....","--...","---..","----.","-----"};
        LinkedList listMorse = new LinkedList(Arrays.asList(morseChars));
        for (Object c : listMorse) {
            String t = charToMorse((Node) c);
            translated.add(t);
        }
        return translated;
    }
}
