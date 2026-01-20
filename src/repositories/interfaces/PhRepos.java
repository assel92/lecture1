package repositories.interfaces;
import Entites.Phone;
import java.util.List;

public interface PhRepos {
    boolean addPhone(Phone phone);
    Phone getPhone(int id);
    List<Phone> getAllPhones();
    boolean deletePhone(int id);
}

