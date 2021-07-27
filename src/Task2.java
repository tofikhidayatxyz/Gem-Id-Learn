import java.util.Arrays;

class Task2 {

    static final Integer minPerDistance = 10000;
    static final Integer pricePerDistance = 10000;

    static void countDistance(String schema[][], Integer money) {
        Integer currentDistance = 0;

        boolean hasFoundO = false;
        boolean hasFinalOFound = false;
        boolean hasBreak = false;
        Integer totalDistance = 0;
        for (String[] baseScheme : schema) {
            for (String sc : baseScheme) {

                if(hasFoundO && !hasFinalOFound && !sc.equals("o")) {
//                    System.out.println(sc);
                    if(money >= minPerDistance) {
                        currentDistance++;
                        if(sc.equals("x")) {
                            money -= pricePerDistance;
                        }
                    } else {
                        hasBreak = true;
                    }
                    totalDistance++;
                }

                if(hasFoundO && sc.equals("o")) {
                    hasFinalOFound = true;
                }

                if(!hasFoundO && sc.equals("o")) {
                    hasFoundO = true;
                }
            }
        }

        if(hasBreak) {
            System.out.println("Uang anda habis, jarak tersisa sampai tujuan adalah "+ ((totalDistance - currentDistance) * 10) +" km");
        } else {
            System.out.println("Sisa uang : "+money+", jarak tempuh: "+(currentDistance * 10)+" km ");
        }


    }

    public static void main(String[] args) {
        String schema[][] = {
                {"", "o", "x", "x", "x", "x"},
                {"o", "", "", "", ""},
                {"", "", "", "", ""},
        };

        countDistance(schema, 30000);

    }
}