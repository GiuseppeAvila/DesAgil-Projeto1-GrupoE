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
        Node blank1 = new Node(' ');
        Node l = new Node('l');
        Node blank2 = new Node(' ');
        Node p = new Node('p');
        Node b = new Node('b');
        Node j = new Node('j');
        Node x = new Node('x');
        Node c = new Node('c');
        Node y = new Node('y');
        Node z = new Node('z');
        Node q = new Node('q');
        Node blank3 = new Node(' ');
        Node blank4 = new Node(' ');
        Node n5 = new Node('5');
        Node n4 = new Node('4');
        Node blank5 = new Node(' ');
        Node n3 = new Node('3');
        Node blank6 = new Node(' ');
        Node blank7 = new Node(' ');
        Node blank8 = new Node(' ');
        Node n2 = new Node('2');
        Node blank9 = new Node(' ');
        Node blank10 = new Node(' ');
        Node blank11 = new Node(' ');
        Node blank12 = new Node(' ');
        Node blank13 = new Node(' ');
        Node blank14 = new Node(' ');
        Node n6 = new Node('6');
        Node n1 = new Node('1');
        Node blank15 = new Node(' ');
        Node blank16 = new Node(' ');
        Node blank17 = new Node(' ');
        Node blank18 = new Node(' ');
        Node blank19 = new Node(' ');
        Node n7 = new Node('7');
        Node blank20 = new Node(' ');
        Node blank21 = new Node(' ');
        Node blank22 = new Node(' ');
        Node n8 = new Node('8');
        Node blank23 = new Node(' ');
        Node n9 = new Node('9');
        Node n0 = new Node('0');


        root = new Node('*');
        map = new HashMap<>();
        map.put('*', root);
        e.setParent(root);
        t.setParent(root);
        root.setLeft(e);
        root.setRight(t);
        map.put('e', e);
        map.put('t', t);
        i.setParent(e);
        a.setParent(e);
        e.setLeft(i);
        e.setRight(a);
        map.put('i', i);
        map.put('a', a);
        n.setParent(t);
        m.setParent(t);
        t.setLeft(n);
        t.setRight(m);
        map.put('n', n);
        map.put('m', m);
        s.setParent(i);
        u.setParent(i);
        i.setLeft(s);
        i.setRight(u);
        map.put('s', s);
        map.put('u', u);
        r.setParent(a);
        w.setParent(a);
        a.setLeft(r);
        a.setRight(w);
        map.put('r', r);
        map.put('w', w);
        d.setParent(n);
        k.setParent(n);
        n.setLeft(d);
        n.setRight(k);
        map.put('d', d);
        map.put('k', k);
        g.setParent(m);
        o.setParent(m);
        m.setLeft(g);
        m.setRight(o);
        map.put('g', g);
        map.put('o', o);
        h.setParent(s);
        v.setParent(s);
        s.setLeft(h);
        s.setRight(v);
        map.put('h', h);
        map.put('v', v);
        f.setParent(u);
        blank1.setParent(u);
        u.setLeft(f);
        u.setRight(blank1);
        map.put('f', f);
        l.setParent(r);
        blank2.setParent(r);
        r.setLeft(l);
        r.setRight(blank2);
        map.put('l', l);
        p.setParent(w);
        j.setParent(w);
        w.setLeft(p);
        w.setRight(j);
        map.put('p', p);
        map.put('j', j);
        b.setParent(d);
        x.setParent(d);
        d.setLeft(b);
        d.setRight(x);
        map.put('b', b);
        map.put('x', x);
        c.setParent(k);
        y.setParent(k);
        k.setLeft(c);
        k.setRight(y);
        map.put('c', c);
        map.put('y', y);
        z.setParent(g);
        q.setParent(g);
        g.setLeft(z);
        g.setRight(q);
        map.put('z', z);
        map.put('q', q);
        blank3.setParent(o);
        blank4.setParent(o);
        o.setLeft(blank3);
        o.setRight(blank4);
        n5.setParent(h);
        n4.setParent(h);
        h.setLeft(n5);
        h.setRight(n4);
        map.put('5', n5);
        map.put('4', n4);
        blank5.setParent(v);
        n3.setParent(v);
        v.setLeft(blank5);
        v.setRight(n3);
        map.put('3', n3);
        blank6.setParent(f);
        blank7.setParent(f);
        f.setLeft(blank6);
        f.setRight(blank7);
        blank8.setParent(blank1);
        n2.setParent(blank1);
        blank1.setLeft(blank8);
        blank1.setRight(n2);
        map.put('2', n2);
        blank9.setParent(l);
        blank10.setParent(l);
        l.setLeft(blank9);
        l.setRight(blank10);
        blank11.setParent(blank2);
        blank2.setRight(blank11);
        blank12.setParent(p);
        blank13.setParent(p);
        p.setLeft(blank12);
        p.setRight(blank13);
        blank14.setParent(j);
        n1.setParent(j);
        j.setLeft(blank14);
        j.setRight(n1);
        map.put('1', n1);
        n6.setParent(b);
        b.setLeft(n6);
        map.put('6', n6);
        blank15.setParent(x);
        x.setRight(blank15);
        blank16.setParent(c);
        blank17.setParent(c);
        c.setLeft(blank16);
        c.setRight(blank17);
        blank18.setParent(y);
        blank19.setParent(y);
        y.setLeft(blank18);
        y.setRight(blank19);
        n7.setParent(z);
        blank20.setParent(z);
        z.setLeft(n7);
        z.setRight(blank20);
        map.put('7', n7);
        blank21.setParent(q);
        blank22.setParent(q);
        q.setLeft(blank21);
        q.setRight(blank22);
        n8.setParent(blank3);
        blank23.setParent(blank3);
        blank3.setLeft(n8);
        blank3.setRight(blank23);
        map.put('8', n8);
        n9.setParent(blank4);
        n0.setParent(blank4);
        blank4.setLeft(n9);
        blank4.setRight(n0);
        map.put('9', n9);
        map.put('0', n0);

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
