package com.cyy.springbootshiro.reps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @program: spring-security
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-08 23:39
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

   private Integer code;

   private String message;

   private T data;

   public static <T> Result<T> success() {
      return restResult(HttpStatus.OK.value(), null, null);
   }

   public static <T> Result<T> success(T data) {
      return restResult(HttpStatus.OK.value(), null, data);
   }

   public static <T> Result<T> success(String message, T data) {
      return restResult(HttpStatus.OK.value(), message, data);
   }

   public static <T> Result<T> error(Integer code) {
      return restResult(code, null, null);
   }

   public static <T> Result<T> error(String message) {
      return restResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null);
   }

   public static <T> Result<T> error(Integer code, String message) {
       return restResult(code, message, null);
   }

   public static <T> Result<T> error(Integer code, String message, T data) {
      return restResult(code, message, data);
   }

   private static <T> Result<T> restResult(Integer code, String message, T data) {
      Result<T> apiResult = new Result<>();
      apiResult.setCode(code);
      apiResult.setData(data);
      apiResult.setMessage(message);
      return apiResult;
   }

}
