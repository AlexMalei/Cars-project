package dev5.malei.carrent.states;

import dev5.malei.carrent.entities.Car;
import dev5.malei.carrent.entities.Comment;
import dev5.malei.carrent.entities.Rating;
import dev5.malei.carrent.entities.RentInfo;
import dev5.malei.carrent.services.filters.CarFilter;
import dev5.malei.carrent.services.*;
import dev5.malei.carrent.utils.FilterListCreatorUtil;
import dev5.malei.carrent.utils.InputUtil;
import dev5.malei.carrent.utils.OutputUtil;

import java.util.Date;
import java.util.List;


public class UserDialog implements Dialog {

    private CarService carService = new CarServiceImpl();
    private RentInfoService rentInfoService = new RentInfoServiceImpl();
    private RatingService ratingService = new RatingServiceImpl();
    private CommentService commentService = new CommentServiceImpl();

    public void makeDialog() {
        int commandNumber;
        boolean isEnd = false;
        do {
            OutputUtil.outputLine("Choose action:\n 1 - watch list unrented cars\n 2 - watch info of concrete car\n 3 - watch all cars\n 4 - filter cars by characteristics\n " +
                    "5 - watch info about end of rental date\n 6 - leave rating\n 7 - leave comment\n 8 - watch comments by user\n 9 - watch rating by user\n 10 - watch comments on car\n 11 - watch rating on car\n" +
                    " 12 - rent car\n 0 - change role");
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
                    case 6:
                        Rating rating = new Rating();
                        rating.setCarId(InputUtil.inputCarId());
                        rating.setUserId(InputUtil.inputUserId());
                        rating.setCountStars(InputUtil.inputCountStars());
                        ratingService.add(rating);
                        break;
                    case 7:
                        Comment comment = new Comment();
                        comment.setUserId(InputUtil.inputUserId());
                        comment.setDate(new Date());
                        comment.setCarId(InputUtil.inputCarId());
                        comment.setText(InputUtil.inputComment());
                        commentService.add(comment);
                        break;
                    case 8:
                        OutputUtil.outputComments(commentService.getCommentsByUser(InputUtil.inputUserId()));
                        break;
                    case 9:
                        OutputUtil.outputRatings(ratingService.getRatingByUser(InputUtil.inputUserId()));
                        break;
                    case 10:
                        OutputUtil.outputComments(commentService.getCommentsByCar(InputUtil.inputCarId()));
                        break;
                    case 11:
                        OutputUtil.outputRatings(ratingService.getRatingByCar(InputUtil.inputCarId()));
                        break;
                    case 12:
                        int carId = InputUtil.inputCarId();
                        if (rentInfoService.isRentAvailable(carId)) {
                            RentInfo rentInfo = new RentInfo();
                            rentInfo.setDateFrom(new Date());
                            rentInfo.setDateTo(new Date(new Date().getTime() + 100000L)); //TODO(INPUT DATE)
                            rentInfo.setConfirmed(false);
                            rentInfo.setCarId(carId);
                            rentInfo.setUserId(InputUtil.inputUserId());
                            rentInfoService.add(rentInfo);
                        } break;
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
