package org.renjin.cran.RCurl;

import org.renjin.eval.Context;
import org.renjin.sexp.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CurlHandle {


  private URL url;
  private Closure writeFunction;


  public void setOption(CurlOption curlOption, SEXP optionValue) {
    switch (curlOption) {
      case URL:
        this.url = urlValue(stringValue(optionValue));
        break;

      case WRITEFUNCTION:
        this.writeFunction = functionValue(optionValue);
        break;

      default:
        throw new UnsupportedOperationException("TODO: " + curlOption.name());
    }
  }

  private Closure functionValue(SEXP optionValue) {
    if(optionValue instanceof Closure) {
      return (Closure) optionValue;
    }
    throw new IllegalArgumentException("Expected function");
  }

  private String stringValue(SEXP optionValue) {
    if(optionValue instanceof AtomicVector && optionValue.length() > 0) {
      return ((AtomicVector) optionValue).getElementAsString(0);
    } else {
      throw new IllegalArgumentException("Expected character option value");
    }
  }

  private URL urlValue(String string) {
    try {
      return new URL(string);
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  static CurlHandle valueOf(SEXP curl) {
    ExternalPtr<CurlHandle> externalPtr = (ExternalPtr<CurlHandle>) curl;
    return externalPtr.getInstance();
  }

  public void perform(Context context) throws IOException {

    try(InputStream urlConnection = url.openConnection().getInputStream()) {

    }
  }
}
