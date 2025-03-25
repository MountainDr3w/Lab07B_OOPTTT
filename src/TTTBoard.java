import javax.swing.*;
import java.awt.*;

class TTTBoard extends JPanel {
    private TTTTileButton[][] buttons;
    TTTRunner TTTRunner;

    public TTTBoard(TTTRunner TTTRunner) {
        this.TTTRunner = TTTRunner;
        setLayout(new GridLayout(3, 3));
        buttons = new TTTTileButton[3][3];
        createBoard();
    }

    private void createBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new TTTTileButton(row, col, this);
                add(buttons[row][col]);
            }
        }
    }

    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((buttons[i][0].getSymbol() == player && buttons[i][1].getSymbol() == player && buttons[i][2].getSymbol() == player) ||
                    (buttons[0][i].getSymbol() == player && buttons[1][i].getSymbol() == player && buttons[2][i].getSymbol() == player)) {
                return true;
            }
        }
        return (buttons[0][0].getSymbol() == player && buttons[1][1].getSymbol() == player && buttons[2][2].getSymbol() == player) ||
                (buttons[0][2].getSymbol() == player && buttons[1][1].getSymbol() == player && buttons[2][0].getSymbol() == player);
    }

    public boolean isFull() {
        for (TTTTileButton[] row : buttons) {
            for (TTTTileButton button : row) {
                if (button.getSymbol() == ' ') return false;
            }
        }
        return true;
    }

    public void resetBoard() {
        TTTRunner.turns = 0;
        for (TTTTileButton[] row : buttons) {
            for (TTTTileButton button : row) {
                button.reset();
            }
        }
    }
}