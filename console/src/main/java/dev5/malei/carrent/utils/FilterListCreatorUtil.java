package dev5.malei.carrent.utils;

import dev5.malei.carrent.entities.BodyType;
import dev5.malei.carrent.entities.CarType;
import dev5.malei.carrent.entities.EngineType;
import dev5.malei.carrent.filters.*;
import dev5.malei.carrent.services.filters.CarFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterListCreatorUtil {
    public static List<CarFilter> createFilters() {
        List<CarFilter> filters = new ArrayList<>();
        OutputUtil.outputLine("Input car type (p - Passenger, f - Freight) or '-' if this parameter unnessesary");

        boolean isCorrect;
        do {
            isCorrect = true;
            switch (InputUtil.inputLine().toUpperCase().charAt(0)) {
                case 'P':
                    filters.add(new CarTypeFilter(CarType.PASSENGER));
                    break;
                case 'F':
                    filters.add(new CarTypeFilter(CarType.FREIGHT));
                    break;
                case '-':
                    break;
                default:
                    OutputUtil.outputLine("Invalid input of car type, try again!");
                    isCorrect = false;
            }
        } while (!isCorrect);

        OutputUtil.outputLine("Input body type (s - sedan, c - crossover, h - hatchback  , t - truck) or '-' if this parameter unnessesary");

        do {
            isCorrect = true;
            switch (InputUtil.inputLine().toUpperCase().charAt(0)) {
                case 'S':
                    filters.add(new BodyTypeFilter(BodyType.SEDAN));
                    break;
                case 'C':
                    filters.add(new BodyTypeFilter(BodyType.CROSSOVER));
                    break;
                case 'H':
                    filters.add(new BodyTypeFilter(BodyType.HATCHBACK));
                    break;
                case 'T':
                    filters.add(new BodyTypeFilter(BodyType.TRUCK));
                    break;
                case '-':
                    break;
                default:
                    OutputUtil.outputLine("Invalid input of body type, try again!");
                    isCorrect = false;
            }
        } while (!isCorrect);

        OutputUtil.outputLine("Input engine type (g - gasoline, d - diesel) or '-' if this parameter unnessesary");

        do {
            isCorrect = true;
            switch (InputUtil.inputLine().toUpperCase().charAt(0)) {
                case 'G':
                    filters.add(new EngineTypeFilter(EngineType.GASOLINE));
                    break;
                case 'D':
                    filters.add(new EngineTypeFilter(EngineType.DIESEL));
                    break;
                case '-':
                    break;
                default:
                    OutputUtil.outputLine("Invalid input of engine type, try again!");
                    isCorrect = false;
            }
        } while (!isCorrect);

        OutputUtil.outputLine("Input RENT COST like this: '- -' if filter unnessesary, 'number -' if nessesary lower border, '- number' if nessesary upper border, 'number number' if nessesary both borders");

        Integer[] params = parseParamString(InputUtil.inputLine());
        if (params[0] != null || params[1] != null) {
            filters.add(new RentCostFilter(params[0], params[1]));
        }

        OutputUtil.outputLine("Input ENGINE CAPACITY like this: '- -' if filter unnessesary, 'number -' if nessesary lower border, '- number' if nessesary upper border, 'number number' if nessesary both borders");

        params = parseParamString(InputUtil.inputLine());
        if (params[0] != null || params[1] != null) {
            filters.add(new EngineCapacityFilter(params[0], params[1]));
        }

        OutputUtil.outputLine("Input RELEASE YEAR like this: '- -' if filter unnessesary, 'number -' if nessesary lower border, '- number' if nessesary upper border, 'number number' if nessesary both borders");
        params = parseParamString(InputUtil.inputLine());
        if (params[0] != null || params[1] != null) {
            filters.add(new ReleaseYearFilter(params[0], params[1]));
        }

        return filters;
    }

    private static Integer[] parseParamString(String paramString){
        Integer[] ints = new Integer[2];
        String[] substrings = paramString.trim().split(" ");
        try {
            ints[0] = Integer.parseInt(substrings[0]);
        } catch (NumberFormatException e) { /*NOP*/}
        try {
            ints[1] = Integer.parseInt(substrings[1]);
        } catch (NumberFormatException e) { /*NOP*/}

        return ints;
    }
}
