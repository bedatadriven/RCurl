package org.renjin.cran.RCurl;

import org.renjin.primitives.Native;
import org.renjin.sexp.*;

import java.io.IOException;

public class RCurl {

  public static SEXP R_curl_version_info(SEXP flag) {
    throw new UnsupportedOperationException("TODO");
  }

  public static SEXP R_curl_easy_init() {
    return new ExternalPtr<>(new CurlHandle());
  }

  public static SEXP R_getCURLOptionEnum() {
    return createNamedEnum(CurlOption.values());
  }

  private static SEXP createNamedEnum(CurlEnum[] values) {
    IntArrayVector.Builder vector = new IntArrayVector.Builder(0, values.length);
    StringArrayVector.Builder names = new StringVector.Builder(0, values.length);
    for (CurlEnum value : values) {
      vector.add(value.id());
      names.add(value.name());
    }

    vector.setAttribute(Symbols.NAMES, names.build());
    return vector.build();
  }

  public static void R_curl_easy_setopt(SEXP handleSexp, SEXP optionIds, SEXP optionValues, SEXP protectedSexp, SEXP encoding) {

    CurlHandle handle = CurlHandle.valueOf(handleSexp);
    Vector optionIdVector = (Vector) optionIds;
    Vector optionValueVector = (Vector) optionValues;

    for (int i = 0; i < optionIdVector.length(); i++) {
      int optionId = optionIdVector.getElementAsInt(i);
      SEXP optionValue = optionValueVector.getElementAsSEXP(i);

      CurlOption curlOption = CurlOption.valueOf(optionId);
      handle.setOption(curlOption, optionValue);
    }

  }

  public static SEXP R_curl_easy_perform(SEXP curl, SEXP opts, SEXP isProtected, SEXP encoding) throws IOException {
    CurlHandle curlhandle = CurlHandle.valueOf(curl);

    if(opts.length() > 0) {
      R_curl_easy_setopt(curl, opts.getElementAsSEXP(0), opts.getElementAsSEXP(1), isProtected, encoding);
    }

    curlhandle.perform(Native.currentContext());

    return Null.INSTANCE;
  }

}
