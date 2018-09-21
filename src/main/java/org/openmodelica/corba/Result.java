package org.openmodelica.corba;

public class Result {
  public final String res;
  public final String log;
  public final String err;

  public Result(String res, String log, String err) {
    this.res = res;
    this.log = log;
    this.err = err;
  }
}
