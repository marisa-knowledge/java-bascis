public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("程序开始运行...");

        try {
            // 危险代码 1：数组越界
            int[] arr = {1, 2, 3};
            System.out.println("尝试访问数组的第5个元素：" + arr[4]);

            // 危险代码 2：除以0（如果上面没报错，这句才会执行）
            // System.out.println(10 / 0);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("【被抓住了】数组越界异常！你访问了不存在的位置。");
        } catch (ArithmeticException e) {
            System.out.println("【被抓住了】算术异常！除数不能为0。");
        } catch (Exception e) {
            // Exception 是所有异常的父类，必须写在最后面兜底
            System.out.println("【兜底】发生了一个未知错误。");
        } finally {
            System.out.println("【finally】不管有没有报错，我一定会执行。");
        }

        System.out.println("程序继续往下走，没有崩溃！");
    }
}