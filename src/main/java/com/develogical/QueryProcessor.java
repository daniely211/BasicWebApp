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
            String first = splitString[1];
            if (first.startsWith("what is")) {
                String[] split2 = first.split(" ");
                String num1 = split2[2];
                String op = split2[3];
                switch (op) {
                    case "multiplied":
                        String num2 = split2[5];
                        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
                    case "plus":
                        String num3 = split2[4];
                        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num3));
                    case "minus":
                        String num4 = split2[4];
                        return String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num4));
                }

            }

            switch(splitString[1]) {
                case "what is your team name":
                    return "Team Golf";
                case "which of the following numbers is the largest":
                    if (splitString.length > 2) {
                        String numbers = splitString[2];
                        String[] numStrings = numbers.split(", ");
                        int max = 0;
                        for(int i = 0; i < numStrings.length; i++) {
                            max = Math.max(max, Integer.parseInt(numStrings[i]));
                        }
                        return String.valueOf(max);
                    }
                case "which of the following numbers is both a square and a cube":
                    if (splitString.length > 2) {
                        String numbers = splitString[2];
                        String[] numStrings = numbers.split(", ");
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("[");
                        for(int i = 0; i < numStrings.length; i++) {
                            int cur = Integer.parseInt(numStrings[i]);
                            double sqreRoot = Math.sqrt(cur); // get the cube root
                            if (Math.round(sqreRoot) == sqreRoot) {
                                double cubeRoot = Math.cbrt(cur); // get the cube root
                                if (Math.round(cubeRoot) == cubeRoot) {
                                    stringBuilder.append(numStrings[i]);
                                    stringBuilder.append(", ");
                                }
                            }
                        }
                        return stringBuilder.toString() + "]";
                    }

                default:
                    return "Team Golf";
            }
//            which%20year%20was%20Theresa%20May%20first%20elected%20as%20the%20Prime%20Minister%20of%20Great%20Britain
//            %20which%20of%20the%20following%20numbers%20are%20primes:%20692,%20449
//            %20who%20played%20James%20Bond%20in%20the%20film%20Dr%20No
//            %20which%20of%20the%20following%20numbers%20is%20both%20a%20square%20and%20a%20cube:%20841,%20912
//            what%20is%204%20multiplied%20by%2014
//            %20what%20is%205%20plus%2013
//            %20which%20of%20the%20following%20numbers%20is%20the%20largest:%2042,%2067,%2030,%20614
        }

        return "";
    }
}
