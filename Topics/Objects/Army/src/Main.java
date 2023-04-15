import javax.print.Doc;

class Army {

    public static void createArmy() {
        // Create all objects here
        Unit[] units = new Unit[5];
        Knight[] knights = new Knight[3];
        General[] general = new General[1];
        Doctor[] doctor = new Doctor[1];

        for (int i = 0; i < 5; i++) {
            units[i] = new Unit("Unit"+i);
        }

        for (int i = 0; i < 3; i++) {
            knights[i] = new Knight("Knight"+i);
        }

        for (int i = 0; i < 1; i++) {
            general[i] = new General("General"+i);
        }

        for (int i = 0; i < 1; i++) {
            doctor[i] = new Doctor("Doctor"+i);
        }

    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}
