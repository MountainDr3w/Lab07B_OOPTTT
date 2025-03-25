import javax.swing.*;
import java.awt.*;

public class TTTRunner extends JFrame {
    private TTTBoard board;
    private char currentPlayer;
    public int turns = 0;

    public TTTRunner() {
        setTitle("Tic Tac Toe Game!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        currentPlayer = 'X';
        board = new TTTBoard(this);

        setLayout(new BorderLayout());
        add(board, BorderLayout.CENTER);
        createQuitPanel();
    }

    private void createQuitPanel() {
        JPanel quitPanel = new JPanel();
        JButton quitButton = new JButton("Quit");
        quitButton.setBackground(Color.RED);
        quitButton.addActionListener(e -> System.exit(0));
        quitPanel.add(quitButton);
        add(quitPanel, BorderLayout.SOUTH);
    }

    public void makeMove(int row, int col, TTTTileButton button) {
        button.setSymbol(currentPlayer);
        button.setEnabled(false);
        if (board.checkWin(currentPlayer)) {
            int option = JOptionPane.showConfirmDialog(this, "Congrats, " + currentPlayer + " has won!\nDo you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) board.resetBoard();
            else System.exit(0);
        } else if (board.isFull()) {
            int option = JOptionPane.showConfirmDialog(this, "It's a tie!\nDo you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) board.resetBoard();
            else System.exit(0);
        } else {
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        turns++;
    }

    public static void main(String[] args) {
            TTTRunner TTTRunner = new TTTRunner();
            TTTRunner.setVisible(true);
    }
}
