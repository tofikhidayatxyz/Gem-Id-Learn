public class Task3 {

    static void findChair(String[][] schema, String[] users) {
        for(int i = 0; i < schema.length; i++) {
            for(int j = 0; j < schema[i].length; j++) {
                // user
                for(int k = 0; k < users.length; k++) {
                    if(schema[i][j].length() == 0 && users[k] != null) {
                        schema[i][j] = users[k];
                        users[k] = null;
                    }
                }
            }
        }

        String buffUser = "";
        Integer unallocatedUser = 0;

        for (String usr : users) {
            if(usr != null) {
                buffUser += usr +", ";
                unallocatedUser ++;
            }
        }

        if(unallocatedUser > 0) {
            System.out.println(buffUser + " tidak mendapatkan kursi bus. Silahkan cari bus lain");
        } else {
            for(String[] line : schema) {
                for (String chair : line) {
                    System.out.print(chair + ", ");
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        String[][] schemas1 =  {
                {"Hary", "", "Button"},
                {"", "Tony", ""},
                {"Udin", "Paijo", "Butet"}
        };
        String[] users1 =  {"Budi", "Soleh", "Miku"};



        String[][] schemas2 =  {
                {"Udin", "", ""},
                {"", "", "Dede"},
                {"Saiful", "Paijo", "Butet"}
        };
        String[] users2 =  {"Alucard", "Balmond", "Eudora", "Nana", "Miya", "Zilong", "Layla", "Grock"};

        findChair(schemas1, users1);

        System.out.println("---------------------------");

        findChair(schemas2, users2);
    }
}
