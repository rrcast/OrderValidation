import java.util.*;

public final class Constants {
    public static final List<Order> ORDERLIST = new ArrayList<>();
    Order o = new Order();

    static {
        ORDERLIST.add(new Order(true, 0, null, "empty", "empty"));
        ORDERLIST.add(new Order(null, 0, true, "empty", "empty"));
        ORDERLIST.add(new Order(null, null, null, null, "empty"));
        ORDERLIST.add(new Order(null, null, null, "empty", null));

    }


}
