package xyz.pangosoft.dimsa.auth;

public class JwtConfig {
    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAwBs7Mb/2RaAQMF2MISP4D3o5GmJsqa60uGYyHCG7R87HSlCb\n" +
            "HB6sKFpqk6fMkwF9gpZUvEbhDBZxxCuILz2i3NoyVjMH7pPK4m6F1FLrU5uPlD+o\n" +
            "W85Hh+QqqGceLk4iPF54eF3FntQiuI2HZLRQcoxhWj7zetPiPvKkJnUpfArf2qe6\n" +
            "Toq7z7MNYBu5Q/jZYZ4qsZXlOIUfNk5d4VumYWxVSAh6jBGFtJHSWr2BF2Q2+MYO\n" +
            "v2ypC4fm3BQfil/y2xkjZXsXLwCDsKVfbCVouOIpIJzcoJUywaKA8fuBIsR0HRvZ\n" +
            "cOsrmZIYJjj9DILITh5BiDVmfY+5BKJLCeP5+wIDAQABAoIBADwnys93VvzSdH9Q\n" +
            "q9Ks2r6t/Tef3nr79CdSCRr6DRUdURaaSxfxGuO//GOkRdE6xDyiKoKSh2IrnRBa\n" +
            "uVhhqqARy3VmoXM54GwrQ8kK9hnGOp2nmWa2H3wUHK+DKtZBLUNOKdc3NezYbM7x\n" +
            "spX8SLy17L4/vCqYMt6XSIOqaIUor2zYO3Gj2duiLGqhSW+ZEOqezl7fWYpY/aVo\n" +
            "fXiL8HmOPoCz6nML8td9gp5/hKeqcdjY6Q20QAlAeULPhfYfHVnf01dtJKHcKhqa\n" +
            "0dO2h4pkRQZSHTPRpQYcu0buPRrUHiVzI8fU2MjziX5K5qSUBdDg77VEbAshwBrP\n" +
            "FisUmQECgYEA6/eb9SfqdzP21xkErBqNDgVx5SmmhD/9sXYVTxPL7KsFcUEbLbiH\n" +
            "Me6fHrA/mxk/hg5bWOUx1/Dp1ZhOLyVDwsgEUsyIyMp9CdJbI1XTaZxVIb+fRMt8\n" +
            "nkqGKlhXCPTpy4YvPWQamH3uu72IwnOfqyh1qDIfCnZsxUZvhcdj0TsCgYEA0Gpf\n" +
            "a4LlSGHNubkcI+EQLQOCG7IghdlWGt2pKruUpw6crgBCqSAA6RL18Z0kd6d7eB2z\n" +
            "wwSNOd7PCR2Ks2yn+5HhrfPtyi0eAnQfBJgmS6SfzDFfv21SwAdq9a2biY4dzwQi\n" +
            "W+T9E19YYllQo2OJysed9qRzM+QJPUj/sCal7kECgYEA16KVYPmzKG/SWUrBnE0/\n" +
            "LdsH9DWVuDGKMswIORWMO6El/hNTNPr2gUjhHHhQB/qQtH8WNyxr2jyMU+c1O5xA\n" +
            "ShXi7Y+ASI3SqlETfD0IT/DPU2H7uDCEl1rfNH86OjMmHBlpvh5mt4gNzH8uJRTo\n" +
            "is8UhjoXZ8ZFLBpr+8L0ktUCgYAFB+xRvhEm1CWRLCS/wPkQ/Rqw7HXYhUyMzXj9\n" +
            "7RVDixjBIoR5bKpY9fo14OM2eDaEycLDHGMEWJqKz8m/VwofCoB2IING9BvbV05A\n" +
            "YCPcg5bP6Qk0p8DtncA5Of2dLm8Nxj3GFhr90rlhdmJ57zcuS+9GOuYFBKYscoyp\n" +
            "heVPgQKBgQDrQKNVqiWVHjsvs2SvRIVAaajODd7sX603p8S1yya5y2N3DgGNIxc0\n" +
            "Y28apsrQd9yKKWCxd9f01vdS8ybCf/GkVHfo1rp3e7bjbW3gGWT+XVR5tTtMalbc\n" +
            "et731d8U0NFihu9iSvEZo+zDGkgC6pYeuXo+qZa0LpAim1VfB6hrxQ==\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwBs7Mb/2RaAQMF2MISP4\n" +
            "D3o5GmJsqa60uGYyHCG7R87HSlCbHB6sKFpqk6fMkwF9gpZUvEbhDBZxxCuILz2i\n" +
            "3NoyVjMH7pPK4m6F1FLrU5uPlD+oW85Hh+QqqGceLk4iPF54eF3FntQiuI2HZLRQ\n" +
            "coxhWj7zetPiPvKkJnUpfArf2qe6Toq7z7MNYBu5Q/jZYZ4qsZXlOIUfNk5d4Vum\n" +
            "YWxVSAh6jBGFtJHSWr2BF2Q2+MYOv2ypC4fm3BQfil/y2xkjZXsXLwCDsKVfbCVo\n" +
            "uOIpIJzcoJUywaKA8fuBIsR0HRvZcOsrmZIYJjj9DILITh5BiDVmfY+5BKJLCeP5\n" +
            "+wIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
