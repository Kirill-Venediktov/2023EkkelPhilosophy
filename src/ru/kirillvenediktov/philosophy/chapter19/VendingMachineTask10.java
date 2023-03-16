package ru.kirillvenediktov.philosophy.chapter19;

import ru.kirillvenediktov.philosophy.util.Generator;

import java.util.EnumMap;

import static ru.kirillvenediktov.philosophy.chapter19.VendingMachineTask10.State.DISPENDING;
import static ru.kirillvenediktov.philosophy.chapter19.VendingMachineTask10.State.GIVING_CHANGE;
import static ru.kirillvenediktov.philosophy.chapter19.VendingMachineTask10.State.TERMINAL;

public class VendingMachineTask10 {

    private State state = State.RESTING;

    private int amount = 0;

    private Input selection = null;

    private EnumMap<State, Command> enumMap = new EnumMap<>(State.class);

    {
        enumMap.put(State.RESTING, new Command() {

            @Override
            public void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = State.ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = State.TERMINAL;
                    default:
                }
            }

        });

        enumMap.put(State.ADDING_MONEY, new Command() {

            @Override
            public void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount())
                            System.out.println("Insufficient money for " + selection);
                        else state = State.DISPENDING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = State.TERMINAL;
                    default:
                }
            }

        });

        enumMap.put(DISPENDING, new Command() {

            @Override
            public void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }

        });

        enumMap.put(GIVING_CHANGE, new Command() {

            @Override
            public void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = State.RESTING;
            }

        });

        enumMap.put(TERMINAL, new Command() {

            @Override
            public void output() {
                System.out.println("Halted");
            }
        });
    }

    private class Command {

        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }

        void output() {
            System.out.println(amount);
        }
    }

    enum StateDuration {TRANSIENT}

    enum State {
        RESTING, ADDING_MONEY, DISPENDING(StateDuration.TRANSIENT), GIVING_CHANGE(StateDuration.TRANSIENT), TERMINAL;

        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

    }

    void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            Command command = enumMap.get(state);
            command.next(gen.next());
            while (state.isTransient) {
                command = enumMap.get(state);
                command.next();
            }
            command.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        VendingMachineTask10 machine1 = new VendingMachineTask10();
        VendingMachineTask10 machine2 = new VendingMachineTask10();
        if (args.length == 1)
            gen = new FileInputGenerator(args[0]);
        machine1.run(gen);
        machine2.run(gen);
    }
}
