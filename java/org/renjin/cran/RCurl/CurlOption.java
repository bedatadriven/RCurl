package org.renjin.cran.RCurl;

import static org.renjin.cran.RCurl.CurlOptionType.*;

public enum CurlOption implements CurlEnum {

  FILE(OBJECTPOINT, 1),
  URL(OBJECTPOINT, 2),
  PORT(LONG, 3),
  PROXY(OBJECTPOINT, 4),
  USERPWD(OBJECTPOINT, 5),
  PROXYUSERPWD(OBJECTPOINT, 6),
  RANGE(OBJECTPOINT, 7),
  INFILE(OBJECTPOINT, 9),
  ERRORBUFFER(OBJECTPOINT, 10),
  WRITEFUNCTION(FUNCTIONPOINT, 11),
  READFUNCTION(FUNCTIONPOINT, 12),
  TIMEOUT(LONG, 13),
  INFILESIZE(LONG, 14),
  POSTFIELDS(OBJECTPOINT, 15),
  REFERER(OBJECTPOINT, 16),
  FTPPORT(OBJECTPOINT, 17),
  USERAGENT(OBJECTPOINT, 18),
  LOW_SPEED_LIMIT(LONG , 19),
  LOW_SPEED_TIME(LONG, 20),
  RESUME_FROM(LONG, 21),
  COOKIE(OBJECTPOINT, 22),
  HTTPHEADER(OBJECTPOINT, 23),
  HTTPPOST(OBJECTPOINT, 24),
  SSLCERT(OBJECTPOINT, 25),
  SSLCERTPASSWD(OBJECTPOINT, 26),
  SSLKEYPASSWD(OBJECTPOINT, 26),
  CRLF(LONG, 27),
  QUOTE(OBJECTPOINT, 28),
  WRITEHEADER(OBJECTPOINT, 29),
  COOKIEFILE(OBJECTPOINT, 31),
  SSLVERSION(LONG, 32),
  TIMECONDITION(LONG, 33),
  TIMEVALUE(LONG, 34),
  CUSTOMREQUEST(OBJECTPOINT, 36),
  STDERR(OBJECTPOINT, 37),
  POSTQUOTE(OBJECTPOINT, 39),
  WRITEINFO(OBJECTPOINT, 40),
  VERBOSE(LONG, 41),      /* talk a lot */
  HEADER(LONG, 42),       /* throw the header out too */
  NOPROGRESS(LONG, 43),   /* shut off the progress meter */
  NOBODY(LONG, 44),       /* use HEAD to get http document */
  FAILONERROR(LONG, 45),  /* no output on http error codes >= 300 */
  UPLOAD(LONG, 46),       /* this is an upload */
  POST(LONG, 47),         /* HTTP POST method */
  FTPLISTONLY(LONG, 48),  /* Use NLST when listing ftp dir */
  FTPAPPEND(LONG, 50),    /* Append instead of overwrite on upload! */

  NETRC(LONG, 51),
  FOLLOWLOCATION(LONG, 52),  /* use Location: Luke! */
  TRANSFERTEXT(LONG, 53), /* transfer data in text/ASCII format */
  PUT(LONG, 54),          /* PUT the input file */
  PROGRESSFUNCTION(FUNCTIONPOINT, 56),
  PROGRESSDATA(OBJECTPOINT, 57),
  AUTOREFERER(LONG, 58),
  PROXYPORT(LONG, 59),
  POSTFIELDSIZE(LONG, 60),
  HTTPPROXYTUNNEL(LONG, 61),
  INTERFACE(OBJECTPOINT, 62),
  KRB4LEVEL(OBJECTPOINT, 63),
  SSL_VERIFYPEER(LONG, 64),
  CAINFO(OBJECTPOINT, 65),
  MAXREDIRS(LONG, 68),
  FILETIME(OBJECTPOINT, 69),
  TELNETOPTIONS(OBJECTPOINT, 70),
  MAXCONNECTS(LONG, 71),
  CLOSEPOLICY(LONG, 72),
  FRESH_CONNECT(LONG, 74),

