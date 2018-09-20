package com.bjs.knowledge.designmodel.composite;

public class Main {
     public static void main(String[] args){
         JutiCompany root = new JutiCompany("北京总公司");
         root.add(new HRDepart("总公司人力资源部"));
         root.add(new FinanceDepart("总公司财务部"));

         JutiCompany comp = new JutiCompany("上海东华分公司");
         comp.add(new HRDepart("上海东华分公司人力资源部"));
         comp.add(new FinanceDepart("上海东华分公司财务部"));
         root.add(comp);

         JutiCompany comp2 = new JutiCompany("南京办事处");
         comp2.add(new HRDepart("南京办事处人力资源部"));
         comp2.add(new FinanceDepart("南京办事处财务部"));
         root.add(comp2);

         JutiCompany comp3 = new JutiCompany("杭州办事处");
         comp3.add(new HRDepart("杭州办事处人力资源部"));
         comp3.add(new FinanceDepart("杭州办事处财务部"));
         root.add(comp3);

         System.out.println("结构图如下所示：");

         root.display(2);

         root.lineOfDuty();

     }
}
