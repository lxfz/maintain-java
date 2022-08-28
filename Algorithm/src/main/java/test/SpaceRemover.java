package test;

public class SpaceRemover {
  public static void main(String[] args) {
    String s = "Maximum Score Words Formed by Letters";
    System.out.println(s.replaceAll("\\s+", ""));
  }
}
