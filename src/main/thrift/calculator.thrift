namespace scala com.dellitt.thrift

 service Calculator {
    i64 add(i64 first, i64 second);
    i64 subtract(i64 first, i64 second);
    i64 multiply(i64 first, i64 second);
    i64 divide(i64 first, i64 second);
 }