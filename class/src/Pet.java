import java.text.DecimalFormat;

/**
 * This is a class to define Pet objects. Pets should be compared
 * according to their owner's names, ignoring capitalization. Ties
 * should be broken based on the pet's name, ignoring capitalization.
 * <p>
 * Your job is to add the necessary data and methods to support the
 * P3main program, as well as the related classes in this system. Some
 * required methods are noted below with comments, but these are not the
 * only things you will need.
 */

/**
 * Pet类：该类主要用户记录一个宠物的相关信息
 *  一个宠物必须包含name（宠物名）,owner’s name（宠物主人的名字）和weight(宠物体重)和其它一些必须的数据。
 *  Pet类必须实现Comparable接口，以支持在Vet类中有对宠物排序。排序的依据为首先考虑宠物主人的姓名的字母顺序，再考虑宠物的名字字母顺序,排序的时候均忽略大小写。
 *  Pet类必须实现equals方法，如果两个宠物的主人名字和宠物的名字都相等（忽略大小写），则认为这两个宠物相等。
 *  已提供该类的基本架构和相关的文档注释，除了补充完成相关方法之外，还需要根据类的功能增加必要的域和方法。

 */
public class Pet implements Comparable {

    /**
     * Handy for formatting.
     */
    private static DecimalFormat money = new DecimalFormat("0.00");

    /* The access specifiers for these variables must not be changed! */

    private String name;
    private String owner;
    private double weight;

    protected int visits;
    protected double cost;
    protected static final double MONEY_PER_SHOT = 30;
    protected static final double MONEY_PER_VISIT = 85;

    /**
     * Create a Pet object, initializing data members.
     *
     * @param pname the Pet's name
     * @param oname the owner's name
     * @param wt    the weight of the pet
     */
    public Pet(String pname , String oname , double wt) {
        name = pname;
        owner = oname;
        weight = wt;
        visits = 0;
        cost = 0;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.name + " (owner " + this.owner + ") " + this.weight
                + " lbs, $" + money.format(this.avgCost()) + " avg cost/visit  ";
    }

    /**
     * The Pet is visiting the vet, and will be charged accordingly.
     * The base cost for a visit is $85.00, and $30/shot is added.
     *
     * @param shots the number of shots the pet is getting
     * @return the entire cost for this particular visit
     */
    public double visit(int shots) {
        visits++;
        double total = MONEY_PER_SHOT * shots + MONEY_PER_VISIT;
        cost += total;
        return total;
    }

    /**
     * Determine the average cost per visit for this pet.
     *
     * @return that cost, or 0 if no visits have occurred yet
     */
    public double avgCost() {
        if (visits == 0 || cost == 0)
            return 0;
        else return cost / visits;
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Pet)) return false;
        Pet other = (Pet)obj;
        return (name.equalsIgnoreCase(other.name) && owner.equalsIgnoreCase(other.owner));
    }

    @Override
    public int compareTo(Object o) {
        Pet other = (Pet)o;
        this.owner.toLowerCase();
        other.owner.toLowerCase();
        for (int i = 0; i < this.owner.length() && i < other.owner.length(); i++) {
            if (this.owner.equalsIgnoreCase(other.owner)) {
                for (int j = 0; j < this.name.length() && j < other.name.length(); j++) {
                    this.name.toLowerCase();
                    other.name.toLowerCase();
                    if (this.name.charAt(j) != other.name.charAt(j)) return this.name.charAt(j) - other.name.charAt(j);
                }
            }
            if (this.owner.charAt(i) != other.owner.charAt(i)) return this.owner.charAt(i) - other.owner.charAt(i);
        }
        return 0;
    }
}

/**
 * Cat类：Pet的子类，记录宠物猫的相关信息。
 * 该类需要一个实例域来记录该宠物猫是一只仅在户内饲养的猫（inside）还是一只也会去户外活动的猫(outside)。
 * 该类需要一个实例域方法能在猫去户外后，改变其状态为一只(outside)的猫。
 * 所有的宠物猫默认情况下仅在户内饲养。但一旦去了一次户外，就是一只outside的猫了。
 * 该类需要重写visit（）方法，重写后功能为：宠物猫每次来宠物医院，会需要额外20$的洗牙费（每次来都会洗），同时每次相比（若是outside的猫）一般宠物(Pet)还要多打一针（shot），该针的费用同一般宠物(Pet)打针费用。重写该方法的时候需要注意，Pet类的相关数据也需要正确更新（提示，可先调用父类的visit()方法）。
 */
class Cat extends Pet {
    private String type;
    private static final double EXTRA_FEE = 20;

    public Cat(String pname , String oname , double wt) {
        super(pname , oname , wt);
        type = "inside";
        cost = 0;
    }

    public void goOutside() {
        type = "outside";
    }

    public String getType() {
        return type;
    }

    @Override
    public double visit(int shots) {
        double extra = 0;
        if (type.equals("outside")) extra = EXTRA_FEE + MONEY_PER_SHOT;  //outside cat should take an extra shot
        if (type.equals("inside")) extra = EXTRA_FEE;
        double a = super.visit(shots) + extra;
        cost += extra;
        return a;
    }

    public String toString() {
        return this.getType() + " cat " + super.toString();
    }
}

/**
 * Dog类：Pet的子类，记录宠物狗的相关信息。
 * 该类需要一个实例域来记录该宠物狗是一只小型(small)、中型(medium)还是大型(large)的狗。该实例域在构造方法中赋值，可参看P3main.java中的语句。
 * 该类需要重写visit（）方法，重写后功能为：宠物狗每次来宠物医院，需要收取的额外费用为：15$的修剪指甲，中型(Medium)狗的打针费用每针比一般宠物(Pet)多收取2.5$，大型(Large)狗的打针费用每针比一般宠物(Pet)多收取5$。重写该方法的时候需要注意，Pet类的相关数据也需要正确更新（提示，可先调用父类的visit()方法）。
 */
class Dog extends Pet {

    private String type;
    private static final double EXTRA_FEE = 15;

    public Dog(String pname , String oname , double wt , String atype) {
        super(pname , oname , wt);
        type = atype;
        cost = 0;
    }

    public double visit(int shots) {
        double total = 0;
        if (type.equalsIgnoreCase("Small"))
            total = MONEY_PER_VISIT + (double)shots * MONEY_PER_SHOT + EXTRA_FEE;
        if (type.equalsIgnoreCase("Medium"))
            total = MONEY_PER_VISIT + (double)shots * (MONEY_PER_SHOT+2.5) + EXTRA_FEE;
        if (type.equalsIgnoreCase("Large"))
            total = MONEY_PER_VISIT + (double)shots * (MONEY_PER_SHOT+5) + EXTRA_FEE;
        visits++;
        cost += total;
        return total;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return this.getType() + " dog " + super.toString();
    }

}