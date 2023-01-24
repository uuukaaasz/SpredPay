package com.example.spredpay;

public class Users {
    public Integer id;
    public String username;
    public String password;
    public Integer pin_code;
    public Float bank;
    public Float crypto;
    public Float spred;

    public Users() {
    }

    public Users(String Username, String Password, Integer Pin_code, Float Bank, Float Crypto,
                     Float Spred) {
        this.username = Username;
        this.password = Password;
        this.pin_code = Pin_code;
        this.bank = Bank;
        this.crypto = Crypto;
        this.spred = Spred;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) { this.password = Password; }

    public Integer getPin_code() {
        return pin_code;
    }

    public void setPin_code(Integer Pin_code) {
        this.pin_code = Pin_code;
    }

    public Float getBank() {
        return bank;
    }

    public void setBank(Float Bank) {
        this.bank = Bank;
    }

    public Float getCrypto() {
        return crypto;
    }

    public void setCrypto(Float Crypto) {
        this.crypto = Crypto;
    }

    public Float getSpred() {
        return spred;
    }

    public void setSpred(Float Spred) {
        this.spred = Spred;
    }

}
