package ru.kirillvenediktov.philosophy.chapter11;

public class WordStatisticCarrier {

    private String word;
    private int count;

    public WordStatisticCarrier(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
