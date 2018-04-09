package dev5.malei.carrent.states;

import dev5.malei.carrent.entities.*;
import dev5.malei.carrent.services.*;
import dev5.malei.carrent.utils.InputUtil;
import dev5.malei.carrent.utils.OutputUtil;



public class AdminDialog implements Dialog {

    private CarService carService = new CarServiceImpl();
    private RentInfoService rentInfoService = new RentInfoServiceImpl();
    private BlockDetailsService blockDetailsService = new BlockDetailsServiceImpl();

    public void makeDialog() {
        Car car;
        int commandNumber;
        boolean isEnd = false;
        do {
            OutputUtil.outputLine("Choose action:\n 1 - add new car \n 2 - remove car\n 3 - edit car \n 4 - confirm an order for rent\n " +
                    "5 - block user with comment \n 6 - list cars\n 7 - list rent info\n 8 - list block details 0 - change role");
            try {
                commandNumber = InputUtil.inputNumber();
                switch (commandNumber) {
                    case 1:
                        car = new Car();
                        car.setEngineCapacity(100);
                        car.setBodyType(BodyType.SEDAN);
                        car.setCarType(CarType.PASSENGER);
                        car.setEngineType(EngineType.GASOLINE); //TODO( INPUT VALUES)
                        car.setModel("CAR MODEL");
                        car.setReleaseYear(2006);
                        car.setRentCost(1000);
                        carService.add(car);
                        break;
                    case 2:
                        carService.delete(InputUtil.inputCarId());
                        break;
                    case 3:
                        car = carService.get(InputUtil.inputCarId());
                        car.setRentCost(car.getRentCost() + 1);         //TODO(INPUT VALUES)
                        car.setReleaseYear(car.getReleaseYear() + 1);
                        car.setModel(car.getModel() + "1");
                        carService.update(car);
                        break;
                    case 4:
                        RentInfo rentInfo = rentInfoService.get(InputUtil.inputRentInfoId());
                        rentInfo.setConfirmed(true);
                        rentInfoService.update(rentInfo);
                        break;
                    case 5:
                        blockDetailsService.blockUser(InputUtil.inputUserId(), InputUtil.inputComment());
                        break;
                    case 6:
                        OutputUtil.outputCars(carService.list());
                        break;
                    case 7:
                        OutputUtil.outputRentInfos(rentInfoService.list());
                        break;
                    case 8:
                        OutputUtil.outputBlockDetails(blockDetailsService.list());
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
