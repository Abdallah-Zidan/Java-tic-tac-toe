package network;


 // Client that let a user play Tic-Tac-Toe with another across a network.
 
 import java.awt.BorderLayout;
 import java.awt.Dimension;
 import java.awt.Graphics;
import java.awt.GridLayout;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import java.net.Socket;
 import java.net.InetAddress;
 import java.io.IOException;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.JTextArea;
 import javax.swing.JTextField;
 import javax.swing.SwingUtilities;
 import java.util.Formatter;
 import java.util.Scanner;
 import java.util.concurrent.Executors;
 import java.util.concurrent.ExecutorService;
/*<applet code="TicTacToeClient" width=400 height=300></applet>*/

public class Client extends JFrame implements Runnable 
 { 
   private JTextField idField; 
   private JTextArea displayArea;
    private JPanel boardPanel; 
    private JPanel panel2; 
    private Square board[][];
    private Square currentSquare;
    private Socket connection; 
    private Scanner input;
    private Formatter output;
    private String ticTacToeHost; 
    private String myMark; 
    private boolean myTurn;
    private final String X_MARK = "X"; 
    private final String O_MARK = "O"; 

    
    public Client( String host )
    {
       ticTacToeHost = host; 
       displayArea = new JTextArea( 4, 30 );
       displayArea.setEditable( false );
       add( new JScrollPane( displayArea ), BorderLayout.SOUTH );
       boardPanel = new JPanel();
      boardPanel.setLayout( new GridLayout( 3, 3, 0, 0 ) );

       board = new Square[ 3 ][ 3 ];

      
       for ( int row = 0; row < board.length; row++ )
       {
                for ( int column = 0; column < board[ row ].length; column++ )
          {
      
             board[ row ][ column ] = new Square(  " ",row * 3 + column);
             boardPanel.add( board[ row ][ column ] ); // add square
           } 
       } 

       idField = new JTextField();
       idField.setEditable( false ); 
       add( idField, BorderLayout.NORTH ); 

      panel2 = new JPanel();  
       panel2.add( boardPanel, BorderLayout.CENTER );
       add( panel2, BorderLayout.CENTER ); 

       setSize( 300, 225 ); 
       setVisible( true );  

       startClient(); 
    } 

   
    public void startClient() 
    { 
       try  
      { 
          // make connection to server 
          connection = new Socket(InetAddress.getLocalHost( ),12345);
          // get streams for input and output 
         input = new Scanner( connection.getInputStream() );    
          output = new Formatter( connection.getOutputStream() );
       }  
      catch ( IOException ioException ) 
      { 
          ioException.printStackTrace(); 
       }  

       
       ExecutorService worker = Executors.newFixedThreadPool( 1 ); 
       worker.execute( this ); 
    }  

     
    public void run() 
    { 
       myMark = input.nextLine(); 

       SwingUtilities.invokeLater( 
          new Runnable() 
         { 
              public void run() 
             {
                 
                 idField.setText( "You are player \"" + myMark + "\"" ); 
              } 
         }  
       ); 

      myTurn = ( myMark.equals( X_MARK ) ); 
               while ( true ) 
             {
               if ( input.hasNextLine() )
               processMessage( input.nextLine() );
              } 
    } 

    
    private void processMessage( String message )
    {
    
           if(message.equals("Game over %s won"))
             {
                          displayMessage(message+"\n" );
             }    

            else if ( message.equals( "Your move is done" ) )
            {
            displayMessage( message+"\n" );
            int i=input.nextInt();
            input.nextLine();
            setMark( board[i/3][i%3], myMark ); // set mark in square
       } 
          else if(message.equals("Valid move in "))
               displayMessage(message);

         else if ( message.equals( "Invalid move, try again" ) )
         {
          displayMessage( message + "\n" ); // display invalid move
          myTurn = true; // still this client's turn
       } 
       else if ( message.equals( "Opponent moved" ) )
        {
          int location = input.nextInt(); // get move location
          input.nextLine(); // skip newline after int location
          int row = location / 3; // calculate row
          int column = location % 3; // calculate column
          setMark( board[ row ][ column ],
             ( myMark.equals( X_MARK ) ? O_MARK : X_MARK ) ); 
          displayMessage( "Opponent moved. Your turn.\n" );
          myTurn = true; 
       } 
     else
          displayMessage( message + "\n" );
    } 

    
    private void displayMessage( final String messageToDisplay )
    {
      SwingUtilities.invokeLater(
          new Runnable()
          {
            public void run()
             {
                displayArea.append( messageToDisplay ); 
             } // end method run
          } 
        ); 
    } 

    private void setMark( final Square squareToMark, final String mark )
    {
       SwingUtilities.invokeLater(
          new Runnable()
          {
              public void run()
             {
                 squareToMark.setMark( mark ); 
              } 
          } 
        );
   } 

     
    public void sendClickedSquare( int location ) 
    { 
     
       if ( myTurn ) 
       { 
          output.format( "%d\n", location );
          output.flush();                                              
          myTurn = false; 
       }  
    } 

     
    public void setCurrentSquare( Square square ) 
    { 
       currentSquare = square; 
    }  

    
    private class Square extends JPanel 
    { 
       private String mark; 
       private int location; 

       public Square( String squareMark, int squareLocation ) 
       { 
          mark = squareMark;  
          location = squareLocation;  

          addMouseListener( 
             new MouseAdapter() 
             { 
               public void mouseReleased( MouseEvent e ) 
               {
                 currentSquare=Square.this; 
            
                sendClickedSquare( getSquareLocation() ); 
               } 
             }  
           );  
       } 

     
    public Dimension getPreferredSize() 
    { 
       return new Dimension( 30, 30 );  
    } 

     
    public Dimension getMinimumSize() 
    { 
       return getPreferredSize(); 
    }  
    
    public void setMark( String newMark ) 
    { 
       mark = newMark;
       repaint(); 
    }

    
    public int getSquareLocation() 
    { 
       return location; 
    }

    public void paintComponent( Graphics g ) 
    { 
       super.paintComponent( g ); 

       g.drawRect( 0, 0, 29, 29 ); 
       g.drawString( mark, 11, 20 );  
    } 
   } 
} 
