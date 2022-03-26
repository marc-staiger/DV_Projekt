/*************************************************************************
 *  Compilation:  javac Queens.java Board.java
 *  Execution:    java Queens N
 *  
 *  Solve the N queens problem using recursion and backtracing.
 *  Prints out all solutions and shows a GUI
 *
 *  Remark: this program implicitly enumerates all N^N possible
 *  placements (instead of N!), but the backtracing prunes off
 *  most of them, so it's not necessarily worth the extra
 *  complication of enumerating only permutations.
 *
 *  % java Queens 3
 *
 *  % java Queens 4
 *  * Q * * 
 *  * * * Q 
 *  Q * * * 
 *  * * Q * 
 *
 *  * * Q * 
 *  Q * * * 
 *  * * * Q 
 *  * Q * * 
 *
 *  % java Queens 8
 *  Q * * * * * * * 
 *  * * * * Q * * * 
 *  * * * * * * * Q 
 *  * * * * * Q * * 
 *  * * Q * * * * * 
 *  * * * * * * Q * 
 *  * Q * * * * * * 
 *  * * * Q * * * * 
 *
 *  ...
 *
 *************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Queens extends JPanel implements ActionListener
{
    //--- member variables ---//
    private Board board; //for visualization
    private int[] q; //storage for queen positions
    private int[][] q2; //storage for queen positions
    private int queenCount = 0; //number of queens

    private boolean stopped = true;
    private long timeout = 1000;
    private long minTimeout = 50;

    private int stepCounter = 0;
    private int solutionCounter = 0;

    //--- buttons for GUI ---//
    private JButton startButton;
    private JButton stopButton;
    private JButton toggleTimeoutButton;

    public Board getBoard() {return board;}

    public void init() { init(8, minTimeout);}
    public void init(int boardsize, long minimumTimeout)
    {
        board = new Board(boardsize);
        board.init();
        minTimeout = minimumTimeout;
        if (minTimeout==0)
        {
            stopped=false;
            timeout=0;
        }

        //--- empty queen storage ---//
        q = new int[boardsize];
        q2 = new int[boardsize][boardsize];
        for(int i=0;i<q.length; ++i) 
            q[i]=-1;
        for(int i=0;i<q.length; ++i) 
            for(int j=0;j<q.length; ++j) 
                q2[i][j]=-1;
       
        //--- setup GUI ---//
        //setBackground(Color.white);
        this.setLayout(new BorderLayout());
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(0,1));
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        toggleTimeoutButton = new JButton("<html>Toggle<br>Timeout</html>");
        controls.add(startButton);
        controls.add(stopButton);
        controls.add(toggleTimeoutButton);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        toggleTimeoutButton.addActionListener(this);
        this.add(controls, BorderLayout.EAST);
        this.add(board, BorderLayout.CENTER);
    }

    public void updateGUI() { if (minTimeout>0) repaint(); }

    public void actionPerformed(ActionEvent e)
    {
        JButton source = (JButton) e.getSource();
        if (source==stopButton)
        {
            stopped = true;
        }
        else if (source==startButton)
        {
            stopped = false;
        }
        else if (source==toggleTimeoutButton)
        {
            if (timeout==1000) timeout=minTimeout;
            else timeout=1000;
        }
    }

    public void waitIfStopped()
    {
        while (stopped)
        {
            try { Thread.sleep(timeout);} catch(InterruptedException e ){};
        }
    }

    
    //---------------------------------------------------------------------//
    // Print out N-by-N placement of queens from permutation q in ASCII.
    //---------------------------------------------------------------------//
    public void printQueens(long time) 
    {
        //--- text output ---//
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i] == j) {System.out.print("Q "); board.addPiece(3, 0, j, i);}
                else           {System.out.print("* "); board.removePiece(j,i);}
            }
            System.out.println();
        }  
        System.out.println();

        //--- GUI output ---//
        updateGUI();
        try { Thread.sleep(time);} catch(InterruptedException e ){};
    }
    public void printQueens2(long time) 
    {
        //--- text output ---//
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q2[i][j] == 1) {System.out.print("Q "); board.addPiece(3, 0, j, i);}
                else           {System.out.print("* "); board.removePiece(j,i);}
            }
            System.out.println();
        }  
        System.out.println();

        //--- GUI output ---//
        updateGUI();
        try { Thread.sleep(time);} catch(InterruptedException e ){};
    }
    
    
    //---------------------------------------------------------------------//
    // Return true if queen placement q[n] does not conflict with
    // other queens q[0] through q[n-1]
    //---------------------------------------------------------------------//
    public boolean isConsistent(int row, boolean showInconsistent) 
    {
        //--- check consistency ---//
        ++stepCounter;
        boolean consistent = true;
        int i=0;
        for (; i < row; i++) 
        {
            if (q[i] == q[row]) { consistent=false; break;}   // same column
            else if ((q[i] - q[row]) == (row - i)) {consistent=false; break;}   // same major diagonal
            else if ((q[row] - q[i]) == (row - i)) {consistent=false; break;}   // same minor diagonal
        }

        //--- display result ---//
        if (!consistent && showInconsistent) 
        {
            System.out.println("Inconsistent row: "+i);
            board.setHighlighted(i,q[i]); 
            updateGUI();
            try { Thread.sleep(timeout);} catch(InterruptedException e ){};
            waitIfStopped();
            board.setHighlighted(-1,-1);
        }
        return consistent;
    }
    
    
    
    //---------------------------------------------------------------------//
    //  Try all permutations using backtracking
    //---------------------------------------------------------------------//
    public void search(int option) 
    {
        switch (option)
        {
            case 1:
                bruteforce(0);
                break;
            case 2:
                depthfirstsearch(0);
                break;
            case 3:
                backtracking(0);
                break;
            case 4:
                queens1(0);
                break;
        }
        board.setMessage("Finished!");
        printQueens(timeout);
        System.out.println("Number of steps: "+stepCounter);
        System.out.println("Number of solutions: "+solutionCounter);
    }
    public void backtracking(int row) 
    {
        int N = q.length;
        if (row == N) 
        {
            board.setMessage("Found solution!");
            ++solutionCounter;
            printQueens(timeout);
            if (minTimeout>0) stopped = true;
            waitIfStopped();
        }
        else 
        {
            for (int i = 0; i < N; i++) 
            {
                q[row] = i;
                if (minTimeout>0) printQueens(timeout);
                waitIfStopped();
                board.setMessage("");
                if (isConsistent(row, true)) backtracking(row+1);
            }
            q[row]=-1;
            board.setMessage("Backtrack!");
            if (minTimeout>0) printQueens(timeout);
        }
    }  
    public void depthfirstsearch(int row) 
    {
        int N = q.length;
        if (row == N) 
        {
            boolean consistent = true;
            for(int i=0; i<N; ++i)
            {
                consistent = consistent && isConsistent(i, false);
            }
            if (consistent)
            {
                board.setMessage("Found solution!");
                ++solutionCounter;
                printQueens(timeout);
                if (minTimeout>0) stopped = true;
                waitIfStopped();
            }
        }
        else 
        {
            for (int i = 0; i < N; i++) 
            {
                q[row] = i;
                if (minTimeout>0) printQueens(timeout);
                waitIfStopped();
                board.setMessage("");
                depthfirstsearch(row+1);
            }
            q[row]=-1;
            //board.setMessage("Backtrack!");
            if (minTimeout>0) printQueens(timeout);
        }
    }
    public void bruteforce(int pos) 
    {
        int N = q.length;
        if (queenCount==N) return;
        if (pos==N*N) return;
        else 
        {
            for (int i=pos; i<N*N; ++i) 
            {
                q2[i/N][i%N]=1;
                ++queenCount;
                if (minTimeout>0) printQueens2(timeout);
                waitIfStopped();
                board.setMessage("");
                bruteforce(i+1);
                System.out.println("coming back");
                q2[i/N][i%N]=0;
                --queenCount;
            }
            //board.setMessage("Backtrack!");
            if (minTimeout>0) printQueens2(timeout);
        }
    }
    void queens1(int row) 
    {
        int N = q.length;
        if (row==N) return;
        else 
        {
            for ( int col=0; col<N; ++col) 
            {
                q2[row][col] = 1;
                if (minTimeout>0) printQueens2(timeout);
                waitIfStopped();
                queens1(row+1);
                q2[row][col] = -1;
            }
        }
    }    

}

