package org.renjin.cran.RCurl;

import org.renjin.gcc.runtime.Ptr;
import org.renjin.primitives.Native;
import org.renjin.primitives.packaging.DllInfo;
import org.renjin.primitives.packaging.DllSymbol;
import org.renjin.repackaged.guava.base.Charsets;
import org.renjin.sexp.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class RCurl {

  public static void R_init_RCurl(DllInfo dll) {

    for (Method method : RCurl.class.getMethods()) {
      if(method.getAnnotation(Register.class) != null) {
        dll.register(new DllSymbol(method));
      }
    }

    dll.setUseDynamicSymbols(true);
  }

  @Register
  public static SEXP R_curl_version_info(SEXP flag) {
    ListVector.NamedBuilder version = ListVector.newNamedBuilder();
    version.add("age", 3);
    version.add("version", "7.47.0");
    version.add("version_num", 470784);
    version.add("host", "x86_64-pc-linux-gnu");
    version.add("features", 968605);
    version.add("ssl_version", "Java");
    version.add("ssl_version_num", 0);
    version.add("libz_version", "1.2.8");
    version.add("ares", "");
    version.add("ares_num", 0);
    version.add("libidn", "1.32");

    return version.build();
  }

  @Register
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

  @Register
  public static SEXP R_curl_easy_perform(SEXP curl, SEXP opts, SEXP isProtected, SEXP encoding) throws IOException {
    CurlHandle curlhandle = CurlHandle.valueOf(curl);

    if(opts.length() > 0) {
      R_curl_easy_setopt(curl, opts.getElementAsSEXP(0), opts.getElementAsSEXP(1), isProtected, encoding);
    }

    curlhandle.perform(Native.currentContext());

    return Null.INSTANCE;
  }


  public static void R_check_bits(Ptr val, Ptr bits, Ptr ans, Ptr n) {
    int i;
    for (i = 0; i < n.getInt(); i++) {
      boolean bitSet = (val.getInt() & bits.getAlignedInt(i)) != 0;
      ans.setAlignedInt(i, bitSet ? 1 : 0);
    }
  }


  @Register
  public static SEXP R_curl_escape(SEXP vals, SEXP escapeSexp) throws UnsupportedEncodingException {

    boolean escape = escapeSexp.asLogical().toBooleanStrict();

    int i, n;
    n = vals.length();
    StringVector.Builder result = StringArrayVector.newBuilder();
    for(i = 0; i < n ; i++) {
      String ptr = ((StringVector) vals).getElementAsString(i);
      if(ptr != null) {
        if(escape) {
          result.add(URLEncoder.encode(ptr, Charsets.UTF_8.name()));
        } else {
          result.add(URLDecoder.decode(ptr, Charsets.UTF_8.name()));
        }
      }
    }
    return result.build();
  }
}
