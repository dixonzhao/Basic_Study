package week09_part02.practice;

/**
 * Created by betamaz on 6/13/17.
 */
public class TestSetAction {

    public static void main(String[] args) {
        TestSetAction myTest = new TestSetAction();
        myTest.setAction1(() -> System.out.print("Action 1! "));
        myTest.setAction2(e -> System.out.print(e + " "));
        System.out.println(myTest.setAction3(e -> e * 2));
    }

    public void setAction1(T1 t)
    {    t.m(); }

    public void setAction2(T2 t)
    {    t.m(4.5); }

    public double setAction3(T3 t)
    {    return t.m(5.5); }
}

/**
 * A functional interface whose abstract method:
 * - with no arguments,
 * - no return type.
 */
interface T1
{    public void m(); }


/**
 * A functional interface whose abstract method:
 * - with one argument,
 * - no return type.
 */
interface T2
{    public void m(Double d); }

/**
 * A functional interface whose abstract method:
 * - with one argument,
 * - returns a double.
 */
interface T3
{    public double m(Double d); }
