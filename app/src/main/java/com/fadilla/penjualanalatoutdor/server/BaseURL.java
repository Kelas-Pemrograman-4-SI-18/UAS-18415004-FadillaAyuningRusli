package com.fadilla.penjualanalatoutdor.server;

public class BaseURL {
    public static String baseUrl ="http://192.168.43.69:5050/";

    public static String login = baseUrl + "user/login";
    public static String registrasi = baseUrl + "user/registrasi";

    //barang
    public static String databarang = baseUrl + "barang/databarang" ;

    public static String editdatabarang = baseUrl + "barang/ubah/" ;

    public static String hapusdata = baseUrl + "barang/hapus/" ;

    public static String inputbarang = baseUrl + "barang/input/" ;

}

