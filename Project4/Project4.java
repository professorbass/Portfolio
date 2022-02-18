

import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Main class
public class Project4 {

    //instance of TreeMap for database
    private TreeMap<String, Property> database;
    //frame for components
    private JFrame frame;
    //labels
    private JLabel lblTransNo, lblAddress,
            lblBedrooms, lblSqFt, lblPrice;
    //text fields
    private JTextField txtTransNo, txtAddress,
            txtBedrooms, txtSqFt, txtPrice;
    //buttons
    private JButton btnProcess, btnChangeSt;
    //combo boxes
    private JComboBox cmbOper, cmbStatus;

    //constructor of the main class
    public Project4() {
        //initializing the database
        database = new TreeMap<>();
        //creating a frame
        frame = new JFrame("Real Estate Database");
        frame.setBounds(600, 200, 350, 350);
        frame.setLayout(new GridLayout(7, 2, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initializing the components
        lblTransNo = new JLabel("Transaction No: ");
        txtTransNo = new JTextField();
        //adding listener for text field
        txtTransNo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //if the typed key is not a digit
                if (!Character.isDigit(e.getKeyChar())) {
                    //event consumed
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //if the typed key is not a digit, Backspace and Enter
                if (!Character.isDigit(e.getKeyChar())
                        && !(e.getKeyCode() == 10 || e.getKeyCode() == 8)) {
                    //show error message
                    JOptionPane.showMessageDialog(frame, "Enter digits only.",
                            "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //adding components in the frame
        frame.add(lblTransNo);
        frame.add(txtTransNo);

        lblAddress = new JLabel("Address: ");
        txtAddress = new JTextField();
        //adding components in the frame
        frame.add(lblAddress);
        frame.add(txtAddress);

        lblBedrooms = new JLabel("Bedrooms: ");
        txtBedrooms = new JTextField();
        txtBedrooms.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //if the typed key is not a digit
                if (!Character.isDigit(e.getKeyChar())) {
                    //event consumed
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //if the typed key is not a digit, Backspace and Enter
                if (!Character.isDigit(e.getKeyChar())
                        && !(e.getKeyCode() == 10 || e.getKeyCode() == 8)) {
                    //show error message
                    JOptionPane.showMessageDialog(frame, "Enter digits only.",
                            "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //adding components in the frame
        frame.add(lblBedrooms);
        frame.add(txtBedrooms);

        lblSqFt = new JLabel("Square Footage: ");
        txtSqFt = new JTextField();
        txtSqFt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //if the typed key is not a digit
                if (!Character.isDigit(e.getKeyChar())) {
                    //event consumed
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //if the typed key is not a digit, Backspace and Enter
                if (!Character.isDigit(e.getKeyChar())
                        && !(e.getKeyCode() == 10 || e.getKeyCode() == 8)) {
                    //show error message
                    JOptionPane.showMessageDialog(frame, "Enter digits only.",
                            "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //adding components in the frame
        frame.add(lblSqFt);
        frame.add(txtSqFt);

        lblPrice = new JLabel("Price: ");
        txtPrice = new JTextField();
        txtPrice.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //if the typed key is not a digit
                if (!Character.isDigit(e.getKeyChar())) {
                    //event consumed
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //if the typed key is not a digit, Backspace and Enter
                if (!Character.isDigit(e.getKeyChar())
                        && !(e.getKeyCode() == 10 || e.getKeyCode() == 8)) {
                    //show error message
                    JOptionPane.showMessageDialog(frame, "Enter digits only.",
                            "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //adding components in the frame
        frame.add(lblPrice);
        frame.add(txtPrice);

        btnProcess = new JButton("Process");
        cmbOper = new JComboBox(new String[]{"Insert", "Find", "Delete"});
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //local variables to hold the data
                String transNo, address, bedrooms, sqFt, price;
                //to identify the database operation
                switch (cmbOper.getSelectedIndex()) {
                    case 0:
                        //getting the data from the fields
                        transNo = txtTransNo.getText();
                        address = txtAddress.getText();
                        bedrooms = txtBedrooms.getText();
                        sqFt = txtSqFt.getText();
                        price = txtPrice.getText();
                        //checking the if data is valid
                        if (transNo.trim().length() > 0 && address.trim().length() > 0
                                && bedrooms.trim().length() > 0 && sqFt.trim().length() > 0
                                && price.trim().length() > 0) {
                            //if the key already exists in the database
                            if (database.containsKey(transNo)) {
                                //show error message
                                JOptionPane.showMessageDialog(frame, "Transaction number already exists.",
                                        "Duplicate key", JOptionPane.ERROR_MESSAGE);
                            } else {
                                //adding the property in the database
                                database.put(transNo, new Property(address, Integer.parseInt(bedrooms),
                                        Integer.parseInt(sqFt), Integer.parseInt(price)));
                                //show success message
                                JOptionPane.showMessageDialog(frame, "Property added successfully.",
                                        "Success", JOptionPane.PLAIN_MESSAGE);
                                //clearing the fields
                                txtTransNo.setText("");
                                txtAddress.setText("");
                                txtBedrooms.setText("");
                                txtSqFt.setText("");
                                txtPrice.setText("");
                            }
                        } else {
                            //show error message
                            JOptionPane.showMessageDialog(frame, "Fill all the fields.",
                                    "Fields incomplete", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        transNo = txtTransNo.getText();
                        if (transNo.trim().length() > 0) {
                            //getting the property from the database
                            Property property = database.get(transNo);
                            //if the property does not exist in the database
                            if (property == null) {
                                //show error message
                                JOptionPane.showMessageDialog(frame, "Property not found.",
                                        "Not found", JOptionPane.ERROR_MESSAGE);
                            } else {
                                //show the info of property
                                JOptionPane.showMessageDialog(frame, property.toString(),
                                        "Property found", JOptionPane.INFORMATION_MESSAGE);
                                txtTransNo.setText("");
                            }
                        } else {
                            //show error message
                            JOptionPane.showMessageDialog(frame, "Enter transaction no",
                                    "Field incomplete", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    default:
                        transNo = txtTransNo.getText();
                        if (transNo.trim().length() > 0) {
                            //removing and getting the property
                            Property property = database.remove(transNo);
                            //if the property does not exist in the database
                            if (property == null) {
                                //show error message
                                JOptionPane.showMessageDialog(frame, "Property not found.",
                                        "Not found", JOptionPane.ERROR_MESSAGE);
                            } else {
                                //show success message
                                JOptionPane.showMessageDialog(frame, "Property deleted successfully.",
                                        "Deleted", JOptionPane.PLAIN_MESSAGE);
                                txtTransNo.setText("");
                            }
                        } else {
                            //show error message
                            JOptionPane.showMessageDialog(frame, "Enter transaction no",
                                    "Field incomplete", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
            }
        });
        //adding components in the frame
        frame.add(btnProcess);
        frame.add(cmbOper);

        btnChangeSt = new JButton("Change Status");
        cmbStatus = new JComboBox(new String[]{"FOR_SALE", "UNDER_CONTRACT", "SOLD"});
        btnChangeSt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getting transaction number from the text field
                String transNo = txtTransNo.getText();
                //checking if the number is not empty
                if (transNo.trim().length() > 0) {
                    //getting the property
                    Property property = database.get(transNo);
                    //if the property does not exist
                    if (property == null) {
                        //show error message
                        JOptionPane.showMessageDialog(frame, "Property not found.",
                                "Not found", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //to identify the status
                        switch (cmbStatus.getSelectedIndex()) {
                            //set status according the selected value
                            case 0:
                                property.changeState(Status.FOR_SALE);
                                break;
                            case 1:
                                property.changeState(Status.UNDER_CONTRACT);
                                break;
                            default:
                                property.changeState(Status.SOLD);
                                break;
                        }
                        //updating the property
                        database.replace(transNo, property);
                        //show success message
                        JOptionPane.showMessageDialog(frame, "Status changed successfully.",
                                "Success", JOptionPane.PLAIN_MESSAGE);
                        //clearing the text field
                        txtTransNo.setText("");
                    }
                } else {
                    //show error message
                    JOptionPane.showMessageDialog(frame, "Enter transaction no",
                            "Field incomplete", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //adding components in the frame
        frame.add(btnChangeSt);
        frame.add(cmbStatus);
        
        //making the frame visible on the screen
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //calling the constructor to show the GUI
        new Project4();
    }
}
