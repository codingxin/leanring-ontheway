package com.codingzx.设计模式.行为模式.行为模式_责任链模式.案例2;

/**
 * @author codingzx
 * @description 班主任第一步处理
 * @date 2021/9/11 15:04
 */
public class FirstProcess extends AbstractProcess {

    @Override
    public void handleRequest(int LeaveDays) {

        if (LeaveDays <= 2) {
            System.out.println("班主任统一申请 " + LeaveDays + "天");
        } else {
            System.out.println("请假天数太多, 班主任不同意，往上申请");
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("没有领导同意了");
            }

        }


    }


}
