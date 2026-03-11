package com.trivera.msvc_customer.utils;

public interface IMapper<T> {

  T getDTO();
  void setData(T t);

}
