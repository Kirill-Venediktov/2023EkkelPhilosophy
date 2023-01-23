package ru.kirillvenediktov.philosophy.chapter10.task19;

public class NestedTask19 {

    private int outerInt = 1;

    public int getOuterInt() {
        return outerInt;
    }

    public void setOuterInt(int outerInt) {
        this.outerInt = outerInt;
    }

    public static class Inner {

        private int innerInt = 2;

        public int getInnerInt() {
            return innerInt;
        }

        public void setInnerInt(int innerInt) {
            this.innerInt = innerInt;
        }

        public static class Deep {

            private int deepInt = 3;

            public int getDeepInt() {
                return deepInt;
            }

            public void setDeepInt(int deepInt) {
                this.deepInt = deepInt;
            }
        }

    }

    public static void main(String[] args) {
        NestedTask19.Inner.Deep deep = new Inner.Deep();
        System.out.println(deep.getDeepInt());
    }

}
