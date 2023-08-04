package info.juliocnsouza.puzzles.functional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroupByCategory {
    public static Map<String, List<Product>> groupByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
    }

    public static class Product {
        private String category;
        private String name;

        public Product(String category, String name) {
            this.category = category;
            this.name = name;
        }

    }
}

