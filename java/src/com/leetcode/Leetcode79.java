package com.leetcode;

/**
 * Created by 强 on 2018/9/21.
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.
 */
public class Leetcode79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exists(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    //i是行，j是列，index是word的索引
    private static boolean exists(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index) || board[i][j] == 0) return false;
        char temp = board[i][j];//遍历过的节点标记为0作为visited状态
        board[i][j] = 0;
        boolean res = exists(board, word, i+1, j,  index+1) ||
                exists(board, word, i, j+1,  index+1) ||
                exists(board, word, i-1, j,  index+1) ||
                exists(board, word, i, j-1,  index+1) ;
        board[i][j] = temp;//复位
        return res;
    }
}
