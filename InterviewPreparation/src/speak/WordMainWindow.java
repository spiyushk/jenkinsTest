package speak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color.*;
import javax.swing.event.*;
import java.util.*;

public class WordMainWindow
{

  public static void main(String [] args)
   {
        Menuframe  frame = new Menuframe();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
   }
}

class Menuframe  extends JFrame
{
    private static int screenWidth = 0 , screenHeight = 0 ;

  public Menuframe()
  {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screensize  = kit.getScreenSize();
        screenWidth  = screensize.width;
        screenHeight  = screensize.height;
        setTitle("Raj Kishori Complex");
	  setSize(screenWidth,screenHeight - 30);


        JMenu form  = new JMenu("Form");
        form.setMnemonic('F');

       
          JMenuItem  nf = form.add(new TakeAction("Start"));
          nf.setMnemonic('S');
          nf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));

          JMenuItem  imp = form.add(new TakeAction("Important Only"));
          imp.setMnemonic('I');
          imp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
          
        JMenuItem ex = form.add(new TakeAction("Exit"));
        ex.setMnemonic('x');


        JMenuBar  menubar  =   new  JMenuBar();
        setJMenuBar(menubar);
        menubar.add(form);

        JPanel jp = new JPanel();
		jp.setBackground(new Color(128,128,255));

         add(jp);


    }// COSTRUCTOR  public Menurame()
  } // CLASS MENUFRAME


  class TakeAction      extends AbstractAction
    {
      public TakeAction(String nm)
          {
                super(nm);
          }
          public void actionPerformed(ActionEvent evt)
           {
              try{
                  

                if(getValue(Action.NAME) == "Start")
                  {          
                	BlankForm.getData(false);
                	BlankForm.initializeRandom();
                	BlankForm.form4SplitWindow();
                  }

                if(getValue(Action.NAME) == "Important Only")
                {          
                  	BlankForm.getData(true);
	              	BlankForm.initializeRandom();
	              	BlankForm.form4SplitWindow();
                }
                

                if(getValue(Action.NAME) == "Exit")
                  {                        
                      System.exit(0);
                  }
		}//try

                  catch(Exception e)
		        {
          			e.printStackTrace();
		        }




           } //AP
     } //Class

