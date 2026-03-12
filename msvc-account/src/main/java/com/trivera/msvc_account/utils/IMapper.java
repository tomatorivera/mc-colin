package com.trivera.msvc_account.utils;

public interface IMapper<T> {
  
  T getDTO();
  void setData(T t);

}
