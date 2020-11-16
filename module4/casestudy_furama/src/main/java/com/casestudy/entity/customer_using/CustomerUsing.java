package com.casestudy.entity.customer_using;

public class CustomerUsing {
        String customerId;
        String customerName;
        String contactId;
        String attachServiceName;

        public CustomerUsing(String customerName, String contactId, String attachServiceName) {
            this.customerName = customerName;
            this.contactId = contactId;
            this.attachServiceName = attachServiceName;
        }

        public CustomerUsing(String customerId, String customerName, String contactId, String attachServiceName) {
            this.customerId = customerId;
            this.customerName = customerName;
            this.contactId = contactId;
            this.attachServiceName = attachServiceName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getContactId() {
            return contactId;
        }

        public void setContactId(String contactId) {
            this.contactId = contactId;
        }

        public String getAttachServiceName() {
            return attachServiceName;
        }

        public void setAttachServiceName(String attachServiceName) {
            this.attachServiceName = attachServiceName;
        }
    }