  /* Set to explicitly forbid the upcoming transfer's connection to be re-used
     when done. Do not use this unless you're absolutely sure of this, as it
     makes the operation slower and is less friendly for the network. */
  FORBID_REUSE(LONG, 75),

  /* Set to a file name that contains random data for libcurl to use to
     seed the random engine when doing SSL connects. */
  RANDOM_FILE(OBJECTPOINT, 76),

  /* Set to the Entropy Gathering Daemon socket pathname */
  EGDSOCKET(OBJECTPOINT, 77),

  /* Time-out connect operations after this amount of seconds, if connects
     are OK within this time, then fine... This only aborts the connect
     phase. [Only works on unix-style/SIGALRM operating systems] */
  CONNECTTIMEOUT(LONG, 78),

  /* Function that will be called to store headers (instead of fwrite). The
   * parameters will use fwrite() syntax, make sure to follow them. */
  HEADERFUNCTION(FUNCTIONPOINT, 79),

  /* Set this to force the HTTP request to get back to GET. Only really usable
     if POST, PUT or a custom request have been used first.
   */
  HTTPGET(LONG, 80),

  /* Set if we should verify the Common name from the peer certificate in ssl
   * handshake, set 1 to check existence, 2 to ensure that it matches the
   * provided hostname. */
  SSL_VERIFYHOST(LONG, 81),

  /* Specify which file name to write all known cookies in after completed
     operation. Set file name to "-" (dash) to make it go to stdout. */
  COOKIEJAR(OBJECTPOINT, 82),

  /* Specify which SSL ciphers to use */
  SSL_CIPHER_LIST(OBJECTPOINT, 83),

  /* Specify which HTTP version to use! This must be set to one of the
     CURL_HTTP_VERSION* enums set below. */
  HTTP_VERSION(LONG, 84),

  /* Specificly switch on or off the FTP engine's use of the EPSV command. By
     default, that one will always be attempted before the more traditional
     PASV command. */
  FTP_USE_EPSV(LONG, 85),

  /* type of the file keeping your SSL-certificate ("DER", "PEM", "ENG") */
  SSLCERTTYPE(OBJECTPOINT, 86),

  /* name of the file keeping your private SSL-key */
  SSLKEY(OBJECTPOINT, 87),

  /* type of the file keeping your private SSL-key ("DER", "PEM", "ENG") */
  SSLKEYTYPE(OBJECTPOINT, 88),

  /* crypto engine for the SSL-sub system */
  SSLENGINE(OBJECTPOINT, 89),

  /* set the crypto engine for the SSL-sub system as default
     the param has no meaning...
   */
  SSLENGINE_DEFAULT(LONG, 90),

  /* Non-zero value means to use the global dns cache */
  DNS_USE_GLOBAL_CACHE(LONG, 91), /* To become OBSOLETE soon */

  /* DNS cache timeout */
  DNS_CACHE_TIMEOUT(LONG, 92),

  /* send linked-list of pre-transfer QUOTE commands (Wesley Laxton)*/
  PREQUOTE(OBJECTPOINT, 93),

  /* set the debug function */
  DEBUGFUNCTION(FUNCTIONPOINT, 94),

  /* set the data for the debug function */
  DEBUGDATA(OBJECTPOINT, 95),

  /* mark this as start of a cookie session */
  COOKIESESSION(LONG, 96),

  /* The CApath directory used to validate the peer certificate
     this option is used only if SSL_VERIFYPEER is true */
  CAPATH(OBJECTPOINT, 97),

  /* Instruct libcurl to use a smaller receive buffer */
  BUFFERSIZE(LONG, 98),

  /* Instruct libcurl to not use any signal/alarm handlers, even when using
     timeouts. This option is useful for multi-threaded applications.
     See libcurl-the-guide for more background information. */
  NOSIGNAL(LONG, 99),

  /* Provide a CURLShare for mutexing non-ts data */
  SHARE(OBJECTPOINT, 100),

