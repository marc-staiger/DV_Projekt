import java.awt.*;
import java.io.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.font.*;
import javax.imageio.*;
import javax.swing.JPanel;


public class Board extends JPanel
{
    public static enum PIECES {ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN};

    private int boardsize;
    private int fieldsize=110;
    private int piecesize = 82;
    float scaleFactor = 0.75f;

    private BufferedImage bi[];
    private Integer pieces[][];
    private Integer colors[][];
    
    private String message;
    private int highlighted = -1;

    public Board(int boardsize)
    {
        this.boardsize = boardsize;
        this.message = "";
    }

    public void init() 
    {
        pieces = new Integer[boardsize][boardsize];
        colors = new Integer[boardsize][boardsize];

        //---  Load images ---//
        String s[] = { "board-white.png", "board-black.png", "merida2.png"};
        bi = new BufferedImage[s.length];

        for ( int i = 0; i < bi.length; i++ ) 
        {
            try 
            {
                File f = new File("./images/" + s[i]);
                //URL f = new URL("http://192.168.2.114/queens/"+ s[i]);
                BufferedImage bufferedImage = ImageIO.read(f);
                bi[i] = bufferedImage;
                
            } 
            catch (Exception e) 
            {
                System.err.println("Error reading file: ");
                System.exit(1);
            }
        }
    }

    public void setMessage(String message) {this.message=message;}
    public void setHighlighted(int row, int col) {this.highlighted=row*boardsize+col;}
    public int getBoardSize() {return (int)(fieldsize*scaleFactor*boardsize);}
    
    private BufferedImage getPiece(int type, int color)
    {
       BufferedImage piece = bi[2].getSubimage(type*piecesize,color*piecesize, piecesize, piecesize);
       return piece;
               
    }
    public void addPiece(int type, int color, int x, int y)
    {
        if (type==-1) return;
        pieces[x][y]=type;
        colors[x][y]=color;
    }
    public void removePiece(int x, int y)
    {
        pieces[x][y]=null;
        colors[x][y]=null;
    }
    
    public void paint( Graphics g ) 
    {
        Graphics2D g2 = (Graphics2D) g;
        drawBoard(g2, this, message);
    }

   public void drawBoard(Graphics2D g2, Component context, String message)
   {
	   System.out.println("draw board");
        //int iw = bi[0].getWidth(this);
        //int ih = bi[0].getHeight(this);
        int iw = bi[0].getWidth(context);
        int ih = bi[0].getHeight(context);
        
        int x = 0, y = 0;

        for ( int fX = 0; fX < boardsize; ++fX ) 
        for ( int fY = 0; fY < boardsize; ++fY ) 
        {
            int i = (fX+fY)%2;
            x = (int)(fX*fieldsize*scaleFactor);
            y = (int)(fY*fieldsize*scaleFactor);

            //---  Create a scaled transformation for the image ---//
            AffineTransform at = new AffineTransform();
            at.scale(scaleFactor, scaleFactor);

            //--- draw field (black or white to bimg ---//
            BufferedImageOp biop = null;
            BufferedImage bimg = new BufferedImage(iw, ih, BufferedImage.TYPE_INT_ARGB);
            bimg.getGraphics().drawImage(bi[i],0,0, context);// = bi[i];
           
            //--- get correct piece and draw to bimg ---//
            Integer pieceNr = pieces[fX][fY];//[fY*boardsize+fX];
            Integer color = colors[fX][fY];//[fY*boardsize+fX];
            if (pieceNr!=null)
            {
                BufferedImage piece = this.getPiece(pieceNr, color);
                bimg.getGraphics().drawImage(piece, 10, 10, context);
            }

            //--- draw piece to component ---//
            biop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            g2.drawImage(bimg,biop,x,y);
         
            //--- highlight field ---//
            if (fX+fY*boardsize==highlighted)
            {
                drawRedSquare(g2, fX, fY);
            }

            //--- display text message ---//
            drawMessage(g2);
        }
    }

    private void drawRedSquare(Graphics2D g2, int fX, int fY) 
    {
        float size = fieldsize*scaleFactor;
        g2.setPaint(Color.red);
        g2.setStroke(new BasicStroke(5.f));
        Rectangle2D redSquare = new Rectangle2D.Float(fX*size+5, fY*size+5, size-10, size-10);
        g2.draw(redSquare);
    }

    private void drawMessage(Graphics2D g2)
    {
        if (message.length()>0)
        {
            Font f = new Font("Helvetica",Font.BOLD, 24);
            g2.setColor(Color.red);
            TextLayout tl = new TextLayout(message, f,g2.getFontRenderContext());
            tl.draw(g2, (float) (getBoardSize()/2-70), (float) (getBoardSize()/2-20));
        }
    }
}
