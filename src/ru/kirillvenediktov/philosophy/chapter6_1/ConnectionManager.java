package ru.kirillvenediktov.philosophy.chapter6_1;

public class ConnectionManager {

    private static int limit = 5;

    public static Connection getConnection() {
        Connection connection = null;
        if (Connection.getCount() < limit) {
            connection = Connection.createConnection();
        }
        return connection;
    }
}

class Connection {

    private static int count = 0;

    private Connection() {
    }

    public static Connection createConnection() {
        count++;
        return new Connection();
    }

    public static int getCount() {
        return count;
    }
}

class Task8 {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(ConnectionManager.getConnection());
        }
    }
}
