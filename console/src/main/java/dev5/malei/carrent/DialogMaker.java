package dev5.malei.carrent;

import dev5.malei.carrent.entities.Role;
import dev5.malei.carrent.states.AdminDialog;
import dev5.malei.carrent.states.Dialog;
import dev5.malei.carrent.states.GuestDialog;
import dev5.malei.carrent.states.UserDialog;

public class DialogMaker {
    private Dialog dialog;

    public DialogMaker(Role role) {
        switch (role){
            case GUEST:
                dialog = new GuestDialog();
                break;
            case USER:
                dialog = new UserDialog();
                break;
            case ADMIN:
                dialog = new AdminDialog();
        }
    }

    public void makeDialog(){
        dialog.makeDialog();
    }


}
