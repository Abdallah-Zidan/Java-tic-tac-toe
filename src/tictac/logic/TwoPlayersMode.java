///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tictac.logic;
//
///**
// *
// * @author zidan
// */
//public class TwoPlayersMode extends Game {
//
//    public TwoPlayersMode(boolean isRecorded, Player oppenent, PlayerSign myMark) {
//        super(isRecorded, oppenent, myMark);
//    }
//
//   
//
//    @Override
//    public void start() {
//         System.out.println(board);
//        while(!gameEnded){
//            Position position = null;
//            if(myTurn){
//                position = makeMove();
//                board = new Board(board, position, myMark);
//            }else{
//                position = makeMove();
//                board = new Board(board, position, oppenentMark);
//            }               
//            myTurn = !myTurn;
//                System.out.println(board);
//                evaluateGame();
//        }
//    }
//    
//}
