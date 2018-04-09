package dev5.malei.carrent.utils;

import dev5.malei.carrent.entities.*;


import java.util.Date;
import java.util.List;

public class OutputUtil {

    public static void outputCars(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars!\n");
        } else {
            for (Car car : cars) {
                outputCar(car);
            }
        }
    }

    public static void outputCar(Car car) {
        if (car == null) {
            System.out.println("No Car!");
        } else {
            System.out.println(FormatterUtil.formatCar(car));
        }
    }

    public static void outputComments(List<Comment> comments) {
        if (comments.isEmpty()) {
            System.out.println("No comments!\n");
        } else {
            for (Comment comment : comments) {
                outputComment(comment);
            }
        }
    }

    public static void outputComment(Comment comment) {
        if (comment == null) {
            System.out.println("No comments!n");
        } else {
            System.out.println(FormatterUtil.formatComment(comment));
        }
    }

    public static void outputRatings(List<Rating> ratings) {
        if (ratings.isEmpty()) {
            System.out.println("No ratings!\n");
        } else {
            for (Rating rating : ratings) {
                outputRating(rating);
            }
        }
    }

    private static void outputRating(Rating rating) {
        if (rating == null) {
            System.out.println("No ratings!\n");
        } else {
            System.out.println(FormatterUtil.formatRating(rating));
        }
    }

    public static void outputDate(Date date, String pattern) {
        System.out.println(FormatterUtil.formatDate(date, pattern));
    }

    public static void outputLine(String line) {
        System.out.println(line);
    }


    public static void outputRentInfos(List<RentInfo> rentInfos) {
        if (rentInfos.isEmpty()) {
            System.out.println("No rent info at all!\n");
        } else {
            for (RentInfo rentInfo : rentInfos) {
                outputRentInfo(rentInfo);
            }
        }
    }

    private static void outputRentInfo(RentInfo rentInfo) {
        if (rentInfo == null) {
            System.out.println("No rent info!\n");
        } else {
            System.out.println(FormatterUtil.formatRentInfo(rentInfo));
        }
    }

    public static void outputBlockDetails(List<BlockDetails> blockDetailsList) {
        if (blockDetailsList.isEmpty()) {
            System.out.println("No block details at all!\n");
        } else {
            for (BlockDetails blockDetails : blockDetailsList) {
                outputBlockDetail(blockDetails);
            }
        }
    }

    private static void outputBlockDetail(BlockDetails blockDetails) {
        if (blockDetails == null) {
            System.out.println("No block details!\n");
        } else {
            System.out.println(FormatterUtil.formatBlockDetails(blockDetails));
        }
    }
}


