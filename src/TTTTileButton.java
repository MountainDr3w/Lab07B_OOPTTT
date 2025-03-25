import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class TTTTileButton extends JButton {
    private int row, col;
    private char symbol;
    private TTTBoard board;

    public TTTTileButton(int row, int col, TTTBoard board) {
        this.row = row;
        this.col = col;
        this.board = board;
        symbol = ' ';
        setFont(new Font("Arial", Font.BOLD, 60));
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setFocusPainted(false);
        setOpaque(true);
        addActionListener(this::handleClick);
    }

    private void handleClick(ActionEvent e) {
        board.TTTRunner.makeMove(row, col, this);
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
        setText(String.valueOf(symbol));
    }

    public char getSymbol() {
        return symbol;
    }

    public void reset() {
        symbol = ' ';
        setText(" ");
        setEnabled(true);
    }
}