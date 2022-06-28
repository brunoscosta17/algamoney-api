package com.example.algamoney.api.model;

import javax.persistence.Embeddable;

@Embeddable
    public class Address {
        
        private String street;
        private String number;
        private String complement;
        private String district;
        private String zip_code;
        private String city;
        private String state;
        
        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getComplement() {
            return complement;
        }

        public void setComplement(String complement) {
            this.complement = complement;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getZipCode() {
            return zip_code;
        }

        public void setZipCode(String zip_code) {
            this.zip_code = zip_code;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }