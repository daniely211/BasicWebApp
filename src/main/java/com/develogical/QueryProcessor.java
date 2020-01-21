package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        String[] splitString = query.split(":");
        if (splitString.length > 1) {
            switch(splitString[1]) {
                case " what is your team name":
                    return "Team Golf";
                default:
                    return "Team Golf";
            }
        }

        return "";
    }
}
