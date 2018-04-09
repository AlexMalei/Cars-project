package dev5.malei.carrent;

import dev5.malei.carrent.daoImpl.CrudDAOImpl;
import dev5.malei.carrent.entities.Role;
import dev5.malei.carrent.utils.InputUtil;
import dev5.malei.carrent.utils.OutputUtil;


public class ConsoleMain {
    public static void main(String[] args) {
        initializeAfterStart();

        Role role = null;
        int action = 0;
        do {
            OutputUtil.outputLine("Choose type of User:\n 1 - Guest\n 2 - User\n 3 - Admin\n 0 - Close app");
            try {
                action = InputUtil.inputNumber();
                switch (action) {
                    case 1:
                        role = Role.GUEST;
                        break;
                    case 2:
                        role = Role.USER;
                        break;
                    case 3:
                        role = Role.ADMIN;
                        break;
                    case 0:
                        break;
                    default:
                        OutputUtil.outputLine("Invalid number, try again\n");
                }
                if (action >= 1 && action <= 3) {
                    DialogMaker dialogMaker = new DialogMaker(role);
                    dialogMaker.makeDialog();
                }
            } catch (NumberFormatException e) {
                OutputUtil.outputLine("Invalid input, try again\n");
            }

        } while (action != 0);


        saveOnClose();
    }

    private static void initializeAfterStart() {
        String pathToDBFile = getPathToDBFile();
        CrudDAOImpl.deserializeEntities(pathToDBFile);
    }

    private static void saveOnClose() {
        String pathToDBFile = getPathToDBFile();
        CrudDAOImpl.serializeEntities(pathToDBFile);
    }

    private static String getPathToDBFile() {
        PropertyReader propertyReader = new PropertyReader();
        return propertyReader.getProperty("dbFile.path");
    }
}
