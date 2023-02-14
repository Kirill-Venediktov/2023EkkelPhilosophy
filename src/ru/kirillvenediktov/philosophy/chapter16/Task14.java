package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.util.ConvertTo;
import ru.kirillvenediktov.philosophy.util.CountingGenerator;

import java.util.Arrays;

public class Task14 {

    private final int size;
    private Boolean[] b1;
    private Character[] c1;
    private Short[] s1;
    private Integer[] i1;
    private Long[] l1;
    private Float[] f1;
    private Double[] d1;

    private CountingGenerator.Boolean boolg = new CountingGenerator.Boolean();
    private CountingGenerator.Byte bg = new CountingGenerator.Byte();
    private CountingGenerator.Character cg = new CountingGenerator.Character();
    private CountingGenerator.Short sg = new CountingGenerator.Short();
    private CountingGenerator.Integer ig = new CountingGenerator.Integer();
    private CountingGenerator.Long lg = new CountingGenerator.Long();
    private CountingGenerator.Float fg = new CountingGenerator.Float();
    private CountingGenerator.Double dg = new CountingGenerator.Double();

    public Task14(int size) {
        this.size = size;
        b1 = new Boolean[size];
        c1 = new Character[size];
        s1 = new Short[size];
        i1 = new Integer[size];
        l1 = new Long[size];
        f1 = new Float[size];
        d1 = new Double[size];

    }

    public void fillArrays() {
        for (int i = 0; i < size; i++) {
            b1[i] = boolg.next();
            c1[i] = cg.next();
            s1[i] = sg.next();
            i1[i] = ig.next();
            l1[i] = lg.next();
            f1[i] = fg.next();
            d1[i] = dg.next();
        }

        boolean[] booleans = ConvertTo.primitive(b1);
        char[] chars = ConvertTo.primitive(c1);
        short[] shorts = ConvertTo.primitive(s1);
        int[] ints = ConvertTo.primitive(i1);
        long[] longs = ConvertTo.primitive(l1);
        float[] floats = ConvertTo.primitive(f1);
        double[] doubles = ConvertTo.primitive(d1);

        System.out.println(Arrays.toString(booleans));
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(shorts));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(longs));
        System.out.println(Arrays.toString(floats));
        System.out.println(Arrays.toString(doubles));


    }

    public static void main(String[] args) {

        Task14 task14 = new Task14(5);
        task14.fillArrays();

    }
}
