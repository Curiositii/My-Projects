import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SudokuTestBuild extends JFrame{
    private JTextField[][] boxes;
    
    public SudokuTestBuild(){
        setTitle("Sudoku");
        setSize(400,400);
        setLayout(new GridLayout(9, 9));
        boxes = new JTextField[9][9];
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    for(int i = 0; i < 9; i++){
        for(int x = 0; x < 9; x++){
            boxes[i][x] = new JTextField();
            add(boxes[i][x]);
        }
    }
    setVisible(true);
}
public static void main(String[] args){
    SudokuTestBuild newGame = new SudokuTestBuild();
}
}