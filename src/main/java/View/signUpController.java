package View;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class signUpController extends generalController {

    //public javafx.scene.control.Label txtfld_usrIsAlreadyExists;


    public void SignUp(javafx.event.ActionEvent event)  throws IOException {
        String[] checkUserTaken = controller.ReadUser(txtfld_userName.getText());

        if(datefld_userBirthday.getValue() == null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse("2000-01-01", formatter);
            datefld_userBirthday.setValue(localDate);
        }

        if(checkUserTaken.length ==1){
            boolean[] checkFields = controller.CreateNewUser(txtfld_userName.getText(),txtfld_userPassword.getText(),datefld_userBirthday.getValue().toString(), txtfld_userFirstName.getText(),txtfld_userLastName.getText(), txtfld_userCity.getText());
            txtfld_userName.setStyle("");
            txtfld_userPassword.setStyle("");
            datefld_userBirthday.setStyle("");
            txtfld_userFirstName.setStyle("");
            txtfld_userLastName.setStyle("");
            txtfld_userCity.setStyle("");

            checkUserParams(event, checkFields);

        }
        else{
            txtfld_usrIsntExists.setVisible(true);
        }
    }
}
