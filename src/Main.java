import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Main implements ActionListener {
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private static JButton button4;
    private static JButton button5;
    private static JButton button6;
    private static JButton button7;
    private static JButton button8;
    private static JButton button9;
    private static JButton[] buttons;
    private static char[] board;
    private static final Random r = new Random();
    private static boolean endGame = false;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        JFrame frame = new JFrame("TicTacToe");
        frame.setSize(496, 498);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));
        frame.setLocationRelativeTo(null);

        board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};


        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        buttons = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};

        for (JButton button : buttons) {
            button.addActionListener(this);
            button.setFocusable(false);
            button.setBackground(Color.WHITE);
            button.setContentAreaFilled(false);
            button.setSize(166, 166);
            button.setFont(new Font("Roboto", Font.PLAIN, 30));
            frame.add(button);
        }

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean computerTurn = true;
        if (e.getSource() == button1 && button1.getText().equals("")) {
            board[0] = 'X';
            button1.setText("X");
            button1.setEnabled(false);
            if (checkWin(board, 0)) {
                win(true);
                return;
            }
        } else if (e.getSource() == button2 && button2.getText().equals("")) {
            board[1] = 'X';
            button2.setText("X");
            button2.setEnabled(false);
            if (checkWin(board, 1)) {
                win(true);
                return;
            }
        } else if (e.getSource() == button3 && button3.getText().equals("")) {
            board[2] = 'X';
            button3.setText("X");
            button3.setEnabled(false);
            if (checkWin(board, 2)) {
                win(true);
                return;
            }
        } else if (e.getSource() == button4 && button4.getText().equals("")) {
            board[3] = 'X';
            button4.setText("X");
            button4.setEnabled(false);
            if (checkWin(board, 3)) {
                win(true);
                return;
            }
        } else if (e.getSource() == button5) {
            if (!endGame && button5.getText().equals("")) {
                board[4] = 'X';
                button5.setText("X");
                button5.setEnabled(false);
                if (checkWin(board, 4)) {
                    win(true);
                    return;
                }
            } else {
                for (JButton button : buttons) {
                    button.setText("");
                    button.setEnabled(true);
                }
                Arrays.fill(board, ' ');
                endGame = false;
                computerTurn = r.nextBoolean();
            }
        } else if (e.getSource() == button6 && button6.getText().equals("")) {
            board[5] = 'X';
            button6.setText("X");
            button6.setEnabled(false);
            if (checkWin(board, 5)) {
                win(true);
                return;
            }
        } else if (e.getSource() == button7 && button7.getText().equals("")) {
            board[6] = 'X';
            button7.setText("X");
            button7.setEnabled(false);
            if (checkWin(board, 6)) {
                win(true);
                return;
            }
        } else if (e.getSource() == button8 && button8.getText().equals("")) {
            board[7] = 'X';
            button8.setText("X");
            button8.setEnabled(false);
            if (checkWin(board, 7)) {
                win(true);
                return;
            }
        } else if (e.getSource() == button9 && button9.getText().equals("")) {
            board[8] = 'X';
            button9.setText("X");
            button9.setEnabled(false);
            if (checkWin(board, 8)) {
                win(true);
                return;
            }
        }
        checkTie();
        if (computerTurn) {
            computerTurn(board);
        }
    }

    public void checkTie() {
        for (char button : board) {
            if (button == ' ') {
                return;
            }
        }
        System.out.println("hello");
        tie();
    }

    public boolean checkWin(char[] board, int position) {
        return checkColumn(board, position) || checkRows(board, position) || checkDiagonal(board, position);
    }

    public boolean checkColumn(char[] board, int position) {
        if ((position == 0 || position == 3 || position == 6) && (board[0] == board[3] && board[3] == board[6])) {
            return true;
        }
        if ((position == 1 || position == 4 || position == 7) && (board[1] == board[4] && board[4] == board[7])) {
            return true;
        }
        return (position == 2 || position == 5 || position == 8) && (board[2] == board[5] && board[5] == board[8]);
    }

    public boolean checkDiagonal(char[] board, int position) {
        if ((position == 0 || position == 4 || position == 8) && (board[0] == board[4] && board[4] == board[8])) {
            return true;
        }
        return (position == 2 || position == 4 || position == 6) && (board[2] == board[4] && board[4] == board[6]);
    }

    public boolean checkRows(char[] board, int position) {
        if ((position == 0 || position == 1 || position == 2) && (board[0] == board[1] && board[1] == board[2])) {
            return true;
        }
        if ((position == 3 || position == 4 || position == 5) && (board[3] == board[4] && board[4] == board[5])) {
            return true;
        }
        return (position == 6 || position == 7 || position == 8) && (board[6] == board[7] && board[7] == board[8]);
    }

    public int computerCheckWin(char[] board, boolean print) {
        if (print) System.out.println("Rows: " + computerCheckRows(board) + "\nColumns: " + computerCheckColumns(board) + "\nDiagonals: " + computerCheckDiagonal(board) + "\nAnswer: " + largest(new int[]{computerCheckRows(board), computerCheckColumns(board), computerCheckDiagonal(board)}));
        return largest(new int[]{computerCheckRows(board), computerCheckColumns(board), computerCheckDiagonal(board)});
    }

    public int computerCheckDiagonal(char[] board) {
        if ((board[4] == board[8]) && board[4] == 'X' && board[0] != 'O') {
            return 0;
        }
        if ((board[4] == board[6]) && board[4] == 'X' && board[2] != 'O') {
            return 2;
        }
        if ((board[0] == board[8]) && board[0] == 'X' && board[4] != 'O') {
            return 4;
        }
        if ((board[2] == board[6]) && board[2] == 'X' && board[4] != 'O') {
            return 4;
        }
        if ((board[2] == board[4]) && board[2] == 'X' && board[6] != 'O') {
            return 6;
        }
        if ((board[0] == board[4]) && board[0] == 'X' && board[8] != 'O') {
            return 8;
        }
        return -1;
    }

    public int computerCheckColumns(char[] board) {
        if ((board[3] == board[6]) && board[3] == 'X' && board[0] != 'O') {
            return 0;
        }
        if ((board[4] == board[7]) && board[4] == 'X' && board[1] != 'O') {
            return 1;
        }
        if ((board[5] == board[8]) && board[5] == 'X' && board[2] != 'O') {
            return 2;
        }
        if ((board[0] == board[6]) && board[0] == 'X' && board[3] != 'O') {
            return 3;
        }
        if ((board[1] == board[7]) && board[1] == 'X' && board[4] != 'O') {
            return 4;
        }
        if ((board[2] == board[8]) && board[2] == 'X' && board[5] != 'O') {
            return 5;
        }
        if ((board[0] == board[3]) && board[0] == 'X' && board[6] != 'O') {
            return 6;
        }
        if ((board[1] == board[4]) && board[1] == 'X' && board[7] != 'O') {
            return 7;
        }
        if ((board[2] == board[5]) && board[2] == 'X' && board[8] != 'O') {
            return 8;
        }
        return -1;
    }

    public int computerCheckRows(char[] board) {
        if ((board[1] == board[2]) && board[1] == 'X' && board[0] != 'O') {
            return 0;
        }
        if ((board[0] == board[2]) && board[0] == 'X' && board[1] != 'O') {
            return 1;
        }
        if ((board[0] == board[1]) && board[0] == 'X' && board[2] != 'O') {
            return 2;
        }
        if ((board[4] == board[5]) && board[4] == 'X' && board[3] != 'O') {
            return 3;
        }
        if ((board[3] == board[5]) && board[3] == 'X' && board[4] != 'O') {
            return 4;
        }
        if ((board[3] == board[4]) && board[3] == 'X' && board[5] != 'O') {
            return 5;
        }
        if ((board[7] == board[8]) && board[7] == 'X' && board[6] != 'O') {
            return 6;
        }
        if ((board[6] == board[8]) && board[6] == 'X' && board[7] != 'O') {
            return 7;
        }
        if ((board[6] == board[7]) && board[6] == 'X' && board[8] != 'O') {
            return 8;
        }
        return -1;
    }

    public void computerTurn(char[] board) {
        boolean b = true;
        int count = 0;
        int tries = 0;
        while (true) {
            int computerChoice;
            if (b) {
                if (computerCheckWin(board, true) == -1) {
                    computerChoice = r.nextInt(9);
                    count++;
                } else {
                    computerChoice = computerCheckWin(board, false);
                    tries++;
                }
            } else {
                computerChoice = r.nextInt(9);
                count++;
            }
            if (board[computerChoice] == ' ') {
                buttons[computerChoice].setText("O");
                buttons[computerChoice].setEnabled(false);
                board[computerChoice] = 'O';
                printBoard();
                if (checkWin(board, computerChoice)) {
                    win(false);
                }
                break;
            }
            if (count == 10000) {
                tie();
                break;
            }
            if (tries == 10000) {
                b = false;
            }
        }
    }

    public void win(boolean player) {
        if (player) {
            System.out.println("You win :)");
        } else {
            System.out.println("You lose :(");
        }
        printBoard();
        endGame();
    }

    public void tie() {
        System.out.println("Tie game!");
        printBoard();
        endGame();
    }

    public void endGame() {
        endGame = true;
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        buttons[4].setEnabled(true);
        buttons[4].setText("Replay?");
    }

    static int largest(int[] arr) {
        int i;

        int max = arr[0];

        for (i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public void printBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("- + - + -");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("- + - + -");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

}
