package ru.kirillvenediktov.philosophy.chapter7;

class Task19Satelite {

}

public class Task19 {

    private final Task19Satelite TASK_19_SATELITE;

    public Task19() {
        TASK_19_SATELITE = new Task19Satelite();
    }

    public Task19(Task19Satelite TASK_19_SATELITE) {
        this.TASK_19_SATELITE = TASK_19_SATELITE;
    }

    public static void main(String[] args) {
        Task19 task19 = new Task19();
        System.out.println(task19.TASK_19_SATELITE);
//        task19.TASK_19_SATELITE = new Task19Satelite();
    }
}
