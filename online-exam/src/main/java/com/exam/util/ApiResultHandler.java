//package com.exam.util;
//
//public class ResultHandler {
//
//    public static Result success(Object object) {
//        Result Result = new Result();
//        Result.setData(object);
//        Result.setCode(200);
//        Result.setMessage("请求成功");
//        return Result;
//    }
//
//    public static Result success() {
//        return success(null);
//    }
//
//    public static <T> Result buildResult(Integer code, String message, T data) {
//        Result Result = new Result();
//
//
//        Result.setCode(code);
//        Result.setMessage(message);
//        Result.setData(data);
//        return Result;
//    }
//}
