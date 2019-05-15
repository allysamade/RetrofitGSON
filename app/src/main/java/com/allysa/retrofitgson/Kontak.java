package com.allysa.retrofitgson;

import com.google.gson.annotations.SerializedName;

public class Kontak {

    @SerializedName("id")
    private String  idContact;

    private String  nama;
    private String  email;

    @SerializedName("nohp")
    private String  phone;

    @SerializedName("alamat")
    private String  addres;

    public Kontak(String nama, String email, String phone, String addres) {
        this.nama = nama;
        this.email = email;
        this.phone = phone;
        this.addres = addres;
    }

    public String getIdContact() {
        return idContact;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddres() {
        return addres;
    }

    public void setIdContact(String idContact) {
        this.idContact = idContact;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
