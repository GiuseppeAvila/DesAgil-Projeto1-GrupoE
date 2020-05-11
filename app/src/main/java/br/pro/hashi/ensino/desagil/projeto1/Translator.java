/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import android.widget.ArrayAdapter;


import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;



    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator(Node root) {
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
        Node n_1 = new Node('a');
        Node n_2 = new Node('a');
        Node n_3 = new Node('a');
        Node n_4 = new Node('a');
        Node n_5= new Node('a');
        Node n_6 = new Node('a');
        Node n_7 = new Node('a');
        Node n_8 = new Node('a');
        Node n_9 = new Node('a');








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
        return " ";
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
