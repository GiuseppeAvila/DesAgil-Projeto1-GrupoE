/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import android.widget.ArrayAdapter;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;
    String arr[];



    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {
        // dash = right
        // dot = left

        map = new HashMap<>();

        root = new Node('*');
        Node e = new Node('e');
        Node t = new Node('t');
        Node i = new Node('i');
        Node a = new Node('a');
        Node n = new Node('n');
        Node m = new Node('m');
        Node s = new Node('s');
        Node u = new Node('u');
        Node r = new Node('r');
        Node w = new Node('w');
        Node d = new Node('d');
        Node k = new Node('k');
        Node g = new Node('g');
        Node o = new Node('o');
        Node h = new Node('h');
        Node v = new Node('v');
        Node f = new Node('f');
        Node nodenull1 = new Node(' ');
        Node l = new Node('l');
        Node nodenull2 = new Node(' ');
        Node p = new Node('p');
        Node b = new Node('b');
        Node j = new Node('j');
        Node x = new Node('x');
        Node c = new Node('c');
        Node y = new Node('y');
        Node z = new Node('z');
        Node q = new Node('q');
        Node nodenull3 = new Node(' ');
        Node nodenull4 = new Node(' ');
        Node n5 = new Node('5');
        Node n4 = new Node('4');
        Node nodenull5 = new Node(' ');
        Node n3 = new Node('3');
        Node nodenull6 = new Node(' ');
        Node nodenull7 = new Node(' ');
        Node nodenull8 = new Node(' ');
        Node n2 = new Node('2');
        Node nodenull9 = new Node(' ');
        Node nodenull10 = new Node(' ');
        Node nodenull11 = new Node(' ');
        Node nodenull12 = new Node(' ');
        Node nodenull13 = new Node(' ');
        Node nodenull14 = new Node(' ');
        Node n6 = new Node('6');
        Node n1 = new Node('1');
        Node nodenull15 = new Node(' ');
        Node nodenull16 = new Node(' ');
        Node nodenull17 = new Node(' ');
        Node nodenull18 = new Node(' ');
        Node nodenull19 = new Node(' ');
        Node n7 = new Node('7');
        Node nodenull20 = new Node(' ');
        Node nodenull21 = new Node(' ');
        Node nodenull22 = new Node(' ');
        Node n8 = new Node('8');
        Node nodenull23 = new Node(' ');
        Node n9 = new Node('9');
        Node n0 = new Node('0');


        e.setParent(root);
        t.setParent(root);
        root.setLeft(e);
        root.setRight(t);
        i.setParent(e);
        a.setParent(e);
        e.setLeft(i);
        e.setRight(a);
        n.setParent(t);
        m.setParent(t);
        t.setLeft(n);
        t.setRight(m);
        s.setParent(i);
        u.setParent(i);
        i.setLeft(s);
        i.setRight(u);
        r.setParent(a);
        w.setParent(a);
        a.setLeft(r);
        a.setRight(w);
        d.setParent(n);
        k.setParent(n);
        n.setLeft(d);
        n.setRight(k);
        g.setParent(m);
        o.setParent(m);
        m.setLeft(g);
        m.setRight(o);
        h.setParent(s);
        v.setParent(s);
        s.setLeft(h);
        s.setRight(v);
        f.setParent(u);
        nodenull1.setParent(u);
        u.setLeft(f);
        u.setRight(nodenull1);
        l.setParent(r);
        nodenull2.setParent(r);
        r.setLeft(l);
        r.setRight(nodenull2);
        p.setParent(w);
        j.setParent(w);
        w.setLeft(p);
        w.setRight(j);
        b.setParent(d);
        x.setParent(d);
        d.setLeft(b);
        d.setRight(x);
        c.setParent(k);
        y.setParent(k);
        k.setLeft(c);
        k.setRight(y);
        z.setParent(g);
        q.setParent(g);
        g.setLeft(z);
        g.setRight(q);
        nodenull3.setParent(o);
        nodenull4.setParent(o);
        o.setLeft(nodenull3);
        o.setRight(nodenull4);
        n5.setParent(h);
        n4.setParent(h);
        h.setLeft(n5);
        h.setRight(n4);
        nodenull5.setParent(v);
        n3.setParent(v);
        v.setLeft(nodenull5);
        v.setRight(n3);
        nodenull6.setParent(f);
        nodenull7.setParent(f);
        f.setLeft(nodenull6);
        f.setRight(nodenull7);
        nodenull8.setParent(nodenull1);
        n2.setParent(nodenull1);
        nodenull1.setLeft(nodenull8);
        nodenull1.setRight(n2);
        nodenull9.setParent(l);
        nodenull10.setParent(l);
        l.setLeft(nodenull9);
        l.setRight(nodenull10);
        nodenull11.setParent(nodenull2);
        nodenull2.setRight(nodenull11);
        nodenull12.setParent(p);
        nodenull13.setParent(p);
        p.setLeft(nodenull12);
        p.setRight(nodenull13);
        nodenull14.setParent(j);
        n1.setParent(j);
        j.setLeft(nodenull14);
        j.setRight(n1);
        n6.setParent(b);
        b.setLeft(n6);
        nodenull15.setParent(x);
        x.setRight(nodenull15);
        nodenull16.setParent(c);
        nodenull17.setParent(c);
        c.setLeft(nodenull16);
        c.setRight(nodenull17);
        nodenull18.setParent(y);
        nodenull19.setParent(y);
        y.setLeft(nodenull18);
        y.setRight(nodenull19);
        n7.setParent(z);
        nodenull20.setParent(z);
        z.setLeft(n7);
        z.setRight(nodenull20);
        nodenull21.setParent(q);
        nodenull22.setParent(q);
        q.setLeft(nodenull21);
        q.setRight(nodenull22);
        n8.setParent(nodenull3);
        nodenull23.setParent(nodenull3);
        nodenull3.setLeft(n8);
        nodenull3.setRight(nodenull23);
        n9.setParent(nodenull4);
        n0.setParent(nodenull4);
        nodenull4.setLeft(n9);
        nodenull4.setRight(n0);


        map.put('*', root);
        map.put('0', n0);
        map.put('1', n1);
        map.put('2', n2);
        map.put('3', n3);
        map.put('4', n4);
        map.put('5', n5);
        map.put('6', n6);
        map.put('7', n7);
        map.put('8', n8);
        map.put('9', n9);
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);
        map.put('d', d);
        map.put('e', e);
        map.put('f', f);
        map.put('g', g);
        map.put('h', h);
        map.put('i', i);
        map.put('j', j);
        map.put('k', k);
        map.put('l', l);
        map.put('m', m);
        map.put('n', n);
        map.put('o', o);
        map.put('p', p);
        map.put('q', q);
        map.put('r', r);
        map.put('s', s);
        map.put('t', t);
        map.put('u', u);
        map.put('v', v);
        map.put('w', w);
        map.put('x', x);
        map.put('y', y);
        map.put('z', z);

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
            } else if (caractere == '-') {
                if (nodeAtual.getRight() != null) {
                    nodeAtual = nodeAtual.getRight();
                }
            } else {
                nodeAtual = root;
            }
        }
        return nodeAtual.getValue();
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        StringBuilder morse = new StringBuilder();
        while (node != root){
            Node acima = node.getParent();
            if (node == acima.getLeft()){
                morse.append('.');
            } else if (node == acima.getRight()){
                morse.append('-');
            }
            node = acima;
        }
        //String stringMorse = listMorse.toString();

        return morse.reverse().toString();
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        Queue<Node> queue = new LinkedList<>();
        LinkedList<String> output = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.element();
            Node left = node.getLeft();
            Node right = node.getRight();

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }

          //  char[] especiais = new char[]{' ', '/','*','+','='};

            if (node.getValue() != ' ' &&  node.getValue() != '*') {
                output.add(charToMorse(node.getValue()));
            }

                queue.remove();
        }
        return output;
    }
}
