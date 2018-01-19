package org.renjin.cran.RCurl;


public enum CurlFeatures {
  IPV6,
  KERBEROS4,
  SSL,
  LIBZ,
  NTLM,
  GSS_NEGOTIATE,
  DEBUG,
  ASYNC_DNS,
  SPNEGO,
  LARGEFILE,
  IDN,
  SSPI,
  CONV,
  CURL_DEBUG,
  TLSAUTH_SRP,
  NTLM_WB;

  int bitmask() {
    return 2 ^ ordinal();
  }

}
