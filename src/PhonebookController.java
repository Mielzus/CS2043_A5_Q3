/**
 * Created by Jason on 2017-06-13.
 */

public class PhonebookController {

    private PhonebookModel phonebookModel;

    private PhonebookView phonebookView;

    public PhonebookController() {
        phonebookModel = new PhonebookModel();
    }

    public void userInput(String command) {
        if(command.equals("add")) {
            phonebookModel.AddEntry(phonebookView.getInputName(), phonebookView.getInputPhone());
            phonebookView.showAddSuccess();
        }
        else if(command.equals("searchName")) {
            phonebookView.showSearchResults("Phone for person with Name = " + phonebookView.getInputName() + " is "
                    + phonebookModel.searchName(phonebookView.getInputName()));
        }
        else if(command.equals("searchPhone")) {
            phonebookView.showSearchResults("Name for person with Phone = " + phonebookView.getInputPhone() + " is "
                                            + phonebookModel.searchPhone(phonebookView.getInputPhone()));
        }
    }

    public void setView(PhonebookView pView) {
        phonebookView = pView;
    }

    public static void main(String[] args)
    {
        PhonebookController controller = new PhonebookController();
        PhonebookView view = new PhonebookView(controller);
        controller.setView(view);
        view.createGui();
    }
}
