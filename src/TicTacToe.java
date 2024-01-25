import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1turn;
    Color winningCombination = new Color(99, 131, 81);

    TicTacToe() {
        // Parameters of the global frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Parameters of the text field
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(0, 150, 255));
        textField.setFont(new Font("Roboto", Font.BOLD, 75));
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        // Place the title
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        // Configure the button panel
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        // Create the buttons in the buttons array and add them to the panel
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setBackground(new Color(220, 220, 220));
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        // Add everything to the frame
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1turn) {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(140, 52, 52));
                        buttons[i].setText("X");
                        player1turn = false;
                        textField.setText("O turn");

                        checkWinCondition();
                    }
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(81, 116, 131));
                        buttons[i].setText("O");
                        player1turn = true;
                        textField.setText("X turn");

                        checkWinCondition();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        // Add a delay before choosing the first player so that the title is displayed for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // have the random class pick a random number to chose who starts (0 = player 1, 1 = player 2)
        if (random.nextInt(2) == 0) {
            player1turn = true;
            textField.setText("X turn");
        } else {
            player1turn = false;
            textField.setText("O turn");
        }
    }

    public void checkWinCondition() {
        // check X win conditions
        if ((Objects.equals(buttons[0].getText(), "X")) && (Objects.equals(buttons[1].getText(), "X")) && (Objects.equals(buttons[2].getText(), "X"))) {
            xWins(0, 1, 2);
        }
        if ((Objects.equals(buttons[3].getText(), "X")) && (Objects.equals(buttons[4].getText(), "X")) && (Objects.equals(buttons[5].getText(), "X"))) {
            xWins(3, 4, 5);
        }
        if ((Objects.equals(buttons[6].getText(), "X")) && (Objects.equals(buttons[7].getText(), "X")) && (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(6, 7, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "X")) && (Objects.equals(buttons[3].getText(), "X")) && (Objects.equals(buttons[6].getText(), "X"))) {
            xWins(0, 3, 6);
        }
        if ((Objects.equals(buttons[1].getText(), "X")) && (Objects.equals(buttons[4].getText(), "X")) && (Objects.equals(buttons[7].getText(), "X"))) {
            xWins(1, 4, 7);
        }
        if ((Objects.equals(buttons[2].getText(), "X")) && (Objects.equals(buttons[5].getText(), "X")) && (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(2, 5, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "X")) && (Objects.equals(buttons[4].getText(), "X")) && (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(0, 4, 8);
        }
        if ((Objects.equals(buttons[2].getText(), "X")) && (Objects.equals(buttons[4].getText(), "X")) && (Objects.equals(buttons[6].getText(), "X"))) {
            xWins(2, 4, 6);
        }

        // check O win conditions
        if ((Objects.equals(buttons[0].getText(), "O")) && (Objects.equals(buttons[1].getText(), "O")) && (Objects.equals(buttons[2].getText(), "O"))) {
            oWins(0, 1, 2);
        }
        if ((Objects.equals(buttons[3].getText(), "O")) && (Objects.equals(buttons[4].getText(), "O")) && (Objects.equals(buttons[5].getText(), "O"))) {
            oWins(3, 4, 5);
        }
        if ((Objects.equals(buttons[6].getText(), "O")) && (Objects.equals(buttons[7].getText(), "O")) && (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(6, 7, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "O")) && (Objects.equals(buttons[3].getText(), "O")) && (Objects.equals(buttons[6].getText(), "O"))) {
            oWins(0, 3, 6);
        }
        if ((Objects.equals(buttons[1].getText(), "O")) && (Objects.equals(buttons[4].getText(), "O")) && (Objects.equals(buttons[7].getText(), "O"))) {
            oWins(1, 4, 7);
        }
        if ((Objects.equals(buttons[2].getText(), "O")) && (Objects.equals(buttons[5].getText(), "O")) && (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(2, 5, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "O")) && (Objects.equals(buttons[4].getText(), "O")) && (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(0, 4, 8);
        }
        if ((Objects.equals(buttons[2].getText(), "O")) && (Objects.equals(buttons[4].getText(), "O")) && (Objects.equals(buttons[6].getText(), "O"))) {
            oWins(2, 4, 6);
        }

    }

    public void xWins(int index1, int index2, int index3) {
        // change the bg of the wining combination
        buttons[index1].setBackground(winningCombination);
        buttons[index2].setBackground(winningCombination);
        buttons[index3].setBackground(winningCombination);

        // disable all buttons
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        // change text field
        textField.setText("X wins");
    }

    public void oWins(int index1, int index2, int index3) {
        // change the bg of the wining combination
        buttons[index1].setBackground(winningCombination);
        buttons[index2].setBackground(winningCombination);
        buttons[index3].setBackground(winningCombination);

        // disable all buttons
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        // change text field
        textField.setText("O wins");
    }
}
