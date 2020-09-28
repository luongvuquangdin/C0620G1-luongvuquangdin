package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductServiceImpl implements ProductService {
    static Map<Integer, Product> productMap=new TreeMap<>();
    static {
        productMap.put(1,new Product(1,"Rebel 500", (double) 180000000,"Honda",
        "khối động cơ 2 xy lanh song song mạnh mẽ, đặt gọn trong bộ khung xe với trọng tâm thấp" +
                "phong cách thiết kế tối giản đã đưa chiếc xe trở nên hấp dẫn"));
        productMap.put(2,new Product(2,"Winner X", (double) 45990000,"Honda",
                "phối màu và tem mới làm nổi bật khí chất đỉnh cao của người lái"));
        productMap.put(3,new Product(3,"SH 125i/150i", (double) 70990000,"Honda",
                "Kiệt tác thiết kế đậm chất châu Âu được thổi một luồng gió mới với việc bổ sung phiên" +
                        " bản đen mờ nam tính dành riêng cho phiên bản 150 cc."));
        productMap.put(4,new Product(4,"Goldwing", (double) 1200000000,"Honda",
                "Gold Wing đã được cải tiến hệ thống FI và ly hợp kép DCT giúp cải thiện khả năng vận hành " +
                        "ở tốc độ thấp, hệ thống giảm xóc được tinh chỉnh cùng tay nắm cho người ngồi sau được thiết kế to hơn"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create() {

    }

    @Override
    public Product findProductByName(String name) {
        return null;
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }
}
