import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Runner
{
    public static void main(String args[]) 
    {
        //--- command line parameters ---//
        int N = 8;
        if (args.length>0)
        {
            N = Integer.parseInt(args[0]);
        }
        int option = 3;
        if (args.length>1)
        {
            option = Integer.parseInt(args[1]);
        }
        long minTimeout = 50;
        if (args.length>2)
        {
            minTimeout = Long.parseLong(args[2]); 
        }

        //--- window title ---//
        String windowtitle = "N-Queens: ";
        switch (option)
        {
            case 1: windowtitle += "Naive Algorithm"; break;
            case 2: windowtitle += "Exhaustive Depth First Search"; break;
            case 3: windowtitle += "Backtracking"; break;
        }

        //--- set up n queens ---//
        Queens queens = new Queens();
        queens.init(N, minTimeout);
        int boardwidth = queens.getBoard().getBoardSize();

        //--- create window ---//
        JFrame f = new JFrame(windowtitle);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        f.getContentPane().add("Center", queens);
        f.pack();
        f.setSize(new Dimension(boardwidth+100,boardwidth+30));
        f.setVisible(true);
        f.setResizable(false);
        
        //--- start n queens search ---//
        queens.search(option);
    }
}
