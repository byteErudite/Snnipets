package com.vaibhav.snippets.LLD.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SnakeAndLadder {



    private Board board;
    private List<Player> players;

    private int turn = 0;


    public void findTurn() {
        turn = turn % players.size();
        turn++;
    }

    SnakeAndLadder(List<String> players) {
        board = new Board();
        this.players = new ArrayList<>();
        for(int i =0; i< 100 ; i++) {
            Node n = new Node();
            n.pos = i;
            board.board[i] = n;
        }
        players.forEach(p -> players.add(p));
    }

    public void startGame() {
        System.out.println("Game has started...");

        int option = 0;

        while(option != 1) {
            Player turnPlayer = players.get(turn);
            System.out.println("Player "+turnPlayer.getName()+ "'s turn");
            switch (option) {
                case 0 : play();
                    break;

                case 2: // add Player
                     break;
                case 1 :
                    break;
            }
        }



    }

    public int rollDice() {
        return new Random().nextInt(7);
    }

    public void play() {
        int roll = new Random().nextInt(7);

        Player turnPlayer = players.get(turn);
        int newPos = turnPlayer.getPos();
        if (roll + newPos < 100) {
            newPos = turnPlayer.getPos() + roll;
        }

        turnPlayer.setPos(newPos);

        Node boardPos = board.board[newPos];

        while (boardPos.isLadder) {
            newPos = boardPos.next.pos + rollDice();
            boardPos = board.board[newPos];
        }

        if (boardPos.isSnake) {
            turnPlayer.setPos(boardPos.next.pos);
        }


    }

}

class Node {
    Node next;
    boolean isSnake;
    boolean isLadder;

    int pos;

}


class Board {
    Node[] board;

    Board() {
        board = new Node[100];
    }

    private void addBlock(int pos , int target, String type) {
        Node snakeNode = board[pos];
        if (type.equals("snake")) {
            snakeNode.isSnake = true;
        }
        if (type.equals("ladder")) {
            snakeNode.isLadder = true;
        }
        snakeNode.next = board[target];
    }

    public void addSnake(int pos, int target) {
        addBlock(pos, target, "snake");
    }

    public void addLadder(int pos, int target) {
        addBlock(pos, target, "ladder");
    }


}

class Player {
    private UUID playerId;
    private String name;

    private int pos;

    Player(String name) {
        playerId = UUID.randomUUID();
        this.name = name;
        this.pos = 0;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}


