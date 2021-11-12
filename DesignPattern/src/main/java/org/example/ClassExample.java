package org.example;

public class ClassExample {

  public void getClazz() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    /**
     * JVM持有的每个 Class 实例都指向一个数据类型（class或interface）：
     * 这种通过 Class 实例获取 class 信息的方法称为反射（Reflection）。
     */

    // 方法一：直接通过一个class的静态变量class获取：
    Class cls1 = String.class;

    // 方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取：
    String s = "Hello";
    Class cls2 = s.getClass();

    // 方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
    Class cls3 = Class.forName("java.lang.String");

    // 创建一个String实例:
    // 它的局限是：只能调用public的无参数构造方法。带参数的构造方法，
    // 或者非public的构造方法都无法通过Class.newInstance()被调用。
    String ss = (String) cls1.newInstance();


    // JVM动态加载class的特性:
      // JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，
      // 而是第一次需要用到class时才加载。

  }

  public static void main(String[] args) {
    printClassInfo("".getClass());
    printClassInfo(Runnable.class);
    printClassInfo(java.time.Month.class);
    printClassInfo(String[].class);
    printClassInfo(int.class);
  }

  static void printClassInfo(Class cls) {
    System.out.println("Class name: " + cls.getName());
    System.out.println("Simple name: " + cls.getSimpleName());
    if (cls.getPackage() != null) {
      System.out.println("Package name: " + cls.getPackage().getName());
    }
    System.out.println("is interface: " + cls.isInterface());
    System.out.println("is enum: " + cls.isEnum());
    System.out.println("is array: " + cls.isArray());
    System.out.println("is primitive: " + cls.isPrimitive());
  }
}
