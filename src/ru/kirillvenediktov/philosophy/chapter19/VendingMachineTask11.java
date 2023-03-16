package ru.kirillvenediktov.philosophy.chapter19;

import ru.kirillvenediktov.philosophy.util.Generator;
import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

interface InputUnit {

}

class Money implements InputUnit {

    private String name;

    private int cost;

    public Money(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}

class Goods implements InputUnit {

    private String name;

    private int cost;

    public Goods(String name) {
        this.name = name;
    }

    public Goods(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}

class ActionCommand implements InputUnit {

    private String name;

    public ActionCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class VendingMachineTask11 {

    private static State state = State.RESTING;

    private static int amount = 0;

    private static final List<Goods> goods = new ArrayList<>();

    private static Goods selection = null;

    static {
        for (String s : new TextFile(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter19\\ForVendingMachine.txt",
                " ")) {
            String[] data = s.split("[()]");
            goods.add(new Goods(data[0], Integer.parseInt(data[1])));
        }
    }

    enum StateDuration {TRANSIENT}

    enum State {
        RESTING {
            void next(InputUnit input) {
                if (input instanceof Money) {
                    amount += ((Money) input).getCost();
                    state = ADDING_MONEY;
                } else if (input instanceof ActionCommand && ((ActionCommand) input).getName().equals("STOP")) {
                    state = TERMINAL;
                }
            }
        },
        ADDING_MONEY {
            void next(InputUnit input) {
                if (input instanceof Money) {
                    amount += ((Money) input).getCost();
                } else if (input instanceof Goods) {
                    for (Goods goods : goods) {
                        if (goods.equals(input)) {
                            selection = goods;
                            if (amount < selection.getCost()) {
                                System.out.println("Insufficient money for " + selection);
                            } else {
                                state = DISPENDING;
                            }
                            break;
                        }
                    }
                } else if (input instanceof ActionCommand
                        && ((ActionCommand) input).getName().equals("ABORT_TRANSACTION")) {
                    state = GIVING_CHANGE;
                } else if (input instanceof ActionCommand
                        && ((ActionCommand) input).getName().equals("STOP")) {
                    state = TERMINAL;
                }
            }
        },
        DISPENDING(StateDuration.TRANSIENT) {
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.getCost();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            void output() {
                System.out.println("Halted");
            }
        };

        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(InputUnit input) {
            throw new RuntimeException("Only call " +
                    "next(InputUnit input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }

        void output() {
            System.out.println(amount);
        }
    }

    static void run(Generator<InputUnit> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<InputUnit> gen = new InputUnitGenerator();
        run(gen);
    }
}

class InputUnitGenerator implements Generator<InputUnit> {

    private static final List<String> ACTION_COMMANDS = Arrays.asList("ABORT_TRANSACTION", "STOP");

    private static final Map<String, Integer> MONEY = new HashMap<>();

    static {
        MONEY.put("NICKEL", 5);
        MONEY.put("DIME", 10);
        MONEY.put("QUARTER", 25);
        MONEY.put("DOLLAR", 100);
    }

    private final LinkedList<InputUnit> unitsQueue = new LinkedList<>();

    public InputUnitGenerator() {
        for (String s : new TextFile(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter19\\actions.txt",
                " ")) {
            unitsQueue.add(interpret(s.trim()));
        }
    }

    public InputUnit interpret(String string) {
        if (ACTION_COMMANDS.contains(string)) {
            return new ActionCommand(string);
        } else if (MONEY.containsKey(string)) {
            return new Money(string, MONEY.get(string));
        } else {
            return new Goods(string);
        }
    }

    @Override
    public InputUnit next() {
        return unitsQueue.poll();
    }
}
