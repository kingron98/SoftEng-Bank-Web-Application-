package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.BankAccount;
import com.example.business.Customer;
import com.example.exceptions.DaoException;


public class CustomerDao extends Dao {

    public Customer findUserByUsernamePassword(String uname, String pword) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM CUSTOMER WHERE USERID = ? AND PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pword);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	String userId = rs.getString("USERID");
                String password = rs.getString("PASSWORD");
                String customerName = rs.getString("CUSTOMER_NAME");
                String phoneNumber = rs.getString("PHONE_NUMBER");
                String linkedBankCard = rs.getString("LINKEDBANKCARD");
                String email = rs.getString("EMAIL");
                c = new Customer(userId, password, customerName, phoneNumber, linkedBankCard, email);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserByUsernamePassword" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return c;     
    }
    
    public BankAccount getBankAccount(String username) throws DaoException {

    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BankAccount ac = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM BANKACCOUNT WHERE ACCOUNT_ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	String accountId = rs.getString("ACCOUNT_ID");
                double balance = rs.getDouble("BALANCE");
                String accountHolder = rs.getString("ACCOUNT_HOLDER");
                ac = new BankAccount(accountId, balance, accountHolder);
            }
        } catch (SQLException e) {
            throw new DaoException("getBankAccount" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("getBankAccount" + e.getMessage());
            }
        }
        return ac;     // u may be null 
    }
    
    public int updateCustomerProfile(String phoneNumber, String email, String uName) throws DaoException {

    	Connection con = null;
        PreparedStatement ps = null;
        int rs = 0;
        
        try {
            con = this.getConnection();
            
            String query = "UPDATE CUSTOMER SET PHONE_NUMBER = ?, EMAIL = ? WHERE USERID = ?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, phoneNumber);
            ps.setString(2, email);
            ps.setString(3, uName);
            
            rs = ps.executeUpdate();
     
        } catch (SQLException e) {
            throw new DaoException("updateCustomerProfile" + e.getMessage());
        }
        return rs;
    }
    
    public int[] transferFunds(String uNameRecp, double amount, String uName, double custBalance) throws DaoException {

    	Connection con = null;
        PreparedStatement ps = null;
        int[] rs = null;
 
        double newCustBalance = custBalance - amount;
        
        // Recp bank account and balance
        BankAccount r = getBankAccount(uNameRecp);
        double newRecpBalance = r.getBalance() + amount;
        
        try {
            con = this.getConnection();
            
            String query = "UPDATE BANKACCOUNT SET BALANCE = ? WHERE ACCOUNT_ID = ?";
            
            ps = con.prepareStatement(query);
            ps.setDouble(1, newCustBalance);
            ps.setString(2, uName);
            ps.addBatch();
            
            ps = con.prepareStatement(query);
            ps.setDouble(1, newRecpBalance);
            ps.setString(2, uNameRecp);
            ps.addBatch();
            
            rs = ps.executeBatch();
     
        } catch (SQLException e) {
            throw new DaoException("transferFunds" + e.getMessage());
        }
        return rs;
    }
}
