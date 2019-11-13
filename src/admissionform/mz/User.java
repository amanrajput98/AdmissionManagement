/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionform.mz;

/**
 *
 * @author Aman
 */
class User {
    private int rollNo;
    private String name,address;
    
    public User(String name ,int rollNo,String address){
        this.rollNo=rollNo;
        this.name=name;
        this.address=address;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getAddress(){
        return address;
    }
    public String getName(){
        return name;
    }
            
}
