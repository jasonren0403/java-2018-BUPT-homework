/**
 * 仔细阅读DataSet.java，该类实现了如下功能：
 * 1．	通过add(…)接收一组double类型数据；
 * 2．	通过getAverage()返回接收到的所有数据的平均值；
 * 3．	通过getMaximum()返回接收到的所有数据中最大的一个；
 * 利用接口技术改写此程序，扩展程序功能，要求改写后程序能够实现
 * 1．	通过add(…)接收一些自定义的类的对象；（提示：这些类实现了某个接口，而这个接口中的某个方法返回了类的测量值）；
 * 2．	通过getAverage()返回接收到的所有对象测量值的平均值；
 * 3．	通过getMaximum()返回接收到的所有对象测量值最大的一个对象；
 * 并用改写后的DataSet类，接收一组Human/Student对象，输出这一组对象的平均值，和其中测量值最大的一个对象。
 */

/**
 * Computes the average of a set of data values.
 */
class DataSet {
    private double sum;
    private double maximum;
    private int count;

    /**
     * Constructs an empty data set.
     */
    public DataSet() {
        sum = 0;
        count = 0;
        maximum = 0;
    }

    /**
     * Adds a data value to the data set
     *
     * @param x a data value
     */
    public void add(Measurable... x) {
        for (int i = 0; i < x.length; i++) {
            double a = x[i].getMeasure();
            sum = sum + a;
            if (count == 0 || maximum < x[i].getMeasure()) maximum = x[i].getMeasure();
            count++;
        }
    }

    /**
     * Gets the average of the added data.
     *
     * @return the average or 0 if no data has been added
     */
    public double getAverage() {
        if (count == 0) return 0;
        else return sum / count;
    }

    /**
     * Gets the largest of the added data.
     *
     * @return the maximum or 0 if no data has been added
     */
    public double getMaximum() {
        return maximum;
    }

}




