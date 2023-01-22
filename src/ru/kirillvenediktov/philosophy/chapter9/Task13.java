package ru.kirillvenediktov.philosophy.chapter9;

public interface Task13 {
}

interface Task13SateliteOne extends Task13 {

}

interface Task13SateliteTwo extends Task13 {

}

interface Task13SateliteThree extends Task13SateliteOne, Task13SateliteTwo {

}
