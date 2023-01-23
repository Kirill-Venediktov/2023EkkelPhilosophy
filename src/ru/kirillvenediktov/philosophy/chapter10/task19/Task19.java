package ru.kirillvenediktov.philosophy.chapter10.task19;

public class Task19 {
    private int outerInt = 1;

    public int getOuterInt() {
        return outerInt;
    }

    public void setOuterInt(int outerInt) {
        this.outerInt = outerInt;
    }

    public class Inner {
        private int innerInt = 2;

        public int getInnerInt() {
            return innerInt;
        }

        public void setInnerInt(int innerInt) {
            this.innerInt = innerInt;
        }

        public class Deep {
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
        Task19 task19 = new Task19();
        Task19.Inner inner = task19.new Inner();
        Task19.Inner.Deep deep = inner.new Deep();

        System.out.println(inner.getInnerInt());
        System.out.println(deep.getDeepInt());

    }
}
