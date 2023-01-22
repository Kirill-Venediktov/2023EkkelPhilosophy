package ru.kirillvenediktov.philosophy.chapter3;

public class Task2 {

    public static void main(String[] args) {
        FloatCarrier carrierOne = new FloatCarrier();
        FloatCarrier carrierTwo = new FloatCarrier();

        carrierOne.setTestFloat(1F);
        carrierTwo.setTestFloat(7F);

        System.out.println("testFloat c1 = " + carrierOne.getTestFloat()
                + ", testFloat c2 = " + carrierTwo.getTestFloat());
        carrierOne = carrierTwo;
        System.out.println("testFloat c1 = " + carrierOne.getTestFloat()
                + ", testFloat c2 = " + carrierTwo.getTestFloat());
        carrierOne.setTestFloat(27F);
        System.out.println("testFloat c1 = " + carrierOne.getTestFloat()
                + ", testFloat c2 = " + carrierTwo.getTestFloat());
    }
}
