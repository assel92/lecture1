package controllers;
import Entites.Phone;
import repositories.interfaces.PhRepos;
import java.util.List;

public class PhoneControllers {
    private final PhRepos repos;
    public PhoneControllers(PhRepos repos){
        this.repos=repos;
    }
    public String addPhone(int id, int number, float price,String brand, String OS, int storage){
        Phone phone = new Phone(id, number, price, brand, OS, storage);
        boolean result = repos.addPhone(phone);
        return (result ? "Phone was added" : "Phone was not added");
    }
    public String getPhone(int id){
        Phone phone = repos.getPhone(id);
        return (phone==null ? "Phone was not found" : phone.toString());
    }
    public String getAllPhones(){
        List<Phone> phones=repos.getAllPhones();
        return phones.toString();}

    public String deletePhone(int id){
        Phone phone = repos.getPhone(id);
        return (phone==null ? "Phone was not found" : "Phone was deleted");
    }
    public String updatePhoneBrand(int id, String newBrand) {
        boolean updated = repos.updatePhoneBrand(id, newBrand);

        if (updated) {
            return "Brand updated successfully";
        } else {
            return "Phone not found";
        }
    }


}