  /* indicates type of proxy. accepted values are CURLPROXY_HTTP (default),
     CURLPROXY_SOCKS4 and CURLPROXY_SOCKS5. */
  PROXYTYPE(LONG, 101),

  /* Set the Accept-Encoding string. Use this to tell a server you would like
     the response to be compressed. */
  ENCODING(OBJECTPOINT, 102),

  /* Set pointer to private data */
  PRIVATE(OBJECTPOINT, 103),

  /* Set aliases for HTTP 200 in the HTTP Response header */
  HTTP200ALIASES(OBJECTPOINT, 104),

  /* Continue to send authentication (user+password) when following locations,
     even when hostname changed. This can potentionally send off the name
     and password to whatever host the server decides. */
  UNRESTRICTED_AUTH(LONG, 105),

  /* Specificly switch on or off the FTP engine's use of the EPRT command ( it
     also disables the LPRT attempt). By default, those ones will always be
     attempted before the good old traditional PORT command. */
  FTP_USE_EPRT(LONG, 106),

  /* Set this to a bitmask value to enable the particular authentications
     methods you like. Use this in combination with CURLOPT_USERPWD.
     Note that setting multiple bits may cause extra network round-trips. */
  HTTPAUTH(LONG, 107),

  /* Set the ssl context callback function, currently only for OpenSSL ssl_ctx
     in second argument. The function must be matching the
     curl_ssl_ctx_callback proto. */
  SSL_CTX_FUNCTION(FUNCTIONPOINT, 108),

  /* Set the userdata for the ssl context callback function's third
     argument */
  SSL_CTX_DATA(OBJECTPOINT, 109),

  /* FTP Option that causes missing dirs to be created on the remote server */
  FTP_CREATE_MISSING_DIRS(LONG, 110),

  /* Set this to a bitmask value to enable the particular authentications
     methods you like. Use this in combination with CURLOPT_PROXYUSERPWD.
     Note that setting multiple bits may cause extra network round-trips. */
  PROXYAUTH(LONG, 111),

  /* FTP option that changes the timeout, in seconds, associated with
     getting a response.  This is different from transfer timeout time and
     essentially places a demand on the FTP server to acknowledge commands
     in a timely manner. */
  FTP_RESPONSE_TIMEOUT(LONG , 112),

  /* Set this option to one of the CURL_IPRESOLVE_* defines (see below) to
     tell libcurl to resolve names to those IP versions only. This only has
     affect on systems with support for more than one, i.e IPv4 _and_ IPv6. */
  IPRESOLVE(LONG, 113),

  /* Set this option to limit the size of a file that will be downloaded from
     an HTTP or FTP server.

     Note there is also _LARGE version which adds large file support for
     platforms which have larger off_t sizes.  See MAXFILESIZE_LARGE below. */
  MAXFILESIZE(LONG, 114),
  INFILESIZE_LARGE(OFF_T, 115),
  RESUME_FROM_LARGE(OFF_T, 116),
  MAXFILESIZE_LARGE(OFF_T, 117),
  NETRC_FILE(OBJECTPOINT, 118),
  FTP_SSL(LONG, 119),
  POSTFIELDSIZE_LARGE(OFF_T, 120),
  TCP_NODELAY(LONG, 121),

  /* Collect certificate chain info and allow it to get retrievable with
   CURLINFO_CERTINFO after the transfer is complete. (Unfortunately) only
   working with OpenSSL-powered builds. */
  CERTINFO(LONG, 172);

  private final CurlOptionType type;
  private final int id;

  CurlOption(CurlOptionType type, int id) {
    this.type = type;
    this.id = id;
  }

  public CurlOptionType getType() {
    return type;
  }

  @Override
  public int id() {
    return id;
  }

  public static CurlOption valueOf(int optionId) {
    for (CurlOption curlOption : values()) {
      if(curlOption.id() == optionId) {
        return curlOption;
      }
    }
    throw new IllegalArgumentException("No such CurlOption: " + optionId);
  }
}
