import  java.util.*;
interface SplitStrategy {
    void validate(List<Split> splits, double totalAmount);
    void calculate(List<Split> splits, double totalAmount);
}