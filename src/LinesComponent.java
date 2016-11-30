import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.Object;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LinesComponent extends JComponent{

private static class Line{
    int x1; 
    int y1;
    int x2;
    int y2;   
    Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }               
}

public static boolean isNumeric(String s) {  
    return s.matches("[-+]?\\d*\\.?\\d+");  
}  

private final static LinkedList<Line> lines = new LinkedList<Line>();

public void addLine(int x1, int x2, int x3, int x4) {
    addLine(x1, x2, x3, x4, Color.black);
    repaint();
}

public void addLine(int x1, int x2, int x3, int x4, Color color) {
    lines.add(new Line(x1,x2,x3,x4, color));        
    repaint();
}

public void clearLines() {
    lines.clear();
    repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.drawString("1", 97, 1000);
    g.drawString("2", 197, 1000);
    g.drawString("3", 297, 1000);
    g.drawString("4", 397, 1000);
    g.drawString("5", 497, 1000);
    g.drawString("6", 597, 1000);
    g.drawString("7", 697, 1000);
    g.drawString("8", 797, 1000);
    g.drawString("9", 897, 1000);
    g.drawString("10", 993, 1000);
    
    //YAS
    g.drawString("1", 0, 903);
    g.drawString("2", 0, 803);
    g.drawString("3", 0, 703);
    g.drawString("4", 0, 603);
    g.drawString("5", 0, 503);
    g.drawString("6", 0, 403);
    g.drawString("7", 0, 303);
    g.drawString("8", 0, 203);
    g.drawString("9", 0, 103);
    g.drawString("10", 0, 3);
    
    

    g.setColor(Color.white);
    //X AS TODO: Lines to full screen?
		g.drawLine(100, 985, 100, 0);

		g.drawLine(200, 985, 200, 0);

		g.drawLine(300, 985, 300, 0);

		g.drawLine(400, 985, 400, 0);

		g.drawLine(500, 985, 500, 0);

		g.drawLine(600, 985, 600, 0);

		g.drawLine(700, 985, 700, 0);

		g.drawLine(800, 985, 800, 0);

		g.drawLine(900, 985, 900, 0);

		g.drawLine(1000, 985, 1000, 0);
    
    //Y AS
		g.drawLine(10, 900, 1000, 900);

		g.drawLine(10, 800, 1000, 800);

		g.drawLine(10, 700, 1000, 700);

		g.drawLine(10, 600, 1000, 600);

		g.drawLine(10, 500, 1000, 500);

		g.drawLine(10, 400, 1000, 400);

		g.drawLine(10, 300, 1000, 300);

		g.drawLine(10, 200, 1000, 200);

		g.drawLine(10, 100, 1000, 100);
       
    for (Line line : lines) {
        g.setColor(line.color);
        System.out.println(line.x1 + " " + line.y1 + " " + line.x2 + " " + line.y2);
        g.drawLine(line.x1, 1000 - line.y1, line.x2, 1000 - line.y2);
        
    }
}

