package ru.kirillvenediktov.philosophy.chapter10;

interface Monster {

    void menace();
}

interface DangerousMonster extends Monster {

    void destroy();
}

interface Lethal {

    void kill();
}

interface Vampire extends DangerousMonster, Lethal {

}

public class HorrorShow {

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DangerousMonster() {

            @Override
            public void destroy() {

            }

            @Override
            public void menace() {

            }
        };

        u(barney);
        v(barney);
        Vampire vlad = new Vampire() {

            @Override
            public void destroy() {

            }

            @Override
            public void kill() {

            }

            @Override
            public void menace() {

            }

            public void drinkBlood() {

            }
        };
        u(vlad);
        v(vlad);
        w(vlad);
    }

}
