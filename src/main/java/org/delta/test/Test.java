package org.delta.test;

public class Test {

    public static void main(String[] args) {
        System.out.println("test");

        PointFactory pointFactory = new PointFactory();
        PointPrint pointPrint = new PointPrint();

        PointService pointService = new PointService(pointFactory, pointPrint);

        pointService.createPoint(10, 10);
    }

}
