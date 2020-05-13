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
    String arr[];



    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {
        this.map = new HashMap<Character, Node>();
        this.root = new Node(' ');
        char arr[] = new char[]{' ',
                'e', 't',
                'i', 'a', 'n', 'm', 's', 'u', 'r', 'w', 'd', 'k', 'g', 'o',
                'h', 'v', 'f', ' ', 'l', ' ', 'p', 'j', 'b', 'x', 'c', 'y', 'z', 'q', ' ', ' ',
                '5', '4', ' ', '3', ' ', ' ', ' ', '2', ' ', ' ', '+', ' ', ' ', ' ', ' ', '1', '6', '=', '/', ' ', ' ', ' ', ' ', ' ', '7', ' ', ' ', ' ', '8', ' ', '9', '0'
        };


        //public void newNodes(String arr){
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
            if (arr[i] != ' ') {
                this.map.put(arr[i], nodes[i]);
                nodes[i] = new Node(arr[i]);
            } else {
                nodes[i] = null;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] != null) {
                if (nodes.length > 2 * i + 1) {
                    nodes[i].setLeft(nodes[2 * i + 1]);
                }
                if (nodes.length > 2 * i + 2) {
                    nodes[i].setRight(nodes[2 * i + 2]);
                }

            }
        }
        root = nodes[0];
    }



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
        LinkedList listMorse = new LinkedList();
        while (node != root){
            Node acima = node.getParent();
            if (node == acima.getLeft()){
                 listMorse.add('.');
            } else if (node == acima.getRight()){
                listMorse.add('_');
            }
            node = acima;
        }
        String stringMorse = listMorse.toString().replaceAll(",","");

        return stringMorse;
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
            String t = charToMorse((Character) c);
            translated.add(t);
        }
        return translated;
    }
}
