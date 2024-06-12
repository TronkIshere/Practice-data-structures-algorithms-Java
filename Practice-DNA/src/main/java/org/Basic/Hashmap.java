package org.Basic;

import java.util.HashMap;

public class Hashmap {
    public static void main(String[] arg){
        HashMap<String, Integer> empIds = new HashMap<>();
        empIds.put("John", 12345);
        empIds.put("Carl", 54321);
        empIds.put("Jerry", 8675309);

        System.out.println(empIds);
        System.out.println(empIds.get("Carl"));
        System.out.println(empIds.containsKey("Carl")); //Kiểm tra có tồn tại không
        System.out.println(empIds.containsValue(12345)); //Kiểm tra có tồn tại không

        /*Nếu key đã tồn tại thì nó sẽ thay thế giá trị*/
        empIds.put("John", 123);
        System.out.println(empIds);

        //Thay giá trị nếu như key đó có tồn tại
        empIds.replace("John", 1234);
        System.out.println(empIds);

        //Thêm nếu như key không tồn tại
        empIds.putIfAbsent("Steve", 333);
        System.out.println(empIds);

        //Xóa dựa trên key
        empIds.remove("Steve");
        System.out.println(empIds);
    }
}
