package com.chainofResponsibility;

public interface IRole{
    public void setnextRole(IRole role);
    public void execute(String role);
}