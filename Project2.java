import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Project2 {

	private JFrame frame;
	private JTextField makemodel;
	private JTextField sprice;
	private JTextField mpg;
	private JTextField weight;
	private JTextField salesTax;
	
	int count=0;
	ArrayList<Automobile> list_auto=new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project2 window = new Project2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Automobile Sales Tax Calculator");
		frame.setBounds(100, 100, 652, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Make and Model");
		lblNewLabel.setBounds(128, 39, 96, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Sales Price");
		label.setBounds(128, 64, 96, 14);
		frame.getContentPane().add(label);
		
		makemodel = new JTextField();
		makemodel.setBounds(234, 36, 86, 20);
		frame.getContentPane().add(makemodel);
		makemodel.setColumns(10);
		
		sprice = new JTextField();
		sprice.setBounds(234, 61, 86, 20);
		frame.getContentPane().add(sprice);
		sprice.setColumns(10);
		
		JLabel label_1 = new JLabel("Automobile Type");
		label_1.setBounds(58, 107, 96, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Miles Per Gallon");
		label_2.setBounds(215, 137, 96, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Weight in Pounds");
		label_3.setBounds(215, 173, 96, 14);
		frame.getContentPane().add(label_3);
		
		mpg = new JTextField();
		mpg.setBounds(318, 134, 86, 20);
		frame.getContentPane().add(mpg);
		mpg.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(321, 170, 86, 20);
		frame.getContentPane().add(weight);
		weight.setColumns(10);
		
		
		
		JRadioButton hybrid = new JRadioButton("Hybrid");
		hybrid.setBounds(45, 137, 109, 23);
		frame.getContentPane().add(hybrid);
		
		
		
		JRadioButton electric = new JRadioButton("Electric");
		electric.setBounds(45, 163, 109, 23);
		frame.getContentPane().add(electric);
		
		JRadioButton other = new JRadioButton("Other");
		other.setBounds(45, 189, 109, 23);
		frame.getContentPane().add(other);
		
		JButton btnNewButton = new JButton("Compute Sales Tax");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(sprice.getText().matches("[0-9]+") && sprice.getText().length() > 2)) {
					JOptionPane.showMessageDialog(frame,"Sales price must contain only numbers.");
					return;
				}
				
				if(hybrid.isSelected()) {
					
					if(!(mpg.getText().matches("[0-9]+") && mpg.getText().length() > 2)) {
						JOptionPane.showMessageDialog(frame,"MPG must contain only numbers.");
						return;
					}
					
					Hybrid auto=new Hybrid(makemodel.getText(), Double.parseDouble(sprice.getText()), Integer.parseInt(mpg.getText()));
					list_auto.add(auto);
					salesTax.setText(String.valueOf(auto.salesTax()));
				}
				else if(electric.isSelected()) {
					if(!(weight.getText().matches("[0-9]+") && weight.getText().length() > 2)) {
						JOptionPane.showMessageDialog(frame,"Weight must contain only numbers.");
						return;
					}
					Electric auto=new Electric(makemodel.getText(), Double.parseDouble(sprice.getText()), Integer.parseInt(weight.getText()));
					list_auto.add(auto);
					salesTax.setText(String.valueOf(auto.salesTax()));
				}
				else if(other.isSelected()) {
					Automobile auto=new Automobile(makemodel.getText(), Double.parseDouble(sprice.getText()));
					list_auto.add(auto);
					salesTax.setText(String.valueOf(auto.salesTax()));
				}
			}
		});
		btnNewButton.setBounds(74, 246, 131, 23);
		frame.getContentPane().add(btnNewButton);
		
		salesTax = new JTextField();
		salesTax.setBounds(252, 247, 86, 20);
		salesTax.setEditable(false);
		frame.getContentPane().add(salesTax);
		salesTax.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Clear Fields");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makemodel.setText("");
				sprice.setText("");
				weight.setText("");
				
				mpg.setText("");
				salesTax.setText("");
				
			}
		});
		btnNewButton_1.setBounds(75, 292, 130, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("Display Reports");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(list_auto.size()<5) {
					for(int i=0;i<list_auto.size();++i) {
						System.out.print(list_auto.get(i).toString());
						System.out.print("\n");
					}
				}
				else {
					for(int i=list_auto.size()-5;i<list_auto.size();++i) {
						System.out.print(list_auto.get(i).toString());
						System.out.print("\n");
					}
				}
				
			}
		});
		button.setBounds(249, 292, 130, 23);
		frame.getContentPane().add(button);
	}
}
