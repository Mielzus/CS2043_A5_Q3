/**
 * Created by Jason on 2017-06-13.
 */

public class PhonebookModel {

    private PairStore table;

    public PhonebookModel() {
        table = new PairStore();
    }

    public void AddEntry(String name, String phone) {
        table.put(name, phone);
    }

    public String searchName(String name) {
        return table.get(name, null);
    }

    public String searchPhone(String phone) {
        return table.get(null, phone);
    }
}
