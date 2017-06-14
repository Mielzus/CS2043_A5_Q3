import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 * Created by Jason on 2017-06-13.
 */

public class PhonebookView implements ActionListener {

    private Frame f;
    private TextField tName;
    private TextField tPhone;
    private Button bAdd;
    private Button bSearch;
    private Button bSearchName;
    private Button bSearchPhone;

    private PhonebookController phonebookController;

    public PhonebookView(PhonebookController pController) {
        phonebookController = pController;
    }

    public void createGui() {
        f = new Frame();
        f.setTitle("Phonebook - Add entry or search for phone or name");
        f.setSize(750,70); // default size is 0,0
        f.setLocation(10,200); // default is 0,0 (top left corner)
        // Window Listeners
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            } //windowClosing
        } );
        f.setLayout(new FlowLayout());
        Label lName = new Label("Name:");
        tName = new TextField(20);
        Label lPhone = new Label("Phone:");
        tPhone = new TextField(20);
        bAdd = new Button("Add Entry");
        bAdd.setActionCommand("add");
        bAdd.addActionListener(this);

        bSearchName = new Button("Search Name");
        bSearchName.setActionCommand("searchName");
        bSearchName.addActionListener(this);

        bSearchPhone = new Button("Search Phone");
        bSearchPhone.setActionCommand("searchPhone");
        bSearchPhone.addActionListener(this);

        f.add(lName);
        f.add(tName);
        f.add(lPhone);
        f.add(tPhone);
        f.add(bAdd);
        f.add(bSearchName);
        f.add(bSearchPhone);
        f.setVisible(true);
    }

    public String getInputName() {
        return tName.getText();
    }

    public String getInputPhone() {
        return tPhone.getText();
    }

    public void showAddSuccess() {
        JOptionPane.showMessageDialog(null, "Added entry with Name = "
                + getInputName() + " and Phone = " + getInputPhone());
    }

    public void showSearchResults(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void getUserInput(String command) {
        phonebookController.userInput(command);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getUserInput(e.getActionCommand());
    }
}

