import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MayProblem1 extends JFrame implements ActionListener {
    private JButton[][] board = new JButton[3][3];
    private char currentPlayer = 'X';
    private boolean gameOver = false;
    private Random random = new Random();

    MayProblem1() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        setVisible(true);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                board[i][j] = button;
                button.addActionListener(this);
                add(button);
            }
        }
    }

    private void resetBoard() {
        currentPlayer = 'X';
        gameOver = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
                board[i][j].setEnabled(true);
            }
        }
    }

    private boolean checkForWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].getText().equals(String.valueOf(player)) && board[i][1].getText().equals(String.valueOf(player))
                && board[i][2].getText().equals(String.valueOf(player))) ||
            (board[0][i].getText().equals(String.valueOf(player)) && board[1][i].getText().equals(String.valueOf(player))
                && board[2][i].getText().equals(String.valueOf(player)))) {
                return true;
            }
        }
        if ((board[0][0].getText().equals(String.valueOf(player)) && board[1][1].getText().equals(String.valueOf(player))
            && board[2][2].getText().equals(String.valueOf(player))) ||
        (board[0][2].getText().equals(String.valueOf(player)) && board[1][1].getText().equals(String.valueOf(player))
            && board[2][0].getText().equals(String.valueOf(player)))) {
            return true;
        }
        return false;
    }

    private boolean fullBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void endOfGame(char winner) {
        String message;
        if (winner == ' ') {
            message = "It's a draw!";
        } else {
            message = winner + " wins!";
        }
        JOptionPane.showMessageDialog(null, message);
        int option = JOptionPane.showConfirmDialog(null, "Start Over?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            resetBoard();
        } else {
            dispose();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (gameOver){
            return;
        }
        JButton buttonClick = (JButton) e.getSource();
        buttonClick.setText(String.valueOf(currentPlayer));
        buttonClick.setEnabled(false);
        if (checkForWin(currentPlayer)) {
            gameOver = true;
            endOfGame(currentPlayer);
        } else if (fullBoard()) {
            gameOver = true;
            endOfGame(' ');
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            if (currentPlayer == 'O') {
                computerMove();
            }
        }
    }

    private void computerMove() {
        int row;
        int col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board[row][col].getText().isEmpty());
        board[row][col].setText(String.valueOf(currentPlayer));
        board[row][col].setEnabled(false);
        if (checkForWin(currentPlayer)) {
            gameOver = true;
            endOfGame(currentPlayer);
        } else if (fullBoard()) {
            gameOver = true;
            endOfGame(' ');
        } else {
            currentPlayer = 'X';
        }
    }

    public static void main(String[] args) {
        MayProblem1 newGame = new MayProblem1();
    }
}
