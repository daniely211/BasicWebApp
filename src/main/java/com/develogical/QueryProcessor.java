package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        String[] splitString = query.split(": ");
        if (splitString.length > 1) {
            switch(splitString[1]) {
                case "what is your team name":
                    return "Team Golf";
                case "which of the following numbers is the largest":
                    if (splitString.length > 2) {
                        String numbers = splitString[2];
                        String[] numStrings = numbers.split(",");
                        int max = 0;
                        for(int i = 0; i < numStrings.length; i++) {
                            max = Math.max(max, Integer.parseInt(numStrings[i]));
                        }
                        return String.valueOf(max);
                    }
                default:
                    return "Team Golf";
            }

//            %20which%20of%20the%20following%20numbers%20is%20the%20largest:%2042,%2067,%2030,%20614
        }

        return "";
    }
}
