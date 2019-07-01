package Functional;


public class Operation {
    //region TwoArgumentsOperations
        // операция "+"
        public static double Addition(double firstArgument, double secondArgument) {
            return firstArgument + secondArgument;
        }

        // операция "-"
        public static double Subtraction(double firstArgument, double secondArgument) {
            return firstArgument - secondArgument;
        }

        // операция "*"
        public static double Multiplication(double firstArgument, double secondArgument) {
            return firstArgument * secondArgument;
        }

        // операция "/"
        public static double Division(double firstArgument, double secondArgument) {
            return firstArgument / secondArgument;
            // при делении на ноль возвращает infinity
        }

        // операция "div" (деление без остатка)
        public static double DivisionWithoutReminder(double firstArgument, double secondArgument) {
            return  (int)(firstArgument / secondArgument);
            // при делении на ноль возвращает infinity
        }

        // операция "mod" (отстаток от деления)
        public static double  RemainderOfDivision(double firstArgument, double secondArgument) {
            return firstArgument % secondArgument;
            // остаток от нуля равен NaN
        }
    //endregion
}
