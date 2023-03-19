package ru.kirillvenediktov.philosophy.chapter20.database;

@DBTable(name = "MEMBER_TASK1")
public class MemberTask1 {

    @SQLLong
    Long id;

    @SQLString(30)
    String firstName;

    @SQLString(30)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLBoolean
    Boolean isEmployed;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public Boolean getEmployed() {
        return isEmployed;
    }

    @Override
    public String toString() {
        return handle;
    }
}
