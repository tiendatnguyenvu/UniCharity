package com.UniCharity.UniCharity.utils;

import java.lang.reflect.Field;
import java.util.List;

public class SortUtils {
    public static <T> List<T> sortList(List<T> list, String sortField, String sortDirection) {
        list.sort((item1, item2) -> {
            try {
                // Lấy field từ lớp của đối tượng
                Field field = item1.getClass().getDeclaredField(sortField);
                field.setAccessible(true); // Cho phép truy cập vào field private nếu cần

                // Lấy giá trị của field từ hai đối tượng
                Object value1 = field.get(item1);
                Object value2 = field.get(item2);

                // Kiểm tra giá trị null
                if (value1 == null && value2 == null) return 0;
                if (value1 == null) return sortDirection.equalsIgnoreCase("ASC") ? -1 : 1;
                if (value2 == null) return sortDirection.equalsIgnoreCase("ASC") ? 1 : -1;

                // Ép kiểu giá trị thành Comparable để so sánh
                Comparable comparable1 = (Comparable) value1;
                Comparable comparable2 = (Comparable) value2;

                // So sánh theo hướng sắp xếp
                return sortDirection.equalsIgnoreCase("ASC")
                        ? comparable1.compareTo(comparable2)
                        : comparable2.compareTo(comparable1);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error sorting list by field: " + sortField, e);
            }
        });
        return list;
    }
}
