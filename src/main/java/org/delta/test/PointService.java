package org.delta.test;

import java.util.ArrayList;
import java.util.List;

public class PointService {

    private List<Point> points;

    private PointFactory pointFactory;

    private PointPrint pointPrint;

    public PointService(PointFactory pointFactory, PointPrint pointPrint) {
        this.points = new ArrayList<>();
        this.pointFactory = pointFactory;
        this.pointPrint = pointPrint;
    }

    public Point createPoint(int a, int b) {
        Point point = this.pointFactory.createPoint(a, b);
        this.points.add(point);

        this.pointPrint.printPoint(point);

        return point;
    }


}