public static void main(String[] args) {
    JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    final LinesComponent comp = new LinesComponent();
    comp.setPreferredSize(new Dimension(1020, 1000));
    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
    JPanel buttonsPanel = new JPanel();
    JButton newLineButton = new JButton("New Line");
    JButton selectLineButton = new JButton("Resize line");
    JButton addVectorButton = new JButton("Add vectors");
    JButton removeLineButton = new JButton("Remove lines");
    JButton clearButton = new JButton("Clear");
    buttonsPanel.add(newLineButton);
    buttonsPanel.add(selectLineButton);
    buttonsPanel.add(removeLineButton);
    buttonsPanel.add(addVectorButton);
    buttonsPanel.add(clearButton);
    testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
 
    
    newLineButton.addActionListener(new ActionListener() { //make vector smaller and bigger
    	public void actionPerformed(ActionEvent e) {
    		
    		  JTextField xField1 = new JTextField(2);
    	      JTextField yField1 = new JTextField(2);
    	      JTextField xField2 = new JTextField(2);
    	      JTextField yField2 = new JTextField(2);

    	      JPanel myPanel = new JPanel();
    	      myPanel.add(new JLabel("x1:"));
    	      myPanel.add(xField1);
    	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    	      myPanel.add(new JLabel("y1:"));
    	      myPanel.add(yField1);
    	      myPanel.add(Box.createHorizontalStrut(15));
    	      myPanel.add(new JLabel("x2:"));
    	      myPanel.add(xField2);
    	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    	      myPanel.add(new JLabel("y2:"));
    	      myPanel.add(yField2);
    	      myPanel.add(Box.createHorizontalStrut(15));
				while (true) {
					int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Numberic X and Y Values",
							JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_CANCEL_OPTION){
						return;
					}
					if (result == JOptionPane.OK_OPTION) {
						System.out.println("x1 value: " + xField1.getText());
						System.out.println("y1 value: " + yField1.getText());
						System.out.println("x2 value: " + xField2.getText());
						System.out.println("y2 value: " + yField2.getText());
						
						if (isNumeric(xField1.getText()) && isNumeric(yField1.getText()) && isNumeric(xField2.getText()) && isNumeric(yField2.getText())) {
								double x1 = Double.parseDouble(xField1.getText()) * 100;
								double y1 = Double.parseDouble(yField1.getText()) * 100;
								double x2 = Double.parseDouble(xField2.getText()) * 100;
								double y2 = Double.parseDouble(yField2.getText()) * 100;
								if(x1 >= 0 && x1 <= 1000 && y1 >= 0 && y1 <= 1000 && x2 >= 0 && x2 <= 1000 && y2 >= 0 && y2 <= 1000){
									Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
									
									comp.addLine((int)x1, (int)y1, (int)x2, (int)y2, randomColor);
									System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
									return;
								}
						}

					}
				}

			}
    	
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int x1 = (int) (Math.random()*500);
//            int x2 = (int) (Math.random()*500);
//            int y1 = (int) (Math.random()*500);
//            int y2 = (int) (Math.random()*500);
//            Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
//            comp.addLine(x1, y1, x2, y2, randomColor);
//        }
    });
    
    selectLineButton.addActionListener(new ActionListener() { //make vector smaller and bigger		
    	public void actionPerformed(ActionEvent e) {
		  JPanel mySelectPanel = new JPanel();
		  mySelectPanel.setPreferredSize(new Dimension(400,300));
		  List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
			for(int x = 0; x < lines.size(); x++){
				mySelectPanel.add(new JLabel("Line: " + x + " | C1(x/y): " + (double)lines.get(x).x1/100 + "/" + (double)lines.get(x).y1/100 + " && C2(x/y): " + (double)lines.get(x).x2/100 + "/" + (double)lines.get(x).y2/100));
				JCheckBox lineCheckbox = new JCheckBox();
				lineCheckbox.setName("" + x);		
				checkBoxes.add(lineCheckbox);
				mySelectPanel.add(lineCheckbox);
			}			
			mySelectPanel.add(new JLabel(" "),"span, grow");
			JTextField factorField = new JTextField(2);
			mySelectPanel.add(new JLabel("Smaller bigger factor:"));
			mySelectPanel.add(factorField);
			while (true) {
				int result = JOptionPane.showConfirmDialog(null, mySelectPanel, "Select the line you want to edit",
						JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_CANCEL_OPTION){
					return;
				}
				if (result == JOptionPane.OK_OPTION) {
					if (isNumeric(factorField.getText())) {
						for (JCheckBox checkBox : checkBoxes) {
					        if (checkBox.isSelected()) {
					            //Do stuff
					        	System.out.println("Line : " + Integer.parseInt(checkBox.getName()));
					        				     		      
					        	Line line = lines.get(Integer.parseInt(checkBox.getName()));
					        	System.out.println("Before: " + line.x2 + " : " + line.y2);
					        	
					        	int i = line.x2 - line.x1;
					        	int j = line.y2 - line.y1;
					        	
					        	int i2 = (int) (i * Double.parseDouble(factorField.getText()));
					        	int j2 = (int) (j * Double.parseDouble(factorField.getText()));
					        	
					        	line.x2 = line.x1 + i2;
					        	line.y2 = line.y1 + j2;
					        	
					        	//lines.remove(Integer.parseInt(checkBox.getName()));	
					  
					        }
					    }
						testFrame.repaint();
						return;
					}	
				}
			}
		}  	
    });
    
    removeLineButton.addActionListener(new ActionListener() { //adds 2 vectors to each other	
    	public void actionPerformed(ActionEvent e) {
		  JPanel mySelectPanel = new JPanel();
		  mySelectPanel.setPreferredSize(new Dimension(400,300));
		  List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
			for(int x = 0; x < lines.size(); x++){
				mySelectPanel.add(new JLabel("Line: " + x + " | C1(x/y): " + (double)lines.get(x).x1/100 + "/" + (double)lines.get(x).y1/100 + " && C2(x/y): " + (double)lines.get(x).x2/100 + "/" + (double)lines.get(x).y2/100));
				JCheckBox lineCheckbox = new JCheckBox();
				lineCheckbox.setName("" + x);		
				checkBoxes.add(lineCheckbox);
				mySelectPanel.add(lineCheckbox);
			}			
			mySelectPanel.add(new JLabel(" "),"span, grow");
				while (true) {
					int result = JOptionPane.showConfirmDialog(null, mySelectPanel, "Select the line you want to edit",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_CANCEL_OPTION) {
						return;
					}
					if (result == JOptionPane.OK_OPTION) {
						for (JCheckBox checkBox : checkBoxes) {
							if (checkBox.isSelected()) {
								lines.remove(Integer.parseInt(checkBox.getName()));
							}
						}
						testFrame.repaint();
						return;
					}
				}

			}
		});
    
    addVectorButton.addActionListener(new ActionListener() { //adds 2 vectors to each other	
    	public void actionPerformed(ActionEvent e) {
		  JPanel mySelectPanel = new JPanel();
		  mySelectPanel.setPreferredSize(new Dimension(400,300));
		  List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
			for(int x = 0; x < lines.size(); x++){
				mySelectPanel.add(new JLabel("Line: " + x + " | C1(x/y): " + (double)lines.get(x).x1/100 + "/" + (double)lines.get(x).y1/100 + " && C2(x/y): " + (double)lines.get(x).x2/100 + "/" + (double)lines.get(x).y2/100));
				JCheckBox lineCheckbox = new JCheckBox();
				lineCheckbox.setName("" + x);		
				checkBoxes.add(lineCheckbox);
				mySelectPanel.add(lineCheckbox);
			}			
			mySelectPanel.add(new JLabel(" "),"span, grow");
				while (true) {
					int result = JOptionPane.showConfirmDialog(null, mySelectPanel, "Select the line you want to edit",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_CANCEL_OPTION) {
						return;
					}
					if (result == JOptionPane.OK_OPTION) {
						boolean foundLine1 = false;
						boolean foundLine2 = false;
						Line line1 = null;
						Line line2 = null;
						for (JCheckBox checkBox : checkBoxes) {
							if (checkBox.isSelected()) {
								// Do stuff
								if(!foundLine1){
									line1 = lines.get(Integer.parseInt(checkBox.getName()));
									foundLine1 = true;
								}
								else if(foundLine1 && !foundLine2){
									line2 = lines.get(Integer.parseInt(checkBox.getName()));
									foundLine2 = true;
								}
							}
							
						}
						if(foundLine1 && foundLine2){
							System.out.println("Line1: " + line1.x1 + " " + line1.y1 + " " + line1.x2 + " " + line1.y2);
							System.out.println("Line2: " + line2.x1 + " " + line2.y1 + " " + line2.x2 + " " + line2.y2);
							if(line1.x1 == line2.x1 && line1.y1 == line2.y1){
								System.out.println("Seems they are right!");
								int startx = line1.x2;
								int starty = line1.y2;
								int endx = line1.x2 + line2.x2;
								int endy = line1.y2 + line2.y2;								
								//Line linex = new Line(startx, starty, endx, endy, Color.black);
								//lines.add(linex);								
								Line liney = new Line(line1.x1, line1.y1, endx, endy, Color.RED);
								lines.add(liney);
								
								testFrame.repaint();
								return;
								
							}
						}
					}
				}

			}
		});

    
    clearButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            comp.clearLines();
        }
    });
    testFrame.pack();
    testFrame.setVisible(true);
    
}

	

}