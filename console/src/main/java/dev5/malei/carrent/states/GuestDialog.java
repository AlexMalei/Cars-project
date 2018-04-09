package dev5.malei.carrent.states;

import dev5.malei.carrent.entities.*;
import dev5.malei.carrent.filters.*;
import dev5.malei.carrent.services.CarService;
import dev5.malei.carrent.services.CarServiceImpl;
import dev5.malei.carrent.services.RentInfoService;
import dev5.malei.carrent.services.RentInfoServiceImpl;
import dev5.malei.carrent.utils.FilterListCreatorUtil;
import dev5.malei.carrent.utils.InputUtil;
import dev5.malei.carrent.utils.OutputUtil;
import java.util.*;

public class GuestDialog implements Dialog {

    private CarService carService = new CarServiceImpl();
    private RentInfoService rentInfoService = new RentInfoServiceImpl();

    public void makeDialog() {
        int commandNumber;
        boolean isEnd = false;
        do {
            OutputUtil.outputLine("Choose action:\n 1 - watch list unrented cars\n 2 - watch info of concrete car\n 3 - watch all cars\n 4 - filter cars by characteristics\n " +
                    "5 - watch info about end of rental date\n 0 - change role");
            try {
                commandNumber = InputUtil.inputNumber();
                switch (commandNumber) {
                    case 1:
                        OutputUtil.outputCars(carService.getUnrentedCars());
                        break;
                    case 2:
                        Car car = carService.get(InputUtil.inputCarId());
                        OutputUtil.outputCar(car);
                        break;
                    case 3:
                        OutputUtil.outputCars(carService.list());
                        break;
                    case 4:
                        OutputUtil.outputCars(carService.filter(FilterListCreatorUtil.createFilters()));
                        break;
                    case 5:
                        OutputUtil.outputDate(rentInfoService.getEndRentDate(InputUtil.inputCarId()), "yyyy.MM.dd HH:mm:ss");
                        break;
                    case 0:
                        isEnd = true;
                        break;
                    default:
                        OutputUtil.outputLine("Invalid number, try again\n");
                }
            } catch (NumberFormatException e) {
                OutputUtil.outputLine("Invalid number input, try again");
            }

        } while (!isEnd);

    }

}
