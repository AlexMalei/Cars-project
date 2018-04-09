package dev5.malei.carrent.utils;

import dev5.malei.carrent.entities.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatterUtil {
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return null ;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        }
    }

    public static String formatCar(Car car){
        return String.format(" Car ID: %s\n Car type: %s\n Rent cost: %s\n Body type:%s\n Engine capacity: %s\n Engine type: %s\n Release year: %s\n Model:%s\n\n",
                car.getId(), car.getCarType().name(), car.getRentCost(), car.getBodyType().name(), car.getEngineCapacity(), car.getEngineType().name(), car.getReleaseYear(), car.getModel());
    }

    public static String formatComment(Comment comment) {
        return String.format("Comment ID: %s\n Car Id: %s\n User ID: %s\n Text: %s\n Date: %s",
                comment.getId(), comment.getCarId(), comment.getUserId(), comment.getText(), formatDate(comment.getDate(), "yyyy.MM.dd HH:mm:ss"));
    }

    public static String formatRating(Rating rating) {
        return String.format("Rating ID: %s\n Car Id: %s\n User ID: %s\n Count stars: %s\n ",
                rating.getId(), rating.getCarId(), rating.getUserId(), rating.getCountStars());
    }

    public static String formatRentInfo(RentInfo rentInfo) {
        return String.format("Rating ID: %s\n Car Id: %s\n User ID: %s\n Date from: %s\n Date to: %s\n ",
                rentInfo.getId(), rentInfo.getCarId(), rentInfo.getUserId(), formatDate(rentInfo.getDateFrom(), "yyyy.MM.dd HH:mm:ss"), formatDate(rentInfo.getDateTo(), "yyyy.MM.dd HH:mm:ss"));
    }

    public static String formatBlockDetails(BlockDetails blockDetails) {
        return String.format("Rating ID: %s\n User ID: %s\n  Comment: %s\n ",
                blockDetails.getId(), blockDetails.getUserId(), blockDetails.getComment());
    }
}
